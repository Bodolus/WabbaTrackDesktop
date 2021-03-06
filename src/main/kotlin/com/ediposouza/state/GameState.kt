package com.ediposouza.state

import com.ediposouza.data.TESLTrackerData
import com.ediposouza.executor.GameExecutor
import com.ediposouza.executor.GameExecutor.processCardDrawProphecy
import com.ediposouza.model.*
import com.ediposouza.ui.DeckTrackerWidget
import com.ediposouza.util.Logger
import com.ediposouza.util.Mixpanel
import com.ediposouza.util.ScreenFuncs
import javafx.application.Platform
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.awt.image.BufferedImage
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by ediposouza on 24/03/17.
 */
object GameState : StateHandler.TESLState {

    const val GAME_RECOGNIZER_SPS = 1    //Screenshot Per Second
    const val GAME_RECOGNIZER_DRAW_SPS = 2    //Screenshot Per Second
    const val GAME_RECOGNIZER_DRAW_FIRST_SPS = 3    //Screenshot Per Second
    const val GAME_RECOGNIZER_CARD_DELAY = 4    //Screenshot Per Second

    const val playerGoFirstLock = "lock"
    const val playerDeckClassLock = "lock"
    const val playerRankLock = "lock"
    const val opponentDeckClassLock = "lock"
    const val opponentRankLock = "lock"
    const val cardDrawLock = "lock"
    const val cardDrawProphecyLock = "lock"
    const val cardGenerateLock = "lock"
    const val endMatchLock = "lock"

    private val deckTracker by lazy { DeckTrackerWidget() }
    private var deckCardsSlot: List<CardSlot> = listOf()

    var threadRunning: Boolean = false
    var firstCardDraws: Triple<String?, String?, String?>? = null
    var firstCardDrawsWithoutMulligan: Triple<String?, String?, String?>? = null
    var firstCardDrawsTracked: Boolean = false
    var playerGoFirst: Boolean? = null
    var playerDeckClass: DeckClass? = null
    var playerRank: Int? = null
    var playerRankLegend: Boolean? = null
    var opponentDeckClass: DeckClass? = null
    var opponentRank: Int? = null
    var lastCardDraw: Card? = null
    var matchMode: MatchMode? = null
    var cardGenerated: Card? = null
    var cardGeneratedDetected: Boolean? = null
    var shouldShowDeckTracker: Boolean = true

    override fun onResume() {
        showDeckTracker()
        Logger.i("GameState onResume")
        threadRunning = true
        launch(CommonPool) {
            runStateThread()
        }
    }

    override fun onPause() {
        hideDeckTracker()
        Logger.i("GameState onPause")
        threadRunning = false
    }

    override fun resetState() {
        firstCardDraws = null
        firstCardDrawsWithoutMulligan = null
        firstCardDrawsTracked = false
        playerGoFirst = null
        playerDeckClass = null
        playerRank = null
        playerRankLegend = null
        opponentDeckClass = null
        opponentRank = null
        lastCardDraw = null
        matchMode = null
        cardGenerated = null
        cardGeneratedDetected = null
        deckTracker.resetDraws()
    }

    suspend fun runStateThread() {
        val detectFirstDraws = launch(CommonPool) {
            while (!firstCardDrawsTracked) {
                ScreenFuncs.takeScreenshot()?.apply {
                    processCardFirstDraws(this)
                    processCardDraw(this)
                }
                delay(1000L / GAME_RECOGNIZER_DRAW_FIRST_SPS)
            }
        }
        detectFirstDraws.join()
        launch(CommonPool) {
            while (threadRunning) {
                ScreenFuncs.takeScreenshot()?.apply {
                    processCardDraw(this)
                    processCardDrawProphecy(this)
                    processCardGenerate(this)
                }
                delay(1000L / GAME_RECOGNIZER_DRAW_SPS)
            }
        }
        launch(CommonPool) {
            while (threadRunning) {
                ScreenFuncs.takeScreenshot()?.apply {
                    if (playerGoFirst == null) {
                        processPlayerGoFirst(this)
                    }
                    if (playerDeckClass == null) {
                        processPlayerDeck(this)
                    }
                    if (playerRank == null) {
                        processPlayerRank(this)
                    }
                    if (opponentDeckClass == null) {
                        processOpponentDeck(this)
                    }
                    if (opponentRank == null) {
                        processOpponentRank(this)
                    }
                    processEndMatch(this)
                }
                delay(1000L / GAME_RECOGNIZER_SPS)
            }
        }
    }

    fun setDeckCardsSlot(cardsSlot: List<CardSlot>, deckName: String? = null) {
        deckCardsSlot = cardsSlot
        Platform.runLater {
            deckTracker.setDeckCardsSlot(cardsSlot, deckName)
        }
    }

    private fun processCardFirstDraws(screenshot: BufferedImage) {
        launch(CommonPool) {
            if (!firstCardDrawsTracked) {
                GameExecutor.processFirstCardDraws(screenshot).run {
                    if (firstCardDrawsWithoutMulligan != this) {
                        firstCardDraws = this
                    }
                    if (firstCardDrawsWithoutMulligan == null) {
                        firstCardDrawsWithoutMulligan = this
                    }
                }
            }
        }
    }

    private fun processPlayerGoFirst(screenshot: BufferedImage) {
        launch(CommonPool) {
            GameExecutor.processPlayerGoFirst(screenshot)?.run {
                synchronized(playerGoFirstLock) {
                    if (playerGoFirst == null) {
                        playerGoFirst = this
                        Logger.i("--PlayerGoFirst!".takeIf { this } ?: "--PlayerGoSecond!")
                    }
                }
            }
        }
    }

    private fun processPlayerDeck(screenshot: BufferedImage) {
        launch(CommonPool) {
            GameExecutor.processPlayerDeckClass(screenshot)?.run {
                synchronized(playerDeckClassLock) {
                    if (playerDeckClass == null) {
                        playerDeckClass = this
                        Logger.i("--PlayerDeckClass: $this!")
                    }
                }
            }
        }
    }

    private fun processPlayerRank(screenshot: BufferedImage) {
        launch(CommonPool) {
            GameExecutor.processPlayerRank(screenshot)?.run {
                synchronized(playerRankLock) {
                    if (playerRank == null) {
                        playerRank = this
                        playerRankLegend = playerRank == 0
                        Logger.i("--PlayerRank: $this!")
                        matchMode = MatchMode.RANKED
                    }
                }
            }
        }
    }

    private fun processOpponentDeck(screenshot: BufferedImage) {
        launch(CommonPool) {
            GameExecutor.processOpponentDeckClass(screenshot)?.run {
                synchronized(opponentDeckClassLock) {
                    if (opponentDeckClass == null) {
                        opponentDeckClass = this
                        Logger.i("--OpponentDeckClass: $this!")
                    }
                }
            }
        }
    }

    private fun processOpponentRank(screenshot: BufferedImage) {
        launch(CommonPool) {
            GameExecutor.processOpponentRank(screenshot)?.run {
                synchronized(opponentRankLock) {
                    if (opponentRank == null) {
                        opponentRank = this
                        Logger.i("--OpponentRank: $this!")
                    }
                }
            }
        }
    }

    private fun processCardGenerate(screenshot: BufferedImage) {
        launch(CommonPool) {
            GameExecutor.processCardGenerated(screenshot)?.run {
                synchronized(cardGenerateLock) {
                    if (cardGeneratedDetected != this) {
                        cardGeneratedDetected = this
                        Logger.i("--Card generated!")
                        launch(CommonPool) {
                            delay(3000L)
                            cardGeneratedDetected = null
                        }
                    }
                }
            }
        }
    }

    private fun processCardDraw(screenshot: BufferedImage) {
        launch(CommonPool) {
            GameExecutor.processCardDrawProphecy(screenshot)?.run {
                synchronized(cardDrawProphecyLock) {
                    if (lastCardDraw != this) {
                        lastCardDraw = this
                        deckTracker.trackCardDraw(this)
                        Logger.i("--$name prophecy draw!")
                        launch(CommonPool) {
                            delay(1000L * GAME_RECOGNIZER_CARD_DELAY)
                            lastCardDraw = null
                        }
                    }
                }
            }
            GameExecutor.processCardDraw(screenshot)?.run {
                synchronized(cardDrawLock) {
                    if (lastCardDraw != this) {
                        lastCardDraw = this
                        if (cardGeneratedDetected ?: false) {
                            cardGenerated = this
                            Logger.i("--$name generated!")
                        } else {
                            deckTracker.trackCardDraw(this)
                            Logger.i("--$name draw!")
                        }
                        launch(CommonPool) {
                            delay(1000L * GAME_RECOGNIZER_CARD_DELAY)
                            lastCardDraw = null
                            if (cardGeneratedDetected ?: false) {
                                cardGeneratedDetected = null
                            }
                        }
                        firstCardDraws?.apply {
                            Logger.d("Tracking first cards draw: $firstCardDraws")
                            TESLTrackerData.getCard(first)?.apply { deckTracker.trackCardDraw(this) }
                            TESLTrackerData.getCard(second)?.apply { deckTracker.trackCardDraw(this) }
                            TESLTrackerData.getCard(third)?.apply { deckTracker.trackCardDraw(this) }
                            firstCardDraws = null
                            firstCardDrawsTracked = true
                        }
                    }
                }
            }
        }
    }

    private fun processEndMatch(screenshot: BufferedImage) {
        launch(CommonPool) {
            GameExecutor.processMatchEnd(screenshot)?.run {
                synchronized(endMatchLock) {
                    if (playerGoFirst != null) {
                        val win = this
                        Logger.i("--Player Win!".takeIf { win } ?: "--Player Lose!")
                        playerDeckClass?.let { playerCls ->
                            opponentDeckClass?.let { opponentCls ->
                                val result = "Win".takeIf { win } ?: "Loss"
                                Logger.d("${playerCls.name} vs ${opponentCls.name} - $result")
                                saveMatch(win)
                                matchMode?.let {
                                    Mixpanel.postEventGameResult(playerCls, opponentCls, it, result)
                                }
                            }
                        }
                        resetState()
                        threadRunning = false
                    }
                }
            }
        }
    }

    fun isDeckTrackerVisible() = deckTracker.isVisible

    fun showDeckTracker(forceShow: Boolean = false) {
        if (forceShow) {
            deckTracker.resetZoom()
        }
        if (forceShow || (deckCardsSlot.isNotEmpty() && shouldShowDeckTracker)) {
            deckTracker.isVisible = true
        }
    }

    fun hideDeckTracker() {
        deckTracker.isVisible = false
    }

    fun trackCardDraw(card: Card) {
        deckTracker.trackCardDraw(card)
    }

    fun saveMatch(win: Boolean) {
        if (playerGoFirst != null && playerDeckClass != null && opponentDeckClass != null &&
                matchMode != null && matchMode != MatchMode.PRATICE) {
            val newUuid = LocalDateTime.now().withNano(0).toString()
            val currentSeason = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy_MM"))
            val playerDeck = MatchDeck(deckTracker.deckName ?: "", playerDeckClass!!, DeckType.OTHER)
            val opponentDeck = MatchDeck("", opponentDeckClass!!, DeckType.OTHER)
            val mode = playerRank?.let { MatchMode.RANKED } ?: matchMode!!
            TESLTrackerData.saveMatch(Match(newUuid, playerGoFirst!!, playerDeck, opponentDeck, mode,
                    currentSeason, playerRank ?: 0, opponentRank ?: 0, playerRankLegend ?: false, win)) {
                Logger.i("Match saved!")
            }
        }
    }

}
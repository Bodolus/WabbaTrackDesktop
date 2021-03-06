package com.ediposouza

import com.ediposouza.extensions.*
import com.ediposouza.util.ImageFuncs
import com.ediposouza.util.Logger
import com.ediposouza.util.Recognizer
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * Created by ediposouza on 06/03/17.
 */
object CalcPHashs {

    val CALC_CARDS_HASH = false

    val CROP_FOLDER_ARENA = "Arena"
    val CROP_FOLDER_CARDS = "Cards"
    val CROP_FOLDER_DECK = "Deck"
    val CROP_FOLDER_GAME = "Game"
    val CROP_FOLDER_SCREENS = "Screens"

    @JvmStatic fun main(args: Array<String>) {
        Logger.d("--Cards--")
        if (CALC_CARDS_HASH) {
            getDHashFolderFiles("/Cards", CROP_FOLDER_CARDS, BufferedImage::getCardCrop)
        }
        Logger.d("--Screens--")
        getDHashFile("/Screens/Main.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenMainCrop)
        getDHashFile("/Screens/MainModeCasual.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenMainModeCrop)
        getDHashFile("/Screens/MainModeRanked.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenMainModeCrop)
        getDHashFile("/Screens/MainModePratice.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenMainModeCrop)
        getDHashFile("/Screens/MainModePratice2.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenMainModeCrop)
        getDHashFile("/Screens/Game.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenGameCrop)
        getDHashFile("/Screens/ArenaClasses.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenArenaClassesCrop)
        getDHashFile("/Screens/ArenaPicks.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenArenaPicksCrop)
        getDHashFile("/Screens/ArenaDash.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenArenaDashboardCrop)
        getDHashFile("/Screens/DeckBuilder.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenDeckBuilderCrop)
        getDHashFile("/Screens/DeckBuilderEmpty.png", CROP_FOLDER_SCREENS, BufferedImage::getScreenDeckBuilderEmptyCrop)
        getDHashFile("/Deck/CollectionEmpty.png", CROP_FOLDER_DECK) { it.getDeckBuilderFirstLineCardCrop(1) }
        getDHashFile("/Deck/DeckBuilderNoneLeft.png", CROP_FOLDER_DECK) { it.getDeckBuilderNoneLeftCardCrop(2) }

        Logger.d("--Arena Class Select--")
        getDHashFolderFiles("/ArenaClass", CROP_FOLDER_ARENA, BufferedImage::getArenaPickClassCrop)

        Logger.d("--Game--")
        getDHashFile("/Game/PlayFirst.png", CROP_FOLDER_GAME, BufferedImage::getGamePlayerFirstCrop)
        getDHashFile("/Game/PlaySecond.png", CROP_FOLDER_GAME, BufferedImage::getGamePlayerSecondCrop)
        getDHashFile("/Game/Win.png", CROP_FOLDER_GAME, BufferedImage::getGameWinCrop)
        getDHashFile("/Game/Win2.png", CROP_FOLDER_GAME, BufferedImage::getGameWin2Crop)
        getDHashFile("/Game/Loss.png", CROP_FOLDER_GAME, BufferedImage::getGameLossCrop)
        getDHashFile("/Game/Loss2.png", CROP_FOLDER_GAME, BufferedImage::getGameLoss2Crop)
        getDHashFile("/Game/CardGenerated.png", CROP_FOLDER_GAME, BufferedImage::getGameCardGenerateCrop)
        getDHashFolderFiles("/Game/PlayerRank", CROP_FOLDER_GAME, BufferedImage::getGameOpponentRankCrop)
        getDHashFolderFiles("/Game/PlayerClass", CROP_FOLDER_GAME, BufferedImage::getGamePlayerClassCrop)
        getDHashFolderFiles("/Game/OpponentClass", CROP_FOLDER_GAME, BufferedImage::getGameOpponentClassCrop)
    }

    fun getDHashFile(relativePath: String, cropFolder: String = "", cropFun: (BufferedImage) -> BufferedImage?) {
        val file = File(TESLTracker::class.java.getResource(relativePath).toURI())
        calcImageFileDHash(file, cropFolder, cropFun)
    }

    fun getDHashFolderFiles(relativePath: String, cropFolder: String = "", cropFun: (BufferedImage) -> BufferedImage?) {
        val folder = File(TESLTracker::class.java.getResource(relativePath).toURI())
        getDHashFolderFiles(folder, folder.path, cropFolder, cropFun)
    }

    private fun getDHashFolderFiles(folder: File, path: String, cropFolder: String = "", cropFun: (BufferedImage) -> BufferedImage?) {
        folder.listFiles().forEach {
            if (it.isDirectory) {
                getDHashFolderFiles(it, path, cropFolder, cropFun)
            } else {
                calcImageFileDHash(it, cropFolder, cropFun)
            }
        }
    }

    private fun calcImageFileDHash(file: File, cropFolder: String, cropFun: (BufferedImage) -> BufferedImage?) {
        ImageFuncs.getFileImage(file)?.apply {
            cropFun(this)?.apply {
                calcDHash(this, file.name, cropFolder)
            }
        }
    }

    private fun calcDHash(image: BufferedImage, imageName: String, cropFolder: String) {
        var cropFolderPath = File(File(TESLTracker.jarPath).parentFile, "data/crops").path
        if (cropFolder.isNotEmpty()) {
            cropFolderPath += "/$cropFolder"
        }
        File(cropFolderPath).apply {
            if (!exists()) {
                mkdirs()
            }
        }
        val imageShortName = imageName.substring(0, imageName.indexOf("."))
        Logger.d("\"${Recognizer.calcPHash(image)}\" to \"$imageShortName\",")
        ImageIO.write(image, "png", File("$cropFolderPath/$imageShortName.png"))
    }

}
package com.ediposouza

import com.ediposouza.data.DHash
import com.ediposouza.extensions.*
import com.ediposouza.util.BaseRecognizeTests
import com.ediposouza.util.ReferenceConfig1366x768
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import java.awt.image.BufferedImage

/**
 * Created by ediposouza on 06/03/17.
 */
class ScreenClassRecognizeTests : BaseRecognizeTests() {

    @Before
    fun setUp() {
        TESLTracker.referenceConfig = ReferenceConfig1366x768()
    }

    @Test
    fun testScreenMain() {
        recognizeScreen("ScreenMain.png", DHash.SCREEN_MAIN, BufferedImage::getScreenMainCrop)
    }

    @Test
    fun testScreenMainMode() {
        recognizeScreen("ScreenMainModeCasual.png", DHash.SCREEN_MAIN_MODE_CASUAL, BufferedImage::getScreenMainModeCrop)
        recognizeScreen("ScreenMainModeRanked.png", DHash.SCREEN_MAIN_MODE_RANKED, BufferedImage::getScreenMainModeCrop)
        recognizeScreen("ScreenMainModePratice.png", DHash.SCREEN_MAIN_MODE_PRATICE, BufferedImage::getScreenMainModeCrop)
    }

    @Test
    fun testScreenGame() {
        recognizeScreen("ScreenGame.png", DHash.SCREEN_GAME, BufferedImage::getScreenGameCrop)
        recognizeScreen("ScreenGame2.png", null, BufferedImage::getScreenGameCrop)
    }

    @Test
    fun testScreenArenaClasses() {
        recognizeScreen("ScreenArenaClasses.png", DHash.SCREEN_ARENA_CLASSES, BufferedImage::getScreenArenaClassesCrop)
    }

    @Test
    fun testArenaPickClass() {
        recognizeArenaPickClass("ArenaClass/PickArcher.png", "Archer")
        recognizeArenaPickClass("ArenaClass/PickAssassin.png", "Assassin")
        recognizeArenaPickClass("ArenaClass/PickBattlemage.png", "Battlemage")
        recognizeArenaPickClass("ArenaClass/PickCrusader.png", "Crusader")
        recognizeArenaPickClass("ArenaClass/PickMage.png", "Mage")
        recognizeArenaPickClass("ArenaClass/PickMonk.png", "Monk")
        recognizeArenaPickClass("ArenaClass/PickScout.png", "Scout")
        recognizeArenaPickClass("ArenaClass/PickSorcerer.png", "Sorcerer")
        recognizeArenaPickClass("ArenaClass/PickSpellsword.png", "Spellsword")
        recognizeArenaPickClass("ArenaClass/PickWarrior.png", "Warrior")
    }

    @Test
    fun testScreenArenaPickFalse() {
        recognizePickScreen("ArenaPick/ArenaPick.png", null, { it })
    }

    @Test
    fun testScreenArenaPicks() {
        recognizePickScreen("ArenaPick/ArenaPick01.png", DHash.SCREEN_ARENA_PICK_01, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick02.png", DHash.SCREEN_ARENA_PICK_02, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick03.png", DHash.SCREEN_ARENA_PICK_03, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick04.png", DHash.SCREEN_ARENA_PICK_04, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick05.png", DHash.SCREEN_ARENA_PICK_05, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick06.png", DHash.SCREEN_ARENA_PICK_06, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick07.png", DHash.SCREEN_ARENA_PICK_07, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick08.png", DHash.SCREEN_ARENA_PICK_08, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick09.png", DHash.SCREEN_ARENA_PICK_09, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick10.png", DHash.SCREEN_ARENA_PICK_10, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick11.png", DHash.SCREEN_ARENA_PICK_11, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick12.png", DHash.SCREEN_ARENA_PICK_12, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick13.png", DHash.SCREEN_ARENA_PICK_13, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick14.png", DHash.SCREEN_ARENA_PICK_14, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick15.png", DHash.SCREEN_ARENA_PICK_15, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick16.png", DHash.SCREEN_ARENA_PICK_16, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick17.png", DHash.SCREEN_ARENA_PICK_17, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick18.png", DHash.SCREEN_ARENA_PICK_18, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick19.png", DHash.SCREEN_ARENA_PICK_19, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick20.png", DHash.SCREEN_ARENA_PICK_20, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick21.png", DHash.SCREEN_ARENA_PICK_21, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick22.png", DHash.SCREEN_ARENA_PICK_22, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick23.png", DHash.SCREEN_ARENA_PICK_23, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick24.png", DHash.SCREEN_ARENA_PICK_24, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick25.png", DHash.SCREEN_ARENA_PICK_25, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick26.png", DHash.SCREEN_ARENA_PICK_26, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick27.png", DHash.SCREEN_ARENA_PICK_27, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick28.png", DHash.SCREEN_ARENA_PICK_28, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick29.png", DHash.SCREEN_ARENA_PICK_29, BufferedImage::getScreenArenaPickNumberCrop)
        recognizePickScreen("ArenaPick/ArenaPick30.png", DHash.SCREEN_ARENA_PICK_30, BufferedImage::getScreenArenaPickNumberCrop)
    }

    @Test
    fun testScreenArenaDash() {
        recognizeScreen("ScreenArenaDash.png", DHash.SCREEN_ARENA_DASHBOARD, BufferedImage::getScreenArenaDashboardCrop)
    }

    private fun recognizeScreen(testFileName: String, screen: String?, cropFun: (BufferedImage) -> BufferedImage?) {
        cropFun(getFileImage(testFileName))?.apply {
            assertThat(recognizeImage(this, DHash.SCREENS_LIST)).isEqualTo(screen)
        }
    }

    private fun recognizePickScreen(testFileName: String, screen: String?, cropFun: (BufferedImage) -> BufferedImage?) {
        cropFun(getFileImage(testFileName))?.apply {
            assertThat(recognizeImage(this, DHash.SCREENS_PICK_LIST)).isEqualTo(screen)
        }
    }

    private fun recognizeArenaPickClass(testFileName: String, cls: String) {
        val croppedImage = getFileImage(testFileName).getArenaPickClassCrop()
        croppedImage.saveCroppedImage()
        assertThat(recognizeImage(croppedImage, DHash.CLASS_PICK_LIST)).isEqualTo(cls)
    }

}
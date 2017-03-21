package com.ediposouza

import com.ediposouza.data.DHashCards
import com.ediposouza.extensions.getArenaCardCrop
import com.ediposouza.util.images.ReferenceConfig1024x768
import com.ediposouza.util.images.ReferenceConfig1366x768
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by ediposouza on 06/03/17.
 */
class ArenaCardPickRecognizeTests : BaseRecognizeTests() {

    @Before
    fun setUp() {
        App.referenceConfig = ReferenceConfig1366x768()
    }

    @Test
    fun testArenaPick1024x768() {
        recognizeArenaPick("Pick1024x768.png", "gardenerofswords", "elusiveschemer", "improvisedweapon")
    }

    @Test
    fun testArenaPick1280x768() {
        recognizeArenaPick("Pick1280x768.png", "gardenerofswords", "elusiveschemer", "improvisedweapon")
    }

    @Test
    fun testArenaPick1360x768() {
        recognizeArenaPick("Pick1360x768.png", "fharundefender", "treeminder", "execute")
    }

    @Test
    fun testArenaPick1366x768() {
        recognizeArenaPick("Pick1366x768.png", "fifthlegiontrainer", "septimguardsman", "snowwolf")
    }

    @Test
    fun testArenaPick1024x768WithAlternativeReferenceConfig() {
        App.referenceConfig = ReferenceConfig1024x768()
        recognizeArenaPick("Pick1024x768.png", "gardenerofswords", "elusiveschemer", "improvisedweapon")
    }

    @Test
    fun testArenaPick1280x768WithAlternativeReferenceConfig() {
        App.referenceConfig = ReferenceConfig1024x768()
        recognizeArenaPick("Pick1280x768.png", "gardenerofswords", "elusiveschemer", "improvisedweapon")
    }

    @Test
    fun testArenaPick1360x768WithAlternativeReferenceConfig() {
        App.referenceConfig = ReferenceConfig1024x768()
        recognizeArenaPick("Pick1360x768.png", "fharundefender", "treeminder", "execute")
    }

    @Test
    fun testArenaPick1366x768WithAlternativeReferenceConfig() {
        App.referenceConfig = ReferenceConfig1024x768()
        recognizeArenaPick("Pick1366x768.png", "fifthlegiontrainer", "septimguardsman", "snowwolf")
    }

    private fun recognizeArenaPick(testFileName: String, card1: String, card2: String, card3: String) {
        val croppedImage1 = getFileImage(testFileName).getArenaCardCrop(1)
        assertThat(recognizeImage(croppedImage1, DHashCards.LIST)).isEqualTo(card1)
        val croppedImage2 = getFileImage(testFileName).getArenaCardCrop(2)
        assertThat(recognizeImage(croppedImage2, DHashCards.LIST)).isEqualTo(card2)
        val croppedImage3 = getFileImage(testFileName).getArenaCardCrop(3)
        assertThat(recognizeImage(croppedImage3, DHashCards.LIST)).isEqualTo(card3)
    }

}
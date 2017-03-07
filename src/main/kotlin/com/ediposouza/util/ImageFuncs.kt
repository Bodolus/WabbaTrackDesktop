package com.ediposouza.util

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.color.ColorSpace
import java.awt.image.BufferedImage
import java.awt.image.ColorConvertOp
import javax.imageio.ImageIO

/**
 * Created by ediposouza on 06/03/17.
 */
object ImageFuncs {

    const val ARENA_PICK_CARD_HEIGHT = 155
    const val ARENA_PICK_CARD_WIDTH = 118
    const val ARENA_PICK_CARD_START_Y = 152
    const val ARENA_PICK_CARD_FIRST_X = 284
    const val ARENA_PICK_CARD_SECOND_X = 513
    const val ARENA_PICK_CARD_THIRD_X = 740

    const val FULL_CARD_HEIGHT = 275
    const val FULL_CARD_WIDTH = 212
    const val FULL_CARD_START_X = 80
    const val FULL_CARD_START_Y = 100

    fun getCardImage(fileName: String): BufferedImage? {
        try {
            val image = ImageIO.read(javaClass.getResource("/Cards/$fileName"))
            return image.getSubimage(FULL_CARD_START_X, FULL_CARD_START_Y, FULL_CARD_WIDTH, FULL_CARD_HEIGHT)
        } catch (e: Exception) {
            Logger.e("Error loading $fileName - ${e.message}")
            return null
        }
    }

    fun getScaledImage(image: BufferedImage): BufferedImage {
        val tmp = image.getScaledInstance(Recognition.PHASH_SIZE, Recognition.PHASH_SIZE, BufferedImage.SCALE_FAST)
        val scaledIamge = BufferedImage(Recognition.PHASH_SIZE, Recognition.PHASH_SIZE, BufferedImage.TYPE_INT_RGB)
        scaledIamge.graphics.drawImage(tmp, 0, 0, null)
        return scaledIamge
    }

    fun toGrayscale(image: BufferedImage): BufferedImage {
        val cs = ColorSpace.getInstance(ColorSpace.CS_GRAY)
        return ColorConvertOp(cs, null).filter(image, null)
    }

    fun getArenaPickImage(image: BufferedImage, position: Int): BufferedImage {
        val cardX = when(position) {
            1 -> ARENA_PICK_CARD_FIRST_X
            2 -> ARENA_PICK_CARD_SECOND_X
            else -> ARENA_PICK_CARD_THIRD_X
        }
        return image.getSubimage(cardX, ARENA_PICK_CARD_START_Y, ARENA_PICK_CARD_WIDTH, ARENA_PICK_CARD_HEIGHT)
    }

    fun takeScreenshot(): BufferedImage? {
        try {
            val screenRect = Rectangle(Toolkit.getDefaultToolkit().screenSize)
            return Robot().createScreenCapture(screenRect)
        } catch (e: Exception) {
            Logger.e(e)
            return null
        }
    }

}
package com.ediposouza.data

import com.ediposouza.TESLTracker
import com.ediposouza.util.ReferenceConfig1366x768

/**
 * Created by Edipo on 18/03/2017.
 */
object DHash {

    val SCREEN_MAIN = "Main"
    val SCREEN_MAIN_MODE_CASUAL = "Casual"
    val SCREEN_MAIN_MODE_RANKED = "Ranked"
    val SCREEN_MAIN_MODE_PRATICE = "Pratice"
    val SCREEN_GAME = "Game"
    val SCREEN_GAME_CARD_GENERATED = "CardGenerated"

    val SCREEN_ARENA_CLASSES = "ArenaClasses"
    val SCREEN_ARENA_PICKS = "ArenaPicks"
    val SCREEN_ARENA_PICK_01 = "ArenaPick01"
    val SCREEN_ARENA_PICK_02 = "ArenaPick02"
    val SCREEN_ARENA_PICK_03 = "ArenaPick03"
    val SCREEN_ARENA_PICK_04 = "ArenaPick04"
    val SCREEN_ARENA_PICK_05 = "ArenaPick05"
    val SCREEN_ARENA_PICK_06 = "ArenaPick06"
    val SCREEN_ARENA_PICK_07 = "ArenaPick07"
    val SCREEN_ARENA_PICK_08 = "ArenaPick08"
    val SCREEN_ARENA_PICK_09 = "ArenaPick09"
    val SCREEN_ARENA_PICK_10 = "ArenaPick10"
    val SCREEN_ARENA_PICK_11 = "ArenaPick11"
    val SCREEN_ARENA_PICK_12 = "ArenaPick12"
    val SCREEN_ARENA_PICK_13 = "ArenaPick13"
    val SCREEN_ARENA_PICK_14 = "ArenaPick14"
    val SCREEN_ARENA_PICK_15 = "ArenaPick15"
    val SCREEN_ARENA_PICK_16 = "ArenaPick16"
    val SCREEN_ARENA_PICK_17 = "ArenaPick17"
    val SCREEN_ARENA_PICK_18 = "ArenaPick18"
    val SCREEN_ARENA_PICK_19 = "ArenaPick19"
    val SCREEN_ARENA_PICK_20 = "ArenaPick20"
    val SCREEN_ARENA_PICK_21 = "ArenaPick21"
    val SCREEN_ARENA_PICK_22 = "ArenaPick22"
    val SCREEN_ARENA_PICK_23 = "ArenaPick23"
    val SCREEN_ARENA_PICK_24 = "ArenaPick24"
    val SCREEN_ARENA_PICK_25 = "ArenaPick25"
    val SCREEN_ARENA_PICK_26 = "ArenaPick26"
    val SCREEN_ARENA_PICK_27 = "ArenaPick27"
    val SCREEN_ARENA_PICK_28 = "ArenaPick28"
    val SCREEN_ARENA_PICK_29 = "ArenaPick29"
    val SCREEN_ARENA_PICK_30 = "ArenaPick30"
    val SCREEN_ARENA_DASHBOARD = "ArenaDashboard"

    val PLAYER_GAME_FIRST = "PlayFirst"
    val PLAYER_GAME_SECOND = "PlaySecond"
    val GAME_WIN = "Win"
    val GAME_WIN2 = "Win2"
    val GAME_LOSS = "Loss"
    val GAME_LOSS2 = "Loss2"

    val SCREENS_ARENA_PICK = listOf(
            SCREEN_ARENA_PICK_01, SCREEN_ARENA_PICK_02, SCREEN_ARENA_PICK_03, SCREEN_ARENA_PICK_04, SCREEN_ARENA_PICK_05,
            SCREEN_ARENA_PICK_06, SCREEN_ARENA_PICK_07, SCREEN_ARENA_PICK_08, SCREEN_ARENA_PICK_09, SCREEN_ARENA_PICK_10,
            SCREEN_ARENA_PICK_11, SCREEN_ARENA_PICK_12, SCREEN_ARENA_PICK_13, SCREEN_ARENA_PICK_14, SCREEN_ARENA_PICK_15,
            SCREEN_ARENA_PICK_16, SCREEN_ARENA_PICK_17, SCREEN_ARENA_PICK_18, SCREEN_ARENA_PICK_19, SCREEN_ARENA_PICK_20,
            SCREEN_ARENA_PICK_21, SCREEN_ARENA_PICK_22, SCREEN_ARENA_PICK_23, SCREEN_ARENA_PICK_24, SCREEN_ARENA_PICK_25,
            SCREEN_ARENA_PICK_26, SCREEN_ARENA_PICK_27, SCREEN_ARENA_PICK_28, SCREEN_ARENA_PICK_29, SCREEN_ARENA_PICK_30)

    val SCREENS_LIST = mapOf(
            "0010111111100101101110110101000011001010100101001010101100100101010110110101001001010010001001010110100000111001110100101" to SCREEN_MAIN,
            "1011011110010101100100001010101101001010010100101001001111011010100101010110111001001101011011010110010001001100001010001" to SCREEN_MAIN_MODE_CASUAL,
            "1011010001000101100110111011001101011010110000111101111000010111110101100010111000111110001001110011110001100111001000001" to SCREEN_MAIN_MODE_RANKED,
            "1001001110110001001011110011000110101100011100010010100101101100001111111000001000111000000010111000000100100011001001111" to SCREEN_MAIN_MODE_PRATICE,
            "1001101110110000101011110010010110011111001111010010100000111110001100111010101111111000010100001000100100111100101101000" to SCREEN_MAIN_MODE_PRATICE,
            "1100111001100010101111011100011000111100000000110001110011110100011000011101010100001111111001110010110100111010011110001" to SCREEN_GAME,
            "1001010110110000010101011110000101100011101000111100101110101101010111100101010010111111011110101111110111111101101001011" to SCREEN_GAME_CARD_GENERATED,
            "1111110110010101100101011111101000110100010101010110101011010111010101011111101001010101010101110110101101111111010101110" to SCREEN_ARENA_CLASSES,
            "1101011011001110111111111011010011111110100000011000111011101001011100001111000110011110110011110001100111111100111100001" to SCREEN_ARENA_PICKS,
            "0111000111001010101101010010110111111010101010011110111101010111101010101001101101010101100111111011111101010110101111011" to SCREEN_ARENA_DASHBOARD)

    val SCREENS_PICK_LIST: Map<String, String>
        get() {
            return when (TESLTracker.referenceConfig) {
                is ReferenceConfig1366x768 -> SCREENS_PICK_LIST_1366
                else -> SCREENS_PICK_LIST_1920
            }
        }

    val SCREENS_PICK_LIST_1366 = mapOf(
            "1111010101011011010100011111111111000000101101101010101100101100000010101011111011001011001111110111100011110110110101011" to SCREEN_ARENA_PICK_01,
            "0101010101011110010110001110101011000010101100000111110011110101011001010001000111110111110000111000011111101001101010001" to SCREEN_ARENA_PICK_02,
            "0111011111011011010100000111101011000000101100100010111110011011001001111100001110010111100101001110110110110111011011100" to SCREEN_ARENA_PICK_03,
            "0101011111111111100010001011000101000001111101010011101110101010000010110001001111010101100100010010110111001111001010110" to SCREEN_ARENA_PICK_04,
            "1111010101010010010100011010101111000001101100111101001101101010010110001011111001101110001111010110111101010110110111011" to SCREEN_ARENA_PICK_05,
            "0101111111011111100010001001110111100001111000011010101110101000100010010101001111010101100101001010110011111111011011110" to SCREEN_ARENA_PICK_06,
            "1111110100001111100000100000111110110101010110010101010001110001110100101010110000111110011101010000110101011101011010101" to SCREEN_ARENA_PICK_07,
            "1101011011001011010111100011010010100011011110110011110010111000111010011100000100011100110111101110110001100111011001000" to SCREEN_ARENA_PICK_08,
            "1111110100001101101001101000101100101100010110101101010011000101111001011110000101101010111100001110010011110111101001010" to SCREEN_ARENA_PICK_09,
            "1111011111111011101001011011010111010001011001011010101100111010000010100101111010000111001101101011100001110010111101010" to SCREEN_ARENA_PICK_10,
            "1010010101001011010100111001011110101101010010011110010011010011111011011110000000110101110100010110100111110011100101000" to SCREEN_ARENA_PICK_11,
            "1101011101000111010110110101010100011101011001111000011101001011110100011110010010101010011010101011101111101001101011011" to SCREEN_ARENA_PICK_12,
            "1001011101001011010100110001010110111001011011011100000001100100111110010011110001101100110100111101010110001101001011100" to SCREEN_ARENA_PICK_13,
            "1001010101001101100010110100101110111001010111111100010001110101111101000110100101111110110110111001011010100101001111010" to SCREEN_ARENA_PICK_14,
            "1001010111001011010100101000100110111110000001110010111110010101111011110100100100110101110001011100101101100011110011010" to SCREEN_ARENA_PICK_15,
            "1000110101001101100011110100111100101101010011110100011001110111111001010010100100111011110110111001010010111101001011010" to SCREEN_ARENA_PICK_16,
            "1000001111001111010110111111000000101001011010111100111010010000011011010111100111110101110000110000100111111111001111000" to SCREEN_ARENA_PICK_17,
            "1010010100001111100000110100101100111101010011011100010001110000111100101010110000111110011101110000110101101101011011101" to SCREEN_ARENA_PICK_18,
            "1000011111101011010111100111000000111001011010110010110010111000111010011110100100011101110111101110100001100011001001000" to SCREEN_ARENA_PICK_19,
            "1010110100101101101101101100101100101101010010111101010011000101111001011110100001101011111100001110110011110111101011010" to SCREEN_ARENA_PICK_20,
            "0110000101101110010110111000001100001111000011001101001110110110111001011011001110010111011001001110010110010110011000011" to SCREEN_ARENA_PICK_21,
            "1100010111101111010110100101110000101101010010011101011001000111111111001011100100100111110011011011000110100001011011101" to SCREEN_ARENA_PICK_22,
            "1010010101001011010100101000111100101111010010011101000011100101111001111101001110010011011101001110100110110110110101111" to SCREEN_ARENA_PICK_23,
            "1010010101101101100010110100101010101110000010001100010010100111011011011001001110010110111100001110110110001110011001100" to SCREEN_ARENA_PICK_24,
            "1000010111001010010110111111100100111110000011001010100100110110100011001001111100010111101111000110111011011111001101101" to SCREEN_ARENA_PICK_25,
            "1010110101101100010010110100101000101110000010101101010110110101011011011001101110010111111101001110010110001111011100100" to SCREEN_ARENA_PICK_26,
            "0110001111101110010110110011100000001111010011011101001110000110001011001011111110010011011001001110010110010110011000000" to SCREEN_ARENA_PICK_27,
            "1010010101101111000010111000101100101111000010011101000011110101011001001101000110010011011001001111100110010110110101000" to SCREEN_ARENA_PICK_28,
            "0110011111101110010110110111000000111011010010011101000100111110111011001110001111010111011001001111110010110000111110111" to SCREEN_ARENA_PICK_29,
            "1110110100101100111110010100101101101110000001101101010110100101111001111100001110010111011101101011010110101010011100101" to SCREEN_ARENA_PICK_30
    )

    val SCREENS_PICK_LIST_1920 = mapOf(
            "0111010101111011110110011111111011110000101100101010101100101111100011101011111101000001100111010110110011110110010100011" to SCREEN_ARENA_PICK_01,
            "0001010101111111110000000110101011010010101100000011111011111101001001010001000101010101110000111110010110101111101010101" to SCREEN_ARENA_PICK_02,
            "0111010101110011110110010111101001000000101101110010111110001011100000101110111010011001001101100100110111010110010001111" to SCREEN_ARENA_PICK_03,
            "0111010111110011111010011011110101001000010101111010101110001010100010101001011011000101101101010000110111011110010000111" to SCREEN_ARENA_PICK_04,
            "1101010111010011010110011010111011000000101101111111111101101010110110001010011000101011001111010111101101011100110001010" to SCREEN_ARENA_PICK_05,
            "0101110111110001111010011100110111001000010101001110101111001110100011101101011011010101100101010110110101110110011110010" to SCREEN_ARENA_PICK_06,
            "1101010101000010010110011111111111010110100001100010101100101001110111111110111001001000001100000101100011011100110111010" to SCREEN_ARENA_PICK_07,
            "0111011101010011111000011111001111010000001101101010101110101110100011111101001101110101100110000110111101010110010101010" to SCREEN_ARENA_PICK_08,
            "0111010101111010010100011110011011000110101100101110101111100111000011100011011001110011100101110110110100110010010101010" to SCREEN_ARENA_PICK_09,
            "1101010111100111101100011001110101010001001001011010101100111010110110110111011011000010001101111011100001111100111101010" to SCREEN_ARENA_PICK_10,
            "1010010111101011010110111100000100101111010010011110010011010000011001011111000000010111111110010110110011111111101101011" to SCREEN_ARENA_PICK_11,
            "1101010101001111010100110101010100111101010011011100001101001011111100101111110111101010010010101011011110101001011010101" to SCREEN_ARENA_PICK_12,
            "1001011101001011110100111100010110111111011010011111000001100000011010010011010001001101111100110100110111011011001001111" to SCREEN_ARENA_PICK_13,
            "1000010101101101111010110100101010111101010110101111010001110001011001010100100100110111110110011010110110100011001011111" to SCREEN_ARENA_PICK_14,
            "1001010111001011010110111000010010101111011001111110000110010100001001110101100110010101100001001100000111111110110011010" to SCREEN_ARENA_PICK_15,
            "1000010101101101110010110100001100101111010010110101010011010001011001010011100101001011110110101110110010101111011011111" to SCREEN_ARENA_PICK_16,
            "1010000111101011010111111011110000101001011000111110110011011110011011000001000010110111111110110100110000010111100101111" to SCREEN_ARENA_PICK_17,
            "1000010101101111110100111100000100101101010010010101010001110000011000000011110000001111011101111100110101111111010001111" to SCREEN_ARENA_PICK_18,
            "1000000111101011010100110111010110111001010010110000000010011000111010000110000110000111010011110110110100110011101101011" to SCREEN_ARENA_PICK_19,
            "1010110111101101101100111100100100101101010010111101010011010100101001011110110001101101111111000100011011010111100001011" to SCREEN_ARENA_PICK_20,
            "0110100110111110011111011101101100001111011011001101101100110011011001001011001111000000001101101100110111001010011110010" to SCREEN_ARENA_PICK_21,
            "1111010001101011010110100101111100101111010010001001001010100100110111010001000100100101110011011111000100110110110001111" to SCREEN_ARENA_PICK_22,
            "1111000111101111111110011100100110101111011010001111101101100000111001101110101110010010011001100101000110111101100110010" to SCREEN_ARENA_PICK_23,
            "1010110101101100111010010100101010101111111010001111110110110011011010011101001110010000011101000000100111011111011100100" to SCREEN_ARENA_PICK_24,
            "1000000111101100001111011000100110111111011001001110100100011011110011101110111010010000100110110110011001001011100100010" to SCREEN_ARENA_PICK_25,
            "1110110101101110011011110110101100101111001000101001110110110111011011001101101111010000001101100100100111001011101110110" to SCREEN_ARENA_PICK_26,
            "0110000111101110001111111001100000001001011001001111100110010010011001101111111011011000001100000100011011011000111010010" to SCREEN_ARENA_PICK_27,
            "0010110100101110101011011100101101101111110010011101110010010111011001001101000110010010011101100101011011001001101100110" to SCREEN_ARENA_PICK_28,
            "0110000111101110000111110111100100111001010010001101111100011110011011000010001011110011101101101000110111001000000110011" to SCREEN_ARENA_PICK_29
    )

    val CLASS_PICK_LIST = mapOf(
            "0110111111111010111111100100100101111011111011100101110001010000110101101010111000011111110110101010011010111100111111110" to "Archer",
            "0001011101110110100000101011010011010001111000100011100001110101110101110011011110001110010011111010110111011101011001111" to "Assassin",
            "0011110101100100011101100010100010100110101001101101111011010001110110101110101100011101101100111011101111111110010111110" to "Battlemage",
            "0111010101000101000111000011001010100010111100101100011101111100100011111011101111111111110001111101101011111001011110001" to "Crusader",
            "0001110101101100000111110111110001001011101101111000111110011111101011011100101100011111100111111101011110111001000111101" to "Mage",
            "1001011111011010101110101011010111100111101111001111001110110110111111101101110110101110011011101011101101110101101011011" to "Monk",
            "1001110001110110101010111101111100001101111101010001101101110011100110111011001011000011011011111111001110001111010101101" to "Scout",
            "0001101010100101011101011001111101101010101110101000011001110101010101111111101001111110111001111111011100001100011000011" to "Sorcerer",
            "0010101010000011011110011100111101011000101011100010010110101111101100100100001111010101011011101011100101010100110010011" to "Spellsword",
            "1001111000110001100000001101010101011110101110100011111011010001011100000000011110111100000111111110101011010110110001110" to "Warrior"
    )

//    -- Game--

    val GAME_ITEMS_LIST = mapOf(
            "0001111010000011110111000110111111101101100101001100110101000011001001001001100111100100110011011010011110111111110111100" to PLAYER_GAME_FIRST,
            "1101100000011011100000001011011000010011100011000011111010001111010100110101101000101011100101000101100010011100010010011" to PLAYER_GAME_SECOND,
            "1101011101110011111000010100000110010011111111110000100110110101100010001000110000100000010000001101100000000100100001101" to GAME_WIN,
            "0011110101000110101101110010100011011010110101001111010100100010100110001111011001101100001011001110100101010001011011011" to GAME_WIN2,
            "0100011100000011011110001110011010001011101101110000010110100110101001000000111000100100010000001100111000001100100100100" to GAME_LOSS,
            "0000011101000000111111111111000000001111000010100001111110001100110011000111101111001000010111100001000000111001011100001" to GAME_LOSS2
    )

    val GAME_PLAYER_CLASS_LIST = mapOf(
            "0011111011011000011001100110001100110111100001110000001110000111100010110000111011011011001101101110000110100011110011111" to "Agility",
            "0101100111000100111001001011101100010111000011110000001110100111100111110000011001011010111001101101000110010010110000111" to "Archer",
            "0110110100100110011001000110101100001111011011110000001010010110000110110000011001011000111100101101001110011011110010111" to "Assassin",
            "0001100011000100111001001011101100000111001001101101001100100111100111100100011000111000100100101101100110010010110000111" to "Battlemage",
            "0001100111001100111001001001101100000111010011100001001001100011100111100100011000110001110001001101001110010000110000111" to "Crusader",
            "0011101110011000110011100001001110000101100001110000011100000111000011110001111000011001101100001100100110100000110010111" to "Endurance",
            "0011111011011000011001100001001110001101001001100101001100100101100110110000011000011001101100001110100110100010110000111" to "Intelligence",
            "0011110110101010011000001100101100001101011011100000001001001010000110110100001000110001110100001101001001011010110100111" to "Mage",
            "0110111100100110011001000110001100000111011011110001010110000111100010110000011001011001101001101110000110011111110011111" to "Monk",
            "0011001111011000101001100011001110011001111011101100001000100101100110110000111000011001101100001100100111100010110000111" to "Neutral",
            "0011101110001010010011001011101100000111100001100100001001100111000011110001111001011011110100101101101100110000110010111" to "Scout",
            "0011111100001110010011001110101100001101110001110000011011001111000110110000011000111000100100101101001100011010110010111" to "Sorcerer",
            "0011011100000110010011001110001100000101110011001000011010000111000111110000001100110001101001101111100110010110110010111" to "Spellsword",
            "0011111001011010001001100001001100010111100011110001001000001101100011100000011000111001100100001100110111100010010000111" to "Strength",
            "0001100110001100110011001011101100000111100001111000001001100111000111100001011000111000110001101101000110010010110000111" to "Warrior",
            "0011110011011000011001101101001110001101111011100001001000101101110100100100000100110001101100011100100111100000110100101" to "Willpower"
    )

    val GAME_PLAYER_RANK_LIST = mapOf(
            "0110011001111011001100100100011001101000100001101101001001000010110110010100010110100111110100100111001001011010010010110" to "0", //legend
            "1001110011111110000010011010010011110010110101000110110110010011100001110010001001010100101101101111100001101101100001000" to "1",
            "0011001111011110000010110111000110100000110111001111001010111000110011110011010000010011001100101100010010011000101101100" to "2",
            "0110011001011110000000100110011011100001000100011100010001100001110110011000110001011010100111001000110000011101100001010" to "3",
            "0111001011011110000000100011011011000000110110011010001000101000100111000011011000100011000011010010010100011111010100101" to "4",
            "1101001001011110000000101011001001100011010100110011011010010010010110010110010010010110110111001001010011110011001111001" to "5",
            "0010100011111110110000110100110001101000010110000111100100101010110011100101010000110010110100100110110001110100101100100" to "6"
    )

    val GAME_OPPONENT_CLASS_LIST = mapOf(
            "0100001001001100100010100110010010101011111001100000001100010010010011001111001111100000110000111110010011000010011000110" to "Agility",
            "0100000011001100100000101111110010001011111000110100110110010011010111000000001111100001110000110110010011100011000000111" to "Archer",
            "0100000110001100100010100110110111001111011000110000110110010010010110010010001111100000110000111110010011100011000000111" to "Assassin",
            "0001100001001100100000001001111011001011001001100100100100110001010101100000101111100000110000110110010011100011000010111" to "Battlemage",
            "0001100001001100100010001001110011001111011001100100110100100000000111100010101111100000011001101110100000100111000110110" to "Crusader",
            "0001000111001000100000111010110011001001111001101100001100000110101001001111001111100001011000111110001110100000110000010" to "Endurance",
            "0001001001101100100000011000011011001101001001100100100100000010111001001101101101100000110000111110001110100000110000010" to "Intelligence",
            "0000000000001001100010100110110111001111011001100000110000001100000110100010101111100000001001101101101100100111100010110" to "Mage",
            "0100001100000100100000100111110010001111011000111000110110010010010110000000001111100000110000110100010011000001100000101" to "Monk",
            "0101000011001000100000111010110011001001011001100100001100000000101001001111001101100001100100101100100100100000100000010" to "Neutral",
            "0001000111011001100000110111110110001011111001100100011001001100000011000000001111100001110000011111101100100111010000111" to "Scout",
            "0000000110011001100010100111110111001101111001011000011001001010000110000010001101100000011000111111100100100101100000111" to "Sorcerer",
            "0000000110011000100000100111110011001111111001101100111010000011110110100100001111100000111000111101000011100001100010100" to "Spellsword",
            "0000011001011001100110111110011010000011001001111000100100001110011001000111001111000001110001101100001100100001100000010" to "Strength",
            "0001000111001100100000001001110010001011111001101100011100100011100111100010001111100001011000111111100011100011100010110" to "Warrior",
            "0001000001001001100110011000110011001110011001100000100100001110000001100111101111100000100001101110001100100000000110010" to "Willpower"
    )

}
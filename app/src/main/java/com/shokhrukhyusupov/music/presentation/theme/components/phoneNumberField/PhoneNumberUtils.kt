package com.shokhrukhyusupov.music.presentation.theme.components.phoneNumberField

object PhoneNumberUtils {

    /**
     * ISO country code -> emoji flag.
     *
     * UZ -> 🇺🇿
     * RU -> 🇷🇺
     * US -> 🇺🇸
     */
    fun isoToEmojiFlag(
        countryCode: String
    ): String {

        require(
            countryCode.length == 2 &&
                    countryCode.all { it.isLetter() }
        ) {
            "Country code must contain exactly 2 Latin letters"
        }

        val code = countryCode.uppercase()

        return code
            .map { char ->
                Character.toChars(
                    0x1F1E6 +
                            (char.code - 'A'.code)
                ).concatToString()
            }
            .joinToString("")
    }

    fun digitsOnly(
        value: String
    ): String {
        return value.filter(Char::isDigit)
    }

    fun getMask(
        countryCode: String
    ): String {
        return PhoneMasks.getMask(
            countryCode
        )
    }

    fun getMaxLength(
        countryCode: String
    ): Int {
        return PhoneMasks.getMaxLength(
            countryCode
        )
    }
}

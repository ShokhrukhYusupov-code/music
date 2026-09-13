package com.shokhrukhyusupov.music.core.ui.components.phoneNumberField

object PhoneMasks {

    private val masks = mapOf(

        // Central Asia
        "UZ" to "XX XXX XX XX",
        "KZ" to "XXX XXX XX XX",
        "KG" to "XXX XXX XXX",
        "TJ" to "XX XXX XX XX",
        "TM" to "XX XXX XX XX",

        // CIS
        "RU" to "XXX XXX XX XX",
        "BY" to "XX XXX-XX-XX",
        "UA" to "XX XXX XX XX",
        "AZ" to "XX XXX XX XX",
        "AM" to "XX XXX XXX",
        "GE" to "XXX XXX XXX",

        // North America
        "US" to "XXX XXX XXXX",
        "CA" to "XXX XXX XXXX",
        "MX" to "XXX XXX XXXX",

        // Europe
        "GB" to "XXXX XXX XXXX",
        "DE" to "XXXX XXXXXXX",
        "FR" to "X XX XX XX XX",
        "IT" to "XXX XXX XXXX",
        "ES" to "XXX XXX XXX",
        "PT" to "XXX XXX XXX",
        "NL" to "XX XXX XXXX",
        "BE" to "XXX XX XX XX",
        "AT" to "XXX XXXXXXX",
        "CH" to "XX XXX XX XX",
        "SE" to "XX XXX XX XX",
        "NO" to "XXX XX XXX",
        "DK" to "XX XX XX XX",
        "FI" to "XX XXX XXXX",
        "PL" to "XXX XXX XXX",
        "CZ" to "XXX XXX XXX",
        "SK" to "XXX XXX XXX",
        "HU" to "XX XXX XXXX",
        "RO" to "XXX XXX XXX",
        "BG" to "XXX XXX XXX",
        "GR" to "XXX XXX XXXX",
        "RS" to "XX XXX XXXX",
        "HR" to "XX XXX XXXX",
        "SI" to "XX XXX XXXX",
        "BA" to "XX XXX XXX",
        "ME" to "XX XXX XXX",
        "MK" to "XX XXX XXX",
        "AL" to "XX XXX XXXX",
        "LT" to "XXX XXXXX",
        "LV" to "XX XXX XXX",
        "EE" to "XXX XXXX",
        "IS" to "XXX XXXX",
        "IE" to "XX XXX XXXX",

        // Turkey / Middle East
        "TR" to "XXX XXX XX XX",
        "IL" to "XX XXX XXXX",
        "AE" to "XX XXX XXXX",
        "SA" to "XX XXX XXXX",
        "QA" to "XXXX XXXX",
        "KW" to "XXXX XXXX",
        "BH" to "XXXX XXXX",
        "OM" to "XXXX XXXX",
        "JO" to "X XXXX XXXX",
        "LB" to "XX XXX XXX",

        // Asia
        "CN" to "XXX XXXX XXXX",
        "JP" to "XX XXXX XXXX",
        "KR" to "XX XXXX XXXX",
        "IN" to "XXXXX XXXXX",
        "ID" to "XXX XXXX XXXX",
        "MY" to "XX XXX XXXX",
        "SG" to "XXXX XXXX",
        "TH" to "XX XXX XXXX",
        "VN" to "XXX XXX XXXX",
        "PH" to "XXX XXX XXXX",
        "PK" to "XXX XXX XXXX",
        "BD" to "XXXX XXX XXX",

        // Oceania
        "AU" to "XXX XXX XXX",
        "NZ" to "XX XXX XXXX",

        // South America
        "BR" to "XX XXXXX XXXX",
        "AR" to "XX XXXX-XXXX",
        "CL" to "X XXXX XXXX",
        "CO" to "XXX XXX XXXX",
        "PE" to "XXX XXX XXX",
        "EC" to "XX XXX XXXX",
        "UY" to "X XXX XXXX",
        "PY" to "XXX XXX XXX",
        "BO" to "X XXX XXXX",

        // Africa
        "ZA" to "XX XXX XXXX",
        "EG" to "XX XXXX XXXX",
        "MA" to "XXX XXX XXX",
        "DZ" to "XXX XXX XXX",
        "TN" to "XX XXX XXX",
        "NG" to "XXX XXX XXXX",
        "KE" to "XXX XXX XXX",
        "GH" to "XXX XXX XXX",
        "TZ" to "XXX XXX XXX",
        "UG" to "XXX XXX XXX"
    )

    fun getMask(countryCode: String): String {
        return masks[countryCode.uppercase()]
            ?: "XXX XXX XXXX"
    }

    fun getMaxLength(countryCode: String): Int {
        return getMask(countryCode)
            .count { it == 'X' }
    }

    fun getMaxLengthFromMask(mask: String): Int {
        return mask.count { it == 'X' }
    }
}

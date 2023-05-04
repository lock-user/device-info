package ch.lock.mobile.android.deviceinfo.utils

import java.util.regex.Pattern

class FormatUtils {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "FormatUtils"
    }

    /**
     * 국제 번호를 지역 번호 형태로 format
     */
    fun toLocalPhoneNumber(
        internationalNumber: String?,
        includeHyphen: Boolean = true
    ): String {
        if (internationalNumber.isNullOrEmpty()) return "유심 미장착"

        var toLocalPhoneNumber: String = Pattern.compile("(^[+]82)|(^82)")
            .matcher(internationalNumber)
            .replaceAll("0")

        try {
            if (includeHyphen) {
                toLocalPhoneNumber = when (toLocalPhoneNumber.length) {
                    8 -> {
                        toLocalPhoneNumber.replaceFirst("^([0-9]{4})([0-9]{4})$".toRegex(), "$1-$2")
                    }
                    12 -> {
                        toLocalPhoneNumber.replaceFirst(
                            "(^[0-9]{4})([0-9]{4})([0-9]{4})$".toRegex(),
                            "$1-$2-$3"
                        )
                    }
                    else -> {
                        toLocalPhoneNumber.replaceFirst(
                            "(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$".toRegex(),
                            "$1-$2-$3"
                        )
                    }
                }
            }
            return toLocalPhoneNumber
        } catch (e: Exception) {
            return toLocalPhoneNumber
        }
    }

}
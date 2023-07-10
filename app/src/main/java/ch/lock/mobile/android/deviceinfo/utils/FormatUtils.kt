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

/**
 * ms를 조건에 따라 format
 */
fun Long.getTime(): String = if (this < 60_000) {
    String.format("${(this / 1_000) % 60}초 전")
} else if (this < 3_600_000) {
    String.format("${(this / 1_000 / 60) % 60}분 전")
} else if (this < 86_400_000) {
    String.format("${this / 1_000 / 3_600}시간 전")
} else {
    String.format("${this / 1_000 / 86_400}일 전")
}
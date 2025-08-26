package com.dokarun.zigzag.util

import android.icu.text.DecimalFormat

fun Int.addComma(): String {
    return this.let { DecimalFormat("#,###").format(it) }
}

fun Int.toKoreanCompact(): String {
    return when {
        this < 100 -> this.toString()

        this < 1000 -> {
            val hundred = this / 100
            val decimal = (this % 100) / 10
            if (decimal == 0) "${hundred}백" else "${hundred}.${decimal}백"
        }

        this < 10_000 -> {
            val thousand = this / 1000
            val decimal = (this % 1000) / 100
            if (decimal == 0) "${thousand}천" else "${thousand}.${decimal}천"
        }

        this < 100_000 -> {
            val tenThousand = this / 10_000
            val decimal = (this % 10_000) / 1000
            if (decimal == 0) "${tenThousand}만" else "${tenThousand}.${decimal}만"
        }

        else -> {
            val tenThousand = this / 10_000
            "${tenThousand}만"
        }
    }
}
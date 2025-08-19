package com.dokarun.zigzag.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class ZigzagColors(
    pink100: Color = Color(0xFFFDE9FA),
    pink500: Color = Color(0xFFF55DD6),
    pink800: Color = Color(0xFF913382),
    black100: Color = Color(0xFFE0E0E0),
    black200: Color = Color(0xFFB8B8B8),
    black300: Color = Color(0xFF929292),
    black400: Color = Color(0xFF6E6E6E),
    black500: Color = Color(0xFF4B4B4B),
    black600: Color = Color(0xFF2B2B2B),
    black700: Color = Color(0xFF111111),
    white: Color = Color(0xFFFFFFFF),
    purple500: Color = Color(0xFF7B60FA),
    red500: Color = Color(0xFFFF4C4C),
    navy500: Color = Color(0xFF2A6490),
    orange100: Color = Color(0xFFFFEFDB),
    orange500: Color = Color(0xFFFF950D),
) {
    var pink100 by mutableStateOf(pink100)
        private set
    var pink500 by mutableStateOf(pink500)
        private set
    var pink800 by mutableStateOf(pink800)
        private set
    var black100 by mutableStateOf(black100)
        private set
    var black200 by mutableStateOf(black200)
        private set
    var black300 by mutableStateOf(black300)
        private set
    var black400 by mutableStateOf(black400)
        private set
    var black500 by mutableStateOf(black500)
        private set
    var black600 by mutableStateOf(black600)
        private set
    var black700 by mutableStateOf(black700)
        private set
    var white by mutableStateOf(white)
        private set
    var purple500 by mutableStateOf(purple500)
        private set
    var red500 by mutableStateOf(red500)
        private set
    var navy500 by mutableStateOf(navy500)
        private set
    var orange100 by mutableStateOf(orange100)
        private set
    var orange500 by mutableStateOf(orange500)
        private set

    fun copy(
        pink100: Color = this.pink100,
        pink500: Color = this.pink500,
        pink800: Color = this.pink800,
        black100: Color = this.black100,
        black200: Color = this.black200,
        black300: Color = this.black300,
        black400: Color = this.black400,
        black500: Color = this.black500,
        black600: Color = this.black600,
        black700: Color = this.black700,
        white: Color = this.white,
        purple500: Color = this.purple500,
        red500: Color = this.red500,
        navy500: Color = this.navy500,
        orange100: Color = this.orange100,
        orange500: Color = this.orange500,
    ): ZigzagColors {
        return ZigzagColors(
            pink100 = pink100,
            pink500 = pink500,
            pink800 = pink800,
            black100 = black100,
            black200 = black200,
            black300 = black300,
            black400 = black400,
            black500 = black500,
            black600 = black600,
            black700 = black700,
            white = white,
            purple500 = purple500,
            red500 = red500,
            navy500 = navy500,
            orange100 = orange100,
            orange500 = orange500
        )
    }

    fun updateColorFrom(other: ZigzagColors) {
        pink100 = other.pink100
        pink500 = other.pink500
        pink800 = other.pink800
        black100 = other.black100
        black200 = other.black200
        black300 = other.black300
        black400 = other.black400
        black500 = other.black500
        black600 = other.black600
        black700 = other.black700
        white = other.white
        purple500 = other.purple500
        red500 = other.red500
        navy500 = other.navy500
        orange100 = other.orange100
        orange500 = other.orange500
    }
}

val LocalColors = staticCompositionLocalOf { ZigzagColors() }
package com.fbatista.kotlincarsselling

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import java.util.*

fun Float.getFormattedPrice() = String.format("R$ %,.2f", this)

fun String.bold(): SpannableStringBuilder{

    val aux = SpannableStringBuilder(this)

    aux.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            this.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )


    return aux
}

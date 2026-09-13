package com.shokhrukhyusupov.music.core.ui.components.phoneNumberField

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.text.iterator

class PhoneNumberVisualTransformation(
    private val mask: String,
    private val placeholderColor: Color
) : VisualTransformation {

    override fun filter(
        text: AnnotatedString
    ): TransformedText {

        val digits = text.text.filter(Char::isDigit)

        val builder = AnnotatedString.Builder()

        var digitIndex = 0

        /*
         * Позиция каждого реального введённого символа
         * в итоговой строке.
         */
        val originalToTransformed = mutableListOf<Int>()

        /*
         * Для каждой позиции итоговой строки
         * сохраняем количество реальных цифр
         * до этой позиции.
         */
        val transformedToOriginal = mutableListOf<Int>()

        for (maskChar in mask) {

            if (maskChar == 'X') {

                val currentOriginalIndex = digitIndex

                if (digitIndex < digits.length) {

                    originalToTransformed.add(
                        builder.length
                    )

                    builder.append(
                        digits[digitIndex]
                    )

                    digitIndex++

                } else {

                    /*
                     * Placeholder.
                     */
                    builder.pushStyle(
                        SpanStyle(
                            color = placeholderColor
                        )
                    )

                    builder.append('0')

                    builder.pop()
                }

                transformedToOriginal.add(
                    currentOriginalIndex
                )

            } else {

                /*
                 * Разделитель.
                 */
                builder.append(maskChar)

                transformedToOriginal.add(
                    digitIndex
                )
            }
        }

        val result = builder.toAnnotatedString()

        val offsetMapping = object : OffsetMapping {

            override fun originalToTransformed(
                offset: Int
            ): Int {

                if (offset <= 0) {
                    return 0
                }

                if (offset <= originalToTransformed.size) {
                    return originalToTransformed[
                        offset - 1
                    ] + 1
                }

                return result.length
            }

            override fun transformedToOriginal(
                offset: Int
            ): Int {

                if (offset <= 0) {
                    return 0
                }

                val safeOffset =
                    offset.coerceAtMost(
                        transformedToOriginal.size
                    )

                if (safeOffset == 0) {
                    return 0
                }

                return transformedToOriginal[
                    safeOffset - 1
                ].coerceAtMost(
                    digits.length
                )
            }
        }

        return TransformedText(
            text = result,
            offsetMapping = offsetMapping
        )
    }
}

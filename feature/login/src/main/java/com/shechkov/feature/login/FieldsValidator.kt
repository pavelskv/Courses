package com.shechkov.feature.login

import android.util.Patterns

interface FieldsValidator {
    fun isValid(text: String): Boolean

    abstract class EmptinessValidator() : FieldsValidator {
        override fun isValid(text: String): Boolean = text.isNotEmpty()
    }

    class Email() : FieldsValidator {
        override fun isValid(text: String): Boolean =
            Patterns.EMAIL_ADDRESS.matcher(text).matches()
    }

    class Password() : EmptinessValidator()
}
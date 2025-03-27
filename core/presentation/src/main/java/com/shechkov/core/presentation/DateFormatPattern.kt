package com.shechkov.core.presentation

interface DateFormatPattern {

    abstract class Abstract(private val pattern: String): DateFormatPattern{
        override fun toString(): String = pattern
    }

    class YYYYMMDD: Abstract("yyyy-MM-dd")
    class DDMMMYYYY: Abstract("dd MMM yyyy")

}
package com.shechkov.courses.plugins

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureJUnit() {
    dependencies {
        add("testImplementation", libs.findLibrary("junit").get())
        add("androidTestImplementation", libs.findLibrary("androidx.junit").get())
        add("androidTestImplementation", libs.findLibrary("androidx.espresso.core").get())
    }
}
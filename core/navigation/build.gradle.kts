plugins {
    alias(libs.plugins.courses.android.library)
    alias(libs.plugins.courses.hilt)
}

android {
    namespace = "com.shechkov.courses.core.navigation"
}

dependencies {
    implementation(libs.cicerone)
}
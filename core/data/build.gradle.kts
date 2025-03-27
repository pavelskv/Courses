plugins {
    alias(libs.plugins.courses.android.library)
    alias(libs.plugins.courses.android.retrofit)
    alias(libs.plugins.courses.hilt)
}

android {
    namespace = "com.shechkov.courses.core.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:database"))
}
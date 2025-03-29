plugins {
    alias(libs.plugins.courses.android.library)
}

android {
    namespace = "com.shechkov.core.ui"
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
}
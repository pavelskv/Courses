plugins {
    alias(libs.plugins.courses.android.library)
    alias(libs.plugins.courses.android.room)
    alias(libs.plugins.courses.hilt)
}

android {
    namespace = "com.shechkov.courses.core.database"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
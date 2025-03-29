plugins {
    alias(libs.plugins.courses.android.library)
    alias(libs.plugins.courses.hilt)
}

android {
    namespace = "com.shechkov.core.presentation"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.adapterdelegates)
    implementation(libs.adapterdelegates.viewbinding)

    implementation(project(":core:ui"))

}
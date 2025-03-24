plugins {
    alias(libs.plugins.courses.android.library)
}

android {
    namespace = "com.shechkov.core.presentation"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

}
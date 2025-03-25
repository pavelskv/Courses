plugins {
    alias(libs.plugins.courses.android.feature)
}

android {
    namespace = "com.shechkov.feature.login"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(project(":core:presentation"))

}
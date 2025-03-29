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

    implementation(libs.cicerone)

    implementation(project(":core:presentation"))
    implementation(project(":core:navigation"))
    implementation(project(":core:domain"))

}
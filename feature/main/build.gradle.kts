plugins {
    alias(libs.plugins.courses.android.feature)
}

android {
    namespace = "com.shechkov.courses.feature.main"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.cicerone)

    implementation(project(":core:presentation"))
    implementation(project(":core:navigation"))
}
plugins {
    alias(libs.plugins.courses.android.feature)
}

android {
    namespace = "com.shechkov.feature.account"

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(project(":core:presentation"))
    implementation(project(":core:domain"))
    implementation(project(":core:navigation"))

    implementation(libs.adapterdelegates)
    implementation(libs.adapterdelegates.viewbinding)

    implementation(libs.cicerone)

}
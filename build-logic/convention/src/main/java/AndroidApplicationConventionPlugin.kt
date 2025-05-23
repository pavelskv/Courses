import com.android.build.api.dsl.ApplicationExtension
import com.shechkov.courses.plugins.configureJUnit
import com.shechkov.courses.plugins.configureKotlin
import com.shechkov.courses.plugins.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlin()
                configureKotlinAndroid(this)

                defaultConfig.targetSdk = 34
            }

            configureJUnit()
        }
    }
}
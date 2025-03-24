import org.gradle.api.Plugin
import org.gradle.api.Project
import com.shechkov.courses.plugins.libs
import org.gradle.kotlin.dsl.dependencies

class AndroidRetrofitConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                add("implementation", libs.findLibrary("retrofit.core").get())
                add("implementation", libs.findLibrary("retrofit.converter.gson").get())
                add("implementation", libs.findLibrary("okhttp.logging").get())
                add("implementation", libs.findLibrary("okhttp.core").get())
            }
        }
    }
}
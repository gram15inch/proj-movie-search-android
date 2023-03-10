plugins {
    id ("com.android.application") version "7.4.1" apply false
    id ("com.android.library") version "7.4.1" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("de.mannodermaus.android-junit5") version "1.8.2.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("org.jetbrains.kotlin.kapt")  version "1.7.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.0" apply false
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}

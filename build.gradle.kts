// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.6.0" apply false

}
buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.6.0")
        classpath("com.android.tools.build:gradle:8.6.0")
        classpath ("io.realm:realm-gradle-plugin:10.15.1")
        // Add other classpath dependencies here
    }
}
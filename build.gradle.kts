import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.2.51"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlin_version))
    }
}

plugins {
    java
}

group = "com.xi-zz.learningrx"
version = "1.0-SNAPSHOT"

apply {
    plugin("kotlin")
}

val kotlin_version: String by extra

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8", kotlin_version))
    testCompile("junit", "junit", "4.12")
    compile("io.reactivex.rxjava2:rxjava:2.1.17")
    compile("io.reactivex.rxjava2:rxkotlin:2.2.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
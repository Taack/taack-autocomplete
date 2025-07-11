import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType

plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.6.0"
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        val platformVersion = providers.gradleProperty("platformVersion")

        create(IntelliJPlatformType.IntellijIdeaUltimate, platformVersion)
        bundledPlugin("com.intellij.java")
        bundledPlugin("org.intellij.groovy")

        pluginVerifier()
        zipSigner()
        instrumentationTools()


        version = "1.6.9"
        description = "Use with TaackUI Framework to recognize compiler extensions."
    }
}

intellijPlatform {
    buildSearchableOptions = false
}
import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType

plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.0.0-beta8"
}
group "org.taack"
version "1.6.6-beta8"

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

//        plugin("org.intellij.groovy", "4.0.14")//version.get())

//        plugins.set(listOf(/* Plugin Dependencies */"com.intellij.java", "org.intellij.groovy"))
//        id = "org.taack.taack-autocomplete"
        version = "1.6.6-beta8"
//        name = "TaackUiASTAutocomplete"
        description = "Use with TaackUI Framework to recognize compiler extensions."
//        changeNotes =
//            """
//            Compile for release 2024.2.beta8 ...
//            """.trimIndent()

    }
}

//patchPluginXml {
//    changeNotes.set(provider {
//        """2024.X version.<br><em>Ensure Taack AST Transformations get completion</em>"""
//    })
//}

//signPlugin {
////    password = System.getenv("PRIVATE_KEY_PASSWORD")
////    certificateChain = new File('/home/auo/intellij/chain.crt').text
////    privateKey = new File('/home/auo/intellij/private.pem').text
//}


//publishPlugin {
//    token = System.getenv("PUBLISH_TOKEN")
//}
plugins {
    kotlin("multiplatform") version "1.9.22"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlin-wrappers/maven/") {
        metadataSources {
            mavenPom()
            artifact()
        }
    }
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.10.0")
            }
        }
    }
}

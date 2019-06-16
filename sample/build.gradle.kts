plugins {
    kotlin("multiplatform") version "1.3.31"
}

group = "com.github.kropp"
version = "0.1"

repositories {
    // required for local development
    mavenLocal()
    mavenCentral()
}

kotlin {
    linuxX64() {
        binaries {
            executable("sample") {
                entryPoint = "sample.main"
            }
        }
    }

    sourceSets {
        val linuxX64Main by getting {
            dependencies {
                // add dependency to the generated gtk3 library
                implementation("$group:gtk3-linuxx64:$version")
            }
        }
    }
}

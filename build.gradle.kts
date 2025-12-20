plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.10.5"
}

group = "com.sodol"
version = "1.01"

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    intellijPlatform {
        intellijIdeaCommunity("2025.1.3")
        pluginVerifier()
        zipSigner()
    }
}

intellijPlatform {
    pluginConfiguration {
        id = "com.sodol.ds_idea_claude"
        name = "Ds Idea Claude"
        vendor {
            name = "sodol"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.runIde {
    args("C:\\Users\\dsodo\\project\\2026\\build_test")
}
plugins {
    java
}

group = "org.ttriukhan.automatization"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("checkFile") {
    val filePath = "$buildDir/README.md"
    doLast {
        val file = file(filePath)
        if (file.exists()) {
            println("File \"$filePath\" exists")
        }
        else {
            println("File \"$filePath\" does not exists")
        }
    }
}

tasks.register("generateReadme") {
    doLast {
        val readmeFile = file("$buildDir/README.md")
        if (!readmeFile.exists()) {
            readmeFile.createNewFile()
        }
        readmeFile.writeText(("""
            # Multi-Module Project

            ## Modules
            - core
            - scraper
            - main
            
            """ + System.currentTimeMillis()).trimIndent())
    }
}

tasks.named("build") {
    dependsOn("generateReadme")
}

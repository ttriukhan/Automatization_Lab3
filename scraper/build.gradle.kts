plugins {
    id("java")
}

group = "org.ttriukhan.automatization"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation("org.jsoup:jsoup:1.15.4")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

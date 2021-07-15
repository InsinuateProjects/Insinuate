plugins {
    kotlin("jvm") version "1.5.20"
    java
//    id("com.github.johnrengelman.shadow") version "7.0.0" apply false
}

allprojects {
    group = "io.insinuate"
    version = "0.1.0".let {
        try {
            rootProject.tasks.getByName("release")
            return@let it
        } catch (t: Throwable) {
            return@let "${it}-SNAPSHOT"
        }
    }

    tasks.withType<JavaCompile> {
        version = "1.8"
    }
}

repositories {
    mavenCentral()
}

tasks.register("release") {

}
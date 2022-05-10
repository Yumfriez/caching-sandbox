plugins {
    id("java")
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.springframework.boot") version "2.6.7"
}

repositories {
    mavenCentral()
}

subprojects {

    group = "com.budaev.caching"
    version = "1.0-SNAPSHOT"

    apply(plugin = "java");
    apply(plugin = "org.springframework.boot");
    apply(plugin = "io.spring.dependency-management");

    java.sourceCompatibility = JavaVersion.VERSION_11
    java.targetCompatibility = JavaVersion.VERSION_11

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    }

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.getByName<Wrapper>("wrapper") {
    gradleVersion = "7.1"
}

tasks.getByName<Task>("build").doLast {
    subprojects {
        tasks.getByName("build") {}
    }
}

tasks.getByName<Task>("bootJar").enabled = false

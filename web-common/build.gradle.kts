dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.getByName<Task>("bootJar").enabled = false

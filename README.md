# browserstack-appium-kotlin-junit-gradle

## Run Command
* `gradle build`
* `gradle test` OR `./gradlew test`

## Setup build.gradle
* Add the following lines of code to setup the BrowserStack SDK
```
dependencies {
    .
    .
    compileOnly("com.browserstack:browserstack-java-sdk:latest.release")
}
val browserstackSDKArtifact = configurations.compileClasspath.get().resolvedConfiguration.resolvedArtifacts.find { it.name == "browserstack-java-sdk" }
tasks.test {
    useJUnitPlatform(){
        jvmArgs("-javaagent:${browserstackSDKArtifact?.file}")
    }
}
```

## Update configurations
* Add all BrowserStack specific configurations in the `browserstack.yml` file
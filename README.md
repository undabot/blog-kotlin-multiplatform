# kotlin-multiplatform

This repository is showcase project built upon kotlin multi platform feature. Main goal is to show how kotlin
could be used to share same codebase between web & android app

## Prerequisites 
* Node >= 6
* Android SDK
* recommended: IntelliJ IDEA >=2017.3.3

## How to build and run

### Building the code
 * Run `./gradlew build`

### Running Android
 * Create `local.properties` in the root directory of the project and `sdk.dir=/Users/<your username>/Library/Android/sdk`.
 * Create run configuration of type "Android App"
 * Select module "app" in the run configuration settings
 * Run the configuration

### Running Web client
 * Run `npm run serve` in the 'web' directory to run webpack development server

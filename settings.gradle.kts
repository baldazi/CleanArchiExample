plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.23.0"
////                            # available:"0.30.0"
////                            # available:"0.30.1"
////                            # available:"0.30.2"
////                            # available:"0.40.0"
////                            # available:"0.40.1"
////                            # available:"0.40.2"
////                            # available:"0.50.0"
////                            # available:"0.50.1"
////                            # available:"0.50.2"
////                            # available:"0.51.0"
}

rootProject.name = "CleanArchiExample"

include("Commons_Android:gradle", "app")

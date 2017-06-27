# Base Synchronized Server
A boilerplate for backend applications integrating Trafficante with logging, configuration and data access.

## To Do When Cloning
- Download the project sources.
- Copy `ReleaseAgent/git-hooks/hooks` directory to `.git` directory to enable ReleaseAgent support. NodeJS must be locally installed for that. More info at [https://github.com/avivcarmis/ReleaseAgent](https://github.com/avivcarmis/ReleaseAgent "https://github.com/avivcarmis/ReleaseAgent")
- Open in your IDE.
- Rename `com.example` package name to whatever package you like to use.
- Edit `gradle.properties` file, set maven project name and group, and set the main class.
- Edit `LocalConfig`, `ClusterConfig` classes to add/remove config fields. `ClusterConfig` currently uses System Properties, create a cluster data source (i.e. Consul KV, MySQL, etc...) and set it in the main class. More info at [https://github.com/avivcarmis/conf-eager/wiki](https://github.com/avivcarmis/conf-eager/wiki "https://github.com/avivcarmis/conf-eager/wiki")
- Edit `Server` class, update base package name, update config fields if needed.
- Edit `APIResponse` class if structural changes are needed.
- Remove `ExampleEndpoint` class and start adding new endpoints. More info at [https://github.com/avivcarmis/trafficante](https://github.com/avivcarmis/trafficante "https://github.com/avivcarmis/trafficante")
- Remove `ExampleTestClass` class and start adding tests.

## How To Compile And Run
- Compile a fat jar (standalone jar containing all dependencies) by running `gradle bootRepackage`. (To use gradle wrapper, run `gradlew bootRepackage` on unix or `gradlew.bat bootRepackage` on windows). This will generate `build/libs/${project-name}-${project-version}.jar`. This is your executable.
- Copy `start.sh` for linux or `start.bat` for windows, and your executable jar. Change the executable jar name to `server.jar`, and edit the start script variables to match your target machine and local configuration.
- That's it! Run your start script and the server should be up.
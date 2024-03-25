#Ski Resort Weather CLI

  <!-- TABLE OF CONTENTS -->
  <details>
    <summary>Table of Contents</summary>
    <ol>
      <li>
        <a href="#about-the-project">About The Project</a>
        <ul>
          <li><a href="#video-demo">Video Demo</a></li>
          <li><a href="#description">Description</a></li>
          <li><a href="#project-repo">Project Repo</a></li>
          <li><a href="#built-with">Built With</a></li>
        </ul>
      </li>
      <li>
        <a href="#usage">Usage</a>
        <ul>
          <li><a href="#installation">Installation</a></li>
          <li><a href="#Running-The-Application">Running The Application</a></li>
        </ul>
      </li>
      <li><a href="#contributing">Contributing</a></li>
      <li><a href="#license">License</a></li>
      <li><a href="#contact">Contact</a></li>
      <li><a href="#acknowledgments">Acknowledgments</a></li>
    </ol>
  </details>



  <!-- ABOUT THE PROJECT -->
## About The Project

### Video Demo

Watch the Video: https://drive.google.com/file/d/188f4F4EOEzVIppDXtARgWloIW088L58g/view

### Description

  This project is a simple CLI written in java utilizing maven as a package manger. It allows the user to get current and forecasted weather for various ski resorts around the world. It was completed for the 2024 cs50 asynchronous course hosted by edX.

  The project is broken into 3 different modules:

1. **ski-resort-info-repository**: 

    This module contains the jdbc connections to a postgres database. the db_init.sql file with create the needed table if you do not already have it. It essentially just takes the data from the ski resort api and strip away the needless info, converts it to a java record, and then saves it to the local postgres database. The benifit of doing this is mainly that it reduces traffic to third party API that limits calls. The other aspect would be that it allows for the list of resorts to grow if there are other databases of resort info you could access or if you wanted to manually add your own.
2. **ski-resort-info-server**:

    This module is actually unecessary in the current stage of this application. This allows the data held in the repository to be hosted on a server. In future development this is how i would go about hosting the whole application and creating some sort of gui or front end interface.
3. **ski-resort-info-cli**:
   
    This is the main module of the application. It is broken into two main parts. The resort retriever and the weather retriever. The Resort retriever is a one time use functionality that makes the api call to the resort list and saves it to the repository mentioned above. If you are setting up the project locally you need to run this step once essentially a seed data step. The second part, the weather retriever, is the bulk of the program. It's the cli that allows the user to make api calls to a weather api based of the the resorts in our local database.


  <p align="right">(<a href="#readme-top">back to top</a>)</p>

### Project Repo

https://github.com/andrewmuhn/ski-resort-weather?tab=readme-ov-file#installation

### Built With

- [![Java][Java]][Java-url]
- [![IntelliJ IDEA][IntelliJ-IDEA]][IntelliJ-IDEA-url]
- [![Postgres][Postgres]][Postgres-url]
- [![Apache Maven][Apache-Maven]][Apache-Maven-url]
- [![Open-Weather][Open-Weather]][Open-Weather-url]

  <p align="right">(<a href="#readme-top">back to top</a>)</p>

  <!-- USAGE -->

## Usage

### Installation
To get started make sure you have java version 17+ installed and any version of postgres. Then you can clone the repository and open it in your favorite IDE. 
You will need to create a postgres database and set the environment variables for the database url, username, and password.
You can do this by opening the database.properties file in the ski-resort-info-repository/src/main/resources directory and renaming the values present. The file should look like this:

```yaml
  postgres.username = YOUR_POSTGRES_USERNAME
  postgres.password = YOUR_POSTGRES_PASSWORD
```

You can then initialize the database by running the db_init.sql file from the terminal.
You can do this by running the following command from a terminal:
    
```sh
    psql -U YOUR_POSTGRES_USERNAME -f db_init.sql
```

You will also need to get an api key from open weather and set that as an environment variable.
You will do this by creating a file called configs.properties in the ski-resort-info-cli/src/main/resources directory. The file should look like this:

```yaml
  ski-resort-info.resort-api-key = YOUR-API-KEY
  ski-resort-info.resort-api-host = ski-resorts-and-conditions.p.rapidapi.com
  open-weather-map.api-key = YOUR-API-KEY
  open-weather-map.api-url = https://api.openweathermap.org/data/2.5/
```

You will then need to seed the ski resort database by running the ResortRetriever class from the IDE. This makes an api call to an external resource that contains ski resort info.

Once you have the environment variables and database setup you are ready to run the application.
You can run the following command from the terminal or run can run the WeatherRetriever from your IDE:

```sh
java -jar ski-resort-info-cli/target/ski-resort-info-cli-1.0-SNAPSHOT.jar
```
  <p align="right">(<a href="#readme-top">back to top</a>)</p>

### Running The Application

Once the app is running you will be presented with a simple CLI with a main menu. 
You can navigate to each selection by typing in the command you wish to execute and hitting enter.
(ie. 'weather' to enter the weather menu)

The application allows you to look up real time weather data for a ski resort as well as a list of ski resort you can call upon from within this application. The application can provide current weather or a 5 day forecast.
  <p align="right">(<a href="#readme-top">back to top</a>)</p>



  <!-- CONTRIBUTING -->
## Contributing
This project is not accepting contributions
  <p align="right">(<a href="#readme-top">back to top</a>)</p>



  <!-- LICENSE -->
## License <br>
[![License: MIT][License: MIT]][License: MIT-url]
  <p align="right">(<a href="#readme-top">back to top</a>)</p>

  <!-- CONTACT -->

## Contact

Andrew Muhn - [andrewmuhn](https://github.com/andrewmuhn) - andrewmuhn@gmail.com <br>

  <p align="right">(<a href="#readme-top">back to top</a>)</p>


  <!-- ACKNOWLEDGMENTS -->
## Acknowledgments
![edX][edX]

[//]: # (![cs50-Duck][cs50-Duck])

Thanks to cs50 for a great experience!<br>

<!-- MARKDOWN LINKS & IMAGES -->

[edX]: https://img.shields.io/badge/edX-%2302262B.svg?style=for-the-badge&logo=edX&logoColor=white
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/
[IntelliJ-IDEA]: https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white
[IntelliJ-IDEA-url]: https://www.jetbrains.com/idea/
[Postgres]: https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white
[Postgres-url]: https://www.postgresql.org/
[Apache-Maven]: https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white
[Apache-Maven-url]: https://maven.apache.org/
[JUnit5]: https://img.shields.io/badge/junit5-239D5F.svg?style=for-the-badge&logo=junit5&logoColor=white
[JUnit5-url]: https://junit.org/junit5/
[Open-Weather]: https://img.shields.io/badge/open%20weather-EA6E4B.svg?style=for-the-badge&logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4KDTwhLS0gVXBsb2FkZWQgdG86IFNWRyBSZXBvLCB3d3cuc3ZncmVwby5jb20sIFRyYW5zZm9ybWVkIGJ5OiBTVkcgUmVwbyBNaXhlciBUb29scyAtLT4KPHN2ZyB3aWR0aD0iODAwcHgiIGhlaWdodD0iODAwcHgiIHZpZXdCb3g9IjAgMCA1MC44IDUwLjgiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIgZmlsbD0iI0ZGRkZmRiIgc3Ryb2tlPSIjRkZGRmZGIj4KDTxnIGlkPSJTVkdSZXBvX2JnQ2FycmllciIgc3Ryb2tlLXdpZHRoPSIwIi8%2BCg08ZyBpZD0iU1ZHUmVwb190cmFjZXJDYXJyaWVyIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS1saW5lam9pbj0icm91bmQiLz4KDTxnIGlkPSJTVkdSZXBvX2ljb25DYXJyaWVyIj4KDTxwYXRoIGQ9Ik03Ljg1OSAyOS4yNjZhMTQuOTQ3IDE0Ljk0NyAwIDAgMSA1Ljg2NC0xNi4xMTIgMTQuOTQ3IDE0Ljk0NyAwIDAgMSAxNy4xNDcgMCAxNC45NDcgMTQuOTQ3IDAgMCAxIDUuODY1IDE2LjExMm0tOC4yNjYgMGgxNC4xMjltLTM3LjI5OCAwaDQuNDg3bS4wMDMgNS41OTRoOC45NDNtMTUuMzk4IDBoMi41MTRtNS4zIDBoMi41MTRtLTMxLjc3MSA1LjU5NGgyMy43NTdtLTkuMjk0LTUuNTk0aDEuODQ0TTkuNzkgMjkuMjY2YTIuNzk3IDIuNzk3IDAgMCAxIDIuNzk3IDIuNzk4QTIuNzk3IDIuNzk3IDAgMCAxIDkuNzkgMzQuODZtOC45NDMgMGEyLjc5NyAyLjc5NyAwIDAgMSAyLjc5OCAyLjc5OCAyLjc5NyAyLjc5NyAwIDAgMS0yLjc5OCAyLjc5N204LjQxOCAwYTIuNzk3IDIuNzk3IDAgMCAxLTIuNDIyLTEuMzk4IDIuNzk3IDIuNzk3IDAgMCAxIDAtMi43OTcgMi43OTcgMi43OTcgMCAwIDEgMi40MjItMS40IiBzdHlsZT0ib3BhY2l0eToxO2ZpbGw6bm9uZTtmaWxsLXJ1bGU6ZXZlbm9kZDtzdHJva2U6I0ZGRkZGRjtzdHJva2Utd2lkdGg6My4xNzU7c3Ryb2tlLWxpbmVjYXA6cm91bmQ7c3Ryb2tlLWxpbmVqb2luOnJvdW5kO3N0cm9rZS1taXRlcmxpbWl0OjA7c3Ryb2tlLWRhc2hhcnJheTpub25lO3N0cm9rZS1vcGFjaXR5OjEiLz4KDTxwYXRoIGQ9Ik0yOC40NyAzNC44NmEyLjc5NyAyLjc5NyAwIDAgMS0yLjQyMi0xLjM5OCAyLjc5NyAyLjc5NyAwIDAgMSAwLTIuNzk3IDIuNzk3IDIuNzk3IDAgMCAxIDIuNDIzLTEuMzk5IiBzdHlsZT0ib3BhY2l0eToxO2ZpbGw6bm9uZTtmaWxsLXJ1bGU6ZXZlbm9kZDtzdHJva2U6I0ZGRkZGRjtzdHJva2Utd2lkdGg6My4xNzU7c3Ryb2tlLWxpbmVjYXA6cm91bmQ7c3Ryb2tlLWxpbmVqb2luOnJvdW5kO3N0cm9rZS1taXRlcmxpbWl0OjA7c3Ryb2tlLWRhc2hhcnJheTpub25lO3N0cm9rZS1vcGFjaXR5OjEiLz4KDTwvZz4KDTwvc3ZnPg%3D%3D
[Open-Weather-url]: https://openweathermap.org/api
[cs50-Duck]: https://img.shields.io/badge/cs50-FED46F.svg?style=for-the-badge&logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPD94bWwgdmVyc2lvbj0iMS4wIiBzdGFuZGFsb25lPSJubyI%2FPgo8IURPQ1RZUEUgc3ZnIFBVQkxJQyAiLS8vVzNDLy9EVEQgU1ZHIDIwMDEwOTA0Ly9FTiIKICJodHRwOi8vd3d3LnczLm9yZy9UUi8yMDAxL1JFQy1TVkctMjAwMTA5MDQvRFREL3N2ZzEwLmR0ZCI%2BCjxzdmcgdmVyc2lvbj0iMS4wIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciCiB3aWR0aD0iMjU2LjAwMDAwMHB0IiBoZWlnaHQ9IjI1Ni4wMDAwMDBwdCIgdmlld0JveD0iMCAwIDI1Ni4wMDAwMDAgMjU2LjAwMDAwMCIKIHByZXNlcnZlQXNwZWN0UmF0aW89InhNaWRZTWlkIG1lZXQiPgo8bWV0YWRhdGE%2BCkNyZWF0ZWQgYnkgcG90cmFjZSAxLjEwLCB3cml0dGVuIGJ5IFBldGVyIFNlbGluZ2VyIDIwMDEtMjAxMQo8L21ldGFkYXRhPgo8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgwLjAwMDAwMCwyNTYuMDAwMDAwKSBzY2FsZSgwLjA1MDAwMCwtMC4wNTAwMDApIgpmaWxsPSIjMDAwMDAwIiBzdHJva2U9Im5vbmUiPgo8cGF0aCBkPSJNMTAxIDI1NjAgbDEgLTIyODAgMjQ1OSAwIDI0NTkgMCAwIDIyODAgMCAyMjgwIC0yNDYwIDAgLTI0NjAgMCAxCi0yMjgweiBtMTYzNSAyMTQ4IGMxMDMgLTQyIDU5OCAtNDIyIDc1NCAtNTc4IDUwMiAtNTA2IDUyMyAtMTE0MyA1NSAtMTY1NgotMjQyIC0yNjUgLTMyMSAtNDY3IC0yMjEgLTU2NyAyMSAtMjEgMjYgLTYgMjYgODAgMCAxMjcgMzkgMTkxIDI4MyA0NTkgOTAgOTgKMTgwIDIxMSAyMDAgMjUxIDIwIDQwIDM5IDc2IDQxIDgwIDIgNCAzMyAtMTUgNzAgLTQzIDI1OCAtMTk0IDExMDQgLTQ4MSAxMjM5Ci00MjEgMzcgMTcgMjIgMjUgLTEwMyA1OSBsLTE0NSAzOSAxNTEgNzUgYzE3MiA4NSAzMjkgMjQxIDQyOCA0MjUgbDU5IDExMAoxMDMgLTExOCBjMjEzIC0yNDUgMjU0IC00MDAgMjM5IC04OTAgLTI3IC04MTcgLTMyOSAtMTQwMyAtNzg2IC0xNTIyIC0zMDAKLTc5IC02NzggLTEwMSAtMTcxOSAtMTAwIC0xNTc2IDAgLTE5NDIgNzQgLTIxMTkgNDI4IC0xNDcgMjk1IC0xMTcgNjMzIDg4Cjk1OSAxMDkgMTc0IDE4MCAzNTIgMTg3IDQ2NCAyIDQzIDcgNzggMTAgNzggMTUgMCA4MyAtMTc1IDg0IC0yMTUgMCAtNDYgMzgKLTY1IDQyIC0yMCAxMyAxNjUgLTM5IDMwOCAtMTY3IDQ2MSAtMzUxIDQxOSAtMzg1IDczNSAtMTM2IDEyNTggMTQ2IDMwNyAzNTIKNTA5IDgxNSA3OTggMjcyIDE3MCAzMzQgMTgyIDUyMiAxMDZ6Ii8%2BCjxwYXRoIGQ9Ik03MjUgNDA1NSBjLTExNSAtNTUgLTE5MCAtMzEzIC0xNDYgLTUwNyA2NSAtMjkyIDMwNiAtMzAzIDM5MiAtMTgKODggMjk0IC02MiA2MTQgLTI0NiA1MjV6IG0xMjAgLTkwIGM0MSAtNDcgNzEgLTE0NiAzMyAtMTEwIC00NSA0MyAtMTM2IDI5Ci0xODkgLTI4IC01NyAtNjEgLTYwIC01MyAtMTkgNDcgNTUgMTMyIDExMyAxNjIgMTc1IDkxeiBtNDEgLTE4NyBjMjggLTQ1IDQKLTk4IC00NCAtOTggLTUzIDAgLTg1IDU4IC01OSAxMDYgMjMgNDIgNzQgMzggMTAzIC04eiIvPgo8cGF0aCBkPSJNMjE2MyA0MDI5IGMtMTk1IC0xNjQgLTExNCAtNzA5IDEwNSAtNzA5IDIxNSAwIDMwMCA1MTMgMTE3IDcwNSAtNjYKNzAgLTE0MyA3MSAtMjIyIDR6IG0xOTEgLTEwNyBjNjggLTEwMCA2MCAtMTM3IC0xNiAtNzQgLTY4IDU4IC04MyA2MSAtMTQxIDMwCi01NyAtMzAgLTYxIC0xNiAtMTYgNTkgNTEgODQgMTExIDc4IDE3MyAtMTV6IG01IC0xNTEgYzM5IC00NiAxNyAtMTAxIC0zOQotMTAxIC0zNyAwIC01MiAxMiAtNTcgNDggLTEwIDcxIDUzIDEwNSA5NiA1M3oiLz4KPHBhdGggZD0iTTE0MzggMzM4MiBjLTQwIC04IC0xMTYgLTQzIC0xNjkgLTc4IC04MyAtNTUgLTExMyAtNjQgLTIyNiAtNjQKLTMwMSAwIC00OTEgLTI5NCAtMzM4IC01MjIgNDAxIC01OTQgMTk5MiAtMjgxIDE2OTQgMzM0IC00OSAxMDAgLTE5OSAxODgKLTMyMiAxODggLTQ2IDAgLTEyOCAyNyAtMjExIDY5IC0xNDQgNzMgLTI5NyA5OSAtNDI4IDczeiBtMjgzIC0xMDIgYzQwIC0xMQoxMzAgLTYwIDIwMCAtMTEwIDE0MiAtOTggMjU5IC0xMzEgMTQ5IC00MSAtNzAgNTggLTU0IDYyIDg1IDIxIDE0MCAtNDIgMjA1Ci0xMjEgMjA1IC0yNDkgMCAtMzk3IC05NzkgLTU4MiAtMTQ2NCAtMjc3IC0yODcgMTgwIC0yMDYgNTEwIDEzNCA1NDUgMTE1IDEyCjExOCAxMSA3NSAtMjEgLTI1IC0xOCAtNDUgLTQyIC00NSAtNTMgMCAtMzggMTExIDkgMjA0IDg3IDE0MiAxMTkgMjc3IDE0OAo0NTcgOTh6Ii8%2BCjxwYXRoIGQ9Ik0xNDIzIDMxMTggYy0zNyAtMTEgLTYzIC0yNSAtNTcgLTMxIDYgLTYgNDIgLTEgNzkgMTEgNTMgMTggOTkgMTYKMjA2IC02IDE1MCAtMzIgMjAxIC0yNyA3NiA2IC0xMjkgMzQgLTIzNCA0MSAtMzA0IDIweiIvPgo8cGF0aCBkPSJNMTIyMyAyODY5IGMtMjE4IC04MCAtMzE1IC04NyAtMzkxIC0yNyAtNzYgNjAgLTg0IDM3IC0xMSAtMzMgODMKLTc5IDI1MiAtODMgNDI5IC05IDE2OSA3MCAzNTMgNjggNTMwIC02IGwxMzAgLTU0IC0xMTAgMTMgYy0xNjAgMTkgLTU0MCAyMwotNTI5IDUgMTQgLTIzIC02MCAtNDEgLTEwMSAtMjUgLTI1IDkgLTMyIDYgLTIyIC0xMCAyMCAtMzIgNzYgLTI5IDE0NSA3IDY4CjM1IDMzMCA0MSA0MjMgOSAxMDcgLTM4IDQyNyA1IDUyNiA3MCAxMDYgNzAgOTIgODAgLTQ4IDMxIC0xNDkgLTUzIC0xNzAgLTUxCi00MDIgMzAgLTI0OSA4OCAtMzI5IDg3IC01NjkgLTF6Ii8%2BCjxwYXRoIGQ9Ik0zMTI5IDIwODIgYy0zOTIgLTIyNSAtNDg0IC03OTMgLTE3MCAtMTA0MSA1NDMgLTQyNyAxNTU1IC0yMzMgMTY4OAozMjMgMjAgODMgLTIyIDg3IC00NSA0IC0xMzMgLTQ4MSAtMTA3OCAtNjM2IC0xNTg4IC0yNjEgLTI3NiAyMDMgLTE4OSA3MjkKMTU3IDk0NyAxNTEgOTUgMTE2IDExOCAtNDIgMjh6Ii8%2BCjxwYXRoIGQ9Ik00NDUyIDE3MDkgYy00MyAtMzggLTkxIC02OSAtMTA1IC02OSAtMTUgMCAtMjcgLTkgLTI3IC0yMCAwIC0zNiA1MwotMjEgMTM3IDQwIDQ2IDMzIDgzIDc0IDgzIDkwIDAgMzkgMyA0MCAtODggLTQxeiIvPgo8cGF0aCBkPSJNMTc5MCAxMzgxIGMtMTk2IC04MyAtMjA5IC00NzEgLTE5IC01NTggMTQxIC02NCAyNTQgMTUgMjc5IDE5MyAzMQoyMzEgLTExMCA0MjkgLTI2MCAzNjV6IG0xMTAgLTE0MSBjODAgLTgwIDQxIC0zNDAgLTUyIC0zNDAgLTgzIDAgLTEzOSAyMDMKLTg1IDMwNiA0MyA4MiA4MCA5MSAxMzcgMzR6Ii8%2BCjxwYXRoIGQ9Ik00NzAgMTM2MSBjLTEzNSAtNTYgLTE3NyAtMjMwIC05NCAtMzkyIDgzIC0xNjQgMTk1IC0yMDcgMzAyIC0xMTgKbDY1IDU1IC00MSA0MSBjLTM4IDM4IC00MyAzOCAtNzcgNyAtNDUgLTQwIC0xMTMgLTI2IC0xNTEgMzMgLTEwMyAxNTkgLTE2CjM1MSAxMTkgMjYzIDI4IC0xOCA1MiAtMzAgNTQgLTI3IDMgNCAxNyAyMyAzMSA0MiA2MCA3OCAtODcgMTQ2IC0yMDggOTZ6Ii8%2BCjxwYXRoIGQ9Ik04NTggMTM1MCBjLTE2MSAtODcgLTEwMSAtMjY4IDEwNSAtMzE3IDgzIC0yMCAxMDAgLTExMyAyMSAtMTEzIC0xOQowIC02MCAxNCAtOTIgMzAgLTMyIDE3IC01OSAyOCAtNjEgMjUgLTEgLTMgLTE0IC0yMCAtMjggLTM5IC02NiAtODYgMjE2IC0xNTcKMjk3IC03NiA5MSA5MSAzNCAyMTcgLTEzMiAyOTAgLTExNCA1MSAtMTMxIDc2IC03MSAxMDggMjUgMTQgNTMgMTEgOTIgLTkgNjkKLTM2IDYxIC0zOCA5OSAyMCA1NiA4NiAtMTEyIDE0NSAtMjMwIDgxeiIvPgo8cGF0aCBkPSJNMTI0OSAxMzU5IGMtODIgLTEzMyAtMjEgLTMxMiAxMDMgLTMwMiA2OCA2IDExOSAtMzggMTAxIC04NyAtMTkKLTQ5IC03NSAtNTkgLTEzNiAtMjQgLTU0IDMwIC01OCAzMCAtODAgLTExIC01NCAtMTAxIDE5NCAtMTY0IDI4NSAtNzMgMTAwCjEwMCAtOCAzMzMgLTE0NSAzMTMgLTQ4IC03IC01NyAtMSAtNTcgMzcgMCA0MSAxMSA0NyAxMDUgNTIgOTggNiAxMDUgMTAgMTExCjYxIGw3IDU1IC0xNDAgMCBjLTc4IDAgLTE0NyAtMTAgLTE1NCAtMjF6Ii8%2BCjwvZz4KPC9zdmc%2BCg%3D%3D
[License: MIT]: https://img.shields.io/badge/License-MIT-yellow.svg
[License: MIT-url]: https://opensource.org/licenses/MIT

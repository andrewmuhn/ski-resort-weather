#Dopamine-Box

  <!-- TABLE OF CONTENTS -->
  <details>
    <summary>Table of Contents</summary>
    <ol>
      <li>
        <a href="#about-the-project">About The Project</a>
        <ul>
          <li><a href="#Project Image">Project Images</a></li>
          <li><a href="#built-with">Built With</a></li>
        </ul>
      </li>
      <li><a href="#usage">Usage</a></li>
      <li><a href="#contributing">Contributing</a></li>
      <li><a href="#license">License</a></li>
      <li><a href="#contact">Contact</a></li>
      <li><a href="#acknowledgments">Acknowledgments</a></li>
    </ol>
  </details>



  <!-- ABOUT THE PROJECT -->
## About The Project
### Project Images

  <p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

- [![Java][Java]][Java-url]
- [![IntelliJ IDEA][IntelliJ-IDEA]][IntelliJ-IDEA-url]
- [![Postgres][Postgres]][Postgres-url]
- [![Apache Maven][Apache-Maven]][Apache-Maven-url]
- [![Open-Weather][Open-Weather]][Open-Weather-url]

  [//]: # (- [![JUnit5][JUnit5]][JUnit5-url])
- [![][]][]
- [![][]][]
- [![][]][]
- [![][]][]

  <p align="right">(<a href="#readme-top">back to top</a>)</p>

  <!-- USAGE EXAMPLES -->

## Usage <br>

To get started make sure you have java version 17+ installed. Then you can clone the repository and open it in your favorite IDE. 
You will need to create a postgres database and set the environment variables for the database url, username, and password. You will also need to get an api key from open weather and set that as an environment variable.
You will do this by creating a file called configs.properties in the ski-resort-info-cli/src/main/resources directory. The file should look like this:

```yaml
  ski-resort-info.resort-api-key = YOUR-API-KEY
  ski-resort-info.resort-api-host = ski-resorts-and-conditions.p.rapidapi.com
  open-weather-map.api-key = YOUR-API-KEY
  open-weather-map.api-url = https://api.openweathermap.org/data/2.5/
```
Once you have the environment variables set you can run the application and it will create the necessary tables in the database. You can then use the application by navigating to the location the project is cloned to and then run the following command in your preferred terminal: 

```sh
java -jar ski-resort-info-cli/target/ski-resort-info-cli-1.0-SNAPSHOT.jar
```


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
[License: MIT]: https://img.shields.io/badge/License-MIT-yellow.svg
[License: MIT-url]: https://opensource.org/licenses/MIT

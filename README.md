# Exercise App
This web application is built using Java 8 SpringBoot Framework with Thymeleaf/Vue.Js as to render a basic UI. The purpose is to create a simple web interface to randomize exercises to do on a daily basis without repeating the same exercise type from the last day to build an optimal exercise routine.

## How to run as a developer:
```
mvn spring-boot:run
```

## How to build and run:
```
mvn clean build
java -jar target/exercise-app.jar
```

## Configuration:
To set up different environments, add a env specific config file in the config difrectory and specify the following in the command line when running.

E.g. `application-dev.yml` you would run, `SPRING_PROFILES_ACTIVE=dev java -jar target/exercise-app.jar`

## Endpoints:

### GET - Get All Exercises
Returns all exercises.

`http://localhost:8888/api/exercise/list`

Ex. Response:
```
[
    {
        "id": 1,
        "name": "Bicep Curls",
        "reps": 6,
        "sets": 5,
        "restInSecs": 30,
        "type": "STRENGTH",
        "category": "ARMS",
        "subcategory": "BICEP_TALL",
        "intensityMode": "REGULAR"
    },    
    {
        "id": 4,
        "name": "Wrist curls",
        "reps": 20,
        "sets": 5,
        "restInSecs": 30,
        "type": "STRENGTH",
        "category": "ARMS",
        "subcategory": "WRIST",
        "intensityMode": "REGULAR"
    },
]
```

### POST - Add An Exercise
Adds a new exercise to the list.

`http://localhost:8888/api/exercise/add`

Ex. Request Body:
```
{
    "name": "Bicep Curls",
    "reps": 6,
    "sets": 5,
    "restInSecs": 30,
    "type": "STRENGTH",
    "category": "ARMS",
    "subcategory": "BICEP_TALL",
    "intensityMode": "REGULAR"
}
```

### DELETE - Delete An Exercise
Deletes an exercise from the list by id.

`http://localhost:8888/api/exercise/delete?id={id}`

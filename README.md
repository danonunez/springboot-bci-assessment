# springboot-bci-assessment
Spring Boot RESTful API for user creation

> To compile and run the project, just use the command `docker-compose up`.

> Email and Password validation regular expressions can be configured in the `application.yml` file in the `validation.email` and `validation.password` properties. The respective error messages can be configured in the `messages.properties` file in the `email.message` and `password.message` properties.

> The project uses H2 in-memory database, and does not need a build script.

## Endpoints

- Create User: POST http://localhost:8080/api/users

```
{
    "name": "Juan Rodriguez",
    "email": "juan@dominio.cl",
    "password": "hunter2A%",
    "phones": [
        {
        "number": "1234567",
        "citycode": "1",
        "contrycode": "57"
        }
    ]
}
```

- Get All Users: GET http://localhost:8080/api/users

- Get User by id: GET http://localhost:8080/api/users/{id}

- Update User by id: PUT http://localhost:8080/api/users/{id}

```
    {
    "name": "Juan Rodriguez Perez",
    "email": "juan@dominio.cl",
    "password": "hunter2A%#",
    "phones": [
        {
            "number": "123456788",
            "cityCode": "1",
            "countryCode": "57"
        },
        {
            "number": "535435435",
            "cityCode": "2",
            "countryCode": "57"
        }
    ]
}
```

- Delete User: DELETE http://localhost:8080/api/users/{id}

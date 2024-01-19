# TeachersManagerBackend
Homework for the 5th session of the *Programming of Windows and Mobile Applications* subject. A simple backend for managing teachers. Allows user to communicate with database to manage:
- teachers,
- groups,
- rates.

Written in Java and developed in IntelliJ IDEA. The project also utilizes the Spring Framework.

## Functionality
The backend provides several endpoints to interact with the database:
- List teachers: `GET http://localhost:8080/api/teacher`
- Add teacher: `POST http://localhost:8080/api/teacher`
  
  Example request:
    {
        "fName": "John",
        "lName": "Smith",
        "salary": 7500.0
        "year": 1997,
        "cond": "present"
    }
- Edit teacher: `PUT http://localhost:8080/api/teacher/1`
  
  Example request:
    {
        "fName": "John",
        "lName": "Smith",
        "salary": 7500.0
        "year": 1997,
        "cond": "sick"
    }
- Delete teacher: `DELETE http://localhost:8080/api/teacher/1`
- Export teachers list to csv: `GET http://localhost:8080/api/teacher/csv`
- List groups: `GET http://localhost:8080/api/group`
- List teachers in group: `GET http://localhost:8080/api/group/1/teacher`
- Add group: `POST http://localhost:8080/api/group`
  
  Example request:
    {
        "name": "English teachers",
        "max": 5,
        "teachers": [],
        "ratings": []
    }
- Get group fillng (%): `GET http://localhost:8080/api/group/1/fill`
- Delete group: `DELETE http://localhost:8080/api/group/1`
- List rates: `GET http://localhost:8080/api/rating`
- Add rate: `POST http://localhost:8080/api/rating`
  
  Example request:
    {
        "rating": 5,
        "description": "Very good"
    }
- Edit rate: `PUT http://localhost:8080/api/rating/1`
  
  Example request: `PUT http://localhost:8080/api/rating/4`
    {
        "rating": 5,
        "description": "Excellent"
    }
- Delete rate: `DELETE http://localhost:8080/api/rating/1`

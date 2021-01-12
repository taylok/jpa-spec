0.1.0 Basic JPA 
```
curl -X GET 'http://localhost:8080/members'
```
0.2.0 Specification JPA
```
curl -X GET 'http://localhost:8080/members?active=true&filter=123'
```
0.3.0 SearchString JPA
```
curl -X GET 'http://localhost:8080/members?active=true&filter=123&searchString=tennis'
```
0.4.0 Basic Quartz Config

0.5.0 Quartz API
```
curl -X GET 'http://localhost:9000/scheduler/information'
curl -X GET 'http://localhost:9000/scheduler/jobKeys'
curl -X GET 'http://localhost:9000/scheduler/jobKeys?name=Member+Statistics+Job&group=DEFAULT'
curl -X DELETE 'http://localhost:9000/scheduler/deleteJob?name=Member+Statistics+Job&group=DEFAULT'
```

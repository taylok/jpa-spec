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

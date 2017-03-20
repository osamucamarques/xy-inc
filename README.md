# xy-inc
Multi model Spring Boot Application running inside docker container linked with MySQL container.
For details please read: https://github.com/samucamarques/xy-inc/wiki#welcome-to-the-xy-inc-wiki

### How to run it with Docker step by step
Assume you already have Docker installed. See https://docs.docker.com/installation/.

1) clone or download the project and build locally:

~~~
git clone https://github.com/samucamarques/xy-inc.git
cd xy-inc
mvn clean package docker:build
~~~

2) Create a newtwork in Docker container:

~~~
docker network create xy-inc-network
~~~

3) Run MySQL 5.6 in Docker container:

~~~
docker run -d --net=xy-inc-network --name=xy-inc-mysql -e MYSQL_ROOT_PASSWORD=xy-inc -e MYSQL_DATABASE=xy-inc -e MYSQL_USER=xy-inc -e MYSQL_PASSWORD=xy-inc mysql:5.6
~~~

4) Run xy-inc application in Docker container and link to xy-inc-mysql:

~~~~
docker run -t --net=xy-inc-network --name=xy-inc-application --link=xy-inc-mysql:mysql -p 8080:8080 zup/xy-inc-application
~~~~






Now, you're ready to test services with any HTTP client.



### Endpoints

| Method | Url | Decription |
| ------ | --- | ---------- |
| GET    |/xy-inc/api/interestpoint/list  | get all interest points |
| POST   |/xy-inc/api/interestpoint/create| save one interest point - request body {name:"Pub", x: 12, y: 8} |
| GET    |/xy-inc/api/interestpoint/nearby/{x}/{y}/{dmax}    | get interest points near by |

### Frameworks

| Name | Site |
| ------ | --- |
| Spring boot | https://projects.spring.io/spring-boot/ |
| Flywaydb | https://flywaydb.org/ |
| Hibernate validator | http://hibernate.org/validator/ |




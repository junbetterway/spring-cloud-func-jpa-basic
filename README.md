# Java Spring Cloud Function Basic With Spring Data JPA
Please check out my previous __[tutorial](https://github.com/junbetterway/spring-cloud-func-basic)__ which provides a basic introduction on using __[Spring Cloud Function](https://spring.io/projects/spring-cloud-function)__. 

This time, we will integrate Spring Cloud Function with H2 database together with __[Spring Data JPA](https://spring.io/projects/spring-data-jpa)__. There will be two exposed endpoints for our previous __Account module__ - create and readAll. 

*__Note:__ We will use the __traditional bean definitions__ instead of the __functional bean style__ since the latter is not yet supported because the functional form of the embedded Servlet container has not yet been implemented - see __[SpringcloudfuncConfig](https://github.com/junbetterway/spring-cloud-func-jpa-basic/blob/main/src/main/java/com/junbetterway/serverless/springcloudfunc/config/SpringcloudfuncConfig.java)__.class on how we did this.*

```
@Configuration
@RequiredArgsConstructor
public class SpringcloudfuncConfig {

	private final AccountRepository repository;
	
	@Bean
	public CreateAccount createAccount() {
		return new CreateAccount(repository);
	}

	@Bean
	public ReadAllAccounts readAllAccounts() {
		return new ReadAllAccounts(repository);
	}
	
}
```

# Run the Spring Boot Application Using Spring Tool Suite (STS)
1. Download STS version 3.4.* (or better) from the [Spring website](https://spring.io/tools). STS is a free Eclipse bundle with many features useful for Spring developers.
2. Right-click on the project or the main application class then select "Run As" > "Spring Boot App"

# Test The Functions
Now one can invoke the two endpoints in any API tool such as Postman or cURL. Using cURL, we can call:
1. Create Account function by:

```
curl -H "Content-type: application/json" -X POST -d '{"name":"Jun King Minon", "balance": 12000}' http://localhost:8080/createAccount
```

2. Read ALL Accounts function by:

```
curl http://localhost:8080/readAllAccounts
```

*__Note:__ The endpoint is case-sensitive or else you will end up getting an error response similar to below:*

```
{
    "timestamp": "2021-02-28T14:08:07.816+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "",
    "path": "/readallAccounts"
}
```

## Powered By
Contact me at [junbetterway](mailto:jkpminon12@yahoo.com)

Happy coding!!!

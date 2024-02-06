## Backend Assessment

### Pre-requisities

To run the application you would require:

- [Java](https://www.azul.com/downloads/#zulu)
- [Temporal](https://docs.temporal.io/cli#install)
- [Docker](https://docs.docker.com/get-docker/)
- [Stripe API Keys](https://stripe.com/docs/keys)

### On macOS:

First, you need to install Java 21 or later. You can download it from [Azul](https://www.azul.com/downloads/#zulu) or
use [SDKMAN](https://sdkman.io/).

```sh
brew install --cask zulu21
```

You can install Temporal using Homebrew

```sh
brew install temporal
```

or visit [Temporal Installation](https://docs.temporal.io/cli#install) for more information.

You can install Docker using Homebrew

```sh
brew install docker
```

or visit [Docker Installation](https://docs.docker.com/get-docker/) for more information.

### Other platforms

Please check the official documentation for the installation of Java, Temporal, and Docker for your platform.

### Code

Download the code from above or clone it using
```sh
git clone https://github.com/NishantKumar-007/backend-engineer-assessment.git
```


### Stripe API Keys

Sign up for a Stripe account and get your API keys from the [Stripe Dashboard](https://dashboard.stripe.com/apikeys).
Then in `application.properties` file add the following line with your secret key.

```properties
stripe.api-key=sk_test_51J3j
```

## Run

You are required to first start the temporal server using the following command

```sh
temporal server start-dev
```

and then run the application using the following command at project source or using your IDE.

```sh
gradlew bootRun
```
Springboot application will start at [http://localhost:8080](http://localhost:8080/). To invoke the workflows we need [Postman](https://www.postman.com/downloads/) to send data to endpoints (to mimic user registered behaviour). Open postman and send POST request to -
```sh
http://localhost:8080/accounts
```
body parameters -
```sh
{
    "firstName":"Tom",
    "lastName":"Cruise",
    "email":"tom@test.com"
}
```
This will invoke the workflow and your temporal UI will start at [http://localhost:8233](http://localhost:8233/)

### Running Test
run following command at project root
```sh
gradlew test
```

## Implementation Approach
![Untitled-2024-02-06-0053](https://github.com/NishantKumar-007/backend-engineer-assessment/assets/61771311/c9c121df-bd29-4f73-b41d-dca3608ab13a)

### Major Changes 
- Created Workflow implementation
- Create Activity implementation
- Added Provider type and id to user details
- Creating customer using Strip API
- saving updated data to DB
- unit test for updated user fields

### Result
![result](https://github.com/NishantKumar-007/backend-engineer-assessment/assets/61771311/aba2afb2-5af7-486c-bf2b-6a4cf3975a56)

## Bonus
I have created another branch with 2 more important changes - [link](https://github.com/NishantKumar-007/backend-engineer-assessment/tree/feature)
- GET/POST endpoints return providerType and providerId along with other basic details.
- Can not create more than one user if email already exists

Note - reason for not including above features in main branch -> I didn't want to temper with original auto generated data there.

## Guides

The following guides illustrate how to use some features concretely:

- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Temporal Quick Start](https://docs.temporal.io/docs/quick-start)
- [Temporal Java SDK Quick Guide](https://docs.temporal.io/dev-guide/java)
- [Stripe Quick Start](https://stripe.com/docs/quickstart)
- [Stripe Java SDK](https://stripe.com/docs/api/java)

### Docker Compose support

This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

- postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)

Please review the tags of the used images and set them to the same as you're running in production.

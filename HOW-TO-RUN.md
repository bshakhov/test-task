# HOW TO RUN

## Quick start with Docker

1. In the CLI navigate to root folder of this project (where the file `docker-compose.yml` is located)
2. Run `docker-compose up`
3. Open the following URL in the browser: http://localhost:4200
4. If you want to see the changes that you apply in the source code reflected in the web site, you have to recreate the existing image. To make it, please add the --build parameter, `docker-compose up --build`.

## Run unit tests

- Frontend: Run command `ng test`
- Backend: Run command `gradle clean test`

## Run via IDE (IntelliJ IDEA)

In case it is necessary to run with the IDE, make sure the following requirements are met:

- Database: Run a PosgreSQL database on port 5432 and create an empty database `space_tours_in` with owning user `stiuser` (password `stipass`)
- Backend: Run with active profile "`development`" to prevent CORS issues with the frontend
- Frontend: Make sure to run `npm install` before running `ng serve`
- Propellant Markt Inc Mock: if the test API for this service is down or failing, a mockserver can be run (https://www.mock-server.com/mock_server/running_mock_server.html) using the expectations file from the `propellant-markt-inc-mock` folder. The `STI_PROPELLANT_BASEURI` environment variable must point to the running mockserver and passed to the Backend.

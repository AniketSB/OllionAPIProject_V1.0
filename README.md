# OllionAPIProject_V1.0
Automation test framework - Badges API for stackExchange

This test framework covers all the test cases for stackExchange badges API, it includes happy path scenarios as well as unhappy path scenarios.

Concepts Included Validation of different status codes of an API Validation of different status messages of an API Gradle Cucumber-JVM JUnit Spring Jackson

#Requirements To utilise this project, you need to have the following installed locally:

Gradle 6.3 JDK 17.0.7 plugins -- Cucumber for java Gherkin Lombok

#Usage The project is broken into separate feature file for each endpoint of an API. Each of these modules can be utilised independently and each module represents the test cases for the respective endpoint.

To run all modules/scenarios, navigate to src->test->java --> com.example.stackExchange --> double click TestRunner

To run tags specific test cases like @HappyPath or @UnhappyPath, navigate to TestRunner file and provide Tags as @HappyPath or @UnhappyPath and run test runner file as above.

You can also run the same tests using command from terminal ./gradlew clean build However you need to make sure the certificates are in place.

#Reporting

Running scenario Individually If you would like to run the scenario in isolation, you can run it just from feature file and can get the reports in either .html or .json format in target/cucumberReports folder.

All the requests and responses are logged in reports, currently log level is set at Info level but can be changed to debug level from logback.xml file.

Reports are kept as provided by default by cucumber plugin but this framework can be extended with plugins which can show reports with graph.


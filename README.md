# Selenium UI Automation — AutomationExercise

UI test automation project for authentication flows (registration and login) on https://automationexercise.com.

The project demonstrates Page Object Model design, TestNG test structure, Allure reporting, and CI execution in headless Chrome.
## Tech Stack
- Java 25
- Selenium WebDriver
- TestNG
- Maven
- Allure Reports
- GitHub Actions CI
- Chrome (headless in CI)
## Project Structure (Maven Standard)
```
selenium-automation-exercise
│
├─ .github
│   └─ workflows
│       └─ ui-tests.yml
│
├─ src
│   ├─ main
│   │   └─ java
│   │       └─ com/olena/automation/ui
│   │           ├─ BasePage.java
│   │           ├─ DriverWrapper.java
│   │           ├─ HomePage.java
│   │           ├─ LoginPage.java
│   │           ├─ SignupPage.java
│   │           ├─ AccountCreatedPage.java
│   │           └─ AccountDeletedPage.java
│   │
│   └─ test
│       └─ java
│           └─ com/olena/automation/ui
│               ├─ LoginTests.java
│               └─ RegistrationTests.java
│
├─ pom.xml
└─ README.md
```
## Test Coverage
- Successful user registration
- Successful login
- Login with incorrect email
- Login with incorrect password
- Login with empty fields
## Run Tests Locally
Requirements
- JDK 25
- Maven
- Chrome browser
## Run
```bash
mvn clean test
```
## Allure Reports
Generate and open report locally:
```bash
mvn allure:serve
```
In CI, the report is generated automatically and published to GitHub Pages.
## CI Pipeline
The pipeline:
- Runs UI tests in headless Chrome
- Generates Allure report
- Publishes report to GitHub Pages
- Keeps history of test runs
- Workflow file location:
```bash
.github/workflows/ui-tests.yml
```
## Implementation Highlights
- Page Object Model architecture
- Explicit waits with WebDriverWait
- Ad blocking via Chrome DevTools
- Test data generation with JavaFaker
- Headless browser execution in CI
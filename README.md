# Selenium QA Automation Project

## Overview
This project contains automated UI tests built using Selenium WebDriver, Java, TestNG, and the Page Object Model (POM) design pattern.

The purpose of this project is to automate and validate different UI functionalities available on the DemoQA website.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

## Implemented Features
### UI Test Scenarios
- Button interactions
    - Left click
    - Right click
    - Double click

- Broken links validation
    - Valid link navigation
    - Broken link validation

- Practice Form validation
    - Positive test scenario
    - Negative test scenarios
    - Required fields validation

- Modal Dialogs
    - Small modal verification

- Selectable elements
    - Option selection validation

## Framework Features
- Page Object Model (POM)
- Explicit waits
- Reusable methods
- Scroll utility method
- Retry mechanism for flaky tests using RetryAnalyzer

## Project Structure
```text
src
 ├── Base
 ├── Pages
 └── Tests
```

## How to Run the Project
1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Install Maven dependencies
4. Run TestNG test classes

## Future Improvements
- Add more automated test scenarios
- Implement API testing
- Improve reporting
- Add CI/CD integration

## Author
Pavle Djurdjevic
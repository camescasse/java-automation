# Java Selenium Automation

UI Automation project written in Java, using Selenium and TestNG for the website https://demoqa.com/.

## Getting Started

### Prerequisites

- Java Development Kit v.22 (JDK)

### Installing

1. Clone this repository
2. Navigate to the project directory
3. Install dependencies found in `pom.xml` using Maven or your preferred IDE

#### Optional

Create a file in root called `.properties` and copy the key/values from the `example.properties` file

| Key        | Description                                                                            |
|------------|----------------------------------------------------------------------------------------|
| `HOST`     | Defines stage/test environment host. Defaults to production.                           |
| `BROWSER`  | Defines which Web Browser to use on your machine (eg. `chrome`, `firefox`, etc).       |
| `HEADLESS` | Determines whether tests will run headless or not. Inputs allowed are `true`, `false`. |

> **Notes:**
>
>`BROWSER` and `HEADLESS` values are case-insensitive.
> 
>`BROWSER` defaults to `chrome`.
> 
> `HEADLESS` defaults to `true`.
> 
> Currently supported browsers are Chrome, Firefox and Edge.

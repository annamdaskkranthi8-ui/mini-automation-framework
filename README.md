# Mini Automation Framework

Selenium Automation Framework built using:

• Java  
• Selenium WebDriver  
• TestNG  
• Maven  
• Page Object Model (POM)

---

## Framework Features

✔ Page Object Model design  
✔ TestNG test execution  
✔ Data Driven Testing (DataProvider)  
✔ Retry Analyzer for failed tests  
✔ Screenshot capture on failure  
✔ Extent HTML Reports  
✔ Parallel Test Execution  
✔ ThreadLocal WebDriver (Thread-safe)  
✔ Config Reader for environment setup

---

## Project Structure

src
├── main
│   ├── java
│   │   ├── pages
│   │   │   └── BasePage
│   │   └── utils
│   │       ├── ConfigReader
│   │       ├── DriverFactory
│   │       ├── ExtentManager
│   │       └── ScreenshotUtil
│   └── resources
│       ├── config.properties
│       └── log4j2.xml
│
└── test
├── java
│   ├── base
│   │   └── BaseTest
│   ├── pages
│   │   ├── LoginPage
│   │   ├── ProductsPage
│   │   ├── CartPage
│   │   └── CheckoutPage
│   ├── tests
│   │   ├── LoginTest
│   │   ├── CartTest
│   │   └── CheckoutTest
│   └── utils
│       ├── TestData
│       ├── RetryAnalyzer
│       └── ExtentTestListener

---

## Test Execution

Run tests using:

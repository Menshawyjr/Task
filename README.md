# 💼 E-Commerce Website Test Automation Framework

This project is a complete test automation framework built using **Selenium**, **Java**, **TestNG**, and **Maven**, designed to test critical user journeys and perform security validations on the Magento e-commerce website.

> ✅ URL Under Test: [https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html]

---

## 📦 Tech Stack

- **Language**: Java
- **Framework**: TestNG
- **Automation Tool**: Selenium WebDriver
- **Build Tool**: Maven
- **Design Pattern**: Page Object Model (POM)
- **Driver Management**: WebDriverManager
- **Logging & Reporting**:
  - Custom Bug Logging (`BugLogger.java`)

---

## ✅ Test Scenarios Covered

### 🔍 Search Functionality
- Valid Product Search
- Invalid Product Search

### 📂 Cart Validation
- Confirming Product is Added to Cart

### 🔒 Security Validations
- SQL Injection Detection
- XSS Vulnerability Detection

🧾 Bug Logging

- Any failed test will automatically log a detailed bug in `dynamic_bugs_report.txt`.
- Each entry contains:
  - Title
  - Severity
  - Expected vs Actual
  - Steps to reproduce

---

 🚨 Security Focus

Includes essential vulnerability detection:
- SQL Injection
- Cross-Site Scripting (XSS)

If vulnerabilities are detected, the bug logger will capture them automatically.

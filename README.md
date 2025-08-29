# E-commerce Site Test Automation

Automated test framework for an e-commerce demo site using **Selenium WebDriver**, **Cucumber (BDD)**, and **JUnit/TestNG**.

---

## 🚀 Features
- BDD-style test scenarios with Cucumber.
- Page Object Model (POM) for maintainable code.
- Hooks for setup/teardown and screenshots on failure.
- Reusable driver factory for multiple browsers.
- Assertions for UI validations and search functionality.

---

## 🛠️ Tech Stack
- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit/TestNG**
- **Maven**

---

## 📂 Project Structure
src\
├── main/java/ecommerce/site/pages # Page classes (POM)\
├── test/java/ecommerce/site/steps # Step definitions\
├── test/java/ecommerce/site/hooks # Hooks (Before/After)\
├── test/resources/features # Cucumber feature files


---

## ▶️ How to Run
1. Clone the repository:
```bash
   git clone https://github.com/ToqaMuhammad6/E-commerce-BDD-with-Selenium.git
 ```
2. Navigate to the project folder:
```bash
    cd ecommerce-site-tests
```

3. Run tests with Maven:
```bash
  mvn test
```


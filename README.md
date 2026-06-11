# 🛒 Automation Test – Decathlon Website

## 📌 Project Overview
This project is a Selenium WebDriver automation framework developed using Java to automate and validate key functionalities of the Decathlon e-commerce website.

The framework follows a structured approach to perform end-to-end testing of user actions such as login, product search, and adding products to the cart.

## 🚀 Features
- User Login Automation
- Product Search Functionality Testing
- Add to Cart Validation
- Reusable Utility Functions
- Data-Driven Configuration using Properties File
- Automated Browser Execution
- Test Result Validation

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|----------|
| Java | Programming Language |
| Selenium WebDriver | Browser Automation |
| Eclipse IDE | Development Environment |
| TestNG | Test Execution Framework |
| Maven | Dependency Management |
| Git & GitHub | Version Control |

## 📂 Project Structure

```
automation-test-decathlon-site
│
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │
│   └── test
│       ├── java
│       │   └── decathlon
│       │       ├── login.java
│       │       ├── searchTheProduct.java
│       │       └── addToCart.java
│       │
│       └── resources
│
├── Driver
│
├── screenShot
│   ├── img1.png
│   └── img2.png
│
├── target
│
├── test-output
│
├── pom.xml
│
└── testng01.xml

```

## 🔧 Test Scenarios

### 1. Login Test
- Open Decathlon website
- Enter valid credentials
- Verify successful login

### 2. Search Product Test
- Search for a product
- Validate search results
- Verify product visibility

### 3. Add To Cart Test
- Select a product
- Add product to cart
- Verify cart update

## ▶️ How to Run the Project

### Prerequisites
- Java JDK 8 or above
- Eclipse IDE
- Maven
- Chrome Browser
- ChromeDriver

### Steps

1. Clone the repository

```bash
git clone https://github.com/devabharathi13/automation-test-decathlon-site.git
```

2. Open project in Eclipse

3. Update Maven Dependencies

```bash
Right Click Project → Maven → Update Project
```

4. Configure `data.properties`

```properties
url=https://www.decathlon.in
username=your_email
password=your_password
```

5. Run TestNG Suite or Individual Test Classes

## 📊 Test Automation Workflow

```
Launch Browser
       ↓
Open Decathlon Website
       ↓
Login
       ↓
Search Product
       ↓
Select Product
       ↓
Add To Cart
       ↓
Validate Results
       ↓
Close Browser
```

## 📸 Sample Automated Functions

- Login Validation
- Product Search
- Add Product to Cart
- Property File Handling
- Browser Launch and Close

## 📈 Future Enhancements

- Extent Reports Integration
- Screenshot Capture on Failure
- Page Object Model (POM)
- Data-Driven Testing using Excel
- Cross Browser Testing
- CI/CD Integration with GitHub Actions

## 👩‍💻 Author

**Deva Bharathi**

- GitHub: https://github.com/devabharathi13
- Java Selenium Automation Tester

## 📄 License

This project is developed for educational and learning purposes.

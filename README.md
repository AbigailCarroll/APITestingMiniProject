# API Testing Mini Project

An API testing framework for [Automation Excersise](https://automationexercise.com/api/)

### Which end points are tested?
- /productsList
- /brandsList
- /searchProduct
- /verifyLogin
- /createAccount
- /deleteAccount
- /updateAccount
- /getUserDetailByEmail

### How to run test? (when using intelliJ)
- Navigate to the src/test/restassured directory
- Right click on the folder
- Click "Run tests in 'restassured'"

### How to add new tests?
- Navigate to an existing class and create a method or create a new class inside the src/test/restassured directory
- If creating a new class, ensure you use a @BeforeAll setup method that retrieves a response from the api
- Create a test method with @Test bean
- Implement the test

### Defects found:
- Status code inside header of response can be different to responses status code in json (productList endpoint).

### Config:
Java version: 22

Dependencies: 
- jackson-xml
- rest-assured
- junit5
- gson simple

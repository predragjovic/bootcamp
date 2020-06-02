FinalProjectItBootcamp


FinalProjectItBootcamp is used for testing functionalities:
Target application URL is: https://petstore.octoperf.com/.

Browsers:

Chrome Browser version: 79.0.3945.36

Run test suite: TestNg.xml

Total tests run: 16

Used libraries:
TestNG automation testing framework
Selenium portable framework for testing web applications
Apache POI

The following website functionalities are tested:
Enter the store
Check URL status for all links
Go to all links and check are we going to the right page
Sign in
Logout
Testing registration whit Apache poi (Excel tabel, sheet users)
Select from the dropdown menu
Checkbox functionality
Adding all items in the Cart (Excel tabel, sheet cart_items)
Check are all items added to cart
Delete all cookies
Check if cart is empty
Using soft assert

This project contains 3 packages:
Pages
Tests
Utilis


Package Pages contains 6 classes:
CartPage
HomePage
PetStoreMenuPage
RegistrationPage
SignInPage
StoreItemPage

Package Tests contains 5 classes:
CartTest
HomePageTest
PetStoreMenuPageTest
RegistrationPageTest
SignInPageTest

Package Utilis contains 1 class:
ExcelUtils

Folder data contains 1 xlsx file
pet-store-data.xlsx

Folder Config contains
jpetstore.properties

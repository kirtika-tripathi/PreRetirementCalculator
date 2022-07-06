# PreRetirementCalculator
This application uses TestNG framework to automate the following Pre-retirement calculator application.
URL: https://www.securian.com/insights-tools/retirement-calculator.html

 
# Framework and Pattern used
TestNG: It is an open-source test automation framework for Java. It is developed on the same lines of JUnit and NUnit.

Page Object Model:
Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements. It is useful in reducing code duplication and improves test case maintenance. In Page Object Model, consider each web page of an application as a class file.


The application tests three different scenarios mentioned in PreRetirementCalculatorTest.java class:

 - The test 'formSubmissionWithoutSocialBenefitsNoAdjustments' is happy path which tests the calculator without Social benefits and no default adjustments.
 - The test 'formSubmissionWithSocialBenefitsNoAdjustments' tests the calculator with Social benefits but no default adjustments.
 - The test 'formSubmissionWithSocialBenefitsAndAdjustments' tests the calculator with Social benefits and with default adjustments.
 
The application uses Constants.java to store the test data, config properties and other constants.

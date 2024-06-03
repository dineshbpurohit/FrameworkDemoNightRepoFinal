Feature: Application Login

Scenario: Login with valid credentials

Given open any browser
And Navigate to login page
When User enters username as "dinesh@yopmail.com" and password as "Welcome@11" in to fields
And User clicks on login button
Then Verify user is able to successfully login
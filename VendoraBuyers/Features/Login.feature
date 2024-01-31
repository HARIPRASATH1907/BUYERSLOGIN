Feature: Login


Scenario: Successful Login with Valid Credentials
Given User Launch Chrome browser
When User opens URL "https://angleritech.co.in/Vendora/buyer/users/login?redirect=%2Fbuyer%2F%3Furl%3Dbuyer%252F"
And User enters Username as "juliet" and Password as "angleritech"
And Click on Login
Then Page Title should be "Dashboard | Vendor Portal"
When User click on Signout link
Then Page Title should be "Login | Vendor Portal"
And close browser



Scenario Outline: Login with Invalid Credentials
Given User Launch Chrome browser
When User opens URL "https://angleritech.co.in/Vendora/buyer/users/login?redirect=%2Fbuyer%2F%3Furl%3Dbuyer%252F"
And User enters Username as "<username>" and Password as "<password>"
And Click on Login
Then Error Message Should be "Your username or password is incorrect."
And close browser

Examples:
      |username|password|
      |juliet | #%&&&%%%|
      |juliet |1234567|
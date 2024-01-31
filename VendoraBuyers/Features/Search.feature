Feature: Search

Background: Below are the common steps for each scenario
Given User Launch Chrome browser
When User opens URL "https://angleritech.co.in/Vendora/buyer/users/login?redirect=%2Fbuyer%2F%3Furl%3Dbuyer%252F"
And User enters Username as "juliet" and Password as "angleritech"
And Click on Login
When User click on Reports Menu





Scenario: Search Based On Location


When click on pending POs Menu Item
When click on Show Filter button
And Select Delivery Location and Click Filter Button
Then User should found Pending POs in the Search Table with respect to the Delivery Location Entered
And close browser



Scenario: Search Based on Vendor

When click on pending POs Menu Item
When click on Show Filter button
And Select Vendor and Click Filter Button
Then User should found Pending POs in the Search Table  with respect to the Vendor Name Entered
And close browser

   

Scenario: Take Screenshot of Pending POs Overall Report

And Click on Pending POs Overall Report
Then Take Screenshot Of Pending POs Overall Report 
And close browser


@ourplans
Feature:To test Our Plans drop down in AARP site
Scenario:To verify menu under drop down of Our Plans link  in AARP site
Given I am a user who has navigated to a page on the ULAYER acquistion site
When I hover over the Our Plans button
Then drop down column 1 should appear with the following in order - Find all plans in your area header, Enter ZIP field, Find Plans button, Need Help content, Need Help Link, Find right plan header, take quiz button
Then user validates all the content and links in the Our Plans drop down
#And content appears in column 1 per copy deck
When I click find ZIP link
When I DON'T enter a ZIP and I click Find Plans button
Then error message should be appeard
#When I click on either user name and/or password fields and enters a character then text in the boxes should disappear
When I DON'T enter 5 numbers in the ZIP and I click Find Plans button
Then error message should appear
When I enter 5 numbers and I click Find Plans button
Then I am navigated to view plans link
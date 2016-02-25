@headerBLayerAlreadyMemberOneTest
Feature:To test Already a Member Sign in button in UMS site
Scenario:To verify Already a plan member drop down displayed on the Brand section of UMS site
Given the user is on the UHC Medicaresolutions Site
Then the Already a Member button should display in it's inactive state light blue button
#And user clicks Already a member button in its inactive state
#And user clicks and enters invalid user ID or password in the fields
#And user clicks sign in button
#And user clicks on forgot your username or password link of UMS site
#And user switches back to acquisition home page of UMS Site
#And user clicks on register here link of UMS site

#And user switches back to acquisition home page of UMS Site from Registration page
#Scenario: To verify the successful sign in
#Given the user is on the UHC Medicaresolutions Site
Then user clicks on Already a member button in its inactive state on the Brand section of UMS site
And user enters a valid user id or password
And user clicks sign in button after entering valid credentials
Then user should be logged into their account and land on their home page


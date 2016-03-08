@global
Feature:To test Global Header links in UMS site
Scenario:To verify links displayed in Global Header section in UMS site
Given the user is on the UHC Medicaresolutions Site
When user accesses global header UHC Medicaresolutions Site
And user clicks on the Important Disclosures link on UHC Medicaresolutions Site page
And user clicks on the UnitedHealthCare logo on UHC Medicaresolutions Site page
And user clicks on home link in navigation section on UHC Medicaresolutions Site page
And user clicks text  in global search field in navigation section on UHC Medicaresolutions Site page
Then user validates the Brand Section items on UHC Medicaresolutions Site page

Scenario:To verify Already a plan member dropdown displayed on the Brand section of UMS site
Given the user is on the UHC Medicaresolutions Site
When the header is rendered, the Already a Member button should display in it's inactive state on the Brand section of UMS site
And user clicks on Already a member button in its inactive state on the Brand section of UMS site
And user clicks on user name, password text field in the Already a plan member drop down of UMS site
And user clicks on forgot your username or password link of UMS site
And user switches back to acquisition home page of UMS Site
And user clicks on register here link of UMS site
Then user validates all the elements in the Already a plan member drop down of UMS site

Scenario:To verify error message of sign in button under Already a plan member dropdown displayed on the Brand section of UMS site
Given the user is on the UHC Medicaresolutions Site
When the user clicks on Already a member button on the Brand section of UMS site
And user enters invalid user name, password text field in the Already a plan member drop down of UMS site
Then user clicks on sign in button and validate the error message in Already a plan member drop down of UMS site

		 

Scenario:To verify sign in button functionality under Already a plan member dropdown displayed on the Brand section of UMS site
Given the user is on the UHC Medicaresolutions Site
When the user clicks on Already a member button on the Brand section of UMS site
And user enters valid user name, password text field in the Already a plan member drop down of UMS site
Then user clicks on sign in button and validates if it is landed on member my account home page of UMS site
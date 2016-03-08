@global
Feature:To test Brand section of AARP site header
Scenario:To verify links displayed in the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When user accesses brand section of the AARP Medicare Plans home page
Then user validates all the links in brand section
And user clicks on Important Disclosures link of AARP Medicare Plans home page
And user clicks on AARP logo on Disclaimer page
And user clicks on visit AARP org link of Home page

Scenario:To verify Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the header is rendered, the Already a Member button should display in it's inactive state on the Brand section of AARP site
And user clicks on Already a member button in its inactive state on the Brand section of AARP site
And user clicks on user name, password text field in the Already a plan member drop down of AARP site
And user clicks on forgot your username or password link of AARP site
And user switches back to acquisition home page of AARP Site
And user clicks on register here link of AARP site
Then user validates all the elements in the Already a plan member drop down of AARP site


Scenario:To verify error message of sign in button under Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the user clicks on Already a member button on the Brand section of AARP site
And user enters invalid user name, password text field in the Already a plan member drop down of AARP site
Then user clicks on sign in button and validate the error message in Already a plan member drop down of AARP site

		 

Scenario:To verify sign in button functionality under Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the user clicks on Already a member button on the Brand section of AARP site
And user enters valid user name, password text field in the Already a plan member drop down of AARP site
Then user clicks on sign in button and validates if it is landed on member my account home page of AARP site

Scenario:To verify timer/visitor cookie scenarios under Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the user clicks on Already a member button on the Brand section of AARP site
And user enters valid user name, password text field in the Already a plan member drop down of AARP site
And user reloads the AARP site page and accesses, validates  active state of Already a member dropdown and checks for cookie timer and cookie in browser of AARP site
Then user waits for the time mentioned in the cookie timer and validates if the already member dropdown is inactive in AARP site

Scenario:To verify timer/visitor cookie scenarios under Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the user clicks on Already a member button on the Brand section of AARP site
And user enters valid user name, password text field in the Already a plan member drop down of AARP site
Then user clicks on the page and validates if the timer has stopped in browser of AARP site

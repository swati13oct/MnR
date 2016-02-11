@headerUlayer
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



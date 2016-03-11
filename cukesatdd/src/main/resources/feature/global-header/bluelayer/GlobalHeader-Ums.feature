@headerFooterTest
Feature:To test Global Header links in UMS site

Scenario:To verify links displayed in Global footer section in UMS site
Given the user is on the UHC Medicaresolutions Site
When user accesses global footer UHC Medicaresolutions Site
And the user clicks on Sitemap link from home page footer UHC Medicaresolutions Site
And the user clicks on Aboutus link from home page footer UHC Medicaresolutions Site
And the user clicks on Contactus link from about us page footer UHC Medicaresolutions Site
And the user clicks on Privacy Policy link from Contactus page footer UHC Medicaresolutions Site
And the user clicks on Terms of use link from Privacy Policy page footer UHC Medicaresolutions Site
And the user clicks on Disclaimers link from Terms of use page footer UHC Medicaresolutions Site
And the user clicks on Agents & Brokers link from Disclaimers page footer UHC Medicaresolutions Site
And user clicks on home link of agents&brokers page bluelayer
And user clicks on medicare advantage plans link from footer of the uhc medicare solutions home page
And user clicks on medicare supplement insurance plans link from footer of the medicare advantage plans page bluelayer
And user clicks on medicare prescription drug plans link from footer of the medicare supplement plans page bluelayer
And user clicks on medicare special needs plans link from footer of the medicare supplement plans page bluelayer
And user clicks on Learn About Medicare link from footer of the medicare special needs plans page bluelayer
And user clicks on Prepare For Initial Enrollment link from footer of the Learn About Medicare page bluelayer
And user clicks on Explore Changing plans link from footer of the Prepare For Initial Enrollment page bluelayer
And user clicks on Discover More Resources link from footer of the Explore Changing plans page bluelayer
And user clicks on Home link from footer of the discover more resources page bluelayer
And user clicks on view disclaimer information section links from footer of the UHC Medicare Solutions home page
Then the user validates links in the global footer in UHC Medicaresolutions Site

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

Scenario:To verify all the links displayed in Our Plans drop down of UMS site
Given the user is on the UHC Medicaresolutions Site
When user hovers on Our Plans section of the UHC Medicare Solutions home page
Then user validates all the content and links in the Our Plans drop down
And user clicks on medicare advantage plans link of our plans drop down from home page of blue layer
And user clicks on medicare advantage Request Personal Help & Information link of our plans drop down from medicare advantage plans page of blue layer
And user clicks on Medicare Prescription Drug Plans link of our plans dropdown from medicare advantage Request More Information page of blue layer
And user clicks on Prescription Drug Request Personal Help & Information link of our plans drop down from Medicare Prescription Drug Plans page blue layer
And user clicks on Medicare Supplement Plans link of our plans drop down from Prescription Drug Request more information page bluelayer
And user clicks on Medicare Select Hospital Directory link under Medicare Supplement Plans section of our plans drop down from Medicare Supplement Plans page
And user clicks on Resume Your Saved Application link under Medicare Supplement Plans section of our plans drop down from Medicare Select Hospital Directory page
And user clicks on medicare special needs plan from UHC Medicare Solutions home page
And user clicks on get enrollment information link from medicare special needs plan page of bluelayer
And user clicks on Take the quiz button from our plans drop down of blue layer
And user clicks the zipcode text field of ourplan drop down blue layer
And user clicks on lookup zipcode link of our plan drop down blue layer

Scenario:To verify links displayed in Our Plans Drop Down in UMS site
Given the user is on the UHC Medicaresolutions Site
When user accesses Medicare Education section UHC Medicare Solutions Site
And user clicks on LearnAboutMedicare link by hovering on Medicare Education of the UHC Medicare Solutions home page
And user clicks on ExploreChangingPlans link by hovering on Medicare Education of the UHC Medicare Solutions home page
And user clicks on PrepareForInitialEnrollment link by hovering on Medicare Education of the UHC Medicare Solutions home page
And user clicks on DiscoverMoreResources link by hovering on Medicare Education of the UHC Medicare Solutions home page
Then the user validates all links in the medicare education drop down of UMS site



Scenario Outline:To verify if Error message is displayed when invalid zipcode is entered
Given the user is on the UHC Medicaresolutions Site
And user enter the below zipcode from home page in blue layer
	| <zipCode> |
Then the user validates the error message displayed

Examples:
| zipCode |
| 		  |  
| 9021	  |
| abc     |


Scenario:To verify sign in button functionality under Already a plan member dropdown displayed on the Brand section of UMS site
Given the user is on the UHC Medicaresolutions Site
When the user clicks on Already a member button on the Brand section of UMS site
And user enters valid user name, password text field in the Already a plan member drop down of UMS site
Then user clicks on sign in button and validates if it is landed on member my account home page of UMS site

Scenario:To verify timer/visitor cookie scenarios under Already a plan member dropdown displayed on the Brand section of UMS site
Given the user is on the UHC Medicaresolutions Site
When the user clicks on Already a member button on the Brand section of UMS site
And user enters valid user name, password text field in the Already a plan member drop down of UMS site
And user reloads the UMS site page and accesses, validates  active state of Already a member dropdown and checks for cookie timer and cookie in browser of UMS site
Then user waits for the time mentioned in the cookie timer and validates if the already member dropdown is inactive in UMS site

Scenario:To verify timer/visitor cookie timer stop scenarios under Already a plan member dropdown displayed on the Brand section of UMS site
Given the user is on the UHC Medicaresolutions Site
When the user clicks on Already a member button on the Brand section of UMS site
And user enters valid user name, password text field in the Already a plan member drop down of UMS site
Then user clicks on the page and validates if the timer has stopped in browser of UMS site

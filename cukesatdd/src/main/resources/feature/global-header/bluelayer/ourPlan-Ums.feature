@headerOurPlansNavBlueLayer
Feature:To test Our Plans drop down navigation in UMS site
Scenario:To verify links displayed in Our Plans drop down of UMS site
Given user is on the home page of UMS Site
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



Scenario Outline:To verify if Error message is displayed when invalid zipcode is entered
Given user is on the home page of UMS Site
And user enter the below zipcode from home page in blue layer
	| <zipCode> |
Then the user validates the error message displayed

Examples:
| zipCode |
| 		  |  
| 9021	  |
| abc     |




Scenario Outline:To verify if user is navigated to our plans page after entering valid zipcode
Given user is on the home page of UMS Site
And user clicks on findplans button by providing below valid zipcode
	| <zipCode> |

Examples:
| zipCode |
| 90210   |
@mymedicamobile
Feature: Test case for My MEDICA Mobile site

  Scenario Outline: To Verify the My MEDICA  Mobile site AboutUs contact us and Sign in page navigation
    Given the user is on the My MEDICA mobile site landing page
 #   Given the user is on registration page of My Medica mobile site1
#Given the user clicks on back button from  My Medica mobile site registration page
#Given the user is on password assistance page of My Medica mobile site1


When the user logs in with a registered UMS with following details in Medica site
	| Plan Type   | <planType>  |
Then the user validates plan and member details on benefits summary page in Medica site 

Examples:
	| planType |
	| MAPD     |
	



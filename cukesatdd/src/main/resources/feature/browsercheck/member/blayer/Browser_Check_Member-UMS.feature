@memberBrowserCheck
Feature: To test Browser check on member UMS site
Scenario: To Verify the Pages of template in the browser for member site
Given the user is on the UMS Member site landing page
When the user is on the UMS Member home page
Then the user validates unsupported error message on the browser


Scenario Outline: To Verify the Pages of template in the browser for Uhcm member site
Given the user is on the UMS Member site landing page
When the user logs in with a registered UMP with following details in member UHC medicare site
	| Plan Type   | <planType>  |
Then the user validates unsupported error message after login in UHC medicare site

	Examples:
	| planType |
	| MAPD     |
#	| MA       |

Scenario Outline: To Verify the Page of Generic template in the browser
Given the user is on the UMS Member site landing page
When the user logs in with a registered UMP with following details in member UHC medicare site
	| Plan Type   | <planType>  |
And the user navigates to plan summary page in UHC site
Then the user validates unsupported error message after login in UHC medicare site
 
	Examples:
	| planType |
	| MAPD     |


Scenario Outline:To Verify the Page of right rail template in the browser
Given the user is on the UMS Member site landing page
When the user logs in with a registered UMP with following details in member UHC medicare site
	| Plan Type   | <planType>  |
And the user navigates to drug search in UHC site
Then the user validates unsupported error message after login in UHC medicare site

	Examples:
	| planType |
	| MAPD     |

Scenario Outline:To Verify the Page of blayer contactus  template in the browser
Given the user is on the UMS Member site landing page
When the user logs in with a registered UMP with following details in member UHC medicare site
	| Plan Type   | <planType>  |
And the user navigates to contact us page in UHC site
Then the user validates unsupported error message after login in UHC medicare site

 
	Examples:
	| planType |
#	| PDP      |
	| MAPD     |

Scenario: To Verify the Pages of Banner template in the browser for member Aarp site
Given the user is on the UMS Member site landing page
When the user logs in with a registered UMP with following details in member UHC medicare site
	| Plan Type   | <planType>  |
And user is on UMS error page
Then the user validates unsupported error message after login in UHC medicare site

	Examples:
	| planType |
	| MAPD     |

Scenario: To Verify the Pages of Registration template in the browser for member Aarp site
Given the user is on the UMS Member site landing page
When the user is on the UMS Member home page
And user navigates to login assistance page from member UHC site
Then the user validates unsupported error message after login in UHC medicare site


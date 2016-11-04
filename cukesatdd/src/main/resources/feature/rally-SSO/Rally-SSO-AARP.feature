@RallySSO
Feature:Testing with Test Harness for Rally SSO
Scenario Outline:Validating Provider search flow with myuhc Test Harness
Given user login to AARP member site
|Username|<username>|
|Password|<password>|
When user clicks on medical providers link on myaccount home page of ulayer
And user logs in to myuhc site
When user provides required details for ulayer on test harness page of MYUHC
|Adapter 	 |<adapter> |
|ClientId	 |<clientId>|
|State   	 |<state>   |
|ClientSecret|<clientSecret>|
And user decodes the generated token
Then user validates the generated token for ulayer


Examples:
|username 	   |password  |adapter 		 	 |clientId            |state 				 |clientSecret													   |
|Dec_ulayer001 |Password@1|devulayer	 	 |stage-uhcmnr-digital|portalSource=mnr_aarpm|92KEbzt3y2FlW2W1Hrk60hYm40zSZl2HmQ5RFOG8O1029qVCJBOhDsF8ixMRHPd0 |
@RallySSO
Feature:Testing with Test Harness for Rally SSO
Scenario Outline:Validating Provider search flow with myuhc Test Harness
Given user login to UHCMedicaresolutions member site
|Username|<username>|
|Password|<password>|
|Category|<category>|
When user clicks on medical providers link on myaccount home page
And user logs in to myuhc site
When user provides required details on test harness page of MYUHC
|Adapter 	 |<adapter> |
|ClientId	 |<clientId>|
|State   	 |<state>   |
|ClientSecret|<clientSecret>|
And user decodes the generated token
Then user validates the generated token


Examples:
|username 	   |password  |category |adapter 		 |clientId            |state 				|clientSecret													  |
|sep_group054  |Password@1|Group    |mrdevbluelayer	 |stage-uhcmnr-digital|portalSource=mnr_uhcm|92KEbzt3y2FlW2W1Hrk60hYm40zSZl2HmQ5RFOG8O1029qVCJBOhDsF8ixMRHPd0 |
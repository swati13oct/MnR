@RallytoolAARPMember
Feature:To launch Rally tool from AARP Member Pages
Scenario Outline:To verify rallytool for registered member on AARP ulayer
Given user is in AEP period
|Month|<month>|
|Date|<date>|
|Year|<year>|
|Hours|<hours>|
|Minutes|<min>|
|Seconds|<seconds>|
And user launches the AARP Ulayer member sites and logged in with valid credentials
|Username|<username>|
|Password|<password>|
Then user clicks on search provider link and rallytool launches in new tab 

Examples:
	|username	  |password  |month|date|year|hours|minutes|seconds|
	|jul_ulayer002|Password@1|10   |01  |2016|01   |00     |00     |  
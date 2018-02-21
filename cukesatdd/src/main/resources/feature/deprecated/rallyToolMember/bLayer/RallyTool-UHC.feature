@RallytoolUHCMember
Feature:To launch Rally tool from AARP Member Pages
Scenario Outline: To verify rallytool for registered member on UHC ulayer
Given registered UHC member with following details rally tool integration
	| Plan Type   | <planType> |
	| Member Type | <memberType> |
Then user clicks on search provider link and rallytool launches in new tab

Examples:
	|planType	    |memberType  | 
	|MAPD         |Group       |
	
#US289501
Scenario Outline: To verify rallytool for registered member on UHC from Plan Benefits and Coverage
Given registered UHC member with following details rally tool integration
	| Plan Type   | <planType> |
	| Member Type | <memberType> |
Then the user navigates to plan and coverage page and validates RallyTool
|pageName|<>|
Examples:
	|planType	    |memberType  | 
	|MAPD         |Group       |
	|MA           |Group       |

#US289735
Scenario Outline: To verify rallytool for registered member on UHC from Forms and Resources
Given registered UHC member with following details rally tool integration
	| Plan Type   | <planType> |
	| Member Type | <memberType> |
Then the user navigates to forms and resources page and validates RallyTool
|pageName|<>|
Examples:
	|planType	    |memberType  | 
	|MAPD         |Group       |
	|MA           |Group       |
	
 
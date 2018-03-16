@smokeTest
Feature: 1.05-VBF-MemRedesign-To test EOB functionality
@smokeTest_EOB @rallyDashboard @testharness
Scenario Outline: Validate that member can search for eob statement
Given I am a authenticated member on the member redesign site for EOB
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
	| EOB Type		 |<eobType>|
When the above plantype user logs in member redesign for EOB
Then the user navigates to EOB page  
And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type			 |<eobType>|
Then the user validates EOB count
Then the user validates EOB statments displayed
#Then the user validates site leaving pop up  	
Examples:
	| planType  | memberType           |dateRange		  | eobType 		  |
	| MAPD      | UHCIndividualEOB     |18 Months		  | Medical 		  |          
	| MAPD      | UHCIndividualEOB     |18 Months		  | Prescription Drug | 
#	| MAPD      | AARPIndividualEOB    |18 Months		  | Medical 		  | 
#	| MAPD      | AARPIndividualEOB    |18 Months		  | Prescription Drug | 
#	| MAPD      | GroupRetireeEOB      |18 Months		  | Medical           | 
#	| MAPD      | GroupRetireeEOB      |18 Months		  | Prescription Drug | 

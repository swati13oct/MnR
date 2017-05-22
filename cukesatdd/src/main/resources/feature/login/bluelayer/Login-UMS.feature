@login
Feature: To test Login on UMS site 
Scenario Outline:To verify login in UHC site
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMP with following details in UHC site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
Then the user validates plan and member details after login in UHC site

Examples:
	| planType | memberType |
#	| MA       | Individual |
#	| MA       | Group      |
	| MAPD     | Individual |
#	| MAPD     | Group      |
#	| PDP      | Group      |

Scenario Outline: Verify login in UHC site for group plan member 
Given registered UHC member with following attributes
	| <planType>        |
	| Group      |
When the user logs in successfully in UMS site
Then the user validates following plan details in UMS site
     | Plan Name     |
     | Group Id      |
     | Member Number | 
     | Plan Status   |
Examples:
     | planType |
 #   | MA       |
 #   | MAPD     |
 #    | PDP      |
 #   | SSUP     |
 #   | SSRD     |




Scenario Outline: Verify login in UHC site for a terminated member less than 12 months
Given registered UHC member with following attributes
	| <planType>               |
	| <memberType>             |
	| Term less than 12 months |
When the user logs in successfully for terminated member in UHC site
Then the user validates following UHC terminated plan details
   | Plan Name             |
   | Member Number         |
   | Plan Termination Date |

Examples:
       | planType   | memberType  |
 #	   | MA         | INDIVIDUAL  | 
 #	   | MA         | GROUP       | 
 #	   | MAPD       | INDIVIDUAL  | 
 #	   | MAPD       | GROUP       |
 #	   | PDP        | GROUP       |
 #	   | SSUP        | GROUP       | 



Scenario Outline: Verify login in UHC site for a terminated member greater than 12 months
Given registered UHC member with following attributes
	| <planType>                  |
	| <memberType>                |
	| Term greater than 12 months |
When the user logs in successfully in UHC site
Then the user validates the UHC plan inactive error
   | Plan Inactive Error |
Examples:
  	 | planType  | memberType |
#	 | MAPD      | GROUP      |
#    | MA        | GROUP      |
#    | MA        | INDIVIDUAL | 
#    | MAPD      | INDIVIDUAL |
#    | PDP       | GROUP      |
#    | SSUP       | GROUP      |


Scenario Outline: Verify login in UMS site for combo group plan member for active member
Given registered UHC member with following attributes
 | <planType1> |
 | <planType2> |
When the user logs in successfully in UMS site
Then the user validates following plan detail
     | Plan Name     |
     | Group Id      |
     | Member Number | 
     | Plan Status   |
Examples:
     | planType1 | planType2  |
#    | PDP       | SSUP       |
    
    
    
Scenario Outline: Verify login in UHC site for combo group plan member for a terminated less than 12 months
Given registered UMS member with following attributes
 | <planType1> |
 | <planType2> |
 | Term less than 12 months | 
When the user logs in successfully in UMS site
Then the user validates following Group plan Details in UMS site
     | Plan Name     |
     | Group Id      |
     | Member Number | 
     | Plan Status   |
Examples:
     | planType1      | planType2    |
#    | PDP terminated | SSUP active  |  
#    | SSUP terminated| PDP active   |
 
 
 
Scenario Outline:To verify login in UHC site to validate temp print id card
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMP with following details in UHC site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
Then the user validates temp id card pop up after login in UHC site

Examples:
	| planType | memberType |
	| MAPD     | Individual |
	
	
@login
Feature: To test Login on UMS site 
Scenario Outline:To verify login in UHC site
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMP with following details in UHC site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
Then verify that the tabs are displayed
And verify that links are displayed
And click on plan name link and my Plans-Summary page should be displayed
And click on back button in the browser and Home page should be displayed
And validate provider search not displayed for PDP and for other member, click on search for providers button and Provider search modal window should be displayed 
And click on back button in the browser and Home page should be displayed
And click on Drug lookup-estimate costs button and estimate my drug costs page should be displayed
And click on back button in the browser and Home page should be displayed
And click on locate a pharmacy button and Locate a pharmacy page should be displayed
And click on back button in the browser and Home page should be displayed
And click on View Personal Health Record button and My Personal Health Record page should be displayed
And click on back button in the browser and Home page should be displayed
And click on View Health & Wellness button and My Health and Wellness page should be displayed
And click on back button in the browser and Home page should be displayed

Examples:
	| planType | memberType |
	| PDP	   | Group		|
	| MA       | Individual |

@eob
Feature:To test EOB on Dashboard page

@fixed
Scenario Outline: Allowed Domains – Authors need ability to define messages and domains for leaving member sites (ATDD)
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page 
Then the user validates site leaving pop up         
Examples:
       | planType  | memberType        |  
       | MAPD      | q4_dec_aarp018  	 |    
 			  
@workingOn
Scenario Outline: To validate EOB Type Drop-Down
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page	
Then the user validates EOB type and Date Range for MAPD
  | Plan Type      |<planType>  |
 
Examples:
       | planType  | memberType              |  
       | MAPD      | q4_dec_aarp018		       |
 			 
       
     	
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
       | MAPD      | q4_dec_uhc002  	 | 
       | PDP			 | q4_dec_aarp292		 |
       | MA				 | q4_dec_aarp507	   |   
 			  
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
       | MAPD      | q4_dec_aarp441		       |

@eobPdf       
Scenario Outline: To verify How to read a medical EOB PDF
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page
And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type			 |<eobType>|
And the user validates how to read medical eob PDF
 	Examples:
	| planType  | memberType        |dateRange			| eobType |
	| MAPD      | q4_dec_uhc002     |Last 18 months		  | Medical |
       
       
 @validateEOBStatements      
 Scenario Outline: To verify How to read a medical EOB PDF
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page	
And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type			 |<eobType>|
Then the user validates EOB statments displayed 	
Examples:
	| planType  | memberType        |dateRange			| eobType |
	| MAPD      | q4_dec_uhc002     |Last 18 months | Medical |
	| PDP	      | q3_sep_rxulayer001     |Last 18 months | Medical |
	
       
Scenario Outline: To verify EOB result list
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page	
And the user validates EOB statments displayed
	Examples:
	| planType  | memberType   				| eobTypeData       | fromDate   | toDate     |dateRange       |
 	| PDP      | q3_sep_rxulayer001  | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
  | MAPD       | q4_dec_uhc002			  | Medical           | 12/12/2007 | 12/12/2008 |Last 6 months   |
 	
 	
 	
 	
     	
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
	| MAPD      | q4_dec_uhc002     |Last 6 months		  | Medical |
	| MAPD      | q4_dec_uhc002     |Last 18 months		  | Prescription |
	| MAPD      | q4_dec_uhc002     |Last 90 days 		  | Prescription |
	
	
       
       
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
	| MAPD      | q4_dec_uhc002     |Last 6 months | Medical |
	| PDP	      | q3_sep_rxulayer001     |Last 6 months | Medical |
	| MAPD      | q4_dec_uhc002     |Last 18 months | Prescription |
	| PDP	      | q3_sep_rxulayer001     |Last 90 days | Medical |
 
	
       
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

@new
 Scenario Outline: To verify mobile responsive for all plans on EOB page
Given registered AMP with for EOB flow
       | Plan Type      |<planType>  |
       | Member Type    |<memberType>|
Then the user navigates to EOB page and validates the page
|Date Range|<dateRange1>  |
|Plan Type |<planType>   |
|EOB Type  |<eobTypeData>|
|From Date |<fromDate>   |
|To Date   |<toDate>     |
Then the user navigates to EOB page and validates the page
|Date Range|<dateRange2>  |
|Plan Type |<planType>   |
|EOB Type  |<eobTypeData>|
|From Date |<fromDate>   |
|To Date   |<toDate>     |
Then the user navigates to EOB page and validates the page
|Date Range|<dateRange3>  |
|Plan Type |<planType>   |
|EOB Type  |<eobTypeData>|
|From Date |<fromDate>   |
|To Date   |<toDate>     |
Then the user navigates to EOB page and validates the page
|Date Range|<dateRange4>  |
|Plan Type |<planType>   |
|EOB Type  |<eobTypeData>|
|From Date |<fromDate>   |
|To Date   |<toDate>     |
Examples:
      | planType  | memberType   | eobTypeData       | fromDate   | toDate     |dateRange1       |dateRange2 |dateRange3 |dateRange4 |
      | MA        |  q4_dec_aarp507        | Medical           | 01/01/2016 | 04/01/2017 |Last 90 Days  |  Last 6 Months  | Last 12 Months  | Last 18 Months |
      | MAPD      |  q4_dec_uhc002		     | Medical           | 01/01/2016 | 04/01/2017 |Last 90 days  |  Last 6 months  | Last 12 months  | Last 18 months |  
      | PDP       |  q4_dec_aarp292        | Medical           | 01/01/2016 | 04/01/2017 |Last 90 days  |  Last 6 months  | Last 12 months  | Last 18 months |
        
@comboTab
Scenario Outline: To verify different plan types under combo tabs
Given registered AMP with for EOB flow
       | Member Type    |<memberType>|
And the user navigates to EOB page  
Then the user validates content displayed on EOB page
       | Plan Type      |<planType>  |       
Examples: 
| planType    | memberType   					 | 
#| MA          | q4_dec_combo015        |
#|	SSUP				|	q4_dec_combo015        |
#|	HIP					| q4_dec_ship020				 |
#| MAPD				|	q4_dec_ship020				 | 
#| PDP					| q4_dec_combo026				 |
#|	SHIP				| q4_dec_combo026				 |
#Peehip
| MA					| q4_dec_grp036					 |
| PDP					| q4_dec_grp036          |

#failing
|	PDP					|	q4_dec_aarp002          |

| PDP					| q4_dec_ship072          |
|	SSUP				| q4_dec_ship072          | 
@noComboTab
Scenario Outline: To verify different plan types under combo tabs
Given registered AMP with for EOB flow
       | Member Type    |<memberType>|
And the user navigates to EOB page  
Then the user validates content displayed on EOB page without combo tabs
       | Plan Type      |<planType>  |
Examples: 
| planType    | memberType   					 |
#WELLS FARGO
| PDP					| q4_dec_grp039          |  

             
	
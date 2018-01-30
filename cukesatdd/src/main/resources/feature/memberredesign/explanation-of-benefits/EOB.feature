@fastandfurious
@eob
Feature:To test EOB on Dashboard page
@Eobsiteleavingpopup 
Scenario Outline: Allowed Domains – Authors need ability to define messages and domains for leaving member sites (ATDD)
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page 
Then the user validates site leaving pop up         
Examples:
       | planType  | memberType        |  
  #    | MAPD      | q4_dec_uhc020   	 | 
       | PDP			 | q1_aarp_feb345		 |
       | MA				 | q1_aarp_feb284	   |   

  @eobCountdaterange
Scenario Outline: To verify EOB result list
Given registered AMP with for EOB flow
	| Plan Type      |<planType>  |
	| Member Type    |<memberType>|
Then the user navigates to EOB page	
And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type			 |<eobType>   |
Then the user validates EOB count
	Examples:
		| planType  | memberType        |dateRange			| eobType |
		| MA        | q4_dec_grp074     |12 Months		  | Medical |


 

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
#| PDP					| q4_dec_grp039          |  

|	MAPD				|	q4_dec_grp074					 |

@noComboTabNew
Scenario Outline: To verify different plan types under non combo tabs
Given registered AMP with for EOB flow
       | Member Type    |<memberType>|
And the user navigates to EOB page  
And the user selects the desired date range
		| Plan Type      |<planType>  |
		|EOB Type				 |<eobTypeData>|
		|Date Range			 |<dateRange>|


Examples:
| planType    | memberType   					 |eobTypeData				|dateRange			|
#5 	EOBS
|	MAPD				|	q4_dec_grp074					 |Prescription Drug |12 Months  	 |
#|	MAPD				|	q4_dec_grp074					 |Prescription Drug |18 Months  	 |
|	MAPD				|	q4_dec_grp074					 |Prescription Drug |6 Months  	   |
|	MAPD				|	q4_dec_grp074					 |Prescription Drug |custom-search |

 |	PDP				|	q4_dec_aarp327					 |na |12 Months |
 |	PDP	  		|	q4_dec_aarp327					 |na |18 Months|
 
 
 
 


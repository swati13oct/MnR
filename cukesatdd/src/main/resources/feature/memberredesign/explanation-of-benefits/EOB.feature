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
  	   | MAPD      |IndividualMed_EOB  | 
     

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
		| MAPD      |IndividualMed_EOB  |12 Months		  | Medical |


 

@noComboTab
Scenario Outline: To verify different plan types under combo tabs
Given registered AMP with for EOB flow
       | Member Type    |<memberType>|
And the user navigates to EOB page  
Then the user validates content displayed on EOB page without combo tabs
       | Plan Type      |<planType>  |
Examples: 
| planType    | memberType   					 |
| MAPD        |IndividualMed_EOB  |  



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
| planType    | memberType   					 |eobTypeData				 |dateRange			|
| MAPD        |IndividualMed_EOB  		 | Prescription Drug |12 Months  	 |

 
 
 
 


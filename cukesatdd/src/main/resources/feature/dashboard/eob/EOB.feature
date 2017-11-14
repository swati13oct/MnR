@eobFnF
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


#@eobPdf        @workingFine
#Scenario Outline: To verify How to read your medical EOB
#Given registered AMP with for EOB flow
	#| Plan Type      |<planType>  |
	#| Member Type    |<memberType>|
#Then the user navigates to EOB page
#And the user slects the desired date range
 # | Plan Type      |<planType>  |
 # | Date Range     |<dateRange> |
 # | EOB Type			 |<eobType>|
#And the user validates how to read medical eob PDF
 #	Examples:
 	#Member should have EOBs for the specified date range
	#| planType  | memberType        |dateRange			| eobType |
	#| MAPD      | q4_dec_grp074     |18 Months		  | Medical |
#	| MAPD      | q4_dec_grp074     |12 Months		  | Medical |
	      
       
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
	| MAPD      | q4_dec_uhc001     |12 Months		  | Medical |
	 
 
	
  @eobCoutn    
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


 
@comboTab
Scenario Outline: To verify different plan types under combo tabs
Given registered AMP with for EOB flow
       | Member Type    |<memberType>|
And the user navigates to EOB page  
Then the user validates content displayed on EOB page
       | Plan Type      |<planType>  |       
Examples: 
| planType    | memberType   					 | 
| MA          | q4_dec_combo015        |
|	SSUP				|	q4_dec_combo015        |
|	HIP					| q4_dec_ship020				 |
| MAPD				|	q4_dec_ship020				 | 
| PDP					| q4_dec_combo026				 |
|	SHIP				| q4_dec_combo026				 |
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
|	MAPD				|	q4_dec_grp074					 |Prescription Drug |18 Months  	 |
|	MAPD				|	q4_dec_grp074					 |Prescription Drug |6 Months  	   |
|	MAPD				|	q4_dec_grp074					 |Prescription Drug |custom-search |

# =========== B Layer Group =======================================================================
 |	MA				|	q4_dec_grp181					 |na |12 Months |
 |	MA				|	q4_dec_grp181					 |na |18 Months|
 |	MA				|	q4_dec_grp181					 |na |6 Months |
 |	MA				|	q4_dec_grp181					 |na |custom-search |
 # 2 EOBs displayed
 |	PDP				|	q4_dec_grp273					 |na |12 Months |
 |	PDP	  		|	q4_dec_grp273					 |na |18 Months|
 |	PDP	  		|	q4_dec_grp273					 |na |6 Months |
 |	PDP  			|	q4_dec_grp273					 |na |custom-search |
 
 #=====================================================================================================
 
 
 
 
 
 
 


@fastandfurious @theSpartans @febRelease2018
@eob
Feature:F1.1To test EOB on Dashboard page
@Eobsiteleavingpopup 
Scenario Outline: Allowed Domains – Authors need ability to define messages and domains for leaving member sites (ATDD)
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page_hsid 
Then the user validates site leaving pop up         
Examples:
       | planType    | memberType                      |  
 			 | MAPD        | IndividualAARPWOEOB						 |
       | MA          | IndividualAARPWOEOB						 |
     

  @eobCountdaterange
Scenario Outline: To verify EOB result list
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page_hsid	
And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type			 |<eobType>   |
Then the user validates EOB count
	| EOB COUNT			 | <eobCount>|
	Examples:
	| planType    | memberType                |dateRange					   | eobType           |eobCount |
 	| PCP         | withEOB                   | 18 Months            | Medical           |		4		 |
	| MAPD        |aarpWithEOB 			          | 90 Days    			     | Medical 	         |		4		 |
	| MAPD        |aarpWithEOB 			          | 6 Months    		     | Medical 	         |		8		 |
	| MAPD        |aarpWithEOB 			          | 12 Months    		     | Medical 	         |		8		 |
	| MAPD        |aarpWithEOB 			          | 18 Months    		     | Medical 	         |		8		 |
	| MAPD        |aarpWithEOB 			          | 6 Months   			     | Prescription Drug |		1		 |
	| MAPD        |aarpWithEOB 			          | 12 Months  			     | Prescription Drug |		1		 |
	| MAPD        |aarpWithEOB 			          | 18 Months   		     | Prescription Drug |		1		 |

 

@planTypeValidation @hsideob2
Scenario Outline: To verify different plan types under combo tabs
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
And the user navigates to EOB page_hsid  
Then the user validates content displayed on EOB page without combo tabs
  | Plan Type      |<planType>  |
Examples: 
| planType    | memberType   					         |
| MAPD        | NICE_EOB 						 |
#| MA          | IndividualAARPWOEOB						 |
  
@dropDownFuntion 
Scenario Outline: To validate page functionality with different dropdowns
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page and validates the page
 |Date Range|<dateRange>  |
 |Plan Type |<planType>   |
 |EOB Type  |<eobTypeData>|
 Then the user validates content displayed on EOB page without combo tabs
  | Plan Type      |<planType>  |
Examples:
	| planType    | memberType                | eobTypeData       | dateRange       |
	| MAPD        | IndividualAARPWOEOB       | Medical           | 6 Months        |
	| MAPD        | IndividualAARPWOEOB       | Prescription Drug | 6 Months        |
 	| MAPD        | IndividualAARPWOEOB       | Medical           | 12 Months       |
	| MAPD        | IndividualAARPWOEOB       | Medical           | 18 Months       |
	| MAPD        | IndividualAARPWOEOB       | Medical           | 90 Days         |
	| SHIP        | Individual 			  			  | Medical 					|6-12 Months			|
	| SHIP        | Individual 			  			  | Medical 					|90 Days			    |
  
@learnAboutMedicalEOB 
Scenario Outline: To verify How to read a medical EOB PDF
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page and validates the page
 |Date Range|<dateRange>  |
 |Plan Type |<planType>   |
 |EOB Type  |<eobTypeData>|
And the user validates how to read medical eob PDF
 	Examples:
	| planType    | memberType                |dateRange         | eobTypeData       |
	| PCP         | withEOB                   |  18 Months       | Medica            |
	| MAPD        |aarpWithEOB 			          | 90 Days    			 | Medical 	         |
	| MAPD        |aarpWithEOB 			          | 6 Months    		 | Medical 	         |
	| MAPD        |aarpWithEOB 			          | 12 Months    		 | Medical 	         |
	| MAPD        |aarpWithEOB 			          | 18 Months    		 | Medical 	         |

@febRelease2018 @hsideob @regression_06_06_18
Scenario Outline: To verify NICE EOB and click on the pdf
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page_hsid 
And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type         |<eobType>   |
Then the user validates EOB count
       | EOB COUNT                | <eobCount>|
 And the user clicks on first eob from the list
 #And the user validates how to read medical eob PDF
 
           Examples:
       | planType    | memberType    |dateRange  | eobType |  eobCount |
       | MAPD        | NICE_EOB_R      | 18 Months |Medical  |     1     |
       | MA          | COSMOS_EOB_R      | 18 Months |Medical  |     16     |
       | PDPI         | COSMOS_EOB_R     | 18 Months |Medical  |     0     |
       | SHIP_ACTIVE  | SHIP_EOB      | 12-18 Months |Medical  |     1     |
       | SHIP_Termnated| SHIP_EOB      | 12-18 Months |Medical  |     1     |
       | MAPD          | NICETermin_EOB_R | 18 Months |Medical  |     1     |
       
@regression_06_06_18FnF
Scenario Outline: To verify EOB accessible for PDP + MEDSup Plan
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page_hsid 
Then the user validates content displayed on EOB page
      |Plan Tab     | <planTab1>  |
Then the user validates content displayed on EOB page
      |Plan Tab     | <planTab2>  |
 Examples:
       | planType     | memberType     |dateRange  | eobType |  eobCount | planTab1   |planTab2 |
       | PDP          |  comboEOBMedSup      | 18 Months |Medical  |     0     | 	PDP			 | MedSup     |
       
@regression_06_06_18FnF
Scenario Outline: TC009_Check EOB is accessible for PCP Individual - Active Plan
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page_hsid 
And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type       |<eobType>   |
Then the user validates EOB count
       | EOB COUNT                | <eobCount>|
And the user clicks on first eob from the list
Examples:
       | planType    | memberType    |dateRange  | eobType |  eobCount |
       | PCP        | eobData      | 18 Months |Medical  |     1     |

@regression_06_06_18FnF     
Scenario Outline: TC013_Check EOB is accessible for TEXAS ERS  - Active Plan
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page_hsid 
And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type       |<eobType>   |
Examples:
       | planType    | memberType    	 |dateRange  | eobType |   
       | PDP        | texasERS      | 18 Months |Medical  |      

@regression_06_06_18FnF
Scenario Outline: TC011_Check EOB is accessible for MEDICA Individual - Active Plan
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page_hsid 
And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type       |<eobType>   |
Examples:
       | planType    | memberType    	 |dateRange  | eobType |   
       | MA        | Medica      | 18 Months |Medical  |

@regression_06_06_18FnF
Scenario Outline: TC010_Check EOB displays error message_ PHIP- Active Plan member
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page_hsid 
Then the user validates content displayed on EOB page
      |Plan Tab     | <planTab1>  |
And the user gets the error message for PHIP member	
      
Examples:
       | planType      | memberType     | 
       | PHIP          |  SHIP          |


Scenario Outline: TC008_Check EOB is accessible for MedsSupp ( Terminated) + PHIP (Active) Plan member

Scenario Outline: TC007_Check EOB is accessible for  MedsSupp ( Active) + PHIP (Terminated) Plan member


        
 

|
 

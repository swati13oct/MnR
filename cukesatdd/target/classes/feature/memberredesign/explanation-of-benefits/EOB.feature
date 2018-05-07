@fastandfurious @theSpartans @febRelease2018
@eob
Feature:F1.1To test EOB on Dashboard page
@Eobsiteleavingpopup 
Scenario Outline: Allowed Domains – Authors need ability to define messages and domains for leaving member sites (ATDD)
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page 
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
Then the user navigates to EOB page	
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

 

@planTypeValidation
Scenario Outline: To verify different plan types under combo tabs
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
And the user navigates to EOB page  
Then the user validates content displayed on EOB page without combo tabs
  | Plan Type      |<planType>  |
Examples: 
| planType    | memberType   					         |
| MAPD        | IndividualAARPWOEOB						 |
| MA          | IndividualAARPWOEOB						 |
  
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

@febRelease2018
Scenario Outline: To verify NICE EOB and click on the pdf
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to EOB page and validates the page
 |Date Range|<dateRange>  |
 |Plan Type |<planType>   |
 |EOB Type  |<eobTypeData>|
And the user clicks on first eob from the list
 	Examples:
	| planType    | memberType    |dateRange     | eobTypeData       | friendname | favcolor | phonenumber |
	| MAPD        | NICE_EOB      | 18 Months    | Medical           | name1      | color1   | number1     |
	| MA          | NICE_EOB 			| 18 Months    | Medical 	         | name1      | color1   | number1     |
	| MAPD_GRP    | NICE_EOB 			| 18 Months    | Medical 	         | name1      | color1   | number1     |
	
	
	
 

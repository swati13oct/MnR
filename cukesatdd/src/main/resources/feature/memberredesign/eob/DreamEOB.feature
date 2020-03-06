@Dreameob @fastandfurious 
Feature:1.04 Member EOB on Dashboard page

@DreamEOB1_MA
Scenario Outline: TID: <UID> -plan: <planType> -memberType: <memberType>- Validation Dream EOB page for Medical only MA members
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to Dream EOB Page 
Then the user validates EOB type dropdown is not displayed on Dream EOB page
Then the user validates Learn More Link and section on Dream EOB Page
Then the user validates the EOB table for Medical only EOBs
Then the user validates the date range dropdown
And the user selects the desired date range on Dream EOB Page
  | Date Range     |<dateRange> |
Then the user validates EOB count on Dream EOB Page
	| EOB COUNT			 | <eobCount>|
Then the user validates EOB PDF size is not 0kb on Dream EOB Page

Examples:
	 |UID | planType    | memberType                |dateRange					   |eobCount |
 	 |15134 | MA         | withEOB                   | 18 Months          |		4		 |


@DreamEOB1_MAPD
Scenario Outline: TID: <UID> -plan: <planType> -memberType: <memberType>- Validation Dream EOB page for Medical only MA members
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to Dream EOB Page 
Then the user validates EOB type dropdown is not displayed on Dream EOB page
Then the user validates Learn More Link and section on Dream EOB Page
Then the user validates the date range dropdown
And the user selects the desired date range on Dream EOB Page
  | Date Range     |<dateRange> |
Then the user validates EOB count for Medical Only EOBs on Dream EOB Page
	| EOB COUNT			 | <MedicalCount>|
Then the user validates EOB count for Rx Only EOBs on Dream EOB Page
	| EOB COUNT			 | <RxCount>|
	Then the user validates EOB count for Combined EOBs on Dream EOB Page
	| EOB COUNT			 | <CombinedCount>|
Then the user validates EOB PDF size is not 0kb on Dream EOB Page

Examples:
	 |UID | planType    | memberType                |dateRange					   |MedicalCount |
 	 |15134 | MAPD       | withEOB                 | 18 Months          |		4		 |


@DreamEOB1_PDP
Scenario Outline: TID: <UID> -plan: <planType> -memberType: <memberType>- Validation Dream EOB page for Medical only MA members
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to Dream EOB Page 
Then the user validates EOB type dropdown is not displayed on Dream EOB page
Then the user validates Learn More Link and section on Dream EOB Page
Then the user validates the EOB table for Rx only EOBs
Then the user validates the date range dropdown
And the user selects the desired date range on Dream EOB Page
  | Date Range     |<dateRange> |
Then the user validates EOB count on Dream EOB Page
	| EOB COUNT			 | <eobCount>|
Then the user validates EOB PDF size is not 0kb on Dream EOB Page

Examples:
	 |UID | planType    | memberType                |dateRange					   |eobCount |
 	 |15134 | PDP         | withEOB                   | 18 Months          |		4		 |
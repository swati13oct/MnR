@TeamPredators
@F108803_HICN_MBI
Feature: ATDD implementation for HICN/MBI entry to Medicare ID field for Personal Identification Page in Registration Flow

@HICN_Entry_PreApr2018
Scenario Outline: Medicare ID filed should accept HICN number for Serverd date 31 March 2018 without error for Personal identification
Given Server Date is set to the following date
     | Server Date   | <ServerDateMilliSeconds>   |
And User adds the following details in Registration Page and click on Continue Button
     | Member Number   | <MemberNo>   |
     | Date Of Birth   | <DOB>   |
When User enters Following No in the Member ID field
     | Identification Type	  | <HICN_MBI>   |
     | Identification Value   | <HICN_MBI_Value> |
Then Validate that Continue button is enabled
And User should successfully navigate to create User Account Page
Examples:

| ServerDateMilliSeconds | MemberNo  | DOB 				| HICN_MBI | HICN_MBI_Value | 
| 1522476000000 				 | 001742786 | 11/01/1939 | HICN		 | 	163344396A	 |

@HICN_MBI_Entry_Apr2018
Scenario Outline: Medicare ID filed should accept either HICN or MBI number for Server date 01 Apr 2018 without error for Personal identification
Given Server Date is set to the following date
     | Server Date   | <ServerDateMilliSeconds>   |
And User adds the following details in Registration Page and click on Continue Button
     | Member Number   | <MemberNo>   |
     | Date Of Birth   | <DOB>   |
When User enters Following No in the Member ID field
     | Identification Type	  | <HICN_MBI>   |
     | Identification Value   | <HICN_MBI_Value> |
Then Validate that Continue button is enabled
And User should successfully navigate to create User Account Page
Examples:

| ServerDateMilliSeconds | MemberNo  | DOB 				| HICN_MBI | HICN_MBI_Value | 
| 1522562400000 				 | 001742786 | 11/01/1939 | HICN		 | 	163344396A	 |
| 1522562400000 				 | 001742786 | 11/01/1939 | MBI		 	 | 	2A22C22YK22	 |
| 1522562400000 				 | 001742786 | 11/01/1939 | MBI		 	 | 	1A11C11YK11	 |


@HICN_MBI_Entry_Dec2019
Scenario Outline: Medicare ID filed should accept either HICN OR MBI number for Server date 31 Dec 2019 without error for Personal identification
Given Server Date is set to the following date
     | Server Date   | <ServerDateMilliSeconds>   |
And User adds the following details in Registration Page and click on Continue Button
     | Member Number   | <MemberNo>   |
     | Date Of Birth   | <DOB>   |
When User enters Following No in the Member ID field
     | Identification Type	  | <HICN_MBI>   |
     | Identification Value   | <HICN_MBI_Value> |
Then Validate that Continue button is enabled
And User should successfully navigate to create User Account Page

Examples:
| ServerDateMilliSeconds | MemberNo  | DOB 				| HICN_MBI | HICN_MBI_Value | 
| 1577772000000 				 | 001742786 | 11/01/1939 | HICN		 | 	163344396A	 |
| 1577772000000 				 | 001742786 | 11/01/1939 | MBI		   | 	2A22C22YK22	 |
| 1577772000000 				 | 001742786 | 11/01/1939 | MBI		   | 	1A11C11YK11	 |

@MBI_Entry_Jan2020
Scenario Outline: Medicare ID filed should accept MBI number for Server date 01 Jan 2020 without error for Personal identification
Given Server Date is set to the following date
     | Server Date   | <ServerDateMilliSeconds>   |
And User adds the following details in Registration Page and click on Continue Button
     | Member Number   | <MemberNo>   |
     | Date Of Birth   | <DOB>   |
When User enters Following No in the Member ID field
     | Identification Type	  | <HICN_MBI>   |
     | Identification Value   | <HICN_MBI_Value> |
Then Validate that Continue button is enabled
And User should successfully navigate to create User Account Page

Examples:
| ServerDateMilliSeconds | MemberNo  | DOB 				| HICN_MBI | HICN_MBI_Value | 
| 1577772000000 				 | 001742786 | 11/01/1939 | MBI		 | 	2A22C22YK22	 |
| 1577772000000 				 | 001742786 | 11/01/1939 | MBI		 | 	1A11C11YK11	 |

@HICN_Entry_Jan2020
Scenario Outline: Medicare ID filed should NOT accept HICN number for Server date 01 Jan 2020 without error for Personal identification
Given Server Date is set to the following date
     | Server Date   | <ServerDateMilliSeconds>   |
And User adds the following details in Registration Page and click on Continue Button
     | Member Number   | <MemberNo>   |
     | Date Of Birth   | <DOB>   |
When User enters Following No in the Member ID field
     | Identification Type	  | <HICN_MBI>   |
     | Identification Value   | <HICN_MBI_Value> |
Then Validate that Continue button is Disabled
And User should NOT be able navigate to create User Account Page

Examples:
| ServerDateMilliSeconds | MemberNo  | DOB 				| HICN_MBI | HICN_MBI_Value | 
| 1577772000000 				 | 001742786 | 11/01/1939 | HICN		 | 	163344396A	 |

@ErrorMessages_HICN_MBI
Scenario Outline: Medicare ID filed should NOT accept invalid HICN or MBI number for Server date 01 Apr 2019 and throw Error Message
Given Server Date is set to the following date
     | Server Date   | <ServerDateMilliSeconds>   |
And User adds the following details in Registration Page and click on Continue Button
     | Member Number   | <MemberNo>   |
     | Date Of Birth   | <DOB>   |
When User enters Following No in the Member ID field
     | Identification Type	  | <InvalidNo>   |
     | Identification Value   | <HICN_MBI_Value> |
Then The following Error Message should be Displayed
And User should NOT be able navigate to create User Account Page

Examples:
| ServerDateMilliSeconds | MemberNo  | DOB 				| InvalidNo | HICN_MBI_Value | 
| 1577772000000 				 | 001742786 | 11/01/1939 | Invalid Value		 | 	163344396A	 |


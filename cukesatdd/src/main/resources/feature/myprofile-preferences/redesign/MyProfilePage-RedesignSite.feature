@MyProfilePreferencePage
Feature: To test for Functionality and UI for My Profile Page in Redesign site

@ValidateSHIPsingleTab
Scenario Outline: Verify Single tabs for all SHIP Plans except for PHIP in My Profile and Preferences in Member Redesign site
Given registered AMP member with following attributes
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user Validates Single Tab for all SHIP Plans

Examples:   
            | planType    | memberType |
            | SHIP        | MedSuppwithRider |
            | SHIP				| HIPwithRider	|

@ValidatePHIPtab
Scenario Outline: Verify Single tabs for all SHIP Plans except for PHIP in My Profile and Preferences in Member Redesign site
Given registered AMP member with following attributes
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user Validates Separate PHIP tab

Examples:   
            | planType    | memberType |
            | SHIP        | PHIP |

@ValidateComboTabsAARPPlans
Scenario Outline: Verify Separate tabs for All AARP Plans in My Profile and Preferences in Member Redesign site
Given registered AMP member with following attributes
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then user navigates to Tabs for all Plan Types
      | Combo Plans | <comboPlans> |
 
Examples:   
            | planType  | memberType | comboPlans |
            | MA        | MAwithHIP | MA,HIP |
            | MAPD			| MAPDwithHIP | MA,HIP |
            | PDP				| PDPwithMedHIP | PDP,HIP |
            | MA        | MAwithMedSupp | MA,MedSupp |
            | MAPD			| MAPDwithMedSUpp | MA,MedSupp |
            | PDP				| PDPwithMedSupp | PDP,MedSupp |

@ValidateComboTabsUHCPlans
Scenario Outline: Verify Separate tabs for All UHC Plans in My Profile and Preferences in Member Redesign site
Given registered UHC member with following attributes
	| Plan Type | <planType> |
	| Member Type  | <memberType> |
When the user Navigates to BlueLayer Member Redesign My Profile and Preferences page
Then user navigates to Tabs for all Plan Types
      | Combo Plans | <comboPlans> |
 
Examples:   
            | planType  | memberType | comboPlans |
            | PDPwithSSUP | Group | PDP,SSUP |


@EditEmailErrorMessagesAARP
Scenario Outline: Verify Error Messages for Edit Email scenarios in My Profile and Preferences in Member Redesign site
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user Validates all Error Messages for Edit Email scenarios

Examples:   
            | planType    | 
            | MA          |
 
 @TempAltAddressErrorMessagesAARP
Scenario Outline: Verify Error Messages for Alt/Temp Address scenarios in My Profile and Preferences in Member Redesign site
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user Validates all Error Messages for Alt/Temp Address scenarios

Examples:   
            | planType    | 
            | MA          |
      
@EditEmailErrorMessagesUMS
Scenario Outline: Verify Error Messages for Edit Email scenarios in My Profile and Preferences in Member Redesign site
Given registered UHC member with following attributes
	| Plan Type    | <planType>   |
	| Member Type  | <memberType> |
When the user Navigates to BlueLayer Member Redesign My Profile and Preferences page
Then the user Validates all Error Messages for Edit Email scenarios

Examples:   
            | planType    | memberType |
            | MA          | Individual |
 
 @TempAltAddressErrorMessagesUMS
Scenario Outline: Verify Error Messages for Alt/Temp Address scenarios in My Profile and Preferences in Member Redesign site
Given registered UHC member with following attributes
	| Plan Type    | <planType>   |
	| Member Type  | <memberType> |
When the user Navigates to BlueLayer Member Redesign My Profile and Preferences page
Then the user Validates all Error Messages for Alt/Temp Address scenarios

Examples:   
            | planType    | memberType |
            | MA          | Individual |

@blankpassworderrormessage
Scenario Outline:To verify profile and preference blank password error messages in AARP site
Given registered AMP member with following attributes
	| Plan Type | <plantype> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user edits password in preference page in AARP Site
	 | Current password | <currentpassword>    |
	 | New pass Error Msg | <newpasserrormsg> |
	 | Conf Pass Error Msg | <confpasserrormsg>  |
	 	 
Examples:
	| plantype | currentpassword | newpasserrormsg        |confpasserrormsg       |
	| MAPD      | Password@1     |Enter your new password.|This field is required.|
	#| MAPD      | Password@1     | Password@2  | Password@3      |
	#| MAPD      | Password@1     | Password&2  | Password@2      |
	#| MAPD      | Password@1     |Password@1   | Password@1      |
	
@phoneerrormessage
Scenario Outline:To verify profile and preference phone error messages in AARP site
Given registered AMP member with following attributes
	| Plan Type | <plantype> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user validate phone number error messages
   |day time phone number | <daytimephonenumber> |
   |Phone error message | <phoneerrormsg> |
Examples:
	| plantype |daytimephonenumber |phoneerrormsg																		|
	| MAPD     |aaaa               |Enter your phone number like this: 111-111-1111 |
	

@diffpassworderrormessage
Scenario Outline:To verify profile and preference different password error messages in AARP site
Given registered AMP member with following attributes
	| Plan Type | <plantype> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user verify diff password error msg in preference page in AARP Site
	 | Current password | <currentpassword>    |
	 | New password   | <newpassword> |
	 |Confirm Password | <confirmpassword> |
	 
Examples:
	| plantype | currentpassword |newpassword | confirmpassword | 
	| MAPD      | Password@1     | Password@2  | Password@3     |
	
@incorrectpasswordformaterrormessage
Scenario Outline:To verify profile and preference incorrect format password error messages in AARP site
Given registered AMP member with following attributes
	| Plan Type | <plantype> |
When the user Navigates to AARP Member Redesign My Profile and Preferences page
Then the user verify incorrect format password error msg in preference page in AARP Site
	 | Current password | <currentpassword>    |
	 | New password   | <newpassword> |
	 |Incorrect Format ErrMsg | <incorrectformatErrorMsg> |
	 
Examples:
	| plantype | currentpassword |newpassword | incorrectformatErrorMsg 													 |
	| MAPD      | Password@1     | Password&2 | Your password needs to follow a set of guidelines. |

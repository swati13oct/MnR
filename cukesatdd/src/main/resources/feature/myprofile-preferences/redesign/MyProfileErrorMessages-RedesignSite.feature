@MyProfileErrorMessages
Feature: To test for Error Messages for My Profile Page in Redesign site

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


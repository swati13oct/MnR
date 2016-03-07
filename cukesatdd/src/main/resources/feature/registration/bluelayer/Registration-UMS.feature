@registration
Feature:To test registration flow in UMS site
Scenario Outline: To verify registration for two plan combo member with out perks in UMS site
Given the following details with which the member registers in UMS site
	| Plan Member ID | <planMemberId> |
	| Date of birth  | <dateOfBirth>  |
When the user provides additional Member Id in UMS site
| Additional Plan Member ID | <additionalMemberId> |
And the user confirm personal and plan information for both plans in UMS site
And the user registers with the following details in UMS site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
Then user registers successfully in UMS site
	
Examples:
	| planMemberId	 | dateOfBirth | additionalMemberId | userName           | password   | confirmPassword | email          	| confirmEmail      |
##	| 0110425671     | 08-05-1932  | 923552129-11       | q4blgroup_049      | Password@1 | Password@1      | GPS_UHC@OPTUM.COM	| GPS_UHC@OPTUM.COM |
##	| 975017589-01   | 08-06-1939  | 1007606011         | q4blgroup_059      | Password@1 | Password@1      | TEST@OPTUM.COM	| TEST@OPTUM.COM    |

Scenario Outline: Verify registration for individual or group members in UMS site
Given the following details with which the member registers in UMS site
   	   | Plan Member ID | <planMemberId> |
	   | Date of birth  | <dateOfBirth>  |
When the user confirms plan details in UMS site
And the user registers with the following details in UMS site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
Then user registers successfully in UMS site

Examples:
	 | planMemberId | dateOfBirth | userName           | password   | confirmPassword | email                   | confirmEmail            |
	 | 0120822481   | 04-30-1950  | q4blgroup_113      | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
#	 | 974849955-11 | 11-15-1924  | q3uhcgrp_050       | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
#	 | 0141695071   | 10-11-1946  | q3uhcgrp_098       | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
#	 | 907051786-11 | 09-05-1940  | q3uhcgrp_001       | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |

##WORKING	
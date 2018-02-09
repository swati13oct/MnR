@unimplemented
Feature:To test My Profile & Preferences in UMS site
Scenario Outline:To verify My Profile in UMS site
Given registered member for My Profile & Preferences in UMS site
	| Plan Type | <plantype> |
	| MemberType     | <memberType>|
When the user view My Profile & Preferences in UMS site
And the user selects My Profile in UMS site
And the user views account profile in UMS site
And the user views plan profile in UMS site
Then user validates plan profiles
Examples:
	        | plantype | memberType |
		| MA       | INDIVIDUAL |
		| MAPD     | INDIVIDUAL |
		| MA       | Group      |   
		| MAPD     | Group      |
		| PDP      | Group      |
		| SSUP      | Group      |


Scenario Outline:To verify My Profile and edit profile in UMS site
Given registered member for My Profile & Preferences in UMS site
	| Plan Type | <plantype> |
	| MemberType     | <memberType>|
When the user view My Profile & Preferences in UMS site
And the user selects My Profile in UMS site
And the user edits account profile in UMS site
	 | Current password | <currentpassword>    |
	 | New password | <newpassword> |
	 | Confirm password | <confirmpassword>  |
	 | New email address | <newemailaddress> |
	 | Confirm email address | <confirmemailaddress> |
And the user edits plan profile in UMS site
         | Street address | <streetaddress> |
	 | Street address2 | <streetaddress2> |
	 | Daytime phone | <daytimephone> |
	 | Evening phone | <eveningphone> |
And the user edits alternate address in plan profile in UMS site
         | Street address | <streetaddress> |
	 | Street address2 | <streetaddress2> |
	 | City | <city> |
	 | State | <state> |
	 | Zip Code | <zipcode> |
	 | Country | <country> |
	 | Start Date | <startdate> |
	 | End Date | <enddate> |
And the user edits mailling address in plan profile in UMS site
         | Street address | <streetaddress> |
	 | Street address2 | <streetaddress2> |
	 | City | <city> |
	 | State | <state> |
	 | Zip Code | <zipcode> |
	 | Country | <country> |
	 | Start Date | <startdate> |
	 | End Date | <enddate> |

Examples:

	| plantype | memberType |currentpassword | newpassword | confirmpassword | newemailaddress | confirmemailaddress | streetaddress | streetaddress2 | daytimephone | eveningphone | streetaddress | streetaddress2 | city     | state    | zipcode | country       | startdate  | enddate   | streetaddress | streetaddress2 | city     | state    | zipcode | country       | startdate  | enddate   |
	| PDP      |  Group      | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 
        | MAPD     |  Group      | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 
        | MA       |  Group      | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 
        | MA       | INDIVIDUAL | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 
        | MAPD     | INDIVIDUAL | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 
        | SSUP      | Group      | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 


Scenario Outline:To verify My Preferences in UMS site
Given registered member for My Profile & Preferences in UMS site
	| Plan Type | <plantype> |
	| MemberType     | <memberType>|
When the user view My Profile & Preferences in UMS site
And the user selects My Preferences in UMS site
And the user views document name and delivery preferences for a plan in UMS site
       | Document Name	      | 
       | Delivery Preferences |
Then user click update preferences in UMS site
Examples:
	        | plantype | memberType |
		| MA       | INDIVIDUAL |
		| MAPD     | INDIVIDUAL |
		| MA       | Group      |   
		| MAPD     | Group      |
		| PDP      | Group      |
		| SSUP      | Group      |




Scenario Outline:To verify My Preferences and edit preferences in UMS site
Given registered member for My Profile & Preferences in UMS site
	| Plan Type | <plantype> |
	| MemberType     | <memberType>|
When the user view My Profile & Preferences in UMS site
And the user selects My Preferences in UMS site
And the user edits document name and delivery preferences for a plan in UMS site
       | Document Name	      | <documentname>        |
       | Delivery Preferences | <deliverypreferences> |
Then user click update preferences in UMS site
Examples:
	| plantype | memberType |documentname                                    | deliverypreferences |
	| PDP      | Group      |Annual Notice Of Changes Documents              | online              |
	| MAPD     | Group      |Prescription Drug Explanation of Benefits (EOB) | u.s.mail            |
	| MA       | Group      |Claims                                          | online              |
        | SSUP      | Group      |Prescription Drug Explanation of Benefits (EOB) | u.s.mail            |
        | MA       | INDIVIDUAL |Claims                                          | online              |
	| MAPD     | INDIVIDUAL |Prescription Drug Explanation of Benefits (EOB) | u.s.mail            |
         
	       




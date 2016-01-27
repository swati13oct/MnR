@unimplemented
Feature:To test My Profile & Preferences in AARP site
Scenario Outline:To verify My Profile in AARP site
Given registered member for My Profile & Preferences in AARP Site
	| Plan Type | <plantype> |
When the user view My Profile & Preferences in AARP Site
And the user selects My Profile in AARP Site
And the user views account profile in AARP Site
And the user views plan profile in AARP Site
Then user validates plan profiles
Examples:
	| plantype | 
	| PDP      |
	| MAPD     |
	| MA       |
	| MS       |
	| HIP      |


Scenario Outline:To verify My Profile and edit profile in AARP site
Given registered member for My Profile & Preferences in AARP Site
	| Plan Type | <plantype> |
When the user view My Profile & Preferences in AARP Site
And the user selects My Profile in AARP Site
And the user edits account profile in AARP Site
	 | Current password | <currentpassword>    |
	 | New password | <newpassword> |
	 | Confirm password | <confirmpassword>  |
	 | New email address | <newemailaddress> |
	 | Confirm email address | <confirmemailaddress> |
And the user edits plan profile in AARP Site
         | Street address | <streetaddress> |
	 | Street address2 | <streetaddress2> |
	 | Daytime phone | <daytimephone> |
	 | Evening phone | <eveningphone> |
And the user edits alternate address in plan profile in AARP Site
         | Street address | <streetaddress> |
	 | Street address2 | <streetaddress2> |
	 | City | <city> |
	 | State | <state> |
	 | Zip Code | <zipcode> |
	 | Country | <country> |
	 | Start Date | <startdate> |
	 | End Date | <enddate> |
And the user edits mailling address in plan profile in AARP Site
         | Street address | <streetaddress> |
	 | Street address2 | <streetaddress2> |
	 | City | <city> |
	 | State | <state> |
	 | Zip Code | <zipcode> |
	 | Country | <country> |
	 | Start Date | <startdate> |
	 | End Date | <enddate> |

Examples:
	| plantype | currentpassword | newpassword | confirmpassword | newemailaddress | confirmemailaddress | streetaddress | streetaddress2 | daytimephone | eveningphone | streetaddress | streetaddress2 | city     | state    | zipcode | country       | startdate  | enddate   | streetaddress | streetaddress2 | city     | state    | zipcode | country       | startdate  | enddate   |
	| PDP      | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 
        | MAPD     | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 
        | MA       | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 
        | MS       | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 
        | HIP      | Password@1      | Password@!  | Password@!      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|  abcd         | efgh           |california|california| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015| 


Scenario Outline:To verify My Preferences in AARP site
Given registered member for My Profile & Preferences in AARP Site
	| Plan Type | <plantype> |
When the user view My Profile & Preferences in AARP Site
And the user selects My Preferences in AARP Site
And the user views document name and delivery preferences for a plan in AARP Site
       | Document Name	      | 
       | Delivery Preferences |
Then user click update preferences
Examples:
	| plantype |
	| PDP      |
	| MAPD     |
	| MA       |
        | MS       |
        | HIP      |

Scenario Outline:To verify My Preferences and edit preferences in AARP site
Given registered member for My Profile & Preferences in AARP Site
	| Plan Type | <plantype> |
When the user view My Profile & Preferences in AARP Site
And the user selects My Preferences in AARP Site
And the user edits document name and delivery preferences for a plan in AARP Site
       | Document Name	      | <documentname>        |
       | Delivery Preferences | <deliverypreferences> |
Then user click update preferences
Examples:
	| plantype | documentname                                    | deliverypreferences |
	| PDP      | Annual Notice Of Changes Documents              | online              |
	| MAPD     | Prescription Drug Explanation of Benefits (EOB) | u.s.mail            |
	| MA       | Claims                                          | online              |
        | MS       | Claims                                          | online              |
        | HIP      | Claims                                          | online              | 
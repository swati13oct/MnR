@profileandpreferences
Feature:To test My Profile & Preferences flow in UMS site
Scenario Outline:To verify My Profiles in UMS site
Given registered member for My Profile & Preferences in UMS site
	| Plan Type      | <planType>  |
	| Member Type     | <memberType>|
When the user navigates to My Profiles in UMS site
Then the user validates the complete profile in UMS site
Examples:
	    | planType | memberType |
	#	| MA       | Individual |
	#	| MAPD     | Individual |
	#	| MA       | Group      |   
	#	| MAPD     | Group      |
	#	| PDP      | Group      |
	#	| SSUP     | Group      |
    #    | MAPD     |  Group     |


Scenario Outline:To verify My Profile and edit profile in UMS site
Given registered member for My Profile & Preferences in UMS site
	| Plan Type   | <planType> |
	| Member Type  | <memberType>|
When the user navigates to My Profiles in UMS site
And the user edits account profile in UMS site
	 | Current password      | <currentPassword>     |
	 | New password          | <newPassword>         |
	 | Confirm password      | <confirmPassword>     |
	 | New email address     | <newEmailAddress>     |
	 | Confirm email address | <confirmEmailAddress> |
And the user edits plan profile in UMS site
     | Street address  | <streetAddress>  |
	 | Street address2 | <streetAddress2> |
	 | Daytime phone   | <dayTimePhone>   |
	 | Evening phone   | <eveningPhone>   |
And the user edits alternate address in plan profile in UMS site
     | Street address  | <streetAddress>  |
	 | Street address2 | <streetAddress2> |
	 | City            | <city>           |
	 | State           | <state>          |
	 | Zip Code        | <zipCode>        |
	 | Country         | <country>        |
	 | Start Date      | <startDate>      |
	 | End Date        | <endDate>        |
And the user edits mailing address in plan profile in UMS site
     | Street address  | <streetAddress>  |
	 | Street address2 | <streetaddress2> |
	 | City            | <city>           |
	 | State           | <state>          |
	 | Zip Code        | <zipCode>        |
	 | Country         | <country>        |
	 | Start Date      | <startDate>      |
	 | End Date        | <endDate>        |
Then the user validates the complete profile in UMS site

Examples:

	| planType | memberType  |currentPassword  | newPassword | confirmPassword | newEmailAddress | confirmEmailAddress | streetAddress | streetAddress2 | dayTimePhone | eveningPhone | city       | state      | zipCode | country       | startDate  | endDate   | 
#	| PDP      |  Group      | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | california | CALIFORNIA | 90001   | UNITED STATES | 11-11-2014 | 12-12-2015|  
 #  | MAPD     |  Group      | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | california | CALIFORNIA | 90001   | UNITED STATES | 11-11-2014 | 12-12-2015|  
 #  | MA       |  Group      | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | california | CALIFORNIA | 90001   | UNITED STATES | 11-11-2014 | 12-12-2015|  
 #  | MA       | Individual  | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | california | CALIFORNIA | 90001   | UNITED STATES | 11-11-2014 | 12-12-2015|   
 #  | MAPD     | Individual  | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | california | CALIFORNIA | 90001   | UNITED STATES | 11-11-2014 | 12-12-2015|   
 #  | SSUP     | Group       | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com      | abcd          | efgh           | 902-955-8321 | 902-955-8456 | california | CALIFORNIA | 90001   | UNITED STATES | 11-11-2014 | 12-12-2015|  


Scenario Outline:To verify My Preferences in UMS site
Given registered member for My Profile & Preferences in UMS site
	| Plan Type   | <planType>  |
	| Member Type  | <memberType>|
When the user navigates to My Profiles in UMS site
And the user selects my preferences tab in UMS site
Then the user validates the document name and delivery preferences for a plan in UMS site
Examples:
	        | planType | memberType |
#			| MA       | Individual |
#			| MAPD     | Individual |
#			| MA       | Group      |   
#			| MAPD     | Group      |
#			| PDP      | Group      |
#			| SSUP     | Group      |




Scenario Outline:To verify My Preferences and edit preferences in UMS site
Given registered member for My Profile & Preferences in UMS site
	| Plan Type   | <planType> |
	| Member Type  | <memberType>|
When the user navigates to My Profiles in UMS site
And the user selects my preferences tab in UMS site
And the user changes delivery preferences for document name in UMS Site
    | Document Name	       | <documentName>        |
    | Delivery Preferences | <deliveryPreferences> |
And user click update preferences in UMS site
Then the user validates the document name and delivery preferences for a plan in UMS site
Examples:
	| planType | memberType |documentName                                      | deliveryPreferences  |
#	| PDP      | Group      |Annual Notice Of Changes Documents                | Online               |
#	| MAPD     | Group      |Prescription Drug Explanation of Benefits (EOB)   | U.S. Mail            |
#	| MA       | Group      |Claims                                            | Online               |
#   | SSUP     | Group      | Prescription Drug Explanation of Benefits (EOB)  | U.S. Mail            |
#   | MA       | Individual |Claims                                            | Online               |
#	| MAPD     | Individual |Prescription Drug Explanation of Benefits (EOB)   | U.S. Mail            |
         
@profileandpreferencesfnf	       
Scenario Outline:To verify whether add plan link is hidden in UMS site for AL PEEHIP
Given registered member for My Profile & Preferences in UMS site
	| Plan Type | <plantype> |
	| Member Type     | <memberType>|
When the user navigates to My Profiles in UMS site
And the add plan link should be hidden in UMS site
Examples:
	        | plantype | memberType |
		#| MA       | GROUP |
		#| MAPD     | INDIVIDUAL |
		| MAPD       | GROUP |



@agentAppointment
Feature: To test request an appointment with an agent flow in UHC site
@ebrc-UHC
Scenario Outline: Verify request an appointment with an agent flow in UHC site
Given the user is on the UHCM site landing page
When the user navigates to request more help and information in UHC site
And the user navigates to request appointment with an agent in UHC site
Then the user provides below personal details to request an appointment with an agent and complete the form
	| First Name | <firstName> |
	| Last Name  | <lastName>  |
	| Address    | <address>   |
	| City       | <city>      |
	| State      | <state>     |
	| ZipCode    | <zipcode>   |
	| Phone      | <phone>     |


Examples:
	| firstName | lastName | address | city | state      | zipcode | phone        |
	| Jon       | Doe      | address | LA   | California | 90001   | 999-999-9999 |

Scenario Outline: Verify request an appointment with an agent in plan summary flow of UMS site
Given the user is on the UHC medicare site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in UMS site
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
When the user navigates to Meet with an Agent in UHC site
And the user provides below personal details to request an appointment with an agent in UHC site
	| First Name | <firstName> |
	| Last Name  | <lastName>  |
	| Address    | <address>   |
	| City       | <city>      |
	| State      | <state>     |
	| ZipCode    | <zipcode>   |
	| Phone      | <phone>     |
Then the user validates the confirmation page in UHC site
Examples:
	| zipcode | county             | plantype | planName                                              | firstName | lastName | address | city | state      | zipcode | phone        |
	| 90210   | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 3 (HMO)     | Jon       | Doe      | address | LA   | California | 90001   | 999-999-9999 |
	

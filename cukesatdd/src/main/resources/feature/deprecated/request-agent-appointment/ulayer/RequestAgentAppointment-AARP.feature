@agentAppointment
Feature: To test request an appointment with an agent flow in AARP site
Scenario Outline: Verify request an appointment with an agent flow in AARP site
Given the user is on the AARP medicare site landing page
When the user navigates to request more help and information in AARP site
And the user navigates to request appointment with an agent in AARP site
And the user provides below personal details to request an appointment with an agent in AARP site
	| First Name | <firstName> |
	| Last Name  | <lastName>  |
	| Address    | <address>   |
	| City       | <city>      |
	| State      | <state>     |
	| ZipCode    | <zipcode>   |
	| Phone      | <phone>     |
Then the user validates the confirmation page in AARP site

Examples:
	| firstName | lastName | address | city | state      | zipcode | phone        |
	| Jon       | Doe      | address | LA   | California | 90001   | 999-999-9999 |
	
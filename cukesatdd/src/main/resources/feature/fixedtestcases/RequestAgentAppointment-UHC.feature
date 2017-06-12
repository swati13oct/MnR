@fixedTestCaseTest
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
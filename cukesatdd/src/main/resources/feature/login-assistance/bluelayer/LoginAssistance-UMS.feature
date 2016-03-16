@loginAssistanceTest
Feature: To test Login Assistance flow on UMS site 
Scenario Outline: Verify Login Assistance flow in UMS site when forgot username
Given user navigates to login assistance page from member UMS site
When the user selects the username or password checkbox in UMS site
	| <choice> |
And the user enters the below member details in personal information page in UMS site
	| Member Id	| <memberId> |
	| Date of Birth | <dob>	     |
	| Last Name	| <lastName> |
	| Zipcode	| <zipCode>  |
Then the user validates the successfully mail sent message in UMS site

Examples:
	| choice		| memberId	| dob		| lastName | zipCode |
	| username		| 824145384-01	| 07-02-1939	| OWRIA    | 06492   |
	| username,password	| 824145384-01	| 07-02-1939	| OWRIA    | 06492   |
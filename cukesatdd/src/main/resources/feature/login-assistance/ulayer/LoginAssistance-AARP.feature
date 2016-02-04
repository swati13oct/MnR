@loginAssistanceTest
Feature: To test Login Assistance flow on AARP site 
Scenario Outline: Verify Login Assistance flow in AARP site when forgot username
Given user navigates to login assistance page from member AARP site
When the user selects the username or password checkbox in AARP site
	| <choice> |
And the user enters the below member details in personal information page in AARP site
	| Member Id	| <memberId> |
	| Date of Birth | <dob>	     |
	| Last Name	| <lastName> |
	| Zipcode	| <zipCode>  |
Then the user validates the successfully mail sent message in AARP site

Examples:
	| choice		| memberId	| dob		| lastName    | zipCode |
	| username		| 0019389581	| 04-30-2005	| TIJRQGAD    | 38482   |
	| username,password	| 0019389581	| 04-30-2005	| TIJRQGAD    | 38482   |
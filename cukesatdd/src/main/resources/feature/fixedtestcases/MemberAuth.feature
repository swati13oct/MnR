@memberAuth
@fixedTestCaseTest
Feature:1.27-VBF-To test member auth flow on Stage
@memAuth
Scenario Outline: Verify member auth flow 
Given the user is on the member auth site for stage
And the user logs in with the credentials
	|Username | <username> |
	|Password | <password>|
Then the user puts in the username and navigates to rally and validates
	|Member | <member>|

	
Examples:
	| username 	  | password  | member |
	| qavgogine   | qavgogine | q4_dec_uhc203 |
	
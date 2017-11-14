@loginAssistance
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


@US622061
Scenario Outline: Verify Login Assistance flow error messages in AARP site
Given user navigates to login assistance page from member AARP site
When the user selects the username or password checkbox in AARP site
	| <choice> |
And the user clicks continue button without entering anything
Then the user validates the successfully all fields error messages

Examples:
	| choice |
	| username |
	| username,password |


@US622061
Scenario Outline: Verify Login Assistance flow error messages in AARP site
Given user navigates to login assistance page from member AARP site
When the user selects the username or password checkbox in AARP site
	| <choice> |
And the user enters the below member details in personal information page in AARP site
	| Member Id	| <memberId> |
	| Date of Birth | <dob>	     |
	| Last Name	| <lastName> |
	| Zipcode	| <zipCode>  |
Then the user validates the successfully all fields error messages

Examples:
	| choice		| memberId	| dob		| lastName    | zipCode |
	| username		| aaaaaaa	| a0-12-2005	| 7IJRQGAD    | a8482   |
	| username,password	| aaaaaaaa	| a0-12-2005	| 7IJRQGAD    | a8482   |


@US622159
Scenario: Verify Movement from Assistance confirmation to Sign In Page
Given user is on AssistanceConfirmationPage and moves to Sign in Page

@US622167
Scenario: Verify Movement from Identity Assistance to Personal Identification page
Given user is on Identity Assistance page selects Username and Password then user should be moved to Personal Identification page

#@US622167
Scenario: Verify Error messages on Personal Identification page
Given user is on Identity Assistance page and selects Nothing then user should be displayed error message

@US622156
Scenario: Verify Sign in page movement
Given user is on Identity Assistance page and clicks cancel then user should be taken to sign in page


@LoginAssistanceErrorMessages
Scenario: Verify Error messages on Ulayer Personal Identification page
Given user is on Identity Assistance page, moves to PI page and validates error messages

  @US738867 @spartans
  Scenario Outline: Fetch Username and Password on missing
    Given user navigates to login assistance page from member AARP site
    When select username and password
    Then confirmation page need to be displayed
      | memID    | <memberID> |
      | DBmm     | <DOBmm>    |
      | DBdd     | <DOBdd>    |
      | DOByyyy  | <DOByr>    |
      | LastName | <lstname>  |
      | zipcd    | <zip>      |

    Examples: 
      | memberID  | DOBmm | DOBdd | DOByr | lstname | zip   |
      | 861622172 |     7 |    21 |  1940 | EBAEA   | 27713 |
      | test |     7 |    21 |  1940 | EBAEA   | 27713 |
      | 861622172 |     7 |    21 |  1940 | 12345   | 27713 |
      | 861622172 |     7 |    21 |  1940 | EBAEA   | abcde |





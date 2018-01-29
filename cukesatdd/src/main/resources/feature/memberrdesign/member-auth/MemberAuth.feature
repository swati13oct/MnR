@smokeTest
Feature:To test sign functionality via member auth
@smokeTest_CsrLogin
Scenario Outline: To validate that member is successfully getting logged in to Rally Dashboard via CSR
Given I am a user of the member auth tool
    | Username | <username> |
  	| Password | <password> |
When I search for a member
	| Username1 | <username1> |
Then click on the member displayed in the search list
And I will see the disclaimer text at top of the page
Then all SUBMIT buttons display message when clicked on contact us page
Then request a call access should not be done and display message when clicked

    Examples: 
  | username  | password  | username1  |
  | qavgogine | qavgogine | q1_feb_uhc001 |
  | qavgogine | qavgogine | q1_aarp_feb156 |
  | qavgogine | qavgogine | q1_grp_feb036 |


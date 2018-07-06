@smokeTest
Feature: 1.08-VBF-MemRedesign-To test sign functionality via member auth
@smokeTest_CsrLogin @rallyDashboard
Scenario Outline: Validate that member is successfully getting logged in to Rally Dashboard via CSR
Given I am a user of the member auth tool
    | Username | <username> |
  	| Password | <password> |
When I search for a member
	| Username1 | <username1> |
Then click on the member displayed in the search list
And I will see the disclaimer text at top of the page
	| Disclaimer | <disclaimer> |
Then all SUBMIT buttons display message when clicked on contact us page
	| Message | <message> |
#Then request a call access should not be done and display message when clicked

    Examples: 
  | username  | password  | username1  | disclaimer | message |
  | qavgogine | qavgogine | q1_apr_uhc002 | read only access | You are not auhtorised to submit a question on behalf of member |
#  | qavgogine | qavgogine | q1_aarp_feb159 | read only access | You are not auhtorised to submit a question on behalf of member |
# | qavgogine | qavgogine | q1_grp_feb036 | read only access | You are not auhtorised to submit a question on behalf of member |

@smokeTest_CsrLoginMemID @rallyDashboard
Scenario Outline: Validate that member log in to Rally Dashboard via CSR memberID and DOB
Given I am a user of the member auth tool
    | Username | <username> |
  	| Password | <password> |
 When the member enter the member ID and DOB into Member ID field
      | Member ID | <memberID> |
      | Date of birth | <dateOfBirth> |
Then click on the member displayed in the search list
And I will see the disclaimer text at top of the page
	| Disclaimer | <disclaimer> |
Then all SUBMIT buttons display message when clicked on contact us page
	| Message | <message> |
#Then request a call access should not be done and display message when clicked

    Examples: 
  | username  | password  | memberID  | dateOfBirth |disclaimer | message |
  | qavgogine | qavgogine | 967169097-1 | 04-10-1942 | read only access | You are not auhtorised to submit a question on behalf of member |


@loginAssistance
Feature: To test Login Assistance flow on My PCP site

  Scenario Outline: Verify Login Assistance flow in My PCP site when forgot username
    Given user navigates to login assistance page from member My PCP site
    When the user selects the username or password checkbox in My PCP site
      | <choice> |
    And the user enters the below member details in personal information page in My PCP site
      | Member Id     | <memberId> |
      | Date of Birth | <dob>      |
      | Last Name     | <lastName> |
      | Zipcode       | <zipCode>  |
    Then the user validates the successfully mail sent message in My PCP site

    Examples: 
      | choice            | memberId     | dob        | lastName | zipCode |
      | username          | 950592474-01 | 12-12-1946 | GAYLE    |   33319 |
#      | password          | 950592474-01 | 12-12-1946 | GAYLE    |   33319 |
#      | username,password | 950592474-01 | 12-12-1946 | GAYLE    |   33319 |



@loginAssistance

  Scenario Outline: Verify Login Assistance flow in My Medica site when forgot username
    Given user navigates to login assistance page from member My PCP site
    When the user selects the username or password checkbox in My PCP site
      | <choice> |
    And the user enters the below member details in personal information page in My PCP site
      | Member Id     | <memberId> |
      | Date of Birth | <dob>      |
      | Last Name     | <lastName> |
      | Zipcode       | <zipCode>  |
    Then the user validates the personal identification error message in My pcp site

    Examples: 
      | choice   | memberId     | dob        | lastName | zipCode |
#      | username | 951498845-01 | 08-12-1945 | PRIME    |   33143 |
#      | password          | 951498845-01 | 08-12-1945 | PRIME    |   33143 |
      | username,password | 951498845-01 | 08-12-1945 | PRIME    |   33143 |


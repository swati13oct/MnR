@loginAssistance
Feature: To test Login Assistance flow on My Medica site

  Scenario Outline: Verify Login Assistance flow in My Medica site when forgot username
    Given user navigates to login assistance page from member My Medica site
    When the user selects the username or password checkbox in My Medica site
      | <choice> |
    And the user enters the below member details in personal information page in My Medica site
      | Member Id     | <memberId> |
      | Date of Birth | <dob>      |
      | Last Name     | <lastName> |
      | Zipcode       | <zipCode>  |
    Then the user validates the successfully mail sent message in My Medica site

    Examples: 
      | choice   | memberId     | dob        | lastName | zipCode |
#      | username | 951498845-01 | 08-12-1945 | PRIME    |   33143 |
#      | password          | 951498845-01 | 08-12-1945 | PRIME    |   33143 |
      | username,password | 951498845-01 | 08-12-1945 | PRIME    |   33143 |

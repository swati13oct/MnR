Feature: My Medication Page
  To validate user navigate to My Medication Page

  @Sanity @Regression
  Scenario Outline: To verify My Medication Page display active 10 drugs and disclaimer
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    And user clicks View all medications link to view the My Medications page
    Then user validates the disclaimer Medication appearance subject to change
    Then user validates first ten of his active prescriptions
    And user advance and reverse through the pages

    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Free@123 | Berniewb    | PDP      | Individual |

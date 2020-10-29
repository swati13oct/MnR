Feature: MedCab Load On P&P Page
  To validate MedCab Load On P&P Page

  @Sanity @Regression
  Scenario Outline: To verify MedCab Load On P&P Page
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
    And user view MedCab load successfully on PnP page
    Then user validates the disclaimer Medication appearance subject to change
    And user validates first six of his active prescriptions

    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Free@123 | Berniewb    | PDP      | Individual |

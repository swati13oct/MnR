Feature: Change or Add Payment Details
  To validate Change or Add Payment Details

  @Regression
  Scenario Outline: To verify Change or Add Payment Details
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
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    When user view the Payment section
    When user select Change Payment
    Then user will view Change Payment in a full page modal

    Examples: 
      | username | password | memUserName                          | planType | memberType |
      | kjadha10 | Virus$$1 | b2dc8f2f-56d5-43e5-bef3-bb36ad49d6f9 | PDP      | Individual |
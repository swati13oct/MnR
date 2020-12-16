Feature: Change Shipping Address
  To validate Change Shipping Address

  @Regression
  Scenario Outline: To verify Change Shipping Address
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
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page

    Examples: 
      | username | password | memUserName                          | planType | memberType |
      | kjadha10 | Virus$$1 | 9ac57f09-f46f-4989-99af-53f86c089e07 | PDP      | Individual |

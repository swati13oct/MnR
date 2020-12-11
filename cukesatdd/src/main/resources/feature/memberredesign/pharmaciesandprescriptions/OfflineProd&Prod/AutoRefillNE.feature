Feature: Auto Refill NE
  To validate Auto Refill NE

  @Regression
  Scenario Outline: To verify Auto refill filled not displayed
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
    Then user will not view the Auto Refill display

    Examples: 
      | username | password | memUserName   | planType | memberType |
      | kjadha10 | Virus$$1 | Everett123fish| PDP      | Individual |

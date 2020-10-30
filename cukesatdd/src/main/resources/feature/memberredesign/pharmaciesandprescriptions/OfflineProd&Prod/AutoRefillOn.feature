Feature: Auto Refill On
  To validate Auto Refill On

  @Regression
  Scenario Outline: To verify Auto Refill Checkbox is checked
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
    Then user will see the auto refill line populate for any eligible medications on Refill Checkout Summary Page
    Then user will view Auto Refill On displaying checked box
    When user deselect the auto refill checkbox
    Then user will view auto refill disenrollment page asking for stop auto refill
    When user select Continue auto refill
    Then user will see "Complete Your Refill" Page

    Examples: 
      | username | password | memUserName                          | planType | memberType |
      | kjadha10 | Free@123 | bc76bb53-1748-4883-a8a8-588ef6c36ee6 | PDP      | Individual |

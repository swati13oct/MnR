Feature: Auto Refill Off
  To validate Auto Refill Off

  @Regression
  Scenario Outline: To verify Auto Refill checkbox is unchecked
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
    Then user will view Auto Refill off displaying unchecked box
    When user select the auto refill checkbox
    Then user will view auto refill enrollment page asking for enroll auto refill
    When user select Cancel
    Then user will see "Complete Your Refill" Page

    Examples: 
      | username | password | memUserName                          | planType | memberType |
      | kjadha10 | Free@123 | ce929863-9037-483a-8475-43ba067eb8fc | PDP      | Individual |

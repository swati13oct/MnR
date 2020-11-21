Feature: Auto Refill NE
  To validate Auto Refill NE

  @STAGERegression
  Scenario Outline: To verify Auto refill filled not displayed
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    Then user will not view the Auto Refill display

    Examples:
      | planType | memberType             |
      | PDP     | Rx_Refill_AutoRefillNE |

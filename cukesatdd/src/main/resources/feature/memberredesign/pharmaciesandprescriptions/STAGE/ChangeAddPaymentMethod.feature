Feature: Change or Add Payment Details
  To validate Change or Add Payment Details

  @STAGERegression
  Scenario Outline: To verify Change or Add Payment Details
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    When user view the Payment section
    When user select Change Payment
    Then user will view Change Payment in a full page modal

    Examples:
      | planType | memberType             |
      | PDP     | Rx_Refill_ChangePaymentMethod |

Feature: Refill All Medications CTA - My Medications
  To validate Refill All Medications CTA

  @STAGERegression
  Scenario Outline: To verify Refill All Medications CTA displayed on My Medications page if user is eligible for refill
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    And user will view an explanation of the Refill All Medications CTA
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication

    Examples:
      | planType | memberType             |
      | PDP     | Rx_Refill_AutoRefillOff |

  @STAGERegression
  Scenario Outline: To verify Refill All Medications CTA is not displayed on My Medications page if user is not eligible for refill
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    And user clicks View all medications link to view the My Medications page
    And user DO NOT have home delivery medications currently eligible for refill
    Then user will NOT view the Refill All Medications CTA on MY Medications Page
    And user will not see an explanation of the Refill All Medications CTA

    Examples:
      | planType | memberType             |
      | PDP     | Rx_Refill_AutoRefillOff |

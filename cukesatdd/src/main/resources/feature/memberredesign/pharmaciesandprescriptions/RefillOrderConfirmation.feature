Feature: Refill - Order confirmation
  I am a user of the M&R Portal with Rx benefits I must have access to Refill order confirmation

  @RefillMedications @F481928 @US2767410 @Scenario3
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Navigate to P&P page
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user have a home delivery medication eligible for refill
    And user clicks Refill Medication call to action button
    Then user views the Medications section
    When user clicks PLACE ORDER button
    Then user views refill order confirmation page
    When user selects the Go to Pharmacies And Prescriptions button
    Then user views the Pharmacies And Prescriptions page
    And the status of this refill and CTA are updated per this refill transaction

    Examples:
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |


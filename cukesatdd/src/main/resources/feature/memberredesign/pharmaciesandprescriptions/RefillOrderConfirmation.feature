Feature: Refill Order Confirmation
  Display Refill order confirmation.

  @RefillOrderConfirmation @F481928 @F496830 @US2767412 @US2767413 @US2767418 @US2767425 @US2767426 @US2767427 @US2767424 @US2767457 @US2853935
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Refill Order Confirmation page components
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    And user fetches medication information and clicks on Refill Medication call to action button from My Medication
    Then user will see "Complete Your Refill" Page
    And user will see Place Order Btn
    And user will click on Place Order btn
    Then user will see Refill order confirmation page
    Then user will see order number
    Then user will see order placed date
    Then user will see order tracked as Order Received
    Then user will see order confirmation email messaging
    Then user will see Order Confirmation section
    Then user will see the shipping method displayed
    Then user will see the shipping address displayed
    Then user will see the payment method displayed
    Then user will view NA in the Price Total field
    Then user will see an order total disclaimer displayed
    Then user will see the estimated delivery date
    When user view the Medications section
    Then user will see the drug name and strength
    And user will see the day supply
    And user will view NA in the Medication Price field
    And user will view the Rx number
    And user will view the provider
    And user will view the remaining refills
    When user select the Go to Pharmacies and Prescriptions button
    Then user will view the PnP page
    And the page should be refreshed so that the status of this refill and CTA are updated per this refill transaction

    Examples: 
      | FID     | planType | memberType                        |
      | F481928 | MAPD     | Rx_Individual_Refill_Confirmation |

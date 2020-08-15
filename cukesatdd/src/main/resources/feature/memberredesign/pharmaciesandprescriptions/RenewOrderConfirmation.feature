Feature: Renew Order Confirmation
  Display Renew order confirmation.

  @RenewOrderConfirmation @F484053 @US2777880 @US2777881 @US2777882 @US2777883 @US2777884 @US2777885 @US2777886
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Refill Order Confirmation page components
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information and clicks on Renew Medication call to action button
    Then user will see "Complete Your Renewal" Page
    And user will see Place Order Btn
    When user clicks on Place Order btn
    Then user will see Renew order confirmation page
    Then user will see order placed date
    Then user will see order tracked as Order Received
    Then user will see order confirmation email messaging
    Then user will see Order Confirmation section
    Then user will see the shipping method displayed
    Then user will see the shipping address displayed
    Then user will see the payment method displayed
    Then user will see the order total displayed
    Then user will see an order total disclaimer displayed
    Then user will see the estimated delivery date alert message
    When user view the Medications section
    Then user will see the drug name and strength
    And user will see the day supply
    And user will view the price
    And user will view the Rx number
    And user will view the provider
    When user select the Go to Pharmacies and Prescriptions button
    Then user will view the PnP page
    And the page should be refreshed so that the status of this renew and CTA are updated per this renew transaction

    Examples: 
      | FID     | planType | memberType                                |
      | F484053 | MAPD     | Rx_Individual_PnP_rx_renewal_Confirmation |

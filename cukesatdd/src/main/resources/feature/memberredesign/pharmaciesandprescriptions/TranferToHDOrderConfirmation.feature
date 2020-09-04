Feature: Transfer Order Confirmation
  Display Transfer order confirmation

  @TransferToHDConfirmation @F484053 @US2777921 @US2777922 @US2777924 @US2777925 @US2777926 @US2777923 @F496830 @US2853935
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Renew Order Confirmation page components
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication informations and clicks on Transfer To HD call to action button
    Then user will see "Transfer to Home Delivery" Page
    And user will see Place Order Btn
    Then user will click on Place Order btn on Checkout Transfer Page
    Then user will see Transfer order confirmation page
    Then user will see order placed date
    Then user will see order tracked as Order Received
    Then user will see order confirmation email messaging
    Then user will see Order Confirmation section
    Then user will see the shipping method displayed
    Then user will see the shipping address displayed
    Then user will see the payment method displayed
    Then user will view the Price Total field
    Then user will see an order total disclaimer displayed
    Then user will see the estimated delivery date alert message
    When user view the Medications section
    And user will see the drug name and strength on Transfer Confirmation
    And user will see the day supply
    And user will view rx price in the Medication Price field
    And user will view the Rx number
    And user will view the provider
    When user select the Go to Pharmacies and Prescriptions button
    Then user will view the PnP page
    And the page should be refreshed so that the status of this transfer request is updated per this transfer transaction

    Examples: 
      | FID     | planType | memberType                                  |
      | F484053 | MAPD     | Rx_Individual_PnP_TransferToHD_Confirmation |

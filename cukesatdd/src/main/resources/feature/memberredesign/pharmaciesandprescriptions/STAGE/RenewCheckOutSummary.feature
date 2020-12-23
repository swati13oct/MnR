Feature: Renew Checkout Summary Page

  @STAGERegression
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Complete Your Renewal Page Functionality
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication informations and clicks on Renew Medication call to action button
    Then user will see "Complete Your Renewal" Page
    When user views the Medications section
    Then user will see the number of medications in my order indicated in the header
    And user validates the medication name and strength
    And user validates the price
    And user validates the day supply for Renew
    And user validates the Rx number
    And user validates the provider
    And user sees a Remove Item From Order CTA
    And user will see message about OptumRx contacting the provider for a new prescription
    #And user will see the estimated delivery date for each shipment
    When user view the Order summary section
    Then user will see the line item Medications
    And user will see the number of prescriptions included in the order
    And user will see the total price of all medications in the order
    And user will see the line item Shipping
    And user will see the price of the shipping for renew
    And user will see the price total
    And the total will include medication and shipping cost
    And user will see a disclaimer related to estimated order total
    And user will see Place Order Btn
    When user will view the section above Place Order Btn
    Then user will see a message about shipping address
    And user will see shipping address
    When user view the Payment section
    Then user will see Preferred payment method
    And user will see the card type
    And user will see the last four digits of the card number
    And user will view the card expiration date
    And user will view the marker Preferred Credit Card
    And user will see a Change Payment CTA
    When user view the Shipping Address section
    Then user will see Preferred shipping address
    And user will view the Preferred Address label
    And user will view the Change Shipping address CTA
    When user view the bottom of Skyline Complete Your Renew Component
    Then user will view the disclaimer message
    And disclaimer will remind the user that "OptumRx" is fulfilling the order

    Examples: 
      | planType | memberType                    |
      | PDP      | Rx_Refill_ChangePaymentMethod |

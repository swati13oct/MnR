Feature: To test Transfer To HD Checkout Summary Page

  @Regression @Sanity
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Transfer to Home Delivery Page Functionality
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    And user fetches medication informations and clicks on Transfer To HD call to action button on My Medication Page
    Then user will see "Transfer to Home Delivery" Page
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
    When user view the bottom of Skyline Transfer to HD Component
    Then user will view the disclaimer message
    And disclaimer will remind the user that "OptumRx" is fulfilling the order

    Examples: 
      | FID     | username | password | MemUserName | planType | memberType     |
      | F484057 | ntalesha | pass@123 | DorisJean27 | MPDP     | Individual_PnP |

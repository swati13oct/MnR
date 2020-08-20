@F481927
Feature: Refill - Checkout summary
  I am a user of the M&R Portal with Rx benefits I must have access to checkout information for refillable medications

  @F481927 @US2767410 @Scenario1 @NeedToTest
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication number
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    And user clicks Refill Medication call to action button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    Then user will see the number of medications in my order indicated in the header

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767410 @Scenario2 @NeedToTest @TestAgain
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication information 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information and clicks on Refill Medication call to action button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    And user validates the medication name and strength
    And user validates the price
    And user validates the day supply
    And user validates the Rx number
    And user validates the provider
    And user validates the remaining refills

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767410 @Scenario5 @Test
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove Items From Order CTA
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the Medications section
    And user sees a Remove Item From Order CTA

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767407 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Line Item Medications in Order Summary Section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    When user view the Order summary section
    Then user will see the line item Medications
    And user will see the number of prescriptions included in the order

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767407 @Scenario2 @NeedToTest @TestReady
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify price of Prescriptions in Order Summary Section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    When user view the Order summary section
    Then user will see the total price of all medications in the order

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767407 @Scenario3 @Test
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Line Item Shipping in Order Summary Section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    When user view the Order summary section
    Then user will see the line item Shipping
    And user will see the price of the shipping

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767407 @Scenario4 @TestReady
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Total Price in Order Summary Section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    When user view the Order summary section
    Then user will see the price total
    And the total will include medication and shipping cost

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767407 @Scenario5
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Disclaimer in Order Summary Section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    When user view the Order summary section
    Then user will see a disclaimer related to estimated order total

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2781924 @Scenario1 @Test
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Confirmation Shipping Address in Order Summary Section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    When user will view the section above Place Order Btn
    Then user will see a message about shipping address
    And user will see shipping address

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767408 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Line Item Medications in Order Summary Section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    When user view the Payment section
    Then user will see Preferred payment method

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767408 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Payment Details
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    When user view the Payment section
    Then user will see the card type
    And user will see the last four digits of the card number
    And user will view the card expiration date
    And user will view the marker Preferred Credit Card
    And user will see a Change Payment CTA

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767409 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Shipping Address Details
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    When user view the Shipping Address section
    Then user will see Preferred shipping address
    And user will view the Preferred Address label
    And user will view the Change Shipping address CTA

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767408 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Place Order Buttn
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    Then user views the "Complete Your Refill" page
    And user will see Place Order Btn

    #When user clicks on Place Order Btn
    #Then user will see the Order Confirmation Page
    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F481927 @US2767408 @Scenario1 @TestReady
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Estimated Delivery Date
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    #And user clicks View all medications link to view the My Medications page
    #And user clicks Refill All Medication call to action button
    Then user views the "Complete Your Refill" page
    When user views the Medications section
    #When user medications are grouped into more than one shipment
    #Then user will see the different shipments indicated
    Then user will see the estimated delivery date for each shipment

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  #@F481927 @US2767408 @Scenario1 @Test
  #Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Auto Refill Line Populate
  # Given login with following details logins in the member portal and validate elements
  #  | Plan Type   | <planType>   |
  # | Member Type | <memberType> |
  #When user navigates to the pharmacies and prescriptions page from testharness page
  #And user clicks Refill Medication call to action button
  #Then user views the "Complete Your Refill" page
  #When user views the Medications section
  #Then user will see the auto refill line populate for any eligible medication
  #Examples:
  # | FID     | planType | memberType                  |
  #| F481927 | PDP      | Rx_Individual_PnP_rx_refill |
  @F481927 @Regression
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Complete Your Refill Page Functionality
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information and clicks on Refill Medication call to action button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    Then user will see the number of medications in my order indicated in the header
    And user validates the medication name and strength
    And user validates the price
    And user validates the day supply
    And user validates the Rx number
    And user validates the provider
    And user validates the remaining refills
    And user sees a Remove Item From Order CTA
    And user will see the estimated delivery date for each shipment
    When user view the Order summary section
    Then user will see the line item Medications
    And user will see the number of prescriptions included in the order
    And user will see the total price of all medications in the order
    And user will see the line item Shipping
    And user will see the price of the shipping
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

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

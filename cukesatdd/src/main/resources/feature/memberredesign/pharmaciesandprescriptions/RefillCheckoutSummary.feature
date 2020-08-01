Feature: Refill - Checkout summary
  I am a user of the M&R Portal with Rx benefits I must have access to checkout information for refillable medications

  @RefillMedications @F481927 @US2767410 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication number
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user have a home delivery medication eligible for refill
    And user clicks Refill Medication call to action button
    Then user views the Medications section
    And User will see the number of medications in my order indicated in the header

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767410 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication information 
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user have a home delivery medication eligible for refill
    And user clicks Refill Medication call to action button
    Then user views the Medications section
    And user validates the medication name
    And user validates the strength of the medication
    And user validates the price I paid for the medication
    And user validates the day supply of the medication
    And user views the Rx number
    And user views the provider
    And user views the remaining refills

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767410 @Scenario3
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication shipments
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    When user clicks Refill All Medications button
    Then user views the Medications section
    Then user sees the different shipments indicated
    And user sees the estimated delivery date for each shipment

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767410 @Scenario4
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Auto refill
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user have a home delivery medication eligible for refill
    And user clicks Refill Medication call to action button
    Then user views the Medications section
    Then user sees the auto refill line populate for any eligible medication
    And user sees an information icon

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767410 @Scenario5
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user have a home delivery medication eligible for refill
    And user clicks Refill Medication call to action button
    Then user views the Medications section
    And user sees a Remove Item link

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767407 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user view the Order summary section
    Then user will see the line item Medications
    And user will see the number of prescriptions included in the order

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767407 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user view the Order summary section
    Then user will see the total price of all medications in the order

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767407 @Scenario3
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user view the Order summary section
    Then user will see the line item Shipping
    And user will see the price of the shipping

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767407 @Scenario4
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user view the Order summary section
    Then user will see the price total
    And the total will include medication and shipping cost

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767407 @Scenario5
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user view the Order summary section
    Then user will see a disclaimer related to estimated order total

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2781924 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user view the Order summary section
    Then user will see a message about shipping address
    And user will see shipping address

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767408 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user view the Payment section
    Then user will see my Preferred payment method

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767408 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user view the Payment section
    Then user will see the card type
    And user will see the last four digits of the card number
    And user will view the card expiration date
    And user will view the marker Preferred Credit Card
    And user will see a Change Payment link

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767409 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user view the Shipping Address section
    Then user will see my Preferred shipping address
    And user will view the Preferred Address label
    And user will view the Change Shipping address link

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @RefillMedications @F481927 @US2767408 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove links
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user have a home delivery medication eligible for refill
    When user clicks Refill Medication call to action button
    Then user views the Complete Your Refill page
    When user select Place Order
    Then user will view the order confirmation page

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

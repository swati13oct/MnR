Feature: MVP - Current Medications
  I am a user of the M&R Portal with Rx benefits, I must have access to Current Medications on P&P Page

  @CurrentMedications @F392596 @US2301927 @tip
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views medicine cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    And user validates first six of his active prescriptions
    And user validates medications will be displayed beginning with the ones that have an associated call to action

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2301927
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views all medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    And user valides View all medications link text

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2301927
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views all active medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user clicks View all medications link
    Then user will be directed to My Medications page

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2301927
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views Current Medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    Then user validates a number in parentheses
    And user validates the number will correspond to the total number of active medications he has

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2301927
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication image disclaimer
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    Then user validates the disclaimer Medication appearance subject to change

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2301928
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views medication information on medicine cabinet
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    And user validates his active prescriptions displayed on the page
    And user validates the medication name
    And user validates an image of the medication
    And user validates the strength of the medication
    And user validates the price I paid for the medication
    And user validates the pharmacy where the medication was last filled
    And user validates the day supply of the medication
    And user validates the order status if applicable
    And user validates any relevant calls to action to manage the medication
    And user validates information on remaining refills
    And user validates a button "Contact Pharmacy" to contact my retail pharmacy

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2301929 @Kiran
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user selects drug on Current Medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user clicks medication name of one of his active prescriptions listed on the Current Medications
    Then user validates the Drug Info overview page for that prescription/medication in the same browser tab

    Examples: 
      | FID     | planType | memberType      |
      | F392596 | MAPD     | Rx_Group_PnP_rx |

  @MedicineCabinet @F392596 @US2301929 @Kiran
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user  selects Learn More button on Current Medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user clicks on the Learn More button on one of my active prescriptions listed under Current Medications
    Then validate user redirects to the Drug Info page for that prescription/medication in the same browser tab

    Examples: 
      | FID     | planType | memberType          |
      | F392596 | MAPD     | Rx_Indiviual_PnP_rx |

  @MedicineCabinet @F392596 @US2508786 @Kiran
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views order status on Medicine Cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user views a home delivery drug listed in his Current Medications
    Then user validates that home delivery drug is associated with a current order

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508786 @Kiran
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify with doctor, Order Verified
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user views a home delivery drug listed in his Current Medications
    Then user validates the status of Verifying with doctor or status of Order verified
    Then user views an empty Harvey Ball on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify request received
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user views a home delivery drug order
    And user views a status of Request received
    Then user views one fourth Harvey Ball on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Processing
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user views a home delivery drug order
    And user views a status of Processing
    Then user views  a half Harvey Ball on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedication @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Shipped
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user views a home delivery drug order
    And user views a status of Shipped
    Then user views a 3/4 Harvey Ball on that medication row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedication @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Delivered
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user views a home delivery drug order
    And user views a status of  Delivered
    Then user views a full Harvey Ball with a checkmark on that medication row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on payment method hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views active medications
    When user views one of his active medications has a payment method hold on it
    Then user validates a red On Hold indicator
    Then user validates a green Resolve hold button on that medication's row
    And user validates the external link icon in the button

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on verify address hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views active medications
    When user views one of his active medications has a address hold on it
    Then user validates a red On Hold indicator
    Then user validates a green Resolve hold button on that medication's row
    And user validates the external link icon in the button

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on Price Adjustment hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views active medications
    When user views one of his active medications has  a price adjustment hold on it
    Then user validates a red On Hold indicator
    Then user validates a green Resolve hold button on that medication's row
    And user validates the external link icon in the button

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on CALL hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views active medications
    When user views one of his active medications has a Call hold on it
    Then user validates a red On Hold indicator
    Then user validates a green Resolve hold button on that medication's row
    And user validates the external link icon in the button

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on informational hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views active medications
    When user views one of his active medications has an informational hold on it
    Then user validates a red On Hold indicator
    Then user validates a green Resolve hold button on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home Delivery medication eligible for refill
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views active medications
    When user views a Refill Medication call to action button on that medication's row
    Then user validates the external link icon in the button

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home Delivery medication eligible for renewal
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views active medications
    When user views a Renew Medication call to action button on that medication's row
    Then user validates the external link icon in the button

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home delivery order in progress
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    When user views  an active medication currently in progress for home delivery
    Then user views a Track Status call to action button on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home delivery order delivered
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    When user views an active medication home delivery order that has been delivered
    Then user views a View Order call to action button on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869 @Kiran
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Refill medication (SSO)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user views a Refill Medication call to action button on that medication's row
    When user clicks Refill Medication call to action button
    Then user views the OptumRx landing page in a new browser tab

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869 @Kiran
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Renew medication (SSO)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user views a Renew Medication call to action button on that medication's row
    When user clicks the Renew Medication call to action button
    Then user views the OptumRx landing page in a new browser tab

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869 @Kiran
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify  Resolve hold (SSO)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user views a home delivery medication on hold
    When user clicks the Resolve Hold call to action button
    Then user views the OptumRx landing page in a new browser tab

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869 @Kiran
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Track status
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user views  an active medication currently in progress for home delivery
    When user clicks the Track Status call to action button on that medication's row
    Then user views the Home Delivery tab on the Drug Info page for that medication

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MedicineCabinet @F392596 @US2508869 @Kiran
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify View order
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user views the Current Medications
    When user views an active medication home delivery order that has been delivered
    When user clicks the View order call to action button on that medication's row
    Then user views the Home Delivery tab on the Drug Info page for that medication

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2618672
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Contact Pharmacy Call To Action For Retail Medications
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user have active retail medications
    Then user will view active retail medications
    And user will see a "Green" "Contact Pharmacy" button

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2618672
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Contact Pharmacy Call To Action For Retail Medications
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user have active retail medications
    And user select the green "Contact Pharmacy" button
    Then user will view a popup with the phone number available to call

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on payment method hold
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    And user have active medications
    And one of user active medications has a payment method hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on verify address hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    And user have active medications
    When one of user active medications has an address hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on Price Adjustment hold
    Given I am an M&R member viewing Current Medications the Medicine Cabinet
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    And user have active medications
    When one of user active medications has a price adjustment hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on CALL hold
    Given I am an M&R member viewing Current Medications the Medicine Cabinet
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    And user have active medications
    When one of user active medications has a Call hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CurrentMedications @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on informational hold
    Given I am an M&R member viewing Current Medications the Medicine Cabinet
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    And user have active medications
    When one of user active medications has an informational hold on it
    Then user will NOT see a "Red" "On Hold" indicator
    And user will NOT see a "Green" "Resolve hold" button on that medication row

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |
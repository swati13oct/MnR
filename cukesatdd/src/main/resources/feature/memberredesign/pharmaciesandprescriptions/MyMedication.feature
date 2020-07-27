@F448402
Feature: MVP - My Medications
  I am a user of the M&R Portal with Rx benefits, I must have access to My Medications on P&P Page

  @MyMedications @F448402 @US2568656 @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Member views Active Prescription Drugs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    Then user validates first ten of his active prescriptions
    And user validates medications will be displayed beginning with the ones that have an associated call to action

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568656 @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Member has more than 10 active prescriptions
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    When user has more than ten active prescriptions
    Then user validates up to ten of his active prescriptions
    And user advance and reverse through the pages

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on payment method hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    And one of user active medications has a payment method hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on verify address hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When one of user active medications has an address hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on Price Adjustment hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When one of user active medications has a price adjustment hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on CALL hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When one of user active medications has a Call hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType         |
      | F448402 | PDP     | Rx_Grp_PnP_rx_Call |

  @MyMedications @F448402 @US2568667 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on informational hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When one of user active medications has an informational hold on it
    Then user will NOT see a "Red" "On Hold" indicator
    And user will NOT see a "Green" "Resolve hold" button on that medication row

    Examples: 
      | FID     | planType | memberType           |
      | F448402 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667 @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home Delivery medication eligible for refill
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When user have a home delivery medication eligible for refill
    Then user validates the external link icon in the button

    Examples: 
      | FID     | planType | memberType                          |
      | F392596 | MAPD      | Rx_Individual_PnP_rx_refill_renewal |

  @MyMedications @F448402 @US2568667 @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home Delivery medication eligible for renewal
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When user views a home delivery medication eligible for renewal
    Then user validates the external link icon in the button

    Examples: 
      | FID     | planType | memberType                          |
      | F392596 | MAPD      | Rx_Individual_PnP_rx_refill_renewal |

  @MyMedications @F448402 @US2568667 @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home delivery order in progress
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When user views an active medication currently in progress for home delivery
    Then user views a Track Status call to action button on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667 @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home delivery order delivered
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When user views an active medication home delivery order that has been delivered
    Then user views a View Order call to action button on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568665 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Shipped
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user views the Medicine Cabinet on the My Medications page
    When user views a home delivery drug order
    And user views a order having status of Shipped
    Then user views a 3/4 Harvey Ball on that medication row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Group_PnP_Shipped |

  @MyMedications @F448402 @US2568665 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Delivered
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user views the Medicine Cabinet on the My Medications page
    When user views a home delivery drug order
    And user views a order having status of  Delivered
    Then user views a full Harvey Ball with a checkmark on that medication row

    Examples: 
      | FID     | planType | memberType             |
      | F392596 | MAPD     | Rx_Group_PnP_Delivered |

  @MyMedications @F448402 @US2618939 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Contact Pharmacy Call To Action For Retail Medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active retail medications
    And user will view active retail medications
    And user will see a "Green" "Contact Pharmacy" button

    Examples: 
      | FID     | planType | memberType      |
      | F392596 | MAPD     | Rx_Group_PnP_rx |

  @MyMedications @F448402 @US2618939 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Contact Pharmacy Call To Action For Retail Medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active retail medications
    When user select the green "Contact Pharmacy" button
    Then user will view a popup with the phone number available to call

    Examples: 
      | FID     | planType | memberType      |
      | F392596 | MAPD     | Rx_Group_PnP_rx |

  @MyMedications @F448402 @US2568665 @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball:Request received
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user views the Medicine Cabinet on the My Medications page
    When user views a home delivery drug order
    And user views a status of Request received
    Then user views one fourth Harvey Ball on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568665 @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Processing
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user views the Medicine Cabinet on the My Medications page
    When user views a home delivery drug order
    And user views a status of Processing
    Then user views  a half Harvey Ball on that medication's row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568656 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Member selects the next page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    When user select the next page arrow
    Then user will see remaining prescriptions on the My Medications page

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F392596 @US2508869 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Refill medication (SSO)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    When user have a home delivery medication eligible for refill
    And user clicks Refill Medication call to action button
    Then user views the OptumRx "My Prescriptions" page in a new browser tab

    Examples: 
      | FID     | planType | memberType                  |
      | F436319 | MAPD     | Rx_Individual_PnP_rx_refill |

  @MyMedications @F392596 @US2508869 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Renew medication (SSO)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    When user views a home delivery medication eligible for renewal
    And user clicks the Renew Medication call to action button
    Then user will view the OptunRx "My Prescriptions" page in a new browser tab

    Examples: 
      | FID     | planType | memberType                   |
      | F436319 | PDP     | Rx_Individual_PnP_rx_renewal |

  @MyMedications @F392596 @US2508869 @Naresh @Testing @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Resolve hold (SSO)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    When user views a home delivery medication on hold
    And user clicks the Resolve Hold call to action button
    Then user views the OptumRx "Order Status" page in a new browser tab

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

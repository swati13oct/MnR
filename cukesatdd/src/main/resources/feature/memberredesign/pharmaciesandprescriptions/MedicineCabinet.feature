#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: MVP - Call to Action
  I am a user of the M&R Portal with Rx benefits, I must have access to Medicine Cabinet on P&P Page

  ##############################################----US2301927-----###############################################################################
  #Kiran
  @MedicineCabinet @F392596 @US2301927 @TestB
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views medicine cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
    And user validates first five of his active prescriptions
    And user validates medications will be displayed beginning with the ones that have an associated call to action // how do we make sure that?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |

#Yusufu
  @MedicineCabinet @F392596 @US2301927
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views all medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
    And user valides "View all medications" link text

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


#Naresh
  @MedicineCabinet @F392596 @US2301927
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views all active medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user clicks "View all medications" link
    Then user will be directed to My Drugs page

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


##############################################----US2301928-----###############################################################################

#Kiran

  @MedicineCabinet @F392596 @US2301928
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views medication information on medicine cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
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
    And user validates a phone number if no refills are available and the drug is not eligible for transfer

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |

##############################################----US2301929-----###############################################################################


#Yusufu
  @MedicineCabinet @F392596 @US2301929
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user selects drug on medicine cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
    When user clicks medication name of one of his active prescriptions listed on the Medicine cabinet
    Then user validates the Drug Detail overview page for that prescription/medication in the same browser tab

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |



##############################################---- US2508786-----###############################################################################

#Naresh

  @MedicineCabinet @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views order status on Medicine Cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
    When user views a home delivery drug listed in his medicine cabinet
    And user validates that home delivery drug is associated with a current order // how ?
    Then user validates the order status //  (Request Received, Verifying with Doctor, Order Verified, Processing, ShippedDelivered)

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |

  @MedicineCabinet @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify with doctor, Order Verified
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
    When user views a home delivery drug order // different from home delivery drug listed in his medicine cabinet?
    Then user validates the status of Verifying with doctor or status of Order verified
    Then user views an empty Harvey Ball on that medication's row

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


#Kiran

  @MedicineCabinet @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify request received
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
    When user views a home delivery drug order // different from home delivery drug listed in his medicine cabinet?
    And user views a status of Request received
    Then user views 1/4 Harvey Ball on that medication's row // how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Processing
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
    When user views a home delivery drug order // different from home delivery drug listed in his medicine cabinet?
    And user views a status of Processing
    Then user views  a 1/2 Harvey Ball on that medication's row // how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


 #Yusufu

  @MedicineCabinet @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Shipped
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
    When user views a home delivery drug order // different from home delivery drug listed in his medicine cabinet?
    And user views a status of Shipped
    Then user views a 3/4 Harvey Ball on that medication's row// how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508786
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Delivered
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views the Medicine Cabinet
    When user views a home delivery drug order // different from home delivery drug listed in his medicine cabinet?
    And user views a status of  Delivered
    Then user views a full Harvey Ball with a checkmark on that medication's row// how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |



##############################################---- US2508869-----###############################################################################

#Naresh

  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on payment method hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views active medications
    When user views one of his active medications has a payment method hold on it
    Then user validates a red "On Hold" indicator
    Then user validates a green "Resolve hold" button on that medication's row
    And user validates the external link icon in the button // what icon and how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |




  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on verify address hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views active medications
    When user views one of his active medications has a address hold on it
    Then user validates a red "On Hold" indicator
    Then user validates a green "Resolve hold" button on that medication's row
    And user validates the external link icon in the button // what icon and how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |



  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on Price Adjustment hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views active medications
    When user views one of his active medications has  a price adjustment hold on it
    Then user validates a red "On Hold" indicator
    Then user validates a green "Resolve hold" button on that medication's row
    And user validates the external link icon in the button // what icon and how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on CALL hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views active medications
    When user views one of his active medications has a Call hold on it
    Then user validates a red "On Hold" indicator
    Then user validates a green "Resolve hold" button on that medication's row
    And user validates the external link icon in the button // what icon and how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on informational hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views active medications
    When user views one of his active medications has an informational hold on it
    Then user validates a red "On Hold" indicator
    Then user validates a green "Resolve hold" button on that medication's row

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |

  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home Delivery medication eligible for refill
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views active medications
    When user views a "Refill Medication" call to action button on that medication's row // one active medications is eligible for a refil
    Then user validates the external link icon in the button // what icon and how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home Delivery medication eligible for renewal
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user views active medications
    When user views a "Refill Medication" call to action button on that medication's row// one active medications is eligible for a renew
    Then user validates the external link icon in the button // what icon and how to validate it?

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home delivery order in progress
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user views  an active medication currently in progress for home delivery // (Request Received, Verifying with Doctor, Order Verified, Processing/Processed, Shipped)
    Then user views a "Track Status" call to action button on that medication's row

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Home delivery order delivered
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user views an active medication home delivery order that has been delivered
    Then user views a "View Order" call to action button on that medication's row

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Refill medication (SSO)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user views a "Refill Medication" call to action button on that medication's row
    When user clicks Refill Medication call to action button
    Then user views the OptumRx landing page in a new browser tab

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Renew medication (SSO)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user views a "Refill Medication" call to action button on that medication's row
    When user clicks the Renew Medication call to action button
    Then user views the OptumRx landing page in a new browser tab

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify  Resolve hold (SSO)
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user views a home delivery medication on hold
    When user clicks the Resolve Hold call to action button
    Then user views the OptumRx landing page in a new browser tab

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Track status
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user views  an active medication currently in progress for home delivery // (Request Received, Verifying with Doctor, Order Verified, Processing/Processed, Shipped)
    When user clicks the "Track Status" call to action button on that medication's row
    Then user views the Home Delivery tab on the Drug Details page for that medication

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |



  @MedicineCabinet @F392596 @US2508869
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify View order
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user views an active medication home delivery order that has been delivered
    When user clicks the "View order" call to action button on that medication's row
    Then user views the Home Delivery tab on the Drug Details page for that medication

    Examples:
      | FID     | planType | memberType             | expectLink |
      | F392596 | MAPD     | AARP_Individual_PnP_rx | yes        |



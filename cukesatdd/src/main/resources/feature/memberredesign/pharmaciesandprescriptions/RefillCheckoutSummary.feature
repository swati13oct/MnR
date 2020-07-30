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



@F479509
Feature: Refill medication CTA
  I am a user of the M&R Portal with Rx benefits I must have access to checkout information for refillable medications

  @F479509 @US2759127 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication number
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user have a home delivery medication eligible for refill
    And user clicks Refill Medication call to action button
    Then user will be brought to the "Complete Your Refill" page for that medication

    Examples: 
      | FID     | planType | memberType                  |
      | F436319 | PDP      | Rx_Individual_PnP_rx_refill |

  @F479509 @US2759129 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication number
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    When user have a home delivery medication eligible for refill
    And user clicks Refill Medication call to action button
    Then user will be brought to the "Complete Your Refill" page for that medication

    Examples: 
      | FID     | planType | memberType                  |
      | F436319 | PDP      | Rx_Individual_PnP_rx_refill |

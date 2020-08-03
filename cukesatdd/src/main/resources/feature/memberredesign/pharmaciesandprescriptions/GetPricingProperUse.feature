Feature: Get Pricing Proper Use - Current Medications
  I am a user of the M&R Portal with Rx benefits I must have access Get Pricing Proper Use on Current Medications

  @GetPricingPropeUse @F478530 @US2748151 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Drug name link on Current Medications 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user clicks on the name of a drug
    Then validate user redirects to the Proper Use tab of the Find Price page

    Examples:
      | FID     | planType | memberType          |
      | F392596 | MAPD     | Rx_Indiviual_PnP_rx |



  @GetPricingPropeUse @F478530 @US2748151 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Drug name link on Current Medications 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user views the Medicine Cabinet on the My Medications page
    When user clicks on the name of a drug
    Then validate user redirects to the Proper Use tab of the Find Price page

    Examples:
      | FID     | planType | memberType          |
      | F392596 | MAPD     | Rx_Indiviual_PnP_rx |


  @GetPricingPropeUse @F478530 @US2747605 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Drug name link on Current Medications 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user select the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples:
      | FID     | planType | memberType          |
      | F392596 | MAPD     | Rx_Indiviual_PnP_rx |

  @GetPricingPropeUse @F478530 @US2747605 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Drug name link on Current Medications 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user views the Medicine Cabinet on the My Medications page
    When user select the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples:
      | FID     | planType | memberType          |
      | F392596 | MAPD     | Rx_Indiviual_PnP_rx |
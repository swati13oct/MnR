Feature: Technical Touchpoints
  I am a user of the M&R Portal with Rx benefits I must have a prescription at Walgreens and wishes to do a Refill while on Find and Price page.

  @TechnicalTouchpoints @F479113 @US2793282 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Manage at Walgreens
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user has a Walgreens drug
    When user selects the Get Pricing button on that drug
    Then user views the Prices page for that medication
    Then user sees the Manage at Walgreens CTA
    When user click on the Manage at Walgreens Call to Action button
    When user clicks Proceed
    Then the browser redirects to the Walgreens website where the member will be able to fulfill their prescription

    Examples: 
      | FID     | planType | memberType                      |
      | F482427 | MAPD     | AARP_Individual_PnP_rx_walgreen |


  @TechnicalTouchpoints @F479113 @US2793282 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Manage at Walgreens
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user has a Walgreens drug
    When user selects the Get Pricing button on that drug
    Then user views the Prices page for that medication
    Then user sees the Manage at Walgreens CTA
    When user click on the Manage at Walgreens Call to Action button
    When user clicks on the Cancel button on the modal
    Then user views the Prices page for that medication

    Examples:
      | FID     | planType | memberType                      |
      | F482427 | MAPD     | AARP_Individual_PnP_rx_walgreen |


  @TechnicalTouchpoints @F479113 @US2750575 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Manage at Walgreens
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user selects the Get Pricing button on that drug
    Then user views the Prices page for that medication
    Then user sees the Transfer to Walgreens cta option for each Walgreens store that appears in the search results
    When user clicks on the Transfer to Walgreens cta
    When user clicks Proceed
    Then the browser redirects to the Walgreens website where the member will be able to fulfill their prescription

    Examples:
      | FID     | planType | memberType                      |
      | F482427 | MAPD     | AARP_Individual_PnP_rx_not_walgreen |


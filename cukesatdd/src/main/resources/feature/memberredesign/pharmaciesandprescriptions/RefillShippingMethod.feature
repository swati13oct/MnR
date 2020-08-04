@F481922
Feature: Refill - Shipping method
  Display default shipping method (standard - free) and allow members to choose expedited shipping for refill medication orders. 

  @F481922 @US2767428 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove Items From Order CTA
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    And user is viewing "Complete Your Refill" Page
    Then user will see a Select Shipping Method menu
    And user will see the shipping method selection menu default to "Standard Shipping: Free"

    Examples: 
      | FID     | planType | memberType           |
      | F481927 | MAPD     | Rx_Individual_PnP_rx |

  @F481922 @US2767429 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove Items From Order CTA
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    And user is viewing "Complete Your Refill" Page
    Then user select the shipping method selection menu
    And user will see the shipping options:
      | Standard Shipping - Free |
      | Two-day Shipping - $XX   |
      | Expedited Shipping - $XX |

    Examples: 
      | FID     | planType | memberType           |
      | F481927 | MAPD     | Rx_Individual_PnP_rx |

  @F481922 @US2767429 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove Items From Order CTA
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    And user is viewing "Complete Your Refill" Page
    And user select the shipping method selection menu
    And user choose Two-day shipping
    Then user will see my two-day shipping populate the shipping method field 

    Examples: 
      | FID     | planType | memberType           |
      | F481927 | MAPD     | Rx_Individual_PnP_rx |

  @F481922 @US2767429 @Scenario3
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove Items From Order CTA
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    And user is viewing "Complete Your Refill" Page
    And user select the shipping method selection menu
    And user choose Expedited Shipping
    Then user will see expedited shipping populate the shipping method field 

    Examples: 
      | FID     | planType | memberType           |
      | F481927 | MAPD     | Rx_Individual_PnP_rx |

  @F481922 @US2767429 @Scenario4
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove Items From Order CTA
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks Refill Medication call to action button
    And user is viewing "Complete Your Refill" Page
    And user select the shipping method selection menu
    And user choose Standard Shipping
    Then user will see standard shipping populate the shipping method field

    Examples: 
      | FID     | planType | memberType           |
      | F481927 | MAPD     | Rx_Individual_PnP_rx |

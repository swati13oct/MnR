Feature: MVP - Call to Action
  I am a user of the M&R Portal with Rx benefits I must have the ability for members to refill medications with Walgreens by using the Refill with Walgreens CTA

  @RefillWithWalgreens @F482427 @US2508876 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify View Refill with Walgreens CTA
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user has a Walgreens drug
    Then user sees the walgreens button
    And user validates the external link icon in the button

    Examples: 
      | FID     | planType | memberType                      |
      | F482427 | MAPD     | AARP_Individual_PnP_rx_walgreen |


  @RefillWithWalgreens @F482427 @US2508876 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Select Refill with Walgreens
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user has a Walgreens drug
    When user click on the walgreens button
    When user clicks Proceed
    Then the browser redirects to the Walgreens website where the member will be able to fulfill their prescription

    Examples:
      | FID     | planType | memberType                      |
      | F482427 | MAPD     | AARP_Individual_PnP_rx_walgreen |

  @RefillWithWalgreens @F482427 @US2508876 @Scenario3
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Select Refill with Walgreens
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user has a Walgreens drug
    When user click on the walgreens button
    When user clicks on the Cancel button on the modal
    Then user view the PAndP page

    Examples:
      | FID     | planType | memberType                      |
      | F482427 | MAPD     | AARP_Individual_PnP_rx_walgreen |



  @RefillWithWalgreens @F482427 @US2770427 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify View Refill with Walgreens CTA
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    When user has a Walgreens drug
    Then user sees the walgreens button
    And user validates the external link icon in the button

    Examples:
      | FID     | planType | memberType                      |
      | F482427 | MAPD     | AARP_Individual_PnP_rx_walgreen |


  @RefillWithWalgreens @F482427 @US2770427 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Select Refill with Walgreens
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    When user has a Walgreens drug
    When user click on the walgreens button
    When user clicks Proceed
    Then the browser redirects to the Walgreens website where the member will be able to fulfill their prescription

    Examples:
      | FID     | planType | memberType                      |
      | F482427 | MAPD     | AARP_Individual_PnP_rx_walgreen |


  @RefillWithWalgreens @F482427 @US2770427 @Scenario3
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Select Refill with Walgreens
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    When user has a Walgreens drug
    When user click on the walgreens button
    When user clicks on the Cancel button on the modal
    Then user view the PAndP page

    Examples:
      | FID     | planType | memberType                      |
      | F482427 | MAPD     | AARP_Individual_PnP_rx_walgreen |
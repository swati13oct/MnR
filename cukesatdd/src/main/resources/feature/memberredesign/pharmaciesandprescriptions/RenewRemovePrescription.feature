@F484054
Feature: Renew - Remove prescription
  I am a user of the M&R Portal with Rx benefits I Create ability for members to remove a prescription from the Renew flow. 

  @F484054 @US2777889 @Scenario1 @Scenario2 @Scenario3
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove item link
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user clicks Renew Medication call to action button to navigate to checkout page
    Then user will see "Complete Your Renewal" Page
    When user clicks remove item from Order link
    When user views popup modal and selects Cancel
    Then user will see "Complete Your Renewal" Page
    When user clicks remove item from Order link
    When user views popup modal and selects X
    Then user will see "Complete Your Renewal" Page


    Examples:
      | FID     | planType | memberType             |
      | F484054 | PDP      | Rx_Individual_PnP_rx_renewal |



  @F484054 @US2777891 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication number
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user clicks Renew Medication call to action button to navigate to checkout page
    Then user will see "Complete Your Renewal" Page
    When user clicks remove item from Order link
    When user views popup modal and selects Yes
    When user clicks remove item from Order link
    Then user will see the number of medications in my order indicated in the header
    And a message confirming my medication was removed
    And a message indicating there are no prescriptions to

    Examples: 
      | FID     | planType | memberType             |
      | F484054 | PDP      | Rx_Individual_PnP_rx_renewal |


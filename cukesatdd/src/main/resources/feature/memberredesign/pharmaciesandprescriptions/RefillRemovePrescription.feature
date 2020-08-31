@F482460
Feature: Refill - Remove prescription
  I am a user of the M&R Portal with Rx benefits I Create ability for members to remove a prescription from the Refill flow. 

  @F482460 @US2770453 @Scenario1 @Scenario2 @Scenario3
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Remove item link
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    When user clicks remove item from Order link
    When user views popup modal and selects Cancel
    Then user will be brought to the "Complete Your Refill" page for that medication
    Then user will see the number of medications in my order indicated in the header
    When user clicks remove item from Order link
    When user views popup modal and selects X
    Then user will be brought to the "Complete Your Refill" page for that medication
    Then user will see the number of medications in my order indicated in the header


    Examples:
      | FID     | planType | memberType             |
      | F482460 | MAPD     | Rx_Individual_Refill_Remaining |



  @F482460 @US2770449 @Scenario1 @Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication number
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    When user clicks remove item from Order link
    When user views popup modal and selects Yes
    Then user will be brought to the "Complete Your Refill" page for that medication
    Then user will see the number of medications in my order indicated in the header
    And a message confirming my medication was removed
    And a message indicating there are no prescriptions to be transferred
    When user returns to the My Medications page
    Then user will be brought to the "Complete Your Refill" page for that medication

    Examples: 
      | FID     | planType | memberType             |
      | F482460 | MAPD     | Rx_Individual_Refill_Remaining |


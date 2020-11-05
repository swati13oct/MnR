@F479511
Feature: Transfer To Home Delivery CTA
  I am a user of the M&R Portal with Rx benefits I must have access to TransferToHD CTA for eligible retail medications

  @F479511 @US2784933 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Transfer CTA displayed for eligible retail medications
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user have a retail medication eligible for transfer to home delivery
    Then user will see the "Transfer to Home Delivery" button for eligible medication

    Examples: 
      | FID     | planType | memberType             |
      | F479511 | MAPD     | Rx_PnP_Retail_Transfer |

  @F479511 @US2759116 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Transfer to Home Delivery page when user clicks on Transfer to HD CTA
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user have a retail medication eligible for transfer to home delivery
    Then user will see the "Transfer to Home Delivery" button for eligible medication
    When user select the Transfer to Home Delivery button on a drug card
    Then user will be brought to the "Transfer to Home Delivery" page for that medication

    Examples: 
      | FID     | planType | memberType             |
      | F479511 | MAPD     | Rx_PnP_Retail_Transfer |

@F484059
Feature: Transfer - Remove prescription
  I am a user of the M&R Portal with Rx benefits I Create ability for members to remove a prescription from the Transfer flow.

  @F484059 @US2777919
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Medication number
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication informations and clicks on Transfer To HD call to action button
    Then user will see Transfer to Home Delivery page
    When user clicks remove item from Order link
    When user views popup modal and selects Yes
    Then user will see Transfer to Home Delivery page
    Then user will see the number of medications in my order indicated in the header
    And a message confirming my medication was removed
    And a message indicating there are no prescriptions
    When user returns to the My Medications page

    Examples:
      | FID     | planType | memberType             |
      | F484059 | MAPD     | Rx_PnP_Retail_Transfer |
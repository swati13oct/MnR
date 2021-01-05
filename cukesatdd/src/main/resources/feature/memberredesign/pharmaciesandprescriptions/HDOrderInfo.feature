@F499693
Feature: HD Order Status - Order Info
  I am a user of the M&R Portal with Rx benefits I must see the Order Number on Order Info Section

  @F499693 @US2871880
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify order number in Order info section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user clicks on Track Status CTA having an order number
    Then user view the Order Status component for that order
    And user will view the Order Number

    Examples: 
      | FID     | planType | memberType             |
      | F499693 | MAPD     | Rx_Group_PnP_Delivered |

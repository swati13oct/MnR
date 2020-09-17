@F499651
Feature: HD Order Status - Order Received

  Order Received status will be displayed when a refill order is placed or when a new prescription has been submitted in response to a renewal or transfer request. 

  @OrderStatusOrderReceived @F499651 @US2871636 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views medicine cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    Then user views a status of order received
    When user clicks the Track Status call to action button on that medication's row
    Then user view the Order Status page for the medication
    And user sees a status of Order received on Step one of the tracker

    Examples:
      | FID     | planType | memberType           |
      | F439294 | MAPD     | Rx_Individual_PnP_OrderReceived |


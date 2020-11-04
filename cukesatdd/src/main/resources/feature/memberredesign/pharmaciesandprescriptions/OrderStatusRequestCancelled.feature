@F507731
Feature: HD Order Status - Cancelled

  Order Received status will be displayed when a refill order is placed or when a new prescription has been submitted in response to a renewal or transfer request. 

  @OrderStatusCancelled @F507731 @US2923822
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views medicine cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    When user views a status of Request canceled and click view order
    Then user view the Order Status page for the medication
    Then user views request cancelled status
    Then user views a triangle icon on step one tracker
    And user views a message that my request has been cancelled

    Examples:
      | FID     | planType | memberType           |
      | F507731 | MAPD     | Rx_Individual_PnP_canceledOrder |


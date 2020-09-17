@F499650
Feature: HD Order Status - Order Received

  Order Received status will be displayed when a refill order is placed or when a new prescription has been submitted in response to a renewal or transfer request. 

  @OrderStatusRequestPlaced @F499650 @US2871668 @Scenario1 @Scenario3
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views medicine cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    When user views a status of request placed and click track status
    Then user view the Order Status page for the medication
    Then user views a status of request placed
    And user views estimated delivery date is Pending
    And user will not see an order number

    Examples:
      | FID     | planType | memberType           |
      | F499650 | MAPD     | Rx_Individual_PnP_Requestplaced |


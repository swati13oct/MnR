Feature: HD Order Status - Shipped
  Display Shipped status when an order has been shipped but is not yet in transit. 

  @OrderStatusShipped @F439294 @F499653 @US2944240 @US2944238 @US2871896
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Shipped Status on Order Status page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user views a home delivery drug order
    And user clicks View all medications link to view the My Medications page
    And user views order status as Shipped
    Then user views a three fourth Harvey Ball on that medication row

    Examples: 
      | FID     | planType | memberType             |
      | F499653 | PDP      | Rx_OrderStatus_Shipped |


  @OrderStatusShipped @F439294 @F499653 @US2944240 @US2944238 @US2871848
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Shipped Status on Order Status page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user views a home delivery drug order
    And user clicks View all medications link to view the My Medications page
    When user views a status of Shipped and click track status
    Then user view the Order Status page for the medication
    Then user views a status of Shipped on Step two of the tracker

    Examples:
      | FID     | planType | memberType             |
      | F499653 | PDP      | Rx_OrderStatus_Shipped |

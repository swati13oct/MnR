@F439294
Feature: Order Statuses - P&P, My Meds

  @OrderStatuses @F439294 @US2871892
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views received order status
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    Then user views a status of order received cta
    Then user views one fourth Harvey Ball on that medication's row

    Examples:
      | FID     | planType | memberType           |
      | F439294 | MAPD     | Rx_Individual_PnP_OrderReceived |


  @OrderStatuses @F439294 @US2871891
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views Request placed order status
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    When user views a status of request placed cta
    Then user views an empty Harvey Ball


    Examples:
      | FID     | planType | memberType           |
      | F439294 | MAPD     | Rx_Individual_PnP_Requestplaced |


  @OrderStatuses @F439294 @US2871893
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views Processing order status
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    When user views a status of Processing
    Then user views a half Harvey Ball on that medication's row


    Examples:
      | FID     | planType | memberType           |
      | F439294 | MAPD     | Rx_Individual_PnP_processing |



  @OrderStatuses @F439294 @US2923817
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views request cancelled order status
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    When user views a status of Request canceled
    Then user views an empty Harvey Ball


    Examples:
      | FID     | planType | memberType           |
      | F439294 | MAPD     | Rx_Individual_PnP_canceledOrder |
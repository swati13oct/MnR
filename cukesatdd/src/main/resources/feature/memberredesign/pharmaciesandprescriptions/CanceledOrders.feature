Feature: Canceled orders - Current Meds and My Medications

  As an M&R member using the M&R member portal, I want to view canceled orders on my medication cards, so I know that my order is no longer pending with OptumRx

  @CanceledOrders @F479500 @US2752268 @Scenario1@Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Canceled order status�and Harvey Ball
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user views a home delivery drug order
    Then user views a status of Request canceled
    Then user views an empty Harvey Ball

    Examples:
      | FID     | planType | memberType           |
      | F479500 | MAPD     | Rx_Individual_PnP_canceledOrder |


  @CanceledOrders @F479500 @US2752268 @Scenario3@scenario4 @qonaq
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Canceled order Call to action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user views a home delivery drug order
    Then user views a status of Request canceled
    Then user views a View Order call to action button on that medication's row
    When user clicks the View order call to action button
    Then user view the Order Status page for the medication

    Examples:
      | FID     | planType | memberType             |
      | F479500 | MAPD     | Rx_Individual_PnP_canceledOrder |


  @CanceledOrders @F479500 @US2752268 @Scenario1@Scenario2
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Canceled order status�and Harvey Ball
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    When user views a home delivery drug order
    Then user views a status of Request canceled
    Then user views an empty Harvey Ball


    Examples:
      | FID     | planType | memberType           |
      | F479500 | MAPD     | Rx_Individual_PnP_canceledOrder |


  @CanceledOrders @F479500 @US2752268 @Scenario3@scenario4
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Canceled order Call to action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    When user views a home delivery drug order
    Then user views a status of Request canceled
    Then user views a View Order call to action button on that medication's row
    When user clicks the View order call to action button
    Then user view the Order Status page for the medication

    Examples:
      | FID     | planType | memberType             |
      | F479500 | MAPD     | Rx_Individual_PnP_canceledOrder |
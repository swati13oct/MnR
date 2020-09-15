@F439294
Feature: Order Statuses - P&P, My Meds

  @OrderStatuses @F439294 @US2871892 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views medicine cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    Then user views a status of order received
    Then user views one fourth Harvey Ball on that medication's row

    Examples:
      | FID     | planType | memberType           |
      | F439294 | MAPD     | Rx_Individual_PnP_OrderReceived |


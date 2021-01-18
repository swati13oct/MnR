@F499652
Feature: HD Order Status - Processing

  As an M&R member who has submitted a renewal or transfer request, I want to view the status Processing when OptumRx is processing the order, so I know where my order is in the proce

  @OrderStatusProcessing@F499650 @US2871844 @Scenario1
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user views medicine cabinet
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    When user views a status of Processing and click track status
    Then user view the Order Status page for the medication
    Then user views a status of Processing
    And user views a message that my order is being processed


    Examples:
      | FID     | planType | memberType           |
      | F499652 | MAPD     | Rx_Individual_PnP_processing |


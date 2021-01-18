Feature: Order holds - P&P/My Meds
  Direct members from the Pharmacies & Prescriptions/My Medications pages to the Skyline order status page for online hold resolution. 

  @OrderHolds @F510954 @US2942418 @CallHolds
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To resolve the call hold on my order  
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    And user views an active order with Call hold
    When user selects the Resolve Hold CTA
    Then user will view the Order Status page for that order

    Examples:
      | FID     | planType | memberType          |
      | F392596 | MAPD     | Rx_Indiviual_PnP_rx |



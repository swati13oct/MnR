Feature: Resolve holds - Skyline
   Skyline order status page to resolve OptumRx home delivery order holds online

  @ResolveHolds @F510953 @US2942461 @ResolveCallHolds
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To view messaging related to that call hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    And user views an active order with Call hold
    When user selects the Resolve Hold CTA
    Then user will view the Order Status page for that order
    Then user sees an triangle alert icon and text indicating his order is on hold
    And user sees messaging about his hold
    And user will not see an external link icon
    When user selects the Contact Us link
    Then user will see the contact us page open in a new tab

    Examples:
      | FID     | planType | memberType          |
      | F392596 | MAPD     | Rx_Indiviual_PnP_rx |



Feature: Refill All Medications CTA - My Medications
  As an M&R member using the M&R member portal, I want to be able to order all of my available home delivery refills at once, so I can place my orders as easily as possible.

  @RefillAllMedicationsCTA_MyMedications @F479518 @US2770421 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Refill All Medications CTA displayed on My Medications page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    When user have a home delivery medication eligible for refill
    Then user will view the Refill All Medications CTA on MY Medications Page
    And user will view an explanation of the Refill All Medications CTA

    Examples: 
      | FID     | planType | memberType                 |
      | F479518 | PDP     | Rx_Individual_PnP_rx_refill |

  @RefillAllMedicationsCTA_MyMedications @F479518 @US2770421 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Refill All Medications CTA displayed on My Medications page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user DO NOT have home delivery medications currently eligible for refill
    Then user will NOT view the Refill All Medications CTA on MY Medications Page
    And user will not see an explanation of the Refill All Medications CTA

    Examples: 
      | FID     | planType | memberType                 |
      | F479518 | MAPD     | AARP_Individual_PnP_rx     |

  @RefillAllMedicationsCTA_MyMedications @F479518 @US2770422 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Refill All Medications CTA displayed on My Medications page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    When user have a home delivery medication eligible for refill
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    Then user will view all eligible refill medications moved into the refill flow

    Examples: 
      | FID     | planType | memberType                 |
      | F479518 | PDP      | Rx_Individual_PnP_rx_refill |

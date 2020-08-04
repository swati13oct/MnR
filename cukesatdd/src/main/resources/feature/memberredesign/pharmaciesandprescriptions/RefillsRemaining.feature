@F479509
Feature: Refills Remaining

  @F479509
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Refill Left Field for HD Prescription on My Medication Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    And user views the HD Medications on My Medications page
    And user will see "Refills Left" field

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @F479509
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Refill Remaining Value for HD Prescription on My Medication Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    And user views the HD Medications on My Medications page
    When user will see "Refills Left" field
    Then user validates amount of refills remaining for the prescriptions

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @F479509
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Refill Left Field for HD Prescription on Current Medication
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    And user views the HD Medications on Current Medications
    And user will see "Refills Left" field

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @F479509
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Refill Remaining Value for HD Prescription on Current Medication
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    And user views the HD Medications on Current Medications
    When user will see "Refills Left" field
    Then user validates amount of refills remaining for the prescriptions

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @F479509
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Refill Left Field not available for Retail Prescription on Current Medication
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user view a medication card with a retail prescription
    Then user will not see the "Refills Left" field for that prescriptions

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

  @F479509
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Refill Left Field not available for Retail Prescription on Current Medication
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will be directed to My Medications page
    When user view a medication card with a retail prescription
    Then user will not see the "Refills Left" field for that prescriptions

    Examples: 
      | FID     | planType | memberType           |
      | F436319 | MAPD     | Rx_Individual_PnP_rx |

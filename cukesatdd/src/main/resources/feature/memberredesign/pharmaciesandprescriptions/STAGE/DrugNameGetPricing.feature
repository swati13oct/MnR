Feature: Drug Name and Get Pricing
  To validate Drug Name and Get Pricing

  @STAGERegression
  Scenario Outline: To verify MAPD user has access to Drug Name
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user clicks on the name of a drug
    Then user views the Prices page for that medication

    Examples: 
      | planType | memberType     |
      | MAPD     | MAPD_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify MAPD user has access to Get Pricing
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user clicks the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples: 
      | planType | memberType     |
      | MAPD     | MAPD_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify PDP user has access to Drug Name
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user clicks on the name of a drug
    Then user views the Prices page for that medication

    Examples: 
      | planType | memberType    |
      | PDP      | PDP_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify PDP user has access to Get Pricing
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user clicks the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples: 
      | planType | memberType    |
      | PDP      | PDP_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify PCP user has access to Drug Name
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user clicks on the name of a drug
    Then user views the Prices page for that medication

    Examples: 
      | planType | memberType    |
      | PCP      | PCP_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify PCP user has access to Get Pricing
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user clicks the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples: 
      | planType | memberType    |
      | PCP      | PCP_Pnp_rally |

Feature: Userland on P&P Page
  To validate User Land on P&P Page Successfully.

  @STAGERegression
  Scenario Outline: To verify PDP individual user Pharmacy and Prescription Page load successfully
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page

    Examples: 
      | planType | memberType     |
      | PDP      | PDP_Individual |

  @STAGERegression
  Scenario Outline: To verify PDP group user Pharmacy and Prescription Page load successfully
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page

    Examples: 
      | planType | memberType |
      | PDP      | PDP_Group  |

  @STAGERegression
  Scenario Outline: To verify MAPD individual user Pharmacy and Prescription Page load successfully
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page

    Examples: 
      | planType | memberType      |
      | MAPD     | MAPD_Individual |

  @STAGERegression
  Scenario Outline: To verify MAPD group user Pharmacy and Prescription Page load successfully
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page

    Examples: 
      | planType | memberType |
      | MAPD     | MAPD_Group |

  @STAGERegression
  Scenario Outline: To verify AL SEIB user Pharmacy and Prescription Page load successfully
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page

    Examples: 
      | planType | memberType |
      | MAPD     | SEIB_Pnp   |

  @STAGERegression
  Scenario Outline: To verify AL LGHIB user Pharmacy and Prescription Page load successfully
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page

    Examples: 
      | planType | memberType |
      | MAPD     | LGHIB_Pnp  |

  @STAGERegression
  Scenario Outline: To verify PCP user Pharmacy and Prescription Page load successfully
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page

    Examples: 
      | planType | memberType    |
      | PCP      | PCP_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify Medica user Pharmacy and Prescription Page load successfully
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page

    Examples: 
      | planType | memberType       |
      | Medica   | Medica_Pnp_rally |

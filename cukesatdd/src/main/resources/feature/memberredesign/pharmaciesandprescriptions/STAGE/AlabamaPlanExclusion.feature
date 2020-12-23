Feature: Alabama Plan Exclusion
  To validate Alabama plans (AL SEIB and AL LGHIB) do not view any content related to OptumRx home delivery.

  @STAGERegression
  Scenario Outline: To verify AL SEIB plans do not view any content related to OptumRx home delivery
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user views common questions section
    Then user not view any questions related to OptumRx home delivery
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window

    Examples: 
      | planType | memberType |
      | MAPD     | SEIB_Pnp   |

  @STAGERegression
  Scenario Outline: To verify AL LGHIB plans do not view any content related to OptumRx home delivery
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user views common questions section
    Then user not view any questions related to OptumRx home delivery
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window

    Examples: 
      | planType | memberType |
      | MAPD     | LGHIB_Pnp  |

  @STAGERegression
  Scenario Outline: To verify PDP plans view any content related to OptumRx home delivery
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user views common questions section
    Then user views any questions related to OptumRx home delivery

    Examples: 
      | planType | memberType |
      | PDP      | PDP_Pnp    |

  @STAGERegression
  Scenario Outline: To verify MAPD plans view any content related to OptumRx home delivery
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user views common questions section
    Then user views any questions related to OptumRx home delivery

    Examples: 
      | planType | memberType |
      | MAPD     | MADP_Pnp   |

  @STAGERegression
  Scenario Outline: To verify (AL SEIB) P&P Notification is deactivated
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is deactivated

    #When a PnP notification is activated
    Examples: 
      | planType | memberType |
      | MAPD     | SEIB_Pnp   |

  @STAGERegression
  Scenario Outline: To verify (AL LGHIB) P&P Notification is deactivated
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is deactivated

    #When a PnP notification is activated
    Examples: 
      | planType | memberType |
      | MAPD     | LGHIB_Pnp  |

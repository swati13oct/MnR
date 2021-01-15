Feature: Alabama Plan Exclusion
  To validate Alabama plans (AL SEIB and AL LGHIB) do not view any content related to OptumRx home delivery.

  @Regression
  Scenario Outline: To verify AL SEIB plans do not view any content related to OptumRx home delivery
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    When user views common questions section
    Then user not view any questions related to OptumRx home delivery
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window using memAuth

    Examples: 
      | username | password | memUserName | planType                | memberType |
      | yaihemai | Yusufu7$ | Aldridge314 | GroupMAPDWithoutPayment | Group      |

  @Regression
  Scenario Outline: To verify AL LGHIB plans do not view any content related to OptumRx home delivery
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    When user views common questions section
    Then user not view any questions related to OptumRx home delivery
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window using memAuth

    Examples: 
      | username | password | memUserName | planType                | memberType |
      | yaihemai | Yusufu7$ | Xldycop     | GroupMAPDWithoutPayment | Group      |

  @Regression
  Scenario Outline: To verify PDP plans view any content related to OptumRx home delivery
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    When user views common questions section
    Then user views any questions related to OptumRx home delivery

    Examples: 
      | username | password | memUserName  | planType                | memberType |
      | yaihemai | Yusufu7$ | WENDYKETHAN2 | GroupMAPDWithoutPayment | Group      |

  @Regression
  Scenario Outline: To verify MAPD plans view any content related to OptumRx home delivery
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    When user views common questions section
    Then user views any questions related to OptumRx home delivery

    Examples: 
      | username | password | memUserName | planType | memberType |
      | yaihemai | Yusufu7$ | LUGRUG11    | MAPD     | Individual |

  @Sanity @Regression
  Scenario Outline: To verify (AL SEIB) P&P Notification is deactivated
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    When a PnP notification is deactivated

    #When a PnP notification is activated
    Examples: 
      | username | password | memUserName | planType                | memberType |
      | kjadha10 | Virus$$1 | Aldridge314 | GroupMAPDWithoutPayment | Group      |

  @Sanity @Regression
  Scenario Outline: To verify (AL LGHIB) P&P Notification is deactivated
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    When a PnP notification is deactivated

    #When a PnP notification is activated
    Examples: 
      | username | password | memUserName | planType                | memberType |
      | kjadha10 | Virus$$1 | Xldycop     | GroupMAPDWithoutPayment | Group      |
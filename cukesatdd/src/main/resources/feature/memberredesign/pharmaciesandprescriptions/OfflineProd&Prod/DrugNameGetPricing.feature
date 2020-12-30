Feature: Drug Name and Get Pricing
  To validate PDP, MAPD, PCP, Medica user for Drug Name and Get Pricing

  @Sanity @Regression
  Scenario Outline: To verify PDP user has access to Drug Name
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
    Then user views the Current Medications
    When user clicks on the name of a drug
    Then user views the Prices page for that medication

    Examples: 
      | username | password | memUserName | planType | memberType |
      | yaihemai | Yusufu7$ | JAN06ARY    | PDP      | Individual |

  @Sanity @Regression
  Scenario Outline: To verify PDP user has access to Get Pricing
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
    Then user views the Current Medications
    When user clicks the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples: 
      | username | password | memUserName | planType | memberType |
      | yaihemai | Yusufu7$ | JAN06ARY    | PDP      | Individual |

  @Sanity @Regression
  Scenario Outline: To verify MAPD user has access to Drug Name
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
    Then user views the Current Medications
    When user clicks on the name of a drug
    Then user views the Prices page for that medication

    Examples: 
      | username | password | memUserName | planType | memberType |
      | yaihemai | Yusufu7$ | LUGRUG11    | MAPD     | Individual |

  @Sanity @Regression
  Scenario Outline: To verify MAPD user has access to Get Pricing
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
    Then user views the Current Medications
    When user clicks the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples: 
      | username | password | memUserName | planType | memberType |
      | yaihemai | Yusufu7$ | LUGRUG11    | MAPD     | Individual |

  @Sanity @Regression
  Scenario Outline: To verify PCP user has access to Drug Name
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
    Then user views the Current Medications
    When user clicks on the name of a drug
    Then user views the Prices page for that medication

    Examples: 
      | username | password | memUserName         | planType | memberType |
      | yaihemai | Yusufu7$ | sofyabakman@msn.com | PCP      | Individual |

  @Sanity @Regression
  Scenario Outline: To verify PCP user has access to Get Pricing
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
    Then user views the Current Medications
    When user clicks the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples: 
      | username | password | memUserName         | planType | memberType |
      | yaihemai | Yusufu7$ | sofyabakman@msn.com | PCP      | Individual |

  @Sanity @Regression
  Scenario Outline: To verify Medica user has access to Drug Name
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
    Then user views the Current Medications
    When user clicks on the name of a drug
    Then user views the Prices page for that medication

    Examples: 
      | username | password | memUserName | planType | memberType |
      | yaihemai | Yusufu7$ | TCZUNIGA52  | Medica   | Individual |

  @Sanity @Regression
  Scenario Outline: To verify Medica user has access to Get Pricing
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
    Then user views the Current Medications
    When user clicks the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples: 
      | username | password | memUserName | planType | memberType |
      | yaihemai | Yusufu7$ | TCZUNIGA52  | Medica   | Individual |

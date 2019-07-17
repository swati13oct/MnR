#Author: Danthoori shiva
#created Date:2/12/2019
@Test @visitorprofile
Feature: Visitor profile

  @AARPvisitorprofile @addDrugs
  Scenario Outline: Verify user is able to add drug and pharmacy information to the unauthenticated visitor profile
    Given the user is on AARP medicare acquisition site landing page
    And the user selects the state drop down value in AARP home page
      | State | <state> |
    And the user clicks on the shopping cart icon in AARP site
    And the user clicks on the add drugs button in the guest profile in AARP site
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
    And the user returns to the visitor profile page
    Then the user should be able to see the Drug and pharmacy information in the guest profile page
      | Drugname | <Drugname> |

    Examples: 
      | state   | Drugname         | quantity | frequency     | zipcode | radius   | drug             | quantity | frequency     | branded |
      | Alabama | Lipitor TAB 10MG |       30 | Every 1 month |   90210 | 15 miles | Lipitor TAB 10MG |       30 | Every 1 month | yes     |

  @addDrugsDCE
  Scenario Outline: Verify user is able to add drug and pharmacy information to the unauthenticated visitor profile
    Given the user is on AARP medicare acquisition site landing page
    And the user selects the state drop down value in AARP home page
      | State | <state> |
    When I access the acquisition DCE tool from home page
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug and pharmacy information in the guest profile page
      | Drugname | <Drugname> |

    Examples: 
      | state   | Drugname         | quantity | frequency     | zipcode | radius   | drug             | quantity | frequency     | branded |
      | Alabama | Lipitor TAB 10MG |       30 | Every 1 month |   90210 | 15 miles | Lipitor TAB 10MG |       30 | Every 1 month | yes     |

  @addPlans
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile
    Given the user is on AARP medicare acquisition site landing page
    And the user selects the state drop down value in AARP home page
      | State | <state> |
    And the user clicks on the shopping cart icon in AARP site
    And the user clicks on the add plans button in the guest profile in AARP site
    When the user adds plan from plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    Then user saves two plans as favorite on AARP site
      | MA Test Plans | <MA_testPlans> |
    Then user gets a create profile prompt on AARP site
    Then user click on continue as guest button on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | MA Test Plans | <MA_testPlans> |

    Examples: 
      | state   | UID       | zipcode | isMultiCounty | county           | MA_testPlans                                                                                                |
      | Alabama | US1770330 |   90210 | NO            | Jefferson County | AARP MedicareComplete SecureHorizons Essential (HMO)_Test,AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @addPlansVPP
  Scenario Outline: Verify user is save plans from VPP to the unauthenticated visitor profile
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    Then user saves two plans as favorite on AARP site
      | MA Test Plans | <MA_testPlans> |
    Then user gets a create profile prompt on AARP site
    Then user click on continue as guest button on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | MA Test Plans | <MA_testPlans> |

    Examples: 
      | state   | UID       | zipcode | isMultiCounty | county           | MA_testPlans                                                                                                |
      | Alabama | US1770330 |   90210 | NO            | Jefferson County | AARP MedicareComplete SecureHorizons Essential (HMO)_Test,AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
@Test @AARPvisitorprofile @regressionAARP
Feature: 1.08. ACQ- Visitor profile

  @VisitorProfile_AARP_mobile @prod_regression
  Scenario Outline: Verify user is able to add drug information to the unauthenticated visitor profile - zip - <zipCode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page mobile
      | State | <state> |
    And the user clicks on the shopping cart icon mobile
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page mobile
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user selects plan year
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |

    Examples: 
      | state   | drug1   | zipCode | site |
      | Alabama | Lipitor |   90210 | AARP |

  # | Virginia | Lipitor |   15001 | AARP |
  @VisitorProfile_AARP_mobile @prod
  Scenario Outline: Verify user is able to add drug from DCE to the unauthenticated visitor profile - zip -<zipCode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page mobile
      | State | <state> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    When user selects plan year
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |

    Examples: 
      | state    | drug1   | zipCode | site |
      | Alabama  | Lipitor |   90210 | AARP |
      | Virginia | Lipitor |   22320 | AARP |

  @VisitorProfile_AARP_mobile @prod 
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile - zip -<zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page mobile
      | State | <state> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add plans button in the profile
    When the user enters zipcode on health plans page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Test Plans | <testPlans> |
      | Plan Type  | <plantype>  |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And user delets the added plans on visitor profile page
      | Test Plans | <testPlans> |

    Examples: 
      | site | state   | UID       | planyear | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              |
      | AARP | Alabama | US1770330 | current  |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  #  | AARP | Virginia | US1770330 | current  |   22320 | NO            | Alexandria city  | MAPD     | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage Plan 1 (HMO)                           |
  #| Alabama | US1770330 |   53503 | NO            | Jefferson County | SNP      | UnitedHealthcare Dual Complete LP1 (HMO D-SNP),UnitedHealthcare Medicare Advantage Assist (PPO C-SNP)  |
  @VisitorProfile_AARP_mobile @prod
  Scenario Outline: <UID> - Verify user is save plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page mobile
      | State | <state> |
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |

    Examples: 
      | site | state    | UID       | zipcode | isMultiCounty | plantype | planyear | county          | testPlans                                                                     | eyeWearBenefitType | eyeWearExpectedText                                           | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText | membershipinHealthClubFitnessClassesBenefitType | membershipinHealthClubFitnessExpectedText                                                                  |
      # | AARP | Alabama  | US1770330 |   53503 | NO            | MAPD     | current  | Jefferson County | UnitedHealthcare Medicare Advantage Open (PPO),UnitedHealthcare Medicare Advantage Open Essential (PPO) | Eyewear            | Eyewear has a plan benefit limit up to $100 per every 2 years | Eye Exam           | $0 copay               | Foot Care - Routine        | $50 copay                   | Hearing Exam           | $0 copay                | Fitness Program through Renew Active            | Fitness Membership Only: Basic membership in a fitness program at a network location at no additional cost |
      | AARP | Virginia | US1770330 |   22320 | NO            | MAPD     | current  | Alexandria city | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage Patriot (PPO) | Eyewear            | Eyewear has a plan benefit limit up to $200 per every 2 years | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $35 copay                   | Hearing Exam           | $0 copay                | Fitness Program through Renew Active            | Fitness Membership Only: Basic membership in a fitness program at a network location at no additional cost |

  @VisitorProfile_AARP_mobile @prod
  Scenario Outline: Verify user saves Medsupp plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page mobile
      | State | <state> |
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user fills out medsup form and proceeds to next pages mobile
      | Zip Code | <zipcode> |
      | DOB      | <DOB>     |
    Then user saves two ms plans as favorite mobile
      | MS Test Plans | <MS_testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |

    #No pdf link is avialable now
    #And user validate pdf link
    #| MS Test Plans | <MS_testPlans> |
    Examples: 
      | site | state       | zipcode | isMultiCounty | plantype | planyear | DOB        | county           | MS_testPlans  |
      | AARP | Alabama     |   90210 | NO            | MS       | current  | 11/11/1949 | Jefferson County | Plan G,Plan A |
      | AARP | Puerto Rico |   00641 | NO            | MS       | current  | 11/11/1949 | Utuado Municipio | Plan G,Plan A |

  @VisitorProfile_AARP_mobile2 @prod  @VPVPVP
  Scenario Outline: Verify Provider Search functional flow for unauthenticated Visitor Profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page mobile
      | State | <state> |
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And the user back to VPP plan summary page
    When the user views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    Then Navigate to Visitor Profile page
    Then Verify X out of Y provider covered information is displayed on visitor profile page
      | PlanName | <planname> |

    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | plantype | planyear | planname                             | testPlans                                                                 |  |
      | AARP | New York |   10001 | NO              | New York County | MAPD     | current  | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |  |

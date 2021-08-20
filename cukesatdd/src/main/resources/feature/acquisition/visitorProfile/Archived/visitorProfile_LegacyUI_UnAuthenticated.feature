#Author: Naveen BK
#created Date:2/12/2019
@visitorProfileLegacyUIUnAuthenticated @visitorProfile
Feature: 1.09. UAT - Legacy Visitor profile UI Un Authenticated

  @addDrugsUnAuth @addDrugsULayerSmoke @visitorProfileRegressionAARP @dce_Regression_Ulayer_VisitorProfile
  Scenario Outline: Verify user is able to add drug information to the unauthenticated visitor profile - zip - <zipCode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |

    @visitorProfile_AARP @VP_ProdRegression_AARP
    Examples: 
      | state        | drug1   | zipCode | site |
      | Pennsylvania | Lipitor |   15001 | AARP |

    @visitorProfile_UHC @VP_ProdRegression_UHC
    Examples: 
      | state        | drug1   | zipCode | site |
      | Pennsylvania | Lipitor |   15001 | UHC  |

  @addDrugsDCEUnAuth
  Scenario Outline: Verify user is able to add drug from DCE to the unauthenticated visitor profile - zip -<zipCode> - Legacy - <state>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
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

    @visitorProfile_AARP @VP_ProdRegression_AARP
    Examples: 
      | state    | drug1   | zipCode | site |
      | Virginia | Lipitor |   22320 | AARP |

    @visitorProfile_UHC @VP_ProdRegression_UHC
    Examples: 
      | state    | drug1   | zipCode | site |
      | Virginia | Lipitor |   22320 | UHC  |

  @addPlansUnAuth @addPlansULayerSmoke @visitorProfileRegressionAARP
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile - zip -<zipcode>- Legacy - <state>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
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

    @visitorProfile_AARP @VP_ProdRegression_AARP
    Examples: 
      | site | state    | UID       | planyear | zipcode | isMultiCounty | county          | plantype | testPlans                                                                 |
      | AARP | Virginia | US1770330 | future   |   22320 | NO            | Alexandria city | MAPD     | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage (HMO-POS) |

    @visitorProfile_UHC @VP_ProdRegression_UHC
    Examples: 
      | site | state    | UID       | planyear | zipcode | isMultiCounty | county          | plantype | testPlans                                                                 |
      | UHC  | Virginia | US1770330 | future   |   22320 | NO            | Alexandria city | MAPD     | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage (HMO-POS) |

  @addPlansPlanDetailUnAuth @visitorProfileRegressionAARP
  Scenario Outline: <UID> - Verify user is save plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode>- Legacy - <state>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    When the user performs plan search using following information
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
    And user clicks on plan name
      | Test Plans | <testPlans> |
    Then the user validates the following Additional Benefits of Plan for the plan
      | Eye Wear Benefit Type           | <eyeWearBenefitType>          |
      | Eye Wear Expected Text          | <eyeWearExpectedText>         |
      | Eye Exam Benefit Type           | <eyeExamBenefitType>          |
      | Eye Exam Expected Text          | <eyeExamExpectedText>         |
      | Foot Care Routine Benefit Type  | <footCareRoutineBenefitType>  |
      | Foot Care Routine Expected Text | <footCareRoutineExpectedText> |
      | Hearing Exam Benefit Type       | <hearingExamBenefitType>      |
      | Hearing Exam Expected Text      | <hearingExamExpectedText>     |

    @visitorProfile_AARP @VP_ProdRegression_AARP
    Examples: 
      | site | state    | UID       | zipcode | isMultiCounty | plantype | planyear | county          | testPlans                                                                 | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | AARP | Virginia | US1770330 |   22320 | NO            | MAPD     | future   | Alexandria city | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage (HMO-POS) | Eyewear            | $0 copay every 2 years; up to $200 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $35 copay                   | Hearing Exam           | $0 copay                |

    @visitorProfile_UHC
    Examples: 
      | site | state    | UID       | zipcode | isMultiCounty | plantype | planyear | county          | testPlans                                                                 | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | UHC  | Virginia | US1770330 |   22320 | NO            | MAPD     | future   | Alexandria city | AARP Medicare Advantage Walgreens (PPO),AARP Medicare Advantage (HMO-POS) | Eyewear            | $0 copay every 2 years; up to $200 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $35 copay                   | Hearing Exam           | $0 copay                |

  @vpMSSavePlanUnAuth
  Scenario Outline: Verify user saves Medsupp plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode>- Legacy - <state>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user fills out medsup form and proceeds to next pages
      | Zip Code | <zipcode> |
      | DOB      | <DOB>     |
    Then user saves two ms plans as favorite
      | MS Test Plans | <MS_testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |

    @visitorProfile_AARP @VP_ProdRegression_AARP
    Examples: 
      | site | state       | zipcode | isMultiCounty | plantype | planyear | DOB        | county           | MS_testPlans  |
      | AARP | Puerto Rico |   00641 | NO            | MS       | future   | 11/11/1949 | Utuado Municipio | Plan G,Plan A |

    @visitorProfile_UHC @VP_ProdRegression_UHC
    Examples: 
      | site | state       | zipcode | isMultiCounty | plantype | planyear | DOB        | county           | MS_testPlans  |
      | UHC  | Puerto Rico |   00641 | NO            | MS       | future   | 11/11/1949 | Utuado Municipio | Plan G,Plan A |

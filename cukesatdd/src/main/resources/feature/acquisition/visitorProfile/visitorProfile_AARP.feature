#Author: Danthoori shiva
#created Date:2/12/2019
@Test @AARPvisitorprofile
Feature: 1.08. ACQ- Visitor profile AARP

  @addDrugs @addDrugsULayerSmoke @visitorProfileRegressionAARP @prodRegression @DCE_Regression_Ulayer_VisitorProfile
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
      | Dosage    | <dosage>    |
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
      | Drugname | <drug> |

    Examples: 
      | state   | drug    | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded |
      | Alabama | Lipitor | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     |

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
      | Dosage    | <dosage>    |
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
      | state   | drug    | dosage   | quantity | frequency     | zipcode | radius   | drug             | quantity | frequency     | branded |
      | Alabama | Lipitor | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles | Lipitor TAB 10MG |       30 | Every 1 month | yes     |

  @addPlans @addPlansULayerSmoke @visitorProfileRegressionAARP @prodRegression
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile
    Given the user is on AARP medicare acquisition site landing page
    And the user selects the state drop down value in AARP home page
      | State | <state> |
    And the user clicks on the shopping cart icon in AARP site
    And the user clicks on the add plans button in the guest profile in AARP site
    When the user enters zipcode on health plans page in the AARP site
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
      | state   | UID       | zipcode | isMultiCounty | county           | MA_testPlans                                                                                           |
      | Alabama | US1770330 |   90210 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

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

  @addPlansPlanDetail @visitorProfileRegressionAARP @prodRegression
  Scenario Outline: Verify user is save plans from VPP to the unauthenticated visitor profile
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then user saves two plans as favorite on AARP site
      | MA Test Plans | <MA_testPlans> |
    Then user gets a create profile prompt on AARP site
    Then user click on continue as guest button on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | MA Test Plans | <MA_testPlans> |
    And user clicks on plan name in AARP
      | MA Test Plans | <MA_testPlans> |
    Then the user validates the following Additional Benefits of Plan for the plan in AARP
      | Eye Wear Benefit Type                                     | <eyeWearBenefitType>                              |
      | Eye Wear Expected Text                                    | <eyeWearExpectedText>                             |
      | Eye Exam Benefit Type                                     | <eyeExamBenefitType>                              |
      | Eye Exam Expected Text                                    | <eyeExamExpectedText>                             |
      | Foot Care Routine Benefit Type                            | <footCareRoutineBenefitType>                      |
      | Foot Care Routine Expected Text                           | <footCareRoutineExpectedText>                     |
      | Hearing Exam Benefit Type                                 | <hearingExamBenefitType>                          |
      | Hearing Exam Expected Text                                | <hearingExamExpectedText>                         |
      | Membership in Health Club / Fitness Classes Benefit Type  | <membershipinHealthClubFitnessClassesBenefitType> |
      | Membership in Health Club / Fitness Classes Expected Text | <membershipinHealthClubFitnessExpectedText>       |

    Examples: 
      | state   | UID       | zipcode | isMultiCounty | plantype | county           | MA_testPlans                                                                                            | eyeWearBenefitType | eyeWearExpectedText                                           | eyeExamBenefitType | eyeExamExpectedText | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText | membershipinHealthClubFitnessClassesBenefitType | membershipinHealthClubFitnessExpectedText                                                                  |
      | Alabama | US1770330 |   53503 | NO            | MAPD     | Jefferson County | UnitedHealthcare Medicare Advantage Open (PPO),UnitedHealthcare Medicare Advantage Open Essential (PPO) | Eyewear            | Eyewear has a plan benefit limit up to $100 per every 2 years | Eye Exam           | $0 copay            | Foot Care - Routine        | $50 copay                   | Hearing Exam           | $0 copay                | Fitness Program through Renew Active            | Fitness Membership Only: Basic membership in a fitness program at a network location at no additional cost |

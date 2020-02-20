#Author: Naveen BK
#created Date:07/10/2019
@Test @UHCvisitorprofile
Feature: 2.08. ACQ-Visitor profile - UMS

  @UHCvisitorprofile @addDrugs @addDrugsBLayerSmoke @visitorProfileRegressionUHC @prodRegression @DCE_Regression_Blayer_VisitorProfile
  Scenario Outline: Verify user is able to add drug and pharmacy information to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    And the user selects the state drop down value in UHC home page
      | State | <state> |
    And the user clicks on the shopping cart icon in UHC site
    #And the user validates the plan year buttons are present or not and chooses the plan year in UHC
#      | Plan Year | <planyear> |
    And the user clicks on the add drugs button in the guest profile in UHC site
    And I have added a drug to my drug list on ums site
      | Drug | <drug> |
    And user selects drug details in ums site
      | Drug      | <drug>      |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
      | Dosage    | <dosage>    |
    When user successfully adds drug in ums site
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page on ums site
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    And the user returns to the visitor profile page in UHC
    Then the user should be able to see the Drug and pharmacy information in the guest profile page on UHC
      | Drugname | <drug> |

    Examples: 
      | state   | drug    | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded | planyear |
      | Alabama | Lipitor | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     |     2019 |

  @addDrugsDCE 
  Scenario Outline: Verify user is able to add drug and pharmacy information to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    And the user selects the state drop down value in UHC home page
      | State | <state> |
    When I access the acquisition DCE tool from home page on ums site
    And I have added a drug to my drug list on ums site
      | Drug | <drug> |
    And user selects drug details in ums site
      | Drug      | <drug>      |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
      | Dosage    | <dosage>    |
    When user successfully adds drug in ums site
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page on ums site
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug and pharmacy information in the guest profile page on UHC
      | Drugname | <Drugname> |

    Examples: 
      | state   | drug    | dosage   | quantity | frequency     | zipcode | radius   | drug             | quantity | frequency     | branded |
      | Alabama | Lipitor | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles | Lipitor TAB 10MG |       30 | Every 1 month | yes     |

  @addPlans @addPlansBLayerSmoke @visitorProfileRegressionUHC @prodRegression
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    And the user selects the state drop down value in UHC home page
      | State | <state> |
    And the user clicks on the shopping cart icon in UHC site
    And the user validates the plan year buttons are present or not and chooses the plan year in UHC
      | Plan Year | <planYear> |
    And the user clicks on the add plans button in the guest profile in UHC site
    When the user enters zipcode on health plans page in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user saves two plans as favorite on UHC site
      | MA Test Plans | <MA_testPlans> |
      | Plan Type     | <plantype>     |
    Then user gets a create profile prompt on UHC site
    Then user click on continue as guest button on UHC site
    And user validates the added plans on visitor profile page of UHC site
      | MA Test Plans | <MA_testPlans> |

    Examples: 
      | state   | UID       | zipcode | isMultiCounty | county           | MA_testPlans                                                                                           | plantype | planYear |
      | Alabama | US1770330 |   90210 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | MA       |     2020 |

  @addPlansVPP
  Scenario Outline: Verify user is save plans from VPP to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user saves two plans as favorite on UHC site
      | MA Test Plans | <MA_testPlans> |
    Then user gets a create profile prompt on UHC site
    Then user click on continue as guest button on UHC site
    And user validates the added plans on visitor profile page of UHC site
      | MA Test Plans | <MA_testPlans> |

    Examples: 
      | state   | UID       | zipcode | isMultiCounty | county           | MA_testPlans                                                                                              |
      | Alabama | US1770330 |   90210 | NO            | Jefferson County | UHC MedicareComplete SecureHorizons Essential (HMO)_Test,UHC MedicareComplete SecureHorizons Plan 1 (HMO) |

  @addPlansPlanDetail @visitorProfileRegressionUHC @prodRegression
  Scenario Outline: Verify user is save plans from VPP to the unauthenticated visitor profile
    Given the user is on the uhcmedicaresolutions site landing page
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then user saves two plans as favorite on UHC site
      | Plan Type     | <plantype>     |
      | MA Test Plans | <MA_testPlans> |
    Then user gets a create profile prompt on UHC site
    Then user click on continue as guest button on UHC site
    And user validates the added plans on visitor profile page of UHC site
      | MA Test Plans | <MA_testPlans> |
    And user clicks on plan name of UHC site
      | MA Test Plans | <MA_testPlans> |
    Then the user validates the following Additional Benefits of Plan for the plan in UMS
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

@agentRecommendationEngine @ARERegression @regressionAARP @nonProd
Feature: 1.17.1 Agent Recommendation Engine - Verify ARE elements

  @ARE @AREElements @dropdownUI @F439411 @sanity
  Scenario Outline: - <Email> To Verify agent login and validate ARE dropdown UI
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates plan ranking drop down UI plancompare page

    Examples: 
      | User                   | Pass           | Email                 | IfMultiCounty | PlanYear |
      | areddstage@givmail.com | Password@12345 | ATDD1STG@MEMBERDD.COM | None          | current  |

  @ARE @EnrolledNonMAPD @nodropdownUI @F496111
  Scenario Outline: - <Email> To Verify agent login and validate ARE No dropdown UI
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates plan ranking drop down not displaying in plancompare page

    Examples: 
      | User                   | Pass           | Email                  | IfMultiCounty | PlanYear |
      | areddstage@givmail.com | Password@12345 | ATDD4STG@MEMBERDD.COM  | None          | current  |
      | areddstage@givmail.com | Password@12345 | EMILYN@MACIEJEWSKI.COM | None          | current  |

  @ARE @ViewPlanDetailsARE @F439411 @sanity
  Scenario Outline: - <Email> To Verify agent login and validate View Plan Details in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates view plan details in plancompare page

    Examples: 
      | User                   | Pass           | Email                 | IfMultiCounty | PlanYear |
      | areddstage@givmail.com | Password@12345 | ATDD1STG@MEMBERDD.COM | None          | current  |

  @ARE @SavePlansARE @F439411
  Scenario Outline: - <Email> To Verify agent login and validate Save Plans in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates save plans in plancompare page
      | Plan Year | <PlanYear> |

    Examples: 
      | User                   | Pass           | Email                 | IfMultiCounty | PlanYear |
      | areddstage@givmail.com | Password@12345 | ATDD1STG@MEMBERDD.COM | None          | current  |

  @ARE @EnrollPlansARE @F439411
  Scenario Outline: - <Email> To Verify agent login and validate Enroll Plans in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates enroll plans in plancompare page

    Examples: 
      | User                   | Pass           | Email                 | IfMultiCounty | PlanYear |
      | areddstage@givmail.com | Password@12345 | ATDD1STG@MEMBERDD.COM | None          | current  |

  @ARE @PlansReorder @F487396
  Scenario Outline: - <Email> To Verify agent login and validate Plans reorder in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates ranking plans order in plancompare page
      | ZIP                  | <PlanCompareZIP>     |
      | Ranking Options      | <RankingOptions>     |
      | Current Plan         | <DisplayCurrentPlan> |
      | ChangeIn Order       | <ChangeInOrder>      |
      | Expected Plans Order | <PlansOrder>         |

    Examples: 
      | User                   | Pass           | Email                 | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions                        | DisplayCurrentPlan | ChangeInOrder | PlansOrder |
      #| areddstage@givmail.com  | Password@12345 | ATDD5STG@MEMBERDD.COM | None          | current  |          10001 | fitness,lowpremium | YES                | YES           | Mosaic(HMO),Choice(PPO),Essential(HMO),Essential(RegionalPPO),Plan2(HMO),Plan1(RegionalPPO),Plan3(RegionalPPO),Plan1(HMO),Plan4(RegionalPPO) |
      | areddstage@givmail.com | Password@12345 | ATDD5STG@MEMBERDD.COM | None          | current  |          10001 | fitness,lowpremium                    | NO                 | YES           | [blank]    |
      | areddstage@givmail.com | Password@12345 | APISTG@MEMBERDD.COM   | None          | current  |          10001 | hearing,vision,lowpremium,drug,doctor | NO                 | YES           | [blank]    |

  @ARE @deleteaddplans @F487396
  Scenario Outline: - <Email> To Verify agent login and validate deleted plans reordering in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent deletes and adds plan in plancompare page
      | ZIP                  | <PlanCompareZIP>     |
      | Ranking Options      | <RankingOptions>     |
      | Current Plan         | <DisplayCurrentPlan> |
      | ChangeIn Order       | <ChangeInOrder>      |
      | Expected Plans Order | <PlansOrder>         |

    Examples: 
      | User                   | Pass           | Email                 | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions     | DisplayCurrentPlan | ChangeInOrder | PlansOrder |
      | areddstage@givmail.com | Password@12345 | ATDD5STG@MEMBERDD.COM | None          | current  |          10001 | fitness,lowpremium | NO                 | YES           | [blank]    |

  @ARE @PlansReorder @MCE @F487422
  Scenario Outline: - <Email> To Verify agent login and validate Plans reorder in ARE for MCE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates Estimated Annual Medical Cost in plancompare page
      | Estimate MedicalCost | <EstimateMC> |
    Then agent validates ranking plans order in plancompare page
      | ZIP                  | <PlanCompareZIP>     |
      | Ranking Options      | <RankingOptions>     |
      | Current Plan         | <DisplayCurrentPlan> |
      | ChangeIn Order       | <ChangeInOrder>      |
      | Expected Plans Order | <PlansOrder>         |

    Examples: 
      | User                   | Pass           | Email                 | IfMultiCounty | PlanYear | EstimateMC | PlanCompareZIP | RankingOptions | DisplayCurrentPlan | ChangeInOrder | PlansOrder |
      | areddstage@givmail.com | Password@12345 | ATDD2STG@MEMBERDD.COM | None          | current  | YES        |          10001 | mce,lowpremium | NO                 | YES           | [blank]    |

  @ARE @PlansReorder @NOMCE @F487422
  Scenario Outline: - <Email> To Verify agent login and validate Plans reorder in ARE for NoMCE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates Estimated Annual Medical Cost in plancompare page
      | Estimate MedicalCost | <EstimateMC> |
    Then agent validates ranking option is not present in plan ranking drop down
      | Ranking Options | <RankingOptions> |

    Examples: 
      | User                   | Pass           | Email                    | IfMultiCounty | PlanYear | EstimateMC | RankingOptions |
      | areddstage@givmail.com | Password@12345 | ATDD3STG@MEMBERDD.COM    | None          | current  | NO         | mce            |
      | areddstage@givmail.com | Password@12345 | ATDD2STG@NONMEMBERDD.COM | None          | current  | NO         | mce            |

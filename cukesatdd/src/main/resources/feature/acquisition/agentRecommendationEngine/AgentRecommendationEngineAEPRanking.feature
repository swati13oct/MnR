@agentRecommendationEngine @AREAEPRegression
Feature: 1.17.1 Agent Recommendation Engine - Verify ARE elements

  @ARE @PlanYearAutoRanking @F472941
  Scenario Outline: - <Email> To Verify agent login and validate plan year Auto Ranking in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent use flagsmith to validate AEP plancompare page
      | User Name | <username> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    And agent verifies year
      | Plan Year | <PlanYear> |
    Then agent validates auto ranking for plan year change in plancompare page
      | Plan Year            | <PlanYear>           |
      | ZIP                  | <PlanCompareZIP>     |
      | Ranking Options      | <RankingOptions>     |
      | Current Plan         | <DisplayCurrentPlan> |
      | ChangeIn Order       | <ChangeInOrder>      |
      | Expected Plans Order | <PlansOrder>         |

    Examples: 
      | User               | Pass          | Email                    | username | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions                        | DisplayCurrentPlan | ChangeInOrder | PlansOrder                                                                                                                              |
      | mnracq@givmail.com | Password@1234 | ATDD5STG@MEMBERDD.COM    | OCT-15   | None          | future   |          10001 | fitness,lowpremium                    | NO                 | YES           | [blank]                                                                                                                                 |
      | mnracq@givmail.com | Password@1234 | ATDD3STG@NONMEMBERDD.COM | DEC-31   | None          | future   |          10001 | hearing,vision,lowpremium,drug,doctor | NO                 | YES           | Choice(PPO),Plan1(RegionalPPO),Prime(HMO),Plan3(RegionalPPO),Plan4(RegionalPPO),Patriot(RegionalPPO),Plan2(HMO),Plan1(HMO),Patriot(HMO) |

  @ARE @EstimateMedicalCostFuture @F441593 @F487422
  Scenario Outline: - <Email> To Verify agent login and validate Plans reorder in AEP ARE for MCE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent use flagsmith to validate AEP plancompare page
      | User Name | <username> |
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
      | User               | Pass          | Email                 | username | IfMultiCounty | PlanYear | EstimateMC | PlanCompareZIP | RankingOptions | DisplayCurrentPlan | ChangeInOrder | PlansOrder |
      | mnracq@givmail.com | Password@1234 | ATDD2STG@MEMBERDD.COM | DEC-01   | None          | future   | YES        |          10001 | mce,lowpremium | NO                 | YES           | [blank]    |

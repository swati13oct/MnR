@AgentRecommendationEngine @ARERegression
Feature: Agent Recommendation Engine - Verify ARE elements

  @ARE @AREElements @dropdownUI @F439411
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

    #Then agent validates plan ranking drop down UI plancompare page
    Examples: 
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear |
      | qavgogine | qavgogine | ATDD1STG@MEMBERDD.COM | None          | current  |

  #| qavgogine | qavgogine | LEONEL@MEMBER.COM  |
  #| qavgogine | qavgogine | xamegy@getnada.com |
  @ARE @EnrolledNonMAPD @nodropdownUI @F496111
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
    Then agent validates plan ranking drop down not displaying in plancompare page

    Examples: 
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear |
      | qavgogine | qavgogine | ATDD4STG@MEMBERDD.COM | None          | current  |
      #| qavgogine | qavgogine | SPOP@NONMEMBER.COM    | None          | current  |

  @ARE @ViewPlanDetailsARE @F439411
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
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear |
      | qavgogine | qavgogine | ATDD1STG@MEMBERDD.COM | None          | current  |

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
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear |
      | qavgogine | qavgogine | ATDD1STG@MEMBERDD.COM | None          | current  |

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
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear |
      | qavgogine | qavgogine | ATDD1STG@MEMBERDD.COM | None          | current  |

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
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions     | DisplayCurrentPlan | ChangeInOrder | PlansOrder                                                                                                                                   |
      | qavgogine | qavgogine | ATDD5STG@MEMBERDD.COM | None          | current  |          10001 | fitness,lowpremium | YES                | YES           | Mosaic(HMO),Choice(PPO),Essential(HMO),Essential(RegionalPPO),Plan2(HMO),Plan1(RegionalPPO),Plan3(RegionalPPO),Plan1(HMO),Plan4(RegionalPPO) |

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
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions     | DisplayCurrentPlan | ChangeInOrder | PlansOrder |
      | qavgogine | qavgogine | ATDD5STG@MEMBERDD.COM | None          | current  |          10001 | fitness,lowpremium | YES                | YES           |            |

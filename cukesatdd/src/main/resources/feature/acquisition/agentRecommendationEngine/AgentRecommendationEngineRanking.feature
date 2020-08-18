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
  @ARE @DrugARE @F439411
  Scenario Outline: - <Email> To Verify agent login and validate adding drugs in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    When user adds Drugs in plan compare page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user verify Drugs added in plan compare page vs DCE
      | Drugs Names | <DrugNameDosage> |

    Examples: 
      | User      | Pass      | Email                 | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                               | DrugNameDosage                                |IfMultiCounty | PlanYear |
      | qavgogine | qavgogine | MANUAL1STG@MEMBERDD.COM | Lipitor,YES,Lipitor TAB 10MG,,,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Lipitor TAB 10MG:morphine sulfate CAP 10MG ER | None          | current  |

  @ARE @ProviderARE @F439411
  Scenario Outline: - <Email> To Verify agent login and validate adding doctors in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    When user adds providers in plan compare page
      | Doctors | <Doctors> |
    Then user verify added Providers in plan compare page vs Werally
      | Doctors Names  | <DoctorsNames>    |
      | Delete Doctors | <DelDoctorsNames> |

    Examples: 
      | User      | Pass      | Email                 | Doctors                                  | DelDoctorsNames                          | IfMultiCounty | PlanYear |
      | qavgogine | qavgogine | ATDD1STG@MEMBERDD.COM | Okeke, Ernest I, MD:Clower, Daniel C, MD | Okeke, Ernest I, MD:Clower, Daniel C, MD | None          | current  |

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
      | User      | Pass      | Email                 |IfMultiCounty | PlanYear |
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

    Examples: 
      | User      | Pass      | Email                 |IfMultiCounty | PlanYear |
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
      | User      | Pass      | Email                 |IfMultiCounty | PlanYear |
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
      | User      | Pass      | Email            | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions     | DisplayCurrentPlan | ChangeInOrder | PlansOrder                                                                                                                                   |
      | qavgogine | qavgogine | API@MEMBERDD.COM | None          | current  |          10001 | fitness,lowpremium | YES                | YES           | Mosaic(HMO),Choice(PPO),Essential(HMO),Essential(RegionalPPO),Plan2(HMO),Plan1(RegionalPPO),Plan3(RegionalPPO),Plan1(HMO),Plan4(RegionalPPO) |

  @ARE @PlanYearAutoRanking @F487396
  Scenario Outline: - <Email> To Verify agent login and validate plan year Auto Ranking in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates auto ranking for plan year change in plancompare page
      | Plan Year            | <PlanYear>           |
      | ZIP                  | <PlanCompareZIP>     |
      | Ranking Options      | <RankingOptions>     |
      | Current Plan         | <DisplayCurrentPlan> |
      | ChangeIn Order       | <ChangeInOrder>      |
      | Expected Plans Order | <PlansOrder>         |

    Examples: 
      | User      | Pass      | Email            | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions     | DisplayCurrentPlan | ChangeInOrder | PlansOrder |
      | qavgogine | qavgogine | API@MEMBERDD.COM | None          | current  |          10001 | fitness,lowpremium | YES                | YES           |            |

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
      | User      | Pass      | Email            | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions     | DisplayCurrentPlan | ChangeInOrder | PlansOrder |
      | qavgogine | qavgogine | API@MEMBERDD.COM | None          | current  |          10001 | fitness,lowpremium | YES                | YES           |            |

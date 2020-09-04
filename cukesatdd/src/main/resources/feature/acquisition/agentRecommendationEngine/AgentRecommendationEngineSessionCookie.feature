@AgentRecommendationEngine @ARERegression @ARESessionCookie
Feature: Agent Recommendation Engine - Verify ARE functionality with Session Cookies

  @ARE @ClearedSessionNewCloakIn @F457409
  Scenario Outline: - <Email> To Verify agent login and validating clearing session storage in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates information cleared in session storge
      | ZIP | <PlanCompareZIP> |

    Examples: 
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear | PlanCompareZIP |
      | qavgogine | qavgogine | ATDD1STG@MEMBERDD.COM | None          | current  |          10001 |

  @ARE @SavedSessionDropdown @F457409
  Scenario Outline: - <Email> To Verify agent login and validating session storage in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates selected information saved in session storge
      | ZIP              | <PlanCompareZIP>  |
      | Ranking Options  | <RankingOptions>  |
      | Ranking Options1 | <RankingOptions1> |

    Examples: 
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions | RankingOptions1        |
      | qavgogine | qavgogine | ATDD1STG@MEMBERDD.COM | None          | current  |          10001 | lowpremium     | vision,hearing,fitness |

  @ARE @EstimateMedicalCost @F441593
  Scenario Outline: - <Email> To Verify agent login and validating Estimate Medical Cost in ARE
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

    Examples: 
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear | EstimateMC |
      | qavgogine | qavgogine | ATDD1STG@MEMBERDD.COM | None          | current  | YES        |
      | qavgogine | qavgogine | ATDD4STG@MEMBERDD.COM | None          | current  | NO         |

  @ARE @NoDrugDocInDropdown @F457409
  Scenario Outline: - <Email> To Verify agent login and validate No Drugs and Doctors in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    Then agent validates Drug and Doctors in session storge
      | Ranking Options      | <RankingOptions>     |
      | Expected Plans Order | <PlansOrder>         |
      | Current Plan         | <DisplayCurrentPlan> |

    Examples: 
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear | RankingOptions | PlansOrder                                                                                                                                   | DisplayCurrentPlan |
      | qavgogine | qavgogine | ATDD2STG@MEMBERDD.COM | None          | current  | drug,doctor    | Plan1(HMO),Plan2(HMO),MOSAIC(HMO),Essential(HMO),Choice(PPO),Plan1(RegionalPPO),Plan3(RegionalPPO),Plan4(RegionalPPO),Essential(RegionalPPO) | YES                |

  @ARE @AddEditDeleteDrug @F457409
  Scenario Outline: - <Email> To Verify agent login and validate Add,Edit and Delete Drugs in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    When Agent fetch original PlanOrder in plancompare page
      | Ranking Options | <RankingOptions> |
    When user adds Drugs in plan compare page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then Apply ranking and get plans names in plancompare page
      | Ranking Options | <RankingOptions> |
    When user adds Drugs in plan compare page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch2> |
    Then agent get plandetails after editing Drugs in plancompare
      | Current Plan         | <DisplayCurrentPlan> |
      | ChangeIn Order       | <ChangeInOrder>      |
      | Expected Plans Order | <PlansOrder>         |
    Then user verify Drugs added in plan compare page vs DCE
      | Drugs Names | <DrugNameDosage> |
    And agent verify Drug option disabled and Original Plans Order in plancompare page
      | Current Plan         | <DisplayCurrentPlan> |
      | ChangeIn Order1      | <ChangeInOrder1>     |
      | Ranking Options      | <RankingOptions>     |
      | Expected Plans Order | <PlansOrder>         |

    Examples: 
      | User      | Pass      | Email                | IfMultiCounty | PlanYear | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch2 | DrugNameDosage                              | Current Plan | ChangeInOrder | PlansOrder | RankingOptions | ChangeInOrder1 | DisplayCurrentPlan |
      | qavgogine | qavgogine | ATDDSTG@MEMBERDD.COM | None          | current  | AZITHROMYCIN,NO,azithromycin POW 1GM PAK,,,1,NO,NO                   | CELECOXIB,NO,celecoxib CAP 50MG,,,3,NO,NO                             | azithromycin POW 1GM PAK:CELECOXIB CAP 50MG | YES          | YES           |            | drug           | NO             | YES                |

  @ARE @AddEditDeleteDoctors @F457409
  Scenario Outline: - <Email> To Verify agent login and validate Add,Edit and Delete Doctors in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    And agent selects county and plan year in plancompare page
      | Multi County | <IfMultiCounty> |
      | Plan Year    | <PlanYear>      |
    When Agent fetch original PlanOrder in plancompare page
      | Ranking Options | <RankingOptions> |
    When user adds providers in plan compare page
      | Doctors | <Doctors> |
    Then Apply ranking and get plans names in plancompare page
      | Ranking Options | <RankingOptions> |
    When user adds providers in plan compare page
      | Doctors | <Doctors1> |
    Then agent get plandetails after editing Drugs in plancompare
      | Current Plan         | <DisplayCurrentPlan> |
      | ChangeIn Order       | <ChangeInOrder>      |
      | Expected Plans Order | <PlansOrder>         |
    Then user verify added Providers in plan compare page vs Werally
      | Doctors Names  | <DoctorsNames>    |
      | Delete Doctors | <DelDoctorsNames> |
    And agent verify Drug option disabled and Original Plans Order in plancompare page
      | Current Plan         | <DisplayCurrentPlan> |
      | ChangeIn Order1      | <ChangeInOrder1>     |
      | Ranking Options      | <RankingOptions>     |
      | Expected Plans Order | <PlansOrder>         |

    Examples: 
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear | Doctors         | Doctors1         | Current Plan | ChangeInOrder | PlansOrder | RankingOptions | ChangeInOrder1 | DelDoctorsNames                  | DisplayCurrentPlan |
      | qavgogine | qavgogine | ATDD3STG@MEMBERDD.COM | None          | current  | Emily Adams, NP | Palmer, John, MD | YES          | YES           |            | doctor         | NO             | Emily Adams, NP:Palmer, John, MD | YES                |

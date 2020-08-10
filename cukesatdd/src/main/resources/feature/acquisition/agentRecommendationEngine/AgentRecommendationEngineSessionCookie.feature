@AgentRecommendationEngine @ARERegression @ARESessionCookie
Feature: Agent Recommendation Engine - Verify ARE functionality with Session Cookies

  @ARE @ClearedSessionNewCloakIn
  Scenario Outline: - <Email> To Verify agent login and validating cleating session storage in ARE
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
      | User      | Pass      | Email            | IfMultiCounty | PlanYear | PlanCompareZIP |
      | qavgogine | qavgogine | API@MEMBERDD.COM | None          | current  |          10001 |

  @ARE @SavedSessionDropdown
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
      | User      | Pass      | Email            | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions | RankingOptions1        |
      | qavgogine | qavgogine | API@MEMBERDD.COM | None          | current  |          10001 | lowpremium     | vision,hearing,fitness |

  @ARE @NoDrugDocInDropdown
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
      | Ranking Options      | <RankingOptions> |
      | Expected Plans Order | <PlansOrder>     |

    Examples: 
      | User      | Pass      | Email             | IfMultiCounty | PlanYear | RankingOptions | PlansOrder                                                                                                                                   |
      | qavgogine | qavgogine | ATDD@MEMBERDD.COM | None          | current  | drug,doctor    | Plan1(HMO),Plan2(HMO),MOSAIC(HMO),Essential(HMO),Choice(PPO),Plan1(RegionalPPO),Plan3(RegionalPPO),Plan4(RegionalPPO),Essential(RegionalPPO) |

  @ARE @AddEditDeleteDrug
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
    When user adds Drugs in plan compare page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    When user adds Drugs in plan compare page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch2> |
    Then agent get plandetails in plancompare after applied ranking
    	| ChangeIn Order       | <ChangeInOrder>      |
      | Expected Plans Order | <PlansOrder>         |
    Then user verify Drugs added in plan compare page vs DCE
      | Drugs Names | <DrugNameDosage> |

    Examples: 
      | User      | Pass      | Email              | IfMultiCounty | PlanYear | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | DrugNameDosage                              | ChangeInOrder | PlansOrder |
      | qavgogine | qavgogine | ATDD2@MEMBERDD.COM | None          | current  | AZITHROMYCIN,NO,azithromycin POW 1GM PAK,,,1,NO,NO                   | CELECOXIB,NO,CELECOXIB CAP 50MG,,,1,NO,NO                            | azithromycin POW 1GM PAK:CELECOXIB CAP 50MG | YES           |            |

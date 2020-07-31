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
    Then agent validates plan ranking drop down UI plancompare page

    Examples: 
      | User      | Pass      | Email            |
      | qavgogine | qavgogine | MARDI@MEMBER.COM |

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
    Then agent validates plan ranking drop down UI plancompare page
    When user adds Drugs in plan compare page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user verify Drugs added in plan compare page vs DCE
      | Drugs Names | <DrugNameDosage> |

    Examples: 
      | User      | Pass      | Email            | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                               | DrugNameDosage                                |
      | qavgogine | qavgogine | MARDI@MEMBER.COM | Lipitor,YES,Lipitor TAB 10MG,,,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Lipitor TAB 10MG:morphine sulfate CAP 10MG ER |

  @ARE @ProviderARE @F439411
  Scenario Outline: - <Email> To Verify agent login and validate adding drugs in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    Then agent validates plan ranking drop down UI plancompare page
    When user adds providers in plan compare page
      | Doctors | <Doctors> |
    Then user verify added Providers in plan compare page vs Werally
      | Doctors Names  | <DoctorsNames>    |
      | Delete Doctors | <DelDoctorsNames> |

    Examples: 
      | User      | Pass      | Email            | Doctors                                  | DelDoctorsNames                          |
      | qavgogine | qavgogine | MARDI@MEMBER.COM | Okeke, Ernest I, MD:Clower, Daniel C, MD | Okeke, Ernest I, MD:Clower, Daniel C, MD |

      
  @ARE @ViewPlanDetailsARE @F439411
  Scenario Outline: - <Email> To Verify agent login and validate adding drugs in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    #Then agent validates plan ranking drop down UI plancompare page
    Then agent validates view plan details in plancompare page

    Examples: 
      | User      | Pass      | Email            |
      | qavgogine | qavgogine | MARDI@MEMBER.COM |
      
  @ARE @SavePlansARE @F439411
  Scenario Outline: - <Email> To Verify agent login and validate adding drugs in ARE
    Given the agent is on shopper profile login page
    When agent login to shopper profile
      | User Name | <User> |
      | Password  | <Pass> |
    And agent is looking for an profile and cloaksIn
      | Email | <Email> |
    Then agent validates plan ranking drop down UI plancompare page
    Then agent validates save plans in plancompare page

    Examples: 
      | User      | Pass      | Email            |
      | qavgogine | qavgogine | MARDI@MEMBER.COM |
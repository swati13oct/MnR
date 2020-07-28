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
      | User      | Pass      | Email              |
      | qavgogine | qavgogine | MARDI@MEMBER.COM   |
      #| qavgogine | qavgogine | LEONEL@MEMBER.COM  |
      #| qavgogine | qavgogine | xamegy@getnada.com |

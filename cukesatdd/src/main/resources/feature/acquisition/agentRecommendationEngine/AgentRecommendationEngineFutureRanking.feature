@AgentRecommendationEngine @ARERegression
Feature: Agent Recommendation Engine - Verify ARE elements

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
      | User      | Pass      | Email                 | IfMultiCounty | PlanYear | PlanCompareZIP | RankingOptions     | DisplayCurrentPlan | ChangeInOrder | PlansOrder |
      | qavgogine | qavgogine | ATDD5STG@MEMBERDD.COM | None          | future   |          10001 | fitness,lowpremium | YES                | YES           |            |

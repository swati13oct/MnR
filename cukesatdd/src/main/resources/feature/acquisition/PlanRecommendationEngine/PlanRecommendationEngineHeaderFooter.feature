@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify header and footer page in plan Recommendation Engine

  @PRE @headervalidation @HFlinkvalidation @F383639
  Scenario Outline: - To validate Header elements and Links Verification in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
    	| Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    Then user validate Header elements and Link Validation of Plan Recommendation Engine
    
    @FunctionalAARP
     Examples: 
      | site |
      | AARP |  
      
      @FunctionalUHC
      Examples: 
      | site |
      | UHC  | 

  @PRE @footervalidation @HFlinkvalidation @F383639
  Scenario Outline: - To validate Footer elements and Links Verification in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
    	| Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    Then user validate Footer elements and Link Validation of Plan Recommendation Engine
    
    @FunctionalAARP
     Examples: 
      | site |
      | AARP |
      
      @FunctionalUHC
      Examples: 
      | site |
      | UHC  |

  @PRE @headerfooterfunctionality @F383639
  Scenario Outline: - To validate Header and Footer Functionalities in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
    	| Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    Then user validate Header and Footer Functionality of Plan Recommendation Engine
      | Zip Code   | <Zipcode>   |
      | EMail      | <EMail>     |
      | Search Key | <SearchKey> |

		@FunctionalAARP
    Examples: 
      | site | Zipcode | EMail          | SearchKey                  |
      | AARP |   90201 | abc@domain.com | Plan Recommendation Engine |
      
      @FunctionalUHC
      Examples: 
      | site | Zipcode | EMail          | SearchKey                  |
      | UHC  |   90201 | abc@domain.com | Plan Recommendation Engine |

@PlanRecommendationEngine @PRERegression
Feature: Plan Recommendation Engine flow - Verify landing page in plan Recommendation Engine
    
  @PRE @planrecommendation @PRENavigationViaGetHelpChoosing @landingpage @F372697 @F388910 
  Scenario: - To validate user able to navigate to Plan Recommendation Engine via Shop For a Plan-shop-->Get Help Choosing in Tools and Validate Landing Page Elements
  Given the user is on UHC medicare acquisition site PRE landing page
  	| Site | <site> |
  When user navigate Plan Recommendation Engine Using Shop From Home in Find Your Plan
  Then user validate elements on landing page of Plan Recommendation Engine
  
  @FunctionalAARP
     Examples: 
      | site |
      | AARP |  
      
      @FunctionalUHC
      Examples: 
      | site |
      | UHC  |
  
  @PRE @planrecommendation @PRENavigationViaMedicareArticles @landingpage 
  Scenario: - To validate user able to navigate to Plan Recommendation Engine via Shop For a Plan-shop-->Get Help Choosing in Tools and Validate Landing Page Elements
  Given the user is on UHC medicare acquisition site PRE landing page
  	| Site | <site> |
  When user navigate Plan Recommendation Engine Using Get Started From Medicare Articles
  Then user validate elements on landing page of Plan Recommendation Engine
  
  @FunctionalAARP
     Examples: 
      | site |
      | AARP |  
      
      @FunctionalUHC
      Examples: 
      | site |
      | UHC  |
  
  @PRE @planrecommendation @PRENavigationViaMedicareEducation @landingpage 
  Scenario: - To validate user able to navigate to Plan Recommendation Engine via Shop For a Plan-shop-->Get Help Choosing in Tools and Validate Landing Page Elements
  Given the user is on UHC medicare acquisition site PRE landing page
  	| Site | <site> |
  When user navigate to Medicare Education and validate Plan Recommendation Engine Widget
  
  @FunctionalAARP
     Examples: 
      | site |
      | AARP |  
      
      @FunctionalUHC
      Examples: 
      | site |
      | UHC  |
      
	@PRE @planrecommendation @PRENavigationViaHome @landingpage 
  Scenario: - To validate user able to navigate to Plan Recommendation Engine via Home page PRE Widget and Validate Landing Page Elements      
  Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
  When user navigate to PRE using Homepage PRE widget
  
  @FunctionalAARP
     Examples: 
      | site |
      | AARP |  
      
      @FunctionalUHC
      Examples: 
      | site |
      | UHC  |
  
  
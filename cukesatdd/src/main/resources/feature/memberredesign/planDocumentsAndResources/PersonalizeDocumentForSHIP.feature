Feature: Plan Documents - personalize document for SHIP

 #Background: Feature security flag needs to be true before ATDD script execution
 #    Given First check if feature security flag is set to true
 #     | Feature | UCPUserManagement |
###############################Regression Scenarios Begin Here ########################################

  #@CodeWarriors @F377245 -- Content scenario not validated from ATDD
  Scenario Outline: planType <planType> -memberType <memberType> - To validate the NEW text against personalize plan documents 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigates to plan documents and resources page validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
	Then user validates header section content for Plan Documents and Resources page
	And user validates text as NEW for Plan documents under Plan Materials
	Examples: 
      | planType | memberType         |
      | SHIP     | SHIP_PlanDocument  |
Feature: Plan Documents - personalize document for SHIP

  @CodeWarriors @F377245
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
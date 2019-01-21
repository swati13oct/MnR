Feature: Plan Selector Tool flow - Verify back to plan options navigation to plan selector page
@Planselectorbacktoplanoptions @Spartans
Scenario Outline: To validate Plan selector flow in UHC site
Given the user is on UHC medicare acquisition site landing page
When user goes to ours plan tab and click on Take the Quiz button 
And clicks on get started button and runs questionnaire
	|Zip Code| <zipcode> |
And I select my Response and go to Next Questionnaire
And I select my second Response and go directly to results page	
And I click plan detail button
Then the user clicks on both top and bottom back to plan options link and validates its redirection

Examples:
|zipcode|
|90210  |

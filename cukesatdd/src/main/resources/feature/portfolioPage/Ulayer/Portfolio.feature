@vppportfoliopage
Feature: To Verify view plans and pricing Portfolio Page

Scenario Outline: To validate zip code widget functionality MA/PDP prospect
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
And verifies the zipcode on VPP page 
Examples:
		|zipCode|county     |
		|90210  |Los Angeles County|
		
@vppportfoliopage
Scenario: Verify Search by address from VPP portfolio page
Given the user is on the vpp portfolio page
Then user clicks on search by address link
		
@retiree
Feature: 3.03. ACQ-Retiree Pharamacy locator flow UMS

@retireePharmacylocator  @retireePharmacylocator_Smoke
Scenario Outline:To verify the pharmacy locator flow in Retiree site
Given The user is on Retiree Home page 
When the user navigates to pharmacy search page in Retiree Site
And the user enters following details for pharmacy search in Retiree Site
	| Zip Code	| <zipcode>	|
	| Distance	| <distance>	|
	| County Name	| <county>	|
Then the user validates the available pharmacies in Retiree site
	
Examples:
	| zipcode     | distance  | county            |  
	| 80002       | 25 miles  | Adams County      |

	
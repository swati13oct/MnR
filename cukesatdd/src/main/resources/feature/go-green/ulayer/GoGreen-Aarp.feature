@goGreenTest
Feature: To test go green on AARP site 
Scenario Outline: Verify go green in AARP site for federal plan type member  
Given registered member for go green in AARP site
    | <planType> |
When the user clicks on go green icon in AARP site
And the user updates preferences by changing delivery preferences for corresponding document name in AARP Site
	| <documentname:preferences> |
Then the user validates the updated preferences in AARP site


Examples:
	| planType | documentname:preferences								|
	| PDP      | Annual Notice Of Changes Documents:Online,Annual Pharmacy Directory:U.S. Mail	|
#	| MAPD     | Prescription Drug Explanation of Benefits (EOB):Online				|
#	| MA       | Claims-Online									|
#       | MS       | Claims-Online									|
#       | HIP      | Claims-Online									|
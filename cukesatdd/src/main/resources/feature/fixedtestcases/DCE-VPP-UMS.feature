@fixedTestCaseTest
Feature: To test DCE to VPP plan Summary flow  in UMS site
Scenario Outline: To Verify the drugs and plan summary for non AEP period
Given the user is on the UHC medicare solutions site landing page
When the user performs drug search using the following information in UMS site
	| Zip Code    | <zipcode>  |
	| County      | <county>   |
When the user search the drug using drug initials in UMS site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in UMS site
When the user selects following drug in UMS site
	| <drugName> |
Then the user validates the available drug information in UMS site
When the user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in UMS site


Examples:
	| zipcode | county              | drugInitials	|  drugName      |  drugDosage	       | quantity	| drugFrequency  | packages | genericAvailable	| brand/generic								|
	| 90210   |  Los Angeles County	| lipi       	| Lipitor        |  Lipitor TAB 20MG   |   40		| Every 3 Months | null     |	yes				| Lipitor TAB 20MG (Qty 40 Every 3 Months)			| 
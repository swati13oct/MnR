@druglookupUhcRetiree
Feature: To test drug search on UHCRetiree site
Scenario Outline:Verify drug search in UHCRetiree site for a member
Given user navigates to the UHCRetiree site
When the user navigates to drug search in UHCRetiree site
And the user clicks on drugLinks available on the links page in UHCRetiree site
      | <drugLink> |
And the user search the drug with drugInitials in UHCRetiree site
      | <drugInitials> |
And the user selects drugName in the drug list in UHCRetiree site
      | <drugName> | 
Then the user validates drug dosages in UHCRetiree site
#		
#		
Examples:
		| drugLink                          | drugInitials | drugName     |
		| North Carolina State Health Plan  | Nabumetone   | Nabumetone   |
		| North Carolina State Health Plan  | Vimovo       | Vimovo       |
		| North Carolina State Health Plan  | Ponstel      | Ponstel      |
		| North Carolina State Health Plan  | Duragesic    | Duragesic    |
		| North Carolina State Health Plan  | Etodolac ER  | Etodolac ER  |
		| North Carolina State Health Plan  | Cialis       | Cialis       |
		| CalPERS                           | Mupirocin    | Mupirocin    |
		| CalPERS                           | Suprax       | Suprax       |
		| CalPERS                           | Invanz       | Invanz       |
		| CalPERS                           | Potiga       | Potiga       |
		| CalPERS                           | Etodolac ER  | Etodolac ER  |
		| CalPERS                           | Cialis       | Cialis       |
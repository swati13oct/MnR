@druglookupUhcRetiree
Feature: To test drug search on UHCRetiree site
Scenario Outline:Verify drug search in UHCRetiree site for a member
Given user navigates to the UHCRetiree site
When the user navigates to drug search in UHCRetiree site
And the user clicks on drugLinks available on the links page in UHCRetiree site
And the user search the drug with drugInitials in UHCRetiree site
      | <drugInitials> |
And the user selects drugName in the drug list in UHCRetiree site
      | <drugName> | 
Then the user validates drug name in UHCRetiree site
#		
#		
Examples:
		| drugInitials | drugName     |
		| Mupirocin    | mupirocin    |
		| lipi         | Lipitor      |
	    | benz         | Benzaclin    |
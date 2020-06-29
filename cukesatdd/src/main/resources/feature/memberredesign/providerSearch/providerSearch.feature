@providerSearch
Feature: 1.23 Member Provider Search

  @providerSearch01 @regressionMember
  Scenario Outline: -Index <index> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then the user navigates to Provider Search page
	Then the user navigates to Claims page from Provider Search page
	Then the user navigates to Benefits page from Provider Search page
	Then the user navigates to Payments page from Provider Search page
	Then the user navigates to Pharmacies and Prescriptions page from Provider Search page
	Then the user navigates to Health and Wellness page from Provider Search page
	Then the user navigates to Account Settings page from Provider Search page
	
	@providerSearch01a
    Examples: 
	    | index | planType | memberType              | 
	    | 01    | MAPD     | GRP_ProviderSearch      |
	    | 02    | MAPD     | UHC_IND_ProviderSearch  |
	    | 03    | MAPD     | AARP_IND_ProviderSearch |
	    | 04    | PDP      | AARP_IND_ProviderSearch |

	@providerSearch01b
    Examples: 
	    | index | planType | memberType              | 
        | 05    | MA       | UHC_IND_ProviderSearch  |
	    | 06    | MA       | AARP_IND_ProviderSearch |
	    | 07    | MEDICA   | MEDICA_IND_ProviderSearch |
	    | 08    | PCP      | PCP_IND_ProviderSearch  |


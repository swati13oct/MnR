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
	
	@providerSearch01_mapd
    Examples: 
	    | index | planType | memberType              | 
	    | 01    | MAPD     | AARP_IND_ProviderSearch |
	    | 02    | MAPD     | UHC_IND_ProviderSearch  |

	@providerSearch01_pdp
    Examples: 
	    | index | planType | memberType              | 
	    | 03    | PDP      | AARP_IND_ProviderSearch |

	@providerSearch01_ma
    Examples: 
	    | index | planType | memberType              | 
        | 04    | MA       | UHC_IND_ProviderSearch  |
	    | 05    | MA       | AARP_IND_ProviderSearch |

	@providerSearch01_medica_pcp
    Examples: 
	    | index | planType | memberType              | 
	    | 06    | MEDICA   | MEDICA_IND_ProviderSearch |
	    | 07    | PCP      | PCP_IND_ProviderSearch  |

	@providerSearch01_grp
    Examples: 
	    | index | planType | memberType              | 
	    | 08    | PDP      | AARP_IND_ProviderSearch |

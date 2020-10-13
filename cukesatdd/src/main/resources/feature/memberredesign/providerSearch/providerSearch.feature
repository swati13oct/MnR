@providerSearch
Feature: 1.23 Member Provider Search

  #----- begin sanity
  @sanity01
  Scenario Outline: -Index <index> -Plan Type: <planType> -Member Type: <memberType> - To validate navigation from Provider Search page to other secondary pages - claims, benefits, payment
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then the user navigates to Provider Search page
	Then the user navigates to Claims page from Provider Search page
	Then the user navigates to Benefits page from Provider Search page
	Then the user navigates to Payments page from Provider Search page

    @sanity_providerSearch01_mapd
    Examples: 
	    | index | planType | memberType              | 
	    | S02   | MAPD     | UHC_IND_ProviderSearch  |

	@sanity_providerSearch01_pdp
    Examples: 
	    | index | planType | memberType              | 
	    | S03   | PDP      | AARP_IND_ProviderSearch |

	@sanity_providerSearch01_ma
    Examples: 
	    | index | planType | memberType              | 
	    | S05   | MA       | AARP_IND_ProviderSearch |

    @sanity_providerSearch01_medica_pcp
    Examples: 
	    | index | planType | memberType              | 
	    | S06   | MEDICA   | MEDICA_IND_ProviderSearch |

  @sanity02
  Scenario Outline: -Index <index> -Plan Type: <planType> -Member Type: <memberType> - To validate navigation from Provider Search page to other secondary pages - pharmacies and prescriptions, health and wellness, account setting
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then the user navigates to Provider Search page
	Then the user navigates to Pharmacies and Prescriptions page from Provider Search page
	Then the user navigates to Health and Wellness page from Provider Search page
	Then the user navigates to Account Settings page from Provider Search page

    @sanity_providerSearch01_mapd
    Examples: 
	    | index | planType | memberType              | 
	    | S02   | MAPD     | UHC_IND_ProviderSearch  |

	@sanity_providerSearch01_pdp
    Examples: 
	    | index | planType | memberType              | 
	    | S03   | PDP      | AARP_IND_ProviderSearch |

	@sanity_providerSearch01_ma
    Examples: 
	    | index | planType | memberType              | 
	    | S05   | MA       | AARP_IND_ProviderSearch |

    @sanity_providerSearch01_medica_pcp
    Examples: 
	    | index | planType | memberType              | 
	    | S06   | MEDICA   | MEDICA_IND_ProviderSearch |

  #----- begin regression
  @providerSearch01 @regressionMember
  Scenario Outline: -Index <index> -Plan Type: <planType> -Member Type: <memberType> - To validate navigation from Provider Search page to other secondary pages
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
	    | 07    | PCP      | PCP_IND_ProviderSearch  |
	    | 06    | MEDICA   | MEDICA_IND_ProviderSearch |

	@providerSearch01_grp
    Examples: 
	    | index | planType | memberType              | 
	    | 08    | PDP      | AARP_IND_ProviderSearch |

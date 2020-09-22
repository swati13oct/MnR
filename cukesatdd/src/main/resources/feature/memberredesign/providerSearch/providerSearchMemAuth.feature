@providerSearch
Feature: 1.23.1 Member Provider Search - Member Auth

  @memAuth_providerSearch01
  Scenario Outline: -Index <index> -Plan Type: <planType> -Member Type: <memberType> - To verify iHR link display for user that is not on the exclusion table
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
    Then the user navigates to Provider Search page
	Then the user navigates to Claims page from Provider Search page
	Then the user navigates to Benefits page from Provider Search page
	Then the user navigates to Payments page from Provider Search page
	Then the user navigates to Pharmacies and Prescriptions page from Provider Search page
	Then the user navigates to Health and Wellness page from Provider Search page
	Then the user navigates to Account Settings page from Provider Search page
	
	@memAuth_providerSearch01_mapd
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 01    | qavgogine | qavgogine | q3_sep_UAT4_MAPD_009 | MAPD     | AARP_IND_ProviderSearch |
	    | 02    | qavgogine | qavgogine | q3_sep_UAT4_UHC044   | MAPD     | UHC_IND_ProviderSearch  |

	@memAuth_providerSearch01_pdp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 03    | qavgogine | qavgogine | q2_jun_aarp0112      | PDP      | AARP_IND_ProviderSearch |

	@memAuth_providerSearch01_ma
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
        | 04    | qavgogine | qavgogine | q1_uhc_ma001         | MA       | UHC_IND_ProviderSearch  |
	    | 05    | qavgogine | qavgogine | q3_sep_UAT4_AARP203  | MA       | AARP_IND_ProviderSearch |

	@memAuth_providerSearch01_medica_pcp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 06    | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020  | MEDICA   | MEDICA_IND_ProviderSearch |
	    | 07    | qavgogine | qavgogine | q3_Sep_UAT4_Sofl022  | PCP      | PCP_IND_ProviderSearch  |

	@memAuth_providerSearch01_grp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 08    | qavgogine | qavgogine | q3_sep_UAT4_Group029 | MAPD     | GRP_ProviderSearch      |

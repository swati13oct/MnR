@providerSearch
Feature: 1.23.2 Member Provider Search - Member Auth - PROD

  #----- begin sanity
  @prod_sanity01
  Scenario Outline: -Index <index> -Plan Type: <planType> -Member Type: <memberType> - To validate navigation from Provider Search page to other secondary pages - To validate navigation from Provider Search page to other secondary pages - claims, benefits, payment
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

	@prod_providerSearch01_mapd
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | S02   | kkumard   | mnrs786@  | LMHOCHSCHILD11       | MAPD     | UHC_IND_ProviderSearch  |

	@prod_providerSearch01_pdp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | S03   | kkumard   | mnrs786@  | nawal1215            | PDP      | AARP_IND_ProviderSearch |	

	@prod_providerSearch01_ma
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
        | S04   | kkumard   | mnrs786@  | haradaty32           | MA       | UHC_IND_ProviderSearch  |

	@prod_providerSearch01_medica_pcp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              |
	    | S07   | kkumard   | mnrs786@  | BATLLOT@AOL.COM      | PCP      | PCP_IND_ProviderSearch  |

  @prod_sanity02
  Scenario Outline: -Index <index> -Plan Type: <planType> -Member Type: <memberType> - To validate navigation from Provider Search page to other secondary pages - To validate navigation from Provider Search page to other secondary pages  - pharmacies and prescriptions, health and wellness, account setting
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
	Then the user navigates to Pharmacies and Prescriptions page from Provider Search page
	Then the user navigates to Health and Wellness page from Provider Search page
	Then the user navigates to Account Settings page from Provider Search page

	@prod_providerSearch01_mapd
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | S02   | kkumard   | mnrs786@  | LMHOCHSCHILD11       | MAPD     | UHC_IND_ProviderSearch  |

	@prod_providerSearch01_pdp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | S03   | kkumard   | mnrs786@  | nawal1215            | PDP      | AARP_IND_ProviderSearch |	

	@prod_providerSearch01_ma
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
        | S04   | kkumard   | mnrs786@  | haradaty32           | MA       | UHC_IND_ProviderSearch  |

	@prod_providerSearch01_medica_pcp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              |
	    | S06   | kkumard   | mnrs786@  | ALREALESTATE@AOL.COM | MEDICA   | MEDICA_IND_ProviderSearch |

	
  #----- begin regression
  @prod_providerSearch01
  Scenario Outline: -Index <index> -Plan Type: <planType> -Member Type: <memberType> - To validate navigation from Provider Search page to other secondary pages
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
	
	@prod_providerSearch01_mapd
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 01    | kkumard  | mnrs786@  | BILL.ROSNER123#      | MAPD     | AARP_IND_ProviderSearch  |
	    | 02    | kkumard  | mnrs786@  | LMHOCHSCHILD11       | MAPD     | UHC_IND_ProviderSearch  |
	    
	@prod_Sanity_providerSearch_mapd
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 02    | kkumard  | mnrs786@  | LMHOCHSCHILD11       | MAPD     | UHC_IND_ProviderSearch  |

	@prod_providerSearch01_pdp  @prod_SanityproviderSearch_pdp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 03    | kkumard  | mnrs786@  | nawal1215            | PDP      | AARP_IND_ProviderSearch |

	@prod_providerSearch01_ma
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
        | 04    | kkumard  | mnrs786@  | haradaty32           | MA       | UHC_IND_ProviderSearch  |
	    | 05    | kkumard  | mnrs786@  | haradaty32           | MA       | AARP_IND_ProviderSearch |

	@prod_providerSearch01_medica_pcp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              |
	    | 07    | kkumard  | mnrs786@  | BATLLOT@AOL.COM      | PCP      | PCP_IND_ProviderSearch  |
<<<<<<< HEAD
	    
    @prod_SanityproviderSearch_medica
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
=======
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
	    | 06    | kkumard  | mnrs786@  | ALREALESTATE@AOL.COM | MEDICA   | MEDICA_IND_ProviderSearch |

	@prod_providerSearch01_grp
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 08    | kkumard  | mnrs786@  | Andersonga1@Bellsouth.Net | MAPD| GRP_ProviderSearch      |


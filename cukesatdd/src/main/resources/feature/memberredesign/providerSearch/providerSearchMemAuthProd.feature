@providerSearch
Feature: 1.23.2 Member Provider Search - Member Auth - PROD

  @prod_providerSearch01
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
	
	@prod_providerSearch01a
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 01    | ashah120  | Mnrqa002  | Andersonga1@Bellsouth.Net | MAPD| GRP_ProviderSearch      |
	    | 02    | ashah120  | Mnrqa002  | LMHOCHSCHILD11       | MAPD     | UHC_IND_ProviderSearch  |

	@prod_providerSearch01b
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 03    | ashah120  | Mnrqa002  | BILL.ROSNER123#      | MAPD     | AARP_IND_ProviderSearch |
	    | 04    | ashah120  | Mnrqa002  | nawal1215            | PDP      | AARP_IND_ProviderSearch |

	@prod_providerSearch01c
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
        | 05    | ashah120  | Mnrqa002  | haradaty32           | MA       | UHC_IND_ProviderSearch  |
	    | 06    | ashah120  | Mnrqa002  | ERNIE2450            | MA       | AARP_IND_ProviderSearch |

	@prod_providerSearch01d
    Examples: 
	    | index | username  | password  | MemUserName          | planType | memberType              | 
	    | 07    | ashah120  | Mnrqa002  | ALREALESTATE@AOL.COM | MEDICA   | MEDICA_IND_ProviderSearch |
	    | 08    | ashah120  | Mnrqa002  | BATLLOT@AOL.COM      | PCP      | PCP_IND_ProviderSearch  |


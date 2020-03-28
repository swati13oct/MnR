@Dreameob @fastandfurious 
Feature:1.04 Member EOB on Dashboard page

  @eob01 @E2E @regressionMember 
  Scenario Outline: -index: <index> -planType: <planType> -memberType: <memberType> EOB Type <eobType> -To verify EOB page content and PDFs
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to EOB page
    Then the user validates the header section content on DREAM EOB
    Then the user validates site leaving pop up after clicking Adobe link
    Then the user validates Need Help section
    #----- Validate Date Range Last 90 Days ----  
    And the user selects the desired date range
      | Date Range | Last 90 Days |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on first eob from the list to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 6 months ----  
    And the user selects the desired date range
      | Date Range | Last 6 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on first eob from the list to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 12 months ----  
    And the user selects the desired date range
      | Date Range | Last 12 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on first eob from the list to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Last 18 months ----  
    And the user selects the desired date range
      | Date Range | Last 18 months |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on first eob from the list to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Validate Date Range Custom Search ----  
    And the user selects the desired date range
      | Date Range | Custom Search |
    Then the user obtains API response info for validation
    Then the user validates search result section content for DREAM EOB
    Then the user clicks on first eob from the list to validate pdf for DREAM EOB
    Then the user validates EOB count between API and UI are the same
    #----- Final validation ----  
    Then the user validates the eob count for all available search ranges
      | Flag Zero EOB User | <flagZeroEob> |

    #@COSMOS_EOBs @devRegression
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 01    | MAPD     | COSMOS_EOB_R      | Medical           | true        |

    #@COSMOS_EOBs
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 02    | MAPD     | COSMOS_EOB_R      | Prescription Drug | true        |
      | 03    | MA       | COSMOS_EOB_R      | Medical           | true        |
     #note: SSP EOB is disabled
     # | 04    | SSP      | PDP_SSP_COMBO_EOB | Medical           | true        |

    #@NICE_EOBs
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob |
      | 05    | MA       | NICE_EOB_R        | Medical           | true        |      
      | 06    | MAPD     | NICE_EOB_R        | Medical           | true        |      
      | 07    | MAPD     | NICE_EOB_R        | Prescription Drug | true        |      

    #note: PDP GROUP has 1000+ eobs, check to see if they can put the img loader while loading
    #note: adobe links won't come up till very very late
    #@Rx_EOBs
    Examples: 
      | index | planType | memberType        | eobType           | flagZeroEob | 
      | 08    | PDP      | Rx_EOB            | Prescription Drug | true        |
      | 09    | PDP      | GROUP_Rx_EOB      | Prescription Drug | true        |
      | 10    | PDP      | PDP_SSP_COMBO_EOB | Prescription Drug | true        |
      | 11    | PDP      | PDP_SHIP_COMBO_EOB| Prescription Drug | true        |


#----------------- KEEP for now ----------------------------------

@DreamEOB1_MA
Scenario Outline: TID: <UID> -plan: <planType> -memberType: <memberType>- Validation Dream EOB page for Medical only MA members
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to Dream EOB Page 
Then the user validates EOB type dropdown is not displayed on Dream EOB page
Then the user validates Learn More Link and section on Dream EOB Page
Then the user validates the EOB table for Medical only EOBs
Then the user validates the date range dropdown
And the user selects the desired date range on Dream EOB Page
  | Date Range     |<dateRange> |
Then the user validates EOB count on Dream EOB Page
	| EOB COUNT			 | <eobCount>|
Then the user validates EOB PDF size is not 0kb on Dream EOB Page

Examples:
	 |UID | planType    | memberType                |dateRange					   |eobCount |
 	 |15134 | MA         | withEOB                   | 18 Months          |		4		 |


@DreamEOB1_MAPD
Scenario Outline: TID: <UID> -plan: <planType> -memberType: <memberType>- Validation Dream EOB page for Medical only MA members
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to Dream EOB Page 
Then the user validates EOB type dropdown is not displayed on Dream EOB page
Then the user validates Learn More Link and section on Dream EOB Page
Then the user validates the date range dropdown
And the user selects the desired date range on Dream EOB Page
  | Date Range     |<dateRange> |
Then the user validates EOB count for Medical Only EOBs on Dream EOB Page
	| EOB COUNT			 | <MedicalCount>|
Then the user validates EOB count for Rx Only EOBs on Dream EOB Page
	| EOB COUNT			 | <RxCount>|
	Then the user validates EOB count for Combined EOBs on Dream EOB Page
	| EOB COUNT			 | <CombinedCount>|
Then the user validates EOB PDF size is not 0kb on Dream EOB Page

Examples:
	 |UID | planType    | memberType                |dateRange					   |MedicalCount |
 	 |15134 | MAPD       | withEOB                 | 18 Months          |		4		 |


@DreamEOB1_PDP
Scenario Outline: TID: <UID> -plan: <planType> -memberType: <memberType>- Validation Dream EOB page for Medical only MA members
Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to Dream EOB Page 
Then the user validates EOB type dropdown is not displayed on Dream EOB page
Then the user validates Learn More Link and section on Dream EOB Page
Then the user validates the EOB table for Rx only EOBs
Then the user validates the date range dropdown
And the user selects the desired date range on Dream EOB Page
  | Date Range     |<dateRange> |
Then the user validates EOB count on Dream EOB Page
	| EOB COUNT			 | <eobCount>|
Then the user validates EOB PDF size is not 0kb on Dream EOB Page

Examples:
	 |UID | planType    | memberType                |dateRange					   |eobCount |
 	 |15134 | PDP         | withEOB                   | 18 Months          |		4		 |
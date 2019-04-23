@claims @theTransformers
Feature: T1.1To validate the new changes related to claims page on the member redesigned site

	@claims1 @claimsSummaryFED @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the claims present for the Federal member on claims summary page for federal members
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		Then I can validate the claims summary header
		And I can search claims for the following claim period on redesigned site
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection in redesigned site
		And I validate the pagination on the claims summary page 
		And the user validates the EOB section based on domain in redesigned site
		  | Domain     | <domain>      |
		  | Plan Type  | <planType>    |
		And the user validates the DownloadMyData section in redesigned site
		Then I navigate to the Claim Details page in redesigned site
		  | Plan Type  | <planType>    |
		And I validate the Claims Total in claims details page in AARP site
		  | Plan Type  | <planType>    |
		Examples: 
		    | TID   | planType | claimPeriod    | domain | claimssystem |
		  	| 15230 | MAPD     | Last 24 months | COSMOS | COSMOSCLAIMS |
		   #| 15234 | MA       | Last 24 months | COSMOS | COSMOSCLAIMS |
		    | 15227 | MA       | Last 24 months | NICE   | NICECLAIMS   |
		    | 15235 | MAPD     | Last 24 months | NICE   | NICECLAIMS   |
		    | 15299 | PDP      | Last 24 months | RX     | RXCLAIMS     |
	
	@claims2 @claimsSummarySHIP  @febrelease @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the claims present for the SHIP member on claims summary page for SHIP members
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		Then I can validate the claims summary header
		And I can search claims for the following claim period on redesigned site
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection in redesigned site
		And I validate the pagination on the claims summary page 
		And the user validates the EOB section based on domain in redesigned site
		     | Domain       | <domain>      |
		      | Plan Type      | <planType>     |
		Then I navigate to the Claim Details page in redesigned site
		  | Plan Type  | <planType>    |
		Then I validate the Claims Table in claims details page in redesigned site    
		  | Plan Type      | <planType>     |
		Examples: 
		    | TID  | planType | claimPeriod    | domain | claimssystem |
		    |15236 | SHIP     | Last 24 Months | NA     | SHIPCLAIMS   |
	 
	@claims3 @claimsDetailsTableFED @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To Verify Claim Table on Claims Details Page for federal members
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		And I can search claims for the following claim period on redesigned site
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		#And the user search claims for the following time interval in redesigned site
		#| Claims To Date   | <claimToDate>   |
		#| Claims From Date | <claimFromDate>  |
		Then I can see the claims displayed based on the selection in redesigned site
		When I navigate to the Claim Details page for federal members
		#tbd-remove And I validate the Claims Table in claims details page for federal members
		And I validate the Claims Table in claims details page in redesigned site
		  | Plan Type      | <planType>     |
		And I validate the Claims Total in claims details page in AARP site
		  | Plan Type  | <planType>    |
		Examples: 
		  | TID   | planType | claimPeriod    | claimssystem |
		  | 15227 | MA       | Last 24 months | NICECLAIMS   |
		  | 15235 | MAPD     | Last 24 months | COSMOSCLAIMS |
	    
	@claims4 @ClaimsDetailsSHIP @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To Verify Learn more section on Claims Details Page
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		And I can search claims for the following claim period on redesigned site
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection in redesigned site
		When I navigate to the Claim Details page for federal members
		#tbd-remove And I validate the Claims Table in claims details page for federal members
		And I validate the Claims Table in claims details page in redesigned site
		  | Plan Type      | <planType>     |
		Examples: 
		  | TID   | planType | claimPeriod    | claimssystem |
		  | 15236 | SHIP     | Last 24 Months | SHIPCLAIMS   |
	   
	  
	@claims5 @TC10_COMBO @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the claims present for the Combo member on claims sumamry page & the Details on the Claims Details page 
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		And I can search claims for the following claim period on redesigned site
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection in redesigned site
		And I validate the pagination on the claims summary page combo member PDP plan
		And the user validates the EOB section based on domain in redesigned site
		  | Domain     | <domain>      |
		  | Plan Type  | <planType>    |
		And I navigate to the Claim Details page in AARP site for COMBO member
		And I validate the Claim Search link on top    
		And I validate the LEARN MORE ABOUT COST BreakDown Link 
		Then I validate the Claims Table in claims details page for Combo
		Then I validate EOB
		And I can view a claim search back button in Claims Details page in AARP site
		And I validate the two COMBO tabs on the page 
		And I validate the two COMBO tabs on the claim Summary page 
		#And the user validates the DownloadMyData section in redesigned site   
		Examples: 
		   | TID    | planType | claimPeriod    | domain | claimssystem |
		   | 15259  | SHIP     | Last 24 months | NA     | COSMOSCLAIMS |
	
	
#need test data to execute thsi specific scenario
	 @TC_09claimsPHIP 
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the Error Message for a PHIP  member on claims sumamry page
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		And I validate the error message for a PHIP Member on the screen
		Examples: 
		   | TID   | planType | claimssystem |
		   #| 15258 | PHIP     | SHIPCLAIMS   |
	  
#	  #This Scenario can only execute when max claims indicator as true
#	  @MaxClaimsResultsError
#	  Scenario Outline: To Verify the Drug Claims History: Reached Maximum Claim Results Error
#	  Given I am an AARP member on the redesigned site
#	      | Plan Type | <planType> |
#	  When I navigate to the claims Summary page in redesigned site
#	  And the user search claims for the following claim period in AARP site
#	     | Claim Period | <claimPeriod> |
#	  Then The User can able to see Drug Claims History: Reached Maximum Claim Results Error
#	
#	  Examples: 
#	     | planType | claimPeriod    | domain |
#	     | PDP      | Last 24 Months | NA     |
#	
#	  @shipDateRangeGreaterThan24MonthsErrmsg
#	  Scenario Outline: To Verify the SHIP Date Range Greater Than 24-Months Error
#	  Given I am an AARP member on the redesigned site
#	     | Plan Type | <planType> |
#	  When I navigate to the claims Summary page in redesigned site
#	  And the user search claims for the following claim period in AARP site
#	    | Claim Period | <claimPeriod> |
#	  And the user search claims for the following time interval in redesigned site
#	    | Claims To Date   | <claimToDate>   |
#	    | Claims From Date | <claimFromDate> |
#	  Then the user should be able to see the SHIP Date Range Greater Than 24-Months Error
#	
#	  Examples: 
#	    | planType | claimPeriod   | domain | claimToDate | claimFromDate |
#	    | SHIP     | Custom Search | NA     | 10/10/2017  | 06/14/2012    |
#	
#	  @govtDateRangeGreaterThan24MonthsErrmsg
#	  Scenario Outline: To Verify the FED Date Range Greater Than 24-Months Error
#	  Given I am an AARP member on the redesigned site
#	     | Plan Type | <planType> |
#	  When I navigate to the claims Summary page in redesigned site
#	  And the user search claims for the following claim period in AARP site
#	     | Claim Period | <claimPeriod> |
#	  And the user search claims for the following time interval in redesigned site
#	     | Claims To Date   | <claimToDate>   |
#	     | Claims From Date | <claimFromDate> |
#	  Then the user should be able to see the FED Date Range Greater Than 24-Months Error
#	
#	  Examples: 
#	     | planType | claimPeriod   | claimToDate | claimFromDate |
#	     | MAPD     | Custom Search | 10/10/2017  | 06/14/2012    |
	  
	@claims7  @claimsSummaryAndDetails @regressionMember
    Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the claims present for the Federal member on claims sumamry page for AARP site
		Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
	      | Test Data Type | <claimssystem> |
	    When I navigate to the claims Summary page in redesigned site
	    Then I can validate the claims summary header
	    And I can search claims for the following claim period on redesigned site
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
	    Then I can see the claims displayed based on the selection in redesigned site
	    And I validate the pagination on the claims summary page 
	   	And the user validates the EOB section based on domain in redesigned site
	      | Domain     | <domain>      |
	      | Plan Type  | <planType>    |
	    And the user validates the DownloadMyData section in redesigned site
	    When I navigate to the Claim Details page for federal members
	    #tbd-remove And I validate the Claims Table in claims details page for federal members
	    And I validate the Claims Table in claims details page in redesigned site
		  | Plan Type      | <planType>     |
	    And I validate the Claims Total in claims details page in AARP site
		  | Plan Type  | <planType>    |
		
	    Examples: 
	     | TID   | planType | claimPeriod    | domain | claimssystem |
	     | 15235 | MAPD     | Last 24 months | NICE   | NICECLAIMS   | 
	
	
	@claims8 @TC03_FEDAARPIndividualPDP @regressionMember
    Scenario Outline: TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the claims present for the Federal member on claims sumamry page for AARP site
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
	      | Test Data Type | <claimssystem> |
	    When I navigate to the claims Summary page in redesigned site
	    And I can search claims for the following claim period on redesigned site
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
	    Then  I can see the claims displayed based on the selection in redesigned site for PDP plans 
	    And I validate the pagination on the claims summary page for members  
	    And the user validates the EOB section in redesigned site    
	    #And the user validates the DownloadMyData section in redesigned site
	
	    Examples: 
	     | TID   | planType | claimPeriod    | domain | claimssystem |
	     | 15299 | PDP      | Last 24 months | RX     | RXCLAIMS     |
	     
	        
	@claims9  @Tc02 @Tc05 @regressionMember
	Scenario Outline: TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the claims present for the Federal member on claims sumamry page for AARP site
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
	      | Test Data Type | <claimssystem> |
	    When I navigate to the claims Summary page in redesigned site
	    Then I can validate the claims summary header
	    And I can search claims for the following claim period on redesigned site
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
	    Then I can see the claims displayed based on the selection in redesigned site
	    And I validate the pagination on the claims summary page for members
	   	And the user validates the EOB section based on domain in redesigned site
	      | Domain     | <domain>      |
	      | Plan Type  | <planType>    |
	    And the user validates the DownloadMyData section in redesigned site
	    When I navigate to the Claim Details page for federal members
	    #tbd-remove And I validate the Claims Table in claims details page for federal members
	    And I validate the Claims Table in claims details page in redesigned site
		  | Plan Type      | <planType>     |
	    And I validate the Claims Total in claims details page in AARP site
		  | Plan Type  | <planType>    |
	    And I validate the claims history Button
		   
	    Examples: 
	         | TID   | planType | claimPeriod    | domain | claimssystem |
		   # | 15235 | MAPD     | Last 24 months | NICE   | NICECLAIMS   |
		     | 15230 | MAPD     | Last 24 months | COSMOS| COSMOSCLAIMS  |
	     
	  
	@claims10  @TC01_FED_AARP_Individual_NICE @TC04_FED_UHC_Individual_COSMOS @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the claims present for the Federal member on claims sumamry page & the Details on the Claims Details page 
		Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
	      | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
	    Then I validate the claim summary header
	    And I can search claims for the following claim period on redesigned site
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
	    Then I can see the claims displayed based on the selection in redesigned site
	    And I validate the pagination on the claims summary page for members
	   	And the user validates the EOB section based on domain in redesigned site
	      | Domain     | <domain>      |
	      | Plan Type  | <planType>    |
	 	  When I navigate to the Claim Details page for federal members
	    #tbd-remove And I validate the Claims Table in claims details page for federal members
	    And I validate the Claims Table in claims details page in redesigned site
		  | Plan Type      | <planType>     |
	    And I validate the Claims Total in claims details page in AARP site
		  | Plan Type  | <planType>    |
	    And I can view a claim search back button in Claims Details page in AARP site
	    And the user validates the DownloadMyData section in redesigned site
		   
	    Examples: 
	      | TID   | planType | claimPeriod    | domain | claimssystem |
	      | 15227 | MA       | Last 24 months | NICE   | NICECLAIMS   |
	     #| 15234 | MA       | Last 24 months | COSMOS | COSMOSCLAIMS |
	      
	     
	@claims11 @TC11_PCP @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the claims present for the Federal member on claims sumamry page for AARP site
		Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
	      | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		Then I can validate the claims summary header
		Then I validate the text for PCP & medica members 
		And I can search claims for the following claim period on redesigned site
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection in redesigned site
		And I validate the pagination on the claims summary page for members
		And the user validates the EOB section based on domain in redesigned site
	      | Domain     | <domain>      |
	      | Plan Type  | <planType>    |
		And the user validates the DownloadMyData section in redesigned site
		When I navigate to the Claim Details page for federal members
		#tbd-remove And I validate the Claims Table in claims details page for federal members
		And I validate the Claims Table in claims details page in redesigned site
		  | Plan Type      | <planType>     |
		And I validate the Claims Total in claims details page in AARP site
		  | Plan Type  | <planType>    |
		And I validate the claims history Button
		   
		Examples: 
	      | TID   | planType | claimPeriod    | domain | claimssystem |
	      | 15268 | PCP      | Last 24 months | PCP    | COSMOSCLAIMS |
	      
	    
	@claims12  @claimsprintanddownload @thePredators @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the <claimssystem> on claims summary page
		Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
	      | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		#Then I can validate the claims summary header
		And I can search claims for the following claim period on redesigned site
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |      
		Then I can see the claims displayed based on the selection in redesigned site
		Then I can see the print and download option in claims details table
		And I validate the print and download option in claims details table
		And I validate the pagination on the claims summary page 
		And the user validates the EOB section based on domain in redesigned site    
	      | Domain       | <domain>      |
	      | Plan Type    | <planType>    |
		Then I navigate to the Claim Details page in redesigned site
		  | Plan Type  | <planType>    |
		Then I validate the Claims Table in claims details page in redesigned site
		  | Plan Type      | <planType>     |
		And I validate the EOB option in claims details page in redesigned site    
		
		Examples: 
	      | TID   | planType | claimPeriod    | domain | claimssystem |
	      | 15230 | MAPD     | Last 24 Months | COSMOS | COSMOSCLAIMS |
	      
	@claims13  @claimsSummaryFEDError @regressionMember
		Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the custom-search error msg present for the Federal member on claims summary page for federal members when the from date is greater than to date 
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		Then I can validate the claims summary header
		And I can search claims for the following claim period on redesigned site
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		And the user search claims for the following time interval in redesigned site
		  | Claims To Date   | <claimToDate>   |
		  | Claims From Date | <claimFromDate>  |
		Then the user should be able to see the from date is greater than to date error message
		
		Examples: 
	     | TID   | planType | claimPeriod  | domain | claimssystem |claimToDate | claimFromDate |
	     | 15230 | MAPD     |custom-search | COSMOS | COSMOSCLAIMS |11/06/2018  | 01/02/2019    |
	     
	@claims14 @claimsPagination @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -claimsSystem: <claimssystem> - To validate the claims present for the Federal member on claims summary page for federal members
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Test Data Type | <claimssystem> |
		When I navigate to the claims Summary page in redesigned site
		Then I can validate the claims summary header
		And I can search claims for the following claim period on redesigned site
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection in redesigned site
		And I validate the pagination on the claims summary page 
		And the user validates the EOB section based on domain in redesigned site
		  | Domain     | <domain>      |
		  | Plan Type  | <planType>    |
		  
		Examples: 
	    | TID   | planType | claimPeriod    | domain | claimssystem |
	  	| 15230 | MAPD     | Last 24 months | COSMOS | COSMOSCLAIMS |


    #----- begin of claims00 ---------------------------------------------------------
    # note: bypassIssue-1 - YourShare value mismatch between summary and detail INC10332773
    # note: bypassIssue-2 - MA NICE missing Search EOB History on both summary and detail page - pending INC
    # note: bypassIssue-2 - MAPD NICE missing Search EOB History on detail page - pending INC
    # note: bypassIssue-3 - MA and MAPD NICE missing This page contains PDF doc text on detail page - pending INC
	# note: any additional Example will need to tag with either one of these 
	# note:   @claims00_COSMOS_MEDICAL, @claims00_COSMOS_DRUG, 
	# note:   @claims00_NICE_MEDICAL, @claims00_NICE_DRUG or @claims00_NOT_NICE_OR_COSMOS
	# note: 
	#----------------------------------------------------------------------------------
    @claims00 @def1041 @thePredators
	Scenario Outline: DID: <DID> -plan: <planType> -claimsSystem: <claimssystem> -claimType: <claimType> - <index> - To validate claims for both summary and detail page for each search range options
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>            |
		  | Test Data Type | <claimssystem>        |
		When I navigate to the claims Summary page in redesigned site
		Then I can validate the claims summary header
		#----------------- Test for- Last 30 days --------------------------
		And I can search claims for the following claim period and claim type on redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Claim Period | Last 30 days            |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 30 days            |
		And I validate the pagination on the claims summary page for given range 
		  | Claim Period | Last 30 days            |
		Then I can validate the print and download option in claims details table for given range
		  | Claim Period | Last 30 days            |
		Then I can validate claims table displayed based on the selection in redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 30 days            |
		And I can validate the EOB section based on domain in redesigned site
		  | Domain       | <domain>                |
		  | Plan Type    | <planType>              |
		And I can validates the DownloadMyData section in redesigned site
		  | Plan Type    | <planType>              |
		Then I validate Claim Details page content value and Learn More and EOB		  
		  | Domain       | <domain>                |
	      | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 30 days            |
		#----------------- Test for Last 90 days --------------------------
		And I can search claims for the following claim period and claim type on redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Claim Period | Last 90 days            |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 90 days            |
		And I validate the pagination on the claims summary page for given range 
		  | Claim Period | Last 90 days            |
		Then I can validate the print and download option in claims details table for given range
		  | Claim Period | Last 90 days            |
		Then I can validate claims table displayed based on the selection in redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 90 days            |
		And I can validate the EOB section based on domain in redesigned site
		  | Domain       | <domain>                |
		  | Plan Type    | <planType>              |
		And I can validates the DownloadMyData section in redesigned site
		  | Plan Type    | <planType>              |
		Then I validate Claim Details page content value and Learn More and EOB		  
		  | Domain       | <domain>                |
	      | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 90 days            |
		#----------------- Test for Last 6 months --------------------------
		And I can search claims for the following claim period and claim type on redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Claim Period | Last 6 months           |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 6 months           |
		And I validate the pagination on the claims summary page for given range 
		  | Claim Period | Last 6 months           |
		Then I can validate the print and download option in claims details table for given range
		  | Claim Period | Last 6 months           |
		Then I can validate claims table displayed based on the selection in redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 6 months           |
		And I can validate the EOB section based on domain in redesigned site
		  | Domain       | <domain>                |
		  | Plan Type    | <planType>              |
		And I can validates the DownloadMyData section in redesigned site
		  | Plan Type    | <planType>              |
		Then I validate Claim Details page content value and Learn More and EOB		  
		  | Domain       | <domain>                |
	      | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 6 months           |
		#----------------- Test for Last 12 months --------------------------
		And I can search claims for the following claim period and claim type on redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Claim Period | Last 12 months          |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 12 months          |
		And I validate the pagination on the claims summary page for given range 
		  | Claim Period | Last 12 months          |
		Then I can validate the print and download option in claims details table for given range
		  | Claim Period | Last 12 months          |
		Then I can validate claims table displayed based on the selection in redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 12 months          |
		And I can validate the EOB section based on domain in redesigned site
		  | Domain       | <domain>                |
		  | Plan Type    | <planType>              |
		And I can validates the DownloadMyData section in redesigned site
		  | Plan Type    | <planType>              |
		Then I validate Claim Details page content value and Learn More and EOB		  
		  | Domain       | <domain>                |
	      | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 12 months          |
		#----------------- Test for Last 24 months --------------------------
		And I can search claims for the following claim period and claim type on redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Claim Period | Last 24 months          |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 24 months          |
		And I validate the pagination on the claims summary page for given range 
		  | Claim Period | Last 24 months          |
		Then I can validate the print and download option in claims details table for given range
		  | Claim Period | Last 24 months          |
		Then I can validate claims table displayed based on the selection in redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 24 months          |
		And I can validate the EOB section based on domain in redesigned site
		  | Domain       | <domain>                |
		  | Plan Type    | <planType>              |
		And I can validates the DownloadMyData section in redesigned site
		  | Plan Type    | <planType>              |
		Then I validate Claim Details page content value and Learn More and EOB		  
		  | Domain       | <domain>                |
	      | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Last 24 months          |
		#----------------- Test for Custom search --------------------------
		And I can search claims for the following claim period and claim type on redesigned site
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Claim Period | Custom search           |
		And the user custom search claims for the following time interval in redesigned site
		  | Plan Type    | <planType>              |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Custom search           |
		And I validate the pagination on the claims summary page for given range 
		  | Claim Period | Custom search           |
		Then I can validate the print and download option in claims details table for given range
		  | Claim Period | Custom search           |
		And I can validate the EOB section based on domain in redesigned site
		  | Domain       | <domain>                |
		  | Plan Type    | <planType>              |
		And I can validates the DownloadMyData section in redesigned site
		  | Plan Type    | <planType>              |
		Then I validate Claim Details page content value and Learn More and EOB		  
		  | Domain       | <domain>                |
	      | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimssystem>          |
		  | Has Your Share | <SummaryHasYourShare> |
		  | Claim Period | Custom search           |
		#----------------- Test Custom search error cases --------------------------
		And the user custom search claims for the following invalid time interval in redesigned site
		  | Plan Type        | <planType>          |
		  | Claims From Date | 01/02/2019          |
		  | Claims To Date   | 01/02/2018          |
		Then the user should be able to see the from date is greater than the to date error message being displayed
		  | Plan Type        | <planType>          |
		And the user custom search claims for the following invalid time interval in redesigned site
		  | Plan Type        | <planType>          |
		  | Claims From Date | 01/02/2017          |
		  | Claims To Date   | 01/02/2019          |
		Then the user should be able to see the search range is greater than two years error
		  | Plan Type        | <planType>          |
		#----------------- Final Test claims number makes sense from search periods --------------
		And I can validate the numbers of claims from all search periods
		  
	@claims00_01 @claims00_MAPD @claims00_COSMOS_MEDICAL @diffGrpsDiffYrs
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |01    |1041| MAPD     | COSMOS | diffGrpsDiffYrs_COSMOSCLAIMS | Medical           | Yes                 |

	@claims00_02 @claims00_MAPD @claims00_COSMOS_DRUG @diffGrpsDiffYrs
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |02    |1041| MAPD     | COSMOS | diffGrpsDiffYrs_COSMOSCLAIMS | Prescription drug | Yes                 |

	@claims00_03 @claims00_MA @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |03    |1041| MA       | COSMOS | COSMOSCLAIMS                 | Medical           | Yes                 |

	@claims00_04 @claims00_MA @claims00_NICE_MEDICAL
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |04    |1041| MA       | NICE   | NICECLAIMS                   | Medical           | Yes                 |

	@claims00_05 @claims00_MAPD @claims00_NICE_MEDICAL
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |05    |1041| MAPD     | NICE   | NICECLAIMS                   | Medical           | Yes                 |

	@claims00_06 @claims00_MAPD @claims00_NICE_DRUG
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |06    |1041| MAPD     | NICE   | NICECLAIMS                   | Prescription drug | Yes                 |

	@claims00_07 @claims00_MAPD @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |07    |1041| MAPD     | COSMOS | COSMOSCLAIMS                 | Medical           | Yes                 |

	@claims00_08 @claims00_MAPD @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |08    |1041| MAPD     | COSMOS | COSMOSCLAIMS                 | Prescription drug | Yes                 |

	@claims00_09 @claims00_PCP @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |09    |1041| PCP      | COSMOS | COSMOSCLAIMS                 | Medical           | Yes                 |

	@claims00_10 @claims00_PCP @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |10    |1041| PCP      | COSMOS | COSMOSCLAIMS                 | Prescription drug | Yes                 |

	@claims00_11 @claims00_MEDICA @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |11    |1041| MEDICA   | COSMOS | COSMOSCLAIMS                 | Medical           | Yes                 |

	@claims00_12 @claims00_MEDICA @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |12    |1041| MEDICA   | COSMOS | COSMOSCLAIMS                 | Prescription drug | Yes                 |

	@claims00_13 @claims00_PDP @claims00_RX @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |13    |1041| PDP      | RX     | RXCLAIMS                     | Prescription drug | No                  |

	@claims00_14 @claims00_SHIP @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |14    |1041| SHIP     | NA     | SHIPCLAIMS                   | NA                | No                  |

	@claims00_15 @claims00_COMBO @claims00_MAPD @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |15    |1041| MAPD     | COSMOS | COMBO_COSMOSCLAIMS           | Medical           | Yes                 |

	@claims00_16 @claims00_COMBO @claims00_MAPD @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |16    |1041| MAPD     | COSMOS | COMBO_COSMOSCLAIMS           | Prescription drug | Yes                 |

	@claims00_17 @claims00_COMBO @claims00_SHIP @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |17    |1041| SHIP     | NA     | COMBO_SHIPCLAIMS             | NA                | No                  |

	@claims00_18 @claims00_GROUP @claims00_MAPD @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |18    |1041| MAPD     | COSMOS | GROUP_COSMOSCLAIMS           | Medical           | Yes                 |

	@claims00_19 @claims00_GROUP @claims00_MAPD @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |19    |1041| MAPD     | COSMOS | GROUP_COSMOSCLAIMS           | Prescription drug | Yes                 |

	@claims00_20 @claims00_SSUP @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | domain | claimssystem                 | claimType         | SummaryHasYourShare |
	  |20    |1041| SSUP     | COSMOS | COSMOSCLAIMS                 | Medical           | Yes                 |

     #note: these will be in team-a env only
	 #|xx    |1041| MAPD     | COSMOS | t_diffGrpsDiffYrs_COSMOSCLAIMS | Medical           | Yes                |
	 #|xx    |1041| MAPD     | COSMOS | t_diffGrpsDiffYrs_COSMOSCLAIMS | Prescription drug | Yes                |
	#----- end of claims00 ---------------------------------------------------------

	
	#---- this the test EOB link on claims details page
    @claims15 @claimsEOB @US1268210 @F244667 @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -claimsSystem: <claimssystem> - to validate the claims eob link on claims detail page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    Then I validate the claim summary header
    And I can search claims for the following claim period on redesigned site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    Then I can see the claims displayed based on the selection in redesigned site
    When I navigate to the Claim details page to see view as pdf EOB
    Then I can vdate the view as pdf link on claims details page header
      | Plan Type    | <planType>    |
      | Domain       | <domain>      |

    Examples: 
      | FID    | planType | claimPeriod    | domain | claimssystem   |
      | 244667 | MA       | Last 24 months | NICE   | EOB_NICECLAIMS |

    #---- this test check that sub-navigation to EOB page under Claims tab is suppressed for SSUP Only Plan member
    @claims16 @US1662790 @F267688 @claimsEOB_SSUP_Plan @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -claimsSystem: <claimssystem> - to validate that sub-navigation to EOB page under Claims tab is suppressed for SSUP Only Plan member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page from test harness page or dashboard
    Then Explanation of benefits sub navigation under Claims tab is not displayed

    Examples: 
      | FID    | planType | claimssystem |
      | 267688 | SSUP     | COSMOSCLAIMS |
      
    @claims17 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -claimsSystem: <claimssystem> - to validate that SSUP member accessing EOB page via deep link
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page from test harness page or dashboard
    Then Explanation of benefits sub navigation under Claims tab is not displayed
    Then Explanation of benefits deep link is invoked and validate the Page
    Examples: 
      | FID    | planType | claimssystem             |
      | 267688 | SSUP     | SSUP_EOB_Deeplink_CLAIMS |
      
    @claims18 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan
    Scenario Outline: FID: <FID> -plan: <planType> -claimsSystem: <claimssystem> - to validate that SSUP member accessing EOB page via deep link
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page from test harness page or dashboard
    Then Validate Explanation of benefits Page for group SSUP
    Examples: 
      | FID    | planType | claimssystem          |
      | 267688 | SSUP     | Group_SSUP_EOB_CLAIMS |

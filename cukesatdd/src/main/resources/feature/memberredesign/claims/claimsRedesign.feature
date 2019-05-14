@claims @theTransformers
Feature: T1.1To validate the new changes related to claims page on the member site

	@claims1 @claimsSummaryFED @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the Federal member on claims summary page for federal members
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		  | Claim System   | <claimSystem>  |
		When I navigate to the claims Summary page from dashboard or testharness page
		Then I can validate the claims summary header on claims summary page
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		  #tbd | Claim System   | <claimSystem> |
		And I can search claims for the following claim period on claims summary page
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection on claims summary page
		And I validate the pagination on the claims summary page 
		And I can see the learn more and print and download option on claims summary table section 
		And I validate the EOB section based on claims system on claims summary page
		  | Plan Type    | <planType>    |
		  | Claim System | <claimSystem> |
		And I validate the DownloadMyData section on claims summary page
		Then I navigate to the Claim Details page from claims summary page
		  | Plan Type  | <planType>    |
		And I validate the Claims Total on claims details page
		  | Plan Type  | <planType>    |
	    And I validate the claims summary link on claims detail bottom page
		  | Plan Type  | <planType>    |
		Then I navigate to the Claim Details page from claims summary page
		  | Plan Type  | <planType>    |
	    And I validate the claims summary link on claims detail top page
		  | Plan Type  | <planType>    |
	    Examples: 
		    | TID   | planType | memberType | claimPeriod    | claimSystem   |
		  	| 15230 | MAPD     | Individual | Last 24 months | COSMOS_CLAIMS |
		   #| 15234 | MA       | Individual | Last 24 months | COSMOS_CLAIMS |
		    | 15227 | MA       | Individual | Last 24 months | NICE_CLAIMS   |
		    | 15235 | MAPD     | Individual | Last 24 months | NICE_CLAIMS   |
		    | 15299 | PDP      | Individual | Last 24 months | RX_CLAIMS     |
	
	@claims2 @claimsSummarySHIP @febrelease @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the SHIP member on claims summary page for SHIP members
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		  | Claim System   | <claimSystem>  |
		When I navigate to the claims Summary page from dashboard or testharness page
		Then I can validate the claims summary header on claims summary page
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		And I can search claims for the following claim period on claims summary page
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection on claims summary page
		And I validate the pagination on the claims summary page 
		And I validate the EOB section based on claims system on claims summary page
	      | Plan Type      | <planType>     |
		  | Claim System   | <claimSystem>  |
		Then I navigate to the Claim Details page from claims summary page
		  | Plan Type      | <planType>     |
		Then I validate the Claims Table on claims details page    
		  | Plan Type      | <planType>     |
		Examples: 
	      | TID  | planType | memberType | claimPeriod    | claimSystem    |
		  |15236 | SHIP     | Individual | Last 24 Months | COMPASS_CLAIMS |
	 
	@claims3 @claimsDetailsTableFED @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To Verify Claim Table on Claims Details Page for federal members
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		  | Claim System   | <claimSystem>  |
		When I navigate to the claims Summary page from dashboard or testharness page
		And I can search claims for the following claim period on claims summary page
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection on claims summary page
		When I navigate to the Claim Details page for federal members
		And I validate the Claims Table on claims details page
		  | Plan Type      | <planType>     |
		And I validate the Claims Total on claims details page
		  | Plan Type  | <planType>    |
		Examples: 
		  | TID   | planType | memberType | claimPeriod    | claimSystem   |
		  | 15227 | MA       | Individual | Last 24 months | NICE_CLAIMS   |
		  | 15235 | MAPD     | Individual | Last 24 months | COSMOS_CLAIMS |
	    
	@claims4 @ClaimsDetailsSHIP @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To Verify Learn more section on Claims Details Page
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		  | Claim System   | <claimSystem>  |
		When I navigate to the claims Summary page from dashboard or testharness page
		And I can search claims for the following claim period on claims summary page
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection on claims summary page
		When I navigate to the Claim Details page for federal members
		And I validate the Claims Table on claims details page
		  | Plan Type    | <planType>     |
		Examples: 
		  | TID   | planType | memberType | claimPeriod    | claimSystem     |
		  | 15236 | SHIP     | Individual | Last 24 Months | COMPASS_CLAIMS  |
	   
	  
	@claims5 @TC10_COMBO @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the Combo member on claims sumamry page and the Details on the Claims Details page 
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>    |
		  | Member Type    | <memberType>  |
		  | Claim System   | <claimSystem> |
		When I navigate to the claims Summary page from dashboard or testharness page
		And I can search claims for the following claim period on claims summary page
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection on claims summary page
		And I validate the pagination on the claims summary page combo member PDP plan
		And I validate the EOB section based on claims system on claims summary page
		  | Plan Type  | <planType>    |
		  | Claim System   | <claimSystem>  |
		And I navigate to the Claim Details page in AARP site for COMBO member
		And I validate the Claim Search link on top    
		And I validate the LEARN MORE ABOUT COST BreakDown Link 
		Then I validate the Claims Table on claims details page for Combo
		Then I validate EOB
		And I validate the claims summary link on claims detail bottom page
		  | Plan Type  | <planType>    |
		And I validate the two COMBO tabs on the page 
		And I validate the two COMBO tabs on the claim Summary page 
		#And I validate the DownloadMyData section on claims summary page   
		Examples: 
		   | TID    | planType | memberType | claimPeriod    | claimSystem    |
		   | 15259  | SHIP     | Individual | Last 24 months | COMPASS_CLAIMS |
	
	
#    #need test data to execute this specific scenario
#	 @claims6 @TC_09claimsPHIP
#	 Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the Error Message for a PHIP  member on claims sumamry page
#	 Given login with following details logins in the member portal and validate elements
#	   | Plan Type      | <planType>     |
#      | Member Type    | <memberType>   |
#	   | Claim System   | <claimSystem>  |
#	 When I navigate to the claims Summary page from dashboard or testharness page
#	 And I validate the error message for a PHIP Member on the screen
#	 Examples: 
#	   | TID   | planType | memberType | claimSystem    |
#	   | 15258 | PHIP     | Individual | COMPASS_CLAIMS |
	  
	  
	@claims7  @claimsSummaryAndDetails @regressionMember
    Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the Federal member on claims sumamry page for AARP site
		Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
	      | Claim System   | <claimSystem>  |
	    When I navigate to the claims Summary page from dashboard or testharness page
	    Then I can validate the claims summary header on claims summary page
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
	    And I can search claims for the following claim period on claims summary page
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
	    Then I can see the claims displayed based on the selection on claims summary page
	    And I validate the pagination on the claims summary page 
	   	And I validate the EOB section based on claims system on claims summary page
	      | Plan Type    | <planType>    |
		  | Claim System | <claimSystem> |
	    And I validate the DownloadMyData section on claims summary page
	    When I navigate to the Claim Details page for federal members
	    And I validate the Claims Table on claims details page
		  | Plan Type      | <planType>     |
	    And I validate the Claims Total on claims details page
		  | Plan Type  | <planType>    |
		
	    Examples: 
	     | TID   | planType | memberType | claimPeriod    | claimSystem |
	     | 15235 | MAPD     | Individual | Last 24 months | NICE_CLAIMS | 
	
	
	@claims8 @TC03_FEDAARPIndividualPDP @regressionMember
    Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the Federal member on claims sumamry page for AARP site
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
	      | Claim System   | <claimSystem>  |
	    When I navigate to the claims Summary page from dashboard or testharness page
	    And I can search claims for the following claim period on claims summary page
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
	    Then  I can see the claims displayed based on the selection on claims summary page for PDP plans 
	    And I validate the pagination on the claims summary page for members  
	    And I validate the EOB section on claims summary page    
	    #And I validate the DownloadMyData section on claims summary page
	
	    Examples: 
	     | TID   | planType | memberType | claimPeriod    | claimSystem |
	     | 15299 | PDP      | Individual | Last 24 months | RX_CLAIMS   |
	     
	        
	@claims9  @Tc02 @Tc05 @regressionMember
	Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the Federal member on claims sumamry page for AARP site
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
	      | Claim System   | <claimSystem>  |
	    When I navigate to the claims Summary page from dashboard or testharness page
	    Then I can validate the claims summary header on claims summary page
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
	    And I can search claims for the following claim period on claims summary page
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
	    Then I can see the claims displayed based on the selection on claims summary page
	    And I validate the pagination on the claims summary page for members
	   	And I validate the EOB section based on claims system on claims summary page
	      | Plan Type    | <planType>    |
		  | Claim System | <claimSystem> |
	    And I validate the DownloadMyData section on claims summary page
	    When I navigate to the Claim Details page for federal members
	    And I validate the Claims Table on claims details page
		  | Plan Type      | <planType>     |
	    And I validate the Claims Total on claims details page
		  | Plan Type  | <planType>    |
	    And I validate the claims summary link on claims detail bottom page
		  | Plan Type  | <planType>    |
		   
	    Examples: 
	         | TID   | planType | memberType | claimPeriod    | claimSystem    |
		   # | 15235 | MAPD     | Individual | Last 24 months | NICE_CLAIMS    |
		     | 15230 | MAPD     | Individual | Last 24 months | COSMOS_CLAIMS  |
	     
	  
	@claims10  @TC01_FED_AARP_Individual_NICE @TC04_FED_UHC_Individual_COSMOS @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the Federal member on claims sumamry page and the Details on the Claims Details page 
		Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
	      | Claim System   | <claimSystem>  |
		When I navigate to the claims Summary page from dashboard or testharness page
	    Then I can validate the claims summary header on claims summary page
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
	    And I can search claims for the following claim period on claims summary page
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
	    Then I can see the claims displayed based on the selection on claims summary page
	    And I validate the pagination on the claims summary page for members
	   	And I validate the EOB section based on claims system on claims summary page
	      | Plan Type    | <planType>    |
		  | Claim System | <claimSystem> |
	 	When I navigate to the Claim Details page for federal members
	    And I validate the Claims Table on claims details page
		  | Plan Type      | <planType>     |
	    And I validate the Claims Total on claims details page
		  | Plan Type  | <planType>    |
	    And I validate the claims summary link on claims detail bottom page
		  | Plan Type  | <planType>    |
	    And I validate the DownloadMyData section on claims summary page
		   
	    Examples: 
	      | TID   | planType | memberType | claimPeriod    | claimSystem   |
	      | 15227 | MA       | Individual | Last 24 months | NICE_CLAIMS   |
	     #| 15234 | MA       | Individual | Last 24 months | COSMOS_CLAIMS |
	      
	     
	@claims11 @TC11_PCP @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the Federal member on claims sumamry page for AARP site
		Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
	      | Claim System   | <claimSystem>  |
		When I navigate to the claims Summary page from dashboard or testharness page
		Then I can validate the claims summary header on claims summary page
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		Then I validate the text for PCP and medica members 
		And I can search claims for the following claim period on claims summary page
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |
		Then I can see the claims displayed based on the selection on claims summary page
		And I validate the pagination on the claims summary page for members
		And I validate the EOB section based on claims system on claims summary page
	      | Plan Type    | <planType>    |
		  | Claim System | <claimSystem> |
		And I validate the DownloadMyData section on claims summary page
		When I navigate to the Claim Details page for federal members
		And I validate the Claims Table on claims details page
		  | Plan Type      | <planType>     |
		And I validate the Claims Total on claims details page
		  | Plan Type  | <planType>    |
		And I validate the claims summary link on claims detail bottom page
		  | Plan Type  | <planType>    |
		   
		Examples: 
	      | TID   | planType | memberType | claimPeriod    | claimSystem   |
	      | 15268 | PCP      | Individual | Last 24 months | COSMOS_CLAIMS |
	      
	    
	@claims12 @claimsprintanddownload @thePredators @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the <claimSystem> on claims summary page
		Given login with following details logins in the member portal and validate elements
	      | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
	      | Claim System   | <claimSystem>  |
		When I navigate to the claims Summary page from dashboard or testharness page
		Then I can validate the claims summary header on claims summary page
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		And I can search claims for the following claim period on claims summary page
	      | Plan Type    | <planType>    |
	      | Claim Period | <claimPeriod> |      
		Then I can see the claims displayed based on the selection on claims summary page
		Then I can see the learn more and print and download option on claims summary table section
		And I validate the pagination on the claims summary page 
		And I validate the EOB section based on claims system on claims summary page    
	      | Plan Type    | <planType>    |
		  | Claim System | <claimSystem> |
		Then I navigate to the Claim Details page from claims summary page
		  | Plan Type  | <planType>    |
		Then I validate the Claims Table on claims details page
		  | Plan Type      | <planType>     |
		And I validate the EOB option on claims details page    
		
		Examples: 
	      | TID   | planType | memberType | claimPeriod    | claimSystem   |
	      | 15230 | MAPD     | Individual | Last 24 Months | COSMOS_CLAIMS |
	      
	@claims13  @claimsSummaryFEDError @regressionMember
		Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the custom-search error msg present for the Federal member on claims summary page for federal members when the from date is greater than to date 
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		  | Claim System   | <claimSystem>  |
		When I navigate to the claims Summary page from dashboard or testharness page
		Then I can validate the claims summary header on claims summary page
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		And I can search claims for the following claim period on claims summary page
		  | Plan Type    | <planType>    |
		  | Claim Period | <claimPeriod> |
		And I search claims for the following time interval on claims summary page
		  | Claims To Date   | <claimToDate>   |
		  | Claims From Date | <claimFromDate> |
		Then I should be able to see the from date is greater than to date error message
		
		Examples: 
	     | TID   | planType | memberType | claimPeriod   | claimSystem   | claimToDate | claimFromDate |
	     | 15230 | MAPD     | Individual | custom-search | COSMOS_CLAIMS | 11/06/2018  | 01/02/2019    |
	     
	@claims14 @claimsPagination @regressionMember
	Scenario Outline:  TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the Federal member on claims summary page for federal members
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		  | Claim System   | <claimSystem>  |
		When I navigate to the claims Summary page from dashboard or testharness page
		Then I can validate the claims summary header on claims summary page
		  | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
		And I can search claims for the following claim period on claims summary page
		  | Plan Type      | <planType>    |
		  | Claim Period   | <claimPeriod> |
		Then I can see the claims displayed based on the selection on claims summary page
		And I validate the pagination on the claims summary page 
		And I validate the EOB section based on claims system on claims summary page
		  | Plan Type      | <planType>    |
		  | Claim System   | <claimSystem> |
		  
		Examples: 
	    | TID   | planType | memberType | claimPeriod    | claimSystem   |
	  	| 15230 | MAPD     | Individual | Last 24 months | COSMOS_CLAIMS |


    #----- begin of claims00 ---------------------------------------------------------
    # note: bypassIssue-1 - YourShare value mismatch between summary and detail - INC10332773
    # note: bypassIssue-2 - MA NICE missing Search EOB History on both summary and detail page - INC11365785
    # note: bypassIssue-2 - MAPD NICE missing Search EOB History on detail page - INC11365785
    # note: bypassIssue-3 - MA and MAPD NICE missing This page contains PDF doc text on detail page - INC11365785
	# note: any additional Example will need to tag with either one of these 
	# note:   @claims00_COSMOS_MEDICAL, @claims00_COSMOS_DRUG, 
	# note:   @claims00_NICE_MEDICAL, @claims00_NICE_DRUG or @claims00_NOT_NICE_OR_COSMOS
	# note: 
	#----------------------------------------------------------------------------------
    @claims00 @def1041 @thePredators
	Scenario Outline: DID: <DID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> -claimType: <claimType> - <index> - Perform detail validation for claims on both summary and detail page for each search range options
		Given login with following details logins in the member portal and validate elements
		  | Plan Type      | <planType>           |
		  | Member Type    | <memberType>         |
		  | Claim System   | <claimSystem>        |
		When I navigate to the claims Summary page from dashboard or testharness page
		Then I can validate the claims summary header on claims summary page
		  | Plan Type    | <planType>             |
		  | Member Type    | <memberType>         |
		#----------------- Test Custom search error cases --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type    | <memberType>          |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Custom search           |
		And I should be able to see the error message when no to and form dates being entered
		And I custom search claims for the following invalid time interval on claims summary page
		  | Plan Type        | <planType>          |
		  | Claims From Date | 01/02/2019          |
		  | Claims To Date   | 01/02/2018          |
		Then I should be able to see the from date is greater than the to date error message being displayed
		  | Plan Type        | <planType>          |
		And I custom search claims for over two years time interval from current date on claims summary page
		  | Plan Type        | <planType>          |
		Then I should be able to see the search range is greater than two years error
		  | Plan Type        | <planType>          |
		#----------------- Test for Custom search --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type    | <memberType>          |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Custom search           |
		And I custom search claims for the specific time interval on claims summary page
		  | Plan Type    | <planType>              |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Custom search           |
		#And I validate the pagination on the claims summary page for given range 
		#  | Claim Period | Custom search          |
		#Then I can validate the learn more and print and download option in claims details table for given range
		#  | Claim Period | Custom search          |
		#And I can validate the EOB section based on claims system on claims summary page
		#  | Plan Type    | <planType>             |
		#  | Claim System | <claimSystem>          |
		#And I can validates the DownloadMyData section on claims summary page
		#  | Plan Type    | <planType>             |
		#Then I validate Claim Details page content in detail for value and Learn More and EOB		  
	    #  | Plan Type    | <planType>             |
		#  | Claim Type   | <claimType>            |
		#  | Claim System | <claimSystem>          |
		#  | Claim Period | Custom search          |
		#----------------- Test for- Last 30 days --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 30 days            |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 30 days            |
		#And I validate the pagination on the claims summary page for given range 
		#  | Claim Period | Last 30 days            |
		#Then I can validate the learn more and print and download option in claims details table for given range
		#  | Claim Period | Last 30 days            |
		#Then I can validate claims table displayed based on the selection on claims summary page
		#  | Plan Type    | <planType>              |
		#  | Claim Type   | <claimType>             |
		#  | Claim System | <claimSystem>           |
		#  | Claim Period | Last 30 days            |
		#And I can validate the EOB section based on claims system on claims summary page
		#  | Plan Type    | <planType>              |
		#  | Claim System | <claimSystem>           |
		#And I can validates the DownloadMyData section on claims summary page
		#  | Plan Type    | <planType>              |
		#Then I validate Claim Details page content in detail for value and Learn More and EOB		  
	    #  | Plan Type    | <planType>              |
		#  | Claim Type   | <claimType>             |
		#  | Claim System | <claimSystem>           |
		#  | Claim Period | Last 30 days            |
		#----------------- Test for Last 90 days --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 90 days            |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 90 days            |
		#And I validate the pagination on the claims summary page for given range 
		#  | Claim Period | Last 90 days            |
		#Then I can validate the learn more and print and download option in claims details table for given range
		#  | Claim Period | Last 90 days            |
		#Then I can validate claims table displayed based on the selection on claims summary page
		#  | Plan Type    | <planType>              |
		#  | Claim Type   | <claimType>             |
		#  | Claim System | <claimSystem>           |
		#  | Claim Period | Last 90 days            |
		#And I can validate the EOB section based on claims system on claims summary page
		#  | Plan Type    | <planType>              |
		#  | Claim System | <claimSystem>           |
		#And I can validates the DownloadMyData section on claims summary page
		#  | Plan Type    | <planType>              |
		#Then I validate Claim Details page content in detail for value and Learn More and EOB		  
	    #  | Plan Type    | <planType>              |
		#  | Claim Type   | <claimType>             |
		#  | Claim System | <claimSystem>           |
		#  | Claim Period | Last 90 days            |
		#----------------- Test for Last 6 months --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 6 months           |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 6 months           |
		#And I validate the pagination on the claims summary page for given range 
		#  | Claim Period | Last 6 months           |
		#Then I can validate the learn more and print and download option in claims details table for given range
		#  | Claim Period | Last 6 months           |
		#Then I can validate claims table displayed based on the selection on claims summary page
		#  | Plan Type    | <planType>              |
		#  | Claim Type   | <claimType>             |
		#  | Claim System | <claimSystem>           |
		#  | Claim Period | Last 6 months           |
		#And I can validate the EOB section based on claims system on claims summary page
		#  | Plan Type    | <planType>              |
		#  | Claim System | <claimSystem>           |
		#And I can validates the DownloadMyData section on claims summary page
		#  | Plan Type    | <planType>              |
		#Then I validate Claim Details page content in detail for value and Learn More and EOB		  
	    #  | Plan Type    | <planType>              |
		#  | Claim Type   | <claimType>             |
		#  | Claim System | <claimSystem>           |
		#  | Claim Period | Last 6 months           |
		#----------------- Test for Last 12 months --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type  | <memberType>            |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 12 months          |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 12 months          |
		#And I validate the pagination on the claims summary page for given range 
		#  | Claim Period | Last 12 months          |
		#Then I can validate the learn more and print and download option in claims details table for given range
		#  | Claim Period | Last 12 months          |
		#Then I can validate claims table displayed based on the selection on claims summary page
		#  | Plan Type    | <planType>              |
		#  | Claim Type   | <claimType>             |
		#  | Claim System | <claimSystem>           |
		#  | Claim Period | Last 12 months          |
		#And I can validate the EOB section based on claims system on claims summary page
		#  | Plan Type    | <planType>              |
		#  | Claim System | <claimSystem>           |
		#And I can validates the DownloadMyData section on claims summary page
		#  | Plan Type    | <planType>              |
		#Then I validate Claim Details page content in detail for value and Learn More and EOB		  
	    #  | Plan Type    | <planType>              |
		#  | Claim Type   | <claimType>             |
		#  | Claim System | <claimSystem>           |
		#  | Claim Period | Last 12 months          |
		#----------------- Test for Last 24 months --------------------------
		And I can search claims for claim period and claim type on claim summary page
		  | Plan Type    | <planType>              |
		  | Member Type    | <memberType>   |
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 24 months          |
		Then I can see the number of claims
		  | Claim Type   | <claimType>             |
		  | Claim Period | Last 24 months          |
		And I validate the pagination on the claims summary page for given range 
		  | Claim Period | Last 24 months          |
		Then I can validate the learn more and print and download option in claims details table for given range
		  | Claim Period | Last 24 months          |
		Then I can validate claims table displayed based on the selection on claims summary page
		  | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimSystem>           |
		  | Claim Period | Last 24 months          |
		And I can validate the EOB section based on claims system on claims summary page
		  | Plan Type    | <planType>              |
		  | Claim System | <claimSystem>           |
		And I can validates the DownloadMyData section on claims summary page
		  | Plan Type    | <planType>              |
		Then I validate Claim Details page content in detail for value and Learn More and EOB		  
	      | Plan Type    | <planType>              |
		  | Claim Type   | <claimType>             |
		  | Claim System | <claimSystem>           |
		  | Claim Period | Last 24 months          |
		#----------------- Final Test claims number makes sense from search periods --------------
		And I can validate the numbers of claims from all search periods
		  | Flag Zero Claims User | <flagZeroClaimsUser> |
		  
	@claims00_01 @claims00_MAPD @claims00_COSMOS_MEDICAL @diffGrpsDiffYrs
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser | 
	  |01    |1041| MAPD     | diffGrpsDiffYrs_Individual | COSMOS_CLAIMS| Medical           | Yes                | 

	@claims00_02 @claims00_MAPD @claims00_COSMOS_DRUG @diffGrpsDiffYrs
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |02    |1041| MAPD     | diffGrpsDiffYrs_Individual | COSMOS_CLAIMS | Prescription drug| No                 |

	@claims00_03 @claims00_MA @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |03    |1041| MA       | Individual                 | COSMOS_CLAIMS| Medical           | Yes                |

	@claims00_04 @claims00_MA @claims00_NICE_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |04    |1041| MA       | Individual                 | NICE_CLAIMS  | Medical           | Yes                |

	@claims00_05 @claims00_MAPD @claims00_NICE_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |05    |1041| MAPD     | Individual                 | NICE_CLAIMS  | Medical           | Yes                |

	@claims00_06 @claims00_MAPD @claims00_NICE_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |06    |1041| MAPD     | Individual                 | NICE_CLAIMS  | Prescription drug | No                 |

	@claims00_07 @claims00_MAPD @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |07    |1041| MAPD     | Individual                 | COSMOS_CLAIMS| Medical           | Yes                |

	@claims00_08 @claims00_MAPD @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |08    |1041| MAPD     | Individual                 | COSMOS_CLAIMS| Prescription drug | No                 |

	@claims00_09 @claims00_PCP @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem  | claimType         | flagZeroClaimsUser |
	  |09    |1041| PCP      | Individual                 | COSMOS_CLAIMS| Medical           | Yes                |

	@claims00_10 @claims00_PCP @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem    | claimType         | flagZeroClaimsUser |
	  |10    |1041| PCP      | Individual                 | D_COSMOS_CLAIMS| Prescription drug | No                 |

	@claims00_11 @claims00_MEDICA @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |11    |1041| MEDICA   | Individual                 | COSMOS_CLAIMS | Medical           | Yes                |

	@claims00_12 @claims00_MEDICA @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |12    |1041| MEDICA   | Individual                 | COSMOS_CLAIMS | Prescription drug | Yes                |

	@claims00_13 @claims00_PDP @claims00_RX @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |13    |1041| PDP      | Individual                 | RX_CLAIMS     | Prescription drug | Yes                |

	@claims00_14 @claims00_SHIP @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |14    |1041| SHIP     | Individual                 | COMPASS_CLAIMS| NA                | Yes                |

	@claims00_15 @claims00_COMBO @claims00_GROUP @claims00_PDP @claims00_NOT_NICE_OR_COSMOS @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |15    |1041| PDP      | COMBO_GROUP                | RX_CLAIMS     | Prescription drug | No                 |

	@claims00_16 @claims00_COMBO @claims00_GROUP @claims00_SSUP @claims00_COSMOS @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |16    |1041| SSUP     | COMBO_GROUP                | COSMOS_CLAIMS | Medical           | Yes                |

	@claims00_17 @claims00_COMBO @claims00_SHIP @claims00_NOT_NICE_OR_COSMOS
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |17    |1041| SHIP     | COMBO                      | COMPASS_CLAIMS| NA                | Yes                |

	@claims00_18 @claims00_GROUP @claims00_MAPD @claims00_COSMOS_MEDICAL
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |18    |1041| MAPD     | GROUP                      | COSMOS_CLAIMS | Medical           | Yes                |

	@claims00_19 @claims00_GROUP @claims00_MAPD @claims00_COSMOS_DRUG
	Examples: 
	  |index |DID | planType | memberType                 | claimSystem   | claimType         | flagZeroClaimsUser |
	  |19    |1041| MAPD     | GROUP                      | COSMOS_CLAIMS | Prescription drug | No                 |

	#note: covered by COMBO case unless locate user data with claims for SSUP only user
	#@claims00_20 @claims00_SSUP @claims00_COSMOS_MEDICAL
	#Examples: 
	#  |index |DID | planType | memberType                | claimSystem   | claimType         | flagZeroClaimsUser |
	#  |20    |1041| SSUP     | EOB_Deeplink_Individual   | COSMOS_CLAIMS | Medical           | Yes                |

    #note: these will be in team-a env only
	#  |xx    |1041| MAPD     | t_diffGrpsDiffYrs_Individual | COSMOS_CLAIMS | Medical           | No                |
	#  |xx    |1041| MAPD     | t_diffGrpsDiffYrs_Individual | COSMOS_CLAIMS | Prescription drug | No                |
	#----- end of claims00 ---------------------------------------------------------

	
	#---- this the test EOB link on claims details page
    @claims15 @claimsEOB @US1268210 @F244667 @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - to validate the claims eob link on claims detail page
    Given login with following details logins in the member portal and validate elements
          | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
          | Claim System   | <claimSystem>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    And I can search claims for the following claim period on claims summary page
          | Plan Type    | <planType>    |
          | Claim Period | <claimPeriod> |
    Then I can see the claims displayed based on the selection on claims summary page
    When I navigate to the Claim details page to see eob link on details page
    Then I can validate the view as pdf link on claims details page header
          | Plan Type    | <planType>    |
		  | Claim System | <claimSystem> |

    Examples: 
          | FID    | planType | memberType     | claimPeriod    | claimSystem  |
          | 244667 | MA       | EOB_Individual | Last 24 months | NICE_CLAIMS  |

    #---- this test check that sub-navigation to EOB page under Claims tab is suppressed for SSUP Only Plan member
    @claims16 @US1662790 @F267688 @claimsEOB_SSUP_Plan @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - to validate that sub-navigation to EOB page under Claims tab is suppressed for SSUP Only Plan member
    Given login with following details logins in the member portal and validate elements
          | Plan Type      | <planType>     |
 		  | Member Type    | <memberType>   |
          | Claim System   | <claimSystem>  |
	When I navigate to the claims Summary page from dashboard or testharness page
    Then Explanation of benefits sub navigation under Claims tab is not displayed

    Examples: 
          | FID    | planType | memberType              | claimSystem   |
          | 267688 | SSUP     | EOB_Deeplink_Individual | COSMOS_CLAIMS |
      
    @claims17 @US1673123 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - to validate that SSUP member accessing EOB page via deep link
    Given login with following details logins in the member portal and validate elements
          | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
          | Claim System   | <claimSystem>  |
    When I navigate to the claims Summary page from dashboard or testharness page
    Then Explanation of benefits sub navigation under Claims tab is not displayed
    Then Explanation of benefits deep link is invoked and validate the Page
    Examples: 
          | FID    | planType | memberType              | claimSystem   |
          | 267688 | SSUP     | EOB_Deeplink_Individual | COSMOS_CLAIMS |
      
    @claims18 @US1673112 @F267688_Test @claimsEOB_SSUP_Plan @regressionMember
    Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - to validate that SSUP member accessing EOB page via deep link
    Given login with following details logins in the member portal and validate elements
          | Plan Type      | <planType>     |
		  | Member Type    | <memberType>   |
          | Claim System   | <claimSystem>  |
	When I navigate to the claims Summary page from dashboard or testharness page
    Then Validate Explanation of benefits Page for group SSUP
    Examples: 
          | FID    | planType | memberType | claimSystem   |
          | 267688 | SSUP     | EOB_GROUP  | COSMOS_CLAIMS |
      
      
    @E2EClaimstcase
    Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the claims present for the Federal member on claims summary page for federal members
	Given login with following details logins in the member portal and validate elements
         | Plan Type      | <planType>     |
	     | Member Type    | <memberType>   |
         | Claim System   | <claimSystem>  |
	When I navigate to the claims Summary page from dashboard or testharness page
	Then I can validate the claims summary header on claims summary page
	     | Plan Type      | <planType>     |
	     | Member Type    | <memberType>   |
	And I can search claims for the following claim period on claims summary page
	     | Plan Type    | <planType>    |
	     | Claim Period | <claimPeriod> |
	Then I can see the claims displayed based on the selection on claims summary page
	And I validate the pagination on the claims summary page 
	And I can see the learn more and print and download option on claims summary table section 
	And I validate the EOB section based on claims system on claims summary page
	     | Plan Type    | <planType>    |
	     | Claim System | <claimSystem> |
	And I validate the DownloadMyData section on claims summary page
	Then I navigate to the Claim Details page from claims summary page
	     | Plan Type  | <planType>    |
	And I validate the Claims Total on claims details page
	     | Plan Type  | <planType>    |
	And I validate the claims summary link on claims detail bottom page
	     | Plan Type  | <planType>    |
	Then I navigate to the Claim Details page from claims summary page
	     | Plan Type  | <planType>    |
	And I validate the claims summary link on claims detail top page
	     | Plan Type  | <planType>    |
	Then I validate Claim Details page content value and Learn More and EOB		  
	     | Plan Type    | <planType>  |
	     | Claim Type   | <claimType> |
	  
	   Examples:   
	     | TID   | planType | memberType | claimPeriod    | claimSystem   | 
	     | 15230 | MAPD     | Individual | Last 24 months | COSMOS_CLAIMS |
	     | 15235 | MA       | Individual | Last 24 months | NICE_CLAIMS   | 
	     | 15299 | PDP      | Individual | Last 24 months | RX_CLAIMS     | 
	     | 15268 | PCP      | Individual | Last 24 months | COSMOS_CLAIMS | 

		     
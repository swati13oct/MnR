@campaignExternalLinksNewLPM
Feature: 1.11 UAT Scripts Campaign External Links scenario 11 related to New Medicare Plans page

  @Scenario11 
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via New Landing pages
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    Then user clicks on privacy policy link
    Then user clicks on accessibility link
	  Then user validates Current location and change location
      | zipcodeSingle  | <zipcodeSingle> |
      | zipcodeMulti   | <zipcodeMulti>  |
	 
	 @CampaignExternal_Scenario11_AARP
    Examples:
      | Scenario                                       | zipcodeMulti |zipcodeSingle| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | externallink |
      | Campaign External Links - E2E Scenario 11_AMP |   65656      |33111        |Yes            | Stone County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] |  https://www.aarpmedicareplans.com/lp/medicare-plans.html   |  
	
#	@Scenario11 
  #Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via New Landing pages
    #Given user is on campaign external Links page
      #| External Link | <externallink> |
    #Then user verify TFN on AARP external links page
      #| TFN No      | <TFNNo>      |
      #| TFN Xpath   | <TFNxpath1>  |
      #| Working hrs | <workingHrs> |
#	Then user validates zipcode component and navigates to VPP
#	Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #And the user views the plans of the below plan type
      #| Plan Type | <MAplantype> |
     #And the user selects plan year
    #	|Plan Year	| <planyear>|
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    #Then the user view plan details of the above selected plan in site vpp
      #| Plan Name | <MAplanName> |
      #| Plan Type | <MAplantype> |
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail Plan Details page
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    #When user clicks on Add to compare checkbox on plan detail page
    #And the user clicks on back to all plans link and validates its redirection to Plan Summary
    #Then verify the Add to compare checkbox is checked for selected plan
      #| Plan index | <planIndex> |
    #When user select "<planIndex1>" plans to compare
    #And user clicks on compare button
    #Then verify plan compare page is loaded
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail
    #| TFN No    | <TFNNo>     |
    #| TFN Xpath | <TFNxpath3> |
    #Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail OLE page
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath4> |
    #Then the user navigates to Personal Information Page
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail OLE page
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath4> |
    #Then the user validates cancellation and Save Return Later modal for OLE Page
    #Then the user cancels enrollment and navigates to homepage
    #Then user closes current tab and navigate to previous tab
    #----------Repeat the steps for PDP Plan-----------------#
    #Then the user validate aarp medicare plans11 page external link
      #| Zip Code | <zipcode> |
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Zipcode component
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    #And the user views the plans of the below plan type
      #| Plan Type | <PDPplantype> |
     #And the user selects plan year
    #	|Plan Year	| <planyear>|
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    #Then the user view plan details of the above selected plan in site vpp
      #| Plan Name | <PDPplanName> |
      #| Plan Type | <PDPplantype> |
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail Plan Details page
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    #When user clicks on Add to compare checkbox on plan detail page
    #And the user clicks on back to all plans link and validates its redirection to Plan Summary
    #Then verify the Add to compare checkbox is checked for selected plan
      #| Plan index | <planIndex> |
    #When user select "<planIndex1>" plans to compare
    #And user clicks on compare button
    #Then verify plan compare page is loaded
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
     #Then the user validates TFN Number on Right Rail
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    #Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail OLE page
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath4> |
    #Then the user navigates to Personal Information Page
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail OLE page
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath4> |
    #Then user closes current tab and navigate to previous tab
    #----------Repeat the steps for SNP Plan-----------------#
    #Then user validates zipcode component and navigates to VPP
      #| Zip Code | <zipcode> |
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Zipcode component
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    #And the user views the plans of the below plan type
      #| Plan Type | <SNPplantype> |
     #And the user selects plan year
    #	|Plan Year	| <planyear>|
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    #Then the user view plan details of the above selected plan in site vpp
      #| Plan Name | <SNPplanName> |
      #| Plan Type | <SNPplantype> |
    #Then the user validates TFN Number on Right Rail Plan Details page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user navigates to clicks on Enroll Now from Plan details page to start the OLE flow
      #| Plan Type | <SNPplantype> |
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on SNP Right Rail OLE page
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath4> |
    #Then the user navigates to Personal Information Page
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on SNP Right Rail OLE page
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath4> |
     #Then the user validates cancellation and Save Return Later modal for OLE Page
    #Then user closes current tab and navigate to previous tab
    #-------------------Repeat the steps for Medsupp Plan----------------------------------------------
    #Then the user validate aarp medicare plans11 page external link
      #| Zip Code | <zipcode> |
    #Then the user validates SAM icons on the page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Zipcode component
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    #And the user views the plans of the below plan type
      #| Plan Type | <MSplantype> |
    #And the user selects plan year
      #| Plan Year | <planyear> |
    #Then the user validates SAM icons on Medsupp page
      #| TFN No    | <TFNNo>    |
      #| TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number on Right Rail for Medsupp page
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath2> |
    #Then user closes current tab and navigate to previous tab
#
   #
    #@CampaignExternalLink_E2E_Scenario_11_AARP
    #Examples: 
      #| Scenario                              | site | PlanType | externallink                                              | planyear | planYear | zipcode | isMultutiCounty | county            | MAplantype | planyear | MAplanName                        | cardtype | TFNNo          | TFNxpath                                                                                   | TFNxpath1                                          | PDPplantype | SNPplantype | MSplantype | PDPplanName                     | SNPplanName                                       | TFNxpath2                         | TFNxpath3                         | planIndex | planIndex1 | TFNxpath4                         | 
      #| E2E Scenario 11_aarp-medicare-plans | AARP | MAPD-MBI | https://www.aarpmedicareplans.com/lp/medicare-plans.html | future   | future   |   33111 | NO              | Miami-Dade County | MAPD       | future   | AARP Medicare Advantage Choice (PPO) | MBI      | 1-855-264-3792 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | (//a[contains(@class,'tel tfn desktop')])[1]| PDP         | SNP         | MS         | AARP MedicareRx Walgreens (PDP) | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[1] |         1 |          2 | (//a[contains(@class, 'tel')])[3] | 

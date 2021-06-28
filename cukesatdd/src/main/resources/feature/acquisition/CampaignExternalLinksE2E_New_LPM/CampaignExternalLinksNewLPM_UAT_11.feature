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
	 
	 @CampaignExternal_Scenario11_AARP   @StageLP
    Examples:
      | Scenario                                       | zipcodeMulti |zipcodeSingle| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | externallink |
      | Campaign External Links - E2E Scenario 11_AMP |   65656      |33111        |Yes            | Stone County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] |  https://www.stage-aarpmedicareplans.uhc.com/lp/medicare-plans.html   |  
	
	@CampaignExternal_Scenario11_AARP    @OfflineLP
    Examples:
      | Scenario                                       | zipcodeMulti |zipcodeSingle| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | externallink |
      | Campaign External Links - E2E Scenario 11_AMP |   65656      |33111        |Yes            | Stone County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] |  https://offline.aarpmedicareplans.com/lp/medicare-plans.html   |  
	
	@CampaignExternal_Scenario11_AARP    @ProdLP
    Examples:
      | Scenario                                       | zipcodeMulti |zipcodeSingle| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | externallink |
      | Campaign External Links - E2E Scenario 11_AMP |   65656      |33111        |Yes            | Stone County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] |  https://www.aarpmedicareplans.com/lp/medicare-plans.html   |  
	
	@Scenario11 
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via New Landing pages
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
	Then user validates zipcode component and navigates to VPP
	Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
  And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |
   Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <planname> |
      | Plan Type | <plantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user validates TFN Number on Right Rail Plan Details page
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "2" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
      Then the user validates TFN Number on Right Rail OLE page
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab
    #PDP Plan#
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    Then user validates zipcode component and navigates to VPP
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user validates TFN Number on Right Rail
    And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <PDPplanname> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail Plan Details page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    And user closes current tab and navigate to previous tab
    #Med Sup Plan#
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    Then user validates zipcode component and navigates to VPP
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <Medsupplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates SAM icons on Medsupp page from External page
      | TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail for Medsupp page
      | TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath5> |
    And user closes current tab and navigate to previous tab
    #Find Plans in your Area and SNP plantype*****#
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
   Then user validates zipcode component and navigates to VPP
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <SNPPlanName> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans> |
    And Navigate to Visitor Profile page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
   
   
    @CampaignExternalLink_E2E_Scenario_11_AARP    @StageLP
    Examples: 
      | Scenario                       | site | PlanType | externallink                                                       | PSC code| zipcode | isMultutiCounty | county            | MAplantype | planyear | MAplanName                        | cardtype | TFNNo          | TFNxpath                                                                                    | TFNxpath1                                    | PDPplantype | SNPplantype | MSplantype | PDPplanName                     | SNPplanName                                       | TFNxpath2                         | TFNxpath3                         | planIndex | planIndex1 | TFNxpath4                         | 
      | E2E Scenario 11_medicare-plans | AARP | MAPD-MBI | https://www.stage-aarpmedicareplans.uhc.com/lp/medicare-plans.html | 8012869 |  33111 | NO              | Miami-Dade County | MAPD       | future   | AARP Medicare Advantage Choice (PPO) | MBI      | 1-855-264-3792 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')]| (//a[contains(@class,'tel tfn desktop')])[1]| PDP         | SNP         | MS         | AARP MedicareRx Walgreens (PDP) | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[1] |         1 |          2 | (//a[contains(@class, 'tel')])[3] | 

    @CampaignExternalLink_E2E_Scenario_11_AARP    @OfflineLP  
    Examples: 
      | Scenario                       | site | PlanType | externallink                                                 | PSC code| zipcode | isMultutiCounty | county            | MAplantype | planyear | MAplanName                        | cardtype | TFNNo          | TFNxpath                                                                                    | TFNxpath1                                    | PDPplantype | SNPplantype | MSplantype | PDPplanName                     | SNPplanName                                       | TFNxpath2                         | TFNxpath3                         | planIndex | planIndex1 | TFNxpath4                         | 
      | E2E Scenario 11_medicare-plans | AARP | MAPD-MBI | https://offline.aarpmedicareplans.com/lp/medicare-plans.html | 8012869 |  33111 | NO              | Miami-Dade County | MAPD       | future   | AARP Medicare Advantage Choice (PPO) | MBI      | 1-855-264-3792 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')]| (//a[contains(@class,'tel tfn desktop')])[1]| PDP         | SNP         | MS         | AARP MedicareRx Walgreens (PDP) | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[1] |         1 |          2 | (//a[contains(@class, 'tel')])[3] | 
     
    @CampaignExternalLink_E2E_Scenario_11_AARP    @ProdLP  
    Examples: 
      | Scenario                       | site | PlanType | externallink                                             | PSC code| zipcode | isMultutiCounty | county            | MAplantype | planyear | MAplanName                        | cardtype | TFNNo          | TFNxpath                                                                                    | TFNxpath1                                    | PDPplantype | SNPplantype | MSplantype | PDPplanName                     | SNPplanName                                       | TFNxpath2                         | TFNxpath3                         | planIndex | planIndex1 | TFNxpath4                         | 
      | E2E Scenario 11_medicare-plans | AARP | MAPD-MBI | https://www.aarpmedicareplans.com/lp/medicare-plans.html | 8012869 |  33111 | NO              | Miami-Dade County | MAPD       | future   | AARP Medicare Advantage Choice (PPO) | MBI      | 1-855-264-3792 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')]| (//a[contains(@class,'tel tfn desktop')])[1]| PDP         | SNP         | MS         | AARP MedicareRx Walgreens (PDP) | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[1] |         1 |          2 | (//a[contains(@class, 'tel')])[3] | 
       
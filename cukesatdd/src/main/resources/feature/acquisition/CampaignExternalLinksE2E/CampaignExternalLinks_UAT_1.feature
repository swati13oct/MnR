Feature: 1.05.5. UAT Scripts Campaign External Links scenario 1 related to AMP_UMS_English

  
	@Scenario1
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links
    Given user is on campaign external Links page
      | External Link | <externallink> |
     Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
 When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <planname> |
      | Plan Type | <plantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
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
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
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
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
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
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab
    #Med Sup Plan#
   Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
	And the user views the plans of the below plan type
      | Plan Type | <Medsupplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    #And the user validates SAM icons on Medsupp page
    	#| TFN No    | <TFNNo1>     |
      #| TFN Xpath | <TFNxpath2> |
    #Then the user validates TFN Number on Right Rail
     # | TFN No    | <TFNNo1>     |
      #| TFN Xpath | <TFNxpath2> |
    And user closes current tab and navigate to previous tab
    #Find Plans in your Area and SNP plantype*****#
    When user clicks on Find Plans in your area to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
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
    And user closes current tab and navigate to previous tab
    #DCE###
   Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Estimate Your Prescription Drug Costs from external page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user should be able to see Medicare Advantage plan by default
    #And user should be able to toggle between plan types
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page
    And user closes current tab and navigate to previous tab
    #PRE Flow##
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Start Now to get start the PRE flow from external page
    And clicks on get started button and runs a questionnaire
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
 And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |

   @CampaignExternal_Scenario1_AARP
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultutiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode |TFNNo1|pscCode|
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | No              | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 |1-866-408-5545|8012869|

    @CampaignExternal_Scenario1_UHC
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultutiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode |
      | Campaign External Links - E2E Scenario 1_UMS_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | No              | Miami-Dade County | MAPD       | 1-877-801-0043 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[2] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 |

  
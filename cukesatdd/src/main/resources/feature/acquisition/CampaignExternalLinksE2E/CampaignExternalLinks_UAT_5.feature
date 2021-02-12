Feature: 1.05.5. UAT Scripts Campaign External Links Scenario 5 related to morganstanley

  
	 Scenario Outline: <Scenario>: Validate TFN and SAM Call popup in MA, Medsupp page, PRE, VPP Plan Summary from External link: <externallink>
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on morganstanley external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #-------------------Learn About Medicare from Morgan Stanley page------------------
    Then the user clicks on Learn About Medicare button on Morgan Stanley external link page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number in Still have Questions section at bottom of page
      | TFN Xpath | <TFNxpath3> |
    #Then the user validates TFN Number on Right Rail
    #| TFN No    | <TFNNo>     |
    #| TFN Xpath | <TFNxpath3> |
    And the user clicks on Medicare Education Supplement Insurance Plans Link
    And the user validates SAM icons on Medsupp page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number in Still have Questions section at bottom of Medsupp page
      | TFN Xpath | <TFNxpath4> |
    And the user closes the new browser tab
    #--------------------PRE from Morgan Stanley page---------------------------
    Then the user clicks on Get Help Finding a Plan button on Morgan Stanley external link page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
   	And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And the user closes the new browser tab
    #---------------------VPP from Morgan Stanley page-------------------

    @Scenario5_AARP
    Examples: 
      | Scenario                      | externallink                             | TFNNo          | TFNxpath1                                     | TFNxpath2                                                                                          | TFNxpath3                         |	TFNxpath4													|	pscCode	|	Zipcode	|	isMultiCounty	|	county						|	isCoverageOpt	|
      | E2E Scenario 5_ morganstanley | https://www.myuhcplans.com/morganstanley | 1-877-755-5345 | //a[contains(@class,'js-tel js-track-event')] | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | (//a[contains(@class, 'tel')])[1] |	(//a[contains(@class, 'tel')])[2]	|	8002977	|	65656		|	YES						|	Christian County	|	PDP						|
	  
#File Name: VPP-EmailAndPrint-Common.feature
#@vppUlayer @emailAndPrint @emailAndPrint_AARP
Feature: 1.04 -ACQ-Print and email on VPP page

  
  Scenario Outline: TID: <TID> -plantype: <plantype> - Verify print and email for plan compare page in <site> site.
  Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    	  When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
  	And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
    Then user saves first plan on plan summary page on site
    Then I select multiple plans to compare for selected plan and click on compare plan link on the site
      | plan type | <plantype> |
    Then the user validate the print link option in plan compare on site
    Then the user validates the functionality of print button on the plan compare Page on site
    Then the user validate the email link option in plan compare on site
    Then the user validate thank you message in plan compare for selected plan on site
    Then I click back to all plans button and verify that all plans are still selected on summary page on site
   # Then user loads page using email deeplink and validate vpp compare page content on site

    @VppEmailandPrintCommon_AARP_1 @regressionAARP @regressionAARP 
    Examples: 
      | TID   | site | zipcode | plantype | isMultiCounty | planyear 	|
      | 15523 | AARP |   90210 | MA       | NO            | next	  	|

    @VppEmailandPrintCommon_UHC_1
    Examples: 
      | TID   | site | zipcode | plantype | isMultiCounty | planyear	|
      | 15523 | UHC  |   90210 | MA       | NO            | next		  |

    @prodRegression_AARP @VppEmailandPrintCommon_AARP_1 @regressionAARP @regressionAARP @VppEmailandPrintProdSanity_AARP
    Examples: 
      | TID   | site | zipcode | plantype | isMultiCounty | planyear |
      | 15523 | AARP |   90210 | PDP      | NO            | next		 |

    @prodRegression_UHC @VppEmailandPrintCommon_UHC_1 @VppEmailandPrintProdSanity_UHC
    Examples: 
      | TID   | site | zipcode | plantype | isMultiCounty | planyear |
      | 15523 | UHC  |   90210 | PDP      | NO            | next		 |

  #@emailAndPrint_AARP2 @emailAndPrintplanDetails @predators @decRelease2018 @RegressionPredators @emailAndPrint_UHC2 @emailAndPrintplanDetails @predatorsdecrelease2018 @RegressionPredators
  Scenario Outline: TID: <TID> -plantype: <plantype> - Verify email and Print plan functionalities on Plan Details page in AARP site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user view plan details of the first plan in the given plan type and perform validation on site
    Then the user validate the print link on the plan Details Page on site
    Then the user validates the functionality of print button on the plan Details Page on site
    Then the user validate the email link on the plan Details Page on site
    Then the user validates the functionality of email button on the plan Details Page on site
    #Then user loads page using email deeplink and validate vpp detail page content on site

    @VppEmailandPrintCommon_AARP_2
    Examples: 
      | TID   | site | zipcode | plantype | isMultutiCounty | planyear |
      | 15531 | AARP |   80001 | MA       | No              | future  |
      | 15531 | AARP |   80001 | PDP      | No              | future  |

    @VppEmailandPrintCommon_UHC_2 
    Examples: 
      | TID   | site | zipcode | plantype | isMultutiCounty | planyear |
      | 15531 | UHC  |   80001 | MA       | No              | future  |
      | 15531 | UHC  |   80001 | PDP      | No              | future  |

    @prodRegression_AARP @VppEmailandPrintCommon_AARP_2 @VppEmailandPrintProdSanity_AARP
    Examples: 
      | TID   | site | zipcode | plantype | isMultutiCounty | planyear |
      | 15531 | AARP |   80001 | SNP      | No              | future  |

    @prodRegression_UHC @VppEmailandPrintCommon_UHC_2 @VppEmailandPrintProdSanity_UHC
    Examples: 
      | TID   | site | zipcode | plantype | isMultutiCounty | planyear |
      | 15531 | UHC  |   80001 | SNP      | No              | future  |

  # @emailAndPrint_AARP3 @emailAndPrintplanSummary @feature-F265872 @us1598166 @vppEmailRegression @vppFavoritePlanEmailAarp @predators @Apr_release_2019 @emailAndPrint_UHC3 @emailAndPrintplanSummary @feature-F265872 @us1598166 @vppEmailRegression @vppFavoritePlanEmailUhc @predators @Apr_release_2019
  Scenario Outline: UID: <UID> -plantype: <plantype> - Verify user can invoke the email button and the print button on view plan preview page on AARP site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user saves first plan on plan summary page on site
    Then user validates print option for selected plan on plan summary page on site
    #  | Plan Type | <plantype> |
    Then user validates print functionality for selected plan on plan summary page on site
    Then user validates email option for selected plan on plan summary page on site
    Then user validates email functionality with invalid and valid email address for selected plan on plan summary page on site
    #Then user loads page using email deeplink for plan and validate vpp summary page content on site

    @VppEmailandPrintCommon_AARP_3
    Examples: 
      | UID     | site | plantype | zipcode | isMultiCounty | county           | planyear |
      | 1598166 | AARP | PDP      |   80001 | NO            | Jefferson County | future  |
      | 1598166 | AARP | SNP      |   80001 | NO            | Jefferson County | future  |

    @VppEmailandPrintCommon_UHC_3
    Examples: 
      | UID     | site | plantype | zipcode | isMultiCounty | county           | planyear |
      | 1598166 | UHC  | PDP      |   80001 | NO            | Jefferson County | future  |
      | 1598166 | UHC  | SNP      |   80001 | NO            | Jefferson County | future  |

    @prodRegression_AARP @VppEmailandPrintCommon_AARP_3 @VppEmailandPrintProdSanity_AARP
    Examples: 
      | UID     | site | plantype | zipcode | isMultiCounty | county           | planyear |
      | 1598166 | AARP | MA       |   80001 | NO            | Jefferson County | future  |

    @prodRegression_UHC @VppEmailandPrintCommon_UHC_3 @VppEmailandPrintProdSanity_UHC
    Examples: 
      | UID     | site | plantype | zipcode | isMultiCounty | county           | planyear |
      | 1598166 | AARP | MA       |   80001 | NO            | Jefferson County | future  |

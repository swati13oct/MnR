#@SiteSearchResultsAARP @F294024
Feature: 1.03 Acq-To test Sitesearch results site

  #@SiteSearchAARP @SiteSearchRegressionAARP @vbfGate @SiteSearchUHC  @SiteSearchRegressionUHC
  Scenario Outline: Verify search results in <site> site -search value -<newsearchvalue>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user enter the searchvalue in the search text box and hits enter
      | search Value | <searchValue> |
    Then the user should see fifteen results before the pagination
    #Then the user validates count of results aganist the total shown at top of the page
    Then the user validates pagination and results displayed on page
    Then the user validates the secondary search by providing new searchvalue in the text box
      | NewSearchValue | <newsearchvalue> |
    Then the user validates pagination and results displayed on page

    @SiteSearchCommon_AARP
    Examples: 
      | site | searchValue | newsearchvalue |
      | AARP | Medicare    | pharmacy       |

    @SiteSearchCommon_UHC
    Examples: 
      | site | searchValue | newsearchvalue |
      | UHC  | Medicare    | pharmacy       |

  #@SiteSearchAARPErrorHandling @SiteSearchRegressionAARP @SiteSearchResultsVPPBlayer    @SiteSearchRegressionUHC
  Scenario Outline: Verify search results in <site> site - search value -<NewSearchValue>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user enter the searchvalue in the search text box and hits enter
      | search Value | <searchValue> |
    Then the user clear secondary search box and insert new searchvalue
      | New Search Value | <NewSearchValue> |
    Then the user validates Error message on page
      | Error          | <Error>          |
      | NewSearchValue | <NewSearchValue> |

    @SiteSearchCommon_AARP
    Examples: 
      | site | searchValue | Error            | NewSearchValue |
      | AARP | Medicare    | Empty            |                |
      | AARP | Medicare    | InvalidCharacter | medicareeee    |

    @SiteSearchCommon_UHC
    Examples: 
      | site | searchValue | Error            | NewSearchValue |
      | UHC  | Medicare    | Empty            |                |
      | UHC  | Medicare    | InvalidCharacter | medicareeee    |

  #@SiteSearchResultsVPPUlayer  @SiteSearchRegressionAARP @vbfGate @SiteSearchErrorHandlingUHC  @SiteSearchRegressionUHC @vbfGate
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify specific Additional Benefits in Plan Details for provided plan on <site> site
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
    #    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user enter the searchvalue in the search text box and hits enter
      | search Value | <searchValue> |
    Then the user should see fifteen results before the pagination
    #Then the user validates count of results aganist the total shown at top of the page
    Then the user validates pagination and results displayed on page
    Then the user validates the secondary search by providing new searchvalue in the text box
      | NewSearchValue | <newsearchvalue> |
    Then the user validates pagination and results displayed on page

    @SiteSearchCommon_AARP
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county      | plantype | planName                                    | searchValue | newsearchvalue |
      | 15652 | AARP |   19019 | No              | Iowa County | MAPD     | AARP Medicare Advantage Choice Plan 1 (PPO) | Medicare    | pharmacy       |

    @SiteSearchCommon_UHC
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county      | plantype | planName                                    | searchValue | newsearchvalue |
      | 15652 | UHC  |   19019 | No              | Iowa County | MAPD     | AARP Medicare Advantage Choice Plan 1 (PPO) | Medicare    | pharmacy       |

  #@SiteSearchResultsDCEUlayer  @SiteSearchRegressionAARP
  #Scenario Outline: 1.10.11 To verify search results in DCE Ulayer page
  #Given the user is on the AARP medicare site landing page
  #When I access the acquisition DCE tool from home page
  #Then the user enter the searchValue in the search text box and hits enter
  #|search Value|<searchValue>|
  #Then the user should see fifteen results before pagination
  #Then the user validates count of results aganist the total shown at top of the page
  #Then the user validates pagination and results displayed
  #Then the user validates the secondary search by providing newsearchvalue in the text box
  #|NewSearchValue|<newsearchvalue>|
  #Then the user validates pagination and results displayed
  #Examples:
  #| searchValue |newsearchvalue|
  #| Medicare    |pharmacy|
  #
  # @SiteSearchResultsPharmacyLocatorUlayer @SiteSearchRegressionAARP @SearchResultsPharmacyLocatorBlayer    @SiteSearchRegressionUHC
  Scenario Outline: To verify search results in pharmacy locator on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user enter the searchvalue in the search text box and hits enter
      | search Value | <searchValue> |
    Then the user should see fifteen results before the pagination
    #Then the user validates count of results aganist the total shown at top of the page
    Then the user validates pagination and results displayed on page
    Then the user validates the secondary search by providing new searchvalue in the text box
      | NewSearchValue | <newsearchvalue> |
    Then the user validates pagination and results displayed on page

    @SiteSearchCommon_AARP
    Examples: 
      | site | searchValue | newsearchvalue |
      | AARP | Medicare    | pharmacy       |

    @SiteSearchCommon_UHC
    Examples: 
      | site | searchValue | newsearchvalue |
      | UHC  | Medicare    | pharmacy       |

    @SiteSearchAutoComplete  
    Scenario Outline: To verify site search auto complete suggestions in <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user enter the searchValue in the search text box
      | search Value | <searchValue> |
    Then the user should see the auto complete suggestions
    Then the user clicks on the first auto complete suggestion
    Then the user validates pagination and results displayed
    Then the user enter the secondary searchValue in the search text box
        |NewSearchValue|<newsearchvalue>|
    Then the user should see the auto complete suggestions site search page
     Then the user clicks on the first auto complete suggestion site search page
    Then the user validates pagination and results displayed

    @SiteSearchAutoComplete_AARP
    Examples: 
      | site | searchValue | newsearchvalue |
      | AARP | Medicare    | plans    |

    @SiteSearchAutoComplete_UHC
    Examples: 
      | site | searchValue | newsearchvalue |
      | UHC  | Medicare    | plans       |
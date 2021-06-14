@SiteSearchResultsAARP @F448210
Feature: 1.03 Acq-To test Sitesearch results in AMP site

  @SiteSearchAARP @SiteSearchRegressionAARP @Sitesearchhome
  Scenario Outline: Verify search results in AARP site -search value -<newsearchvalue>
    Given the user is on AARP medicare acquisition site landing page
    Then the user enter the searchValue in the search text box and hits enter
      | search Value | <searchValue> |
    Then the user should see fifteen results before pagination
    Then the user validates count of results aganist the total shown at top of the page
    Then the user validates pagination and results displayed
    Then the user validates the secondary search by providing newsearchvalue in the text box
      | NewSearchValue | <newsearchvalue> |
    Then the user validates pagination and results displayed

    Examples: 
      | searchValue     | newsearchvalue                  |
      | Medicare        | pharmacy                        |
      | Medicare        | MEDICARE PART D CLAIM FORM(PDF) |
      | Dental coverage | Drug cost estimator             |

  @SiteSearchAARPErrorHandling @SiteSearchRegressionAARP
  Scenario Outline: Verify search results in AARP site - search value -<NewSearchValue>
    Given the user is on AARP medicare acquisition site landing page
    Then the user enter the searchValue in the search text box and hits enter
      | search Value | <searchValue> |
    Then the user clear secondary search box and insert new search value
      | New Search Value | <NewSearchValue> |
    Then the user validates Error message
      | Error          | <Error>          |
      | NewSearchValue | <NewSearchValue> |

    Examples: 
      | searchValue | Error            | NewSearchValue                                                              |
      | Medicare    | Empty            | [blank]                                                                     |
      | Medicare    | InvalidCharacter | medicareeee                                                                 |
      | Medicare    | InvalidCharacter | ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj |
      | Medicare    | InvalidCharacter | Unicorn                                                                     |

  @SiteSearchResultsVPPUlayer @SiteSearchRegressionAARP
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify specific Additional Benefits in Plan Details for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user enter the searchValue in the search text box and hits enter
      | search Value | <searchValue> |
    Then the user should see fifteen results before pagination
    #Then the user validates count of results aganist the total shown at top of the page
    Then the user validates pagination and results displayed
    Then the user validates the secondary search by providing newsearchvalue in the text box
      | NewSearchValue | <newsearchvalue> |
    Then the user validates pagination and results displayed

    Examples: 
      | TID   | zipcode | isMultutiCounty | county      | plantype | planName                                    | searchValue | newsearchvalue |
      | 15652 |   19019 | No              | Iowa County | MAPD     | AARP Medicare Advantage Choice Plan 1 (PPO) | Medicare    | pharmacy       |

  @SiteSearchResultsDCEUlayer @SiteSearchRegressionAARP
  Scenario Outline: 1.10.11 To verify search results in DCE Ulayer page
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user enter the searchValue in the search text box and hits enter
      | search Value | <searchValue> |
    #Then the user should see fifteen results before pagination
    #Then the user validates count of results aganist the total shown at top of the page
    #Then the user validates pagination and results displayed
    Then the user validates the secondary search by providing newsearchvalue in the text box
      | NewSearchValue | <newsearchvalue> |

    #Then the user validates pagination and results displayed
    Examples: 
      | searchValue | NewSearchValue |
      | Medicare    | pharmacy       |

  @SiteSearchResultsPharmacyLocatorUlayer @SiteSearchRegressionAARP
  Scenario Outline: To verify search results in pharmacy locator Ulayer page
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    Then the user enter the searchValue in the search text box and hits enter
      | search Value | <searchValue> |
    Then the user should see fifteen results before pagination
    #Then the user validates count of results aganist the total shown at top of the page
    Then the user validates pagination and results displayed
    Then the user validates the secondary search by providing newsearchvalue in the text box
      | NewSearchValue | <newsearchvalue> |
    Then the user validates pagination and results displayed

    Examples: 
      | siteName | searchValue | newsearchvalue |
      | Ulayer   | Medicare    | pharmacy       |

  @SiteSearchAARP @thirdpartyURLAARP @SiteSearchRegressionAARP
  Scenario Outline: Verify search results in AARP site -search value -<newsearchvalue>
    Given the user is on AARP medicare acquisition site landing page
    Then the user enter the searchValue in the search text box and hits enter
      | search Value | <searchValue> |
    Then the user clicks on the united health care medicare solutions link
    Then ther user validates the "<url>"
    Then the user navigates to previous tab
    Then user validates search results page

    Examples: 
      | searchValue     | url                                                           |
      | Provider search | https://connect.werally.com/county-plan-selection/uhc.mnr/zip |

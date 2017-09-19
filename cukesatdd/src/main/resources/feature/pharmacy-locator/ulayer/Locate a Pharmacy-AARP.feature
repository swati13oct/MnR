@pharmacylocator
Feature: To test Locate a Pharmacy in acqusition flow AARP site

#@ShowAllRadioOption
#  Scenario Outline: To verify available pharmacies in AARP site
#    Given the user is on the AARP Medicare Site landing page
#    When the user navigates to Request more info page
#    When the user navigates to pharmacy search page in AARP Site
#    And the user enters following details for pharmacy search in AARP Site
#      | Zip Code    | <zipcode>  |
#      | Distance    | <distance> |
#      | County Name | <county>   |
#    And the user chooses a plan from dropdown in AARP Site
#      | <planName> |
#    And the user searches available pharmacies by selecting "Show pharmacies for ALL types" in AARP site
#    Then the user validates the available pharmacies page in AARP site

#    Examples: 
#      | zipcode | distance | county       | planName                                          |
#      |   80002 |       25 | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

#  #	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    |
#  #        | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
#  #	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)       |
  
#@ShowSelectedRadioOption 
#  Scenario Outline: To verify available pharmacies for particular pharmacy types in AARP site
#    Given the user is on the AARP Medicare Site landing page
#    When the user navigates to Request more info page
#    When the user navigates to pharmacy search page in AARP Site
#    And the user enters following details for pharmacy search in AARP Site
#      | Zip Code    | <zipcode>  |
#      | Distance    | <distance> |
#      | County Name | <county>   |
#    And the user chooses a plan from dropdown in AARP Site
#      | <planName> |
#    And the user searches available pharmacies by selecting "Show pharmacies for these services." in AARP site
#      | <pharmacytype> |
#    Then the user validates the available pharmacies page in AARP site
#
#    Examples: 
#      | zipcode | distance | county       | planName                                          | pharmacytype                            |
#      |   80002 |       25 | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | Standard Network Pharmacy,Open 24 hours |

  #	| 78006       | 2        | Bexar County      | AARP MedicareRx Preferred (PDP)                    |  Open 24 hours				|
  #       | 80002       | 2        | Adams County      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |  Pharmacy Saver™ Program			|
  #	| 78006       | 2        | Bexar County      | AARP MedicareRx Saver Plus (PDP)                   |  Open 24 hours				|



  @multicounty
  Scenario Outline: To verify pharmacy locator multi county lookup modal in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |

    Examples: 
      | zipcode | distance | county       |
      |   80002 |       15 | Adams County |

  @languageselection
  Scenario Outline: To verify pharmacy locator language in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    Then the user validate multiple language dropdown menu in AARP site

    Examples: 
      | zipcode | distance | county      |
      |   90210 |       15 | Los Angeles |

  @planType
  Scenario Outline: To verify plantype in pharmacy locator page in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    Then the user click on view search PDF link in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @zipcodeEntry
  Scenario Outline: To verify pharmacy locator zipcode entry in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @showonmap
  Scenario Outline: To verify pharmacy locator showmap in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code | <zipcode>  |
      | Distance | <distance> |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    Then the user click on show on map link in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @resultpdf
  Scenario Outline: To verify pharmacy locator pdf results in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code | <zipcode>  |
      | Distance | <distance> |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    Then the user click on view search PDF link in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

#  @googlemap
#  Scenario Outline: To verify google maps for pharmacies in AARP site
#    Given the user is on the AARP Medicare Site landing page
#    When the user navigates to Request more info page
#    When the user navigates to pharmacy search page in AARP Site
#    And the user enters following details for pharmacy search in AARP Site
#      | Zip Code | <zipcode>  |
#      | Distance | <distance> |
#    And the user chooses the year and a plan from dropdown in AARP site
#      | Year      | <year>     |
#      | Plan Name | <planName> |
#    Then the user validate google map colcor for pharmacy and standard network in AARP Site
#
#    Examples: 
#      | zipcode | distance | county      | year | planName                                          |
#      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @MAplantype
  Scenario Outline: To verify MAplan for pharmacies in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @Widgets
  Scenario Outline: To verify MAplan for pharmacies in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate pharmacy saver widget in AARP site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @moreinfoPDPplantype
  Scenario Outline: To verify PDPplan for pharmacies in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page for PDP plantype
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate more information content based on plan type in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                        |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareRx Walgreens (PDP) |

  @moreinfoMAplantype
  Scenario Outline: To verify moreinfo for MA plantype in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate more information content based on plan type in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @chatPDPplantype
  Scenario Outline: To verify chat window for PDP plantype for pharmacies in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page for PDP plantype
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate chat widget in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                        |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareRx Walgreens (PDP) |

  @chatMAplantype
  Scenario Outline: To verify chat window for MA plantype for pharmacies in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate chat widget in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @TFNPDPplantype
  Scenario Outline: To verify toll free PDP plantype for pharmacies in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page for PDP plantype
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate TFN widget in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                        |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareRx Walgreens (PDP) |

  @TFNMAplantype
  Scenario Outline: To verify toll free MA plantype for pharmacies in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate TFN widget in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @pharmacysaverwidget
  Scenario Outline: To verify pharmacysaverwidget in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate pharmacy saver widget in AARP site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @Pharmacylist
  Scenario Outline: To verify Pharmacylist in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in AARP site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @chineselanguage
  Scenario Outline: To verify pharmacy locator language in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user clicks chineseLink in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches multi lang for pharmacy search results available in AARP site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @spanishlanguage
  Scenario Outline: To verify pharmacy locator language in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    Then the user validate multiple language dropdown menu in AARP site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches multi lang for pharmacy search results available in AARP site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @resultpdfpharmacysaver
  Scenario Outline: To verify pharmacy locator pdf results in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code | <zipcode>  |
      | Distance | <distance> |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in AARP site
    Then the user click on view search PDF link in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @moreinfopharmacysaver
  Scenario Outline: To verify moreinfo for pharmacy saver plantype in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in AARP site
    And the user validate more information content based on plan type in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @redballonpharmacysaver
  Scenario Outline: To verify google map red ballon for pharmacy saver plantype in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in AARP site
    Then the user validate google map red ballon based on plan type in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @tooltippharmacysaver
  Scenario Outline: To verify tooltip for pharmacy saver plantype in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to Request more info page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in AARP site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in AARP site
    Then the user validate tool tip for pharmacy saver plan type in AARP Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

#  @errormessages
#  Scenario Outline: To verify error messages in pharmacy locator page in AARP site
#    Given the user is on the AARP Medicare Site landing page
#    When the user navigates to Request more info page
#    When the user navigates to pharmacy search page in AARP Site
#    And the user enters following details for pharmacy search in AARP Site
#      | Zip Code    | <zipcode>  |
#      | Distance    | <distance> |
#      | County Name | <county>   |
#    And the user verify error messages in pharmacy locator page in AARP site
#
#    Examples: 
#      | zipcode | distance | county      |
#      |         |       15 | Los Angeles |
#      |    9999 |       15 | Los Angeles |

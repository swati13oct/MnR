@pharmacylocator
Feature:To test Locate a Pharmacy in acqusition flow UMS site


  @multicounty
  Scenario Outline: To verify pharmacy locator multi county lookup modal in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |

    Examples: 
      | zipcode | distance | county       |
      |   80002 |       15 | Adams County |

  @languageselection
  Scenario Outline: To verify pharmacy locator language in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    Then the user validate multiple language dropdown menu in UHC site

    Examples: 
      | zipcode | distance | county      |
      |   90210 |       15 | Los Angeles |

  @planType
  Scenario Outline: To verify plantype in pharmacy locator page in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
# View on Map is removed temporarily for Sep Release.
#    Then the user click on view search PDF link in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @zipcodeEntry
  Scenario Outline: To verify pharmacy locator zipcode entry in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2018 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @showonmap
  Scenario Outline: To verify pharmacy locator showmap in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code | <zipcode>  |
      | Distance | <distance> |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    Then the user click on show on map link in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @resultpdf
  Scenario Outline: To verify pharmacy locator pdf results in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code | <zipcode>  |
      | Distance | <distance> |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
# View on Map is removed temporarily for Sep Release.
#    Then the user click on view search PDF link in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

#  @googlemap
#  Scenario Outline: To verify google maps for pharmacies in UHC site
#Given the user is on the UMS Medicare Site landing page
#When the user navigates to pharmacy search page in UMS Site
#    And the user enters following details for pharmacy search in UHC Site
#      | Zip Code | <zipcode>  |
#      | Distance | <distance> |
#    And the user chooses the year and a plan from dropdown in UHC site
#      | Year      | <year>     |
#      | Plan Name | <planName> |
#    Then the user validate google map colcor for pharmacy and standard network in UHC Site
#
#    Examples: 
#      | zipcode | distance | county      | year | planName                                          |
#      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @MAplantype
  Scenario Outline: To verify MAplan for pharmacies in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2018 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @Widgets
  Scenario Outline: To verify MAplan for pharmacies in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate pharmacy saver widget in UHC site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @moreinfoPDPplantype
  Scenario Outline: To verify PDPplan for pharmacies in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate more information content based on plan type in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                        |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareRx Walgreens (PDP) |


  @chatPDPplantype
  Scenario Outline: To verify chat window for PDP plantype for pharmacies in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate chat widget in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                        |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareRx Walgreens (PDP) |

  @chatMAplantype
  Scenario Outline: To verify chat window for MA plantype for pharmacies in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate chat widget in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @TFNPDPplantype
  Scenario Outline: To verify toll free PDP plantype for pharmacies in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate TFN widget in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                        |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareRx Walgreens (PDP) |

  @TFNMAplantype
  Scenario Outline: To verify toll free MA plantype for pharmacies in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate TFN widget in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @pharmacysaverwidget
  Scenario Outline: To verify pharmacysaverwidget in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user validate pharmacy saver widget in UHC site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @Pharmacylist
  Scenario Outline: To verify Pharmacylist in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in UHC site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @chineselanguage
  Scenario Outline: To verify pharmacy locator language in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user clicks chineseLink in UHC Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches multi lang for pharmacy search results available in UHC site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @spanishlanguage
  Scenario Outline: To verify pharmacy locator language in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    Then the user validate multiple language dropdown menu in UHC site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches multi lang for pharmacy search results available in UHC site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @resultpdfpharmacysaver
  Scenario Outline: To verify pharmacy locator pdf results in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code | <zipcode>  |
      | Distance | <distance> |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in UHC site
# View on Map is removed temporarily for Sep Release.
#    Then the user click on view search PDF link in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @moreinfopharmacysaver
  Scenario Outline: To verify moreinfo for pharmacy saver plantype in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in UHC site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @redballonpharmacysaver
  Scenario Outline: To verify google map red ballon for pharmacy saver plantype in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in UHC site
    Then the user validate google map red ballon based on plan type in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @tooltippharmacysaver
  Scenario Outline: To verify tooltip for pharmacy saver plantype in UHC site
Given the user is on the UMS Medicare Site landing page
When the user navigates to pharmacy search page in UMS Site
    And the user enters following details for pharmacy search in UHC Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses the year and a plan from dropdown in UHC site
      | Year      | <year>     |
      | Plan Name | <planName> |
    And the user searches for pharmacy search results available in UHC site
    Then the user validate tool tip for pharmacy saver plan type in UHC Site

    Examples: 
      | zipcode | distance | county      | year | planName                                          |
      |   90210 |       15 | Los Angeles | 2017 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |


	
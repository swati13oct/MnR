@UATRegression
Feature: 1.12 UAT - Medicare Education Pages flows

  @GlobalComponentsAARPPages
  Scenario Outline: <Scenario> : To verify Global Components for the page mentioned of AARP site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    #When user accesses global header of the Medicare Plans home page
    #When user accesses global footer of the Medicare Plans All page
    #Then the User validates Shop for a Plan Navigation link
    #Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on the page using ZipCode "10001"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    # Then the user validates Pro-active Chat
    Then the user validates whether call icon is visible

    # Then the user validates SAM re-active Chat
    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      | Scenario           | site | path                                                     | pageName                              | tfnXpath            | tfnFlag                                                        |      |
      | E2E Scenario 2_AMP | AARP | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options | AARP Medicare Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true |

    @MedEdPages_1_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                                     | pageName                              | tfnXpath         | tfnFlag                                                        |      |
      | E2E Scenario 2_UMS | UHC  | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Choices | UnitedHealthcare | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true |

    @MedEdPages_2_GlobalCompsAARP
    Examples: 
      | Scenario           | site | path                                             | pageName                             | tfnXpath            | tfnFlag                                                        |      |
      | E2E Scenario 5_AMP | AARP | medicare-education/medicare-advantage-plans.html | Learn about Medicare Advantage Plans | AARP Medicare Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true |

    @MedEdPages_2_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                             | pageName                          | tfnXpath         | tfnFlag                                                        |      |
      | E2E Scenario 5_UMS | UHC  | medicare-education/medicare-advantage-plans.html | Medicare Advantage (Part C) Plans | UnitedHealthcare | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true |

    @MedEdPages_3_GlobalCompsAARP
    Examples: 
      | Scenario           | site | path                                                  | pageName                   | tfnXpath            | tfnFlag                                                        |      |
      | E2E Scenario 4_AMP | AARP | medicare-education/medicare-costs.html                | Medicare Cost Basics       | AARP Medicare Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true |
      | E2E Scenario 6_AMP | AARP | medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | AARP Medicare Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true |

    @MedEdPages_3_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                                  | pageName                   | tfnXpath         | tfnFlag                                                        |      |
      | E2E Scenario 4_UMS | UHC  | medicare-education/medicare-costs.html                | Medicare Cost Basics       | UnitedHealthcare | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true |
      | E2E Scenario 6_UMS | UHC  | medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | UnitedHealthcare | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true |

  @GlobalComponentsAARPPages
  Scenario Outline: <Scenario> : To verify Global Components for the page mentioned of AARP site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigates to Medicare Education Page from homepage
    Then the user navigates to Prescriptions, Providers and Benefits page
    Then user select state for geotargeting from global footer of the Medicare Plans All page
    Then user check inner page links on the Medicare Education page
      | PageName | <pageName> |
    Then the user clicks on Estimate Drug Costs Link from Benefit Page to land on DCE Redesign
    Then the user click on return to MEdEd page from Get Started Page
    Then the user click on Provider Search on the Benefit Page
    Then user go back to MedEd page from Rally tool
    Then user clicks on Medicare Annual Enrollment Period Link and comes back
    Then the user validate ZipCode Components on the page using ZipCode "10001"
    Then the user check Still have a question
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user click on next article link

    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      | Scenario           | site | path                                      | pageName                            | tfnXpath                                                       | tfnFlag |
      | E2E Scenario 3_AMP | AARP | medicare-education/medicare-benefits.html | Prescriptions, Providers & Benefits | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @MedEdPages_1_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                      | pageName                            | tfnXpath                                                       | tfnFlag |
      | E2E Scenario 3_UMS | UHC  | medicare-education/medicare-benefits.html | Prescriptions, Providers & Benefits | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

  @GlobalComponentsAARPPages
  Scenario Outline: <Scenario> : To verify Global Components for the page mentioned of AARP site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigates to Medicare Education Page from homepage
    Then the user navigates to Medicare Eligibility page
    Then user select state for geotargeting from global footer of the Medicare Plans All page
    Then user check inner page links on the Medicare Education page
      | PageName | <pageName> |
    Then user clicks on  Initial Enrollment Period Link and comes back
    Then user select state for geotargeting from global footer of the Medicare Plans All page
    Then the user gather medicare info through video
    Then the user click on video transcript link
    Then the user validate ZipCode Components on the page using ZipCode "19019"
    Then the user check Still have a question
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link and validates the correct URL is loaded from Med Ed Page
      | UHC Agent URL | <UHCUrl> |
    Then the user come back to Med-ed page
    Then the user click on next article link

    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      | Scenario           | site | path                                         | pageName             | tfnXpath                                                       | tfnFlag | UHCUrl                      |
      | E2E Scenario 1_AMP | AARP | medicare-education/medicare-eligibility.html | Medicare Eligibility | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    | https://www.myuhcagent.com/ |

    @MedEdPages_1_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                         | pageName             | tfnXpath                                                       | tfnFlag | UHCUrl                      |
      | E2E Scenario 1_UMS | UHC  | medicare-education/medicare-eligibility.html | Medicare Eligibility | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    | https://www.myuhcagent.com/ |

  @GlobalComponentsAARPPages
  Scenario Outline: <Scenario> : To verify Global Components for the page mentioned of AARP site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigates to Medicare Education Page from homepage
    Then the user clicks on Coverage Choices link
    Then user select state for geotargeting from global footer of the Medicare Plans All page
    Then user check inner page links on the Medicare Education page
      | PageName | <pageName> |
    Then user clicks on  Medicare Part A and Part B Coverage dropdown
    Then user clicks on the plan dropdowns
    Then the user check Still have a question
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user click on next article link

    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      | Scenario           | site | path                                                     | pageName         | tfnXpath                                                       | tfnFlag |
      | E2E Scenario 2_AMP | AARP | medicare-education/medicare-parts-and-medigap-plans.html | Coverage Choices | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @MedEdPages_1_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                                     | pageName         | tfnXpath                                                       | tfnFlag |
      | E2E Scenario 2_UMS | UHC  | medicare-education/medicare-parts-and-medigap-plans.html | Coverage Choices | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

  @GlobalComponentsAARPPages
  Scenario Outline: <Scenario> : To verify Global Components for the page mentioned of AARP site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigates to Medicare Education Page from homepage
    Then the user navigates to Medicare Cost Basic page
    Then user select state for geotargeting from global footer of the Medicare Plans All page
    Then user check inner page links on the Medicare Education page
      | PageName | <pageName> |
    Then the user gather medicare info through video
    Then the user click on video transcript link
    Then the user navigates through learn extra links on Cost Basic page
    Then the user check Medicare Savings Program link
    Then the user check Still have a question
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user click on next article link

    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      | Scenario           | site | path                                   | pageName    | tfnXpath                                                       | tfnFlag |
      | E2E Scenario 4_AMP | AARP | medicare-education/medicare-costs.html | Cost Basics | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @MedEdPages_1_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                   | pageName    | tfnXpath                                                       | tfnFlag |
      | E2E Scenario 4_UMS | UHC  | medicare-education/medicare-costs.html | Cost Basics | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

  Scenario Outline: <Scenario> : To verify Global Components for the page mentioned of AARP site for plantype <plantype> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigates to Medicare Education Page from homepage
    Then the user navigates to plan information page
      | planType | <plantype> |
    Then user select state for geotargeting from global footer of the Medicare Plans All page
    Then user click on see plan in your area link
    Then the user gather medicare info through video
    Then the user click on video transcript link
    Then the user hover over and select plan page link
      | nextplanType | MS |
    Then the user hover over and select plan page link
      | nextplanType | PDP |
    Then user click on see plan in your area link
    Then the user gather medicare info through video
    Then the user click on video transcript link
    Then the user check Still have a question
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible

    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      | Scenario           | site | plantype | tfnXpath                                                       | tfnFlag |  |
      | E2E Scenario 5_AMP | AARP | MA       | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

    @MedEdPages_1_GlobalCompsUHC
    Examples: 
      | Scenario           | site | plantype | tfnXpath                                                       | tfnFlag |  |
      | E2E Scenario 5_UMS | UHC  | MA       | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

  Scenario Outline: <Scenario> : To verify Global Components for the page mentioned of AARP site for plantype <plantype> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigates to Medicare Education Page from homepage
    Then the user navigates to Enrollment Basics Page
    Then the user check Social Security link on Enrollment Basic Page
    Then the user click on see all plan link on Enrollment Basic Page
    Then the user validate ZipCode Components on the page using ZipCode "19019"
    Then the user check Still have a question
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible

    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      | Scenario           | site | path                                                  | pageName          | tfnXpath                                                       | tfnFlag |
      | E2E Scenario 6_AMP | AARP | medicare-education/enrollment-and-changing-plans.html | Enrollment Basics | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @MedEdPages_1_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                                  | pageName          | tfnXpath                                                       | tfnFlag |
      | E2E Scenario 6_UMS | UHC  | medicare-education/enrollment-and-changing-plans.html | Enrollment Basics | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

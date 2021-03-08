@UATRegression
Feature: 1.12 UAT - Medicare Education Pages flows

  @GlobalComponentsAARPPages
  Scenario Outline: <Scenario> : To verify Global Components for the page mentioned of AARP site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the Medicare Plans home page
    When user accesses global footer of the Medicare Plans All page
    Then the User validates Shop for a Plan Navigation link
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on the page using ZipCode "10001"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    # Then the user validates Pro-active Chat
    Then the user validates whether call icon is visible

    # Then the user validates SAM re-active Chat
    @MedEdPages_1_GlobalCompsAARP @ios
    Examples: 
      | Scenario           | site | path                                                     | pageName                              | tfnXpath            | tfnFlag                                                              |      |
      | E2E Scenario 2_AMP | AARP | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options | AARP Medicare Plans | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true |

    @MedEdPages_1_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                                     | pageName                              | tfnXpath         | tfnFlag                                                              |      |
      | E2E Scenario 2_UMS | UHC  | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Choices | UnitedHealthcare | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true |

    @MedEdPages_2_GlobalCompsAARP @ios
    Examples: 
      | Scenario           | site | path                                             | pageName                             | tfnXpath            | tfnFlag                                                              |      |
      | E2E Scenario 5_AMP | AARP | medicare-education/medicare-advantage-plans.html | Learn about Medicare Advantage Plans | AARP Medicare Plans | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true |

    @MedEdPages_2_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                             | pageName                          | tfnXpath         | tfnFlag                                                              |      |
      | E2E Scenario 5_UMS | UHC  | medicare-education/medicare-advantage-plans.html | Medicare Advantage (Part C) Plans | UnitedHealthcare | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true |

    @MedEdPages_3_GlobalCompsAARP @ios
    Examples: 
      | Scenario           | site | path                                                  | pageName                   | tfnXpath            | tfnFlag                                                              |      |
      | E2E Scenario 4_AMP | AARP | medicare-education/medicare-costs.html                | Medicare Cost Basics       | AARP Medicare Plans | //span[contains(@style,'inline')]//a[contains(@class, 'tel')]        | true |
      | E2E Scenario 6_AMP | AARP | medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | AARP Medicare Plans | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true |

    @MedEdPages_3_GlobalCompsUHC
    Examples: 
      | Scenario           | site | path                                                  | pageName                   | tfnXpath         | tfnFlag                                                              |      |
      | E2E Scenario 4_UMS | UHC  | medicare-education/medicare-costs.html                | Medicare Cost Basics       | UnitedHealthcare | //span[contains(@style,'inline')]//a[contains(@class, 'tel')]        | true |
      | E2E Scenario 6_UMS | UHC  | medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | UnitedHealthcare | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true |

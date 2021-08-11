Feature:Medicare Education Pages flows for New Pages

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Medicare Eligibility page
    Then the user comes back to new Medicare Education Page from Medicare Eligibility Page
    Then the user navigates to new Coverage Choices page
    Then the user comes back to new Medicare Education Page from Coverage Choices Page
    Then the user navigates to new Benefits page
    Then the user comes back to new Medicare Education Page from Benefits Page
    Then the user navigates to new Cost Basics page
    Then the user comes back to new Medicare Education Page from Cost Basics Page
    Then the user navigates to new Enrollment page
    Then the user comes back to new Medicare Education Page from Enrollment Page
    Then the user navigates to new Original Medicare page
    Then the user comes back to new Medicare Education Page from Original Medicare Page
    Then the user navigates to new Medicare Advantage Plans page
    Then the user comes back to new Medicare Education Page from Medicare Advantage Plans Page
    Then the user navigates to new Medicare Supplement Plans page
    Then the user comes back to new Medicare Education Page from Medicare Supplement Plans Page
    Then the user navigates to new Medicare Prescription Drugs Plans page
    Then the user comes back to new Medicare Education Page from Medicare Prescription Drugs Plans Page
    Then the user navigates to new Special Needs Plans page
    Then the user comes back to new Medicare Education Page from Special Needs Plans Page
    Then the user navigates to new Overview of Plan Types page
    Then the user comes back to new Medicare Education Page from Overview of Plan Types Page
    Then the user navigates to Initial Enrollment Period page
    Then the user comes back to new Medicare Education Page from Initial Enrollment Period Page
    Then the user navigates to new Working Past 65 page
    Then the user comes back to new Medicare Education Page from Working Past 65 Page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible

    @avengersRegressionAARP
    Examples:
      | Scenario     | site | geoState | pageName                    | tfnXpath                                                            | tfnFlag |
      | Avengers AMP | AARP | Alabama  | Medicare Education Hub Page | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario     | site | geoState | pageName                    | tfnXpath                                                            | tfnFlag |
      | Avengers UMS | UHC  | Alabama  | Medicare Education Hub Page | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |


  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> :  <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Medicare Eligibility page
    Then the user validates inner links on new Medicare Eligibility Page
    Then the user validates Learn more about enrolling in Medicare link on Eligibility Page
    Then the user validates Understand your options for Medicare enrollment link on Eligibility Page
    Then the user validates Learn more about Medicare eligibility due to disability link on Eligibility Page
    Then the user validates Social Security link on Eligibility Page
    Then the user click on Get a Plan Recommendation Button and gets back
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user clicks on Coverage Choice link in Next Step Section

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName                 | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 1_AMP | AARP | Arkansas | Medicare Eligibility New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName                 | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 1_UHC | UHC  | Arkansas | Medicare Eligibility New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to Initial Enrollment Period page
    Then the user validates inner links on new Initial Enrollment Period Page
    Then the user gather information through video
    Then the user validates Find Out If You Can Delay Enrolling in Medicare link on new Initial Enrollment Period Page
    Then the user validates See How All the Parts of Medicare Can be Combined link on new Initial Enrollment Period Page
    Then the user validates Enrollment Date Calculator
    Then the user validates email form component on new Medicare Education Page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user clicks on How to Enroll link in Read Next section

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | geoState | pageName                       | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | UAT E2E Scenario 6_AMP | AARP | Alabama  | Initial Enrollment Period Page | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | geoState | pageName                       | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | UAT E2E Scenario 6_AMP | UHC  | Alabama  | Initial Enrollment Period Page | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Coverage Choices page
    Then the user validates inner links on new Coverage Choices Page
    Then the user check plans link on new Coverage Choices Page
    Then the user click on Get a Plan Recommendation Button and gets back
    Then the user gather information through video
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user clicks on Prescriptions Providers and Benefits link in Read Next Section

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName             | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | Alabama  | Coverage Options New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName             | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | Alabama  | Coverage Options New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Benefits page
    Then the user validates inner links on new Benefits Page
    Then the user clicks on DCE link on new Medicare Education Page
    Then the user clicks on Look up Provider link on new Medicare Education Page
    Then the user clicks on Medicare Annual Enrollment link on new Benefits Page
    Then the user clicks on Medicare Advantage Plans link on new Benefits Page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user clicks on Cost Basics link in Read Next Section

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName                                | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | Alabama  | Prescriptions, Providers & Benefits New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName                                | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | Alabama  | Prescriptions, Providers & Benefits New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Cost Basics page
    Then the user validates inner links on new Cost Basics Page
    Then the user gather information through video
    Then the user validates Learn more about the specific costs for Medicare Part A and Part B link on Cost Basics Page
    Then the user validates Learn more about Medicare Prescription Drug plan costs link on Cost Basics Page
    Then the user click on Get a Plan Recommendation Button and gets back
    Then the user validates Learn how to get help with prescription drug costs link on Cost Basics Page
    Then the user validates Learn more about Medicaid and Dual Eligibility link on Cost Basics Page
    Then the user validates Find out if you qualify for Medicare Savings Programs link on Cost Basics Page
    Then the user validates Get more information about PACE link on Cost Basics Page
    Then the user validates Medicare Special Enrollment Period link on Cost Basics Page
    Then the user validates Learn More about Working Past 65 link on Cost Basics Page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user clicks on Learn more about Medicare Advantage Plans link in Read Next Section


    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName             | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 4_AMP | AARP | Alabama  | Cost Basics Page New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName             | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 4_UHC | UHC  | Alabama  | Cost Basics Page New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario> To validate components on New Medicare Education Page :<pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Medicare Advantage Plans page
    Then the user gather information through video
    Then the user validates Get more information about Special Needs Plans link on Medicare Advantage Plans Page
    Then the user validates Learn more about these Medicare Advantage plans here on Medicare Advantage Plans Page
    Then the user validates See how Medicare costs may work with these Medicare coverage examples link on Medicare Advantage Plans Page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user validates Learn more about Medicare Supplement insurance plans on Medicare Advantage Plans Page



    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName                           | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 5_AMP | AARP | Alabama  | Medicare Advantage Part C Plan New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName                           | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 5_UHC | UHC  | Alabama  | Medicare Advantage Part C Plan New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page :<pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Medicare Supplement Plans page
    Then the user clicks on Shop Now button on new Medicare Supplement Plans page
    Then the user validates Learn more about costs associated with Medicare supplement plans link on Medicare Supplement Plans page
    Then the user validates See how Medicare costs may work with these Medicare coverage examples link on Medicare Supplement Plans page
    Then the user validates Learn more about the Medicare Supplement Enrollment Period link on Medicare Supplement Plans page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName                      | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 5_AMP | AARP | Alabama  | Medicare Supplement Plans New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName                      | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 5_UHC | UHC  | Alabama  | Medicare Supplement Plans New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page :<pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Medicare Prescription Drugs Plans page
    Then the user validates Medicare Advantage Plans link on new Medicare Prescription Drugs Plans page
    Then the user gather information through video
    Then the user validates the Extra Help program links on new Medicare Prescription Drugs Plans page
    Then the user validates See how Medicare costs may work with these Medicare coverage examples links on new Medicare Prescription Drugs Plans page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user validates Learn more about how to enroll on Medicare Advantage Plans Page

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName                     | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 5_AMP | AARP | Alabama  | Prescription Drugs Plans New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName                     | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 5_UHC | UHC  | Alabama  | Prescription Drugs Plans New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Special Needs Plans page
    Then the user validates Learn more about Dual Special Needs coverage on Special Needs Plans Page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user validates Medicare Enrollment on Special Needs Plans Page


    @avengersRegressionAARP
    Examples:
      | Scenario     | site | geoState | pageName                | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | Avengers AMP | AARP | Alabama  | Special Needs Plans New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario     | site | geoState | pageName                | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | Avengers UHC | UHC  | Alabama  | Special Needs Plans New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Enrollment page
    Then the user validates inner links on new Enrollment Page
    Then the user validates the Initial Enrollment Period links on new Enrollment page
    Then the user gather information through video
    Then the user validates the creditable link on new Enrollment page
    Then the user validates the Understand your Medicare enrollment options when working past 65 link on new Enrollment page
    Then the user validates the Learn more about the Special Enrollment Period when working past 65 link on new Enrollment page
    Then the user validates the Learn more about Medicare penalties link on new Enrollment page
    Then the user validates the Learn how to enroll in Medicare coverage link on new Enrollment page
    Then the user validates the Learn how to enroll in Medicare with a qualifying disability, ALS or ESRD link on new Enrollment page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user validates the Learn how to change Medicare plans link on new Enrollment page


    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName                | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 6_AMP | AARP | Alabama  | When to Enroll Page New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName                | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 6_UHC | UHC  | Alabama  | When to Enroll Page New | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Original Medicare page
    Then the user validates the Learn more about getting prescription drug coverage link on new Original Medicare page
    Then the user validates the Learn how to get coverage for dental, vision and other benefits with Medicare link on new Original Medicare page
    Then the user click on Get a Plan Recommendation Button and gets back
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user validates the Types of Medicare and Medigap Insurance Plans link on new Original Medicare page


    @avengersRegressionAARP
    Examples:
      | Scenario     | site | geoState | pageName          | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | Avengers AMP | AARP | Alabama  | Original Medicare | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario     | site | geoState | pageName          | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | Avengers UMS | UHC  | Alabama  | Original Medicare | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Overview of Plan Types page
    Then the user validates all the plans links on new Overview of Plan Types page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |


    @avengersRegressionAARP
    Examples:
      | Scenario     | site | geoState | pageName               | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | Avengers AMP | AARP | Alabama  | Overview of Plan Types | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario     | site | geoState | pageName               | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | Avengers UMS | UHC  | Alabama  | Overview of Plan Types | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Working Past 65 page
    Then the user validates the Learn about my Initial Enrollment Period & Medicare choices link on new Working Past 65 page
    Then the user validates the Find your Special Enrollment Period dates link on new Working Past 65 page
    Then the user validates wizard component on new Medicare Education Page
    Then the user validates email form component on new Medicare Education Page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | geoState | pageName             | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | UAT E2E Scenario 6_AMP | AARP | Alabama  | Working Past 65 Page | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | geoState | pageName             | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | UAT E2E Scenario 6_UMS | UHC  | Alabama  | Working Past 65 Page | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Enrollment page
    Then the user validates the Learn how to change Medicare plans link on new Enrollment page
    Then the user validates inner links on new How to Enroll Page
    Then the user validates Social Security links on new How to Enroll Page
    Then the user validates Medicare Gov links on new How to Enroll Page
    Then the user validates View Different Plans links on new How to Enroll Page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user validates Changing Plan link on new How to Enroll Page

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName      | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 6_AMP | AARP | Alabama  | How to Enroll | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName      | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 6_UMS | UHC  | Alabama  | How to Enroll | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page: <pageName> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to new Enrollment page
    Then the user validates the Learn how to change Medicare plans link on new Enrollment page
    Then the user validates Changing Plan link on new How to Enroll Page
    Then the user validates inner links on new Chaning Plan Page
    Then the user validates Learn more here link on new Chaning Plan Page
    Then the user click on Get a Plan Recommendation Button and gets back
    Then the user validates Tips for the Medicare Annual Enrollment Period link on new Chaning Plan Page
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |
    Then the user validates Medicare When Working Past Age 65 Next link on new Chaning Plan Page

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | geoState | pageName                | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 6_AMP | AARP | Alabama  | Changing Medicare Plans | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | geoState | pageName                | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | E2E Scenario 6_UMS | UHC  | Alabama  | Changing Medicare Plans | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To validate components on New Medicare Education Page :<pageName> : <path>:<tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to following sub page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates email form component on new Medicare Education Page
      | Endpoint | <endpoint> |
    Then the user validate ZipCode Components on the page using ZipCode "36117"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user clicks on Agent link from new Medicare Education Pages
      | UHC Agent URL | <UHCUrl> |

    @avengersRegressionAARP
    Examples:
      | Scenario     | site | geoState | path                 | pageName                        | tfnXpath                                                            | tfnFlag | UHCUrl                      | endpoint |
      | Avengers AMP | AARP | Alabama  | iep-guide.html       | Initial Enrollment Period Guide | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | IEP      |
      | Avengers AMP | AARP | Alabama  | wp65-guide.html      | Working Past 65 Guide           | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | WP65     |
      | Avengers AMP | AARP | Alabama  | getting-started.html | Get to Know Medicare            | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | GTKM     |

    @avengersRegressionUHC
    Examples:
      | Scenario     | site | geoState | path                 | pageName                        | tfnXpath                                                            | tfnFlag | UHCUrl                      | endpoint |
      | Avengers UMS | UHC  | Alabama  | iep-guide.html       | Initial Enrollment Period Guide | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | IEP      |
      | Avengers UMS | UHC  | Alabama  | wp65-guide.html      | Working Past 65 Guide           | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | WP65     |
      | Avengers UMS | UHC  | Alabama  | getting-started.html | Get to Know Medicare            | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | GTKM     |


  Scenario Outline: <Scenario> To validate components on New Medicare Education Page :<pageName> : <path>:<tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    Then the user navigates to new Medicare Education homepage
    Then the user navigates to following sub page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Download PDF link
      | Header  | <header>  |
      | PDFName | <pdfName> |
    Then the user validates PDF Viewer on the page
      | PDFName | <pdfName> |

    @avengersRegressionAARP
    Examples:
      | Scenario     | site | geoState | path                                | pageName                            | header                              | pdfName                    |
      | Avengers AMP | AARP | Alabama  | getting-started-medicare-guide.html | Getting Started with Medicare       | Getting Started with Medicare       | getting-started.pdf        |
      | Avengers AMP | AARP | Alabama  | medicare-tips.html                  | Medicare Quick Tips                 | Medicare Quick Tips                 | tips.pdf                   |
      | Avengers AMP | AARP | Alabama  | medicare-while-working-tips.html    | Working Past 65 Medicare Tips       | Working Past 65 Medicare Tips       | medicare-while-working.pdf |
      | Avengers AMP | AARP | Alabama  | medicare-basics-guide.html          | Learning the Basics                 | Learning the Basics                 | medicare-basics.pdf        |
      | Avengers AMP | AARP | Alabama  | iep-checklist.html                  | Initial Enrollment Period Checklist | Initial Enrollment Period Checklist | iep-checklist.pdf          |
      | Avengers AMP | AARP | Alabama  | aep-checklist.html                  | Annual Enrollment Period Checklist  | Annual Enrollment Period Checklist  | aep-checklist.pdf          |
      | Avengers AMP | AARP | Alabama  | plan-finder-worksheet.html          | Plan Finder Worksheet               | Plan Finder Worksheet               | plan-finder.pdf            |
      | Avengers AMP | AARP | Alabama  | plan-review-worksheet.html          | Plan Review Worksheet               | Plan Review Worksheet               | review-your-plan.pdf       |
      | Avengers AMP | AARP | Alabama  | medicare-guide.html                 | Medicare Made Clear Guide           | Medicare Made Clear Guide           | medicare-guide.pdf         |

    @avengersRegressionUHC
    Examples:
      | Scenario     | site | geoState | path                                | pageName                            | header                              | pdfName                    |
      | Avengers AMP | UHC  | Alabama  | getting-started-medicare-guide.html | Getting Started with Medicare       | Getting Started with Medicare       | getting-started.pdf        |
      | Avengers AMP | UHC  | Alabama  | medicare-tips.html                  | Medicare Quick Tips                 | Medicare Quick Tips                 | tips.pdf                   |
      | Avengers AMP | UHC  | Alabama  | medicare-while-working-tips.html    | Working Past 65 Medicare Tips       | Working Past 65 Medicare Tips       | medicare-while-working.pdf |
      | Avengers AMP | UHC  | Alabama  | medicare-basics-guide.html          | Learning the Basics                 | Learning the Basics                 | medicare-basics.pdf        |
      | Avengers AMP | UHC  | Alabama  | iep-checklist.html                  | Initial Enrollment Period Checklist | Initial Enrollment Period Checklist | iep-checklist.pdf          |
      | Avengers AMP | UHC  | Alabama  | aep-checklist.html                  | Annual Enrollment Period Checklist  | Annual Enrollment Period Checklist  | aep-checklist.pdf          |
      | Avengers AMP | UHC  | Alabama  | plan-finder-worksheet.html          | Plan Finder Worksheet               | Plan Finder Worksheet               | plan-finder.pdf            |
      | Avengers AMP | UHC  | Alabama  | plan-review-worksheet.html          | Plan Review Worksheet               | Plan Review Worksheet               | review-your-plan.pdf       |
      | Avengers AMP | UHC  | Alabama  | medicare-guide.html                 | Medicare Made Clear Guide           | Medicare Made Clear Guide           | medicare-guide.pdf         |


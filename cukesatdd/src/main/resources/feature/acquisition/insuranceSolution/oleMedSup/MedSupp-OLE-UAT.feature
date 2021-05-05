@UATRegression @insuranceSolution
Feature: 1.05.9 UAT-OLE MedSupp Flow

  @MedSupp_OLE_Common
  Scenario Outline: <scenario> MedSup E2E Flow through Shop Pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user hovers screen over the shop for a plan
    And click on Enroll Plan on shoppages for Medsupp plans
    When the user performs plan search using Shop Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the site user fills all the details in MedsuppPage
      | DOB | <DOB> |
    Then the site user validates the RightRails Links on Medsupp Page
    Then user validate the plandetails on medsupp plans
    Then the site user clicks on Start Application Button and proceed Next
      | DOB       | <DOB>       |
      | Firstname | <Firstname> |
      | Lastname  | <Lastname>  |
    Then the site user clicks on continue application until confirmaion page
      | MedicareNumber | <medicarenumber> |

    #Then the user validate on medsupp plans confirmation page
    @MedSupp_OLE_Common_AARP @UATRegression @prodRegression_MedSupp_AARP @prodRegression @regressionAARP @sanity
    Examples: 
      | scenario           | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site | medicarenumber |
      | E2E Scenario 3_AMP |   90210 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | Los Angeles County | MS       | 11/13/1940 | John      | Carry    | ABCD          | Resume          | TiggerOptumID29 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP | 1EG1TE1MK12    |

    @MedSupp_OLE_Common_UHC @UATRegression @prodRegression_MedSupp_UHC @regressionUHC
    Examples: 
      | scenario           | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site | medicarenumber |
      | E2E Scenario 3_UMS |   90210 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | Los Angeles County | MS       | 11/13/1940 | John      | Carry    | ABCD          | Resume          | TiggerOptumID29 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  | 1EG1TE1MK13    |

  @MedSupp_OLE_Common
  Scenario Outline: <scenario> MedSup E2E Flow through VPP Pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user fills all the details in MedsuppPage
      | DOB | <DOB> |
    Then the site user validates the RightRails Links on Medsupp Page
    Then user validate the plandetails on medsupp plans
    Then the site user clicks on Start Application Button and proceed Next
      | DOB       | <DOB>       |
      | Firstname | <Firstname> |
      | Lastname  | <Lastname>  |
    # Then the site user clicks on continue application until confirmaion page
    Then the site user clicks on continue application until confirmaion page for vpp pages
      | MedicareNumber | <medicarenumber> |

    #Then the user validate on medsupp plans confirmation page
    @MedSupp_OLE_Common_AARP @UATRegression @prodRegression_MedSupp_AARP @regressionAARP
    Examples: 
      | scenario           | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site | medicarenumber |
      | E2E Scenario 1_AMP |   90210 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | Los Angeles County | MS       | 11/13/1940 | John      | Carry    | ABCD          | Resume          | TiggerOptumID29 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP | 1EG1TE1MK12    |

    @MedSupp_OLE_Common_UHC @UATRegression @prodRegression_MedSupp_UHC @prodRegression @regressionUHC @sanity
    Examples: 
      | scenario           | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site | medicarenumber |
      | E2E Scenario 1_UMS |   90210 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | Los Angeles County | MS       | 11/13/1940 | John      | Carry    | ABCD          | Resume          | TiggerOptumID29 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  | 1EG1TE1MK13    |

  @MedSupp_OLE_Common
  Scenario Outline: <scenario> MedSup E2E Flow through Medicare Education Page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user hovers screen over the learnabout Medicare for a plan
    And click on Enroll Plan on Medicare Education Page for Medsupp plans
    When the user performs plan search using learn about medicare Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the site user fills all the details in MedsuppPage
      | DOB | <DOB> |
    Then the site user validates the RightRails Links on Medsupp Page
    Then user validate the plandetails on medsupp plans
    Then the site user clicks on Start Application Button and proceed Next
      | DOB       | <DOB>       |
      | Firstname | <Firstname> |
      | Lastname  | <Lastname>  |
    Then the site user clicks on continue application until confirmaion page
      | MedicareNumber | <medicarenumber> |
    Then the user validate on medsupp plans confirmation page

    @MedSupp_OLE_Common_AARP @UATRegression @prodRegression_MedSupp_AARP @prodRegression @regressionAARP
    Examples: 
      | scenario           | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site | medicarenumber |
      | E2E Scenario 2_AMP |   90210 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | Los Angeles County | MS       | 11/13/1940 | John      | Carry    | ABCD          | Resume          | TiggerOptumID29 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP | 1EG1TE1MK12    |

    @MedSupp_OLE_Common_UHC @UATRegression @prodRegression_MedSupp_UHC @regressionUHC
    Examples: 
      | scenario           | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site | medicarenumber |
      | E2E Scenario 2_UMS |   90210 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | Los Angeles County | MS       | 11/13/1940 | John      | Carry    | ABCD          | Resume          | TiggerOptumID29 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  | 1EG1TE1MK13    |

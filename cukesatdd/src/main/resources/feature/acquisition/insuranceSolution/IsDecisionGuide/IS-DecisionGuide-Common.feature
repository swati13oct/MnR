Feature: 1.14 Med Supp Plans (IS) Decision Guide flow UAT Scripts

  Scenario Outline: <Scenario> - To Test IS Decision Guide E2E on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    #And the user selects plan year
    # | Plan Year | <planyear> |
    #    Then the user enters valid information for the pre entry form on AARP site
    #      | DOB							|	<dob>								|
    Then the user enters and  saves the entered information in Pre-entry page for validation on IS form
      | DOB | <dob> |
    Then the user clicks on Request a Free Decision Guide on the Raight Rail on VPP PLan Summary Page for Med Supp Plans
    #Then the user validates all the required fields for blank validation on Step1 on AARP site
    #Then the user validated all fields for invalid validation on Step1 on AARP site
    Then the user enters valid information for the following fields
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
    #Then the user validated invalid address error message for next button on Step1 on AARP site
    Then the user validates address autocomplete on Step1
    Then user clicks Next to Navigate to Second Step
    #Then the user validates Decision Guide Step 2 page info is same as the saved information from Pre-entry page on site
    Then the user fill details on the IS pages and click on submit button back to vpp page

    #Then the user validates all the required fields for blank validation on Second Step on AARP site
    #Then the user validated all fields for invalid validation on Second Step on AARP site
    # Then the user provides all valid information for Second Step on AARP site
    #  | DOB        | <dob>        |
    #  | PartBMonth | <partBmonth> |
    #  | PartBYear  | <partByear>  |
    #  | StartDate  | <startDate>  |
    #  | AARPno     | <aarpNo>     |
    #  | PhNo       | <phNo>       |
    # | MobileFlag | <mobileFlag> |
    #Then the user clicks Submit to submit Decision Guide on AARP site
    #Then the user validates Thank You Page
    #Then the user clicks Submit to submit Decision Guide
    #Then the user validates Thank You Page and land on Medsupp Page
    @insuranceSolution_DecisionGuide_Common_AARP @UATRegression @regressionAARP @sanity @insuranceSolution
    Examples: 
      | Scenario                                      | site | zipcode | isMultutiCounty | county             | plantype | firstname  | lastname     | distributionmethod | email                      | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth | partAyear | startDate | gender |
      | IS Decision Guide Request - E2E Scenario_AARP | AARP |   90210 | NO              | Los Angeles County | MS       | MNRtestSai | MNRtestKumar | mail               | [blank]                    | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |
      | IS Decision Guide Request - E2E Scenario_AARP | AARP |   90210 | NO              | Los Angeles County | MS       | MNRtestSai | MNRtestKumar | email              | testQA123@optum.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |

    @insuranceSolution_DecisionGuide_Common_UHC @UATRegression @regressionUHC @insuranceSolution
    Examples: 
      | Scenario                                     | site | zipcode | isMultutiCounty | county             | plantype | firstname  | lastname     | distributionmethod | email                    | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth | partAyear | startDate | gender |
      | IS Decision Guide Request - E2E Scenario_UMS | UHC  |   90210 | NO              | Los Angeles County | MS       | MNRtestSai | MNRtestKumar | mail               | [blank]                  | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |
      | IS Decision Guide Request - E2E Scenario_UMS | UHC  |   90210 | NO              | Los Angeles County | MS       | MNRtestSai | MNRtestKumar | email              | testQA123s@optum.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |

  Scenario Outline: <Scenario> - To Test UAT IS Decision Guide E2E on <site> site thorugh Shop Pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user hovers screen over the shop for a plan
    And click on Enroll Plan on shoppages for Medsupp plans
    When the user performs plan search using Shop Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user enters and  saves the entered information in Pre-entry page for validation on IS form
      | DOB | <dob> |
    Then the user clicks on Request a Free Decision Guide on the Raight Rail on VPP PLan Summary Page for Med Supp Plans
    #Then the user validates all the required fields for blank validation on Step1 on AARP site
    #Then the user validated all fields for invalid validation on Step1 on AARP site
    Then the user enters valid information errors for the following fields in IS Pages
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
    #Then the user validated invalid address error message for next button on Step1 on AARP site
    Then the user validates address autocomplete on Step1
    Then user clicks Next to Navigate to IS Second Step
    #Then the user validates Decision Guide Step 2 page info is same as the saved information from Pre-entry page on site
    Then the user fill details on the IS pages and click on submit button back to vpp page

    #Then the user validates all the required fields for blank validation on Second Step on AARP site
    #Then the user validated all fields for invalid validation on Second Step on AARP site
    # Then the user provides all valid information for Second Step on AARP site
    #  | DOB        | <dob>        |
    #  | PartBMonth | <partBmonth> |
    #  | PartBYear  | <partByear>  |
    #  | StartDate  | <startDate>  |
    #  | AARPno     | <aarpNo>     |
    #  | PhNo       | <phNo>       |
    # | MobileFlag | <mobileFlag> |
    #Then the user clicks Submit to submit Decision Guide
    #Then the user validates Thank You Page and land on Medsupp Page
    @insuranceSolution_DecisionGuide_Common_AARP @UATRegression @regressionAARP @insuranceSolution
    Examples: 
      | Scenario                                        | site | zipcode | isMultutiCounty | county             | plantype | firstname  | lastname     | distributionmethod | email                      | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth | partAyear | startDate | gender |
      | IS Decision Guide Request - E2E Scenario 1_AARP | AARP |   90210 | NO              | Los Angeles County | MS       | MNRtestSai | MNRtestKumar | mail               | [blank]                    | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |
      | IS Decision Guide Request - E2E Scenario 1_AARP | AARP |   90210 | NO              | Los Angeles County | MS       | MNRtestSai | MNRtestKumar | email              | testQA123@optum.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |

    @insuranceSolution_DecisionGuide_Common_UHC @UATRegression @regressionUHC @insuranceSolution
    Examples: 
      | Scenario                                       | site | zipcode | isMultutiCounty | county             | plantype | firstname  | lastname     | distributionmethod | email                    | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth | partAyear | startDate | gender |
      | IS Decision Guide Request - E2E Scenario 1_UMS | UHC  |   90210 | NO              | Los Angeles County | MS       | MNRtestSai | MNRtestKumar | mail               | [blank]                  | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |
      | IS Decision Guide Request - E2E Scenario 1_UMS | UHC  |   90210 | NO              | Los Angeles County | MS       | MNRtestSai | MNRtestKumar | email              | testQA123@optum.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |

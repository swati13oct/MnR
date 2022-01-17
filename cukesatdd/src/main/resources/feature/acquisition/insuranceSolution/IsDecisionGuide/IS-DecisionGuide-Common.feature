Feature: 1.14 Med Supp Plans (IS) Decision Guide flow UAT Scripts

  Scenario Outline: <Scenario> - To Test IS Decision Guide E2E on <site> site for <firstname>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the user enters and  saves the entered information in Pre-entry page for validation on IS form
      | DOB | <dob> |
    Then the user clicks on Request a Free Decision Guide on the Raight Rail on VPP PLan Summary Page for Med Supp Plans
   Then the user enters valid information for the following fields
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
   Then the user validates address autocomplete on Step1
    Then user clicks Next to Navigate to Second Step
   Then the user validates Decision Guide Step 2 page info is same as the saved information from Pre-entry page on site
     Then the user clicks Submit to submit Decision Guide
    Then the user validates Thank You Page and land on Medsupp Page
    
    @insuranceSolution_DecisionGuide_Common_AARP @UATRegression @regressionAARP @sanity @insuranceSolution @insuranceSolution_AARP @nonProd
    Examples: 
      | Scenario                                      | site | zipcode | isMultutiCounty | county             | plantype |	firstname  		| lastname    	| distributionmethod | email              | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth | partAyear | startDate | gender |
      | IS Decision Guide Request - E2E Scenario_AARP | AARP |   58103 | NO              | Cass County | MS       |	MNRtestKumar	| MNRtestSai 		| mail               | [blank]            | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |
      | IS Decision Guide Request - E2E Scenario_AARP | AARP |   58103 | NO              | Cass County | MS       | 	MNRtestSai 		| MNRtestKumar	| email              | test123@optum.com 	| 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |

    @insuranceSolution_DecisionGuide_Common_UHC @UATRegression @regressionUHC @insuranceSolution @nonProd
    Examples: 
      | Scenario                                     | site | zipcode | isMultutiCounty | county             | plantype | firstname  | lastname     | distributionmethod | email                    | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth | partAyear | startDate | gender |
      | IS Decision Guide Request - E2E Scenario_UMS | UHC  |   58103 | NO              | Cass County | MS       | MNRtestKumar | MNRtestSai | mail               | [blank]                  | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |
      | IS Decision Guide Request - E2E Scenario_UMS | UHC  |   58103 | NO              | Cass County | MS       | MNRtestSai | MNRtestKumar | email              | test123@optum.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |

  Scenario Outline: <Scenario> - To Test UAT IS Decision Guide E2E on <site> site thorugh Shop Pages for <firstname>
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
   Then the user enters valid information for the following fields
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
   Then the user validates address autocomplete on Step1
    Then user clicks Next to Navigate to Second Step
   Then the user validates Decision Guide Step 2 page info is same as the saved information from Pre-entry page on site
     Then the user clicks Submit to submit Decision Guide
    Then the user validates Thank You Page and land on Medsupp Page
    
    @insuranceSolution_DecisionGuide_Common_AARP @UATRegression @regressionAARP @insuranceSolution @nonProd
    Examples: 
      | Scenario                                        | site | zipcode | isMultutiCounty | county             | plantype | firstname  | lastname     | distributionmethod | email                      | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth | partAyear | startDate | gender |
     # | IS Decision Guide Request - E2E Scenario 1_AARP | AARP |   58103 | NO              | Cass County | MS       | MNRtestKumar | MNRtestSai | mail               | [blank]                    | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |
      | IS Decision Guide Request - E2E Scenario 1_AARP | AARP |   58103 | NO              | Cass County | MS       | MNRtestSai | MNRtestKumar | email              | venkata.kanagala@optum.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |

    @insuranceSolution_DecisionGuide_Common_UHC @UATRegression @regressionUHC @insuranceSolution @sanity @nonProd
    Examples: 
      | Scenario                                       | site | zipcode | isMultutiCounty | county             | plantype | firstname  | lastname     | distributionmethod | email                    | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth | partAyear | startDate | gender |
     # | IS Decision Guide Request - E2E Scenario 1_UMS | UHC  |   58103 | NO              | Cass County | MS       | MNRtestKumar | MNRtestSai | mail               | [blank]                  | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |
      | IS Decision Guide Request - E2E Scenario 1_UMS | UHC  |   58103 | NO              | Cass County | MS       | MNRtestSai | MNRtestKumar | email              | prashant_kadus@optum.com | 01/01/1946 | January    |      2020 | 0321323215 | 3216549871 | N          | February   |      2020 | June      | male   |

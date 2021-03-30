Feature: 2.05.1.ACQ-OLE PRE Through MAPD

  Scenario Outline: To validate MA plans through PRE
     Scenario Outline: To validate MA plans through PRE

    Given the user is on medicare acquisition site landing page for PRE
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Check Breadcrumbs
    And clicks on get started button and runs a questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects a plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options on Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options on Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors on doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option on Drug page
      | Plan Type      | <isCoverageOpt>  |
      | Drug Selection | <Drug Selection> |
    And user selects additional services option on additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option on cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements on loading results page
    #And the user views the plans of the below plan type and select Next year
    # | Plan Type | <plantype> |
    #And the user views the plans of the below plan type
    #| Plan Type | <plantype> |
    And the user selects plan year for PRE Flow
      | Plan Year | <planyear> |
    And the user validates the available plans for selected plan types
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Last Name                | <lastname>               |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | MedicaidNumber           | <medicaidnumber>         |
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to Medicare Information Page
    #Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      #| PartA Date         | <partadate>         |
      # | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    #    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd ESRD on Medicare Info Page
      | MedicaidNumber | <medicaidnumber> |
      | Plan Year      | <planYear>       |
    #    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user validates the long term questions in Medicare Information Page
      | Health Insurance Name | <healthinsurancename> |
      | Group Number          | <groupnumber>         |
      | Member Number         | <membernumber>        |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
      | Prescription Name | <prescriptioncoveragename> |
      | PD Group Number   | <pdgroupnumber>            |
      | PD Member Number  | <pdmembernumber>           |
    Then the user navigates to SEP Page
      | Input Data | <inputdataType> |
      | PartA Date | <partadate>     |
      | PartB Date | <partbdate>     |
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    #    Then the user navigates to Coverage and Health Information Page
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    # Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment

    #Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.
    @PRE_VPP_OLE_E2E_AARP
    Examples: 
      | site | PlanType      | planyear | planYear | Zipcode | isMultiCounty | county          | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | planyear                                             | planYear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber     | membernumber | prescriptioncoveragename | pdgroupnumber        | pdmembernumber | inputdataType |       |
      | AARP | MAPD-RRID-MBI | current  | current  |   10001 | No            | New York County | MAPD          | None         | None   | Lookup  | John        | [blank]       | No             | Yes,No,No,No                  | Higher               | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | current  | current  |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | MBI      | GOTTFRIED | GARRAND  | 5N69QY6ET34    | false   |  09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    | [blank]       | [blank]     | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | [blank]           | NO      | NO                  | HealthInsurance | HI1562759    | ABC12345DEF              | PrescriptionCoverage | PD5646136      | BCD12345EFG   | Valid |

    #|	AARP	|   55419 | No            | Hennepin   | MAPD          | None         | None   | AcceptsMedicare |                  |               | No             | Yes,No,No,No                  | Higher               |
    @PRE_VPP_OLE_E2E_UHC
    Examples: 
      | site | PlanType      | planyear | planYear | Zipcode | isMultiCounty | county          | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | planyear                                             | planYear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber     | membernumber | prescriptioncoveragename | pdgroupnumber        | pdmembernumber | inputdataType |       |
      | UHC  | MAPD-RRID-MBI | current  | current  |   10001 | No            | New York County | MAPD          | None         | None   | Lookup  | John        | [blank]       | No             | Yes,No,No,No                  | Higher               | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | current  | current  |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | MBI      | GOTTFRIED | GARRAND  | 5N69QY6ET34    | false   |  09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    | [blank]       | [blank]     | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | [blank]           | NO      | NO                  | HealthInsurance | HI1562759    | ABC12345DEF              | PrescriptionCoverage | PD5646136      | BCD12345EFG   | Valid |

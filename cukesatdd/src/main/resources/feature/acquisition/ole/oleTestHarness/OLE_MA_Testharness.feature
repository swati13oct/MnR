@OLEMicroAPP_MA
Feature: OLE Testharness page for AARP for MA

  @OLEMicroAppMA01
  Scenario Outline: TID: <TID> -plan type: <PlanType> - Ole Testharness page to confirmation page for MA
    Given the user is on OLE TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user navigates to OLE WelcomePage using following information
      | SiteId           | <siteId>          |
      | PBPNumber        | <pBPNumber>       |
      | ClientCode       | <clientCode>      |
      | SegmentId        | <segmentId>       |
      | PlanTypeTH       | <PlanTypeTH>      |
      | TFN              | <TFN>             |
      | Plan Name        | <planName>        |
      | psc              | <psc>             |
      | Plan Year        | <planYear>        |
      | env              | <env>             |
      | Zip Code         | <zipcode>         |
      | County Name      | <county>          |
      | FipsCode         | <FipsCode>        |
      | StateCode        | <StateCode>       |
      | CMScode          | <CMScode>         |
      | HNumber          | <HNumber>         |
      | Is Multi County  | <isMultutiCounty> |
      | Plan Type        | <plantype>        |
      | Rider Flag       | <RiderFlag>       |
      | PrefferedPlan Id | <PrefferedPlanId> |
      | Plan Code        | <PlanCode>        |
      | maps PlanType    | <mapsPlanType>    |
      | OLEis CNS        | <OLEisCNS>        |
      | client ProdCode  | <clientProdCode>  |
      | lineOf Business  | <lineOfBusiness>  |
      | OLEis CSNP       | <OLEisCSNP>       |
      | Fitness          | <fitness>         |
      | Vision           | <vision>          |
      | Hearing          | <hearing>         |
      | Dental           | <dental>          |
      | salesagent id    | <salesagentid>    |
      | Premium          | <premium>         |
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
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    #    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd ESRD on Medicare Info Page
      | MedicaidNumber | <medicaidnumber> |
    #    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to SEP Page
    Then the user validates the Plan details in SEP Page OLE Right Rail
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
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
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    # Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | isMultutiCounty | plantype | siteName | THPage | siteId | pBPNumber | clientCode | segmentId | PlanTypeTH | TFN            | planName                                               | psc    | planYear | env     | zipcode | county             | FipsCode | StateCode | CMScode | HNumber | RiderFlag | PrefferedPlanId | PlanCode  | mapsPlanType | OLEisCNS | clientProdCode | lineOfBusiness | OLEisCSNP | fitness | vision | hearing | dental | salesagentid | premium | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      | 00001 | NO              | MA       | Ulayer   | ole    | aarp   |       121 | AARP1      |       000 | MA         | 1-877-699-5710 | AARP Medicare Advantage SecureHorizons Essential (HMO) | 810027 |     2020 | nonProd |   90210 | Los Angeles County |      037 | CA        |     200 | H0543   | true      | H0543121000     | undefined | HMO          | false    | undefined      | undefined      | false     | true    | true   | true    | false  |              |    0.00 | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 | 2e             | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | NO                | NO      |
      | 00002 | NO              | MA       | Blayer   | ole    | uhc    |       121 | UHCMS1     |       000 | MA         | 1-877-596-3258 | AARP Medicare Advantage SecureHorizons Essential (HMO) | 880180 |     2020 | nonProd |   90210 | Los Angeles County |      037 | CA        |     200 | H0543   | true      | H0543121000     | undefined | HMO          | false    | undefined      | undefined      | false     | true    | true   | true    | false  |              |    0.00 | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 | 2e             | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | NO                | NO      |

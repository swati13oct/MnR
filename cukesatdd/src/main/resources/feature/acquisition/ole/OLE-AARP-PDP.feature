@fastandfurious @OLE @PDP_OLE_Ulayer
Feature: 1.05.3.ACQ-OLE common tool flow E2E PDP AARP

  @acquisitionRegression
  @PDP_OLE_AARP @junerelease2018 @september_release_2018 @december_release_2018 @OLE_DNSP_AARP @MACRAvalidation @OEP_CHANGES @OLE_Regression_Ulayer
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
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
    Then the user navigates to Preliminary Questions Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user enters following required information in Personal Information Page
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
    Then the user navigates to SEP Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Review and Submit Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
   # Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType         | zipcode | isMultutiCounty | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
 		  | 15561 | PDP-HICN         |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | HICN     | John      | Doe      | 121242525p     | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15562 | PDP-RRID         |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP)                     | RRID     | John      | Doe      | eo981321668    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15563 | PDP-MBI          |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)                      | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
     
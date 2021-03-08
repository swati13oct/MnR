 @PlansAndDocument_Part6 @PlansAndDocuments @VelocityDasher @regressionMember
Feature: 1.06.6 Member Plans and Documents Page Part 6

						# This feature File consist of Scenario 26 to 28.
	
	 #Need a Combo Active member with New pre effective plan
  @PlansAndDocument26 @FedActiveShipPre  @release_june_2019 @PD_Part6_Regression
  Scenario Outline: FID: <FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for Combo Active member with pre-effective plan
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user is on the forms and resources page for Selected plan tab
      | PlanName | <FirstPlanName> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And the user scrolls till the end of the page to check the forms and resources section
    And user is on the forms and resources page for Selected plan tab
      | PlanName | <SecondPlanName> |
    Then verify Preeffective plan name and Coverage Date for preeffective plan for Combo
      | ShipPreEffe PlanName | <ShipPreEffePlan> |
      | Coverge Date         | <CoverageDate>    |
    Then verify orderPlan Material link is not displayed preeffective plan for Combo

    Examples: 
      | FID     | planType | memberType          | FirstPlanName          | SecondPlanName                     | ShipPreEffePlan               | CoverageDate               |
      | F282605 | Combo    | ActivePreEffective | Medicare Advantage Prescription Drug Plan | Medicare Supplement Insurance Plan | AARP MEDICARE SUPPLEMENT PLAN | Coverage Starts 08/01/2019 |

  #Need a Combo Terminated member with New pre effective plan
  @PlansAndDocument27 @FedTerminatedShipPre  @release_june_2019 @PD_Part6_Regression
  Scenario Outline: FID: <FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for COMBO Terminated member with pre-effective plan
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user is on the forms and resources page for Selected plan tab
      | PlanName | <FirstPlanName> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And for terminated member order plan materials link is not displayed
    Then validate that the anoc section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My Document section is displayed
    Then validate that the renew magazine section is not displayed
    Then validate that the annual directories section is not displayed
    Then validate that the EOB Section is displayed
    And the user scrolls till the end of the page to check the forms and resources section
    And user is on the forms and resources page for Selected plan tab
      | PlanName | <SecondPlanName> |
    Then verify Preeffective plan name and Coverage Date for preeffective plan for Combo
      | ShipPreEffe PlanName | <ShipPreEffePlan> |
      | Coverge Date         | <CoverageDate>    |
    Then verify orderPlan Material link is not displayed preeffective plan for Combo

    Examples: 
      | FID     | planType | memberType       | FirstPlanName                                          | SecondPlanName                     | ShipPreEffePlan               | CoverageDate               |
      | F282605 | Combo    | FedTerNewPreShip | Medicare Advantage Prescription Drug Plan (Terminated) | Medicare Supplement Insurance Plan | AARP MEDICARE SUPPLEMENT PLAN | Coverage Starts 08/01/2019 |

  #----- begin segmentID and pdf code related validation
  # note: will kill the test if page load time takes longer than 5 min to load
  # note: example table values may need to be adjust when year changes and pdf codes change
  @PlansAndDocument28 @F318679_ANOC @regressionMember @Part2of2 @PD_Part6_Regression
  Scenario Outline: FID: F<FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the segment ID and ANOC component code 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigate to plan documents and resources page for segment ID validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then I can validate the segment ID value in localStorage on forms and resources page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Segment ID  | <segmentId>  |
    Then I can validate Annual Notice of Changes Documents section content
      | Plan Type                        | <planType>             |
      | Member Type                      | <memberType>           |
      | Expect Whole ANOC Section        | <expectWholeAnocSect>  |
      | Expect Current Year ANOC Section | <cy_expectAnocSubSect> |
      | Current Year ANOC PDF Code       | <cy_anocPdfCode>       |
      | Current Year EOC PDF Code        | <cy_eocPdfCode>        |
      | Current Year CF PDF Code         | <cy_cfPdfCode>         |
      | Expect Next Year ANOC Section    | <ny_expectAnocSubSect> |
      | Next Year ANOC PDF Code          | <ny_anocPdfCode>       |
      | Next Year EOC PDF Code           | <ny_eocPdfCode>        |
      | Next Year CF PDF Code            | <ny_cfPdfCode>         |

    Examples: 
      | FID    | planType | memberType      | segmentId    | expectWholeAnocSect | cy_expectAnocSubSect | cy_anocPdfCode      | cy_eocPdfCode       | cy_cfPdfCode        | ny_expectAnocSubSect | ny_anocPdfCode      | ny_eocPdfCode       | ny_cfPdfCode        | 
    # note: no working data for these comment out cases yet
    # | 318679 | MAPD     | IndEff_AARP_FnR | 000          | true                | true                 | AAPA19HM4283769_001 | AAPA19HM4283717_003 | AAEX19HM4310605_011 | true                 | AAPA20HM4515155_000 | AAPA20HM4536734_000 | AAEX20HM4540614_000 |
    # | 318679 | MAPD     | IndEff_UHC_FnR  | 000          | true                | true                 | AAFL19RP4284175_001 | AAFL19RP4284870_003 | AAEX19PP4310531_011 | true                 | AAFL20RP4515715_000 | AAFL20RP4537629_000 | AAEX20PP4540533_000 |
      | 318679 | PDP      | IndEff_AARP_FnR | 000          | true                | true                 | PDEX----4284318_002 | AAEX----4285044_004 | PDEX----4310625_013 | true                 | PDEX----4512102_000 | PDEX----4512066_000 | PDEX----4540654_001 |
      | 318679 | SHIP     | IndEff_FnR      | 000          | false               | false                | NA                  | NA                  | NA                  | false                | NA                  | NA                  | NA                  |
    # | 318679 | MAPD     | PreEff_FnR      | 000          | false               | false                | NA                  | NA                  | NA                  | false                | NA                  | NA                  | NA                  |
      | 318679 | PDP      | PreEff_FnR      | 000          | false               | false                | NA                  | NA                  | NA                  | false                | NA                  | NA                  | NA                  |
      | 318679 | MAPD     | Terminated_FnR  | 000          | false               | false                | NA                  | NA                  | NA                  | false                | NA                  | NA                  | NA                  |
  #----- end segmentID and pdf code related validation
      
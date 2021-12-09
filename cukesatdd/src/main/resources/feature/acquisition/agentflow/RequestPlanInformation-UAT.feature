@agentAppointment
Feature: 1.06-UAT Scripts to validate the request plan information on the Acquistion sites

  Scenario Outline: <scenario> Verify request an <plantype> appointment through <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user enters following information in Request Plan Information Guide
      | Firstname | <Firstname> |
      | Lastname  | <Lastname>  |
      | Email     | <email>     |

    @requestPlanInformationUlayer @UATRegression @regressionAARP @nonProd
    Examples: 
      | scenario                                  | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname       | Lastname       | email                      |
      | Request plan information scenario 1 _AARP | AARP | MA-MBI   | future   | future   |   10001 | NO              | New York County | MA       | future   | Test_Portals_J | Test_Portals_K | venkata.kanagala@optum.com |

    @requestPlanInformationBlayer @UATRegression @regressionUHC
    Examples: 
      | scenario                                   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname      | Lastname       | email                      |
      | Request plan information scenario 1 _UHCMS | UHC  | MA-MBI   | future   | future   |   10001 | NO              | New York County | MA       | future   | Test_Portals_J | Test_Portals_K | prashant_kadus@optum.com |

  Scenario Outline: <scenario> Verify request an <plantype>appointment through <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user enters following information in Request Plan Information Guide
      | Firstname | <Firstname> |
      | Lastname  | <Lastname>  |
      | Email     | <email>     |

    @requestPlanInformationUlayer @UATRegression @regressionAARP
    Examples: 
      | scenario                                  | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname      | Lastname       | email                      |
      | Request plan information scenario 1 _AARP | AARP | PDP-MBI  | future   | future   |   10001 | NO              | New York County | PDP      | future   | Test_Portals_J | Test_Portals_K | venkata.kanagala@optum.com |

    @requestPlanInformationBlayer @UATRegression @regressionUHC @nonProd
    Examples: 
      | scenario                                   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname      | Lastname       | email                      |
      | Request plan information scenario 1 _UHCMS | UHC  | PDP-MBI  | future   | future   |   10001 | NO              | New York County | PDP      | future   | Test_Portals_J | Test_Portals_K | prashant_kadus@optum.com   |

  Scenario Outline: <scenario> Verify request <plantype> an appointment through <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user enters following information in Request Plan Information Guide
      | Firstname | <Firstname> |
      | Lastname  | <Lastname>  |
      | Email     | <email>     |

    @requestPlanInformationUlayer @UATRegression @regressionAARP @nonProd
    Examples: 
      | scenario                                  | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname      | Lastname       | email                      |
      | Request plan information scenario 1 _AARP | AARP | PCP-DSNP-MBI | future   | future   |   10001 | NO              | New York County | SNP      | future   | Test_Portals_J | Test_Portals_K | venkata.kanagala@optum.com |

    @requestPlanInformationBlayer @UATRegression @regressionUHC @nonProd
    Examples: 
      | scenario                                   | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname      | Lastname       | email                     |
      | Request plan information scenario 1 _UHCMS | UHC  | PCP-DSNP-MBI | future   | future   |   10001 | NO              | New York County | SNP      | future   | Test_Portals_J | Test_Portals_K | prashant_kadus@optum.com |


   # ------------------ Old pages for Shop for plan and changed to medicare page
  #Scenario Outline: <scenario> Verify Request Plan Information through <site> from Shop for a Plan
    #Given the user is on medicare acquisition site landing page
    #  | Site | <site> |
    #And the user hovers screen over the shop for a plan
    #Then the user enters following information in Request Plan Information Guide through Shop Pages
      #| Email | <email> |

    #@requestPlanInformationUlayer @UATRegression @regressionAARP
    #Examples:
    #  | scenario                                       | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname      | Lastname       | email                      |
     # | Request Plan Information - E2E Scenario 3_AARP | AARP | PCP-DSNP-MBI | future   | future   |   10001 | NO              | New York County | SNP      | future   | Test_Portals_J | Test_Portals_K | venkata.kanagala@optum.com |

    #@requestPlanInformationBlayer @UATRegression @regressionUHC
   # Examples:
     # | scenario                                        | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname      | Lastname       | email                      |
     # | Request Plan Information - E2E Scenario 3_UHCMS | UHC  | PCP-DSNP-MBI | future   | future   |   10001 | NO              | New York County | SNP      | future   | Test_Portals_J | Test_Portals_K | venkata.kanagala@optum.com |
 # ------------------ Old pages for Shop for plan and changed to medicare page



  Scenario Outline: <scenario> Verify Request Plan Information through <site> from learn about medicare page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user hovers screen over the learn medicare for a plan
    Then the user enters following information in Request Plan Information Guide through medicare pages
      | Email | <email> |

    @requestPlanInformationUlayer @UATRegression @regressionAARP @nonProd
    Examples: 
      | scenario                                       | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname      | Lastname       | email                      |
      | Request Plan Information - E2E Scenario 3_AARP | AARP | PCP-DSNP-MBI | future   | future   |   10001 | NO              | New York County | SNP      | future   | Test_Portals_J | Test_Portals_K | venkata.kanagala@optum.com |

    @requestPlanInformationBlayer @UATRegression @regressionUHC @nonProd
    Examples: 
      | scenario                                        | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | Firstname      | Lastname       | email                      |
      | Request Plan Information - E2E Scenario 3_UHCMS | UHC  | PCP-DSNP-MBI | future   | future   |   10001 | NO              | New York County | SNP      | future   | Test_Portals_J | Test_Portals_K | prashant_kadus@optum.com |

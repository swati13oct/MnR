#Author:shiva
#created Date:2/12/2019
@testcase @Shopforaplan
Feature: Acq-To test request Mailed information with an agent flow in UHC site (GATED)

  @AARPshopforaplan
  Scenario Outline: Verify tools that help you choose a plan tools from the shop for a plan Drop down from AARP site
    Given the user is on AARP medicare acquisition site landing page
    And the user hovers screen over the shop for a plan drop down in AARP
   

    Examples: 
      | email          | message                                       |
      | test@optum.com | Your guide will arrive in your inbox shortly. |

#Author: namita_meher@optum.com
Feature: Plan Results Page Search Count

  #@uhccp
  Scenario Outline: Plan Results Page - Count of plan results
    Given User is on the UHCCP landing page
    When the user performs plan search in UHCCP homepage 
    	| Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And validates the total number of results displayed on header
    And validates the total count of results from Filter section
    And validates the total count of plan card in default state
    And selects a filter and validates the plan card based on filter 
 
    Examples: 
      | zipcode | isMultiCounty	|	county					|  
     	|	10001		| No						|	New York County	|
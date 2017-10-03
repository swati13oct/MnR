@AcqSEO
@UlayerAcqSEO
Feature:26-Tier2.2-To test 301 redirects in AARP site Ulayer
Scenario Outline:To Verify httpfox should not list more than 3 permanent 301 redirects in AARP site Ulayer
Given load the AARP Ulayer medicare acquisition site page url
|URL|<url>|

Examples:
|url|
|http://awe-stage-aarpmedicareplans.uhc.com//|
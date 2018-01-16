@AcqSEO
@UlayerAcqSEO
Feature:2.02-VBF-Acq-To test 301 redirects in AARP site Ulayer
@AARPloadUrl
Scenario Outline:To Verify httpfox should not list more than 3 permanent 301 redirects in AARP site Ulayer
Given load the AARP Ulayer medicare acquisition site page url
|URL|<url>|

Examples:
|url|
|http://www.ci-aarpmedicareplans.uhc.com//|
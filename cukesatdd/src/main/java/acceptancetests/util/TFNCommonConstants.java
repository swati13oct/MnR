package acceptancetests.util;

import java.util.HashMap;
import java.util.Map;



public class TFNCommonConstants {
	
	public static final String CAMPAIGN_CROSSWALK_FLOW = "campaignCrosswalk";
	public static final String CHANGE_LOCATION_URL = "/change-location.html";
	public static final String CAMPAIGN_CROSSWALK_EXPECTED_OBJ = "campaignCrossWalkExpectedObject";
	public static final String CAMPAIGN_CROSS_WALK_ACTUAl_OBJ = "campaignCrossWalkActualObject";
	public static final Map<String, CampaignPSC> AARP_TFN_ATTRIBUTE_MAP = new HashMap<String, CampaignPSC>();
	public static final Map<String, CampaignPSC> UHC_TFN_ATTRIBUTE_MAP = new HashMap<String, CampaignPSC>();
	public static final String GOOGLE = "google";
	public static final String YAHOO = "yahoo";
	public static final String BING = "bing";
	public static final String NOT_APPLICABLE = "notApplicable";
	public static final String PSC_CODE = "pscCode";
	public static final String SEARCH_ENGINE = "searchEngine";
	public static final String TFN_FLOW_NAME = "tollfreenumber";
	public static final String TFN_ACTUAL = "TFNActual";
	public static final String TFN_EXPECTED = "TFNExpected";
	
	public static String[] source = {GOOGLE, YAHOO, BING,NOT_APPLICABLE};
	public static CampaignPSC[] umsCampaignPSCs = {new CampaignPSC("https://www.google.com", "880188"), new CampaignPSC("https://www.yahoo.com", "880189"), new CampaignPSC("https://www.bing.com", "880187"),new CampaignPSC("https://www.uhcmedicaresolutions.com", "880180")};
	public static CampaignPSC[] aarpCampaignPSCs = {new CampaignPSC("https://www.google.com", "810106"), new CampaignPSC("https://www.yahoo.com", "810105"), new CampaignPSC("https://www.bing.com", "810104"),new CampaignPSC("https://www.aarpmedicareplans.com", "810027")};

	static{
		
		
		for(String seo:source)
		{
			// UMS and AARP CampaignPSCs should always be the same length
			for(int i=0;i<umsCampaignPSCs.length;i++)
			{
				// Fill UMS map
				if(umsCampaignPSCs[i].getReferrer()!=null && umsCampaignPSCs[i].getReferrer().contains(seo))
				{			
					UHC_TFN_ATTRIBUTE_MAP.put(seo, umsCampaignPSCs[i]);
				}
				else
				{
					
					UHC_TFN_ATTRIBUTE_MAP.put(NOT_APPLICABLE, umsCampaignPSCs[i]);
				}
				
				// Fill AARP map
				if(aarpCampaignPSCs[i].getReferrer()!=null && aarpCampaignPSCs[i].getReferrer().contains(seo))
				{			
					AARP_TFN_ATTRIBUTE_MAP.put(seo, aarpCampaignPSCs[i]);
				}
				else
				{
					
					AARP_TFN_ATTRIBUTE_MAP.put(NOT_APPLICABLE, aarpCampaignPSCs[i]);
				}
			}
		}
		

		
	}
	
}

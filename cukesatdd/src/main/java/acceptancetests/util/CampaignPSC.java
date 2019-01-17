package acceptancetests.util;

public class CampaignPSC {

	String referrer;

	String pscCode;

	public CampaignPSC(String referrer, String pscCode) {
		super();
		this.referrer = referrer;
		this.pscCode = pscCode;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getPscCode() {
		return pscCode;
	}

	public void setPscCode(String pscCode) {
		this.pscCode = pscCode;
	}

}

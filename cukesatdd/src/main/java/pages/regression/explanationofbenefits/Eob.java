package pages.regression.explanationofbenefits;

import java.util.List;

public class Eob {
	
	protected String eobDate;
	protected String esp;
	protected String eobType;

	public Eob() {
		this.eobDate="";
		this.esp="";
		this.eobType="";
	}

	public Eob(String eobDate, String esp) {
		this.eobDate=eobDate;
		this.esp=esp;
		this.eobType="";
	}
	
	public Eob(String eobDate, String esp, String eobType) {
		this.eobDate=eobDate;
		this.esp=esp;
		this.eobType=eobType;
	}
	
	public void printDetail() {
		System.out.print("EOB detail");
		System.out.print(":  eobDate="+eobDate);
		System.out.print("|  esp="+esp);
		if (!eobType.equals(""))
			System.out.print("|  eobType="+eobType);
		System.out.println("\n");
	}

	public void printDetail(Eob inputEob) {
		System.out.print("EOB detail");
		System.out.print(":  eobDate="+inputEob.getEobDate());
		System.out.print("|  esp="+inputEob.getEsp());
		if (!inputEob.getEobType().equals(""))
			System.out.print("|  eobType="+inputEob.getEobType());
		System.out.println("\n");
	}

	public String getEobDate() {
		return eobDate;
	}

	public void setEobDate(String eobDate) {
		this.eobDate = eobDate;
	}

	public String getEsp() {
		return esp;
	}

	public void setEsp(String esp) {
		this.esp = esp;
	}
	
	public String getEobType() {
		return eobType;
	}

	public void setEobType(String eobType) {
		this.eobType = eobType;
	}


	
}

package com.citi.viewBean;

public class StockQuote {
	int id;
	float diffper;
	float diff;
	String CName;
	float l_fixN;
	float l_fixB;
	
	public StockQuote(){
		super();
	}
	public StockQuote(int id,String CName, float diffper, float diff, float l_fixN, float l_fixB) {
		// TODO Auto-generated constructor stub
		//super();
		this.id=id;
	this.diffper=diffper;
	this.diff=diff;
	this.CName=CName;
	this.l_fixN=l_fixN;
	this.l_fixB=l_fixB;
	System.out.println("Inside StockQuote()");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//int check;
	public float getDiffper() {
		return diffper;
	}
	public void setDiffper(float diffper) {
		this.diffper = diffper;
	}
	public float getDiff() {
		return diff;
	}
	public void setDiff(float diff) {
		this.diff = diff;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public float getL_fixN() {
		return l_fixN;
	}
	public void setL_fixN(float l_fixN) {
		this.l_fixN = l_fixN;
	}
	public float getL_fixB() {
		return l_fixB;
	}
	public void setL_fixB(float l_fixB) {
		this.l_fixB = l_fixB;
	}


}

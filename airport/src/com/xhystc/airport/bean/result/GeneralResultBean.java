package com.xhystc.airport.bean.result;

import java.io.Serializable;

public class GeneralResultBean implements Serializable
{

	String result;
	String tip;

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public String getTip()
	{
		return tip;
	}

	public void setTip(String tip)
	{
		this.tip = tip;
	}

	public GeneralResultBean(String result,String tip)
	{
		this.result=result;
		this.tip=tip;
	}
	public GeneralResultBean()
	{
		this.result="no";
		tip="unknowerror";
	}
}

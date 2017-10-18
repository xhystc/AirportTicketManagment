package com.xhystc.airport.bean.result.easyui;

import java.util.List;

public class EasyUIResultBean
{
	int total;
	List<Object> rows;

	public EasyUIResultBean(int total, List rows)
	{
		this.total = total;
		this.rows = rows;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public List getRows()
	{
		return rows;
	}

	public void setRows(List rows)
	{
		this.rows = rows;
	}
}

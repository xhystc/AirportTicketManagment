package com.xhystc.airport.test;

import java.util.ArrayList;
import java.util.List;

public class Millionaire
{
	/*static int start = 600000;
	static double p = 0.75;*/
	/*static int m = 3;
	static int n = 1<<m;*/
	static List<Pair> list;
	static
	{
		Pair p1 = new Pair(3,4);
		Pair p2 = new Pair(4,5);
		Pair p3 = new Pair(2,3);

		list = new ArrayList<>(3);
		list.add(p1);
		list.add(p2);
		list.add(p3);


	}
	public static void main(String[] args)
	{


		System.out.println("res:"+solve(3,7));
	}

	static int solve(int n,int w)
	{
		if(n<=0 || w<=0) return 0;
		Pair p = list.get(n-1);
		if(p.getW()>w) return solve(n-1,w);

		int res = Math.max(solve(n-1,w),solve(n,w-p.getW())+p.getV());

		return res;

	}

/*
	static double solve(int m,int target)
	{
		if(target==0) return 1;
		if(m==3 && target>1) return 0;
		int round = Math.min(target,n-target);
		double res=0;
		for(int i=0;i<=round;i++)
		{

			for()
			{
				res = Math.max(res,p*solve(m+1,target-round)+(1-p)*solve(m+1,target+round));
			}
		}

		return res;

	}*/



}










package com.java.algorithm;
/*
 * 一共有n层阶梯，每一次你可以走1或2步求一共有多少种走法
 */
/*
 * 思路：全是1共走m步，全是2走n步，计算从加一个2少两个1，并且为这1找一个地方放置
 */
public class DayTwo {
	public static void main(String[] args) {
		for(int i=0;i<7;i++)
		{
			System.out.println(getStep(i));
		}
	}
	public static int getStep(int result)
	{
		if(result==0)
			return 0;
		int n = result/2;
		if(result%2==1)
		{
			int sum = 1;
			for(int i=0;i<n;i++)
			{
				int twoStep = 1+i;
				int oneStep = result-2*twoStep;
				sum += getC(oneStep,twoStep);
			}
			return sum;
		}
		else
		{
			int sum = 2;
			for(int i=0;i<n-1;i++)
			{
				int twoStep = 1+i;
				int oneStep = result-2*twoStep;
				sum += getC(oneStep,twoStep);
			}
			return sum;
		}
		
	}
	public static int getC(int m, int n)
	{
	   if(m==0 || n==0) return 1;
	   return getC(m-1, n) * (n+m)/m;
	}
}

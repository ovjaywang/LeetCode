package com.wjy.code;
/**
 * 连续整数数组表示股票价格 若只能做一次进一次出最大收益是多少
 * LeetCode-121
 * @author Administrator
 *
 */
public class Best_Time_To_Bug_And_Sell_The_Stock {
    public static int  maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int fuck=0,ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]+fuck>0){
                fuck +=prices[i] - prices[i-1];
                if(fuck > ans)
                	ans = fuck;
            }else{
                fuck = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    	int[] n={7, 6,5,4,3,2,1};
		System.out.println(maxProfit(n));
	}
}

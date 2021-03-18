package com.offer.recurse;


/**
 * 跳台阶问题
	题目描述
	一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级。
	求总共有多少总跳法，并分析算法的时间复杂度。
	https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.05.md
 * @author bupt
 *
 */
public class ClimbStairs {

	/**
	*方法1：递归(斐波那契数列)
	*/
	public static int result[] = {0,1,2};
	public static int climbStairs1(int n){
		if (n <= 2){
			return result[n];
		}
		
		return climbStairs1(n-1) + climbStairs1(n-2);
	}
	/**
	 * 非递归
	 * @return
	 */
	public static int climbStairs2(int n){
		/*int result[] = {0,1,2};
		int sum;
		for (int i = 3; i <= n; ++i){
			sum = result[1] + result[2];
			result[0] = result[1];
			result[1] = result[2];
			result[2] = sum;
		}
		
		return result[2];*/
		//上面是我的代码，下面是别人的，不用分配sum的空间
		int result[] = {1, 1, 0};
		for (int i = 2; i <= n; ++i){
			result[2] = result[0] + result[1];
			result[0] = result[1];
			result[1] = result[2];
		}
		
		return result[2];
	}
	
	public static int climbStairs3(int n) {
        if(n==1)
            return 1;
        if (n==2)
            return 2;
        int a = 1, b = 2, res=0;
       for (int i = 3; i<=n; i++){
           res = a+b;
           a = b;
           b = res;
       }
       
       return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs2(6));
		System.out.println(climbStairs3(6));
	}

}

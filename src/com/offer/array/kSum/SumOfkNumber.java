package com.offer.array.kSum;
/**
 * 	寻找和为定值的多个数
	题目描述
	输入两个整数n和sum，从数列1，2，3.......n 中随意取几个数，使其和等于sum，要求将其中所有的可能组合列出来。
	https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.03.md
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class SumOfkNumber {

	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 100, n = 50;
		sumOfkNumber(sum, n);
	}*/

	public static Stack<Integer> list1 = new Stack<Integer>(); 
	public static void sumOfkNumber(int sum, int n)
	{
	    // 递归出口
	    if (n <= 0 || sum <= 0)
	        return;

	    // 输出找到的结果
	    if (sum == n)
	    {
	        // 反转list
	        //list1.reverse();
	        /*for (list<int>::iterator iter = list1.begin(); iter != list1.end(); iter++)
	            cout << *iter << " + ";
	        cout << n << endl;*/
	    	Collections.reverse(list1);
	    	System.out.println(list1);
	    }
	    
	    list1.push(n);      //典型的01背包问题
	    sumOfkNumber(sum - n, n - 1);   //“放”n，前n-1个数“填满”sum-n
	    list1.pop();
	    sumOfkNumber(sum, n - 1);     //不“放”n，n-1个数“填满”sum
	}
	
	public static List<List<Integer>> threeSum(int[] num){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		helper(0, 3, stack, num, 0, set);
		
		Iterator it = set.iterator();
		while (it.hasNext()){
			list.add((List<Integer>)it.next());
		}
		
		return list;
	}
	public static void helper(int sum, int n, Stack<Integer> s, int[] num, int start, Set<List<Integer>> set){
		if (s.size() == 3 && sum == 0){
			System.out.println(s);
			List<Integer> l = new ArrayList<Integer>(s);
			Collections.sort(l);
			set.add(l);
			return ;
		}
		if (start < num.length){
			s.push(num[start]);
			helper(sum-num[start], n-1, s, num, start+1, set);
			s.pop();
			helper(sum, n, s, num, start+1, set);
		}
	}
	
	public static List<List<Integer>> threeSum2(int[] num){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(num == null || num.length <=2)
			return list;
		
		//先排序
		Arrays.sort(num);
		
		for (int i = num.length-1; i >=2 ; i--){
			if (i < num.length-1 && num[i] == num[i+1])//防重
				continue;
			
			List<List<Integer>> l = twoSum2(num, i-1, 0-num[i]);
			for (List<Integer> t : l){//这里直接填上num[i],因为数组有序
				t.add(num[i]);
			}
			list.addAll(l);
		}
		
		return list;
	}
	//夹逼法求所有非重复序列
	public static List<List<Integer>> twoSum2(int[] numbers, int end, int target){
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		if (numbers == null || end < 1)
			return l;
		
		for (int m = 0, n = end; m < n;){
			if (numbers[m] + numbers[n] == target){
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(numbers[m]);
				t.add(numbers[n]);
				l.add(t);
				m++;
				while (m<n && numbers[m] == numbers[m-1]) m++; //防重
				n--;
				while (m<n && numbers[n] == numbers[n+1]) n--;//防重
			}else if (numbers[m] + numbers[n] < target){
				m++;
			}else {
				n--;
			}
		}
		
		return l;
	}
	
	public static void main(String[] args){
		int[] num = {6,-5,-6,-1,-2,8,-1,4,-10,-8,-10,-2,-4,-1,-8,-2,8,9,-5,-2,-8,-9,-3,-5};
		System.out.println(threeSum(num));
		System.out.println(threeSum2(num));
	}

}

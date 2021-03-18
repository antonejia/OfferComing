package com.offer.BFSDFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;


public class WordLadder {

	 public static int ladderLength(String start, String end, HashSet<String> dict) {
		 if (dict.size() == 0)
         return 0;

		 LinkedList<String> wordQueue = new LinkedList<String>();
	     LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

	     wordQueue.add(start);
	     distanceQueue.add(1);//

	     while(!wordQueue.isEmpty()){
	         String currWord = wordQueue.pop();
	         Integer currDistance = distanceQueue.pop();

/*	         if (currWord.equals(end)){
	        	 return currDistance;
	         }*/
	         for(int i=0; i<currWord.length(); i++){
	             char[] currCharArr = currWord.toCharArray();
	             for(char c='a'; c<='z'; c++){
	                 currCharArr[i] = c;

	                 String newWord = new String(currCharArr);
	                 if(newWord.equals(end)){
	                     return currDistance+1;
	                 }
	                 if(dict.contains(newWord)){
	                     wordQueue.add(newWord);
	                     distanceQueue.add(currDistance+1);
	                     dict.remove(newWord);
	                 }
	             }
	         }
	     }

	     return 0;
     }

	 public int ladderLength2(String start, String end, HashSet<String> dict) {
		    if(start==null || end==null || start.length()==0 || end.length()==0 || start.length()!=end.length())
		        return 0;
		    LinkedList<String> queue = new LinkedList<String>();
		    HashSet<String> visited = new HashSet<String>();
		    int level= 1;
		    int lastNum = 1;//
		    int curNum = 0;//
		    queue.offer(start);
		    visited.add(start);
		    while(!queue.isEmpty())
		    {
		        String cur = queue.poll();
		        lastNum--;
		        for(int i=0;i<cur.length();i++)
		        {
		            char[] charCur = cur.toCharArray();
		            for(char c='a';c<='z';c++)
		            {
		                charCur[i] = c;
		                String temp = new String(charCur);
		                if(temp.equals(end))
		                    return level+1;
		                if(dict.contains(temp) && !visited.contains(temp))
		                {
		                    curNum++;
		                    queue.offer(temp);
		                    visited.add(temp);
		                }
		            }
		        }
		        if(lastNum==0)
		        {
		            lastNum = curNum;
		            curNum = 0;
		            level++;
		        }
		    }
		    return 0;
		}
	/**
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	public static int ladderLength3(String start, String end, HashSet<String> dict) {
		if (start == null || end == null || dict == null || (start != end && dict.size()==0))
			return 0;

		int level = 1;
		HashSet<String> visited = new HashSet<String>();
		LinkedList<String> queue = new LinkedList<String>();
		queue.offer(start);
		int count1 = 1, count2 = 0;
		while (!queue.isEmpty()){
			while (count1 > 0){
				String curString = queue.pop();
				visited.add(curString);

				for (int i = 0; i < curString.length(); i++){
					char[] curChars = curString.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++){
						curChars[i] = ch;
						String tmpString = new String(curChars);
						if (tmpString.equals(end))
							return level+1;
						if (dict.contains(tmpString) && !visited.contains(tmpString)){
							queue.offer(tmpString);
							count2++;
						}
					}
				}

				count1--;
			}

			level++;
			count1 = count2;
			count2 = 0;
		}

		return 0;
	}

	public static int ladderLength4(String start, String end, HashSet<String> dict) {
		if (start == null || end == null || dict == null || (start != end && dict.size()==0))
			return 0;

		int level = 1;
		HashSet<String> visited = new HashSet<String>();
		LinkedList<String> queue = new LinkedList<String>();
		queue.offer(start);
		visited.add(start);//
		int count1 = 1, count2 = 0;
		while (!queue.isEmpty()){
			while (count1 > 0){// 1
				String curString = queue.pop();

				for (int i = 0; i < curString.length(); i++){
					char[] curChars = curString.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++){
						curChars[i] = ch;
						String tmpString = new String(curChars);
						if (tmpString.equals(end))
							return level+1;
						if (dict.contains(tmpString) && !visited.contains(tmpString)){
							queue.offer(tmpString);
							visited.add(tmpString);
							count2++;
						}
					}
				}

				count1--;
			}

			level++;
			count1 = count2;
			count2 = 0;
		}

		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit", end = "cog";
		String[] dictStrings = {"hot", "dot","lot","dog","log"};
		HashSet<String> dict = new HashSet<String>(Arrays.asList(dictStrings));

		System.out.println(ladderLength3(start, end, dict));
	}

}


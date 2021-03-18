package com.offer.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval{
	int start;
	int end;
	Interval(){start = 0; end = 0;}
	Interval(int s, int e){start = s; end = e;}
	
	public String toString(){
		return "["+start +"," + end +"]";
	}
}
public class MergeIntervals {
	/**
	 * 方法1：多次调用insert Intervals
	 * @param intervals
	 * @return
	 */
	public static List<Interval> merge(List<Interval> intervals){
		List<Interval> l = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty())
			return l;
		
		for (Interval interval : intervals){
			l = insert(l, interval);
		}
		return l;
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
		List<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty()){
			res.add(newInterval);
			return res;
		}
		int i = 0, len = intervals.size();
		while (i < len && intervals.get(i).end < newInterval.start){
			res.add(intervals.get(i));
			i++;
		}
		if (i < len){
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
		}
		while (i < len && intervals.get(i).start <= newInterval.end){
			i++;
		}
		if (i-1>=0){
			newInterval.end = Math.max(intervals.get(i-1).end, newInterval.end);
		}
		
		res.add(newInterval);
		while (i < len){
			res.add(intervals.get(i));
			i++;
		}
		return res;
	}
	/**
	 * 方法2：
	 * http://www.programcreek.com/2012/12/leetcode-merge-intervals/
	 * http://blog.csdn.net/linhuanmars/article/details/21857617
	 * @param intervals
	 * @return
	 */
	public static List<Interval> merge2(List<Interval> intervals){
		List<Interval> l = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty())
			return l;
		
		Collections.sort(intervals, new IntervalComparator());
		
		Interval prev = intervals.get(0);
		int i = 1;
		while (i < intervals.size()){
			Interval cur = intervals.get(i);
			if (cur.start <= prev.end){
				prev.end = Math.max(prev.end, cur.end);
				i++;
			}else {
				l.add(prev);
				prev = cur;
				i++;
			}
		}
		l.add(prev);
		
		return l;
	}
	
	static class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start != o2.start){
				return o1.start-o2.start;
			}
			return o1.end - o2.end;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i4 = new Interval(8, 10);
		Interval i5 = new Interval(15, 18);
		
		List<Interval> l = new ArrayList<Interval>();
		l.add(i1);
		l.add(i2);l.add(i4);l.add(i5);
		
		System.out.println(merge(l));
		System.out.println(merge2(l));
	}

}

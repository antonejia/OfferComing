package com.offer.array;

import java.util.ArrayList;
import java.util.List;
/**
 * http://blog.csdn.net/linhuanmars/article/details/22238433
 * @author bupt
 *
 */
public class InsertInterval {

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
		Interval i1 = new Interval(1, 5);
		Interval i2 = new Interval(3, 5);
		Interval i3 = new Interval(6, 7);
		Interval i4 = new Interval(8, 10);
		Interval i5 = new Interval(12, 16);
		
		List<Interval> l = new ArrayList<Interval>();
		l.add(i1);
		//l.add(i2);l.add(i3);l.add(i4);l.add(i5);
		Interval newI = new Interval(0, 0);
		
		List<Interval> newL = insert(l, newI);
		System.out.println(newL);
	}

}

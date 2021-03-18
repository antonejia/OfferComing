package com.offer.thread;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 实现可参考生产者消费者模式：Java编程思想 P709程序
 * 注意点：
 * 1. 多个线程共享同一队列
 * 2. 注意如何同步的：在谁上面synchronized（队列上），在谁上wait，在谁上notifyAll（都是队列上）
 * @author bupt
 *
 */

//线程：爬取单个网页，并解析获取其中的URL
class Gather implements Runnable{
	private Dispather disp;
	public Gather(Dispather disp){
		this.disp = disp;
	}
	
	public void run(){
		try {
			while(true){
				String url;
				boolean flag = false;
				synchronized(disp){
					while(disp.urlList.size() == 0){
						
						disp.wait();//是disp.wait，不是this.wait()
					}
					url = disp.urlList.remove(0);
					
					if (disp.visited.contains(url))//已访问
						flag = true;
				}
				
				if (flag) //flag 为ture，已访问，直接返回
					return;
				
				//爬取url所指网页
				//解析url所指网页中的url，设为 urlListGot
				
				synchronized(disp){
					//将url放入visited
					//将urlListGot放入urlList
					
					//唤醒线程
					disp.notifyAll(); //唤醒所有在disp上等待的线程
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
//多个线程共享的 爬虫队列
class Dispather{
	List<String> urlList; //待爬的url
	HashSet<String> visited; //已爬的url
	
	public Dispather(String initialUrl){ //初始url
		urlList = new LinkedList<String>();
		visited = new HashSet<String>();
		urlList.add(initialUrl);
	}
}

public class Crawl{
	public static void main(String[] args){
		String initialUrl = "www.dddd.com";
		Dispather disp = new Dispather(initialUrl);
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++){
			exec.execute(new Gather(disp)); //所有gather线程共享一个disp
		}
	}
	
}

package com.offer.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
	/**
	 * @param args
	 * @throws IOException 
	 */
/*	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InetAddress addr = InetAddress.getByName(null);
		Socket socket = new Socket(addr, 7777);
		try {
			PrintWriter pw = 
					new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(socket.getOutputStream())), true);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader bReader2 = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while ((line = bReader2.readLine())!=null){
				pw.println(line);
				if ("END".equals(line)){
					break;
				}
				System.out.println(bReader.readLine());
			}
			for (int i = 0; i < 10; ++i){
				pw.println("hello "+ i);
				System.out.println(bReader.readLine());
			}
			pw.println("END");
		}finally{
			socket.close();	
		}

	}*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InetAddress addr = InetAddress.getByName("127.0.0.1");
		Socket socket = new Socket(addr, 7777);
		try {
			OutputStreamWriter outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());
			BufferedWriter bw = new BufferedWriter(outputStreamWriter);
			
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw.write("hello");
			bw.flush();
			
			System.out.println(bReader.readLine());
			
		}finally{
			socket.close();	
		}

	}

}

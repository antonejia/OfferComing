package com.offer.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7777);
			while (true){
				Socket socket = serverSocket.accept();
				//InputStreamReader inputStreamReader =new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String string = null;
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				System.out.println("into");
				/*char chars[] = new char[64];
				int len;
				StringBuilder sb = new StringBuilder();
				while ((len = br.read(chars)) != -1){
					sb.append(new String(chars, 0, len));
					System.out.println(sb.toString());
				}
				System.out.println(sb.toString());*/
				string = br.readLine();
				System.out.println(string);
				bw.write("server: " + string);
				bw.flush();
				
			//	br.close();
				bw.close();
				socket.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	

	}
/*	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(7777);
		try {
			Socket socket = serverSocket.accept();
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
				while(true){
					String string = br.readLine();
					if ("END".equals(string)){
						break;
					}
					System.out.println("echoing " + string);
					pw.println(string);
				}
			}finally{
				System.out.println("closing");
				socket.close();
			}
			
		}finally{
			serverSocket.close();
		}
		

	}*/

}

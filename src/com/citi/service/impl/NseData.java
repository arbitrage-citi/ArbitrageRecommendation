package com.citi.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class NseData {
	public static void nse() {
        try {
        	//String [] symbols={"RELIANCE", "ACC"};
           // URL url = new URL("http://www.google.com/finance/getprices?q=NIFTY&x=NSE&i=60&p=15d&f=n,d,o,h,l,c,v");
        	URL urlN = new URL("http://finance.google.com/finance/info?client=ig&q=NSE:ACC,NSE:AICHAMP,NSE:VAIBHAVGBL,NSE:BEARDSELL,NSE:DELTAMAGNT,NSE:KDDL&i=86400&p=1d&f=d");
        	//URL urlB = new URL("http://finance.google.com/finance/info?client=ig&q=BOM:500410,BOM:532806,BOM:532156&i=86400&p=1d&f=d");

        	// URL url = new URL("http://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol=INFY&illiquid=0");
        	//URL url = new URL("http://www.moneycontrol.com/stocks/marketstats/nsehigh");

            URLConnection urlNConn = urlN.openConnection();
            //URLConnection urlBConn = urlB.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlNConn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            File file = new File("outN.txt"); //Your file for nse data
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            while ((line = bufferedReader.readLine()) != null) {
            	if(line.contains("//"))
            		{
            		line=line.replace("//", "");
            		}
              
                ps.println(line);

            }
            

                        
            ps.close();
            bufferedReader.close();
            inputStreamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   

}

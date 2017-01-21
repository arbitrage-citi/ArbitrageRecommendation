package com.citi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


import com.citi.viewBean.StockQuote;
import com.citi.exception.StockNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class StockService {

	static HashMap<Integer, StockQuote> stockIdMap = getStockIdMap();
	static HashMap<Integer, StockQuote> savedStockIdMap = getSavedStockIdMap();

	public StockService() {
		super();
		BseData.bse();

		// google_finance.gfinance.nseData nd = new
		// google_finance.gfinance.nseData();
		NseData.nse();

		int i = 1, j = 1;
		float[] diffper = new float[51];
		float[] diff = new float[51];
		String[] CName = new String[51];
		CName[1] = "ACC Cement";
		CName[2] = "AI Champdany";
		CName[3] = "Vaibhav Global";
		CName[4] = "Beardsell";
		CName[5] = "Delta Magnet";
		CName[6] = "KDDL";

		float[] l_fixN = new float[51];
		float[] l_fixB = new float[51];

		JSONParser parser = new JSONParser();
		JSONObject stockB, stockN;
		JSONArray jsonArrayN;
		try {
			jsonArrayN = (JSONArray) parser.parse(new FileReader("outN.txt"));
		
		JSONArray jsonArrayB = (JSONArray) parser.parse(new FileReader("outB.txt"));

		for (Object oN : jsonArrayN) {
			stockN = (JSONObject) oN;

			float l_fix1 = Float.parseFloat((String) stockN.get("l_fix"));

			j = 1;
			for (Object oB : jsonArrayB) {
				stockB = (JSONObject) oB;
				float l_fix2 = Float.parseFloat((String) stockB.get("l_fix"));

				if (i == j) {
					diff[i] = Math.abs(l_fix1 - l_fix2);
					diffper[i] = ((diff[i] / l_fix1) * 100);

					if (l_fix1 >= 20 && l_fix2 >= 20 && diffper[i] >= 2) {
						l_fixN[i] = l_fix1;
						l_fixB[i] = l_fix2;
						if (l_fix1 > l_fix2) {
							System.out.println("Arbitrage opportunity exists! Sell at NSE. Buy at BSE");
							System.out.println(stockN.get("t"));

							break;
						} else if (l_fix1 < l_fix2) {

							System.out.println(stockN.get("t"));

							System.out.println("Arbitrage opportunity exists! Sell at BSE. Buy at NSE");
							break;

						}
					} else {
						l_fixN[i] = -99999;
						l_fixB[i] = -99999;

					}
				}
				j++;

			}
			i++;
		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (stockIdMap == null) {
			stockIdMap = new HashMap<Integer, StockQuote>();

			for ( i = 1; i <= 10; i++) {

				// System.out.println(Float.toString(diffper[i]));
				// Creating some object of stocks while initializing

				StockQuote indiaStock = new StockQuote(i, CName[i], diffper[i], diff[i], l_fixN[i], l_fixB[i]);
			//	 StockQuote indiaStock = new StockQuote(i,"ACC", 1f, 2f, 3f, 4f);

				System.out.println(indiaStock.getDiff());
				System.out.println(indiaStock.getCName());
				System.out.println(indiaStock.getDiffper());
				System.out.println("After new StockQuote()");
				stockIdMap.put(i, indiaStock);
				System.out.println("HI" + stockIdMap.values());

			}
		}
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public List<StockQuote> getAllStocks() {
		List<StockQuote> stocks = new ArrayList<StockQuote>(stockIdMap.values());
		return stocks;
	}

	public StockQuote getStock(int id) {
		StockQuote stock = stockIdMap.get(id);

		if (stock == null) {
			throw new StockNotFoundException("Stock with id " + id + " not found");
		}
		return stock;
	}

	public StockQuote addStock(StockQuote stock) {
		stock.setId(getMaxId() + 1);
		stockIdMap.put(stock.getId(), stock);
		return stock;
	}

	public StockQuote updateStock(StockQuote stock) {
		if (stock.getId() <= 0)
			return null;
		stockIdMap.put(stock.getId(), stock);
		return stock;

	}
	public static HashMap<Integer, StockQuote> getStockIdMap() {
		return stockIdMap;
	}

	// Utility method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : stockIdMap.keySet()) {
			if (max <= id)
				max = id;

		}

		return max;

	}
	
	public StockQuote saveStock(int id) {
		StockQuote savedStock = stockIdMap.get(id);
		savedStock.setId(getSavedMaxId() + 1);
		savedStockIdMap.put(savedStock.getId(), savedStock);
		return savedStock;
	}

	public static HashMap<Integer, StockQuote> getSavedStockIdMap() {
		return savedStockIdMap;
	}

	// Utility method to get max id
	public static int getSavedMaxId() {
		int max = 0;
		for (int id : savedStockIdMap.keySet()) {
			if (max <= id)
				max = id;

		}

		return max;

	}
	
	public List<StockQuote> getAllSavedStocks() {
		List<StockQuote> savedStocks = new ArrayList<StockQuote>(savedStockIdMap.values());
		return savedStocks;
	}
}



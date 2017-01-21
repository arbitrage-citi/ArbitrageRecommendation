package com.citi.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.citi.viewBean.StockQuote;
import com.citi.service.impl.StockService;
import org.json.simple.parser.ParseException;

@Path("/stocks")
public class StockController {
	
	StockService ss = new StockService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StockQuote> getStocks() {
		List<StockQuote> listOfStocks = ss.getAllStocks();
		return listOfStocks;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public StockQuote getStockById(@PathParam("id") int id) {
		return ss.getStock(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public StockQuote addStock(StockQuote stock) {
		return ss.addStock(stock);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public StockQuote updateStock(StockQuote stock) {
		return ss.updateStock(stock);

	}

	@PUT
	@Path("/saved")
	@Produces(MediaType.APPLICATION_JSON)
	public StockQuote saveStock(@PathParam("id") int id) {
		
		return ss.saveStock(id);

	}
	@GET
	@Path("/saved/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public StockQuote getSavedStockById(@PathParam("id") int id) {
		return ss.getStock(id);
	}
	

}

package com.jpmorgan.report;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.model.Trade;
import com.jpmorgan.utils.CreateTrades;

public class TradeReportTest extends CreateTrades{

	private TradeReport tradereport;
	private List<Trade> trades; 
	
	@Before
	public void setUp() throws Exception {		
		tradereport = new TradeReport();
		trades = createTrades();
	}

	@Test
	public void testGenerateReport() {
		tradereport.generateReport(trades);
	}

}

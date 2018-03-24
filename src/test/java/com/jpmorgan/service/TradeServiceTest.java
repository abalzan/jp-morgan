package com.jpmorgan.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.util.Currency;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.model.Trade;
import com.jpmorgan.model.Transaction;
import com.jpmorgan.utils.CreateTrades;

public class TradeServiceTest extends CreateTrades{

	private TradeService tradeService;
	private List<Trade> trades; 
	
	@Before
	public void setUp() throws Exception {		
		tradeService = new TradeService();
		trades = createTrades();
	}

	@Test
	public void testGetWorkingDays() {
		tradeService.getWorkingDays(trades);
		
		assertEquals(trades.get(0).getSettlementDate().getDayOfWeek(), DayOfWeek.MONDAY);
		assertEquals(trades.get(1).getSettlementDate().getDayOfWeek(), DayOfWeek.SUNDAY);
		
	}

	@Test
	public void testGetBuyTransactions() {
		List<Trade> buyTransactions = tradeService.getBuyTransactions(trades);
		
		for (Trade trade : buyTransactions) {
			assertEquals(trade.getTransactionType(), Transaction.B);
		}
	}

	@Test
	public void testGetSellTransactions() {
		List<Trade> sellTransactions = tradeService.getSellTransactions(trades);
		
		for (Trade trade : sellTransactions) {
			assertEquals(trade.getTransactionType(), Transaction.S);
		}
	}
	
	@Test
	public void testGetDailyTransactions() {
		
		List<Trade> dailyTransactions = tradeService.getDailyTransactions(trades);
		
		assertEquals(6, dailyTransactions.size());
		
		for (Trade trade : dailyTransactions) {
			assertFalse(trade.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SATURDAY));
			
			if(trade.getCurrency().equals(Currency.getInstance("AED")) || trade.getCurrency().equals(Currency.getInstance("SAR"))) {
				assertFalse(trade.getSettlementDate().getDayOfWeek().equals(DayOfWeek.FRIDAY));	
			}else {
				assertFalse(trade.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SUNDAY));
			}
		}
	}

	@Test
	public void testCalculateAmount() {
		BigDecimal calculateAmount = new BigDecimal(0);
		for (Trade trade : trades) {
			BigDecimal expected = trade.getAgreedFx().multiply(trade.getUnitPrice()).multiply(BigDecimal.valueOf(trade.getUnit())).setScale(2, RoundingMode.HALF_EVEN);
			 
			calculateAmount = tradeService.calculateAmount(trade);
			assertEquals(expected, calculateAmount);
		}		
	}
}

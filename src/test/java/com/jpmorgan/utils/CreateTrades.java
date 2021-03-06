package com.jpmorgan.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import com.jpmorgan.model.Trade;
import com.jpmorgan.model.Transaction;

public class CreateTrades {

	public List<Trade> createTrades() {
		List<Trade> trades = new ArrayList<>();
		
		trades.add(new Trade("FOO", Transaction.B, new BigDecimal(0.5), Currency.getInstance("GBP"), LocalDate.of(2018, 3, 24),
				LocalDate.of(2018, 3, 26), 200L, new BigDecimal(100.25)));
		
		trades.add(new Trade("AED", Transaction.S, new BigDecimal(0.2), Currency.getInstance("AED"), LocalDate.of(2018, 3, 23),
				LocalDate.of(2018, 3, 25), 450L, new BigDecimal(150.5)));
		
		trades.add(new Trade("BAR", Transaction.S, new BigDecimal(0.23), Currency.getInstance("EUR"), LocalDate.of(2018, 3, 25),
				LocalDate.of(2018, 3, 26), 200L, new BigDecimal(100.25)));
		
		trades.add(new Trade("AED", Transaction.B, new BigDecimal(0.2), Currency.getInstance("AED"), LocalDate.of(2018, 3, 24),
				LocalDate.of(2018, 3, 25), 450L, new BigDecimal(150.5)));
		
		trades.add(new Trade("FOO", Transaction.B, new BigDecimal(0.5), Currency.getInstance("GBP"), LocalDate.of(2018, 3, 26),
				LocalDate.of(2018, 3, 26), 200L, new BigDecimal(100.25)));
		
		trades.add(new Trade("AED", Transaction.B, new BigDecimal(0.2), Currency.getInstance("SAR"), LocalDate.of(2018, 3, 25),
				LocalDate.of(2018, 3, 25), 450L, new BigDecimal(150.5)));
		
		return trades;
	}
}

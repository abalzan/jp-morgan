package com.jpmorgan.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

import com.jpmorgan.model.Trade;
import com.jpmorgan.model.Transaction;

public class TradeService extends WorkingDays {

	public void getWorkingDays(List<Trade> trades) {

		WorkingDays workingDays = new WorkingDays();
		
		trades.stream()
				.filter(trade -> trade.getCurrency().equals(Currency.getInstance("AED")) || trade.getCurrency().equals(Currency.getInstance("SAR")))
				.forEach(trade -> workingDays.fillArabicSettlementDate(trade));

		trades.stream()
				.filter(trade -> !trade.getCurrency().equals(Currency.getInstance("AED")) && !trade.getCurrency().equals(Currency.getInstance("SAR")))
				.forEach(trade ->workingDays.fillDefaultSettlementDate(trade));
	}

	public List<Trade> getBuyTransactions(List<Trade> trades) {
		return trades.stream().filter(trade -> trade.getTransactionType().equals(Transaction.B))
				.collect(Collectors.toList());
	}

	public List<Trade> getSellTransactions(List<Trade> trades) {
		return trades.stream().filter(trade -> trade.getTransactionType().equals(Transaction.S))
				.collect(Collectors.toList());
	}

	public List<Trade> getDailyTransactions(List<Trade> trades) {
		return trades.stream().sorted(Comparator.comparing(Trade::getSettlementDate).reversed())
				.collect(Collectors.toList());
	}
	
	public BigDecimal calculateAmount(Trade trade) {
		return trade.getAgreedFx().multiply(trade.getUnitPrice())
				.multiply(BigDecimal.valueOf(trade.getUnit())).setScale(2, RoundingMode.HALF_EVEN);
	}

}

package com.jpmorgan.report;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jpmorgan.model.Trade;
import com.jpmorgan.model.Transaction;
import com.jpmorgan.service.TradeService;

public class TradeReport extends TradeService{


	Comparator<Trade> TOTAL_AMOUNT = Comparator.comparing(Trade::getTotalAmount);
	Comparator<Trade> TRADE_DATE = Comparator.comparing(Trade::getSettlementDate);
	
	public void generateReport(List<Trade> trades){
		this.getWorkingDays(trades);
		
		for (Trade trade : trades) {
			BigDecimal calculateAmount = this.calculateAmount(trade);
			trade.setTotalAmount(calculateAmount);
		}
		
		List<Trade> buyTransactions = this.getBuyTransactions(trades);
		printReport(sortTransactions(buyTransactions));
		
		List<Trade> sellTransactions = this.getSellTransactions(trades);
		printReport(sortTransactions(sellTransactions));
		
	}

	public List<Trade> sortTransactions(List<Trade> transactions) {
		this.getDailyTransactions(transactions);
		transactions.sort(Collections.reverseOrder(TOTAL_AMOUNT));
		transactions.sort(Collections.reverseOrder(TRADE_DATE));
		
		return transactions;
	}
	
	public void printReport(List<Trade> listTrades) {
				
		if(listTrades.get(0).getTransactionType().equals(Transaction.B)) {
			System.out.println("=======================================BUY TRANSACTIONS===============================================");	
		}else {
			System.out.println("=======================================SELL TRANSACTIONS==============================================");
		}

		listTrades.forEach(trade -> System.out.println(trade.toString()));
		
		System.out.println();
	}

}

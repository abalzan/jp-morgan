package com.jpmorgan.service;

import java.time.DayOfWeek;
import java.time.LocalDate;

import com.jpmorgan.model.Trade;

public class WorkingDays {
	
	public Trade fillArabicSettlementDate(Trade trade) {
		
		LocalDate settlementDate = trade.getInstructionDate();
		
		if(DayOfWeek.FRIDAY.equals(trade.getInstructionDate().getDayOfWeek())) {
			trade.setSettlementDate(settlementDate.plusDays(2));
		}else if(DayOfWeek.SATURDAY.equals(trade.getInstructionDate().getDayOfWeek())) {
			trade.setSettlementDate(settlementDate.plusDays(1));
		}else {
			trade.setSettlementDate(settlementDate);
		}
		
		return trade;
	}
	
	public Trade fillDefaultSettlementDate(Trade trade) {
		
		LocalDate settlementDate = trade.getInstructionDate();
		
		if(DayOfWeek.SATURDAY.equals(trade.getInstructionDate().getDayOfWeek())) {
			trade.setSettlementDate(settlementDate.plusDays(2));
		}else if(DayOfWeek.SUNDAY.equals(trade.getInstructionDate().getDayOfWeek())) {
			trade.setSettlementDate(settlementDate.plusDays(1));
		}else {
			trade.setSettlementDate(settlementDate);
		}
		
		return trade;
	}
}

package com.jpmorgan.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

public class Trade {

	private String entity;
	private Transaction transactionType;
	private BigDecimal agreedFx;
	private Currency currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private long unit;
	private BigDecimal unitPrice;
	private BigDecimal totalAmount;

	public Trade(String entity, Transaction transactionType, BigDecimal agreedFx, Currency currency,
			LocalDate instructionDate, LocalDate settlementDate, long unit, BigDecimal unitPrice) {
		this.entity = entity;
		this.transactionType = transactionType;
		this.agreedFx = agreedFx.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.unit = unit;
		this.unitPrice = unitPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Transaction getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Transaction transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public long getUnit() {
		return unit;
	}

	public void setUnit(long unit) {
		this.unit = unit;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Trade [entity=" + entity + ", transactionType=" + transactionType + ", agreedFx=" + agreedFx
				+ ", currency=" + currency + ", instructionDate=" + instructionDate + ", settlementDate="
				+ settlementDate + ", unit=" + unit + ", unitPrice=" + unitPrice + ", totalAmount=" + totalAmount + "]";
	}
	
}

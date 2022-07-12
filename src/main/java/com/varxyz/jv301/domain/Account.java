package com.varxyz.jv301.domain;

import java.util.Date;

public abstract class Account {
	protected long aid;
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	protected Date regDate;
	protected char accountType;

	public Account() {
		
	}
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	public void deposite(double amount) {
		this.balance += amount;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", accountNum=" + accountNum 
				+ ", balance=" + balance + ", customer=" + customer
				+ ", regDate=" + regDate + "]";
	}
	
	
}

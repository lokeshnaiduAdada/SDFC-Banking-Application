package com.web.service;

import com.web.entity.Sdfc_Banking;

public interface BankService {

	public Sdfc_Banking createAccount(Sdfc_Banking bank);
	public Sdfc_Banking checkBalance(long accNo);
	public Sdfc_Banking depositBalance(long accNo,double amt);
	public Sdfc_Banking withdrawBalance(long accNo,double amt);
	public Sdfc_Banking transferBalance(Sdfc_Banking bank,long accNo);
	public Sdfc_Banking closeAccount(long accNO);
	public Sdfc_Banking saveBalance(Sdfc_Banking bank);

}

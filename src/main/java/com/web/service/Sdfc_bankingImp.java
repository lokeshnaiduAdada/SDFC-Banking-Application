package com.web.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.Sdfc_Banking;
import com.web.repo.BankRepo;
@Service
public class Sdfc_bankingImp implements BankService {

	@Autowired
	private BankRepo repo;
	
	@Override
	public Sdfc_Banking createAccount(Sdfc_Banking bank) {
		repo.save(bank);
		return bank;
	}

	@Override
	public Sdfc_Banking checkBalance(long accNo) {
		Sdfc_Banking bank=repo.findById(accNo).get();
		return bank;
	}

	@Override
	public Sdfc_Banking depositBalance(long accNo,double amt) {
		double a=0.0;
		Sdfc_Banking bank=repo.findById(accNo).get();
		a=amt+bank.getAmount();
		bank.setAmount(a);
		return bank;
	}

	@Override
	public Sdfc_Banking withdrawBalance(long accNo,double amt) {
		double a=0.0;
		Sdfc_Banking bank=repo.findById(accNo).get();
		if(bank.getAmount()>amt)
		{
			a=bank.getAmount()-amt;
			bank.setAmount(a);
			return bank;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Sdfc_Banking transferBalance(Sdfc_Banking bank, long accNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sdfc_Banking closeAccount(long accNO) {
		Sdfc_Banking bank=repo.findById(accNO).get();
		bank.setStatus(1);
		return bank;
	}

	@Override
	public Sdfc_Banking saveBalance(Sdfc_Banking bank) {
		repo.save(bank);
		return null;
	}

	

}

package com.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.entity.Sdfc_Banking;
import com.web.service.Sdfc_bankingImp;
@Controller
public class Mycontroller {
	@Autowired
	private Sdfc_bankingImp service;
	@RequestMapping("/")
	public String homePage()
	{
		return "home";
	}
	@RequestMapping("/newaccount")
	public String newAccount()
	{
		return "newacc";
	}
	@RequestMapping("/register")
	public String registerPage(Sdfc_Banking bank,@RequestParam String password,@RequestParam String confirmPassword)
	{
		if(password.equals(confirmPassword))
		{
		service.createAccount(bank);
		return "success";
		}
		else
			return "password";
	}
	@RequestMapping("/balance")
	public String balancePage()
	{
		return "balance";
	}
	@RequestMapping("/checkbal")
	public String checkBal(ModelMap model,@RequestParam long accNo,@RequestParam String name,@RequestParam String password)
	{
		Sdfc_Banking bank=service.checkBalance(accNo);
		model.put("users", bank);
		if(bank.getAccNo()==accNo && bank.getName().equals(name) && bank.getPassword().equals(password))
		{
			if(bank.getStatus()==0)
			{
				return "bal";
			}
			else
				return "status";
		}
		else
		{
		return "error";
		}	
	}
	@RequestMapping("/deposit")
	public String depositForm()
	{
		return "deposit";
	}
	
	@RequestMapping("/depositamt")
	public String depositPage(ModelMap model,@RequestParam int accNo,@RequestParam String name,@RequestParam String password,@RequestParam double amt)
	{
		Sdfc_Banking bank=service.depositBalance(accNo, amt);
		model.put("users", bank);
		if(bank.getAccNo()==accNo && bank.getName().equals(name) && bank.getPassword().equals(password))
		{
			if(bank.getStatus()==0)
			{
				service.saveBalance(bank);
				return "bal";
			}
			else
				return "status";
		}
		else
		{
		return "error";
		}		
	}
	@RequestMapping("/withdraw")
	public String withdrawForm()
	{
		return "withdraw";
	}
	@RequestMapping("/withdrawamt")
	public String withdrawPage(ModelMap model,@RequestParam int accNo,@RequestParam String name,@RequestParam String password,@RequestParam double amt)
	{
		Sdfc_Banking bank=service.withdrawBalance(accNo, amt);
		model.put("users", bank);
		if(bank.getAccNo()==accNo && bank.getName().equals(name) && bank.getPassword().equals(password))
		{
			if(bank.getStatus()==0)
			{
				if(bank!=null)
				{
					service.saveBalance(bank);
					return "bal";
				}
				else
					return "status";
				}
			else
			{
				return "insuff";
			}
		}
		else
		{
		return "error";
		}
		}
	@RequestMapping("/transfer")
	public String transferForm()
	{
		return "transfer";
	}
	@RequestMapping("/transferamt")
	public String transferAmount(ModelMap model,@RequestParam int accNo,@RequestParam int taccNo,@RequestParam String name,@RequestParam String password,@RequestParam double amt)
	{
		Sdfc_Banking b1=service.withdrawBalance(accNo, amt);
		Sdfc_Banking b2=service.depositBalance(taccNo, amt);
		model.put("user1", b1);
		model.put("user2", b2);
		if(b1.getName().equals(name) && b1.getPassword().equals(password) && b1.getAmount()>amt)
		{
			service.saveBalance(b1);
			service.saveBalance(b2);
			return "trans";
		}
		else
			return "error";
		
	}
	@RequestMapping("/aboutus")
	public String aboutUsPage()
	{
		return "aboutus";
	}
	@RequestMapping("/closeacc")
	public String closeAccForm()
	{
		return "closeacc";
	}
	@RequestMapping("/close")
	public String closePage(@RequestParam int accNo,@RequestParam String name,@RequestParam String password,ModelMap model)
	{
		Sdfc_Banking b1=service.closeAccount(accNo);
		if(b1.getName().equals(name) && b1.getPassword().equals(password))
		{
			service.saveBalance(b1);
			return "status";
		}
		else
			return "error";
		
	}

}

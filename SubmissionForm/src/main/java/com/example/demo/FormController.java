package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class FormController {
   
	@Autowired
	 CustomersRepo repo;
	@RequestMapping("/")
	public String details() {
		
		return "dada";
	}
	
	@RequestMapping("details")
	public String details(Customers customers) {
		
		repo.save(customers);
		
	
		return "dada";
	}
	
	@RequestMapping("getdetail")
	public String getdetail() {
		
		
		return "ViewCustomer";
	}

@PostMapping("/getdetail")
public ModelAndView getdetails(@RequestParam int cid)
{
		ModelAndView mv = new ModelAndView("retrive");
		Customers customers = repo.findById(cid).orElse(null);
		mv.addObject(customers);
		return mv;


}
}
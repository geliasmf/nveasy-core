package app.nveasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.nveasy.entity.Investment;
import app.nveasy.service.InvestmentService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/investments")
public class InvestmentController {
	@Autowired
	InvestmentService investmentService;
	
	@GetMapping("/findAll")
	public List<Investment> getAllInvestment(){
		return investmentService.findAll();
	}
	
	@PostMapping("/create")
    public Investment create(@RequestBody Investment investment) {
        return investmentService.create(investment);
    }
	
	@PutMapping("/update")
    public Investment update(Investment investment) {
        return investmentService.update(investment);
    }
	
	@DeleteMapping("/delete/{id}")
    public Investment delete(@PathVariable("id") Long id) {
        return investmentService.delete(id);
    }
}

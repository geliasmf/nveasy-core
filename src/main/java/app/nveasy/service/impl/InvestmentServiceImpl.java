package app.nveasy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.nveasy.entity.Investment;
import app.nveasy.repository.InvestmentRepository;
import app.nveasy.service.InvestmentService;

@Service
public class InvestmentServiceImpl implements InvestmentService {
	@Autowired
	InvestmentRepository investmentRepo;

	@Override
	public Investment create(Investment investment) {
		return investmentRepo.save(investment);
	}

	@Override
	public List<Investment> findAll() {
		return investmentRepo.findAll();
	}

	@Override
	public Investment update(Investment investment) {
		return investmentRepo.save(investment);
	}

	@Override
	public Optional<Investment> findBy(Long id) {
		return investmentRepo.findById(id);
	}

	@Override
	public Investment delete(Long id) {
		if (investmentRepo.existsById(id)) {
			Investment investment = investmentRepo.findById(id).get();
			investmentRepo.delete(investment);
			return investment;
		} else {
			throw new RuntimeException("Investment no encontrado");
		}
	}

}

package app.nveasy.service;

import java.util.List;
import java.util.Optional;

import app.nveasy.entity.Investment;

public interface InvestmentService {
	Investment create(Investment investment);
	List<Investment> findAll();
	Investment update(Investment investment);
	Investment delete(Long id);
	Optional<Investment> findBy(Long id);
}

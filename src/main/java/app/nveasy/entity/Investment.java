package app.nveasy.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Investment")
public class Investment {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String company;
    private double amount;
    private int term;
    private LocalDate maturityDate;
    @Column(name = "monthlyReturn")
    private boolean monthlyReturn;
	
    
    public Investment() {
	}

	public Investment(Long id, String company, double amount, int term, LocalDate maturityDate, boolean monthlyReturn) {
		super();
		this.id = id;
		this.company = company;
		this.amount = amount;
		this.term = term;
		this.maturityDate = maturityDate;
		this.monthlyReturn = monthlyReturn;
	}
    
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}
	/**
	 * @return the maturityDate
	 */
	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	/**
	 * @return the monthlyReturn
	 */
	public boolean isMonthlyReturn() {
		return monthlyReturn;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
	}
	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	/**
	 * @param monthlyReturn the monthlyReturn to set
	 */
	public void setMonthlyReturn(boolean monthlyReturn) {
		this.monthlyReturn = monthlyReturn;
	}
	
}

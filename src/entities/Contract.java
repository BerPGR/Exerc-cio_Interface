package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	
	private int number;
	private Date date;
	private double totalValue;
	
	private List<Installment> installments = new ArrayList<>();
	
	public Contract() {
	}
	
	public Contract(int number, Date date, double totalValue) {
		this.setNumber(number);
		this.setDate(date);
		this.setTotalValue(totalValue);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void addInstallments(Installment instal) {
		installments.add(instal);
	}
	
	public void removeInstallments(Installment instal) {
		installments.remove(instal);

	}
	
	
}

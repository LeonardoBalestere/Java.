package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dueDate;
	private double ammount;
	
	public Installment() {
	}

	public Installment(Date dueDate, double ammount) {
		this.dueDate = dueDate;
		this.ammount = ammount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	@Override
	public String toString() {
		return sdf.format(dueDate)
			 + " - "
			 + String.format("%.2f", ammount);
	}
	
	
}

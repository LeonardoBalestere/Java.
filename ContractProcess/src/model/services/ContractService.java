package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private PaymentServices paymentService;
	
	public ContractService(PaymentServices paymentServices) {
		this.paymentService = paymentServices;
	}
	
	public void processContract(Contract contract, int month) {
		double paymentPerMonth = contract.getTotalValue() / month;
		for (int i = 0; i < month; i++) {
			double valueCalculated = paymentPerMonth + paymentService.interest(paymentPerMonth, (i + 1));
			double totalValueCalculated = valueCalculated + paymentService.paymentFee(valueCalculated);
			Date dueDate = monthCalculated(contract.getDate(), (i + 1));
			contract.getInstallments().add(new Installment(dueDate, totalValueCalculated));
		}
	}
	
	private Date monthCalculated(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}
}

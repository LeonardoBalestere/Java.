package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private double pricePerHour;
	private double pricePerDay;

	private TaxServices taxServices;

	public RentalService() {
	}

	public RentalService(double pricePerHour, double pricePerDay, TaxServices taxServices) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxServices = taxServices;
	}

	public void processInvoice(CarRental carRental) {
		long starttime = carRental.getStart().getTime();
		long finishtime = carRental.getFinish().getTime();
		double hours = (double) (finishtime - starttime) / 1000 / 60 / 60;

		double basicpayment;
		if (hours <= 12.0) {
			basicpayment = pricePerHour * Math.ceil(hours);
		} else {
			basicpayment = pricePerDay * Math.ceil(hours / 24);
		}

		double tax = taxServices.tax(basicpayment);

		carRental.setInvoice(new Invoice(basicpayment, tax));
	}
}

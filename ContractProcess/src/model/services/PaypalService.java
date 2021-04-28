package model.services;

public class PaypalService implements PaymentServices{

	@Override
	public Double paymentFee(Double ammount) {
		ammount *= 0.02;
		return ammount ;
	}

	@Override
	public Double interest(Double ammount, int month) {
		ammount *= (double) month * 0.01;
		return ammount;
	}

	
}

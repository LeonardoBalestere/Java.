package model.services;

public interface PaymentServices {

	public Double paymentFee(Double ammount);
	public Double interest(Double ammount, int month);
}

package entities;

public class OutSoucedEmployee extends Employee{
	
	private Double additionalCharge;
	
	public OutSoucedEmployee() {
		super();
	}
	
	public OutSoucedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}
	
	public Double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	
	@Override
	public Double payment() {
		return super.payment() + getAdditionalCharge() *1.1;
	}
}

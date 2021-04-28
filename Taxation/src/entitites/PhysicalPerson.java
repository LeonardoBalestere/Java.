package entitites;

public class PhysicalPerson extends Person {
	
	private double healthExpenditure;

	public PhysicalPerson() {
		super();
	}
	
	public PhysicalPerson(String name, Double annualIncome, double healthExpenditure) {
		super(name, annualIncome);
		this.healthExpenditure = healthExpenditure;
	}

	public double getHealthExpenditure() {
		return healthExpenditure;
	}

	public void setHealthExpenditure(double healthExpenditure) {
		this.healthExpenditure = healthExpenditure;
	}

	@Override
	public double taxToPay() {
		if(healthExpenditure == 0) {
			if(getAnualIncome() < 20000.00) {
				return getAnualIncome() * 0.15;
			}
			else {
				return getAnualIncome() * 0.25;
			}
		}
		else {
			if(getAnualIncome() < 20000.00) {
				return (getAnualIncome() * 0.15) - (healthExpenditure * 0.5);
			}
			
			else {
				return (getAnualIncome() * 0.25) - (healthExpenditure * 0.5);
			}
		}
	}

}

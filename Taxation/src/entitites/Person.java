package entitites;

public abstract class Person {
	
	private String name;
	private Double anualIncome;
	
	Person(){
	}

	public Person(String name, Double annualIncome) {
		this.name = name;
		this.anualIncome = annualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnualIncome() {
		return anualIncome;
	}

	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}
	
	public abstract double taxToPay();

	@Override
	public String toString() {
		return name
			 + ": $ "
			 + String.format("%.2f", taxToPay());
	}
	
	
}

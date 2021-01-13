package entities;

public class Individual extends TaxPayer {
	private double healthExpendures;

	public Individual(String name, Double annualIncome, double healthExpendures) {
		super(name, annualIncome);
		this.healthExpendures = healthExpendures;
	}

	public double getHealthExpendures() {
		return healthExpendures;
	}

	public void setHealthExpendures(double healthExpendures) {
		this.healthExpendures = healthExpendures;
	}

	@Override
	public double tax() {
		if (getAnnualIncome() < 20000.0) {
			return getAnnualIncome() * 0.15 - healthExpendures * 0.5;
		} else {
			return getAnnualIncome() * 0.25 - healthExpendures * 0.5;
		}
	}
}

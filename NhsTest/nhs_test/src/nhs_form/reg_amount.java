package nhs_form;

public class Reg_amount {
	private String name;
	private String amount;
	private Frequency frequency;
	
	public Reg_amount(String pName, String pAmount, Frequency pFrequency){
		name = pName;
		amount = pAmount;
		frequency = pFrequency;
	}
	
	public Frequency getFrequency() {
		this.frequency = frequency;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String pName) {
		name = pName;
	}
	
	//checking if the weekly value is a divisible amount
	public boolean checkWeeklyValue(String amount, Frequency frequency) {
		switch (frequency) {
			case WEEK:
				return weeklyValueMaths(amount, 1.00);
			case TWO_WEEK:
				return weeklyValueMaths(amount, 2.00);
			case FOUR_WEEK:
				return weeklyValueMaths(amount, 4.00);
			case MONTH:
				return weeklyValueMaths(amount, 4.33);
			case YEAR:
				return weeklyValueMaths(amount, 52.00);
		}
	}
	
	//does the maths for the above method
	public boolean weeklyValueMaths(String amount, Double pDiv) {
		int newAmount = Integer.parseInt(amount);
		double sum = newAmount/pDiv;
		
	}
	
	
	public enum Frequency {
		WEEK, TWO_WEEK, FOUR_WEEK, MONTH, QUARTER, YEAR;
	}
}

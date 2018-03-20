import java.text.DecimalFormat;


public class FullTimeEmployee implements Comparable<FullTimeEmployee> {

	//Answer to Exercise 2.11. 2.12

	final static DecimalFormat MONEY = new DecimalFormat("0.00"); //Provide accurate disply of gross_pay

	protected String name; //first name, last name
	protected double gross_pay;

	public FullTimeEmployee() { //default constructor
		name = "John Doe";
		gross_pay = 0.00;
	}

	public String getName() { //getters and setters
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGross_pay() {
		return gross_pay;
	}

	public void setGross_pay(double gross_pay) {
		this.gross_pay = gross_pay;
	}

	public FullTimeEmployee(String n, double gp){ //non default constructors
		name = n;
		gross_pay = gp;
	}

	public String toString(){
		return name + ", " + MONEY.format(gross_pay);
	}

	public boolean equals(FullTimeEmployee o){ //overridden equals method
		if (! (o instanceof FullTimeEmployee)){
			return false;
		} else {
		return (name.equalsIgnoreCase(o.name) && (Math.abs(o.gross_pay - gross_pay)<=.001));
		}
	}

	/**
	 * Compares two FullTimeEmployee objects and returns and int to represent equality or the employee that comes first alphabetically
	 *
	 * @return 0 if both objects are equal
	 * @return -1 is argument's first name is first alphabetically
	 * @return 1 if argument's first name is last alphabetically
	 */
	public int compareTo(FullTimeEmployee o){ //compareTo is COMPARABLE
		int eq;

		if(! (o instanceof FullTimeEmployee)){
			eq = 2;
		} else if (name.equalsIgnoreCase(o.name) && (Math.abs(o.gross_pay-gross_pay)<=.001)){
			eq = 0;
		} else if (name.compareTo(o.name) < 0) {
			eq = 1;
		} else {
			eq = -1;
		}
		return eq;
	}
}

package edu.pasadena.cs.cs03b;
import java.util.Scanner;

public class TaxTableTools {
	// TODO: Declare the private salary and tax_rate tables as arrays of int 
	private int[] salary = {11000, 44725, 95375, 182100, 231250, 578125};
	private double[] tax_rate = {.1, .12, .22, .24, .32, .35, .37};
	// ***********************************************************************

	// TODO: Implements Default constructor that initializes the private salary and tax_rate tables
	public void setTaxTable(int[] salary){
		this.salary = salary;
	}
	// ***********************************************************************

	// TODO: Write a void setter method that sets new values for the private
	// salary and tax_rate tables to override default salary and tax_rate tables
	public void setTaxTable(int[] salary, double[] tax_rate){
		this.salary = salary;
		this.tax_rate = tax_rate;
	}
	// ***********************************************************************

	// TODO: Method to get a tax rate from salary table based on income
	public double getTaxRate(double annualIncome) {
		double result = 0;
		for (int i = 0; i < salary.length; i++) {
			if (annualIncome < salary[i]) {
				result = tax_rate[i];
				break;
			}
		}
		if (annualIncome > 578125) {
			result = tax_rate[6];
		}
		return result;
	}

    // TODO: Method to get a tax owned based on income and tax rate
	public static void main(String[] args) {
		TaxTableTools taxTableTools = new TaxTableTools();
		// TODO: Add your code here for interactive console mode
		Scanner scanner = new Scanner(System.in);
		while (true){
			System.out.println("Enter your annual income: ");
			double annualIncome = scanner.nextDouble();
			if (annualIncome == -1){
				break;
			}
			System.out.println("Your tax rate is: " + taxTableTools.getTaxRate(annualIncome));
		}
	}
}


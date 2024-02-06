package edu.pasadena.cs.cs03b;
import java.util.Scanner;

public class TaxTableTools {
	// TODO: Declare the private salary and tax_rate tables as arrays of int 
	private int[] salary = {0, 11000, 44725, 95375, 182100, 231250, 578125};
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
		for (int i = 0; i < salary.length - 1; i++) { // Iterate to check through each sallary bracket
			if (annualIncome <= salary[i + 1]) { // Compare the anual income to the sallary bracket's upper bound
				result = tax_rate[i]; // If the income is less than the upper bound, the tax rate is the one for that bracket
				break;
			}
		}
		if (annualIncome >= salary[salary.length - 1]) { // If the income is greater than the highest bracket, the tax rate is the highest bracket's tax rate
			result = tax_rate[tax_rate.length - 1 ];
		}
		return result; // Return the tax rate
	}

    // TODO: Method to get a tax owned based on income and tax rate
	public static void main(String[] args) {
		TaxTableTools taxTableTools = new TaxTableTools();
		// TODO: Add your code here for interactive console mode
		Scanner scanner = new Scanner(System.in);
		while (true){
			System.out.println("Enter your annual income (-1 to exit): ");
			double annualIncome = scanner.nextDouble();
			if (annualIncome == -1){ // If the user enters -1, the program will exit
				break;
			}
			System.out.println("Annual income: " + annualIncome + " Tax rate: " + taxTableTools.getTaxRate(annualIncome) + " Tax to pay: " + annualIncome * taxTableTools.getTaxRate(annualIncome));
			System.err.println();
		}
	}
}


package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		List<TaxPayer> payers = new ArrayList<>();

		try {
			System.out.print("Entre com o número de pagantes: ");
			int numberOfPayers = input.nextInt();

			int i = 1;
			while (i <= numberOfPayers) {
				System.out.println("\nDados do " + i + "º pagante.");
				System.out.print("Pessoa física ou jurídica? (f/j)");
				char ch = input.next().charAt(0);

				if (ch != 'f' && ch != 'j') {
					System.out.println();
					System.out.println("Você deixou de escolher uma das opções (f/j)");
					System.out.println(
							"Por favor, certifique-se de escolher uma das opções, escrever em letra minúscula e tentar novamente.");
				} else {
					System.out.print("Nome: ");
					input.nextLine();
					String name = input.nextLine();
					System.out.print("Renda anual: R$ ");
					double annualIncome = input.nextDouble();

					if (ch == 'f') {
						System.out.print("Despesas com saúde: R$ ");
						double healthExpendures = input.nextDouble();
						payers.add(new Individual(name, annualIncome, healthExpendures));
					} else {
						System.out.print("Quantidade de empregados: ");
						int numberOfEmployees = input.nextInt();
						payers.add(new Company(name, annualIncome, numberOfEmployees));
					}
					i++;
				}
			}
			double sum = 0.0;
			System.out.println();
			System.out.println("PAGANTES:");
			for (TaxPayer tp : payers) {
				double tax = tp.tax();
				System.out.println(tp.getName() + ": R$ " + String.format("%.2f", tax));
				sum += tax;
			}
			System.out.println();
			System.out.println("TOTAL DE IMPOSTO: $ " + String.format("%.2f", sum));
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Foi inserido um valor inadequado para operação.");
			System.out.println("Você pode ter digitado uma letra no lugar de um número por exemplo.");
			System.out.println("Reinicie para tentar novamente.");
		} finally {
			input.close();
		}
	}
}

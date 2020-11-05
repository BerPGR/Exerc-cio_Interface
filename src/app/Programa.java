package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ENTER CONTRACT DATA");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Date (dd/mm/yyyy): ");
		Date data = sdf.parse(sc.next());
		
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract c = new Contract(number, data, totalValue);
		
		System.out.print("Enter number of installments: ");
		int n = sc.nextInt();
		
		ContractService contract = new ContractService(new PaypalService());
		contract.processContract(c, n);
		
		System.out.println("Installments: ");
		for(Installment x : c.getInstallments()) {
			System.out.println(x);
		}
		
		sc.close();
	}

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrasilTaxService;
import model.services.RentalService;

public class Program_Aula_193 {
	// fazendo um teste no git
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.print("Digite o modelo do Veículo: ");
		String model = sc.nextLine();
		
		System.out.print("Data de Retirada do Veículo: ");
		Date start = sfd.parse(sc.nextLine());
		
		System.out.print("Data de devolução do Veículo: ");
		Date finish = sfd.parse(sc.nextLine());
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(model));
		
		System.out.print("Digite o preço /hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Digite o preço /dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrasilTaxService());
		rentalService.processInvoice(carRental);
		
		System.out.println();
		System.out.println();
		
		System.out.println("<<INVOICE>>");
		System.out.println("Basic payment: " + String.format("%.2f",carRental.getInvoice().getBasicPayment()));
		System.out.println("Taxa: " + String.format("%.2f",carRental.getInvoice().getTax()));
		System.out.println("Total Paymant: " + String.format("%.2f",carRental.getInvoice().getTotalPayment()));
		
		sc.close();
	}
	

}

/**
 * 
 */
package java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author semikasiriwardana
 *
 */
public class TraderMain {

	public static void main(String[] args) {
		
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan  = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Briam", "Cambridge"); 
		
		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300), 
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), 
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
		
		//findAllTransactionsIn2011(transactions);
		
		//findAllUniqueCities(traders);
		
		//findAllCambridgeTraders(transactions);
		
		Boolean milanBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan")); 
		if (milanBased) {
			System.out.println("Milan Present");
		}
		
		//printAllTransactionValuesForCambridge(transactions);
		
		transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(d->System.out.println("Max Value : " + d)); 
		
		transactions.stream().map(Transaction::getValue).reduce(Integer::min).ifPresent(d->System.out.println("Min Value : " + d));
		
		findAllTradersAsString(transactions);
		
	}
	
	
	public static void findAllTransactionsIn2011(List<Transaction> transactions) { 
		
		List<Transaction> resultList = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());  
		resultList.forEach(t -> System.out.println(t)); 
		
		List<String> uniqueCities = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList()); 
		uniqueCities.forEach(System.out::println);
 	}
	
	public static void findAllUniqueCities(List<Trader> traders) {
		List<String> uniqueCities = traders.stream().map(Trader::getCity).distinct().collect(Collectors.toList()); 
		uniqueCities.forEach(System.out::println); 
	}
	
	public static void findAllCambridgeTraders(List<Transaction> transactions) {
		List<Trader> list = transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equalsIgnoreCase("Cambridge"))
				.sorted(Comparator.comparing(Trader::getCity))
				.collect(Collectors.toList());
		list.forEach(System.out::println); 
	}
	
	public static void printAllTransactionValuesForCambridge(List<Transaction> transactions) { 
		transactions.stream().filter(d -> d.getTrader().getCity().equalsIgnoreCase("Cambridge"))
				.collect(Collectors.toList()).forEach(d -> System.out.println(d.getValue()));  
	}
	
	public static void findAllTradersAsString(List<Transaction> transactions) {
		String s = transactions.stream()
			.map(transaction -> transaction.getTrader().getName())
			.distinct().sorted().collect(Collectors.joining()); 
		System.out.println(s); 
	}
}

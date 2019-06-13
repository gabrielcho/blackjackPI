package blackjack;

import java.util.Arrays;
import java.util.Scanner;

public class utils {

	public static void println(Object...objects) {
		Arrays.asList(objects).stream().forEach(System.out::println);
	}
	
	public static String input(Object...objects) {
		println(objects);
		Scanner scanner = new Scanner(System.in);
		
		return scanner.nextLine();
	}
}

/**
 * 
 */
package java8.pythogoron;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author semikasiriwardana
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

//		int b = 0;
//		IntStream.rangeClosed(1, 100).boxed().flatMap(b -> IntStream.rangeClosed(b,  100)
//			.filter(a -> Math.sqrt(a*a + b*b) % 1 == 0)
//				.map(a -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)});
		 
		Stream<int[]> pythagoreanTriples =
				IntStream.rangeClosed(1, 100).boxed().flatMap(a ->
					IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
						.mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)}));
		
		//pythagoreanTriples.forEach(a -> System.out.println(a[0] + "," + a[1] + "," + a[2]));  
		
		readFile();
	}
	
	public static void readFile() throws IOException {
		
		Stream<String> lineStream = Files.lines(Paths.get("/Users/semikasiriwardana/workspace/java-8/src/java8/pythogoron/data.txt"), Charset.defaultCharset()); 
		
		//lineStream.forEach(System.out::println); 
		
		List<String> wordStream = lineStream.flatMap(line -> Arrays.stream(line.split(" "))).distinct().collect(Collectors.toList());
		
		// Stream 1 : [SriLanka][is][a][beautiful][country][in][Indian][ocean.]} 
		// Stream 2 : [It][is][totally][surrounded][by][the][sea.]
		
		wordStream.forEach(System.out::println); 
		
		//long noOfDistinctworkds = lineStream.distinct().count();
		
		//lineStream.forEach(System.out::println);
		
		
		//System.out.println(noOfDistinctworkds); 
		
	}

}

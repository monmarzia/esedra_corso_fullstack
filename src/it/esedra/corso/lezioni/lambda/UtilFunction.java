package it.esedra.corso.lezioni.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UtilFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		BiFunction<Integer, Integer, Integer> foo = (x1, x2) -> x1 + x2;
		
		Integer result = foo.apply(2, 3);
		
		System.out.println(result);
		
		Function<Integer, Integer> foon = (x1) -> x1 + 10;
		
		result = foon.apply(2);
		
		System.out.println(result);
		
		Consumer<String> print = x -> System.out.println(x);
		
		print.accept("ciao");
		
		
		Predicate<Integer> lessThan = i -> (i < 10);
		System.out.println(lessThan.test(10));
	}

}

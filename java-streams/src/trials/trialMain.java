package trials;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class trialMain {

	public static void main(String[] args) {
		List<String> lstString = Arrays.asList("aaaaaaaaaaa", "aa", "aaaaa", "aaa", "aaaaaaa", "aaaa");

		Comparator<String> lengthComp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		};

		String[] strArr = new String[lstString.size()];
		strArr = lstString.toArray(strArr);
		Arrays.sort(strArr, lengthComp);
		System.out.println(Arrays.toString(strArr));

		BinaryOperator<Integer> sum = (x, y) -> Integer.sum(x, y); // lambda exepression
		BinaryOperator<Integer> sum2 = Integer::sum;// method reference

		System.out.println(sum2.apply(5, 7));

		List<Integer> lstInteger = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println(accumulate(lstInteger, 0, sum2));

		Consumer<String> printer = s -> System.out.println(s);
		Consumer<String> printer2 = System.out::println;

		Consumer<Integer> square = i -> System.out.println(Math.pow(i, 2));

		square(5, square);
	}

	public static <T> T accumulate(List<T> list, T init, BinaryOperator<T> accumulator) {
		T res = init;
		for (T t : list) {
			res = accumulator.apply(res, t);
		}
		return res;
	}

	public static <T> void print(T t, Consumer<T> printer) {
		printer.accept(t);
	}

	public static <T> Void square(T t, Consumer<T> square) {
		square.accept(t);
		return null;
	}

}

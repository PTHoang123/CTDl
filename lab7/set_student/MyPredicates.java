package lab7.set_student;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		coll.removeIf(p);
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		coll.removeIf(p.negate());
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> re = new HashSet<>();
		for(T t : coll){
			if (p.test(t)) {
				re.add(t);
			}
		}
		return re;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int i = 0;
		for(T t : coll){
			if (p.test(t)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	public static void main(String[] args) {
		Predicate<Integer> p = x -> x % 2 == 0;
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		remove(s, p);
		System.out.println(s);
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		retain(s, p);
		System.out.println(s);
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		System.out.println(collect(s, p));
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		System.out.println(find(s, p));
	}
}

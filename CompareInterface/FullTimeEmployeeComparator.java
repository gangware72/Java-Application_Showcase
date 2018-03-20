import java.util.Comparator;


	public class FullTimeEmployeeComparator implements Comparator<FullTimeEmployee>{

		public int compare(FullTimeEmployee o1, FullTimeEmployee o2){ //compare is COMPARATOR
			int eq;
			if (! (o1 instanceof FullTimeEmployee) || !(o2 instanceof FullTimeEmployee)) {
				eq = 2;
			} else if (o1.name.equalsIgnoreCase(o2.name) && Math.abs(o1.gross_pay - o2.gross_pay) <=.001){
				eq = 0;
			} else if (o1.name.compareTo(o2.name) < 0) {
				eq = 1;
			} else {
				eq = -1;
			}
			return eq;
		}
	}

import java.lang.*;
import java.util.Arrays;

public class OrdinaLavoratori {
  public static void ordinaLavoratori(Lavoratore[] lav) {
	Arrays.sort(lav);
//	Lavoratore o = new Lavoratore();
//		for(int i = 0; i < lav.length - 1; i++) {
//			for(int j = i + 1; j < lav.length; j++) {
//				if (lav[i].compareTo(lav[j]) > 0) {
//					o = lav[i];
//					lav[i] = lav[j];
//					lav[j] = o;
//				}
//			}
//		}
	for (int i = 0; i < lav.length; i++) {
		System.out.print(lav[i].getNome() + " guadagna ");
		if(lav[i] instanceof LavoratoreConStraordinari) {
			LavoratoreConStraordinari a = (LavoratoreConStraordinari) lav[i];
			System.out.println(a.getStipendio() + a.getOre() * a.getRetribuzione());
		}
		else
			System.out.println(lav[i].getStipendio());
		}
	}
}

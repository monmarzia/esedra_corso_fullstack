package it.esedra.corso.lezioni.annotation;

public @interface DaCompletare {
	String descrizione();
	String assegnataA() default "da assegnare";
}

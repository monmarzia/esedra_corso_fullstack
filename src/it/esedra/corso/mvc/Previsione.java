package it.esedra.corso.mvc;

public class Previsione {
	
	private TempoMeteo tempo;
	private Float temperatura;
	
	public TempoMeteo getTempo() {
		return tempo;
	}
	public void setTempo(TempoMeteo tempo) {
		this.tempo = tempo;
	}
	@Deprecated
	public Float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}
}

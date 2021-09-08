package it.esedra.corso.esercitazioneB.matteocirri;

public final class SideEffects {
	private final int addendoA, addendoB, somma;

    public SideEffects(int addendoA, int addendoB, int somma) {
        this.addendoA = addendoA;
        this.addendoB = addendoB;
        this.somma = somma;
    }
    
   	public void setAddendoA(int addendoA) {
        new SideEffects(this.addendoB, addendoA, this.addendoB + this.addendoA);
    }

	public int getAddendoA() {
		return (new SideEffects(this.addendoA, this.addendoB, this.addendoB + this.addendoA)).addendoA;
	}
    public void setAddendoB(int addendoB) {
        new SideEffects(this.addendoA, addendoB, this.addendoB + this.addendoA);
    }
 
    public int getAddendoB() {
        return (new SideEffects(this.addendoA, this.addendoB, this.addendoB + this.addendoA)).addendoB;
    }
  
    public void setSomma() {
        new SideEffects(this.addendoB, this.addendoB, this.addendoB + this.addendoA);
    }
    
    public int getSomma() {
        return (new SideEffects(this.addendoB, this.addendoB, this.addendoA + this.addendoB)).somma;
    }
}

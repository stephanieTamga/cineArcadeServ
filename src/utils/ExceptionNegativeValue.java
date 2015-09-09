package utils;

public class ExceptionNegativeValue  extends IllegalArgumentException{
	private Number valeur;
	public ExceptionNegativeValue(Number valeur){
		this.valeur=valeur;
		System.out.println("Erreur, valeur negative");
	}

}

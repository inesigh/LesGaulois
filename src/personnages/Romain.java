package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() : "La force doit être positive";
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole () + "\"" + texte + "\"");
	}
	
	private String prendreParole () {
		return "Le romain " + nom + " : ";
	}
	
	
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0 : "La force du coup doit être positive";
		int forceAvant = force;
	    force = force - forceCoup;
	    if (force < 1) {
	    	force = 0;
	        parler("J'abandonne !");
	    } else {
	        parler("Aïe");
	    }
	    assert force < forceAvant : "La force doit avoir diminué";
	    assert isInvariantVerified() : "La force doit être positive";
	}
	
	 private boolean isInvariantVerified() {
	        return force >= 0;
	    }
	 
	 public static void main(String[] args) {
	        Romain minus = new Romain("Minus", 6);
	    }
	
}

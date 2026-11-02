package personnages;

import village_gaulois.Village;

import village_gaulois.Musee;

import objets.Equipement;

public class Gaulois {
	private String nom;
	//private int force;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}
	
	public void sePresenter() {
	    if (village == null) {
	        parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
	    } else if (village.getChef() == this) {
	        parler("Bonjour, je m'appelle " + nom + ". Je suis le chef le village : " + village.getNom() + ".");
	    } else {
	        parler("Bonjour, je m'appelle " + nom + ". J'habite le village : " + village.getNom() + ".");
	    }
	}
	
	public void parler(String texte) {
		 System.out.println("Le Gaulois " + nom + " : \"" + texte + "\"");
	}
	
	public void frapper(Romain romain) {
	    System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
	    int forceCoup = (force * effetPotion) / 3;
	    Equipement[] trophees = romain.recevoirCoup((force / 2) * effetPotion);
	    effetPotion--;
	    if (effetPotion < 1) {
	        effetPotion = 1;
	    }
	    for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
	        this.trophees[nbTrophees] = trophees[i];
	    }
	    
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		int forceCoup = (force * effetPotion) / 3;
//		romain.recevoirCoup(forceCoup);
//		if (effetPotion > 1) {
//			effetPotion--;
//		}
//	}
	
	public void faireUneDonnation(Musee musee) {
	    if (nbTrophees > 0) {
	        StringBuilder texte = new StringBuilder("Je donne au musee tous mes trophees :");
	        for (int i = 0; i < nbTrophees; i++) {
	        	texte.append("\n- ").append(trophees[i]);
	            musee.donnerTrophees(this, trophees[i]);
	        }
	        parler(texte.toString());
	        nbTrophees = 0;
	    }
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public static void main (String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		
	}

//	@Override
//	public String toString() {
//		return nom;
//	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	
}

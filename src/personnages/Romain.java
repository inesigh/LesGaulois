package personnages;

import objets.Equipement;


public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public int getForce() {
	    return force;
	}
	
	
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
	
	
	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;
	    forceCoup = calculerResistanceEquipement(forceCoup);
	    if (forceCoup >= force) {
	        force = 0;
	    } else {
	        force -= forceCoup;
	    }
	    if (force > 0) {
	        parler("Aïe");
	    } else {
	        equipementEjecte = ejecterEquipement();
	        parler("J'abandonne...");
	    }
	    return equipementEjecte;
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup > 0 : "La force du coup doit être positive";
//		int forceAvant = force;
//	    force = force - forceCoup;
//	    if (force < 1) {
//	    	force = 0;
//	        parler("J'abandonne !");
//	    } else {
//	        parler("Aïe");
//	    }
//	    assert force < forceAvant : "La force doit avoir diminué";
//	    assert isInvariantVerified() : "La force doit être positive";
//	}
	
	public void sEquiper(Equipement equipement) {
    switch (nbEquipement) {
        case 0:
            ajouterEquipement(equipement);
            break;
        case 1:
            if (equipements[0] == equipement) {
                System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
            } else {
                ajouterEquipement(equipement);
            }
            break;
        case 2:
            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
            break;
    }
}
	private void ajouterEquipement(Equipement equipement) {
	    equipements[nbEquipement] = equipement;
	    nbEquipement++;
	    System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}
	
	 private boolean isInvariantVerified() {
	        return force >= 0;
	    }
	 
	 public static void main(String[] args) {
	        Romain minus = new Romain("Minus", 6);
	        
	        minus.sEquiper(Equipement.CASQUE);
	        minus.sEquiper(Equipement.CASQUE);
	        minus.sEquiper(Equipement.BOUCLIER);
	        minus.sEquiper(Equipement.CASQUE);
	   	 	
	   	
	    }
	 

	 private int calculerResistanceEquipement(int forceCoup) {
			String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
			int resistanceEquipement = 0;
			if (nbEquipement != 0) {
				for (int i = 0; i < nbEquipement; i++) {
					if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 6;
					} else if (equipements[i] != null) {
						resistanceEquipement += 3;
					}
				}
				if (resistanceEquipement >= forceCoup) {
					texte += "\nMais heureusement, grâce à mon équipement sa force a été complètement absorbée.";
					forceCoup = 0;
				} else {
					texte += "\nMais heureusement, grâce à mon équipement sa force a été diminuée de " + resistanceEquipement + " !";
					forceCoup -= resistanceEquipement;
				}
			}
			parler(texte);
			return forceCoup;
		}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
}
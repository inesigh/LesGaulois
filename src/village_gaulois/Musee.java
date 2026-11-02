package village_gaulois;

import objets.Equipement;
import objets.Trophee;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < trophees.length) {
			trophees[nbTrophee] = new Trophee(gaulois, equipement);
			nbTrophee++;
		}
	}
	
	public String extraireInstructionsOCaml() {
		StringBuilder texte = new StringBuilder("let musee = [\n");
		for (int i = 0; i < nbTrophee; i++) {
			texte.append("\t\"").append(trophees[i].donnerNom()).append("\", \"")
			     .append(trophees[i].getEquipement()).append("\"");
			if (i < nbTrophee - 1) {
				texte.append(";\n");
			} else {
				texte.append("\n");
			}
		}
		texte.append("]");
		return texte.toString();
	}
}

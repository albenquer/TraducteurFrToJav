package fr.eral.javaClasses;

import java.util.Arrays;
import java.util.List;

/**
 * Gestion de la traduction français vers Javanais
 * 
 * @return texte traduit en javanais
 * 
 * @author richard
 */
public class FrToJav extends Object {

	public FrToJav() {
		super();
	}

	/**
	 * Fonction itérant sur le string passé en entrée pour traduction en
	 * javanais
	 * 
	 * @param entree
	 *            le mot en français à traduire en javanais
	 * @return le mot traduit en javanais
	 */
	public String tradFrToJav(String entree) {

// ----- Préparation ------

		// on nettoie les espaces avant/après le mot en entrée
		entree = entree.trim();

		// on vérifie si l'entrée est vide ou null
		if (entree.isEmpty() || entree == null) {
			return "Merci de saisir un texte à traduire";
		}

		// création d'une liste des voyelles
		List<Character> voyelles = Arrays.asList(Constantes.VOYELLES);

		// la lettre précédente était-elle une voyelle?
		boolean isVoyelle = false;

		// SB pour le texte traduit en javanais
		StringBuilder textJavBuilder = new StringBuilder();

// ----- Traitement ------

		try {

			// on itère sur le mot en entrée
			for (int i = 0; i < entree.length(); i++) {

				// Si la lettre précédente est une consonne
				if (!isVoyelle) {

					// + si c'est une voyelle. On insère la constante JAV
					// (minuscule ou majuscule)
					if (voyelles.contains(Character.toLowerCase(entree.charAt(i)))) {

						if (Character.isLowerCase(entree.charAt(i))) {
							textJavBuilder.append(Constantes.JAVANAIS.toLowerCase());
						} else {
							textJavBuilder.append(Constantes.JAVANAIS.toUpperCase());
						}

						isVoyelle = true;
					}
				} else {
					isVoyelle = false;
				}

				// on écrit la lettre en cours.
				textJavBuilder.append(entree.charAt(i));
			}

		} catch (Exception e) {

			textJavBuilder = new StringBuilder();
			textJavBuilder.append("Erreur lors du traitement. Merci de recommencer.");
			textJavBuilder.append("</br></br>");
			textJavBuilder.append(e);

		}

		return textJavBuilder.toString();
	}

}

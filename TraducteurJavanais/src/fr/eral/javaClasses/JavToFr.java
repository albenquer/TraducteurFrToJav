package fr.eral.javaClasses;

/**
 * Gestion de la traduction javanais vers français
 * 
 * @return texte traduit en français
 * 
 * @author richard
 */
public class JavToFr extends Object {

	public JavToFr() {
		super();
	}

	/**
	 * Fonction itérant sur le string Javanais passé en entrée pour traduction
	 * en français
	 * 
	 * @param entree
	 *            le mot en javanais à traduire en français
	 * @return le mot traduit en français
	 */
	public String tradJavToFr(String entree) {

// ----- Préparation ------

		// on nettoie les espaces avant/après le mot en entrée
		entree = entree.trim();

		// on vérifie si l'entrée est vide ou null
		if (entree.isEmpty() || entree == null) {
			return "Merci de saisir un texte à traduire";
		}

		// Indicateur si on vient de retirer un morceaux de JAV ou pas
		boolean wasJav = false;

		// SB pour le texte traduit en français
		StringBuilder textFrBuilder = new StringBuilder();

// ----- Traitement ------

		try {

			// on itère sur le mot en entrée jusqu'a l'avant dernière lettre
			// (qui ne peut pas etre un ajout de javanais)
			for (int i = 0; i < entree.length() - (Constantes.JAVANAIS.length() - 1); i++) {

				// Si l'itération précédente était un retrait de JAV. On ne
				// retire pas 2 fois la constante JAV à la suite.
				if (wasJav) {

					wasJav = false;

					if (Constantes.JAVANAIS
							.equals(entree.substring(i, i + Constantes.JAVANAIS.length()).toLowerCase())) {
						// on reproduit la partie à garder
						// (=constantes.Javanais)
						textFrBuilder.append(entree.substring(i, i + Constantes.JAVANAIS.length()));
						i = i + (Constantes.JAVANAIS.length() - 1);
					} else {
						textFrBuilder.append(entree.charAt(i));
					}

				}

				// sinon, on à trouver la contante JAV, on indique le JAV et on
				// avance à la prochaine lettre pertinente
				else if (Constantes.JAVANAIS
						.equals(entree.substring(i, i + Constantes.JAVANAIS.length()).toLowerCase())) {
					wasJav = true;
					i = i + (Constantes.JAVANAIS.length() - 1);

				}
				// sinon, on écrit la lettre.
				else {

					textFrBuilder.append(entree.charAt(i));
				}

			}

			// ajout des dernières lettres (ne peuvent pas être JAV)
			textFrBuilder.append(entree.charAt(entree.length() - 1));

		} catch (Exception e) {

			textFrBuilder = new StringBuilder();
			textFrBuilder.append("Erreur lors du traitement. Merci de recommencer.");
			textFrBuilder.append("</br></br>");
			textFrBuilder.append(e);

		}
		return textFrBuilder.toString();
	}
}

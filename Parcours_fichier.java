import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcours_fichier {

	static String List[];
	static String fileConcat = " ";

	public String group_file() {
		return null;

	}

	public static final int regexOccur(String text, String regex) {
		Matcher matcher = Pattern.compile(regex).matcher(text);
		int occur = 0;
		while (matcher.find()) {
			occur++;
		}
		return occur;
	}

	static String fichier = "C:/Users/JOSAPHAT/Downloads";

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		File repertoire = new File(fichier);
		File[] files = repertoire.listFiles();
		List = new String[files.length];
		for (int i = 0; i < files.length; i++) {

		}

		for (int i = 0; i < files.length; i++) {
			try {

				List[i] = (files[i].getName() != null)
						? files[i].getName().substring(0, files[i].getName().indexOf('.')) : "";
				fileConcat = List[i] + " " + fileConcat;
				// System.out.println(files[i].getName());
			} catch (StringIndexOutOfBoundsException e) {
			}
		}
		System.out.println("avant ");
		System.out.println(fileConcat);

		Pattern traitPattern = Pattern.compile("-");
		// création du moteur associé à la regex sur la chaîne "J'aime le thé."
		Matcher traitMatcher = traitPattern.matcher(fileConcat);
		// remplacement de toutes les occurrences de "thé" par "chocolat"
		String repTrait = traitMatcher.replaceAll(" ");

	//	Pattern sousPattern = Pattern.compile("[^a-z]");
		Pattern sousPattern = Pattern.compile("_");
		// création du moteur associé à la regex sur la chaîne "J'aime le thé."
		Matcher sousMatcher = sousPattern.matcher(repTrait.toLowerCase());
		// remplacement de toutes les occurrences de "thé" par "chocolat"
		String repSous = sousMatcher.replaceAll(" ");
		 
		
		System.out.println("CHANGEMENT=============>");
		System.out.println(repSous);
				System.out.println();
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(repSous);
		System.out.println(matcher.find());
		if (matcher.find())
			while (matcher.find()) {

				fileConcat = matcher.replaceAll(" ");
				// System.out.print(matcher.replaceAll(" "));
			}
		else
			fileConcat = repSous;
		
		 
				
		System.out.println("comm--->" + fileConcat);

		fileConcat = fileConcat.toLowerCase();
		// System.out.println(fileConcat);
		List = fileConcat.split(" ");

		fileConcat = "";

		for (int i = 0; i < List.length; i++) {
			// System.out.print(List[i] + " ");
			// System.out.println(List[i]);
			fileConcat = List[i] + " " + fileConcat;
		}

		System.out.println("apres");
		System.out.println(fileConcat);
		NewList = new String[List.length];
		int[] nb = new int[List.length];
		for (int i = 0; i < List.length; i++) {
			if (List[i].length() >= 3) {

				// System.out.println(regexOccur(fileConcat, List[i]));
				// System.out.println(List[i]);
				Matcher match = Pattern.compile(List[i]).matcher(fileConcat);
				int occur = 0;
				while (match.find()) {
					occur++;
				}

				// System.out.println(occur);
				fileConcat = match.replaceAll(" ");
				// System.out.println(fileConcat);
				if (occur != 0) {
					NewList[i] = List[i];
					nb[i] = occur;
				}
				// System.out.println(fileConcat);
			}
		}
		for (int i = 0; i < nb.length; i++) {
			if (NewList[i] != null)
				System.out.println(NewList[i] + " " + nb[i]);
		}
		int tab[] = { 5, 3, 4, 1, 2 };

		quickSort(nb, 0, nb.length - 1);
		System.out.println("--------------etape de selection----------------");
		for (int i = 0; i < nb.length; i++) {
			if (nb[i] >= 2) {
				System.out.println(nb[i] + " " + NewList[i]);
			}
		}
		System.out.println("------------creation de dossier----------------");
		for (int i = 0; i < NewList.length; i++) {
			String update = "";
			if (nb[i] >= 2) {
				update = fichier + "/" + NewList[i];
				File file = new File(update);
				// Sous Linux
				// File file = new File("/home/temp");
				if (file.exists()) {
					System.out.println("Le dossier existe déjà : " + file.getAbsolutePath());
				} else {
					if (file.mkdir()) {
						System.out.println("Ajout du dossier : " + file.getAbsolutePath());
					} else {
						System.out.println("Echec sur le dossier : " + file.getAbsolutePath());
					}
				}
			}

		}
		System.out.println("--------deplacement de fichier dans le dossiers--------------------");

		System.out.println("-----------deplacer le fichier-----------");
		for (int i = 0; i < NewList.length; i++) {
			if (nb[i] >= 2) {
				if (NewList[i] != null) {
					File[] Filerenome = repertoire.listFiles();
					// Déplacer le fichier vers le disque D:

					for (int j = 0; j < Filerenome.length; j++) {

						// création du moteur associé à la regex sur la chaîne
						// "J'aime
						// le thé."
						if (Filerenome[j].isFile()) {
							// System.out.println(NewList[i]);
							// System.out.println(Filerenome[j].getName());
							Pattern p = Pattern.compile(NewList[i]);
							Matcher m = p.matcher(Filerenome[j].getName().toLowerCase());
							// remplacement de toutes les occurrences de "thé"
							// par
							// "chocolat"

							File destination = new File(fichier + "/" + NewList[i] + "/" + Filerenome[j].getName());
							if (m.find()) {

								System.out.println("========deplacement==========");
								System.out.println("-----source----------->" + Filerenome[j]);
								// if (destination.exists())
								System.out.println("---destination------------->" + destination);

								System.out.println("oui");
								System.out.println(NewList[i]);
								System.out.println(deplacer(Filerenome[j], destination));
								;
								System.out.println("=====fin deplacement===========");
							}
						}
					}
				}
			}

			/*
			 * for (int j = 0; j < Filerenome.length; j++) { File source = new
			 * File(fichier + "/" + Filerenome[j]); if (Filerenome[j].isFile())
			 * { System.out.println("-----source----------->" + Filerenome[j]);
			 * System.out.println("---destination------------->" + destination);
			 * } Matcher match =
			 * Pattern.compile(NewList[i]).matcher(Filerenome[j].getName());
			 * while (match.find()) { // System.out.println("de " + source +
			 * " a " + destination);
			 * System.out.println("========deplacement=========="); if
			 * (Filerenome[j].isFile()) deplacer(Filerenome[j], destination); }
			 * }
			 */
		}
		File[] Filerenome = repertoire.listFiles();
		for (int j = 0; j < Filerenome.length; j++) {
			if (Filerenome[j].isDirectory()) {
				System.out.println(Filerenome[j].toString() + "  " + nbFic(Filerenome[j].toString()));
				if (nbFic(Filerenome[j].toString()) == 0) {
					File rep = new File(Filerenome[j].toString());
					rep.delete();
					System.out.println(rep + "   " + "est supprimer");
				}
			}
		}

	}

	static String[] NewList;

	static int nbFic(String monRep) {
		File monRepertoire = new File(monRep);
		File[] f = monRepertoire.listFiles();
		int x = 0;
		for (int i = 0; i < f.length; i++) {
			if (f[i].isFile()) {
				x++;
			}
		}
		return x;
	}

	public static boolean deplacer(File source, File destination) {
		if (!destination.exists()) {
			// On essaye avec renameTo
			boolean result = source.renameTo(destination);
			/*
			 * if (!result) { // On essaye de copier result = true; result &=
			 * copier(source, destination); result &= source.delete();
			 * 
			 * }
			 */
			return (result);
		} else {
			// Si le fichier destination existe, on annule ...
			return (false);
		}
	}

	static void echanger(int tableau[], int a, int b) {
		int temp = tableau[a];
		tableau[a] = tableau[b];
		tableau[b] = temp;

		String temp1 = NewList[a];
		NewList[a] = NewList[b];
		NewList[b] = temp1;
	}

	static void quickSort(int tableau[], int debut, int fin) {
		int gauche = debut - 1;
		int droite = fin + 1;
		int pivot = tableau[debut];

		/* Si le tableau est de longueur nulle, il n'y a rien à faire. */
		if (debut >= fin)
			return;

		/*
		 * Sinon, on parcourt le tableau, une fois de droite à gauche, et une
		 * autre de gauche à droite, à la recherche d'éléments mal placés, que
		 * l'on permute. Si les deux parcours se croisent, on arrête.
		 */
		while (true) {
			do
				gauche++;
			while (tableau[gauche] > pivot);
			do
				droite--;
			while (tableau[droite] < pivot);
			if (gauche < droite)
				echanger(tableau, gauche, droite);
			else
				break;
		}

		/*
		 * Maintenant, tous les éléments inférieurs au pivot sont avant ceux
		 * supérieurs au pivot. On a donc deux groupes de cases à trier. On
		 * utilise pour cela... la méthode quickSort elle-même !
		 */
		quickSort(tableau, debut, droite);
		quickSort(tableau, droite + 1, fin);
	}
/*
	public static boolean copier(File source, File destination) {
		System.out.println("====copie======");
		boolean resultat = false;

		// Declaration des flux
		java.io.FileInputStream sourceFile = null;
		java.io.FileOutputStream destinationFile = null;

		try {
			// Création du fichier :
			destination.createNewFile();

			// Ouverture des flux
			sourceFile = new java.io.FileInputStream(source);
			destinationFile = new java.io.FileOutputStream(destination);
			System.out.println("===copy==========");
			// Lecture par segment de 0.5Mo
			byte buffer[] = new byte[512 * 1024];
			int nbLecture;

			while ((nbLecture = sourceFile.read(buffer)) != -1) {
				destinationFile.write(buffer, 0, nbLecture);
			}

			// Copie réussie
			resultat = true;
		} catch (java.io.FileNotFoundException f) {

		} catch (java.io.IOException e) {

		} finally {
			// Quoi qu'il arrive, on ferme les flux
			try {
				sourceFile.close();
			} catch (Exception e) {
			}
			try {
				destinationFile.close();
			} catch (Exception e) {
			}
		}
		return (resultat);
	}*/
}

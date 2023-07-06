package fr.humanbooster.jpb;

import fr.humanbooster.jpb.builder.PoneyBuilder;
import fr.humanbooster.jpb.builder.impl.PoneyBuilderImpl;
import fr.humanbooster.jpb.business.*;
import fr.humanbooster.jpb.factory.CodeFactory;
import fr.humanbooster.jpb.factory.impl.CodeFactoryImpl;
import fr.humanbooster.jpb.iterator.CollectionDePoneys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static Poney poney;
    private static CodeFactory codeFactory;
    private static Stage stage;
    private static Cavalier cavalier;
    private static List<String> activites = new ArrayList<>();
    private static PoneyBuilder poneyBuilder = new PoneyBuilderImpl();
    private static CollectionDePoneys collectionDePoneys = new CollectionDePoneys(poneyBuilder.getPoneys());

    public static void main(String[] args) {

        /*
        J'ai nommé cette fonction ainsi car son nom est très explicite.
        Il m'a été difficile de rendre ce projet dans les temps, et mon cerveau semble préférer cette approche.
         */
        fonctionToutEnUn();
    }

    public static void fonctionToutEnUn(){
        /*
        On commence par afficher la liste des poneys grâce au patter itterator
         */
        System.out.println("Bienvenue au Poney Club");
        System.out.println("Tableau des poneys :\n");
        System.out.println("\u001B[34m+----------------------+");
        System.out.println("|   \u001B[36mChoix   \u001B[34m|   \u001B[36mPoney   \u001B[34m|");
        System.out.println("+----------------------+");

        int choix = 1;
        while (collectionDePoneys.hasNext()) {
            Poney poney = collectionDePoneys.next();
            System.out.printf("|    \u001B[32m%-4d   \u001B[34m|   \u001B[35m%-8s  \u001B[34m|\n", choix, poney.getNom());
            choix++;
        }
        System.out.println("+----------------------+\u001B[0m");
        /*
        Notre utilisateur va choisir un poney parmis les 10, et en fonction de sa sélection, nous allons appler le
        builder pour créer une nouvelle instance de poney avec un nom.
         */
        int choixPoney = 0;
        choixPoney = demanderChoix("Veuillez choisir un poney parmis de la liste: exemple: Tapez '1' pour Ribambelle", 1, 10);
        PoneyBuilder poneyBuilder = new PoneyBuilderImpl();
        switch (choixPoney) {
            case 1 -> poneyBuilder.ajouterNom("Ribambelle");
            case 2 -> poneyBuilder.ajouterNom("Ping");
            case 3 -> poneyBuilder.ajouterNom("Pong");
            case 4 -> poneyBuilder.ajouterNom("Pompon");
            case 5 -> poneyBuilder.ajouterNom("Caramel");
            case 6 -> poneyBuilder.ajouterNom("Chocolat");
            case 7 -> poneyBuilder.ajouterNom("Tornade");
            case 8 -> poneyBuilder.ajouterNom("Éclair");
            case 9 -> poneyBuilder.ajouterNom("Galopin");
            case 10 -> poneyBuilder.ajouterNom("Noisette");
        }
        /*
        Cette partie concerne le choix de l'équipement de notre utilisateur mystère, on va ici lui demander de choisir
        parmis une liste d'équipement. En écrivant ces lignes je me rends compte que je n'ai pas gérer le stock.
        Cela est merveilleux!
         */
        afficherTableauSelles();
        int selle = 0;
        selle = demanderChoix("Veuillez choisir une selle: ", 1, 2);
        switch (selle){
            case 1 -> poneyBuilder.ajouterSelle("en cuir de buffle");
            case 2 -> poneyBuilder.ajouterSelle("en matière synthétique");
        }
        afficherTableauBrides();
        int bride = 0;
        bride = demanderChoix("Veuillez choisir une bride: ", 1, 2);
        switch (bride){
            case 1 -> poneyBuilder.ajouterBride("bleu");
            case 2 -> poneyBuilder.ajouterBride("rose");
        }
        afficherTableauRenes();
        int renes = 0;
        renes = demanderChoix("Veuillez choisir vos renes: ", 1, 2);
        switch (renes){
            case 1 -> poneyBuilder.ajouterRenes("noirs");
            case 2 -> poneyBuilder.ajouterRenes("roses");
        }
        afficherTableauCouvreReins();
        int couvreReins = 0;
        couvreReins = demanderChoix("Veuillez choisir vos couvre reins: ", 1, 3);
        switch (couvreReins){
            case 1 -> poneyBuilder.ajouterCouvreReins("violet");
            case 2 -> poneyBuilder.ajouterCouvreReins("rose");
            case 3 -> poneyBuilder.ajouterCouvreReins("bleu");
        }
        /*
        Finalement on peut build de façon "fluent" notre poney grâce notre methode build()
         */
        Poney poney = poneyBuilder.build();
        /*
        Vient l'instant de proposer les activités à notre utilisateur
         */
        afficherTableauActivites();
        String saisie;
        int coutTotal = 0;
        boolean choixEffectue = false;
        int activite;

        System.out.println("Souhaitez-vous ajouter une nouvelle activité (O/N)");
        saisie = scanner.nextLine();
        /*
        J'ai emprunter ce bout de code directement du projet Kart mais sans grand succès. Hélas le temps me manque
        et je ne suis pas parvenu à faire en sorte que si l'utilisateur saisit autre chose que "O" ou "N" mon programme
        lui redemande à nouveau de faire un choix.
         */
        while (saisie.equalsIgnoreCase("O")) {
            activite = demanderChoix("Entrez le numéro de l'activité : ", 1, 4);
            choixEffectue = true;

            switch (activite) {
                case 1 -> stage = new Soins(stage);
                case 2 -> stage = new Balade(stage);
                case 3 -> stage = new PonyGames(stage);
                case 4 -> stage = new SautObstacle(stage);
            }
        /*
        On a déclaré plus haut une Liste de String, ce qui va me permettre de stocké les activités choisis
        On va également incrémenter la variable coutTotal pour à la fin obtenir le prix du stage.
         */
            activites.add(valueOf(stage.getActivites()));
            activites.add(stage.getActivites().get(stage.getActivites().size() - 1));
            coutTotal += stage.getPrix();

            System.out.println("Souhaitez-vous ajouter une autre activité (O/N)");
            saisie = scanner.nextLine();
        }

        if (choixEffectue) {
            System.out.println("Activités choisies :");
            for (String activiteChoisie : activites) {
                System.out.println("- " + activiteChoisie);
            }
            System.out.println("Coût total : " + coutTotal);
        } else {
            System.out.println("Vous devez choisir au moins une activité.");
        }
        /*
        Notre utilisateur ne sera plus inconnu puisqu'on va lui demander son nom!
         */
        System.out.println("Veuillez saisir votre nom: ");
        String nom = scanner.nextLine();
        cavalier = new Cavalier(nom);
        /*
        On utilise ici le pattern factory pour générer un numéro de stage
         */
        codeFactory = CodeFactoryImpl.getInstance();
        stage.setCode(codeFactory.fabriquerCode());
        System.out.println(stage.getCode());
        /*
        Enfin on affiche un récapitulatif du stage à notre utilisateur
         */
        System.out.println("Récapitulatif du stage :");
        System.out.println("Nom du cavalier : " + cavalier.getNom());
        System.out.println("Poney : " + poney.getNom());
        System.out.println("Équipements du poney :");
        System.out.println("- Selle : " + poney.getSelle());
        System.out.println("- Bride : " + poney.getBride());
        System.out.println("- Rênes : " + poney.getRenes());
        System.out.println("- Couvre-reins : " + poney.getCouvreReins());
        System.out.println("Activités : ");
        for (String activiteChoisie : activites) {
            System.out.println("- " + activiteChoisie);
        }
        System.out.println("Coût total du stage : " + coutTotal + " €");
        System.out.println("Numéro de séjour : " + stage.getCode());
    }

    public static void afficherPoney(Poney poney) {
        System.out.println("Récapitulatif du poney :");
        System.out.println("Nom du poney : " + poney.getNom());
        System.out.println("Couvre-reins : " + poney.getCouvreReins());
        System.out.println("Selle : " + poney.getSelle());
        System.out.println("Bride : " + poney.getBride());
        System.out.println("Rênes : " + poney.getRenes());
        // Ajoutez d'autres informations spécifiques au poney selon vos besoins
        System.out.println();
    }
    /*
    Le sujet Kart est une mine d'or, cette méthode me pemet de gérer le choix de l'utilisateur
    et ainsi de gérer les cas où la saisie serait incorrect!!!
     */
    private static int demanderChoix(String message, int borneMin, int borneMax) {
        int valeur = borneMin - 1;
        do {
            System.out.print(message);
            try {
                String saisie = scanner.nextLine();
                valeur = Integer.parseInt(saisie);
                if (valeur < borneMin || valeur > borneMax) {
                    System.out.println("Merci de saisir un nombre compris entre " + borneMin + " et " + borneMax);
                }
            } catch (Exception e) {
                System.out.println("Merci de saisir un nombre");
            }

        } while (!(valeur >= borneMin && valeur <= borneMax));
        return valeur;
    }
    /*
    Les fonctions suivantes vont me permettre d'afficher les equipements obligatoires à mettre
    sur le poney, et à construire l'objet poney au fur et à mesure.
     */
    public static void afficherTableauSelles() {
        System.out.println("Tableau des selles disponibles :\n");
        System.out.println("\u001B[34m+---------+--------------------------+");
        System.out.println("|  \u001B[36mChoix  \u001B[34m|       \u001B[36mSelle              \u001B[34m|");
        System.out.println("+---------+--------------------------+");
        System.out.println("|   \u001B[32m1     \u001B[34m| Cuir de buffle           |");
        System.out.println("|   \u001B[32m2     \u001B[34m| Matière synthétique      |");
        System.out.println("+---------+--------------------------+\u001B[0m");
    }
    public static void afficherTableauBrides() {
        System.out.println("Tableau des brides disponibles :\n");
        System.out.println("\u001B[34m+---------+--------------------------+");
        System.out.println("|  \u001B[36mChoix  \u001B[34m|          \u001B[36mBride           \u001B[34m|");
        System.out.println("+---------+--------------------------+");
        System.out.println("|   \u001B[32m1     \u001B[34m|         \u001B[35mRose             \u001B[34m|");
        System.out.println("|   \u001B[32m2     \u001B[34m|         \u001B[35mBleu             \u001B[34m|");
        System.out.println("+---------+--------------------------+\u001B[0m");
    }
    public static void afficherTableauRenes() {
        System.out.println("Tableau des rênes disponibles :\n");
        System.out.println("\u001B[34m+---------+--------------------------+");
        System.out.println("|  \u001B[36mChoix  \u001B[34m|          \u001B[36mRênes           \u001B[34m|");
        System.out.println("+---------+--------------------------+");
        System.out.println("|   \u001B[32m1     \u001B[34m|         \u001B[35mRoses            \u001B[34m|");
        System.out.println("|   \u001B[32m2     \u001B[34m|         \u001B[35mNoires           \u001B[34m|");
        System.out.println("+---------+--------------------------+\u001B[0m");
    }
    public static void afficherTableauCouvreReins() {
        System.out.println("Tableau des couvre-reins disponibles :\n");
        System.out.println("\u001B[34m+---------+--------------------------+");
        System.out.println("|  \u001B[36mChoix  \u001B[34m|      \u001B[36mCouvre-reins        \u001B[34m|");
        System.out.println("+---------+--------------------------+");
        System.out.println("|   \u001B[32m1     \u001B[34m|         \u001B[35mViolet           \u001B[34m|");
        System.out.println("|   \u001B[32m2     \u001B[34m|         \u001B[35mRose             \u001B[34m|");
        System.out.println("|   \u001B[32m3     \u001B[34m|         \u001B[35mBleu             \u001B[34m|");
        System.out.println("+---------+--------------------------+\u001B[0m");
    }
    /*
    Fin de la partie equipement du poney
     */
    public static void afficherTableauActivites() {
        System.out.println("Tableau des activités disponibles :\n");
        System.out.println("\u001B[34m+---------+-------------------+--------+");
        System.out.println("|   \u001B[36mId    \u001B[34m|     \u001B[36mActivité      \u001B[34m| \u001B[36mTarif  \u001B[34m|");
        System.out.println("+---------+-------------------+--------+");
        System.out.println("|    \u001B[32m1    \u001B[34m|       \u001B[35mSoins       \u001B[34m|   \u001B[35m25   \u001B[34m|");
        System.out.println("|    \u001B[32m2    \u001B[34m|      \u001B[35mBalade       \u001B[34m|   \u001B[35m35   \u001B[34m|");
        System.out.println("|    \u001B[32m3    \u001B[34m|    \u001B[35mPony-Games     \u001B[34m|   \u001B[35m20   \u001B[34m|");
        System.out.println("|    \u001B[32m4    \u001B[34m| Saut d'obstacles  \u001B[34m|   \u001B[35m40   \u001B[34m|");
        System.out.println("+---------+-------------------+--------+\u001B[0m");
    }
}

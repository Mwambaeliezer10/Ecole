import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ecole {
    private HashSet<String> cours;
    private Map<String, ArrayList<String>> etudiantsParCours;
    private Map<String, Map<String, Double>> notesParCours;

    public Ecole() {
        this.cours = new HashSet<>();
        this.etudiantsParCours = new LinkedHashMap<>();
        this.notesParCours = new LinkedHashMap<>();
    }


     //Inscrit un étudiant à un cours.



    public void enrollStudent(String cours, String etudiant) {
        if (!this.cours.contains(cours)) {
            this.cours.add(cours);
            this.etudiantsParCours.put(cours, new ArrayList<>());
            this.notesParCours.put(cours, new LinkedHashMap<>());
        }

        if (!this.etudiantsParCours.get(cours).contains(etudiant)) {
            this.etudiantsParCours.get(cours).add(etudiant);
            this.notesParCours.get(cours).put(etudiant, 0.0);
        }
    }


     // Attribue une note à un étudiant dans un cours.


    public void assignGrade(String cours, String etudiant, double note) {
        if (this.cours.contains(cours) && this.etudiantsParCours.get(cours).contains(etudiant)) {
            this.notesParCours.get(cours).put(etudiant, note);
        }
    }


     //Affiche les étudiants inscrits dans un cours.

    public void listStudentsInCourse(String cours) {
        if (this.cours.contains(cours)) {
            System.out.println("Étudiants inscrits dans le cours " + cours + " :");
            for (String etudiant : this.etudiantsParCours.get(cours)) {
                System.out.println(etudiant);
            }
        }
    }

    public static void main(String[] args) {
        Ecole ecole = new Ecole();

        ecole.enrollStudent("Mathématiques", "Eliezer");
        ecole.enrollStudent("Chimie", "Mwamba");
        ecole.enrollStudent("Physique", "Elie");

        ecole.assignGrade("Mathématiques", "Eliezer", 18.0);
        ecole.assignGrade("Chimie", "Mwamba", 19.0);
        ecole.assignGrade("Physique", "Elie", 19.7);

        ecole.listStudentsInCourse("Chimie");
    }
}

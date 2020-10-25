package nom;

public class Utilisateur {

	    private String nom;
	    private String prenom;
	    private int age;
	    public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getNom() {
	        return nom;
	    }
	    public void setNom(String nom) throws NomException {
	        if (nom.length() > 10) {
	            throw new NomException("Le nom est trop grand ! (10 caracteres maximum)");
	        }
	        else {
	            this.nom = nom; 
	        }
	    }
	    public String getPrenom() {
	        return prenom;
	    }
	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }
}

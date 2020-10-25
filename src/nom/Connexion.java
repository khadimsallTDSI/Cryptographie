package nom;

import javax.servlet.http.HttpServletRequest;

public class Connexion {
	private String resultat;
	public void verifierIdentification(HttpServletRequest request) {
		String login=request.getParameter("login");
		String pass=request.getParameter("pass");
		if(pass.equals(login+"1234")) {
			resultat="vous etes bien connectes";
		}else
			resultat="Incorrect";
		
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	

}

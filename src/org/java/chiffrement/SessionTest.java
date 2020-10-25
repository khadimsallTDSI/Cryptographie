package org.java.chiffrement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nom.*;
import org.java.dao.*;
/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	    Noms tableNoms = new Noms();
       try {
		request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
	} catch (NomException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	Cookie[] cookies=request.getCookies();
    	if(cookies!=null) {
    		for(Cookie cookie: cookies) {
    			if(cookie.getName().contentEquals("prenom")) {
    				request.setAttribute("prenom", cookie.getValue());
    				
    			}
    		}
    	}
    	
    	
    	this.getServletContext().getRequestDispatcher("/WEB-INF/session.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Utilisateur utilisateur = new Utilisateur();
	        try {
				utilisateur.setNom(request.getParameter("nom"));
			} catch (NomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        utilisateur.setPrenom(request.getParameter("prenom"));
	        utilisateur.setPrenom(request.getParameter("age"));
	        Noms tableNoms = new Noms();
	        tableNoms.ajouterUtilisateur(utilisateur);
	        
	        try {
				request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
			} catch (NomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        
	        HttpSession session = request.getSession();

	        session.setAttribute("nom", nom);
	        session.setAttribute("prenom", prenom);
	        Cookie cookie=new Cookie("prenom",prenom);
	        cookie.setMaxAge(60 * 60 * 24 * 30);
	        response.addCookie(cookie);
	        
		this.getServletContext().getRequestDispatcher("/WEB-INF/session.jsp").forward(request, response);
	}

}

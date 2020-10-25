package org.java.chiffrement;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import nom.ByteHex;

/**
 * Servlet implementation class Historique
 */
@WebServlet("/Historique")
public class Historique extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Historique() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String secretKey3 = null;
		SecretKey secretKey2;
		String publicKey=null;
		String privateKey=null;

	    /* Chargement du driver JDBC pour MySQL */
	    try {
	       System.out.println( "Chargement du driver..." );
	        Class.forName( "com.mysql.jdbc.Driver" );
	        System.out.println( "Driver chargé !" );
	    } catch ( ClassNotFoundException e1 ) {
	    	 System.out.println( e1.getMessage() );
	    }

	    /* Connexion à la base de données */
	    String url = "jdbc:mysql://localhost:3306/crypto?characterEncoding=utf8";
	    String utilisateur = "root";
	    String motDePasse = "        ";
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    
	    
	    try {
	        Object messages;
			 System.out.println( "Connexion à la base de données..." );
	        connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );
	        System.out.println( "Connexion réussie !" );

	        /* Création de l'objet gérant les requêtes */
	        statement = (Statement) connexion.createStatement();
	        System.out.println( "Objet requête créé !" );
	        String lieu="touba";
	        String adresse="ndiogo";
	        String del="sss";
	       // String requete="INSERT INTO Cle(`secretKey`, `privateLey`, `publicKey`) VALUES('"+null+"','"+ByteHex.bytesToHex(priv.getEncoded())+"','"+ByteHex.bytesToHex(pub.getEncoded())+"')";
	      //  statement.executeUpdate(requete);
	        System.out.println( "Insertion réussie !" );

	        /* Exécution d'une requête de lecture */
	        resultat = statement.executeQuery("SELECT secretKey, privateLey, publicKey FROM Cle;" );
	        System.out.println( "Requête \"SELECT nom, prenom, email FROM Cle;\" effectuée !" );
	        
	       
	       
	        
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            //int idUtilisateur = resultat.getInt( "id" );
	            secretKey3 = resultat.getString( "secretKey" );
	             privateKey = resultat.getString( "privateLey" );
	             publicKey = resultat.getString( "publicKey" );
	            /* Formatage des données pour affichage dans la JSP finale. */
	            System.out.println( "Données retournées par la requête :  ");
	            System.out.println("secret Key = " + secretKey3 );
	            System.out.println("Private Key  = " + privateKey );		
	            System.out.println("public Key = " + publicKey );
				request.setAttribute("secret", secretKey3);
				request.setAttribute("publicKey",  publicKey);

				request.setAttribute("priv", privateKey);

				

	        }
	        System.out.println(secretKey3);
	    } catch ( SQLException e2 ) {
	    	 System.out.println( "Erreur lors de la connexion : <br/>"
	                + e2.getMessage() );
	    } finally {
	    	 System.out.println( "Fermeture de l'objet ResultSet." );
	        if ( resultat != null ) {
	            try {
	                resultat.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	        System.out.println( "Fermeture de l'objet Statement." );
	        if ( statement != null ) {
	            try {
	                statement.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	        System.out.println( "Fermeture de l'objet Connection." );
	        if ( connexion != null ) {
	            try {
	                connexion.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	    }	
    	this.getServletContext().getRequestDispatcher("/WEB-INF/historique.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	

}

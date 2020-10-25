package org.java.chiffrement;

import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.dao.DaoException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import nom.ByteHex;
import nom.ConnexionBD;
import nom.SaveKey;

/**
 * Servlet implementation class CleSecrete
 */
@WebServlet("/CleSecrete")
public class CleSecrete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	KeyPair keyPair = null;
	KeyPairGenerator keyPairGen;
	PrivateKey priv = null;
	PublicKey pub = null;
	
	String secretKey3 = null;
	SecretKey secretKey2;
	String publicKey=null;
	String privateKey=null;
	String secretKey1 = null;
    String algoAES="AES";
	String algoDES="DES";
	String algo,proviDer;
	//String algo = null;
	String provider="SunJCE";
	int tailleAES=nom.GeneratePaireKeyDH.taille3;
	int tailleDES=nom.GeneratePaireKeyDH.taille4;

	SecretKey secretKey = null;
	KeyGenerator keyGen = null;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("algo1", algoAES); 
		request.setAttribute("algo2", algoDES);


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
		       // Object messages;
				 System.out.println( "Connexion à la base de données..." );
		        connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );
		        System.out.println( "Connexion réussie !" );
		        
		        
		        

		    	try {
		    		if(algoAES=="AES" ) {
						//request.setAttribute("algo2", algoDES);
						request.setAttribute("provider", provider);
						request.setAttribute("taille",tailleAES);
						//request.setAttribute("taille1", tailleDES);
		    			
		    	    keyGen=KeyGenerator.getInstance(algoAES, provider);
		    		keyGen.init(tailleAES);
		    		
		    		}
		    		if(algoDES=="DES" ) {
		    			//request.setAttribute("algo1", algoAES); 
						request.setAttribute("provider", provider);
						//request.setAttribute("taille",tailleAES);
						request.setAttribute("taille1", tailleDES);
		    			
		    		    keyGen=KeyGenerator.getInstance(algoDES, provider);
		    			keyGen.init(tailleDES);
		    			  
		    			}
		    		if(algoDES=="DES" &&  tailleDES > 56  || algoAES=="AES" &&  tailleAES <128) {
		    		   // keyGen=KeyGenerator.getInstance(algoDES, provider);
		    			//keyGen.init(tailleDES);
		    			//secretKey=keyGen.generateKey();
		    		//System.out.println("la cle AES: "+ByteHex.bytesToHex(secretKey.getEncoded()));
		    		    throw new DaoException("L'algorithme et la taille ne doivent pas etre ensemble ");
		                

		    		}
		    		//secretKey=keyGen.generateKey();

		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		        
		        
	    		secretKey=keyGen.generateKey();


		        /* Création de l'objet gérant les requêtes */
		        statement = (Statement) connexion.createStatement();
		        System.out.println( "Objet requête créé !" );
		        String lieu="touba";
		        String adresse="ndiogo";
		        String del="sss";
		       // String requete="INSERT INTO Cle(`secretKey`, `privateLey`, `publicKey`) VALUES('"+ByteHex.bytesToHex(secretKey.getEncoded())+"','"+priv+"','"+pub+"')";
		      //  statement.executeUpdate(requete);
		       // System.out.println( "Insertion réussie !" );
		        
		        String requete="INSERT INTO Cle(`secretKey`, `privateLey`, `publicKey`) VALUES('"+ByteHex.bytesToHex(secretKey.getEncoded())+"','"+priv+"','"+pub+"')";
		        statement.executeUpdate(requete);
		        System.out.println( "Insertion réussie !" );
		        

		        /* Exécution d'une requête de lecture */
		        resultat = statement.executeQuery("SELECT secretKey, privateLey, publicKey FROM Cle ORDER BY id DESC LIMIT 0,1;" );
		        System.out.println( "Requête \"SELECT nom, prenom, email FROM Cle;\" effectuée !" );
		        
		      
		 
		        /* Récupération des données du résultat de la requête de lecture */
		        while ( resultat.next() ) {
		            //int idUtilisateur = resultat.getInt( "id" );
		            secretKey3 = resultat.getString( "secretKey" );
		             privateKey = resultat.getString( "privateLey" );
		             publicKey = resultat.getString( "publicKey" );
		            /* Formatage des données pour affichage dans la JSP finale. */
		            System.out.println( "Données retournées par la requête : seret Key = " + secretKey3 + ", privateKey = " + privateKey
		                    + ", motdepasse = "
		                + ", public Key = " + publicKey + "." );
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
		

		  try {

				

				request.setAttribute("secret",ByteHex.bytesToHex(secretKey.getEncoded()) ); 
		  }catch (Exception e) {
	            request.setAttribute("erreur", e.getMessage());
	            System.out.println(e.getMessage());
	        }
		
		
		
		
	
		//this.getServletContext().getRequestDispatcher("/WEB-INF/Secret.jsp").forward(request, response);
       // ByteHex.bytesToHex( bd.secret().getEncoded()))
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Secret.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	    
	   
		
  
	
}
}

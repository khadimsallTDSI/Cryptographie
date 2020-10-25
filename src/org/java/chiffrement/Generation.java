package org.java.chiffrement;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
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
 * Servlet implementation class Generation
 */
@WebServlet("/Generation")
public class Generation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Generation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String provider1 = nom.GeneratePaireKeyDH.provider1;
		String algo1 = nom.GeneratePaireKeyDH.algo1;
		int taille1 = nom.GeneratePaireKeyDH.taille1;
		int taille2 = nom.GeneratePaireKeyDH.taille2;
		int taille = taille1;

		request.setAttribute("algo1", algo1);
		request.setAttribute("provider1", provider1);
		request.setAttribute("taille1", taille1);
		request.setAttribute("taille2", taille2);

		// DSA

		String provider2 = nom.GeneratePaireKeyDH.provider2;
		String provider3 = nom.GeneratePaireKeyDH.provider3;

		String algo2 = nom.GeneratePaireKeyDH.algo2;
		String algo3 = nom.GeneratePaireKeyDH.algo3;

		request.setAttribute("algo2", algo2);
		request.setAttribute("algo3", algo3);

		request.setAttribute("provider2", provider2);
		request.setAttribute("provider3", provider3);
		
		

				SecureRandom secureRandom = new SecureRandom();
				byte bytes[] = new byte[20];
				secureRandom.nextBytes(bytes);
				KeyPair keyPair = null;
				KeyPairGenerator keyPairGen;
				PrivateKey priv = null;
				PublicKey pub = null;
				try {

					// DH GEneration key

					if (taille == taille1 && provider1 == "SunJCE" && algo1 == "DH") {
						keyPairGen = KeyPairGenerator.getInstance(algo1, provider1);
						keyPairGen.initialize(taille1, secureRandom);

						keyPair = keyPairGen.generateKeyPair();
						// cle private
						priv = keyPair.getPrivate();
						pub = keyPair.getPublic();
					}

					if (taille == taille2 && provider2 == "Sun" && algo2 == "DSA") {
						keyPairGen = KeyPairGenerator.getInstance(algo2, provider2);
						keyPairGen.initialize(taille2, secureRandom);
						keyPair = keyPairGen.generateKeyPair();
						// cle private
						priv = keyPair.getPrivate();
						pub = keyPair.getPublic();
					}

					if (taille == taille2 && provider2 == "SunJCE" && algo2 == "DSA") {
						keyPairGen = KeyPairGenerator.getInstance(algo2, provider2);
						keyPairGen.initialize(taille2, secureRandom);
						keyPair = keyPairGen.generateKeyPair();
						// cle private
						priv = keyPair.getPrivate();
						pub = keyPair.getPublic();
					}

					if (taille == taille1 && provider2 == "Sun" && algo2 == "DSA") {
						keyPairGen = KeyPairGenerator.getInstance(algo2, provider2);
						keyPairGen.initialize(taille1, secureRandom);
						keyPair = keyPairGen.generateKeyPair();
						// cle private
						priv = keyPair.getPrivate();
						pub = keyPair.getPublic();
					}
					if (taille == taille1 && provider2 == "Sun" && algo2 == "DH") {
						keyPairGen = KeyPairGenerator.getInstance(algo2, provider2);
						keyPairGen.initialize(taille1, secureRandom);
						keyPair = keyPairGen.generateKeyPair();
						// cle private
						priv = keyPair.getPrivate();
						pub = keyPair.getPublic();
					}

					if (taille == taille1 && provider3 == "SunRsaSign" && algo3 == "RSA") {
						keyPairGen = KeyPairGenerator.getInstance(algo3, provider3);
						keyPairGen.initialize(taille1, secureRandom);
						keyPair = keyPairGen.generateKeyPair();
						// cle private
						priv = keyPair.getPrivate();
						pub = keyPair.getPublic();
					}

					// DSA Generation key

					// System.out.println("cle private DSA:
					// "+ByteHex.bytesToHex(priv.getEncoded()));
					// cl� public

					// System.out.println("cle public DSA: "+ByteHex.bytesToHex(pub.getEncoded()));

					// Vue dans la page JSP
					request.setAttribute("pub", ByteHex.bytesToHex(pub.getEncoded()));
					request.setAttribute("priv", ByteHex.bytesToHex(priv.getEncoded()));

				} catch (Exception e) {
					e.printStackTrace();
				}
		
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
			        String requete="INSERT INTO Cle(`secretKey`, `privateLey`, `publicKey`) VALUES('"+null+"','"+ByteHex.bytesToHex(priv.getEncoded())+"','"+ByteHex.bytesToHex(pub.getEncoded())+"')";
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
			            System.out.println( "Données retournées par la requête :  secret Key = " + secretKey3 + ", privateKey = " + privateKey
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
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}

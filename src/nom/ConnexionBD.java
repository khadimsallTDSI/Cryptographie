package nom;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.java.dao.DaoException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnexionBD {
//public static void main(String[] args) {
	KeyPair keyPair = null;
	KeyPairGenerator keyPairGen;
	PrivateKey priv = null;
	PublicKey pub = null;
	public SecretKey secret() {
	String secretKey3 = null;
	SecretKey secretKey2;
	String publicKey=null;
	String privateKey=null;
	String secretKey1 = null;
    String algoAES="AES";
	String algoDES="DES";
	//String algo = null;
	String provider="SunJCE";
	int tailleAES=nom.GeneratePaireKeyDH.taille3;
	int tailleDES=nom.GeneratePaireKeyDH.taille4;

	SecretKey secretKey = null;
	KeyGenerator keyGen = null;

	try {
		if(algoAES=="AES") {
	    keyGen=KeyGenerator.getInstance(algoAES, provider);
		keyGen.init(tailleAES);
		//secretKey=keyGen.generateKey();
		}
		if(algoDES=="DES") {
		    keyGen=KeyGenerator.getInstance(algoDES, provider);
			keyGen.init(tailleDES);
			//secretKey=keyGen.generateKey();
			}
		if(algoDES=="DES" &&  tailleDES > 56) {
		    keyGen=KeyGenerator.getInstance(algoDES, provider);
			//keyGen.init(tailleDES);
			//secretKey=keyGen.generateKey();
		//System.out.println("la cle AES: "+ByteHex.bytesToHex(secretKey.getEncoded()));
		    throw new DaoException("L'algorithme et la taille ne doivent pas etre ensemble)");
		}
		secretKey=keyGen.generateKey();

	}catch(Exception e) {
		e.printStackTrace();
	}

	
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
	   // secretKey2=ByteHex.bytesToHex(secretKey1.getEncoded());
	    
	   
		return  secretKey;
} 

	
	
}
	    

	    
	

	
	


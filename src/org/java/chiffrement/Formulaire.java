package org.java.chiffrement;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.taglibs.standard.extra.spath.Path;

import nom.ByteHex;
import nom.Connexion;
import nom.ConnexionBD;

/**
 * Servlet implementation class Formulaire
 */
@WebServlet("/Formulaire")
public class Formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final int TAILLE_TAMPON = 10240;
	 public static final String CHEMIN_FICHIERS = "/Users/mac/Desktop";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formulaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		  //  String fichier=request.getParameter("fichier");
		   // String fichier=request.getParameter("fichier");

			//HttpSession session =request.getSession();		
		//	session.setAttribute("fichier",fichier);
	      //  System.out.println("hhhhhhhhh"+fichier);
	        
	    	
	      
        	
	        
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
        
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connexion form=new Connexion();
//		form.verifierIdentification(request);
		request.setAttribute("form", form);
		
		//SecretKey test= nom.SaveKey.saveSecretKey();
		
		ConnexionBD bd=new ConnexionBD();  
		System.out.println(bd.secret());
		
		String nom=request.getParameter("nom");
		request.setAttribute("nom", nom);
		
		 // On r�cup�re le champ description comme d'habitude
        String description = request.getParameter("description");
        request.setAttribute("description", description );
        
    
        // On r�cup�re le champ du fichier
        Part part = request.getPart("fichier");
        // On v�rifie qu'on a bien re�u un fichier
        String nomFichier = getNomFichier(part);

        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty()) {
            String nomChamp = part.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                    .substring(nomFichier.lastIndexOf('\\') + 1);

            // On �crit d�finitivement le fichier sur le disque
            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

            request.setAttribute(nomChamp, nomFichier);
            System.out.println(nomFichier);
        }
		
        
        try {
        	
        	
			KeyGenerator keyGen=KeyGenerator.getInstance("AES");
			keyGen.init(128);
			SecretKey secretKey=keyGen.generateKey();
			
			FileInputStream fl=new FileInputStream("/Users/mac/"+nomFichier);
			FileOutputStream fos=new FileOutputStream("/Users/mac/sortie1.txt");
			
			 BufferedReader in = new BufferedReader(new FileReader("/Users/mac/"+nomFichier));
				String line;
				byte [] message = null;
				while ((line = in.readLine()) != null)
				{
			      // Afficher le contenu du fichier
					  System.out.println (line);
						request.setAttribute("line", line);
						 message=line.getBytes();
						 Cipher cipher=Cipher.getInstance("AES");
						 cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				}
				in.close();
				//ConnexionBD bd=new ConnexionBD();
				
				//System.out.println(test);
				Cipher cipher=Cipher.getInstance("AES");
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				
				CipherInputStream cis=new CipherInputStream(fl,cipher);
				
				
				
			//	cipher.init(Cipher.ENCRYPT_MODE,secretKey);
											
					
					byte [] textCipher=cipher.doFinal(message);
					System.out.println("message chiffrer: "+ByteHex.bytesToHex(textCipher));
					request.setAttribute("chiffrer", ByteHex.bytesToHex(textCipher));
				
				
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        
        
        
        
        
        
        String clair=request.getParameter("clair");
		//HttpSession session =request.getSession();		
		//session.setAttribute("test",plainText);
		System.out.println(" Plain Text " +clair);
		
		SecureRandom secureRandom=new SecureRandom();
		byte bytes[]=new byte[100];
		secureRandom.nextBytes(bytes);
	
		byte[] textCipher = null;
		byte[] message;
	try {
		message=clair.getBytes();
		KeyPairGenerator keyPairGen= KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024, secureRandom);
		KeyPair keyPair=keyPairGen.generateKeyPair();
		// cle private
		PrivateKey priv=keyPair.getPrivate();
		//System.out.println("cl� private RSA: "+ByteHex.bytesToHex(priv.getEncoded()));
		// cl� public
		PublicKey pub=keyPair.getPublic();
		//System.out.println("cl� public RSA: "+ByteHex.bytesToHex(pub.getEncoded()));
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pub);
		textCipher=cipher.doFinal(message);
		//System.out.println("Message Chiffrer: "+textCipher);
		
		System.out.println("Text Chiffre "+ ByteHex.bytesToHex(textCipher));
		
		request.setAttribute("chiffrer", ByteHex.bytesToHex(textCipher));

		// dechiffrer
		Cipher c=Cipher.getInstance("RSA");
		c.init(Cipher.DECRYPT_MODE, priv);
		byte[] clair1=c.doFinal(textCipher);
		System.out.println("message dechiffrer: "+clair1);
		
		
		
	}catch(Exception e) {
		e.printStackTrace();	
		}
		
		

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
		
		
	}
	 private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
	        BufferedInputStream entree = null;
	        BufferedOutputStream sortie = null;
	        try {
	            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
	            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

	            byte[] tampon = new byte[TAILLE_TAMPON];
	            int longueur;
	            while ((longueur = entree.read(tampon)) > 0) {
	                sortie.write(tampon, 0, longueur);
	            }
	        } finally {
	            try {
	                sortie.close();
	            } catch (IOException ignore) {
	            }
	            try {
	                entree.close();
	            } catch (IOException ignore) {
	            }
	        }
	    }
	    
	    private static String getNomFichier( Part part ) {
	        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	            if ( contentDisposition.trim().startsWith( "filename" ) ) {
	                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
	            }
	        }
	        return null;
	    }   

}

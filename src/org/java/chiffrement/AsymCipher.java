package org.java.chiffrement;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nom.ByteHex;

/**
 * Servlet implementation class AsymCipher
 */
@WebServlet("/AsymCipher")
public class AsymCipher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsymCipher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plainText=request.getParameter("plainText");
	this.getServletContext().getRequestDispatcher("/WEB-INF/AsymCipher.jsp").forward(request, response);

	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String plainText=request.getParameter("plainText");
				//HttpSession session =request.getSession();		
				//session.setAttribute("test",plainText);
				System.out.println(" Plain Text " +plainText);
				
				SecureRandom secureRandom=new SecureRandom();
				byte bytes[]=new byte[100];
				secureRandom.nextBytes(bytes);
			
				byte[] textCipher = null;
				
			try {
				byte[] message=plainText.getBytes();
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
				byte[] clair=c.doFinal(textCipher);
				System.out.println("message dechiffrer: "+clair);
				
				
				
			}catch(Exception e) {
				e.printStackTrace();	
				}
			this.getServletContext().getRequestDispatcher("/WEB-INF/AsymCipher.jsp").forward(request, response);

	}

}

package org.java.chiffrement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
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

import nom.ByteHex;
import nom.ConnexionBD;
import nom.SaveKey;

/**
 * Servlet implementation class Chiffrement
 */
@WebServlet("/Chiffrement")
public class Chiffrement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //public static final String PLAIN_TEXT = "plainText";

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Chiffrement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//SaveKey a=new SaveKey();
		String plainText=request.getParameter("plainText");
		HttpSession session =request.getSession();		
		session.setAttribute("test",plainText);
		//ConnexionBD bd=new ConnexionBD();
		
		
		
		
		
		try {
			KeyGenerator keyGen =KeyGenerator.getInstance("AES");
			keyGen.init(128);
			SecretKey secretKey=keyGen.generateKey();
			Scanner sc=new Scanner(System.in);
			//System.out.println("Entrer le text � chiffrer");
			//String plainText=sc.next();
			byte[] message=plainText.getBytes();
			try {
				Cipher cipher=Cipher.getInstance("AES");
				try {
					cipher.init(Cipher.ENCRYPT_MODE,secretKey);
					try {
						byte [] textCipher=cipher.doFinal(message);
						System.out.println("message chiffrer: "+ByteHex.bytesToHex(textCipher));
						
						

						System.out.println("message chiffrer: "+ByteHex.bytesToHex(textCipher));
						request.setAttribute("cipher", ByteHex.bytesToHex(textCipher));
						
					} catch (IllegalBlockSizeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BadPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		this.getServletContext().getRequestDispatcher("/WEB-INF/Chiffrement.jsp").forward(request, response);

	}
	

}



package org.java.chiffrement;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nom.ByteHex;

/**
 * Servlet implementation class Signature
 */
@WebServlet("/Signature")
public class SignatureMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignatureMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.getServletContext().getRequestDispatcher("/WEB-INF/signature.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Signature signature = null;
		String plainText=request.getParameter("plainText");
		byte[] message = plainText.getBytes();

	    KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    keyPairGen.initialize(1024, new SecureRandom());
	    KeyPair keyPair = keyPairGen.generateKeyPair();

	  
		try {
			signature = Signature.getInstance("SHA1withRSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    try {
			signature.initSign(keyPair.getPrivate(), new SecureRandom());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			signature.update(message);
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    byte[] signatureBytes = null;
		try {
			signatureBytes = signature.sign();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(ByteHex.bytesToHex(signatureBytes));

	    try {
			signature.initVerify(keyPair.getPublic());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			signature.update(message);
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			System.out.println(signature.verify(signatureBytes));
			
			
			request.setAttribute("signature", ByteHex.bytesToHex(signatureBytes));
			request.setAttribute("signatureV", signature.verify(signatureBytes));
			
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.getServletContext().getRequestDispatcher("/WEB-INF/signature.jsp").forward(request, response);

	
	}

}

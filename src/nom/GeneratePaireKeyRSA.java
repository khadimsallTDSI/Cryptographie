package nom;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class GeneratePaireKeyRSA {
	
	public static String algo;
	public static int taille;
	
public static String getAlgo() {
		return algo;
	}

	public static void setAlgo(String algo) {
		GeneratePaireKeyRSA.algo = algo;
	}

	
public static void main(String[] args) {
	SecureRandom secureRandom=new SecureRandom();
	byte bytes[]=new byte[20];
	secureRandom.nextBytes(bytes);
try {
	
	KeyPairGenerator keyPairGen= KeyPairGenerator.getInstance(algo,"SunRsaSign");
	keyPairGen.initialize(taille, secureRandom);
	KeyPair keyPair=keyPairGen.generateKeyPair();
	// cle private
	PrivateKey priv=keyPair.getPrivate();
	System.out.println("cle private RSA: "+ByteHex.bytesToHex(priv.getEncoded()));
	// cl� public
	PublicKey pub=keyPair.getPublic();
	System.out.println("cle public RSA: "+ByteHex.bytesToHex(pub.getEncoded()));
	
}catch(Exception e) {
	e.printStackTrace();
}
}
}

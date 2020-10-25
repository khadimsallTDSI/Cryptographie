package nom;

import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.geom.Area;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.KeyStore.SecretKeyEntry;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SaveKey {

	// methode pour l‘enregistrement de la cle secrete dans un KeyStore:
	public SecretKey saveSecretKey() {
		//	byte[] encodedKey = Base64.decode(genSecretKey());
			//SecretKey secrteKey = new SecretKeySpec(encodedKey, 0, 0, null);
		
		
		
		
		String algo1="AES";
		String algo2="DES";
		//String algo = null;
		String provider="SunJCE";
		int taille=nom.GeneratePaireKeyDH.taille3;
		int taille1=nom.GeneratePaireKeyDH.taille4;

		SecretKey secretKey = null;
		KeyGenerator keyGen;
	
		try {
			if(algo1=="AES") {
		    keyGen=KeyGenerator.getInstance(algo1, provider);
			keyGen.init(taille);
			secretKey=keyGen.generateKey();
			}
			if(algo2=="DES") {
			    keyGen=KeyGenerator.getInstance(algo2, provider);
				keyGen.init(taille1);
				secretKey=keyGen.generateKey();
				}
			//System.out.println("la cle AES: "+ByteHex.bytesToHex(secretKey.getEncoded()));
			

		}catch(Exception e) {
			e.printStackTrace();
		}
		return secretKey;
	}
	/*
	 * 
	 * 
	 * 
	 * //enregistrement de la cle secrete: TextComponent area = null; String keyStr
	 * = area.getText(); byte[] decodedKey =
	 * Base64.getDecoder().decode(keyStr.getBytes()); //SecretKey secretKey = new
	 * SecretKeySpec(decodedKey, 0,decodedKey.length, ""); try { FileInputStream
	 * fis=new FileInputStream("/Users/mac/keystore.ks"); FileOutputStream fos =
	 * null; KeyStore keyStore = KeyStore.getInstance("JCEKS"); // obtenir le mot de
	 * passe de l'utilisateur et le flux d'entrée du fichier char[] keyStorePassword
	 * = "passeabc".toCharArray (); SecretKeyEntry skEntry = new
	 * SecretKeyEntry(secretKey); keyStore.load(null,null);
	 * KeyStore.ProtectionParameter protParam = new
	 * KeyStore.PasswordProtection(keyStorePassword);
	 * keyStore.setEntry("secretKeyAlias", skEntry, protParam); fos = new
	 * java.io.FileOutputStream("/Users/mac/keystore.ks"); //Storing the KeyStore
	 * object keyStore.store(fos, keyStorePassword); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * 
	 * 
	 * 
	 * //recuperation de la cle secret a partir du KeyStore public static SecretKey
	 * getSecreteKey2() { SecretKey key = null; try { KeyStore keyStore =
	 * KeyStore.getInstance("JCEKS"); char[] keyStorePassword =
	 * "passeabc".toCharArray (); keyStore.load(new
	 * FileInputStream("/Users/mac/keystore.ks"), keyStorePassword);
	 * 
	 * key = (SecretKey) keyStore.getKey("secretKeyAlias", keyStorePassword);
	 * 
	 * //System.out.println(newString(Base64.getEncoder().encode(key.getEncoded())))
	 * ;
	 * 
	 * System.out.println("Algorithm used to generate key : "+key.getAlgorithm());
	 * System.out.println("Format used for the key: "+key.getFormat());
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return key; }
	 */

	public static void main(String[] args) {
		SaveKey a=new SaveKey();
		System.out.println(ByteHex.bytesToHex(a.saveSecretKey().getEncoded()));
	}

}

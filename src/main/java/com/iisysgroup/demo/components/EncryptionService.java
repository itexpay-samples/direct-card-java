package com.iisysgroup.demo.components;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.iisysgroup.demo.models.EncryptedPayRequest;

@Component
public class EncryptionService {
    private static PublicKey getPublicKey(String base64PublicKey) {
        PublicKey publicKey = null;
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (Exception e) {

        }
        return publicKey;
    }

    public EncryptedPayRequest encryptData(String transactionData, String encryptedPublicKey) {
        EncryptedPayRequest encrypted = null;
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(128);
            SecretKey secKey = generator.generateKey();
            String SencryptKey = Base64.getEncoder().encodeToString(secKey.getEncoded());
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(encryptedPublicKey));
            byte[] encrypt = cipher.doFinal(SencryptKey.getBytes());
            String encyptedkey = Base64.getEncoder().encodeToString(encrypt);
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
            byte[] byteCipherText = aesCipher.doFinal(transactionData.getBytes());
            String encrypteddata = Base64.getEncoder().encodeToString(byteCipherText);

            System.out.println(encrypteddata); // send as data
            System.out.println(encyptedkey); // send as ctx

            encrypted = new EncryptedPayRequest();
            encrypted.setCtx(encyptedkey);
            encrypted.setData(encrypteddata);

        } catch (Exception e) {
            System.out.println(e);

        }
        return encrypted;
    }
}

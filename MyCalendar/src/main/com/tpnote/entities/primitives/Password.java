package com.tpnote.entities.primitives;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Password {
    private final String hashedPassword;
    private final String salt;

    public Password(String password) {
        this.salt = generateSalt();
        this.hashedPassword = hashPassword(password, this.salt);
    }

    private String hashPassword(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Ajouter le salt au mot de passe avant de le hacher
            String saltedPassword = password + salt;
            byte[] hash = digest.digest(saltedPassword.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erreur de hachage : SHA-256 non disponible", e);
        }
    }

    public boolean checkPassword(String password) {
        String hashedInputPassword = hashPassword(password, this.salt);
        return this.hashedPassword.equals(hashedInputPassword);
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16]; // 16 octets pour le salt
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
}

package gt.edu.umg.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class JwtTokenValidator {

    private PublicKey publicKey;

    @Value("${jwt.public-key-path:keys/public_key.pem}")
    private String publicKeyPath;

    @Value("${jwt.issuer:seguridad-api}")
    private String issuer;

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Cargando llave pública RSA desde: " + publicKeyPath);
        
        ClassPathResource resource = new ClassPathResource(publicKeyPath);
        
        if (!resource.exists()) {
            System.err.println("Archivo de llave pública NO ENCONTRADO en: " + publicKeyPath);
            return;
        }
        
        String publicKeyPEM = new String(Files.readAllBytes(resource.getFile().toPath()))
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        byte[] keyBytes = Base64.getDecoder().decode(publicKeyPEM);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        this.publicKey = keyFactory.generatePublic(spec);
        
        System.out.println("Llave pública RSA cargada correctamente");
    }

    public boolean validateToken(String token) {
        try {
            System.out.println("Validando token con RSA...");
            Claims claims = Jwts.parser()
                    .verifyWith(publicKey)  //VALIDA CON LLAVE PÚBLICA
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            
            boolean valid = issuer.equals(claims.getIssuer());
            System.out.println("Token RSA válido: " + valid);
            return valid;
        } catch (Exception e) {
            System.err.println("Error validando token RSA: " + e.getMessage());
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(publicKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return claims.getSubject();
        } catch (Exception e) {
            System.err.println("Error obteniendo username: " + e.getMessage());
            return null;
        }
    }
}
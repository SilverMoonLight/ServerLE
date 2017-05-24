package com.main.config;

import java.security.Key;
import java.util.Date;
import java.util.List;

import io.jsonwebtoken.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.main.controller.ClientController;
import com.main.dataentity.Client;

@Component
public class JWTUtils {

	private String secret = "silvermoonlight";

	private Logger logger = Logger.getLogger(JWTUtils.class);

	public String createJWT(String id, String issuer, long ttlMillis, Client client) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		logger.info("id " + id + " now " + now + " subject " + client.getEmail() + " issuer " + issuer);
		JwtBuilder builder = Jwts.builder();
		builder.signWith(signatureAlgorithm, signingKey);
		
		
		Claims claims = Jwts.claims();
		claims.put("role", client.getRole().getRoleName());
		claims.put("password", client.getPassword());

		builder.setClaims(claims);

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		
		builder.setId(id).setIssuedAt(now).setSubject(client.getEmail()).setIssuer(issuer);

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public JWTAuthenticationToken parseJWT(String jwt) {

		// This line will throw an exception if it is not a signed JWS (as
		// expected)
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(jwt)
				.getBody();
		logger.info("claims" + claims);
		logger.info("ID: " + claims.getId());
		logger.info("Subject: " + claims.getSubject());
		logger.info("Issuer: " + claims.getIssuer());
		logger.info("Expiration: " + claims.getExpiration());
		logger.info("Role " + claims.get("role"));
		
		List<GrantedAuthority> authorityList = AuthorityUtils
				.commaSeparatedStringToAuthorityList((String) claims.get("role"));
		return new JWTAuthenticationToken(claims.getSubject(), claims.get("password"), authorityList);
	}

}

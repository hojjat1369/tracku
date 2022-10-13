package com.ampada.tracku.common.util;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.ampada.tracku.user.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JwtTokenUtil {

	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour

	@Value("${app.jwt.secret}")
	private String SECRET_KEY;

	public String generateAccessToken(User user) {

		return Jwts	.builder()
					.setSubject(String.format("%s", user.getUsername()))
					.setIssuer("tracku")
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
					.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
					.compact();

	}
}

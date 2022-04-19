package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.BaseModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl extends BaseModel implements Serializable,
    com.example.teamb4spring.service.JwtService {
	private static final long serialVersionUID = 121217778817161L;

	@Value("${jwt.signing.key}")
	private String signingKey;

	@Value("${jwt.token.validity}")
	private Long jwtTokenValidity;

	@Override
	public String getUsernameFromToken(String token) throws JwtException {
		return getClaimFromToken(token, Claims::getSubject);
	}

	@Override
	public Date getExpirationDateFromToken(String token) throws JwtException {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	@Override
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) throws JwtException {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) throws JwtException {
		return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) throws JwtException {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	@Override
	public String generateToken(UserDetails userDetails) throws JwtException {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) throws JwtException {
		//@formatter:off
		return Jwts.builder()
				.setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtTokenValidity * 1000))
				.signWith(SignatureAlgorithm.HS512, signingKey)
				.compact();
		//@formatter:on
	}

	@Override
	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}

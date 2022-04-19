package com.example.teamb4spring.filter;

import com.example.teamb4spring.service.JwtServiceImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
	public static final String BEARER_TOKEN = "Bearer ";

	private final JwtServiceImpl jwtService;
	private final UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
									FilterChain filterChain) throws ServletException, IOException {
		String authorization = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
		String jwtToken = null;
		String userName = null;

		if (null != authorization && authorization.startsWith(BEARER_TOKEN)) {
			jwtToken = authorization.substring(BEARER_TOKEN.length());
			userName = jwtService.getUsernameFromToken(jwtToken);
		}

		if (null != userName && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

			if (jwtService.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}

package DashEsgApi.DashEsgApi.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import DashEsgApi.DashEsgApi.model.User;
import DashEsgApi.DashEsgApi.repository.UserRepository;
import DashEsgApi.DashEsgApi.service.TokenService;

@Component
public class FilterToken extends OncePerRequestFilter{
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token;
		
		String authorizationHeader = request.getHeader("Authorization");
		
		if(authorizationHeader != null) {
			token = authorizationHeader.replace("Bearer ", "");
			String subject = this.tokenService.getSubject(token);
			
			User usuario = this.userRepository.findByEmail(subject);
			
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	
}

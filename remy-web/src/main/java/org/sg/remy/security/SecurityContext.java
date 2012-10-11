package org.sg.remy.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;



/**
 * TODO: Java-Based security context
 * http://stackoverflow.com/questions/10013996/referencing-spring-security-configuration-within-spring-3-1-java-config
 * 
 * @author sgoryachkin
 *
 */
@Configuration
@ComponentScan(basePackageClasses = SecurityContext.class)
@ImportResource("classpath:org/sg/remy/security/security-context.xml")
public class SecurityContext {
	/*
	 @Bean
	 public FilterChainProxy filterChainProxy(){
		 return new FilterChainProxy(securityFilterChain());
	 }
	 
	 @Bean
	 public SecurityFilterChain securityFilterChain(){
	     SecurityFilterChain chain = new DefaultSecurityFilterChain(new AntPathRequestMatcher("/**"),
	             filterSecurityInterceptor());
		 return chain;
	 }
	 
	 
	 @Bean
	 public Filter filterSecurityInterceptor(){
		 SecurityExpressionHandler<FilterInvocation> securityExpressionHandler = new DefaultWebSecurityExpressionHandler();
		 
		 FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
	     //filterSecurityInterceptor.setAuthenticationManager(authenticationManager);
	     //filterSecurityInterceptor.setAccessDecisionManager(accessDecisionManager);
	     LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> map = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
	     map.put(new AntPathRequestMatcher("/**"), Arrays.<ConfigAttribute>asList(new SecurityConfig("isAuthenticated()")));
	     ExpressionBasedFilterInvocationSecurityMetadataSource ms = new ExpressionBasedFilterInvocationSecurityMetadataSource(map, securityExpressionHandler);
	     filterSecurityInterceptor.setSecurityMetadataSource(ms);
	     return filterSecurityInterceptor;
		 
	 }
*/
}

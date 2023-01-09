package com.zeus.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.zeus.common.security.CustomAccessDeniedHandler;
import com.zeus.common.security.CustomLoginSuccessHandler;
import com.zeus.common.security.CustomNoOpPasswordEncoder;
import lombok.extern.java.Log;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * 이 DataSource 개체가 나타내는 물리적 데이터 원본에 대한 연결을 위한 팩터리입니다. DriverManager 기능의 대안인
	 * DataSource 개체는 연결을 얻는 데 선호되는 수단입니다. DataSource 인터페이스를 구현하는 개체는 일반적으로
	 * JNDI(Java Naming and Directory) API를 기반으로 하는 이름 지정 서비스에 등록됩니다.
	 */
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config ...");

		// URI 패턴으로 접근 제한을 설정한다.
		http.authorizeRequests().antMatchers("/board/list").permitAll();
		http.authorizeRequests().antMatchers("/board/register").hasRole("MEMBER");
		http.authorizeRequests().antMatchers("/notice/list").permitAll();
		http.authorizeRequests().antMatchers("/notice/register").hasRole("ADMIN");

		// 개발자가 정의한 로그인 페이지의 URI를 지정한다.
		// 로그인 성공 후 처리를 담당하는 처리자로 지정한다.
		http.formLogin().loginPage("/login").successHandler(createAuthenticationSuccessHandler());

		// 로그아웃 처리를 위한 URI를 지정하고, 로그아웃한 후에 세션을 무효화 한다.
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);

		// 등록한 CustomAccessDeniedHandler를 접근 거부 처리자로 지정한다.
		http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 스프링 시큐리티 5 부터는 기본적으로 PasswordEncoder 를 지정해야 한다.
		// JDBC 인증 제공자, 데이터 소스를 지정, 사용자가 정의한 비번 암호화 처리기를 지정한다.
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(createPasswordEncoder());
		// auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new
		// BCryptPasswordEncoder());

		/*
		 * cf.
		 * auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles
		 * ("MEMBER");
		 * auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles(
		 * "ADMIN");
		 */
	}

	// 스프링 시큐리티의 UserDetailsService를 구현한 클래스를 빈으로 등록한다.
	@Bean
	public UserDetailsService createUserDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	// 사용자가 정의한 비번 암호화 처리기를 빈으로 등록한다.
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new /* CustomNoOpPasswordEncoder(); */BCryptPasswordEncoder();
	}
}
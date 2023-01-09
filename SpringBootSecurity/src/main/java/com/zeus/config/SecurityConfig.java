package com.zeus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.zeus.common.security.CustomAccessDeniedHandler;
import com.zeus.common.security.CustomLoginSuccessHandler;
import com.zeus.common.security.CustomLoginSuccessHandler2;

import lombok.extern.slf4j.Slf4j;

/*
 * @Bean어노테이션 : Spring IOC Container에 Bean을 등록하도록 하는 메타데이터를 기입하는 어노테이션
 * Authentication : 사용자가 인증하는 과정을 뜻한다.
 * Authorization : 서버가 사용자에 대한 권한을 부여하는 것을 뜻한다.
 * 
 * Spring Security의 로그인 기능 구현 중 하나, 페이지 별로 권한 주기.
 *  : 어떠한 페이지를 들어갔을 때 특정 권한을 가진 사람만 인가시켜줄 수 있는 기능을 만드는 것이 목표 
 *  : Spring Security 이전 버젼에서는 아래와 같이 WebSecurityConfigurerAdapter을 상속 받은 WebSecurityConfig 클래스를 만들었어야 했다.
 *  	WebSecurityConfig클래스의 config 메서드를 오버라이드 하여 인가, 인증한다. config메서드는 인증, 인가의 기능을 갖춘 객체들을 인자로 가지고 있다.
 *   -> 하지만 WebSecurityConfigurerAdapter는 Deprecated 되었으므로 사용하지 않고 SecurityFilterChain을 Bean으로 등록하여 사용한다.
 */

@Slf4j
@EnableWebSecurity // Spring Security 설정을 시작
public class SecurityConfig extends WebSecurityConfigurerAdapter { // 페이지 별로 권한을 주기 위해 WebSecurityConfigurerAdapter를
																	// 상속한다.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * HttpSecurity - 인증, 인가의 세부적인 기능을 설정할 수 있도록 API를 제공해주는 클래스이다. - 스프링시큐리티의 각종 설정은
		 * HttpSecurity로 한다 - WebSecurityConfigurerAdapter를 상속하여 configure(HttpSecurity
		 * http) 메서드를 오버라이드 해 설정한다.
		 */

		/*
		 * authorizeRequests-접근하는 url에 따라 인가를 설정한다(URI 패턴으로 접근 제한을 설정한다)
		 * .antMatchers()메소드의 String 인자는 인가하는 url를 가리킨다.
		 */
		http.authorizeRequests().antMatchers("/board/list").permitAll(); // .antMatchers("").permitAll() //무조건 접근을 허용

		http.authorizeRequests().antMatchers("/board/register").hasRole("MEMBER"); // .antMatchers("").hasRole("")
																					// 사용자가 주어진 역할이 있다면 접근을 허용

		http.authorizeRequests().antMatchers("/notice/list").permitAll();

		http.authorizeRequests().antMatchers("/notice/register").hasRole("ADMIN");

		/*
		 * http.formLogin()은 form을 통한 로그인 방식에 대해 설정을 한다. 
		 * - 인증이 필요할 때 이동하는 페이지 설정하는 api입니다. 
		 * -해당 api설정을 하지 않을 경우 기본적으로 spring security가 제공하는 템플릿으로 연결됩니다.
		 * 
		 * 예컨대 http.formLogin()메서드만 사용하면, 기본 Spring security의 폼을 따르게 된다.
		 * .loginPage("") // 사용자 정의 로그인 페이지 
		 * .defaultSuccessUrl("") // 로그인 성공 후 이동 페이지
		 * .failureUrl("") // 로그인 실패 후 이동 페이지 
		 * .usernameParameter("") // 아이디 파라미터명 설정
		 * .passwordParameter("") // 패스워드 파라미터명 설정 
		 * .loginProcessingUrl("") // 로그인 Form  Action Url 
		 * .successHandler((request, response, authentication) -> {}) // 로그인 성공 후 핸들러 
		 * .failureHandler((request, response, exception) -> {}); // 로그인 실패 후 핸들러
		 */
		log.info("security config ...");
		// http.formLogin(); : 폼 기반 인증 기능을 사용한다. 
		//-> 기본 Spring security의 폼을 따른다. 기본값은 Spring Security가 "/login"에 로그인 페이지를 생성하고 
		//"/logout"에 로그아웃 페이지를 생성하는 것입니다.
		//->기본 로그인 페이지가 아닌 개발자가 직접 정의한 로그인 페이지를 사용하려면..밑
		
		// 개발자가 정의한 로그인 페이지의 URI를 지정한다.
		//기본값을 사용하지 않기 때문에 기본 로그인 및 로그아웃 페이지는개발자가 작성해야 하며, 애플리케이션은 제공된 URL + "?error"에서 인증 오류 페이지를
		//렌더링해야한다. 제공된 URL에 대한 POST에 대해 인증이 발생한다.
		//작성한 코드로는 인증이 필요할때 "~/loginPage" url로 mapping시켜주게 됩니다.
		/*
		 * http.formLogin() .loginPage("/login"); //loginPage - 로그인할 양식을 제공하는 리디렉션
		 * URL(예: "/login")
		 */		
		
		// 로그인 성공 후 처리를 담당하는 처리자로 지정한다.
		http.formLogin()
		.loginPage("/login")
		.successHandler(createAuthenticationSuccessHandler()); //or .successHandler(createAuthenticationSuccessHandler2());

		/* exceptionHandling().accessDeniedPage
		 * - 접근 거부 처리자의 URI를 지정! 
		 * - url을 지정하여 접근 권한이 없으면 해당 url로 이동시키는 방법.
		http.exceptionHandling().accessDeniedPage("/accessError");*/
		
		/* .exceptionHandling().accessDeniedHandler()
		 * - 등록한 CustomAccessDeniedHandler를 접근 거부 처리자로 지정한다.
		 * - 인터페이스 AccessDeniedHandler를 구현한 클래스를 인자로 받는다.
		 * - 구현 클래스의 행동을 따른다.
		 */
		http.exceptionHandling()
		.accessDeniedHandler(createAccessDeniedHandler());
		
		/*
		 * - 로그아웃 처리를 위한 URI를 지정하고, invalidateHttpSession를 true의 인자로 둠으로써 로그아웃한 후에 세션을 무효화
		 * 한다. 
		 * - 기본값은 URL"/logout"에 액세스하면 HTTP 세션을 무효화하고 구성된 모든 rememberMe() 인증을 정리하고
		 * SecurityContextHolder를 지우고 "/login?success"로 리디렉션하여 사용자를 로그아웃시키는 것입니다.
		 */
		http.logout()
		.logoutUrl("/logout")
		.invalidateHttpSession(true); 
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// AuthenticationManagerBuilder는 스프링 시큐리티의 인증에 대한 지원을 설정하는 메소드를 가지고 있다.

		/* 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다.
		 * 소스 코드에 아이디와 패스워드를 지정하고(메모리에 저장) 로그인을 처리한다.
		 * 스프링 시큐리티는 5 버전부터는 패스워드 암호화 처리기를 반드시 이용하도록 변경되었다.
		 * 여기서는 암호화 처리기를 사용하지 않도록 "{noop}" 문자열을 비밀번호 앞에 사용한다*/
		auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
		
		/*참고 : http.authorizeRequests().antMatchers("/notice/register").hasRole("ADMIN");의
		 * hasRole과 auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");의
		 * roles가 매치되는 것이며, custom이다.
		 */

		/*
		 * inMemoryAuthentication() : 스프링 시큐리티의 인증에 대한 지원을 설정하는 몇 가지 메소드를 가지고 있다.
		 * (return : InMemoryUserDetailsManagerConfigurer)
		 * 
		 * [inMemoryAuthentication의 메소드] withUser() :
		 * UserDetailsManagerConfigurer.UserDetailBuilder를 반환하고, 이는 사용자 암호를 설정하는
		 * password()와 사용자에게 권한에 대한 역할을 부여해 주는 roles()를 포함한 몇 가지 사용자 설정 메소드를 제공한다.
		 * 
		 * [withUser()의 메소드] password(String) : 사용자의 암호를 명시 roles(String...) : 사용자에게 부여된
		 * 역할을 명시
		 * 
		 * 위와 같은 메소드들로 로그인을 커스텀하고, 해당 withUser메소드의 String 인자와 password의 String인자로
		 * loginForm에 로그인할 수 있다.
		 */
	}

	// CustomAccessDeniedHandler를 빈으로 등록한다.
	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	/* @Bean으로 CustomLoginSuccessHandler를 빈으로 등록한다. 
	* 이 메서드는 AuthenticationSuccessHandler를 구현한
	* SavedRequestAwareAuthenticationSuccessHandler를 상속하여 작성한 
	* CustomLoginSuccessHandler를 생성해 로그인 성공작업을 처리한 메서드
	*/ 
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	

	/* @Bean으로 CustomLoginSuccessHandler2를 빈으로 등록한다. 
	* 이 메서드는 AuthenticationSuccessHandler를 직접 개발자가 구현하여 로그인 성공시
	* 작업을 작성한  CustomLoginSuccessHandler2를 생성해 로그인 성공작업을 처리한 메서드
	*/ 
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler2() {
		return new CustomLoginSuccessHandler2();
	}
}

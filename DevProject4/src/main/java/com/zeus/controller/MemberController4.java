package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.Member;
import lombok.extern.java.Log;


/* [ <form:form>
 * 스프링프레임워크의 JSP 기술중에 form taglib 가 있습니다. form 태그라이브러리를 사용하면 
 * HTML 폼에 데이터를 바인딩하거나 에러메세지 처리등을 간편하게 할 수 있습니다.
 * 
 * ★ path속성 : 바인딩 될 command객체의 프로퍼티를 지정하는 속성
 * - <form:form>의 modelAttribute속성으로 받은 객체를 path로 객체의 프로퍼티를
 * 활용하고, 다시 바인딩하여 controller에 넘길 수 있다.
 * 
 * - <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 * - id 속성은 "command" 가 기본값입니다.
 * - action 속성은 자기 페이지의 URL 입니다.
 * - method는 POST가 기본입니다
 * 
 * <form:form>태그
 *  modelAttribute 옵션 
 *  - 폼에 있는 요소들의 값을 채우기 위해서 사용될 객체를 request 로부터 찾을때 사용할 이름을 지정합니다.
 *  - form의 하위태그들의 path는 보통 input태그의 name과 같은 속성이라고 생각하면 된다.
 *  - 따라서 Controller의 파리미터는 path의 이름을 따르면 되고, 초기화하고 싶은 객체가 있다면 
 *    필드멤버의 이름을 path와 동일하게 해야 한다.
 *    
 *  <form:input>태그
 *  - 스프링 폼 태그로 <form:form>의 하위태그. 텍스트 필드를 출력하려면 <form:input>를 사용한다. 
 *  - path="userId" 식으로 초기화할 property를 찾아 값을 넣는다.
 *  
 *  <form:button>태그
 *  - <form:form> 태그 전송할 때 쓰인다.
 *  
 *  Controller가 할 일 : <form:form>태그가 값을 넣을 객체를 전송한다.
 *  - 컨트롤러는 기본적으로 자바빈즈 규칙에 맞는 객체는 다시 화면으로 폼 객체를 전달한다.
 *  - 자료형 데이터는 Model이나 @ModelAttribute 어노테이션으로 실어 보내야 한다.
 *  
 *  ---------------------------[정리]---------------------------
 *  Controller에서 Model객체로 요소들로 값을 초기화할 객체를 보내면,
 *  modelAttribute 옵션은 addAttribute의 key값으로 속성값을 설정한다.
 *  그리고 <form:input>태그로 객체의 값을 채운다. 
 *  -----------------------------------------------------------
 */


@Log
@Controller
public class MemberController4 {
	@RequestMapping(value = "/registerSpringForm01", method = RequestMethod.GET)
	public String registerSpringForm01() {
		//오류가 난다 : ∵ set할 객체를 Model객체에 실어 보내지 않았기 때문이다.
		log.info("registerSpringForm01");
		return "4/registerSpringForm"; // 뷰 파일명
	}

	// 화면에 전달할 데이터를 위해 Model을 매개변수로 지정한다.
	@RequestMapping(value = "/registerSpringForm02", method = RequestMethod.GET)
	public String registerSpringForm02(Model model) {
		log.info("registerSpringForm02");
		// 속성명에 "member"를 지정하고 폼 객체를 모델에 추가한다.
		model.addAttribute("member", new Member());
		return "4/registerSpringForm";
	}
	
	//속성명에 "user"를 지정하고 폼 객체를 추가한다.
	@RequestMapping(value = "/registerSpringForm03", method = RequestMethod.GET)
	public String registerSpringForm03(Model model) {
		/* <form:form modelAttribute="member" method="post" action="register">
		 * 로 설정되어있기 때문에 whitelabel Error Page가 뜬다.
		 * (Neither Binding nor plain target object for bean name 'member' 
		 * available as rerquest attribute)
		 */
		log.info("4/registerSpringForm03");
		model.addAttribute("user", new Member());
		return "4/registerSpringForm";
	}

	@RequestMapping(value = "/registerSpringForm04", method = RequestMethod.GET)
	public String registerSpringForm04(Model model) {
		log.info("4/registerSpringForm04");
		//속성명에 "user"를 지정하고 폼 객체를 추가한다.
		model.addAttribute("user", new Member());
		return "4/registerSpringForm2"; // 뷰 파일명
	}
	
	@RequestMapping(value = "/registerSpringForm05", method = RequestMethod.GET)
	public String registerSpringForm05(Member member) {
		// 컨트롤러는 기본적으로 자바빈즈 규칙에 맞는 객체는 다시 화면으로 폼 객체를 전달한다.
		log.info("registerSpringForm05");
		return "4/registerSpringForm";
	}

	// 폼 객체의 속성명은 매개변수로 전달된 자바빈즈 클래스의 타입명을을 이용하여 만든다.
	@RequestMapping(value = "/registerSpringForm06", method = RequestMethod.GET)
	public String registerSpringForm06(Member user) {
		log.info("registerSpringForm06");
		return "4/registerSpringForm";
	}

	// @ModelAttribute 애너테이션으로 폼 객체의 속성명을 "user"로 지정한다.
	@RequestMapping(value = "/registerSpringForm07", method = RequestMethod.GET)
	public String registerSpringForm07(@ModelAttribute("user") Member member) {
		log.info("registerSpringForm07");
		return "4/registerSpringForm";
	}

	// @ModelAttribute 애너테이션으로 폼 객체의 속성명을 "user"로 지정한다.
	@RequestMapping(value = "/registerSpringForm08", method = RequestMethod.GET)
	public String registerSpringForm08(@ModelAttribute("user") Member member) {
		log.info("registerSpringForm08");
		return "4/registerSpringForm2"; // 뷰 파일명
	}

	// 폼 객체의 프로퍼티에 값을 지정한다.
	@RequestMapping(value = "/registerSpringForm09", method = RequestMethod.GET)
	public String registerSpringForm09(Model model) {
		log.info("registerSpringForm09");
		Member member = new Member();
		member.setUserId("hong");
		member.setUserName("홍길동");
		model.addAttribute("member", member);
		return "4/registerSpringForm";
	}

	//입력 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		log.info("register");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getUserName() = " + member.getUserName());
		return "4/resultForm"; // 뷰 파일명
	}
}
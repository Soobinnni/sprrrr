package com.zeus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeus.domain.Address;
import com.zeus.domain.Card;
import com.zeus.domain.Member3;

import lombok.extern.java.Log;

@Log
@Controller
public class MemberController5 {

	@GetMapping("/registerAllForm")
	public String registerAllForm() {
		log.info("registerAllForm");
		return "2/registerAllForm";
	}

	@GetMapping("/registerForm01")
	public String registerForm01() {
		return "2/registerForm01";
	}

	@PostMapping("/registerMemberUserId")
	public String registerMemberUserId(Member3 member) {
		log.info("registerMemberUserId");
		log.info("member.getUserId() : " + member.getUserId());
		return "success";
	}

	@PostMapping("/registerUser")
	public String registerUser(Member3 member) { //Member3필드 초기화.
		
		/*
		 * 한 객체가 다른 객체에 종속돼 있을 때, HTML 폼의 name은 그 관계를
		 * 고려하여 작성해야 한다.
		 * 예로, Member3의 List 객체의 필드를 가져오고 싶으면, 폼의 name은 list[0].어쩌구
		 */
		System.out.println("----------------------------------------------------");
		log.info("registerUser");
		// 폼필드명과 Member3의 필드변수명들이 일치하기 때문에 초기화되었다.
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getGender() = " + member.getGender());
		log.info("member.getHobby() = " + member.getHobby());
		// boolean값 : <input type="checkbox" name="foreigner" value="false">
		log.info("member.isForeigner() = " + member.isForeigner()); 
		log.info("member.getDeveloper() = " + member.getDeveloper());
		log.info("member.getBirthDate() = " + member.getDateOfBirth());
		log.info("member.getCars() = " + member.getCars());
		log.info("member.getIntroduction() = " + member.getIntroduction());

		/*
		 * hobbyArray라는 name을 가진 폼 필드 value는 checkbox다. checkbox는 다중 선택이 가능하므로,
		 * Member3에서는 String[]배열, List<String> 컬렉션으로 초기화한다. private String[] hobbyArray;
		 */
		String[] hobbyArray = member.getHobbyArray();
		if (hobbyArray != null) {
			log.info("hobbyArray.length = " + hobbyArray.length);
			for (int i = 0; i < hobbyArray.length; i++) {
				log.info("hobbyArray[" + i + "] = " + hobbyArray[i]);
			}
		} else {
			log.info("hobbyArray == null");
		}

		// private List<String> hobbyList;
		List<String> hobbyList = member.getHobbyList();
		if (hobbyList != null) {
			log.info("hobbyList.size() = " + hobbyList.size());
			for (int i = 0; i < hobbyList.size(); i++) {
				log.info("hobbyList(" + i + ") = " + hobbyList.get(i));
			}
		} else {
			log.info("hobbyList == null");
		}

		/*
		 * Member3와 Addrress는 has-a관계다. 폼필드 name의 address는 Member3의 Address인스턴스명과,
		 * address.(이하)의 이하 부분은 Address의 필드변수명들과 일치하면, 파라미터로 적용할 수 있다.
		 */
		Address address = member.getAddress();
		if (address != null) {
			log.info("address.getPostCode() = " + address.getPostCode());
			log.info("address.getLocation() = " + address.getLocation());
		} else {
			log.info("address == null");
		}

		/*
		 * Card는 List컬렉션에 저장된 인스턴스로, List 역시 Member3와 has-a 관계다. Card의 필드변수는 만일 List가
		 * list로 필드변수 및 폼name으로 지정됐을 때 폼에서 list[index].card필드변수명 으로 표현된다.
		 */
		List<Card> cardList = member.getCardList();
		if (cardList != null) {
			log.info("cardList.size() = " + cardList.size());
			for (int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.getNo() = " + card.getNo());
				log.info("card.getValidMonth() = " + card.getValidMonth());
			}
		} else {
			log.info("cardList == null");
		}

		String[] carArray = member.getCarArray();
		if (carArray != null) {
			log.info("carArray.length = " + carArray.length);
			for (int i = 0; i < carArray.length; i++) {
				log.info("carArray[" + i + "] = " + carArray[i]);
			}
		} else {
			log.info("carArray == null");
		}

		List<String> carList = member.getCarList();
		if (carList != null) {
			log.info("carList.size() = " + carList.size());
			for (int i = 0; i < carList.size(); i++) {
				log.info("hobbyList(" + i + ") = " + carList.get(i));
			}
		} else {
			log.info("carList == null");
		}
		System.out.println("----------------------------------------------------");

		return "success";
	}

	@PostMapping(value = "/registerUserId")
	public String registerUserId(String userId) {
		log.info("registerUserId");
		log.info("userId = " + userId);
		return "success";
	}

	@PostMapping(value = "/registerPassword")
	public String registerPassword(String password) {
		log.info("registerPassword");
		log.info("password = " + password);
		return "success";
	}

	@PostMapping(value = "/registerTextArea")
	public String registerTextArea(String introduction) {
		log.info("registerTextArea");
		log.info("introduction = " + introduction);
		return "success";
	}

	@PostMapping(value = "/registerRadio")
	public String registerRadio(String gender) {
		log.info("registerRadio");
		log.info("gender = " + gender);
		return "success";
	}

	@PostMapping(value = "/registerCheckbox01")
	public String registerCheckbox01(String hobby) {
		//다중 선택을 String으로 저장
		log.info("registerCheckbox01");
		log.info("hobby = " + hobby); 
		//ex결과 :  hobby = Sports,Music
		return "success";
	}

	@PostMapping(value = "/registerCheckbox02")
	public String registerCheckbox02(String[] hobbyArray) {
		log.info("registerCheckbox02");
		if (hobbyArray != null) {
			log.info("hobbyArray.length = " + hobbyArray.length);
			for (int i = 0; i < hobbyArray.length; i++) {
				log.info("hobbyArray[" + i + "] = " + hobbyArray[i]);
			}
		} else {
			log.info("hobbyArray == null");
		}
		
		/* ex 결과
		 * hobbyArray.length = 2
		 * hobbyArray[0] = Sports
		 * hobbyArray[1] = Music
		 */
		return "success";
	}

	@PostMapping(value = "/registerCheckbox03")
	public String registerCheckbox04(String developer) {
		log.info("registerCheckbox04");
		log.info("developer = " + developer);
		return "success";
	}

	@PostMapping(value = "/registerCheckbox04")
	public String registerCheckbox05(boolean foreigner) {
		log.info("registerCheckbox05");
		log.info("foreigner = " + foreigner);
		return "success";
	}

	@PostMapping(value = "/registerSelect")
	public String registerSelect(String nationality) {
		log.info("registerSelect");
		log.info("nationality = " + nationality);
		return "success";
	}

	@PostMapping(value = "/registerMultipleSelect01")
	public String registerMultipleSelect01(String cars) {
		log.info("registerMultipleSelect01");
		log.info("cars = " + cars);
		
		//결과 : cars = volvo,saab,opel,audi
		return "success";
	}

	@PostMapping(value = "/registerMultipleSelect02")
	public String registerMultipleSelect02(String[] carArray) {
		log.info("registerMultipleSelect02");
		if (carArray != null) {
			log.info("carArray.length = " + carArray.length);
			for (int i = 0; i < carArray.length; i++) {
				log.info("carArray[" + i + "] = " + carArray[i]);
			}
		} else {
			log.info("carArray == null");
		}
		/*
		 * carArray.length = 4
		 * carArray[0] = volvo
		 *  carArray[1] = saab
		 *  carArray[2] = opel
		 *  carArray[3] = audi
		 */
		return "success";
	}

	@PostMapping(value = "/registerMultipleSelect03")
	public String registerMultipleSelect03(@RequestParam("carList") ArrayList<String> carList) {
		log.info("registerMultipleSelect03");
		if (carList != null && carList.size()!=0) {
			log.info("carList.size() = " + carList.size());
			for (int i = 0; i < carList.size(); i++) {
				log.info("carList(" + i + ") = " + carList.get(i));
			}
		} else{
			log.info("carList == null");
		}
		return "success";
	}

	@PostMapping(value = "/registerAddress")
	public String registerAddress(Address address) {
		log.info("registerAddress");
		if (address != null) {
			log.info("address.getPostCode() = " + address.getPostCode());
			log.info("address.getLocation() = " + address.getLocation());
		} else {
			log.info("address == null");
		}
		return "success";
	}

	@PostMapping(value = "/registerUserAddress")
	public String registerUserAddress(Member3 member) {
		log.info("registerUserAddress");
		Address address = member.getAddress();
		if (address != null) {
			log.info("address.getPostCode() = " + address.getPostCode());
			log.info("address.getLocation() = " + address.getLocation());
		} else {
			log.info("address == null");
		}
		return "success";
	}

	@PostMapping(value = "/registerUserCardList")
	public String registerUserCardList(Member3 member) {
		log.info("registerUserCardList");
		List<Card> cardList = member.getCardList();
		if (cardList != null) {
			log.info("cardList.size() = " + cardList.size());
			for (int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.getNo() = " + card.getNo());
				log.info("card.getValidMonth() = " + card.getValidMonth());
			}
		} else {
			log.info("cardList == null");
		}
		return "success";
	}

	@PostMapping(value = "/registerDate01")
	public String registerDate01(@DateTimeFormat(pattern = "yyyyMMdd") Date dateOfBirth) {
		log.info("registerDate01");
		if (dateOfBirth != null) {
			log.info("dateOfBirth = " + dateOfBirth);
		} else {
			log.info("dateOfBirth == null");
		}
		return "success";
	}
}
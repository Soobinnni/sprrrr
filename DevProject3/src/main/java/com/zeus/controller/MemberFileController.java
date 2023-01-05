package com.zeus.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.FileMember;
import com.zeus.domain.MemberF;
import com.zeus.domain.MultiFileMember;

import lombok.extern.java.Log;


/*
 * 파일업로드 시에는 form태그의 enctype이 "multipart/form-data/로 설정되어 있어야 한다.
 * method는 "POST"이어야 한다.
 * input 태그의 type 속성 값을 "file"로 지정해야한다.
 * type이 "file"인 input태그가 여러 개 있고, name 속성의 값이 같다면 파일이 배열 형태로 Controller에게 전달된다.
 */

@Log
@Controller
public class MemberFileController {

	// registerFileUpForm으로 이동
	@GetMapping("/registerFileUpForm")
	public String registerFileUpForm() {
		log.info("registerFileUpForm");
		return "3/registerFileUpForm";
	}

	@PostMapping("/registerFileUp01")
	public String registerFileUp01(MultipartFile picture) throws Exception {
		log.info("registerFileUp01");
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		return "success";
	}

	@PostMapping("/registerFileUp02")
	public String registerFileUp02(String userId, String password, MultipartFile picture) throws Exception {
		log.info("registerFileUp02");

		// 일반 param
		log.info("userId = " + userId);
		log.info("password = " + password);
		// file param.
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		return "success";
	}

	@PostMapping("/registerFileUp03")
	public String registerFileUp03(MemberF member, MultipartFile picture) throws Exception {
		log.info("registerFileUp03");
		// 자바빈즈의 초기화
		log.info("userId = " + member.getUserId());
		log.info("password = " + member.getPassword());
		// MultipartFile의 초기화
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		return "success";
	}

	@PostMapping("/registerFileUp04")
	public String registerFileUp04(FileMember fileMember) throws Exception {
		/*
		 * FileMember의 필드 : private String userId; private String password; private
		 * MultipartFile picture;
		 */
		log.info("registerFileUp04");
		// FileMember의 초기화로, 모든 form의 내용을 가져온다. file포함.
		// 일반데이터 타입
		log.info("userId = " + fileMember.getUserId());
		log.info("password = " + fileMember.getPassword());
		// MultipartFile타입을 get으로 가져옴.
		MultipartFile picture = fileMember.getPicture();
		log.info("originalName: " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		return "success";
	}

	@PostMapping("/registerFileUp05")
	public String registerFileUp05(MultipartFile picture, MultipartFile picture2) throws Exception {
		// 두 개의 MultipartFile을 가져온다. 두 input type="file"의 name은 다르게 설정되어 있다(picture,
		// picture2)
		log.info("registerFileUp05");

		// picture인스턴스의 MultipartFile 필드멤버
		log.info("picture originalName: " + picture.getOriginalFilename());
		log.info("picture size: " + picture.getSize());
		log.info("picture contentType: " + picture.getContentType());
		// picture2인스턴스의 MultipartFile 필드멤버
		log.info("picture2 originalName: " + picture2.getOriginalFilename());
		log.info("picture2 size: " + picture2.getSize());
		log.info("picture2 contentType: " + picture2.getContentType());
		return "success";
	}

	@PostMapping("/registerFileUp06")
	public String registerFileUp06(
			 @RequestParam("pictureList")  List<MultipartFile> pictureList) throws Exception {
		log.info("registerFileUp06");

		/* MultipartFile을 List를 통해 객체들로 담아온다.
		 * 이때 List의 인스턴스명을 통해 pictureList[index]로 직접 인덱스번호를 name의 속성값으로
		 * 지정하여 넣거나, name을 중복하여 ArrayList에 MultiparFile객체를 담는 방법이 있다.
		 */
		log.info("registerFileUp06 pictureList.size() = " + pictureList.size());
		for (MultipartFile picture : pictureList) { // for each문으로 객체를 하나씩 꺼낸다.
			log.info("picture originalName: " + picture.getOriginalFilename());
			log.info("picture size: " + picture.getSize());
			log.info("picture contentType: " + picture.getContentType());
		}
		return "success";
	}

	@PostMapping("/registerFileUp07")
	public String registerFileUp07(MultiFileMember multiFileMember) throws Exception {
		/*
		 * MultiFileMember의 필드 private String userId; private String password; private
		 * List<MultipartFile> pictureList;
		 */
		log.info("registerFileUp07");

		/*
		 * MultiFileMember의 필드멤버인 List객체 : MultiFileMember에 종속된 List이기 때문에 name 역시 그 관계를
		 * 고려하여 "pictureList[0]"식으로 표현한다.
		 * Controller에서는 인스턴스.getPictureList();을 통해 List객체를 얻는다.
		 */
		List<MultipartFile> pictureList = multiFileMember.getPictureList();
		log.info("registerFileUp07 pictureList.size() = " + pictureList.size());
		for (MultipartFile picture : pictureList) {
			// 역시 foreach문을 통해 객체들을 꺼낸다.
			log.info("picture originalName: " + picture.getOriginalFilename());
			log.info("picture size: " + picture.getSize());
			log.info("picture contentType: " + picture.getContentType());
		}
		return "success";
	}

	@PostMapping("/registerFileUp08")
	public String registerFileUp08(MultipartFile[] pictureList) throws Exception {
		//MultiparFile을 배열로 가져온다.
		log.info("registerFileUp08");
		log.info("registerFileUp08 pictureList.length = " + pictureList.length);
		for (MultipartFile picture : pictureList) {
			// 역시 foreach문을 통해 객체들을 꺼낸다.
			log.info("picture originalName: " + picture.getOriginalFilename());
			log.info("picture size: " + picture.getSize());
			log.info("picture contentType: " + picture.getContentType());
		}
		return "success";
	}

}

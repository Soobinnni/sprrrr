package com.zeus.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class MultiFileMember {
	private String userId;
	private String password;
	private List<MultipartFile> pictureList;
}

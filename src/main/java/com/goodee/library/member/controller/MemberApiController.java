package com.goodee.library.member.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.library.member.dto.MemberDto;
import com.goodee.library.member.service.MemberService;

@Controller
public class MemberApiController {

	private static final Logger LOGGER=  
			LogManager.getLogger(MemberApiController.class);
		
	
	@Autowired
	MemberService service;
	
	
	@ResponseBody
	@PostMapping("/join")
	public Map<String, String> joinMember(@RequestBody MemberDto dto) {
	LOGGER.info("회원가입 기능");
	//1. 회원 정보를 전달 받아야 합니다. (json)
	//2. 회원 정보를 데이터베이스 등록
	return service.createMember(dto);
	//3. 회원 정보 등록 결과를 view에 전달 (json)
	
	}
	
}

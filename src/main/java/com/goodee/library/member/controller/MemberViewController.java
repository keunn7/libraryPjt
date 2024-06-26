package com.goodee.library.member.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberViewController {

	private static final Logger LOGGER = LogManager.getLogger(MemberViewController.class);
	

	@GetMapping("/join")
	public String openJoin(){
		LOGGER.info("회원가입");
		return "member/join";

	}
}


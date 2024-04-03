package com.goodee.library.member.dao;

import java.io.StringWriter;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.library.member.dto.MemberDto;


@Repository
public class MemberDao {

	private static final Logger LOGGER=  
			LogManager.getLogger(MemberDao.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace ="com.goodee.library.memberMapper.";
	
	
	public int idDoubleCheck(String m_id) {
		LOGGER.info("아이디 중복 검사");
		//1. 정수형 변수 result 선언
		int result = 0; 
		//2. try, catch문 구성
		//3. try문에서 mybatis로 데이터 조회 요청 (idDoubleCheck)
		//4. 파라미터 m_id
		try {
			result = sqlSession.selectOne(namespace+"idDoubleCheck",m_id);
		}catch(Exception e){
			LOGGER.error("아이디 중복검사시 에러 발생");
	    e.printStackTrace();
	       
		
		//5. 수행 결과를 return 
	        
		}		 return result;
	}

	public int createMember(MemberDto dto) {
		LOGGER.info("회원정보 데이터베이스 추가");
		int result = 0; 
		try {
			result = sqlSession.insert(namespace +"createMember", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
				
		}

	}

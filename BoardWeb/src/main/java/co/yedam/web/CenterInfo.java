package co.yedam.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.CenterVO;
import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class CenterInfo implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// json문자열을 넘겨받으면 java객체로 변환해서 db에 삽입
		// json문자열을 java객체로 변환하는 라이브러리 설치(maven에서 spring-core » 5.2.8, Jackson Databind
		// » 2.16.1)

		ServletInputStream sis = req.getInputStream(); // stream:자바에서 데이터를 주고받을 때 쓰이는 통로
		String json = StreamUtils.copyToString(sis, StandardCharsets.UTF_8);// 읽어들인 파일 : sis, 한글이 포함되어 있으면 utf_8 : 속성
		System.out.println(json);
		// 문자열을 다시 객체로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		CenterVO[] centers = objectMapper.readValue(json, CenterVO[].class); // CenterVO에 값이 여러개이기 때문에 배열로
		// 한번에 여러건을 db에 insert ===> ReplyMapper들 이용

		ReplyService svc = new ReplyServiceImpl();
		int r = svc.createCenterInfo(centers);
		// {"txnCnt": 3}
		resp.getWriter().print("{\"txnCnt\": " + r + "}");

	}

}

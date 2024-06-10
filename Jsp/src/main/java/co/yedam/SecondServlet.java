package co.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
// 제어의 역전(개발자가 아닌 제 3자(서블릿 컨테이너)가 하는 작업 => IOC
//rul => tomcat => 객체를 생성하고 init => service => destory 순서대로 실행(개발자가 하는게x)
//서블릿의 생명주기

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SecondServlet extends HttpServlet {

	public SecondServlet() {
		System.out.println("SecondServlet 생성자 호출");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 메소드 호출");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}
	
	
}// end class

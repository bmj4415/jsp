package co.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class RemoveReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//댓글 번호를 활용해서 댓글만 삭제(목록자체를 삭제x)
		//댓글이 정상적으로 삭제되면 retCode:OK, retCode:NG를 반환
		
		resp.setContentType("text/json;charset=utf-8");
		
		String rno = req.getParameter("rno");
		
		//{"retCode": "OK"}
		
		ReplyService rsv = new ReplyServiceImpl();
		
		Map<String, Object> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		
		if (rsv.removeReply(Integer.parseInt(rno))) {
			map.put("retCode", "OK");
			map.put("retMsg", "성공적으로 삭제되었습니다.");
			//resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			map.put("retCode", "NG");
			map.put("retMsg", "처리중 예외가 발생했습니다.");
			//resp.getWriter().print("{\"retCode\": \"NG\"}");
		}

		String json = gson.toJson(map);
		resp.getWriter().print(json);
		
		//map => 키, 값을 담고 있으니까 gson을 활용하여 간편하게 작성할 수 있음
	
	}

}

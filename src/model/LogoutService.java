package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;

public class LogoutService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();


	     
	     // 수정
	     // ★★★★★★★세션 저장을 객체로 했기 때문에 삭제는 id랑 name만 할게 아니라! 전부하기★★★★★★★★★★★★★★★★★★★★★★★★★ 
	     session.invalidate(); 
	     
	     
	     
		// 다시 로그인하러가기
		return new ModelAndView("views/login.jsp",false);
	}

}

package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 수정2. 새로 수정된 내용은 파라미터로 받기
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
	
		// 수정3. 꼭 필요한 no는 세션에서 꺼내기 
		MemberDTO user = (MemberDTO) request.getSession().getAttribute("user");
		
		// 수정4. 세션으로 받아 리턴된 user에도 지정해야하므로 global scope설정하기
		String grade = null;
		
		// 수정5. point에 따라 grade 셋팅
		MemberDTO mem = new MemberDTO();
		if(point >= 5000) {
			grade = "vip";
		} else if(point >=4000) {
			grade= "gold";
		} else if( point >= 3000) {
			grade = "silver";
		} else {
			grade = "bronze";
		}
		mem.setGrade(grade);
		mem.setNo(user.getNo());
		mem.setName(name);
		mem.setPoint(point);   // dto 값 설정
	
		// dao 리턴값 result 저장
		int result = MemberDAO.getInstance().update(mem);
		
		// 수정6.
		// 반환값 있으면 세션에서 받은 객체에 다시 세팅해서 manager.jsp에 객체보내기
		if( result > 0) {
			user.setName(name);
			user.setPoint(point);
			user.setGrade(grade);
			
				
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정 실패')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		
	
		return new ModelAndView("views/manager.jsp",false);
 }
}


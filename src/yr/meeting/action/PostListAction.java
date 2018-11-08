package yr.meeting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.CommandAction;
import yr.meeting.MeetingDao;

public class PostListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MeetingDao data = new MeetingDao();
		
		int num = data.postCount();
		
		request.setAttribute("num", num);
		
		return "post_list.jsp";
	}
/*	public class HomeAction implements CommandAction {
		@Override
		public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
			request.setCharacterEncoding("utf-8");
			
			MemoDao memo = new MemoDao();
			
			String text= null;
			int num=memo.selectCount();
			List<MemoInfo> list = memo.allPost();
			
			if(list == null) {
				text = "등록된 글이 없습니다.";
			} else {
				text = "총 게시글 "+num;
			}
			
			request.setAttribute("num", num);
			request.setAttribute("list", list);
			request.setAttribute("text", text);

			return "index.jsp";
		}
	}
*/
}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.WatchaService;

@WebServlet("/controller")
public class WatchaController extends HttpServlet {
	WatchaService service = WatchaService.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		if (command.equals("movieInfo")) {
			System.out.println("영화 정보를 저장하였습니다.");
			try {
				service.inputMovieInfo();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}

package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.UserDao;
import entity.User;
import service.AppLogger;
import service.UserService;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userService = new UserService();
	AppLogger logger = AppLogger.getInstance();
       
    public AuthServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean rememberUser = false;
		
		boolean isValid = false;
		boolean isMatch = false;
		boolean isValidPassword = false;
		boolean isValidUserame = false;
		
		if (request.getParameter("rememberUser") != null) {
			rememberUser = true;
		}

		if (username != null && username.trim().length() != 0) {
			isValidUserame = true;
		} 
		if (password != null && password.trim().length() != 0) {
			isValidPassword = true;
		} 
		if (isValidUserame && isValidPassword) {
			isValid = true;
			logger.writeLog(Level.WARNING,"Попытка авторизации: username=" + username);
		}
		
		
		
		if (isValid) {
			User tempUser = userService.getByUsername(username);
			if (tempUser.getUserName().equals(username) && 
					tempUser.getUserPassword().equals(password)) {
						isMatch = true;
						if (!rememberUser) {
							logger.writeLog(Level.INFO, "Успешная авторизация : username=" + username);
							session.setAttribute("username", username);
							RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				            dispatcher.forward(request, response);
						} else {
							
							request.getServletContext().setAttribute("username", username);
						}
						
			} 
			
			map.put("isValid", isValid);
			map.put("isMatch", isMatch);
			write(response, map);
		}
		
		
		
	}
	
	private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
		response.setContentType("application/json");	
		response.setCharacterEncoding("UTF-8");
		response.getWriter().
					write(new Gson().
					toJson(map));
	}


}

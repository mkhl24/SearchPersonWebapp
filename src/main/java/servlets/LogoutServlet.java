package servlets;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AppLogger;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppLogger logger = AppLogger.getInstance();
       

    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = "";
		
		HttpSession session = request.getSession(false);
		
		Object sessionUsername = null;
		Object servletUsername = null;
		
		if (session.getAttribute("username") != null) {
			sessionUsername = session.getAttribute("username");	
			username = sessionUsername.toString();
		}
		ServletContext sc = request.getServletContext();
		if (sc.getAttribute("username") != null) {
			servletUsername = sc.getAttribute("username");	
			username = servletUsername.toString();
		}
		
		request.getServletContext().removeAttribute("username");
		
		
        if (session != null) {
            session.removeAttribute("username");
        }
        
        logger.writeLog(Level.INFO, "Пользователь " + username + " вышел из приложения");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("auth.jsp");
        dispatcher.forward(request, response);
	}

}

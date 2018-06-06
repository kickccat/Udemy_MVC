package io.sample;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public WelcomeServlet() {
        super();
    }
    
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
    
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String welcomMessage[] = {"Hello", "Welcome to the Spring course"};
        request.setAttribute("myWelcomeMessage", welcomMessage);
    
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
        
        requestDispatcher.forward(request, response);
    }
}

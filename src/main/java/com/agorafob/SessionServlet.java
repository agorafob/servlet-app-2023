package com.agorafob;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = null;
        // Если для этого клиента сессии еще ни разу не было создано, то она создается и возвращается ссылка на объект
        // Если сессия уже была до этого ранее создана, то возвращается ссылка на созданный ранее объект
        //
        // Если указать false, то если сессии еще ни разу не было создано,
        // то она создаваться не будет, вернется null
        // В противном случае вернется ссылка на ранее созданную сессию.
        HttpSession httpSession = req.getSession(true);
        userName = (String) httpSession.getAttribute("name");
        // Если в пользовательской сессии атрибута name не было
        if (userName == null) {
            userName = req.getParameter("username");
            httpSession.setAttribute("name", userName);
            httpSession.setMaxInactiveInterval(30);
        }


        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("Hello, " + userName);
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}

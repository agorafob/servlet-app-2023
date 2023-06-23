package com.agorafob;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Пришел запрос, проверим, прислал ли нам клиент куку
        // Если имя прислал, то мы имя возьмем из куки
        // Если куку не прислал, то имя возьмем из формы и обратно вернем куку
        String userName = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cook : cookies) {
                // Если клиент прислал куку с ключом name
                if (cook.getName().equals("name")) {
                    userName = cook.getValue();
                    break;
                }
            }
        }

        // Если клиент никакую куку нам не прислал, т.е. клиент зашел первый раз
        if (userName == null) {
            userName = req.getParameter("username");
            Cookie cookie = new Cookie("name", userName);
//            cookie.setPath("/myfirstapp/cookie");
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
            resp.getWriter().append("name ").append(userName).append(" was added to Cookies");
        }
        resp.getWriter().append(userName);
    }
}

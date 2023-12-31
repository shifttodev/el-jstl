package io.shifttodev.eljstl.servlet;

import io.shifttodev.eljstl.bean.Pessoa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession(true);
        Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");

        if (pessoa != null){
            session.removeAttribute("pessoa");
        }

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/form.jsp");
        rd.forward(req, resp);
    }
}

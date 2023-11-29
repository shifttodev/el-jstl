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

import java.util.List;

@WebServlet(urlPatterns = "/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        HttpSession session = req.getSession(true);
        List<Pessoa> pessoas = (List<Pessoa>) session.getAttribute("pessoas");

        Pessoa pessoa = pessoas.stream()
                            .filter(p -> p.getId() == id)
                            .findFirst().get();

        req.setAttribute("pessoa", pessoa);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/view.jsp");

        rd.forward(req, resp);
    }
}

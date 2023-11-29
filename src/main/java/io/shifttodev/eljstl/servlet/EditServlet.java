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

@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        HttpSession session = req.getSession(true);
        List<Pessoa> pessoas = (List<Pessoa>) session.getAttribute("pessoas");

        Pessoa pessoa = pessoas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().get();

        req.setAttribute("pessoa", pessoa);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/form.jsp");

        rd.forward(req, resp);
    }
}


package io.shifttodev.eljstl.servlet;

import io.shifttodev.eljstl.bean.Pessoa;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/save")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String action = req.getParameter("action");
        String nome = req.getParameter("nome");
        String profissao = req.getParameter("profissao");
        String cidade = req.getParameter("cidade");
        HttpSession session = req.getSession(true);
        List<Pessoa> pessoas = null;

        if (action.equals("update")){
            pessoas = (List<Pessoa>) session.getAttribute("pessoas");
            Integer id = Integer.valueOf(req.getParameter("id"));

            Pessoa pessoa = pessoas.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst().get();

            pessoa.setNome(nome);
            pessoa.setProfissao(profissao);
            pessoa.setCidade(cidade);

        } else {
            Pessoa pessoa = new Pessoa();            ;
            pessoa.setNome(nome);
            pessoa.setProfissao(profissao);
            pessoa.setCidade(cidade);

            if (session.getAttribute("pessoas") == null) {
                pessoas = new ArrayList<>();
                pessoas.add(pessoa);
                session.setAttribute("pessoas", pessoas);
            } else {
                pessoas = (List<Pessoa>) session.getAttribute("pessoas");
                pessoas.add(pessoa);
            }
        }

        resp.sendRedirect("/list");
    }
}

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         language="java"
%>
  <jsp:include page="header.jsp" />
<%--    <jsp:useBean id="pessoa" class="io.shifttodev.eljstl.bean.Pessoa" scope="session"/>--%>
<%--    <c:choose>--%>
<%--    <c:when test="${empty param['nome']}">--%>
<%--      <c:set var="nome" value="${pessoa.nome}"/>--%>
<%--      <c:set var="cidade" value="${pessoa.cidade}"/>--%>
<%--      <c:set var="profissao" value="${pessoa.profissao}"/>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--      <c:set var="nome" value="${param['nome']}"/>--%>
<%--      <c:set var="cidade" value="${param['cidade']}"/>--%>
<%--      <c:set var="profissao" value="${param['profissao']}"/>--%>
<%--    </c:otherwise>--%>
<%--    </c:choose>--%>

    <c:choose>
      <c:when test="${empty pessoa.nome}">
        <div class="alert alert-warning mt-3">
          <strong>Sem informações</strong>
        </div>
      </c:when>
      <c:otherwise>
        <div class="card mt-3">
          <h4 class="card-header">${pessoa.nome}</h4>
          <div class="card-body">
            <h5 class="card-title">${pessoa.profissao}</h5>
            <p class="card-text">Residente na cidade de ${pessoa.cidade}</p>
            <a href="/edit?id=${pessoa.id}" class="btn btn-primary">Editar</a>
          </div>
        </div>
      </c:otherwise>

    </c:choose>
  <jsp:include page="footer.jsp" />
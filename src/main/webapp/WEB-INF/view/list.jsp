<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
  <table class="table table-striped table-bordered table-hover mt-3">
    <thead>
      <tr>
        <th scope="col">Nome</th>
        <th scope="col">Profissão</th>
        <th scope="col">Cidade</th>
      </tr>
    </thead>
    <tbody>
      <c:choose>
        <c:when test="${empty pessoas}">
          <div class="alert alert-warning mt-3">
            <p>Nenhum registro encontrado</p>
          </div>
        </c:when>
        <c:otherwise>
          <c:forEach var="pessoa" items="${pessoas}">
            <tr>
              <td><a href="/view?id=${pessoa.id}">${pessoa.nome}</a></td>
              <td>${pessoa.profissao}</td>
              <td>${pessoa.cidade}</td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
    </tbody>
  </table>
<jsp:include page="footer.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<c:choose>
  <c:when test="${empty pessoa}">
    <form action="/save" method="post" class="mt-3">
      <input type="hidden" name="action" value="create">
      <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" class="form-control" id="nome" name="nome" value="${pessoa.nome}" required>
      </div>
      <div class="form-group">
        <label for="cidade">Cidade:</label>
        <input type="text" class="form-control" id="cidade" name="cidade" value="${pessoa.cidade}" required>
      </div>
      <div class="form-group">
        <label for="profissao">Profissão:</label>
        <input type="text" class="form-control" id="profissao" name="profissao" value="${pessoa.profissao}" required>
      </div>
      <button type="submit" class="btn btn-primary">Inserir</button>
    </form>
  </c:when>
  <c:otherwise>
    <form action="/save" method="post" class="mt-3">
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="id" value="${pessoa.id}">
      <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" class="form-control" id="nome" name="nome" value="${pessoa.nome}" required>
      </div>
      <div class="form-group">
        <label for="cidade">Cidade:</label>
        <input type="text" class="form-control" id="cidade" name="cidade" value="${pessoa.cidade}" required>
      </div>
      <div class="form-group">
        <label for="profissao">Profissão:</label>
        <input type="text" class="form-control" id="profissao" name="profissao" value="${pessoa.profissao}" required>
      </div>
      <button type="submit" class="btn btn-primary">Atualizar</button>
    </form>
  </c:otherwise>
</c:choose>

<jsp:include page="footer.jsp"/>
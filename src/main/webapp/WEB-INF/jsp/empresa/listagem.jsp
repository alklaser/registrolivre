<%@ page language="java" contentType="text/html; iso-8859-1" pageEncoding="iso-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>	
	<title>Registro Livre - Listar Empresas</title>
	<jsp:include page="/WEB-INF/jsp/includes/assets.jsp" />
	
	<jsp:include page="/WEB-INF/jsp/includes/datatable.jsp" />
	<script src="../assets/js/datatable.js" charset="utf-8"></script>
	
	<script type="text/javascript">
		<c:set var="resultadoBusca" value="${resultadoBusca}"/>
		$(document).ready(function() {
			datatable.cria(<c:out value="${resultadoBusca}" escapeXml='false' />);
			$("#close-info-busca-aproximada").click(function(){
				$("#info-busca-aproximada").fadeOut();
			});
		});
	</script>	
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/includes/cabecalho.jsp" />
	<div class="container content">
		<div class="row">
			<div class="col-lg-8 col-md-10 col-sm-12 col-lg-offset-2 col-md-offset-1">
				<c:if test="${buscaAproximada == true}">
					<div class="alert alert-info alert-dismissible" id="info-busca-aproximada" role="alert">
						<button type="button" class="close" id="close-info-busca-aproximada" data-dismiss="alert">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<p style="font-weight: strong;">Nenhum registro espec�fico encontrado, seguem abaixo sugest�es de registros aproximados:</p>
					</div>
				</c:if>
				<div class="panel panel-default margin-35-0">
					<div class="panel-heading centralize">
						<h2>Lista de Empresas Cadastradas</h2>
					</div>
					<div class="panel-body">	
						<table id="tabelaListagem" class="table-striped table-hover">
							<thead>
								<tr>
									<th class="centralize"><input type="checkbox" id="seleciona-todos"></th>
									<th>Nome Fantasia</th>
									<th>Endere�o</th>
									<th>Data Emiss�o Documento</th>
								</tr>
							</thead>
						</table>						
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/includes/rodape.jsp" />		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=iso-8859-1"
    pageEncoding="iso-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<title>Registro Livre - Contato</title>
	<jsp:include page="/WEB-INF/jsp/includes/assets.jsp" />
	<script src="/assets/js/contato.js"></script>
</head>
	<body>
	<jsp:include page="/WEB-INF/jsp/includes/cabecalho.jsp" />
		<div class="container content">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-8 col-lg-offset-3 col-md-offset-3 col-sm-offset-2">
				
				<c:forEach items="${errors}" var="error">
	    			<div class="alert alert-danger alert-dismissible" role="alert">
	    				<button type="button" class="close" id="close" data-dismiss="alert">
				  			<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				  		</button>
  						${error.message}
					</div>
				</c:forEach>
				
				<c:if test="${erro != null}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" id="close" data-dismiss="alert">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						${erro}
					</div>
				</c:if>
				
				<c:if test="${enviar != null}">
					<div class="alert alert-success alert-dismissible" role="alert">
						<button type="button" class="close" id="close" data-dismiss="alert">
				  			<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				  		</button>
						${enviar}
					</div>
				</c:if>
				
				<div class="panel panel-default margin-35-0">
						
						<div class="panel-heading centralize">
									<h2>Contato</h2>									
						</div>
						

						<form class="form" name="formulario" action="/contato/enviar" method="POST" enctype="multipart/form-data">

							<div class="panel-body">
								
								<div class="list-group-item-heading centralize">
								</div>								
										
								<div class="form-group has-feedback" id="nome-group">
									<label class="control-label">Seu nome <abbr class="cor-vermelha" title="Preenchimento obrigat�rio">*</abbr></label>
									<input class="form-control" type="text" name="email.nome" value="${email.nome}" id="" placeholder="ex: Fulano de Tal" required/>
									<span class="glyphicon form-control-feedback"></span>
								</div>
							
								<div class="form-group has-feedback" id="email-group">
									<label class="control-label">Seu email  <abbr class="cor-vermelha" title="Preenchimento obrigat�rio">*</abbr> </label>
									<input class="form-control" type="email" name="email.rementente" value="${email.remetente}" id=""  placeholder="ex: fulano123@email.com" required/>
									<span class="glyphicon form-control-feedback"></span>
								</div>

							<div class="form-group">
								<label class="control-label">Assunto <abbr class="cor-vermelha" title="Preenchimento obrigat�rio">*</abbr> </label>
									<div class="select-wrapper">
										<select name="email.assunto" class="form-control" required>
											<option value="" selected>Escolha uma op��o </option>
											<option value="duvida">D�vida</option>
											<option value="reclamacao">Reclama��o</option>
											<option value="elogio">Elogio</option>
											<option value="sugestao">Sugest�o</option>
											<option value="outro">Outro</option>
										</select>
									</div>
							</div>

							<div class="row">
									<div class="col-lg-12">
										<div class="form-group">
											<label class="control-label">Sua mensagem  <abbr class="cor-vermelha" title="Preenchimento obrigat�rio">*</abbr> </label> 
											<br>
											<textarea rows="5" class="form-control" name="email.mensagem" id="" required>${email.mensagem}</textarea>
										</div>
									</div>							
								</div> 
								<span>Sua mensagem ser� enviada para: </span><label class="control-label"> contato@registrolivre.inf.br</label>
							</div>
							
							<div class="panel-footer">								
								<span class="pull-left msg-alert color-red margin-15-0" id="form-alert">Preencha os campos corretamente para enviar.</span>
								<input type="submit" id="btn-submit" class="btn btn-lg btn-primary pull-right margin-0-6" onclick="enviarEmailContato()" value="Enviar" required/>
								<input type="reset" value="Limpar" class="btn btn-default btn-lg pull-right margin-0-6"/>
								<div style="clear:both"></div>
							</div>	
									
						</form>
							
						
					</div> <!-- panel -->
				</div> <!-- col -->
			</div> <!-- row -->
		</div> <!-- container -->
		<jsp:include page="/WEB-INF/jsp/includes/rodape.jsp" />	
	</body>
</html>
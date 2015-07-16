<%@ page language="java" contentType="text/html; charset=iso-8859-1"
    pageEncoding="iso-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<title>Registro Livre - Colabore</title>
	<jsp:include page="/WEB-INF/jsp/includes/assets.jsp" />	
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/includes/cabecalho.jsp" />
		<div class="content">
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-10 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-1">
					
					<h1 class="centralize title">Colabore</h1>
					

					<p class="text">O <b>Registro Livre</b> � um projeto sem fins lucrativos, defensor da liberdade de informa��o 
					e voltado a oferecer subs�dios e especial para jornalistas produzirem reportagens investigativas.</br> 
					Aceitamos e incentivamos a contribui��o de cada qual dentro de suas possibilidades.</p>
					
					<p class="text">Se voc� tem contratos sociais de empresas brasileiras para compartilhar conosco, fa�a o upload 
					em nosso banco de dados, ou ent�o os envie para o email contato@registrolivre.inf.br.</br>
					
					<h2 class="centralize subtitle"> Jornalistas</h2>
					
					<p class="text">Os rep�rteres s�o o p�blico-alvo principal do Registro Livre, porque no desempenho de suas 
					fun��es eles muitas vezes necessitam e adquirem os contratos sociais de empresas brasileiras nas Juntas Comerciais 
					de cada Estado. Nossa iniciativa pretende diminuir os custos de reportagem ao oferecer estes documentos p�blicos de forma livre e 
					gratuita. Por outro lado, contamos com a contribui��o de jornalistas experientes, que j� tenham um arquivo de contratos sociais 
					levantados ao longo de sua carreira. Se voc� � um rep�rter investigativo experiente, fa�a o upload de seus arquivos, ou os envie 
					para o email contato@registrolivre.inf.br. Se n�o tiver arquivos, fale sobre o projeto com seus colegas e os incentive a contribuir.
					</p>
					
					<h2 class="centralize subtitle"> Advogados, contadores, administradores e outros profissionais da �rea comercial. </h1>
					<p class="text">Assim como os jornalistas, advogados, contadores, administradores e outros profissionais da �rea 
					comercial lidam cotidianamente com contratos sociais. Estes grupos poder�o se beneficiar do Registro Livre e, mais importante, 
					podem se tornar os principais colaboradores do nosso projeto. Se voc� trabalha num estabelecimento como estes, solicite autoriza��o 
					e nos envie contratos sociais.</p>
					
					<h1 class="centralize subtitle">Cientistas da informa��o, engenheiros de computa��o, hackers e programadores em geral</h2>
					<p class="text">O Registro Livre � um projeto de software livre. Portanto, voc� pode obter nosso c�digo-fonte no 
					<a href="https://github.com/aceleradora6-tw/RegistroLivre.git" target="_blank">Github</a> e aplicar
					 em seus pr�prios projetos. Melhor ainda, voc� pode nos ajudar a aprimor�-lo! Tamb�m adorar�amos ver os dados dispon�veis 
					aqui servindo como base para an�lises e estudos, ou sugest�es de novas funcionalidades.</p>
					
					<h2 class="centralize subtitle"> Todos os cidad�os</h2>
					<p class="text">Os contratos sociais s�o documentos p�blicos. Obter informa��es sobre a finalidade e estrutura 
					societ�ria de empresas nacionais � essencial para exercer a cidadania -- por exemplo, para fiscalizar a rela��o entre contribui��es de 
					campanha e desempenho de pol�ticos. Esperamos que o Registro Livre seja muito �til para voc� e o convidamos a contribuir para aumentar 
					sua utilidade, nos enviando documentos. Algumas sugest�es:</p>
					
					<ul>
						<li>Se voc� tem tempo livre, crie um cadastro na Junta Comercial de S�o Paulo, que oferece algumas informa��es gratuitamente, e 
						ajude a povoar nosso banco de dados com esses documentos.</li>
						<li>Se voc� puder oferecer algumas dezenas de reais, procure a Junta Comercial de seu Estado e adquira para n�s os contratos sociais 
						de empresas que voc� julgue importantes (concession�rias de servi�os p�blicos, por exemplo).</li>
						<li>Se voc� conhece pessoas que det�m arquivos de contratos sociais, fale com elas e as incentive a contribuir com o Registro Livre.</li>
						<li>Divulgue o Registro Livre em redes sociais como
						<a href="https://twitter.com/home?status=http://registro-livre-aceleradora.herokuapp.com/" onclick="window.open(this.href, 'mywin',
							'left=20,top=20,width=500,height=500,toolbar=1,resizable=0'); return false;" >
							Twitter
						</a>  e 
 					<a href="https://www.facebook.com/sharer/sharer.php?u=http://registro-livre-aceleradora.herokuapp.com/" onclick="window.open(this.href, 'mywin',
						'left=20,top=20,width=500,height=500,toolbar=1,resizable=0'); return false;">
						Facebook.
					</a>										
					</li>
					</ul>	
				</div>
				
				</div>
			</div>
			
		<jsp:include page="/WEB-INF/jsp/includes/rodape.jsp" />		
</body>
</html>
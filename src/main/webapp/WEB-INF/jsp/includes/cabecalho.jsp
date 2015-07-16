<nav class="navbar navbar-default navbar-fixed-top" role="navigation">	
	<div class="container">
		<div class="navbar-header">
			<a href="/" class="logo-link pull-left"><img class="logo-navbar" alt="Registro Livre" src="/assets/img/logo_navbar.svg"/></a>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse" >
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> <span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			
		</div>
		<div class="collapse navbar-mobile">
			<ul class="nav navbar-nav btn-borders-navbar">
				<li><a href="/">Busca</a></li>
				<li><a href="/cadastro">Cadastrar Empresa</a></li>				
				<li><a href="/listagem">Listar Empresas</a></li>				
				
				<li><a href="/sobre" class="visible-xs"><span class="glyphicon glyphicon-user hidden-xs"></span> Quem somos</a></li>
				<li><a href="/colabore" class="visible-xs"><span class="glyphicon glyphicon-thumbs-up hidden-xs"></span> Colabore</a></li>
				<li><a href="/contato" class="visible-xs"><span class="glyphicon glyphicon-envelope hidden-xs"></span> Contato</a></li>
				<li><a href="https://www.facebook.com/sharer/sharer.php?u=http://registro-livre-aceleradora.herokuapp.com/" class="visible-xs" onclick="window.open(this.href, 'mywin', 'left=20,top=20,width=500,height=500,toolbar=1,resizable=0'); return false;" >Facebook</a></li>
				<li><a href="https://twitter.com/home?status=http://registro-livre-aceleradora.herokuapp.com/" class="visible-xs" onclick="window.open(this.href, 'mywin', 'left=20,top=20,width=500,height=500,toolbar=1,resizable=0'); return false;" >Twitter</a></li>			
				<li><a href="https://github.com/aceleradora6-tw/RegistroLivre" class="visible-xs">Github</a></li>
			</ul>
			
			
			<form id="inputaBuscaNavbar" class="form navbar-form navbar-right " role="search" name="pesquisa" action="/busca" method="GET">
			
				<div class="input-group">
					<input type="text" class="form-control" name="busca" id="campo-pesquisado-navbar" placeholder="Buscar" />
					<span><button type="submit" class="btn botao-busca botao-busca-navbar"><span class="glyphicon glyphicon-search"></span></button></span>
				</div>								
			</form>			
		</div>
	</div>
</nav>

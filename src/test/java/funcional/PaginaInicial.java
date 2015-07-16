package funcional;

import static org.fest.assertions.Assertions.assertThat;

import org.fluentlenium.core.FluentPage;

public class PaginaInicial extends FluentPage{
	
	@Override
	public String getUrl(){
		final String url = System.getenv("URL_ENV_TESTE");
		return url;
	}
	
	@Override
	public void isAt(){
		assertThat(title().contains("Registro Livre"));
	}

	public boolean abreBuscaAvancada() throws InterruptedException {
		click("#abrir-busca-avancada");
		
		Thread.sleep(1000);

		return find("#busca-avancada").first().isDisplayed(); 
	}
	
	public boolean fechaBuscaAvancada() throws InterruptedException{

		click("#fecha-busca-avancada");
		
		Thread.sleep(1000);
		
		return find("#busca-avancada").first().isDisplayed();					
	}
	
	public boolean preencheInputDaBusca(String parametro) throws InterruptedException {
		fill("#campo-pesquisado").with(parametro);
		
		return find("#btn-submit").first().isEnabled();
	}
	
	public void clicaNoBotaoPesquisaSocio() throws InterruptedException{
		abreBuscaAvancada();
		
		click("#adiciona-socios-busca-avancada");
	}

}

package funcional;

import java.io.File;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PaginaInicialTest extends FluentTest {
	
	protected static String path;
	
	static {
		System.setProperty("webdriver.chrome.driver", System.getenv("WEBDRIVER_PATH"));
	}

	@Page
	private PaginaInicial paginaInicial = new PaginaInicial();

	public WebDriver driver = new ChromeDriver(DesiredCapabilities.chrome());
	
	@Override
	public WebDriver getDefaultDriver() {
		return driver;
	}
	
	
	 @Test
	 public void quandoOInputDaBuscaEstiverVazioOBotaoDaBuscaDeveEstarDesativado() throws Exception {
		goTo(paginaInicial);
		String parametro = "";
	 	
	 	boolean buttonIsEnabled = paginaInicial.preencheInputDaBusca("");
	 	
	 	assertEquals(buttonIsEnabled, false);
	 }

	 
	 @Test
	 public void quandoOInputDaBuscaEstiverPreenchidoOBotaoDeveEstarAtivado() throws Exception {
		goTo(paginaInicial);
		String parametro = "Larah";
		
		boolean buttonIsEnabled = paginaInicial.preencheInputDaBusca(parametro);
		
		assertEquals(buttonIsEnabled, true);
	 }
	
	 @Test
	 public void deveAbrirEFecharOFormDeBuscaAvancada() throws Exception {
		 goTo(paginaInicial);
		 
		 boolean buscaAvancadaIsDisplayed = paginaInicial.abreBuscaAvancada();
		 boolean buscaAvancadaIsHidden = paginaInicial.fechaBuscaAvancada();
		 
		 assertEquals(buscaAvancadaIsDisplayed, true);
		 assertEquals(buscaAvancadaIsHidden, false);
	 }
	 

	 @Test
	 public void quandoOUsuarioClicarEmPesquisaSocioDeveAbrirUmNovoFormDeSocio() throws InterruptedException{
		 goTo(paginaInicial);
		 
		 paginaInicial.clicaNoBotaoPesquisaSocio();
		 
		 assertTrue(pageSource().contains("Nome do sócio"));
	 }
}

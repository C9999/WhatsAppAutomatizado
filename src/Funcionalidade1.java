import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Funcionalidade1 {
	private ChromeDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers-Tester\\3chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://web.whatsapp.com/");
	}
	
	@Test
	public void enviarMensagemWpp(){	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//Espera necessária para capturar o QRcode pelo celular 
		
		WebElement grupoPodcastsLovers = driver.findElement(By.xpath(".//*[@id='pane-side']/div/div/div/div[10]/div/div/div[2]/div[1]/div[1]/span"));
		grupoPodcastsLovers.click();	
		
		WebElement campoDeMensagem = driver.findElement(By.xpath(".//*[@id='main']/footer/div[1]/div[1]/div/div[2]"));
		campoDeMensagem.sendKeys("Olá pesseoal do Grupo Ouvintes de Podcasts. Hoje vou indicar um Podcast bem legal sobre "
				+ "Tecnologia e Desenvolvimento: "
				+ "https://soundcloud.com/concrete-solutions ");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Espera necessária para aguardar a mensagem ser digitada para que o icone de gravar audio vire botão de envio		
		WebElement botaoEnviaMensagem = driver.findElement(By.xpath(".//*[@id='main']/footer/div[1]/button[2]"));
		botaoEnviaMensagem.click();	
	}
}

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Funcionalidade2 {
	private ChromeDriver driver;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers-Tester\\3chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://web.whatsapp.com/");
	}
	
	@Test
	public void sairDoWpp(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//capturar o QRcode pelo celular 
		WebElement opcoes = driver.findElement(By.xpath(".//*[@id='side']/header/div[2]/div/span/div[2]/button"));
		opcoes.click();
		
		WebElement sair = driver.findElement(By.xpath(".//*[@id='side']/header/div[2]/div/span/div[2]/span/div/ul/li[6]/a"));
		sair.click();
		driver.close();
	}
}

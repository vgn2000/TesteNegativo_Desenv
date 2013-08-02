import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNegativo2CartoesVisaVisa_NumErrado {
	
	WebDriver driver;
	

	@BeforeClass
		
		public static void main() throws InterruptedException {

			 System.setProperty("webdriver.chrome.driver",
					"C:/eclipse/teste-de-sistemas/chromedriver.exe");
				
		}	
	       @Test
			public void realizandoCompras() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
	            driver.get("http://walmart.com.br");
			 		
	        
			Thread.sleep(4000);	
			driver.findElement(By.linkText("Fechar")).click();
			Thread.sleep(1000);	
			
			
			driver.findElement(By.id("search-field")).sendKeys("Geladeira");
			driver.findElement(By.id("search-button")).click();
			driver.get("https://www2.walmart.com.br/Site/Login.aspx?ReturnUrl=/Vitrine/MinhaConta/MeuWalMart.aspx");
			
		    WebElement email = driver.findElement(By.name("ctl00$Conteudo$txtUsername"));
		    email.sendKeys("vgn2000@hotmail.com");
		    WebElement senha = driver.findElement(By.id("ctl00_Conteudo_Password"));
		    senha.sendKeys("1234mudar");
		  		
		    
		    driver.get("http://walmart.com.br/");
		    driver.findElement(By.id("search-field")).sendKeys("357983");
		    driver.findElement(By.id("search-button")).click();
		    driver.get("http://www.walmart.com.br/produto/Livros/Literatura-Infanto-juvenil/Zastras/280627-100-Coisas-Mais-Nojentas-do-Planeta");
		    
		    driver.get("http://www2.walmart.com.br/Carrinho/Add/357983/-1/0/");
		    driver.findElement(By.id("btnConfirmarCompra2")).click(); 
			

		    WebElement name = driver.findElement(By.name("ctl00$Conteudo$txtUsername"));
	        name.sendKeys("lkp.pita@gmail.com");
	        WebElement password = driver.findElement(By.id("ctl00_Conteudo_Password"));
	        password.sendKeys("equipeqa");
	        driver.findElement(By.name("ctl00$Conteudo$Login")).click();
	        
	        driver.findElement(By.className("bnt-selecionar-dadosdecompra")).click();
	       
	        
	        driver.get("https://www2.walmart.com.br/FormaPagamento");

	        
		
	        ///////////////////Escolhendo o 1º Cartão Crédito - Visa
	        
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id='lnkPagarDoisCartoes']")).click();
	        Thread.sleep(1000);
	      

	        Thread.sleep(5000);
	        driver.findElement(By.id("txtCcValor1")).sendKeys("1,00");
	        Thread.sleep(1000);
	        
	        Thread.sleep(5000);  
	        driver.findElement(By.xpath("//*[@id='divCartao1']/fieldset/fieldset/div/div[3]/input")).click();
	        Thread.sleep(1000);
	               
	        Thread.sleep(7000);
		     driver.findElement(By.xpath("//*[@id='cartao1_txtCcNumero']")).sendKeys("4916755161498245");
		     Thread.sleep(1000);
		     
		     driver.findElement(By.xpath("//*[@id='cartao1_txtCcNome']")).sendKeys("Automate Testes Walmart");
		     driver.findElement(By.xpath("//*[@id='cartao1_txtCcCpfCnpj']")).sendKeys("63417181445");
		   

		     Thread.sleep(5000);
		     driver.findElement(By.xpath("//*[@id='cartao1_txtCcCodigo']")).sendKeys("321");
		     Thread.sleep(1000);
		     
	        
	        WebElement roleDropdown = driver.findElement(By.xpath("//*[@id='cartao1_txtCcMes']/option[@value='12']"));
	        roleDropdown.click();     
	        
	        WebElement roleDropdown1 = driver.findElement(By.xpath("//*[@id='selectAno']/option[@value='15']"));
	        roleDropdown1.click(); 
	        
	        WebElement roleDropdown2 = driver.findElement(By.xpath("//*[@id='cartao1_txtListaParcela']/option[@value='1']"));
	        roleDropdown2.click(); 
	        
	        ///////////////////Escolhendo o 2º Cartão Crédito - Visa (Número Errrado do Cartão Visa)
	        
	        
	         	 
		     Thread.sleep(5000);
		     driver.findElement(By.xpath("//*[@id='divCartao2']/fieldset/fieldset/div/div[3]/input")).click();
		     Thread.sleep(1000); 
		     
		     
		     Thread.sleep(5000);
		     driver.findElement(By.xpath("//*[@id='cartao2_txtCcNumero']")).sendKeys("491675516149888");
		     Thread.sleep(1000);
		     
		     driver.findElement(By.name("cartao2.txtCcNome")).sendKeys("Automate Testes Walmart");
		     driver.findElement(By.name("cartao2.txtCcCpfCnpj")).sendKeys("63417181445");
		   

		     Thread.sleep(5000);
		     driver.findElement(By.id("cartao2_txtCcCodigo")).sendKeys("321");
		     Thread.sleep(1000);
		     

		     WebElement roleDropdown22 = driver.findElement(By.xpath("//*[@id='cartao2_txtCcMes']/option[@value='12']"));
		     roleDropdown22.click();     


		     WebElement roleDropdown23 = driver.findElement(By.xpath("//*[@id='DadosFormaPagamamentoCartao2']/fieldset/fieldset[5]/select[2]//option[@value='15']"));
		     roleDropdown23.click(); 

		     WebElement roleDropdown25 = driver.findElement(By.xpath("//*[@id='cartao2_txtListaParcela']/option[@value='2']"));
		     roleDropdown25.click(); 


		     driver.findElement(By.xpath("//*[@id='DadosFormaPagamamentoCartao']/*[@id='btnSalvarCartao']")).click();

		     driver.findElement(By.xpath("//*[@id='btnSalvar1']")).click();
	        
			}
			
			 @AfterMethod(alwaysRun=true)
			 public void catchExceptions(ITestResult result){
			     Calendar calendar = Calendar.getInstance();
			     SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			     String methodName = result.getName();
			     if(!result.isSuccess()){
			         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			         try {
			             FileUtils.copyFile(scrFile, new File(methodName+"_"+formater.format(calendar.getTime())+".png"));
			         } catch (Exception e1) {
			             e1.printStackTrace();
			         }
			     }
			     driver.quit();
			     
			  }
	        
		
	}

package com.br.ifpe.tutorialSelenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


class TestNavegador {
	static WebDriver driver;
	private static Document doc;
	private static NodeList listaProcedimentos;
	private static NodeList listaCasos;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jacyara\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
		try {
			File inputFile = new File("C:\\Users\\Jacyara\\eclipse-workspace\\tutorialSelenium2\\src\\test\\java\\com\\br\\ifpe\\tutorialSelenium\\CasosDeTeste.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			listaProcedimentos = doc.getElementsByTagName("procedimento");
		}catch(Exception e) {
			System.out.println("Erro na leitura do documento");
		}
		driver.get("https://www.calculadoraonline.com.br/basica");

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}


	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void TesteSoma() {
	    Element procedimento = (Element) listaProcedimentos.item(0);
	    listaCasos = procedimento.getElementsByTagName("caso");
	    
	    for(int indcaso = 0; indcaso < listaCasos.getLength(); indcaso++) {
	        Element caso = (Element) listaCasos.item(indcaso);                
	        driver.findElement(By.id("TIExp")).sendKeys(caso.getElementsByTagName("numero1").item(0).getTextContent());
	        driver.findElement(By.id("b4")).click();
	        driver.findElement(By.id("TIExp")).sendKeys(caso.getElementsByTagName("numero2").item(0).getTextContent());    
	        driver.findElement(By.id("b27")).click();
	        assertEquals(caso.getElementsByTagName("resultado").item(0).getTextContent(), driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
	        driver.findElement(By.xpath("//*[@id=\"jp-right\"]/div[2]/div/main/article/div[7]/table/tbody/tr/td[2]")).click();
	    }
	}

	
	@Test
	void TesteExponencial() {
	    Element procedimento = (Element) listaProcedimentos.item(1);
	    listaCasos = procedimento.getElementsByTagName("caso");
	    
	    for(int indcaso = 0; indcaso < listaCasos.getLength(); indcaso++) {
	        Element caso = (Element) listaCasos.item(indcaso);    
	        driver.findElement(By.id("b31")).click();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.findElement(By.id("cx31_0")).sendKeys(caso.getElementsByTagName("numero1").item(0).getTextContent());
	        driver.findElement(By.id("cx31_1")).sendKeys(caso.getElementsByTagName("numero2").item(0).getTextContent());    
	        driver.findElement(By.xpath("//*[@id=\"dpb31\"]/button")).click();
	        assertEquals(caso.getElementsByTagName("resultado").item(0).getTextContent(), driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
	        driver.findElement(By.xpath("//*[@id=\"jp-right\"]/div[2]/div/main/article/div[7]/table/tbody/tr/td[2]")).click();
	    }
	}
	

	@Test
	void TesteFatorial() {
	    Element procedimento = (Element) listaProcedimentos.item(2);
	    listaCasos = procedimento.getElementsByTagName("caso");
	    
	    for(int indcaso = 0; indcaso < listaCasos.getLength(); indcaso++) {
	        Element caso = (Element) listaCasos.item(indcaso);                
	        driver.findElement(By.id("TIExp")).sendKeys(caso.getElementsByTagName("numero1").item(0).getTextContent());
	        driver.findElement(By.id("b15")).click();
	        driver.findElement(By.id("b27")).click();
	        assertEquals(caso.getElementsByTagName("resultado").item(0).getTextContent(), driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
	        driver.findElement(By.xpath("//*[@id=\"jp-right\"]/div[2]/div/main/article/div[7]/table/tbody/tr/td[2]")).click();
	    }
	}
	

	@Test
	void TesteRaizQuadrada() {
	    Element procedimento = (Element) listaProcedimentos.item(3);
	    listaCasos = procedimento.getElementsByTagName("caso");
	    
	    for(int indcaso = 0; indcaso < listaCasos.getLength(); indcaso++) {
	        Element caso = (Element) listaCasos.item(indcaso);                
	        driver.findElement(By.id("TIExp")).sendKeys(caso.getElementsByTagName("numero1").item(0).getTextContent());
	        driver.findElement(By.xpath("//*[@id=\"b21\"]")).click();
	        driver.findElement(By.id("b27")).click();
	        assertEquals(caso.getElementsByTagName("resultado").item(0).getTextContent(), driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
	        driver.findElement(By.xpath("//*[@id=\"jp-right\"]/div[2]/div/main/article/div[7]/table/tbody/tr/td[2]")).click();
	    }
	}
	
	@Test
	void TesteRegraDeTres() {
	    Element procedimento = (Element) listaProcedimentos.item(4);
	    listaCasos = procedimento.getElementsByTagName("caso");
	    
	    for(int indcaso = 0; indcaso < listaCasos.getLength(); indcaso++) {
	        Element caso = (Element) listaCasos.item(indcaso);    
	        driver.findElement(By.id("b37")).click();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.findElement(By.id("cx37_0")).sendKeys(caso.getElementsByTagName("numero1").item(0).getTextContent());
	        driver.findElement(By.id("cx37_1")).sendKeys(caso.getElementsByTagName("numero2").item(0).getTextContent()); 
	        driver.findElement(By.id("cx37_2")).sendKeys(caso.getElementsByTagName("numero3").item(0).getTextContent());  
	        driver.findElement(By.xpath("//*[@id=\"dpb37\"]/button")).click();
	        assertEquals(caso.getElementsByTagName("resultado").item(0).getTextContent(), driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
	        driver.findElement(By.xpath("//*[@id=\"jp-right\"]/div[2]/div/main/article/div[7]/table/tbody/tr/td[2]")).click();
	    }
	}

}


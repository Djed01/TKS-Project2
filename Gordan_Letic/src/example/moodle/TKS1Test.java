package example.moodle;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TKS1Test {
	  private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	  public void tKS1() {
	    driver.get("http://localhost:4200/");
	    driver.manage().window().setSize(new Dimension(1936, 1176));
	    driver.findElement(By.linkText("Add Student")).click();
	    driver.findElement(By.cssSelector(".form-group:nth-child(1) > .form-control")).click();
	    driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[1]/input")).click();
	    driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[1]/input")).sendKeys("name123");
	    driver.findElement(By.cssSelector(".ng-invalid:nth-child(2)")).click();
	    driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[2]/input")).sendKeys("name@gmail.com");
	    driver.findElement(By.cssSelector(".ng-untouched")).click();
	    {
	      WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[3]/select"));
	      dropdown.findElement(By.xpath("//option[. = 'B-Tech']")).click();
	    }
	    driver.findElement(By.cssSelector(".btn-success")).click();
	    driver.findElement(By.linkText("View Student")).click();
	    assertThat(driver.findElement(By.cssSelector(".sorting_1")).getText(), is("name123"));
	    assertThat(driver.findElement(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr[1]/td[2]")).getText(), is("name@gmail.com"));
	    driver.findElement(By.cssSelector(".btn-info")).click();
	    driver.findElement(By.cssSelector(".form-group:nth-child(3) > .form-control")).click();
	    driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/form/div[2]/div[1]/div[2]/input")).clear();
	    driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/form/div[2]/div[1]/div[2]/input")).sendKeys("name123@gmail.com");
	    driver.findElement(By.cssSelector(".btn-success")).click();
	    driver.findElement(By.cssSelector(".btn-danger")).click();
	    assertThat(driver.findElement(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[1]")).getText(), is("name123"));
	    assertThat(driver.findElement(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[2]")).getText(), is("name123@gmail.com"));
	    assertThat(driver.findElement(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr[1]/td[3]")).getText(), is("B-Tech"));
	    vars.put("x", driver.findElements(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr")).size());
	    assertEquals(vars.get("x").toString(), "1");
	    driver.findElement(By.cssSelector(".fa")).click();
	    vars.put("x", driver.findElements(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr")).size());
	    assertEquals(vars.get("x").toString(), "0");
	  }
	}

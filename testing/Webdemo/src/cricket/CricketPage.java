package cricket;




import static org.testng.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExcelWrite;
public class CricketPage {
WebDriver driver;




@FindBy(xpath="//input[@type='text']")
WebElement Search_field;

@FindBy(xpath="(//*[contains(text(),'ODI 4 of 5 (Tied 2-2)')])[1]")
WebElement link;

@FindBy(xpath="(//*[contains(text(),'Australia')])[4]")
WebElement australia;

@FindBy(xpath="(//table/tbody/tr[1]/td[2])[")
WebElement run;

@FindBy(xpath="(//table/tbody/tr[1]/td[1])[")
WebElement player;






	   public CricketPage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	       PageFactory.initElements(driver, this);

	    }
	   public void Search_field(String search){
		   Search_field.sendKeys(search);
	    }

	   public void link(){
		   link.click();

	    }
	   
	   public void australia(){
		   australia.click();

	    }
	   
	   public void detail() throws Exception{
		   int expected=30;
		   int k=14;
		   int a=2;
			for(int i=23;i<32;i++)
			 {
			String actual=driver.findElement(By.xpath("(//table/tbody/tr[1]/td[2])["+i+"]")).getText();
			try{
			if(Integer.parseInt(actual)>expected)
			{
				System.out.println(actual);
				/*int l=k+i+1;*/
				for(int j=i+k;j<j+1;j++)
				 {
					String playername=driver.findElement(By.xpath("(//table/tbody/tr[1]/td[1])["+j+"]")).getText();
					System.out.println(playername);
					
					for(int b=a;b<a+1;b++)
					 {
						ExcelWrite eat = new ExcelWrite("D://testing//Webdemo//src//testData//Cricketwrite.xlsx");
				        eat.setCellData("Sheet1","Player Name",b,playername);
				        eat.setCellData("Sheet1","Run",b,actual);
					 }
					a++;
				 }
			}
			}catch(NumberFormatException e)
			{
				continue;
			}
			k++;
			 }
	}
} 



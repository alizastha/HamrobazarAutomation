package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItem {
	WebDriver dvr;
    public SearchItem(WebDriver paramdvr) {
        PageFactory.initElements(paramdvr, this);
        this.dvr = paramdvr;
        
    }

    
    @FindBy(xpath=".//input[1][@name='searchword']")
    WebElement Searchkeyword;
    
    @FindBy(xpath=".//input[@type='submit']")
    WebElement GoBtn;
    
    @FindBy(xpath=".//option[text()[contains(.,'Price: Low to High')]]")
    WebElement SortAdsByoption;
    
    
    
    
    public void SetSearchKeyword(String Keyword) {
    	Searchkeyword.sendKeys(Keyword);
    }
    public void GoButtonClick() {
    	GoBtn.click();
    }
    public void LowToHighOption() {
    	SortAdsByoption.click();
    }
}

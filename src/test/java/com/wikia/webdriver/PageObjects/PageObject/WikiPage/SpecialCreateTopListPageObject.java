package com.wikia.webdriver.PageObjects.PageObject.WikiPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wikia.webdriver.Common.Logging.PageObjectLogging;

//Top_10_list_EditonCore class was created because there are 2 very similar (but not the same) PageObjects: Special:CreateTopList  and Special:EditTopList
//Special:CreateTopList extends Top_10_list_EditonCore
//Special:EditTopList   extends Top_10_list_EditonCore
//Both of the two PageObjects share many methods from Top_10_list_EditonCore. However, they have some unique methods specific to their own nature. Those are distinguished in their class-bodies

public class SpecialCreateTopListPageObject extends Top_10_list_EditonCore{

	@FindBy(css=".FormButtons input")
	private WebElement createlistButton; 
	@FindBy(css="#list_name")
	private WebElement listNameField; 
	
	public SpecialCreateTopListPageObject(WebDriver driver, String Domain, String top_10_list_Name) {
		super(driver, Domain);
		PageFactory.initElements(driver, this);
	}

	public Top_10_list clickCreateList() {
		waitForElementByElement(createlistButton);
		clickAndWait(createlistButton);
		return new Top_10_list(driver, Domain, this.articlename);
	}

	public void verifyListName(String listName) {
		waitForElementByElement(listNameField);
		waitForValueToBePresentInElementsAttributeByElement(listNameField, "value", listName);
		PageObjectLogging.log("verifyListName", "verify that list has its name visible: "+listName, true, driver);		
	}
}

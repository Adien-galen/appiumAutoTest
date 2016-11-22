package com.kdzwy.appium;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
   
public class AppDemo {  
    private AppiumDriver driver;  
   
    @BeforeClass
    public void setUp() throws Exception {  
    	//����apk��·��
        File classpathRoot = new File(System.getProperty("user.dir"));  
        File appDir = new File(classpathRoot, "apps");  
        File app = new File(appDir, "ContactManager.apk"); 
        
      //�����Զ�����ز���
        DesiredCapabilities capabilities = new DesiredCapabilities();  
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");  
        //ʹ�������ƶ�ƽ̨
        capabilities.setCapability("platformName", "Android");  
        //���������豸�����������ģ����
        capabilities.setCapability("deviceName","Android Emulator");  
        
      //���ð�׿ϵͳ�汾
        capabilities.setCapability("platformVersion", "4.4.2");  
      //����apk·��
        capabilities.setCapability("app", app.getAbsolutePath());  
        
      //����app����������������
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");  
        capabilities.setCapability("appActivity", ".ContactManager");  
        
      //��ʼ��
      driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  
    }  
   
    @Test  
    public void addContact(){  
        WebElement el = driver.findElement(By.name("Add Contact"));  
        el.click();  
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");  
        textFieldsList.get(0).sendKeys("Some Name");  
        textFieldsList.get(2).sendKeys("Some@example.com");  
        driver.swipe(100, 500, 100, 100, 2);  
        driver.findElementByName("Save").click();  
    }  
    
    @AfterClass  
    public void tearDown() throws Exception {  
        driver.quit();  
    }  
}  

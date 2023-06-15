package org.Temelio.Utilities;



import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Properties;

public  class ReadConfig {
    public static Properties prop=new Properties();
    public static File loginfile=new File("F:\\Testing\\Workspace\\Temelio\\Configurations\\qa.properties");
    public static File Adminfile=new File("F:\\Testing\\Workspace\\Temelio\\Configurations\\adminsetting.properties");
    public static File Contactfile=new File("F:\\Testing\\Workspace\\Temelio\\Configurations\\Contacts.properties");
    public static Map<String, String> inputData = new HashMap<String, String>();

    public static Map<String , String> loginData(){
    try {
        FileInputStream fislogin = new FileInputStream(loginfile);
        prop.load(fislogin);
        inputData.put("LoginURL", prop.getProperty("baseURl"));
        inputData.put("Email", prop.getProperty("email"));
        inputData.put("Password", prop.getProperty("password"));
        inputData.put("Browser", prop.getProperty("browser"));
        inputData.put("TitleofPage", prop.getProperty("titleofpage"));
    }
    catch(IOException e){
        e.printStackTrace();
    }
        return inputData;
}

    public static Map<String , String>admindata() {
    try {
        FileInputStream fisadmin = new FileInputStream(Adminfile);
        prop.load(fisadmin);
        inputData.put("DisplayName", prop.getProperty("Displayname"));
        inputData.put("useremail", prop.getProperty("Useremail"));
        inputData.put("titleofMemeber", prop.getProperty("Titleofmember"));
        inputData.put("accessType", prop.getProperty("Accesstype"));
        inputData.put("budgetamount", prop.getProperty("Budgetamount"));
        inputData.put("foundatinTag", prop.getProperty("FoundationTag"));
        inputData.put("bdgtcatogory", prop.getProperty("budgetCatogery"));
        inputData.put("bdgtamount", prop.getProperty("catogaryamount"));
    }
    catch (IOException e){
        e.printStackTrace();
    }
        return inputData;
    }
    public static Map<String , String>contactData(){
        try {
            FileInputStream fiscontact = new FileInputStream(Contactfile);
            prop.load(fiscontact);
            inputData.put("orgSearchName", prop.getProperty("OrgSearchName"));
            inputData.put("orgfullname", prop.getProperty("OrgFullName"));
            inputData.put("contactname", prop.getProperty("ContactName"));
            inputData.put("contactemail", prop.getProperty("ContactEmail"));
            inputData.put("internalnotes", prop.getProperty("Internalnotes"));
            inputData.put("uploadpath", prop.getProperty("uploadfilepath"));
            inputData.put("searchFileName", prop.getProperty("searchfilename"));
            inputData.put("FileName", prop.getProperty("fileName"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return inputData;
    }


}

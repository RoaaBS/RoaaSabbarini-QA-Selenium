package Support;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportClass implements ITestListener ,constant {
	ExtentReports report =new ExtentReports();
	ExtentSparkReporter htmlreporter=new ExtentSparkReporter("report/myreport.html");
	ExtentTest extentTest;
	public void onTestStart(ITestResult result) {
		report.attachReporter(htmlreporter);
		extentTest=report.createTest(result.getMethod().getMethodName());
		extentTest.log(Status.INFO, "Test Start");
	}
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Pass");
	}
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL,"Test Fail");
		
		//to make screenshot
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationPath=System.getProperty("user.dir")+File.separator +"Screenshot" +
		File.separator+ result.getName()+ ".png";
		
		File finalDestination =new File(destinationPath);
		try {
			FileUtils.copyFile(source, finalDestination);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		extentTest.log(Status.FAIL, "Step is fail, see the screenshot please")
		.addScreenCaptureFromPath(destinationPath);
	}
    public void onFinish(ITestContext context) {
    	extentTest.log(Status.INFO, "Test finish");
    	report.flush();//to remove previous report
    }

}

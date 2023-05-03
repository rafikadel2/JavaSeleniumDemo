package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

    private static Reporter reporter;


    private ExtentReports extent;
    private ExtentSparkReporter htmlReporter;



    private Reporter()
    {
        htmlReporter = new ExtentSparkReporter("test-output/ExtentReport/TestReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    public static Reporter getInstance()
    {
        if (reporter==null)
            reporter= new Reporter();
        return reporter;
    }

    public ExtentReports getExtent()
    {
        return this.extent;
    }

}

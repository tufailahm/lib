package com.training.cms;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {  "src/test/resources/Features/"}, 
		glue = { "com.training.cms" },
		tags = "@amazon or @smoke",
		plugin = {
					"pretty", 
					"html:target/HtmlReports/report.html",
					"junit:target/XMLReports/report.xml",
					"json:target/JSONReports/report.json"
		}
		)
public class CucumberTestsRunner extends AbstractTestNGCucumberTests {


}

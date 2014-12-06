package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class MyListener extends TestListenerAdapter {
	
	FileOutputStream fos;
	StringBuilder s = new StringBuilder();
	
	

	@Override
	public void onStart(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onStart(testContext);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		writeResult(result);
		super.onTestStart(result);
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		writeResult(tr);
		super.onTestFailedButWithinSuccessPercentage(tr);
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		writeResult(tr);
		super.onTestSkipped(tr);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		writeResult(tr);
		super.onTestFailure(tr);
	}
	
	
	private void writeResult(ITestResult tr)
	{
		System.out.println(tr.getStatus());
		switch (tr.getStatus())
		{

		case 16:
			s.append("<p>PASSED</p>");
			break;
		case 2:
			s.append("<p>FAILURE</p>");
			break;
		case 3:
			s.append("<p>SKIP</p>");
			break;
		case 4:
			s.append("<p>SUCCES_PERCENTAGE_FAILURE</p>");
			break;
		default:
			break;
		}
		
		s.append("<p>Results:</p>");
		for (String line : Reporter.getOutput(tr))
		{
			s.append(String.format("<p>%s</p>", line));	
		}
		
		s.append(String.format("Duration %d ms", (tr.getEndMillis() - tr.getStartMillis())));
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
		try {
			FileOutputStream fos = new FileOutputStream("log.html");
			fos.write(String.format("<html><body>%s</body></html>",
					s.toString()).getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.onFinish(testContext);
	}
	
	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		writeResult(itr);
		super.onConfigurationSuccess(itr);
	}

}

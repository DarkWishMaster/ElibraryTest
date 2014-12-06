package test;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class TestNgAppender extends ConsoleAppender{
	
	@Override
	public  void append(LoggingEvent event) {
		Reporter.log(event.getMessage().toString());
		super.append(event);
	}
}

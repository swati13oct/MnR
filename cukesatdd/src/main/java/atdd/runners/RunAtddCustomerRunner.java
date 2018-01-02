package atdd.runners;
import java.io.IOException;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import  atdd.framework.ExecutionListener;

import cucumber.junit.Cucumber;


public class RunAtddCustomerRunner extends Cucumber {

	public RunAtddCustomerRunner(Class clazz) throws InitializationError, IOException {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(RunNotifier  notifier)
	{
		notifier.addListener(new ExecutionListener());
		super.run(notifier);
	
	}

}

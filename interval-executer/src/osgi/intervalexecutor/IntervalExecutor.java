package osgi.intervalexecutor;

import java.util.Timer;
import java.util.TimerTask;

import osgi.command.ICommand;

public class IntervalExecutor implements IIntervalExecutor{
	private ICommand command;
	private int initialDelay;
	private int interval;

	@Override
	public int getInitialDelay() {
		return initialDelay;
	}

	@Override
	public void setInitialDelay(int initialDelay) {
		this.initialDelay = initialDelay;
	}

	@Override
	public int getInterval() {
		return interval;
	}

	@Override
	public void setInterval(int interval) {
		this.interval = interval;
	}

	@Override
	public ICommand getCommand() {
		return command;
	}

	@Override
	public void setCommand(ICommand command) {
		this.command = command;
	}
	
	@Override
	public void run() {
		// TODO: If any of the properties are null, call onError with a new exception
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				try {
					command.onInitiation();
					command.execute();
				} catch (Exception e) {
					command.onError(e);
				} finally {
					command.onSuccess();
				}
			}
		};
		
		timer.scheduleAtFixedRate(task, this.getInitialDelay(), this.getInitialDelay());
	}
}

package pipeAndFilterV2.pipe_foundations;

import java.util.List;

//Fan-In Fan-out
public abstract class Filter<I, O> extends ThreadedRunner {
	protected Pipe<I> input;
	protected List<Pipe<O>> output;

	public Filter(Pipe<I> input, List<Pipe<O>> output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {
		transformBetween(input, output);
	}

	protected abstract void transformBetween(Pipe<I> input, List<Pipe<O>> output);
}

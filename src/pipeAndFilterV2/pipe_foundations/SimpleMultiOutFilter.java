package pipeAndFilterV2.pipe_foundations;

import java.util.List;

public abstract class SimpleMultiOutFilter<I, O> extends MultiOutFilter<I, O> {
    public SimpleMultiOutFilter(Pipe<I> input, Pipe<O>... output) {
        super(input, output);
    }

    @Override
    protected void transformBetween(Pipe<I> input, <Pipe<O>[] output) {
        try {
            I in;
            while ((in = input.nextOrNullIfEmptied()) != null) {
                O out = transformOne(in);
                for(Pipe<O> oPipe : output)
                	oPipe.put(out);
            }
        } catch (InterruptedException e) {
            // TODO handle properly, using advice in http://www.ibm.com/developerworks/java/library/j-jtp05236/
            System.err.println("interrupted");
            e.printStackTrace();
            return;
        }
        for(Pipe<O> oPipe : output)
            output.closeForWriting();
    }

    protected abstract O transformOne(I in);
}

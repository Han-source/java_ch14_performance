package pipeAndFilterV2.pipe_foundations.example;

import java.util.List;

import pipeAndFilterV2.pipe_foundations.Pipe;
import pipeAndFilterV2.pipe_foundations.SimpleMultiOutFilter;



public class ExampleMultiOutFilter extends SimpleMultiOutFilter<Integer, String> {
    public ExampleMultiOutFilter(Pipe<Integer> input, Pipe<String>... output) {
        super(input, output);
    }

    @Override
    protected String transformOne(Integer in) {
        String out = Integer.toString(in) + "haha";
        System.out.println("filtered " + Integer.toString(in) + " to " + out);
        delayForDebug(100);
        return out;
    }
}

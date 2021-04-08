package pipeAndFilterV2.pipe_foundations.example;

import pipeAndFilterV2.pipe_foundations.Filter;
import pipeAndFilterV2.pipe_foundations.Generator;
import pipeAndFilterV2.pipe_foundations.MultiOutFilter;
import pipeAndFilterV2.pipe_foundations.Pipe;
import pipeAndFilterV2.pipe_foundations.PipeImpl;
import pipeAndFilterV2.pipe_foundations.Sink;

public class ExampleMultiPipeRunner {
    public static void main(String[] args) {
        // create pipes
        final Pipe<Integer> genToFilter = new PipeImpl<Integer>();
        final Pipe<String> filterToOut1 = new PipeImpl<String>();
        final Pipe<String> filterToOut2 = new PipeImpl<String>();
   
        // create components that use the pipes
        final Generator<Integer> generator = new ExampleGenerator(genToFilter);
        final MultiOutFilter<Integer, String> filter = new ExampleMultiOutFilter(genToFilter, filterToOut1, filterToOut2);
        final Sink<String> sink1 = new ExampleSink(filterToOut1);
        final Sink<String> sink2 = new ExampleSink(filterToOut2);
        // start all components
        generator.start();
        filter.start();
        sink1.start();
        sink2.start();

        System.out.println("runner finished");
    }
}

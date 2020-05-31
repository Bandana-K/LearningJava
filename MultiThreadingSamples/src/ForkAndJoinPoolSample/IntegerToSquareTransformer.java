package ForkAndJoinPoolSample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class IntegerToSquareTransformer extends RecursiveTask<List<Integer>>{
	
	List<Integer> list;
	private int thresholdLimit = 100;
	
	IntegerToSquareTransformer(List<Integer> list){
		this.list = list;
	}

	@Override
	protected List<Integer> compute() {
        if (list.size() <= thresholdLimit) {
            return computeDirectly(list);
        } else {
            int middle = (list.size()) / 2;
 
            IntegerToSquareTransformer subTask1 = new IntegerToSquareTransformer(list.subList(0, middle));
            IntegerToSquareTransformer subTask2 = new IntegerToSquareTransformer(list.subList(middle, list.size()));
 
            invokeAll(subTask1, subTask2);
 
            List<Integer> result = new ArrayList<Integer>();
            result.addAll(subTask1.join());
            result.addAll(subTask2.join());
            
            return result;
        }
     }

	private List<Integer> computeDirectly(List<Integer> list) {
		List<Integer> result = new ArrayList<>();
		for(int i= 0; i<list.size(); i++) {
			int number = list.get(i);
			result.add(number*number);
			
		}
		return result;
	}

}

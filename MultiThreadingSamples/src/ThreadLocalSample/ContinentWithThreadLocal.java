package ThreadLocalSample;

import java.util.*;

public class ContinentWithThreadLocal implements Runnable{
		
    private static final ThreadLocal<List<String>> countryList = new ThreadLocal<List<String>>(){
        @Override
        protected List<String> initialValue()
        {
            return new ArrayList<String>();
        }
    };
	private String continent;
	
	ContinentWithThreadLocal(String continent, List<String> list){
		this.continent = continent;
		countryList.set(list);
	}

	@Override
	public void run() {
		if(continent.equals("EUROPE")) {
			countryList.get().add("ENGLAND");
			countryList.get().add("ITALY");
			countryList.get().add("SPAIN");
		} else {
			countryList.get().add("INDIA");
			countryList.get().add("PAKISTAN");
			countryList.get().add("BANGLADESH");
		}
		
	}

}

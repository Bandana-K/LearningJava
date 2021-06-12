package CountNumberOfWaysToDecodeString;

public class DriverClass{
	  
	  public static void main(String args[]){
	    String toTest = "12234";		
	    int result = getPossibleDecodeCount(toTest);
	    System.out.println(result);
	  }
	  
	  static int getPossibleDecodeCount (String toTest) {
	    
	    int length = toTest.length();
	    int[] resultArr = new int[length];
	    resultArr[0] = 1;
	    
	    if(length == 0){
	      return 0;
	    } 
	    
	    if(length == 1){
	      return 1;
	    } 
	    
	    
	    for(int i = 1; i < length; i++){
	    	
	    	String test = toTest.substring(i-1, i+1);
	    	int addition = Integer.valueOf(test) > 26 ? 0 : 1 ;
	    	
	      	resultArr[i] = resultArr[i-1] + addition;
	  	}
	    
	    return resultArr[length-1];

	  }
	  
}
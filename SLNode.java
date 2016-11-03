public class SLNode 
{
	 public String key;
	 public SLNode forward[];
	 
	 public String key()
	 {
		 return key;
	 }
	
	 public SLNode(String key){
		 this.key = key;
	 }

	public SLNode(String key, int level)
	{
		this.key = key;
		forward = new SLNode[level+1];
		
	}

}
	   



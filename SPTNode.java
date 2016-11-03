
public class SPTNode {
	
	String key;
	//String Value;
	SPTNode left;
	SPTNode right;
	SPTNode parent;
	public SPTNode()
	{
		left = null;
		right = null;
		parent = null;
	}
	
	public SPTNode(String key)
	{
		this.key = key;
		
		left = null;
		right = null;
		parent = null;
		
	}

}

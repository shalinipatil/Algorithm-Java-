
public class NodeBST {
	String key;
	//String Value;
	NodeBST left;
	NodeBST right;
	NodeBST parent;
	public NodeBST()
	{
		left = null;
		right = null;
		parent = null;
	}
	
	public NodeBST(String key)
	{
		this.key = key;
		
		left = null;
		right = null;
		parent = null;
		
	}
}

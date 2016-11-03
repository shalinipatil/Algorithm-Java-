import java.util.*;

public class BSTrees extends NodeBST {
	public NodeBST root;
	public NodeBST nil = null;
	int count=0; 
	public BSTrees()
	{
		root = null;
	}
	public int Num()
	{
		return count;
	}
	 public void insert(String key)
     {
		
		NodeBST Z = new NodeBST(key);
		NodeBST X = root;
		NodeBST Y = null;
					
		while(X!= null)
		{
			Y = X;
			if(root == null)
			{
				root = Z;
			}
			
			else
			{
				if(key.compareTo(X.key)==0)
					return ;
				if(key.compareTo(X.key)<0)
				{
					X = X.left;
				}
				else
					X = X.right;
			}
		}
		Z.parent = Y;
		if (Y == nil)
		{
			root = Z;
		}
		else if(Z.key.compareTo(Y.key)<0)
		{
			Y.left = Z;
		}
		else
			Y.right = Z;
		count ++;
	}
	private NodeBST search(NodeBST x,String key)
	{
			if(x == nil || key.compareTo(x.key)==0)  
				return x;
			else if(key.compareTo(x.key)<0)
				return search(x.left,key);
			else 
				return search(x.right,key);
	}
	
	public void inorder()
	{
		inorder(root);
    }
    private void inorder(NodeBST X)
    {
		if(X!= nil)
		{
			inorder(X.left);
			System.out.print(" "+ X.key + "\n");
			inorder(X.right);
		}
	}
	
	public int height() 
	{
		 return height(root);
	}

	public int height(NodeBST X)
	{	
		if (X == nil)
			return 0;
		return 1 + Math.max(height(X.left), height(X.right));
			
			
	}
	
	public void delete(String key)
    {		
		if (root == null)
			return;

		NodeBST X = search(root, key);
		NodeBST Y = null;

		if (X != nil)
		{
			if (X.left == null) 
			{
				Transplant(X, X.right);
			} 
			else if (X.right == null) 
			{
				Transplant(X, X.left);
			} 
			else
			{
				Y = TreeMinimum(X.right);
				if (Y.parent != X)
				{
					Transplant(Y, Y.right);
					Y.right = X.right;
					Y.right.parent = Y;
				}
				Transplant(X, Y);
				Y.left = X.left;
				Y.left.parent = Y;
			}
			count --;
		} 
		else
			return;
	}
 	
	private NodeBST Transplant(NodeBST u,NodeBST v)
	{ 
		
		if (u.parent == null)
	    	 root = v;
		else if(u == u.parent.left)
		     u.parent.left = v;
		else
			u.parent.right = v;
		if(v!= nil)
			v.parent = u.parent;
		return root;
		
    }
		
	private NodeBST TreeMinimum(NodeBST X)
	{		
		while(X.left!= null)
			X = X.left;
		return X;
	}


}


public class RedBlackTree extends RBTNode
{
	public RBTNode null_node;
	public RBTNode root_node;
	int count=0; 

	public int Num()
	{
		return count;
	}
	/******************************************************
	 *  Constructor to intialize T.nil and T.root
	 *  
	 ******************************************************/
	public RedBlackTree() {
		
		// Creating null_node = T.nil
		null_node = new RBTNode();
		null_node.color = "B";
		

		// Creating root_node = T.root
		root_node = null_node;
		root_node.color = "B";
		
	}
	

	/*******************************************************
	 *  Method to perform Insertion on Red Black tree
	 *  
	 *******************************************************/
	public void insert(String key) {
		RBTNode Z = new RBTNode(key);
		RBTNode Y = null_node;
		RBTNode X = root_node;
		
		while (X != null_node) 
		{
			Y = X;
            
            	if(Z.key.compareTo(X.key)==0)
				return ;
			if (Z.key.compareTo(X.key)<0) {
				X = X.left;
			}
			else {
				X = X.right;
			}
		}
		Z.parent = Y;
		
		// Insertion of first node in empty tree (root node)
		if (Y == null_node) {
			root_node = Z;
			root_node.parent = null_node; 
		}
		// Else insert node at the correct left or right position in the tree  
		else if (Z.key.compareTo(Y.key)<0) {
			Y.left = Z;
		}
		else {
			Y.right = Z;
		}
		
		//Assigning left and right children of inserted node to T.nil as inserted node is leaf
		Z.left = null_node;
		Z.right = null_node;
		
		//Assign RED color to z
		Z.color = "R";
		count++;
		
		// Call to insertFixup to maintain red black tree properties
		insertFixup(Z);
	}

	
	/*******************************************************
	 *  Method to perform Insertion Fixup on Red Black tree
	 *  
	 *******************************************************/
	public void insertFixup(RBTNode Z) {
		
		RBTNode Y;
		while (Z!=null_node && Z.parent.color.compareTo("R")==0) {
			if (Z.parent==Z.parent.parent.left) {
				Y = Z.parent.parent.right;
				
				// case 1
				if (Y!=null_node && Y.color.compareTo("R") == 0 ) {
					Z.parent.color = "B";
					Y.color = "B";
					Z.parent.parent.color = "R";
					Z = Z.parent.parent;
				}
				// case 2
				else {
					if (Z==Z.parent.right) {
						Z = Z.parent;
						LeftRotate(Z);
					}
					// case 3
						Z.parent.color = "B";
						Z.parent.parent.color = "R";
						RightRotate(Z.parent.parent);
				}
			}
			
			else {
				Y = Z.parent.parent.left;
				
				// symmetric case 1
				if (Y!=null_node && Y.color.compareTo("R") == 0) {
					Z.parent.color ="B";
					Y.color = "B";
					Z.parent.parent.color = "R";
					Z = Z.parent.parent;
				}
				// symmetric case 2
				else {
					if (Z==Z.parent.left) {
						Z = Z.parent;
						RightRotate(Z);
					}
					// symmetric case 3
					Z.parent.color = "B";
					Z.parent.parent.color = "R" ;
					LeftRotate(Z.parent.parent);
				}
			}
		}
		root_node.color = "B";
	}

	
	
	/*******************************************************
	 *  Method to perform Deletion on Red Black tree
	 *  
	 *******************************************************/
	public void delete(String key)
	{
		if (root_node == null)
			return;
		
		RBTNode Z = search(root_node, key);
		RBTNode X = null;
		RBTNode Y = Z;
		String YPcolor = Y.color;
		 
		if(Z!= null_node)
		{
			if (Z.left == null_node)
			{
				X = Z.right;
				Transplant(Z, Z.right);
			} 
			else if (Z.right == null_node)
			{
				X = Z.left;
				Transplant(Z, Z.left);
			} 
			else 
			{
				// Set y to z's successor
				Y = TreeMinimum(Z.right);
				YPcolor = Y.color;
				X = Y.right;
				if (Y.parent == Z)
				{
					X.parent = Y;
				} 
				else
				{
					Transplant(Y, Y.right);
					Y.right = Z.right;
					Y.right.parent = Y;
				}
				Transplant(Z, Y);
				Y.left = Z.left;
				Y.left.parent = Y;
				Y.color = Z.color;
			}
			if (YPcolor.compareTo("B") == 0)
			{
				// Call to deleteFixup to maintain red black tree properties
				deleteFixup(X);
			}
			count--;
		} 
		else 
			return;
				
	}        

	
	/*******************************************************
	 *  Method to perform Deletion Fixup on Red Black tree
	 *  
	 *******************************************************/
	public void deleteFixup(RBTNode X) {
		 
		RBTNode W = new RBTNode();
		while ((X != root_node) && (X.color.compareTo("B")==0)) 
		{
			if (X == X.parent.left) 
			{	// Node w is sibling of x
				W = X.parent.right;
				if (W.color.compareTo("R")==0) 
				{
					// case 1
					W.color = "B";
					X.parent.color = "R" ;
					LeftRotate(X.parent);
					W = X.parent.right;
				}
				if ((W.left.color.compareTo("B") == 0) && (W.right.color.compareTo("B") == 0)) 
				{
					// case 2
					W.color = "R";
					X = X.parent;
				}
				else 
				{
					if (W.right.color.compareTo("B") == 0) 
					{
						// case 3
						W.left.color = "B";
						W.color = "R";
						RightRotate(W);
						W = X.parent.right;
					}
					// case 4
					W.color = X.parent.color;
					X.parent.color = "B";
					W.right.color = "B";
					LeftRotate(X.parent);
					X = root_node;
				}
			}
			else 
			{
				W = X.parent.left;
				if (W.color.compareTo("R") == 0) 
				{
					// symmetric case 1
					W.color = "B";
					X.parent.color = "R";
					RightRotate(X.parent);
					W = X.parent.left;
				}
				if ((W.right.color.compareTo("B") == 0) && (W.left.color.compareTo("B") == 0))
				{
					// symmetric case 2
					W.color = "R";
					X = X.parent;
				}
				else
				 {
					if (W.left.color.compareTo("B") == 0) 
					{
						// symmetric case 3
						W.right.color = "B";
						W.color = "R";
						LeftRotate(W);
						W = X.parent.left;
					}
					// symmetric case 4
					W.color = X.parent.color;
					X.parent.color = "B" ;
					W.left.color = "B";
					RightRotate(X.parent);
					X = root_node;
				}
			}
		}
			
		X.color = "B";
		
	}
	
	
	/*******************************************************
	 *  Method to perform Left Rotation on Red Black tree
	 *  
	 *******************************************************/
	public void LeftRotate(RBTNode X) {
		
		// Set y to right child of x
		RBTNode Y = X.right;                        
		// Turn y's left subtree into x's right subtree
		X.right = Y.left;
		if (Y.left != null_node)
		{
			Y.left.parent = X;
		}
		
		// Link x's parent to y
		Y.parent = X.parent;         
		if (X.parent == null_node) 
		{
			root_node = Y;
		}
		else if (X == X.parent.left)
		{
			X.parent.left = Y;
		}
		else 
		{
			X.parent.right = Y;
		}
		
		// Put x on y's left
		Y.left = X;                             
		X.parent = Y;

	}

	
	/*******************************************************
	 *  Method to perform Right Rotation on Red Black tree
	 *  
	 *******************************************************/
	public void RightRotate(RBTNode Y) {

		// Set x to left child of x
		RBTNode X = Y.left;
		// Turn x's right subtree into y's left subtree
		Y.left = X.right;
		if (X.right != null_node) {
			X.right.parent = Y;
		}
		// Link y's parent to x
		X.parent = Y.parent;
		if (Y.parent == null_node) {
			root_node = X;
		} else if (Y == Y.parent.left) {
			Y.parent.left = X;
		} else {
			Y.parent.right = X;
		}
		// Put y on x's right
		X.right = Y;
		Y.parent = X;

	}

	
	/*********************************************************
	 *  Method to perform Transplant in RB Tree
	 *  Transplant is called in Delete method
	 *  
	 ********************************************************/
	public void Transplant(RBTNode u, RBTNode v)
 {
		if (u.parent == null_node) {
			root_node = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		v.parent = u.parent;
	}

	
	/*******************************************************
	 *  Method that returns pointer to the minimum element
	 *  in the subtree rooted at a given node x 
	 *  
	 *******************************************************/
	public RBTNode TreeMinimum(RBTNode X)
	{
		while (X.left != null_node) 
		{
			X = X.left;
		}
		return X;
	}
        
    private RBTNode search(RBTNode X,String key)
	{
		if (X == null_node || key.compareTo(X.key) == 0)
			return X;
		if (key.compareTo(X.key) < 0)
			return search(X.left, key);
		else
			return search(X.right, key);
			
	}
	
	public void inorder()
	{
		inorder(root_node);
    }
    private void inorder(RBTNode X)
    {
		if(X!= null_node)
		{
			inorder(X.left);
			System.out.print(X.key + " "+ X.color +"\n");
			
			inorder(X.right);
		}
	}
	
	public int height() 
	{
		 return height(root_node);
	}

	private int height(RBTNode X)
	{if (X == null_node)
		return 0;
	return 1 + Math.max(height(X.left), height(X.right));
	}

}
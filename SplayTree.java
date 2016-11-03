
public class SplayTree {
		
		public SPTNode root;
		int count=0;
	    		
	   //***************splay insertion *****************/
	    public void insert(String Key) {
	        // splay key to root
	        if (root == null) {
	            root = new SPTNode(Key);
		    count++;
	            return;
	        }
	        
	        root = splay(root, Key);
	        if (Key.compareTo(root.key) == 0) {  //duplicate key insertion do nothing
	            return;
	        }
	        // Insert new node at root
	        if (Key.compareTo(root.key) < 0) {
	            SPTNode n = new SPTNode(Key);
	            n.left = root.left;
	            n.right = root;
	            root.left = null;
	            root = n;
	        }

	        // Insert new node at root
	        else if (Key.compareTo(root.key) > 0) {
	            SPTNode n = new SPTNode(Key);
	            n.right = root.right;
	            n.left = root;
	            root.right = null;
	            root = n;
	        }
	        count++;

	       

	    }
	    
	   /***************splay deletion*************/
	    public void delete(String key) {
	        if (root == null)
	        	return;   // If tree is empty
	        
	        root = splay(root, key);
	        if (key.compareTo(root.key) != 0)
	        	return;
	        if (key.compareTo(root.key) == 0) 
	        {
	            if (root.left == null) {
	                root = root.right;
	            } 
	            else {
	                SPTNode x = root.right;
	                root = root.left;
	                root = splay(root, key);
	                root.right = x;
	            }
	            count--;
	        }

	        
	         else 
		    return ;
	    }
	    
	    
	   /*********************** splay function *****************/
	    // If a node with key exists,splayed it to the root. 
	    //If not, then last node searched for the key is splayed to the root.
	    
	    private SPTNode splay(SPTNode T, String key) {
	        if (T == null) 
	        	return null;
	        
	        if (key.compareTo(T.key) < 0) {
	            // key not in tree, so we're done
	            if (T.left == null) {
	                return T;
	            }
	            
	            // Single RightRotate
	            if (key.compareTo(T.left.key) < 0) {
	                T.left.left = splay(T.left.left, key);
	                T = RightRotate(T);
	            }
	            else if (key.compareTo(T.left.key)> 0) {      // Single LeftRotate
	                T.left.right = splay(T.left.right, key);
	                if (T.left.right != null)
	                    T.left = LeftRotate(T.left);
	            }
	            
	            if (T.left == null) 
	            	return T;
	            else                
	            	return RightRotate(T);
	        }

	        else if (key.compareTo(T.key) > 0) { 
	            // key not in tree, so we're done
	            if (T.right == null) {
	                return T;
	            }
	            
	            if (key.compareTo(T.right.key) < 0) {
	                T.right.left  = splay(T.right.left, key);
	                if (T.right.left != null)
	                    T.right = RightRotate(T.right);
	            }
	            else if (key.compareTo(T.right.key) > 0) {
	                T.right.right = splay(T.right.right, key);
	                T = LeftRotate(T);
	            }
	            
	            if (T.right == null) 
	            	return T;
	            else           
	            	return LeftRotate(T);
	        }

	        else return T;
	    }


	   /*************************************************************************
	    Height Of tree, Number of Count, Inorder Traversal of tree
	    *************************************************************************/

	    // height of tree 
	    public int height() 
	    { 
	    	return height(root); 
	    }
	    private int height(SPTNode x) 
	    {
	        if (x == null) 
	        	return 0;
	        return 1 + Math.max(height(x.left), height(x.right));
	    }

	    
	    public int Num()
	    {
	    	return count;
	    }
	    public void inorder()
		{
			inorder(root);
	    }
	    private void inorder(SPTNode X)
	    {
			if(X!= null)
			{
				inorder(X.left);
				System.out.print(" "+ X.key + "\n");
				inorder(X.right);
			}
		}
	    
	    // right rotate
	    private SPTNode RightRotate(SPTNode T) {
	        SPTNode x = T.left;
	        T.left = x.right;
	        x.right = T;
	        return x;
	    }

	    // left rotate
	    private SPTNode LeftRotate(SPTNode T) {
	        SPTNode x = T.right;
	        T.right = x.left;
	        x.left = T;
	        return x;
	    }

}

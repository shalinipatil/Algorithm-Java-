
public class RBTNode 
{
	     RBTNode left, right,parent;
	     String key;
	     String color;
             // * Variable 'color' is initialized to 0, where 0 = RED and 1 = BLACK 

	     /* Constructor */
	     public RBTNode(String key)
	     {
	         this(key, null, null );
	     } 
	     /* Constructor */
	     public RBTNode(String key, RBTNode lt, RBTNode rt)
	     {
	         left = lt;
	         right = rt;
	         this.key = key;
	         color = "R";
	     }
	     public RBTNode()
             {
	 		
	 		left = null;
	 		right = null;
	 		parent = null;
	 		
             }
	 	
 }



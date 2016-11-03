import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;



public class BSTAlgo 
{
    private static long startTime = System.currentTimeMillis();

    public static void main(String[] args)
   {                 
     
       /* Creating object of BST */
       try
       {
    	   
          // BSTrees bst = new BSTrees();
          // RedBlackTree rbt = new RedBlackTree();
	   SkipList skl = new SkipList();
           FileReader in = new FileReader("query_insert_delete.txt");
           BufferedReader br1 = new BufferedReader(in);
           String strLine;
           String n,n1;
          
           while((strLine = br1.readLine())!= null)
           {
		
        	   String[] s = strLine.split("\t",2);
        	   n = s[0];
        	   n1 = s[1];
        	   
        	   
        	   if(n.equals("1"))
        	      {
        		   		//bst.insert(n1);
        		   		//System.out.println(bst.height());
        		   		//rbt.insert(n1);
        		   		//System.out.println(rbt.height());
					skl.insert(n1);
        		   			   	           		       
        	      }
        	
        	   else if(n.equals("0"))
        	      {
        		   		//bst.delete(n1);
        		   		//System.out.println(bst.height());
        		   	 //  rbt.delete(n1);
       		   		//System.out.println(rbt.height());
					skl.delete(n1);
        	      }
        	   
        	  } 
          
          // bst.inorder(); 
          // System.out.println("Data Structure Contains "+ bst.Num()+ " elements");
          // System.out.println("Height of BST is :" +bst.height());
          
         //rbt.inorder();
          
           // System.out.println("Data Structure Contains "+ rbt.Num()+ " elements");
        	//System.out.println("Height "+ rbt.height());
	skl.print();
        System.out.println("Data Structure Contains "+ skl.Num()+ " elements");

        
        }
       catch(Exception e){
     	   System.out.println(e);
     	  }
       long endTime = System.currentTimeMillis();
       System.out.println("\nIt took " + (endTime - startTime) + " milliseconds");    	  
}
}

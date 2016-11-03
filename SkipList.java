import java.util.*;

class SkipList 
{  
  private int count = 0;
  public static final int MaxLevel = 16;
  public static final double p = 0.5;

  public SLNode head  = new SLNode(null,MaxLevel);
  public int level = 0;

	/** Insert a record into the skiplist */
	public void insert(String Key)
	{	
		SLNode x = head;
		SLNode[] update = new SLNode[MaxLevel + 1];
		
		for (int i = level; i >= 0; i--) {
			while (x.forward[i] != null && x.forward[i].key.compareTo(Key) < 0) {
				x = x.forward[i];
			}
			update[i] = x;
		}
		x = x.forward[0];

		if (x == null || !x.key.equals(Key)) {
			int lvl = randomLevel();
			if (lvl > level) {
				for (int i = level + 1; i <= lvl; i++) {
					update[i] = head;
				}
				level = lvl;
			}
			x = new SLNode( Key,lvl);
			for (int i = 0; i <= lvl; i++) {
				x.forward[i] = update[i].forward[i];
				update[i].forward[i] = x;
			}
			count++;
		}
		
	}
		
	


/** Skiplist Search */
public SLNode Search(String Key) 
{
	SLNode x = head;
  	for (int i=level; i>=0; i--)
  	{
  		while (x.forward[i] != null && x.forward[i].key.compareTo(Key) < 0) {
	        x = x.forward[i];
	    }
  	}
  	x = x.forward[0]; 
  	if (x.key.equals(Key))
        return x;
    else
        return null;
}

public void delete(String Key)
{
	         
	  // Track end of level
	  SLNode[] update = new SLNode[MaxLevel+1];
	  SLNode x = head;        
	  for (int i=level; i>=0; i--) 
	  {
		  while((x.forward[i] != null) && (x.forward[i].key.compareTo(Key)) < 0)
	      {
			  x = x.forward[i];
	      }
		  update[i] = x;               
	  }
	  x = x.forward[0];

	  if (x.key.equals(Key))
	  {
		  for (int i = 0; i <= level; i++) 
		  {
			  if (update[i].forward[i] != x)
				  break;
			  update[i].forward[i] = x.forward[i];
		  }
	  
		  while (level > 0 && head.forward[level] == null) 
		  {
			  level--;
		  }
		  count--;
	  }
	  
}
public void print() 
{
    SLNode x = head.forward[0];
	 while (x != null)
	 {
	    System.out.println(x.key);
	    x = x.forward[0];
	 }
}

	public int Num() {
		return count;
	}

	// Hold the Random class object

	public static int randomLevel() {
        int lvl = (int)(Math.log(1.-Math.random())/Math.log(1.-p));
        return Math.min(lvl, MaxLevel);
    }

}

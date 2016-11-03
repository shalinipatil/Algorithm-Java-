import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Shalini
 */
public class shpatil {

    /**
     * @param args the command line arguments
     */
   private static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
      
        // TODO code application logic here
        String filename = args[1];
        String datastructure = args[3];
        Boolean height = false;
        Boolean print = false;
        long startTime = 0;
        long endTime = 0;
        long diff = 0;
        long totalTime = 0;

        for (String arg : args) {
            if (arg.equals("-h")) {
                height = true;
            }
            if (arg.equals("-p")) {
                print = true;
            }
        }

        BSTrees bst = new BSTrees();
        RedBlackTree rbt = new RedBlackTree();
        SkipList skl = new SkipList();
	SplayTree spt = new SplayTree();


        try {
            Boolean input = false;
            List<String> lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
            if (height) {
                System.out.println("Height is: ");
            }
            for (String line : lines) {
                for (String part : line.split("\t", 2)) {
                    diff = 0;
                    switch (part) {
                        case "1":
                            input = true;
                            break;
                        case "0":
                            input = false;
                            break;
                        default:
                            if (input) {
                                switch (datastructure) {
                                    case "bst":
                                        startTime = System.currentTimeMillis();
                                        bst.insert(part);
                                        endTime = System.currentTimeMillis();
                                        diff = endTime - startTime;
                                        break;
                                    case "rbtree":
                                        startTime = System.currentTimeMillis();
                                        rbt.insert(part);
                                        endTime = System.currentTimeMillis();
                                        diff = endTime - startTime;
                                        break;
                                    case "splaytree":
					startTime = System.currentTimeMillis();
                                        spt.insert(part);
                                        endTime = System.currentTimeMillis();
                                        diff = endTime - startTime;
                                        break;
                                    case "skiplist":
                                        startTime = System.currentTimeMillis();
                                        skl.insert(part);
                                        endTime = System.currentTimeMillis();
                                        diff = endTime - startTime;
                                        break;
                                }
                                totalTime += diff;
                                diff = 0;
                                if (height) {
                                    switch (datastructure) {
                                        case "bst":
                                            startTime = System.currentTimeMillis();
                                            System.out.println(bst.height());
                                            endTime = System.currentTimeMillis();
                                            diff = endTime - startTime;
                                            break;
                                        case "rbtree":
                                            startTime = System.currentTimeMillis();
                                            System.out.println(rbt.height());
                                            endTime = System.currentTimeMillis();
                                            diff = endTime - startTime;
                                            break;
                                        case "splaytree":
					    startTime = System.currentTimeMillis();
                                            System.out.println(spt.height());
                                            endTime = System.currentTimeMillis();
                                            diff = endTime - startTime;
                                            break;
                                    }
                                }
                                totalTime += diff;
                                diff = 0;
                            } else {
                                switch (datastructure) {
                                    case "bst":
                                        startTime = System.currentTimeMillis();
                                        bst.delete(part);
                                        endTime = System.currentTimeMillis();
                                        diff = endTime - startTime;
                                        break;
                                    case "rbtree":
                                        startTime = System.currentTimeMillis();
                                        rbt.delete(part);
                                        endTime = System.currentTimeMillis();
                                        diff = endTime - startTime;
                                        break;
                                    case "splaytree":
					startTime = System.currentTimeMillis();
                                        spt.delete(part);
                                        endTime = System.currentTimeMillis();
                                        diff = endTime - startTime;
                                        break;
                                    case "skiplist":
                                        startTime = System.currentTimeMillis();
                                        skl.delete(part);
                                        endTime = System.currentTimeMillis();
                                        diff = endTime - startTime;
                                        break;
                                }
                                totalTime += diff;
                                diff = 0;

                                if (height) {
                                    switch (datastructure) 
				    {
                                        case "bst":
                                            startTime = System.currentTimeMillis();
                                            System.out.println(bst.height());
                                            endTime = System.currentTimeMillis();
                                            diff = endTime - startTime;
                                            break;
                                        case "rbtree":
                                            startTime = System.currentTimeMillis();
                                            System.out.println(rbt.height());
                                            endTime = System.currentTimeMillis();
                                            diff = endTime - startTime;
                                            break;
                                        case "splaytree":
					    startTime = System.currentTimeMillis();
                                            System.out.println(spt.height());
                                            endTime = System.currentTimeMillis();
                                            diff = endTime - startTime;
                                            break;
                                    }
                                }
                                totalTime += diff;
                                diff = 0;

                            }
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (print) {
            System.out.println("Elements are:");
            switch (datastructure) {
                case "bst":
                    startTime = System.currentTimeMillis();
                    bst.inorder();
                    endTime = System.currentTimeMillis();
                    diff = endTime - startTime;
                    break;
                case "rbtree":
                    startTime = System.currentTimeMillis();
                    rbt.inorder();
                    endTime = System.currentTimeMillis();
                    diff = endTime - startTime;
                    break;
                case "splaytree":
		    startTime = System.currentTimeMillis();
                    spt.inorder();
                    endTime = System.currentTimeMillis();
                    diff = endTime - startTime;
                    break;
                case "skiplist":
                    startTime = System.currentTimeMillis();
                    skl.print();
                    endTime = System.currentTimeMillis();
                    diff = endTime - startTime;
                    break;
            }
            totalTime += diff;
            diff = 0;
        }
        if (true) {
            System.out.println("Total Time: " + totalTime + " milliseconds");
            
            switch(datastructure){
                case "bst":
                    System.out.println("Data structure contains " + bst.Num() + " Elements");
                    break;
                case "rbtree":
                    System.out.println("Data structure contains " + rbt.Num() + " Elements");
                    break;
                case "splaytree":
                    System.out.println("Data structure contains " + spt.Num() + " Elements");
                    break;
                case "skiplist":
                    System.out.println("Data structure contains " + skl.Num() + " Elements");
                    break;
                    
            }
            
        }
    }
}

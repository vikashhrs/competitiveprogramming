import java.util.*;
class Node{
    int value;
    Node left;
    Node right;
    // Node next only for special problems
    Node next;
    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    public void setLeft(Node node){
        this.left = node;
    }

    public void setRight(Node node){
        this.right = right;
    }
}
public class TreeTraversal{
    public static void main(String args[]){
        // Node root = new Node(1);
        // root.left = new Node(2); 
        // root.right = new Node(3); 
        // root.left.left = new Node(4); 
        // root.left.right = new Node(5);

        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(7);
        // root.left.right = new Node(6);
        // root.right.left = new Node(5);
        // root.right.right = new Node(4);

        Node root = new Node(20);  
        root.left = new Node(10);  
        root.left.left = new Node(4);  
        root.left.right = new Node(18);  
        root.right = new Node(26);  
        root.right.left = new Node(24);  
        root.right.right = new Node(27);  
        root.left.right.left = new Node(14);  
        root.left.right.left.left = new Node(13);  
        root.left.right.left.right = new Node(15);  
        root.left.right.right = new Node(19);  

        // System.out.println("\n inorderTraversalRecursive \n");
        // inorderTraversalRecursive(root);
        // System.out.println("\n inorderStack \n");
        // inorderStack(root);

        // System.out.println("\n inorderTraversalRecursive \n");
        // preorderTraversal(root);
        // System.out.println("\n inorderStack \n");
        // preorderStack(root);

        // System.out.println("\n postorderTraversal \n");
        // postorderTraversal(root);
        // System.out.println("\n postorderStack \n");
        // postorderStack(root);

        // TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(verticalSum(root, new HashMap<Integer, Integer>(), 0));

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     System.out.println("Key = " + entry.getKey() +  ", Value = " + entry.getValue()); 
        // }

        levelOrder(root);
        System.out.println();
        // reverseLevelOrder(root);
        // System.out.println();
        // zigzagTraversal(root);
        // System.out.println();
        // levelAverages(root);
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Eneter key :");
        // int successorOf = sc.nextInt();
        // Node successor = levelOrderSuccessor(root, successorOf);
        // if(successor != null)
        //     System.out.println("Successor = "+successor.value);
        // else
        //     System.out.println("No successor!");
        connectNodesAtSameLevel(root);
    }

    public static void inorderTraversalRecursive(Node root){
        if(root != null){
            inorderTraversalRecursive(root.left);
            System.out.print("\t"+root.value);
            inorderTraversalRecursive(root.right);
        }
    }

    public static void inorderStack(Node root){
        Stack<Node> st = new Stack<Node>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            Node current = st.pop();
            System.out.print("\t"+current.value);
            root = current.right;
        }
    }

    public static void preorderTraversal(Node root){
        if(root != null){
            System.out.print("\t"+root.value);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public static void preorderStack(Node root){
        Stack<Node> st = new Stack<Node>(); 
        while(root != null || !st.isEmpty()){
            while(root != null){
                System.out.print("\t"+root.value);
                st.push(root);
                root = root.left;
            }
            Node current = st.pop();
            root = current.right;
        }
    }

    public static void postorderTraversal(Node root){
        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print("\t"+root.value);
        }
    }

    public static void postorderStack(Node root){
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();
        st1.push(root);
        while(!st1.isEmpty()){
            Node current = st1.pop();
            st2.push(current);
            if(current.left != null)
                st1.push(current.left);
            if(current.right != null)
                st1.push(current.right);
        }

        while(!st2.isEmpty()){
            Node temp = st2.pop();
            System.out.print("\t"+temp.value);
        }
    }

    public static void postorderSingleStack(Node root){

    }

    public static HashMap<Integer, Integer> verticalSum(Node root, HashMap<Integer, Integer> map, int d){
        if(root == null){
            return map;
        }
        if(map.get(d) == null)
            map.put(d, root.value);
        else
            map.put(d, map.get(d) + root.value);

        verticalSum(root.left, map, d-1);
        verticalSum(root.right, map, d+1);
        return map;
    }

    public static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            System.out.print("\t"+current.value);
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
    }

    public static void reverseLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            stack.push(current);
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }

        while(!stack.isEmpty()){
            Node current = stack.pop();
            System.out.print("\t"+current.value);
        }
    }

    public static void zigzagTraversal(Node root){
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();

        st1.push(root);

        while(!st1.isEmpty() || !st2.isEmpty()){
            while(!st1.isEmpty()){
                Node current = st1.pop();
                System.out.print("\t"+current.value);
                if(current.left != null)
                    st2.push(current.left);
                if(current.right != null)
                    st2.push(current.right);
            }
            
            while(!st2.isEmpty()){
                Node current = st2.pop();
                System.out.print("\t"+current.value);
                if(current.right != null)
                    st1.push(current.right);
                if(current.left != null)
                    st1.push(current.left);
            }
        }
    }

    public static void levelAverages(Node root){
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();

        st1.push(root);

        while(!st1.isEmpty() || !st2.isEmpty()){
            int sum1 = 0, len1 = 0,sum2 = 0, len2 = 0;
            len1 = st1.size();
            while(!st1.isEmpty()){
                Node current = st1.pop();
                sum1 = sum1 + current.value;
                if(current.left != null)
                    st2.push(current.left);
                if(current.right != null)
                    st2.push(current.right);
            }
            if(len1 != 0)
                System.out.print("\t"+sum1/len1);
            sum1 = 0;
            len2 = st2.size();
            while(!st2.isEmpty()){
                Node current = st2.pop();
                sum2 = sum2 + current.value;
                if(current.right != null)
                    st1.push(current.right);
                if(current.left != null)
                    st1.push(current.left);
            }
            if(len2 != 0)
                System.out.print("\t"+sum2/len2);
            sum2 = 0;
        }
    }

    public static Node levelOrderSuccessor(Node root, int successorOf){
        if(root != null && root.value == successorOf)
            return root.left != null ? root.left : root.right != null ? root.right : null;
        else if(root == null)
            return null;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.remove();

            if(root.left != null)
                queue.add(root.left);

            if(root.right != null)
                queue.add(root.right);

            if(root.value == successorOf)
                break;
        }
        return queue.peek();
    }

    public static void connectNodesAtSameLevel(Node root){
        if(root != null)
            root.next = null;

        connectNodes(root);
    }

    public static void connectNode(Node root){
        if(root == null)
            return;

        if(root.left != null)
            root.left.next = root.right;
        
        if(root.right != null)
            root.right.next = root.next != null ? root.next.left : null;

        connectNode(root.left);
        connectNode(root.right);
    }

    public static Node nextNodeOfNode(Node root, int nextOf){
        if(root == null || root.value == nextOf)
            return root == null ? null : root.next;

        nextNodeOfNode(root.left, nextOf);
        nextNodeOfNode(root.right, nextOf);

        return null;
    }
}
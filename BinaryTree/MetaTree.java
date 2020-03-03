class Node{
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class MetaTree{
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.right = new Node(9);

        System.out.println(minDepth(root));
    }

    public static int minDepth(Node root){
        if(root == null)
            return 0;
        
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;

        return left > right ? right : left;
    }
}
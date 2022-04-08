class BinarySearchTree {
    
    class Node {
        String key;
        String[] value;
        Node left, right;

        public Node(String item, String[] arr) {
            key = item;
            value = arr;
            left = right = null;
        }

    }
    

    private Node root;

    BinarySearchTree() {
        root = null;
    }

}
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
    
    String[] arr = null; 
    private Node root;

    BinarySearchTree() {
        root = null;
    }

    
    /** 
     * @param key
     * @param value
     * Inserta un nodo al arbol
     */
    public void insert(String key, String[] value) {
        root = insertRec(root, key, value);
    }


    
    /** 
     * @param root
     * @param key
     * @param value
     * @return Node
     * Funcion recursiva para insertar la llave al BST
     */
    public Node insertRec(Node root, String key, String[] value) {

        if (root == null) {
            root = new Node(key, value);
            return root;
        }

        if (key.compareToIgnoreCase(root.key) < 0) 
        {
            root.left = insertRec(root.left, key, value);
        } else if (key.compareToIgnoreCase(root.key) >= 0)  
        {
            root.right = insertRec(root.right, key, value);
        }

        return root;
    }

    
    /** 
     * @param root
     * Para verificar el arbol en orden
     */
    private void inOrderRec(Node root) {
        if (root != null) {

            inOrderRec(root.left);

            try {
                System.out.println("\n >> " + root.key + " <<");
                System.out.println(" Ingles: " + root.value[0]);
                System.out.println(" Español: " + root.value[1]);
                System.out.println(" Frances: " + root.value[2]);
            } catch (Exception e) {
                System.out.println("\n >> " + root.key + " no tiene valor <<");
            }  

            inOrderRec(root.right);

        }
    }


    public void getBST() {
        inOrderRec(root);
    }

    
    /** 
     * @param root
     * @param key
     */
    public void getNodeRec(Node root, String key){
        if (root != null) 
        {
            getNodeRec(root.left, key);

            if (root.key.equals(key)) {
                arr = root.value;
            }
        
            getNodeRec(root.right, key);
        }
        
    }

    
    /** 
     * @param key
     * @return String[]
     */
    public String[] getNode(String key) {
        arr = null;
        getNodeRec(root, key);
        return arr;
    }

}
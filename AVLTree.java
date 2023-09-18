package PES1PG22CS039;

public class AVLTree {

    // creating node
    class Node {
        int key, height;
        Node left, right;

        Node(int k) {
            key = k;
            height = 1;
        }
    }

    Node root;

    // to get height of the tree
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // to get maximum of two integers
    int maximum(int i, int j) {
        return (i > j) ? i : j;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // right rotate subtree rooted with y
    // See the diagram given above.
    Node rightR(Node y) {
        Node x = y.left;
        Node z = x.right;

        // Perform rotation
        x.right = y;
        y.left = z;

        // Update heights
        y.height = maximum(height(y.left), height(y.right)) + 1;
        x.height = maximum(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftR(Node x) {
        Node y = x.right;
        Node z = y.left;

        // Perform rotation
        y.left = x;
        x.right = z;

        // Update heights
        x.height = maximum(height(x.left), height(x.right)) + 1;
        y.height = maximum(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public void makeEmpty() {
        root = null;
    }

    public void insert(int element) {
        root = insert(element, root);
    }

    Node insert(int key, Node node) {
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(key, node.left);
        else if (key > node.key)
            node.right = insert(key, node.right);
        else // Equal keys not allowed
            return node;
        System.out.println("Inserted successfully " + node.key);

        /* 2. Update height of parent node */
        node.height = 1 + maximum(height(node.left),
                height(node.right));

        /*
         * 3. Get the balance factor of this parent node to check whether this node is
         * unbalanced
         */

        int balance = getBalance(node);

        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightR(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftR(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftR(node.left);
            return rightR(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightR(node.right);
            return leftR(node);
        }

        /* return the (unchanged) node pointer */
        return node;

    }

    Node minValueNode(Node node) {
        Node currentNode = node;

        /* loop down to find the leftmost leaf */
        while (currentNode.left != null)
            currentNode = currentNode.left;

        return currentNode;
    }

    Node deleteNode(Node root, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then goto left subtree
        if (key < root.key)
            root.left = deleteNode(root.left, key);

        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (key > root.key)
            root.right = deleteNode(root.right, key);

        // if key is same as root's key, then this is the node
        // to be deleted
        else {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of
                                 // the non-empty child
            } else {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENTNode NODE
        root.height = maximum(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightR(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftR(root.left);
            return rightR(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftR(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightR(root.right);
            return leftR(root);
        }

        return root;

    }

    public boolean search(int skey) {
        return search(root, skey);
    }

    private boolean search(Node node, int skey) {
        boolean KeyFound = false;
        while ((node != null) && !KeyFound) {
            int key = node.key;
            if (skey < key)
                node = node.left;
            else if (skey > key)
                node = node.right;
            else {
                KeyFound = true;
                break;
            }
            KeyFound = search(node, skey);
        }
        return KeyFound;
    }

    // display function
    public void inorder() {
        inorder(root);
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }

}

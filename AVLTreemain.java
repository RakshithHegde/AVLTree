package PES1PG22CS039;

import java.util.Scanner;

public class AVLTreemain {
    public static void main(String[] args) {
        AVLTree AVL = new AVLTree();

        Scanner scan = new Scanner(System.in);
        int choice;
        AVL.insert(21);
        AVL.insert(10);
        AVL.insert(5);
        AVL.insert(2);
        AVL.insert(31);
        AVL.insert(25);
        AVL.insert(48);
        AVL.insert(51);
        AVL.insert(70);
        do {
            System.out.println("\n1. Insert key ");
            System.out.println("2. Search key");
            System.out.println("3. Delete key");
            System.out.println("4. Check empty");
            System.out.println("5. Destroy tree");
            System.out.println("6. Display Avl Tree in Postorder");
            System.out.println("7. Display Avl Tree in Preorder");
            System.out.println("8. Display Avl Tree in Inorder");
            System.out.println("9. exit");

            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    int x = scan.nextInt();
                    AVL.insert(x);

                    break;

                case 2:
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : " + AVL.search(scan.nextInt()));
                    break;
                case 3:
                    System.out.println("delete");
                    AVL.deleteNode(AVL.root, scan.nextInt());
                    System.out.println("Deleted successfully");
                    break;
                case 4:
                    System.out.println("Empty status = " + AVL.isEmpty());
                    break;
                case 5:
                    System.out.println("\nTree Cleared");
                    AVL.makeEmpty();
                    break;
                case 6:
                    System.out.println("PostOrder: ");
                    AVL.postorder();
                    break;
                case 7:
                    System.out.println("PreOrder: ");
                    AVL.preorder();
                    break;
                case 8:
                    System.out.println("InOrder: ");
                    AVL.inorder();
                    break;
                case 9:
                    System.out.println("Ok bye");
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

        } while (choice != 9);
        scan.close();
    }

}

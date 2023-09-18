import java.util.Scanner;

class PES1PG22CS039 {

    static class Node {
        int key;
        Node pointer_array[];

        Node(int key, int level) {
            this.key = key;
            pointer_array = new Node[level + 1]; // new levels
        }
    };

    static class randSkipList {

        int MAXLEVEL; // Maximum level (-infinity to + infinity)

        float P; // P points to the nodes with level

        int level;

        Node header; // pointer to header node

        randSkipList(int MAXLEVEL, float P) {
            this.MAXLEVEL = MAXLEVEL;
            this.P = P;
            level = 0;

            // create header node and initialize key to -1
            header = new Node(-1, MAXLEVEL);
        }

        // coin flipping method i.e. random level generator
        int randlvl() {
            float rand = (float) Math.random();
            int lvl = 0;
            while (rand < P && lvl < MAXLEVEL) {
                lvl++;
                rand = (float) Math.random();
            }
            return lvl;
        }

        Node createNode(int key, int level) {
            Node n = new Node(key, level);
            return n;
        }

        // Insertion operation
        void insertEle(int key) {
            Node curr = header;
            // create reform array and initialize it
            Node reform[] = new Node[MAXLEVEL + 1];
            // traversing through the levels for inserting key
            for (int i = level; i >= 0; i--) {
                while (curr.pointer_array[i] != null && curr.pointer_array[i].key < key)
                    curr = curr.pointer_array[i];
                reform[i] = curr;
            }

            // level 0
            curr = curr.pointer_array[0];

            if (curr == null || curr.key != key) {
                // Generate a random level for node
                int randlevel = randlvl();

                if (randlevel > level) {
                    for (int i = level + 1; i < randlevel + 1; i++)
                        reform[i] = header;

                    // reform the list curr level
                    level = randlevel;
                }

                // creating a new node with random level
                Node n = createNode(key, randlevel);

                // insertion of node by rearranging pointers
                for (int i = 0; i <= randlevel; i++) {
                    n.pointer_array[i] = reform[i].pointer_array[i];
                    reform[i].pointer_array[i] = n;
                }
                System.out.println(
                        "Successfully Inserted value " + key);
            }
        }

        void SearchKey(int key) {

            Node curr = header;

            for (int i = level; i >= 0; i--) {
                while (curr.pointer_array[i] != null && curr.pointer_array[i].key < key) {
                    curr = curr.pointer_array[i];
                }
            }

            curr = curr.pointer_array[0];
            // if key is present then it is curr
            if (curr != null && curr.key == key) {
                System.out.println(key + "  found in the skiplist");

            } else {
                System.out.println(key + " doesn't exist in this skiplist");
            }

        }

        void Display() {
            for (int i = 0; i <= level; i++) {
                Node node = header.pointer_array[i];
                System.out.print("Level " + i + ": ");
                while (node != null) {
                    System.out.print(node.key + " ");
                    node = node.pointer_array[i];
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        // creating SkipList object with MAXLEVEL and Probability p
        randSkipList lst = new randSkipList(5, 0.5f);
        Scanner sc = new Scanner(System.in);
        int choice;
        // inserting 20 elements into skiplist
        lst.insertEle(1);
        lst.insertEle(3);
        lst.insertEle(7);
        lst.insertEle(8);
        lst.insertEle(11);
        lst.insertEle(14);
        lst.insertEle(17);
        lst.insertEle(18);
        lst.insertEle(20);
        lst.insertEle(23);
        lst.insertEle(25);
        lst.insertEle(34);
        lst.insertEle(37);
        lst.insertEle(42);
        lst.insertEle(49);
        lst.insertEle(55);
        lst.insertEle(60);
        lst.insertEle(66);
        lst.insertEle(69);
        lst.insertEle(74);
        lst.insertEle(80);
        lst.insertEle(100);
        do {
            System.out.println("==== Menu ====");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:

                    Scanner s = new Scanner(System.in);
                    System.out.println("Enter the element to be inserted: ");
                    int key = s.nextInt();
                    lst.insertEle(key);
                    break;
                case 2:
                    Scanner u = new Scanner(System.in);
                    System.out.println("Enter the element to be searched: ");
                    int ele = u.nextInt();
                    lst.SearchKey(ele);
                    break;
                case 3:
                    lst.Display();
                    break;
                case 4:
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            System.out.println();
        } while (choice != 4);
    }
}

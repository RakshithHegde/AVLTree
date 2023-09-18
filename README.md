# AVLTree
Fully Functional AVL tree 
An AVL tree is a self-balancing binary search tree in which the heights of the left and right 
subtrees of any node differ by at most one. It is named after its inventors, Adelson-Velsky and 
Landis. In an AVL tree, each node stores a key and a value, and the keys in the left subtree are 
less than the key in the root node, while the keys in the right subtree are greater than the key in 
the root node. This allows for efficient searching and insertion of elements in the tree. To 
maintain the balance of the tree, AVL trees use a technique called rotation, which involves 
reorganizing the tree by rotating nodes to maintain the height balance. When a node is inserted 
or deleted from the tree, the AVL tree algorithm checks the balance factor of each node, which 
is the difference in height between its left and right subtrees. If the balance factor is greater 
than one or less than negative one, the tree is rebalanced by performing one or more rotations.
Balance Factor BF = height of the left subtree – height of the right subtree
Operations in AVL Tree(Implementation)
i) Create:
We initialise the avl tree in this operation by declaring the root node to null and height as zero.
We also initialise key and left and right node.
Time complexity for create operation is O(1) (constant) as we only initialise the root node to 
null.
ii) Insertion of keys
We insert the first element entered by the user as root itself into the AVL tree. If the user 
enters another key into the tree we check whether it is greater than or less than root key and 
insert the key to the respective right/left node accordingly. After every insertion operation we 
check the balance factor of the tree.
Since In AVL tree the acceptable height is {-1,0,1} If the height increases we perform suitable 
rotation operation to balance the tree. There are Four types of imbalance in AVL tree:
1) Left-Left imbalance
A right rotation is used to balance a node with a left-heavy subtree.
2) Right-Right imbalance
A left rotation is used to balance a node with a right-heavy subtree.
3)Right - Left imbalance
A double rotation consisting of a right rotation followed by a left rotation is performed
4)Left - Right imbalance
A double rotation consisting of a left rotation followed by a right rotation is performed.
After Balancing the tree we would have successfully inserted the node to the tree.
Time complexity for this operation is O(logn) since balancing after each insertion operation 
takes time.
iii) Search Operation
We initialise a Boolean value found to false. Then we start traversing the tree from root. If the
root.key value is equal to the search.key value we print found=true else if it is less than root 
we move to left subtree. If it is greater than the root we move to right subtree. When the key is 
not found in either ways we return false value.
Time complexity for search operation is O(log n) since we have to traverse the entire tree.
iv) Delete Operation
In delete operation we delete the given key by setting it to null. If the given key is not present
Then we return fail. After every deletion appropriate balancing is done if required.
There are three ways to delete a node in AVL tree.
1) Node with no child
We simply set the node value to null in such case since it doesn’t have any child
2)Node with 1 child
We swap the parent node value with the child node value and then delete the child node by 
setting it to null.
3)Node with 2 child
We take the inorder successor in this case and swap the 2 nodes and then delete the given 
node. 
Time complexity is O(log n) for delete operation.
v) Destroy Operation
We complete this operation by setting the root node to null. Since java language has garbage 
collector There is no need for separate function to delete each nodes present in the tree.
Time complexity is O(1)
vi) Display Operation
There are three ways to display AVL tree
1) Inorder (LVR)
2) Preorder (VLR)
3) Postorder(LRV)





# Skiplist
>As we all know that skip list is a recent data structure that can be used for inserting, searching 
and deleting key values efficiently in a sorted list. Skiplist is a probabilistic data structure.
->We first define the node structure of skiplist. We use an array to store the pointers to point 
to the nodes of different level. Each node carries a key and a pointer_array i.e. the pointer to 
nodes of different level. We define Maxlevel as the limit on number of levels.
->We define how the insertion operation takes place in a skiplist. Firstly the elements are 
inserted into skiplist on the basis of coin flipping method(random method). We basically flip a 
coin to enter the element at each levels. For example if the outcome is head in a coin toss we 
insert the element in next level, if the outcome is tail in a coin toss, then we don't add the 
element to the next level, instead we move on to the next element present in the skiplist. The 
levels which will be equal or less than maxlevel defined doesn't depend on the number of 
elements in the node. This means that the random level algorithm will never generate a level 
greater than defined max level.
->We start inserting elements to the skiplist from the highest level present. The ideology behind 
this is if the element's value to be inserted is greater/larger than the next element present at 
current state we increment the position until condition becomes false.
->If there is no next element with key greater than the one we need to insert, we update the 
pointer and move down one level and again start comparing. This will be true until the level is 
zero where all the elements are present.
->At the level 0 if the pointer points to null then we conclude that there is no element present 
with the key value given and we insert the new element at the respective location (sorted 
manner) and call random function to generate new levels for the new element. This is the 
implementation for insertion operation.
->Time complexity for insertion of elements into skiplist is O(logn).
->Next we implement the search operation in skiplist. Searching is almost similar to insertion
operation in skiplist. We start from the highest level that is present in the given skiplist and 
move downwards. If the key of the next node is less than the given key we move further right
On the same level. If it is greater we update the pointer and we move down one level until the 
condition is satisfied i.e. the key is found.
->If at the 0th level if the rightmost element isn’t a match for the given search key then we 
return key doesn’t exist. Else we return key exist.
->Time complexity for the search operation is O(logn).
->Next we implement display operation in skiplist. We use for loop to traverse along the levels 
and while loop for printing the keys from each level until last level. This operation prints out
every elements with its respective levels.
->Since the time complexity for traversing through the skiplist is O(logn) it holds good
for display function

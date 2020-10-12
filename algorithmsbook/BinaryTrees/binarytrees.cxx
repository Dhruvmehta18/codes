#include <iostream>
#include <stack>
using namespace std;

struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
    Node(int val)
    {
        this->data = val;
        this->left = NULL;
        this->right = NULL;
    }
};

class BinaryTrees
{
    struct Node *root;
private:
    Node* treeMaximum(Node *root);
    Node* treeSuccessor(Node *root);
    Node* treeMinimum(Node *root);
    Node* searchNodeRecursive(Node *x, int y);
    Node* searchNodeIterative(Node *x, int y);
    void recursiveInorderTraversal(Node *x);
    void inOrderStackTraversal(Node *x);
    void inOrderTwoPointerTraversal(Node *x);
    void insertNode(Node *root, int type);
public:
    BinaryTrees();
    void insert(int x);
    void recursiveInorderTraversal(int type);
    Node* search(int x, int type);
    Node* treeMinimum();
    Node* treeMaximum();
    Node* treeSuccessor();
    Node* getRootNode()
    {
        return root;
    }
};

BinaryTrees::BinaryTrees()
{
    root = NULL;
}

void BinaryTrees::insertNode(Node *root, int x)
{
    Node *ptr = root;
    Node *newNode = new Node(x);
    Node *y = NULL;
    while (ptr != NULL)
    {
        y = ptr;
        if (x < ptr->data)
        {
            ptr = ptr->left;
        }
        else
        {
            ptr = ptr->right;
        }
    }
    if (x < y->data)
    {
        y->left = newNode;
    }
    else
    {
        y->right = newNode;
    }
}

void BinaryTrees::insert(int x)
{
    if (root != NULL)
    {
        insertNode(root, x);
    }
    else
    {
        root = new Node(x);
    }
}

void BinaryTrees::recursiveInorderTraversal(Node *x)
{
    if (x != NULL)
    {
        BinaryTrees::recursiveInorderTraversal(x->left);
        cout << x->data << " ";
        BinaryTrees::recursiveInorderTraversal(x->right);
    }
}

void BinaryTrees::inOrderTwoPointerTraversal(Node *x)
{
    if (x == NULL)
    {
        return;
    }
    Node *curr = x, *pre, *tNode;
    while (curr != NULL)
    {
        if (curr->left == NULL)
        {
            cout << curr->data << " ";
            curr = curr->right;
        }
        else
        {
            pre = curr->left;
            while (pre->right != NULL && pre->right != curr)
            {
                pre = pre->right;
            }
            if (pre->right == NULL)
            {
                pre->right = curr;
                curr = curr->left;
            }
            else
            {
                pre->right = NULL;
                cout << curr->data << " ";
                curr = curr->right;
            }
        }
    }
}

void BinaryTrees::inOrderStackTraversal(Node *root)
{
    stack<Node *> st;
    Node *curr = root;

    while (curr != NULL || !st.empty())
    {
        while (curr != NULL)
        {
            st.push(curr);
            curr = curr->left;
        }
        curr = st.top();
        st.pop();

        cout << curr->data << " ";
        curr = curr->right;
    }
}

void BinaryTrees::recursiveInorderTraversal(int x)
{
    switch (x)
    {
    case 1:
        inOrderStackTraversal(root);
        break;
    case 2:
        inOrderTwoPointerTraversal(root);
        break;
    default:
        recursiveInorderTraversal(root);
        break;
    }
    cout << endl;
}

Node* BinaryTrees::searchNodeRecursive(Node *x, int y)
{
    if (x == NULL || y == x->data)
    {
        return x;
    }
    if (y < x->data)
    {
        return searchNodeRecursive(x->left, y);
    }
    else
    {
        return searchNodeRecursive(x->right, y);
    }
}
Node* BinaryTrees::searchNodeIterative(Node *root, int y)
{
    Node *ptr = root;
    while (ptr != NULL && y!=ptr->data)
    {
        if (y == ptr->data)
        {
            return ptr;
        }
        else if (y < ptr->data)
        {
            ptr = ptr->left;
        }
        else
        {
            ptr = ptr->right;
        }
    }
    return ptr;
}

Node* BinaryTrees::search(int x, int type)
{
    switch (type)
    {
    case 1:
        return searchNodeRecursive(root, x);
    default:
        return searchNodeIterative(root, x);
    }
}

Node* BinaryTrees::treeMinimum(){
    return treeMinimum(root);
}

Node* BinaryTrees::treeMinimum(Node *root){
    while (root!=NULL&&root->left!=NULL)
    {
        root = root->left;
    }
    return root;
}

Node* BinaryTrees::treeMaximum(){
    return treeMaximum(root);
}

Node* BinaryTrees::treeMaximum(Node *root){
    while (root!=NULL&&root->right!=NULL)
    {
        root = root->right;
    }
    return root;
}

Node* BinaryTrees::treeSuccessor(Node *root){
    if (root!=NULL&&root->right!=NULL)
    {
        return treeMinimum(root->right);
    }
}

Node* BinaryTrees::treeSuccessor(){
    return treeSuccessor(root);
}


int main()
{
    int option;
    BinaryTrees *binaryTrees = new BinaryTrees();
    do
    {
        cout << "Enter your option" << endl;
        cin >> option;
        switch (option)
        {
        case 1:
            int inp;
            do
            {
                cout << "Enter the node to insert" << endl;
                cin >> inp;
                if (inp == -1)
                    break;
                binaryTrees->insert(inp);
            } while (inp != -1);
            break;
        case 2:
            cout << "Type 1,2 or nothing to chose between different implementation" << endl;
            int x;
            cin >> x;
            binaryTrees->recursiveInorderTraversal(x);
            break;
        default:
            break;
        }
    } while (option != -1);
    return 0;
}

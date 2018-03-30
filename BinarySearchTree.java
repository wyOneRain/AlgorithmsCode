import java.util.Stack;

public class BST {
    private  class  Node{
        public Node left,right;
        public int data;

        public  Node(int data)
        {
            this.left=null;
            this.right=null;
            this.data=data;
        }
    }

    public Node root;

    //查找指定节点
    public Node find(int key) {
        Node currentNode = root;
        while (currentNode != null && currentNode.data != key) {
            if (key < currentNode.data)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return currentNode;
    }

    //插入节点
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node currentNode = root;
        while (true) {
            if (currentNode.data > key) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(key);
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(key);
                    return;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    //递归先序遍历
    public void preOrder(Node rootNode) {
        Node currentNode = this.root;
        if (rootNode != null) {
            System.out.print(rootNode.data + " ");
            preOrder(rootNode.left);
            preOrder(rootNode.right);
        }
    }

    //非递归先序遍历
    public void preOrder(){
        Stack<Node> s = new Stack<Node>();//保存节点信息-->先序遍历（根左右）类似栈，先进后出
        
        Node currentNode = this.root;//游标节点
        
        while (!s.isEmpty() || currentNode != null)
        {
            while (currentNode != null)//先将父节点的所有左子树推入栈
            {
                s.push(currentNode);
                System.out.print(currentNode.data+" ");//输出节点值
                currentNode=currentNode.left;
            }
            
            //左子树遍历完成后，推出，到下一个右节点
            if(!s.isEmpty()){
                Node t = s.pop();
                currentNode = t.right;
            }

        }
    }

    //中序遍历
    public void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.left);
            System.out.print(rootNode.data + " ");
            inOrder(rootNode.right);
        }
    }

    //后序遍历
    public void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.left);
            postOrder(rootNode.right);
            System.out.print(rootNode.data + " ");
        }
    }
    
    //返回二叉树树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
        
    }
}

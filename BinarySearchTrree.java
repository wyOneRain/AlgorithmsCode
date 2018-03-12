import java.util.Arrays;

public class Practice {

    //二叉树节点类
    public static class  Node{
        public Node left,right;
        public int data;

        public  Node(int data)
        {
            this.left=null;
            this.right=null;
            this.data=data;
        }
    }

    public static class Solutions{
        
        //根据前序和中序重构二叉树
        public Node reConstructBinaryTree(int [] pre,int [] in) {
            if (pre.length==0 || in.length==0)
                return null;
            
            Node root = new Node(pre[0]);
            
            //获得中序根节点位置
            int index = 0;
            for(int i = 0; i<in.length;i++){
                if (in[i] == pre[0]){
                    index = i;
                    break;
                }
            }

            root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,index+1),Arrays.copyOfRange(in,0,index));
            root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,index+1,pre.length),Arrays.copyOfRange(in,index+1,in.length));

            return root;
        }

        //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
        private Node reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

            if(startPre>endPre||startIn>endIn)
                return null;
            Node root=new Node(pre[startPre]);

            for(int i=startIn;i<=endIn;i++)
                if(in[i]==pre[startPre]){
                    root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                    root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                }
            return root;
        }

    }

    //创建二叉搜索树
    public static class BinarySearchTree {
        //定义树的根节点
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

        //先序遍历
        public void preOrder(Node rootNode) {
            if (rootNode != null) {
                System.out.print(rootNode.data + " ");
                preOrder(rootNode.left);
                preOrder(rootNode.right);
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
    }

    public static void main(String[] args) {
//        BinarySearchTree tree = new BinarySearchTree();
//        int[] list = new int[]{7, 5, 2, 4, 6, 8, 1, 9, 11, 3, 12, 10};
//        for (int x : list) {
//            tree.insert(x);
//        }
//        tree.preOrder(tree.root);
//        System.out.println(" ");
//        tree.inOrder(tree.root);
//        System.out.println(" ");
//        tree.postOrder(tree.root);
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        System.out.println(pre.length);


        Node tree = new Solutions().reConstructBinaryTree(pre,in);
        int[] newdata = Arrays.copyOfRange(pre,2,8);
        for(int x:newdata)
            System.out.println(x);


    }
}

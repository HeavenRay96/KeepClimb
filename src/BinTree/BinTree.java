package BinTree;

import java.util.*;

/**

前序遍历：
ABDHIMEJNCFKG

中序遍历：
HDMIBJNEAFKCG

后序遍历：
HMIDNJEBKFGCA

**
*/

public class BinTree {
	
	private static class Node {
		Node leftChild;
		Node rightChild;
		Object data;

		Node(Object newData) {
			leftChild = null;
			rightChild = null;
			data = newData;
		}
	}
	
	public static void main(String[] args) {
		String[] array = { "A", "B","C","D","E","F","G","H","I","J",null,null,"K",null,null,null,null,"M",null,null,"N" };
		//String[] array1 = { "A", "B","C","D","E","F","G","H","I","J","K","M","N" };
		ArrayList<Node> nodeList=new ArrayList<Node>();
		createBinTree(array,nodeList);
		 
        Node root = nodeList.get(0);  
        
        System.out.println("前序遍历：");  
        preOrder(root);  
        System.out.println();  
        System.out.println();
        System.out.println("中序遍历：");
        midOrder(root);  
        System.out.println();  
        System.out.println();
        System.out.println("后序遍历：");  
        lastOrder(root);  
        System.out.println();
        System.out.println();
        System.out.println("层序遍历：");  
        floorOrder(root);
        System.out.println();
        System.out.println();
        System.out.println("中序非递归遍历：");
        midOrder1(root);
        System.out.println();
        System.out.println();
        System.out.println("叶子节点：");
        removeLeaves(root,null);
        System.out.println();
        System.out.println();
        System.out.println("删除叶子节点后的层序遍历：");  
        floorOrder(root);  
		
	}
	
	//用层序遍历的数组 构建一颗二叉树
    public static void createBinTree(Object[] array,ArrayList<Node> nodeList) {  
        //nodeList = new LinkedList<Node>(); 
        
    	 // 将一个数组的值依次转换为Node节点  
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {  
            nodeList.add(new Node(array[nodeIndex]));  
        }  
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {  
            // 左孩子  
            nodeList.get(parentIndex).leftChild = nodeList  
                    .get(parentIndex * 2 + 1);  
            // 右孩子  
            nodeList.get(parentIndex).rightChild = nodeList  
                    .get(parentIndex * 2 + 2);  
        }  
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
        int lastParentIndex = array.length / 2 - 1;  
        // 左孩子  
        nodeList.get(lastParentIndex).leftChild = nodeList  
                .get(lastParentIndex * 2 + 1);  
        // 右孩子,如果数组的长度为奇数才建立右孩子  
        if (array.length % 2 == 1) {  
            nodeList.get(lastParentIndex).rightChild = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        }  
    } 
	
    // 前序遍历
	public static void preOrder(Node node) {
		if (node == null)
			return;
		if(node.data!=null)
		System.out.print(node.data + " ");
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}

	// 中序遍历 
	public static void midOrder(Node node) {
		if (node == null)
			return;
		midOrder(node.leftChild);
		if(node.data!=null)
		System.out.print(node.data + " ");
		midOrder(node.rightChild);
	}
	
    //中序非递归 使用栈
	public static void midOrder1(Node node) {
		Stack<Node> stack=new Stack<BinTree.Node>();
		Node currNode=node;
		while(currNode!=null||!stack.isEmpty()) {
			//节点的左节点全部入栈
			while(currNode!=null) {
				stack.push(currNode);
				currNode=currNode.leftChild;
			}
             //1.左节点出栈
			currNode=stack.pop();
			System.out.print(currNode.data+" ");
			// 2.把出栈节点的右节点入栈 如果while判断为空 则出栈节点的根节点出栈
			currNode=currNode.rightChild;
		}
			
	}
	// 后序遍历
	public static void lastOrder(Node node) {
		if (node == null)
			return;
		lastOrder(node.leftChild);
		lastOrder(node.rightChild);
		if(node.data!=null)
		System.out.print(node.data + " ");
	}
	
	// 层序遍历(广度优先遍历) 使用队列实现
	public static void floorOrder(Node node) {
		 Queue<Node> queue = new ArrayDeque<>();		
		  queue.add(node);		 
		  while(!queue.isEmpty())
		  {   Node nowNode=queue.poll();
		      if(nowNode.data!=null)  
			  System.out.print(nowNode.data+" ");
			  if(nowNode.leftChild!=null) {
				  queue.add(nowNode.leftChild);
			  }
			  if(nowNode.rightChild!=null) {
				  queue.add(nowNode.rightChild);
			  }	  			  
		  }
				
	}
	//二叉树之字形层序遍历
	public static void floorOrderZ(Node node) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.offer(node);
		Boolean forward = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				if (forward) {
					node = queue.pollLast();
					if (node.data != null)
						System.out.print(node.data + " ");
					if (node.leftChild != null) {
						queue.offerFirst(node.leftChild);
					}
					if (node.rightChild != null) {
						queue.offerFirst(node.rightChild);
					}
				} else {
					node = queue.poll();
					if (node.data != null)
						System.out.print(node.data + " ");
					if (node.rightChild != null) {
						queue.offer(node.rightChild);
					}
					if (node.leftChild != null) {
						queue.offer(node.leftChild);
					}
				}


			}
			forward = !forward;
		}

	}
	
	//打印叶子节点并删除 pre代表父节点
	public static void removeLeaves(Node root,Node pre) {	
		 if(root==null)
			 return;
             if (root.leftChild == null && root.rightChild == null )  
             {   
            	 //打印叶子节点
            	 System.out.print(root.data+" "); 
            	 
            	 //删除叶子节点
            	 if(root.equals(pre.leftChild))
            		 pre.leftChild=null;            	 
            	 if(root.equals(pre.rightChild))
            		 pre.rightChild=null;
               }
             removeLeaves(root.leftChild,root);
             removeLeaves(root.rightChild,root);          		             		  
	}
	

/**
 * "A", "B","C","D","E","F","G","H","I","J",null,null,"K",null,null,null,null,"M",null,null,"N"
 * 
 *                                   *A* 
 *                                 /     \
 *                                /       \
 *                               /         \ 
 *                             *B*         *C*
 *                           /    \        /  \
 *                          /      \      /    \     
 *                        *D*      *E*  *F*    *G*
 *                        / \     /       \
 *                     *H*  *I* *J*       *K*
 *                          /     \
 *                        *M*      *N* 
 *                        
 */
}

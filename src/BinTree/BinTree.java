package BinTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
/**
先序遍历：
ABDHIMEJNCFKG

中序遍历：
HDMIBJNEAFKCG

后序遍历：
HMIDNJEBKFGCA

二叉树的深度优先遍历（先序 中序 后序）

二叉树的层序遍历(广度优先遍历）
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
		ArrayList<Node> nodeList=new ArrayList<Node>();
		createBinTree(array,nodeList);
		// nodeList中第0个索引处的值即为根节点  
        Node root = nodeList.get(0);  
        System.out.println("先序遍历：");  
        preOrder(root);  
        System.out.println();  
        System.out.println("中序遍历：");  
        midOrder(root);  
        System.out.println();  
        System.out.println("后序遍历：");  
        lastOrder(root);  
        System.out.println();
        System.out.println("层序遍历：");  
        floorOrder(root);
		
	}
	//传入数组 以层序遍历 构建二叉树
    public static void createBinTree(Object[] array,ArrayList<Node> nodeList) {  
        //nodeList = new LinkedList<Node>(); 
        
        // 将一个数组的值依次转换为Node节点  
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {  
            nodeList.add(new Node(array[nodeIndex]));  
        }  
        
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {  
            // 左孩子  
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);  
            // 右孩子  
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);  
        }  
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
        int lastParentIndex = array.length / 2 - 1;  
        // 左孩子  
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);  
        // 右孩子,如果数组的长度为奇数才建立右孩子  
        if (array.length % 2 == 1) {
        nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);  
        }  
    } 
	
    // 先序遍历 先根 再左 后右
	public static void preOrder(Node node) {
		if (node == null)
			return;
		if(node.data!=null)
		System.out.print(node.data + " ");
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}

	// 中序遍历 先左 再根 后右
	public static void midOrder(Node node) {
		if (node == null)
			return;
		midOrder(node.leftChild);
		if(node.data!=null)
		System.out.print(node.data + " ");
		midOrder(node.rightChild);
	}

	// 后序遍历 先左 再右 后根
	public static void lastOrder(Node node) {
		if (node == null)
			return;
		lastOrder(node.leftChild);
		lastOrder(node.rightChild);
		if(node.data!=null)
		System.out.print(node.data + " ");
	}
	// 层序遍历 队列实现
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
/**
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

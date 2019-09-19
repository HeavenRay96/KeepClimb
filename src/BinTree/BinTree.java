package BinTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
/**
ǰ�������
ABDHIMEJNCFKG

���������
HDMIBJNEAFKCG

���������
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
		ArrayList<Node> nodeList=new ArrayList<Node>();
		createBinTree(array,nodeList);
		// nodeList????0???????????????????  
        Node root = nodeList.get(0);  
        System.out.println("ǰ�����");  
        preOrder(root);  
        System.out.println();  
        System.out.println("�������");
        midOrder(root);  
        System.out.println();  
        System.out.println("�������");  
        lastOrder(root);  
        System.out.println();
        System.out.println("�������");  
        floorOrder(root);
		
	}
	//�ò������������ ����һ�Ŷ�����
    public static void createBinTree(Object[] array,ArrayList<Node> nodeList) {  
        //nodeList = new LinkedList<Node>(); 
        
    	 // ��һ�������ֵ����ת��ΪNode�ڵ�  
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {  
            nodeList.add(new Node(array[nodeIndex]));  
        }  
        // ��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������  
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {  
            // ����  
            nodeList.get(parentIndex).leftChild = nodeList  
                    .get(parentIndex * 2 + 1);  
            // �Һ���  
            nodeList.get(parentIndex).rightChild = nodeList  
                    .get(parentIndex * 2 + 2);  
        }  
        // ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������  
        int lastParentIndex = array.length / 2 - 1;  
        // ����  
        nodeList.get(lastParentIndex).leftChild = nodeList  
                .get(lastParentIndex * 2 + 1);  
        // �Һ���,�������ĳ���Ϊ�����Ž����Һ���  
        if (array.length % 2 == 1) {  
            nodeList.get(lastParentIndex).rightChild = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        }  
    } 
	
    // ǰ�����
	public static void preOrder(Node node) {
		if (node == null)
			return;
		if(node.data!=null)
		System.out.print(node.data + " ");
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}

	// �������
	public static void midOrder(Node node) {
		if (node == null)
			return;
		midOrder(node.leftChild);
		if(node.data!=null)
		System.out.print(node.data + " ");
		midOrder(node.rightChild);
	}

	// �������
	public static void lastOrder(Node node) {
		if (node == null)
			return;
		lastOrder(node.leftChild);
		lastOrder(node.rightChild);
		if(node.data!=null)
		System.out.print(node.data + " ");
	}
	// �������(������ȱ���) ʹ�ö���ʵ��
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

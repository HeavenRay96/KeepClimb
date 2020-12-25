package TopK;

public class MyTok {

	public static void main(String[] args) {
		// 源数据
		int[] data = { 45, 275, 12, 6, 45, 478, 41, 1246, 456, 12, 546, 1237 };
                
		// 获取TopK
		int[] TopK = topK(data, 3);

		for (int i = 0; i < TopK.length; i++) {
			System.out.println(TopK[i]);
		}
	}

	private static int[] topK(int[] data, int k) {
		// 创建数组存储前K个数据
		int[] topk = new int[k];
		for (int i = 0; i < k; i++) {
			topk[i] = data[i];
		}
		// 传入数组 MinsHeap构造方法会调用buildMinheap() 生成最小堆
		MinsHeap minsHeap = new MinsHeap(topk);

		// 从K下标开始遍历，如果大于根节点则替换根节点并重新调整
		for (int i = k; i < data.length; i++) {
			int root = minsHeap.getRoot();
			if (data[i] > root)
				minsHeap.setRootAndAdjust(data[i]);
		}
		return topk;
	}
}

class MinsHeap {
	private int[] data;

	public MinsHeap(int[] data) {
		this.data = data;
		buildMinheap();
	}

	// 替换根节点的值 在重新调整
	public void setRootAndAdjust(int i) {
		data[0] = i;
		adjust(0);

	}

	// 获取右结点的数组下标
	private int getRight(int i) {
		return 2 * i + 1;
	}

	// 获取左结点的数组下标<<位置偏移 相当于倍数放大
	private int getLeft(int i) {
		return 2 * i + 2;
	}

	// 交换元素位置
	private void swap(int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	// 获取对中的最小的元素，根元素
	public int getRoot() {
		return data[0];
	}

	// 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点
	// 数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
	// 最后遍历根节点，所以for循环如下
	public void buildMinheap() {
		for (int i = (data.length / 2) - 1; i >= 0; i--) {
			adjust(i);
		}

	}

	// 调整堆
	private void adjust(int i) {
		int left = getLeft(i);
		int right = getRight(i);

		// 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
		int smallest = i;
		// 存在左结点，且左结点的值小于根结点的值
		if (left < data.length && data[left] < data[i])
			smallest = left;
		// 存在右结点，且右结点的值小于以上比较的较小值
		if (right < data.length && data[right] < data[smallest])
			smallest = right;

		// 左右结点的值都大于根节点，直接return，不做任何操作
		if (i == smallest)
			return;

		// 如果最小值不是当前节点
		// 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
		swap(i, smallest);

		// 递归调整
		adjust(smallest);
	}
}
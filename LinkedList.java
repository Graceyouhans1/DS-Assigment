public class LinkedList<T> implements List<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public LinkedList() {
        first = new Node<>();
        last = new Node<>();
        first.setNextNode(last);
        last.setPreNode(first);
    }

    public boolean isEmpty() {
        return first.getNextNode() == last && last.getPreNode() == first;
    }

    public int lenth() {
        return size;
    }

    public T get(int index) {
        if (index < 1 || index > size) {
            System.out.println("Its not normal index range");
            return null;
        }
        return getNode(index).getItem();
    }

    private Node<T> getNode(int index) {
        if (index < 1 || index > size) {
            System.out.println("Its not normal index range");
            return null;
        }
        Node<T> node = first;
        while (index > 0) {
            index--;
            node = node.getNextNode();
        }
        return node;
    }

    public int indexOf(T elem) {
        if (null == elem) {
            return -1;
        }
        int i = 0;
        Node<T> node = first;
        while (node.getNextNode() != null) {
            node = node.getNextNode();
            i++;
            if (node.getItem() == elem) {
                return i;
            }
        }
        return -1;
    }

    public void insert(int index, T elem) {
        if (index < 1 || index > size) {
            System.out.println("Index range is abnormal");
            return;
        }
        Node<T> newNode = new Node<>(elem);
        // Get the previous node at the specified position
        Node<T> preNode = getNode(index).getPreNode();
        preNode.getNextNode().setPreNode(newNode);
        newNode.setNextNode(preNode.getNextNode());
        preNode.setNextNode(newNode);
        newNode.setPreNode(preNode);
        size++;
    }

    /**
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 1 || index > size) {
            System.out.println("Index range is abnormal");
            return null;
        }
        Node<T> n = getNode(index);
        // Get the previous element of the deleted element
        Node<T> preNode = n.getPreNode();
        preNode.setNextNode(n.getNextNode());
        n.getNextNode().setPreNode(preNode);
        n.setPreNode(null);
        n.setNextNode(null);
        size--;
        return n.getItem();
    }

    public void add(T elem) {
        Node<T> newNode = new Node<>(elem);
        // Get the previous node at the specified position
        Node<T> preNode = last.getPreNode();
        preNode.getNextNode().setPreNode(newNode);
        newNode.setNextNode(preNode.getNextNode());
        preNode.setNextNode(newNode);
        newNode.setPreNode(preNode);
        size++;
    }

    /**
     *
     * @return
     */
    public T pop() {

        return remove(size);
    }

    /**
     *
     */
    public void removeAll() {
        while (size > 0) {
            pop();
        }
    }

}

/**
 * 
* @ClassName: Node 
 * @Description: doubly linked list node
* @author xiaomu 
 * @date January 15, 2018 11:44:12 AM 
* 
* @param <T>
 */
class Node<T> {
    protected Node<T> nextNode;
    protected T item;
    protected Node<T> preNode;

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getPreNode() {
        return preNode;
    }

    public void setPreNode(Node<T> preNode) {
        this.preNode = preNode;
    }

    public Node(T item) {
        this.nextNode = null;
        this.item = item;
        this.preNode = null;
    }

    public Node() {
        this(null);
    }
    }
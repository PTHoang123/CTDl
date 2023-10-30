package lab6;

public class Node<E> {
    private E data;
    private Node<E> next;
    public Node(E data) { 
        this.data = data;
    }
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next; 
    }
   
    public static class SinglyLinkedList<E> {
        private Node<E> head = null;
        private Node<E> tail = null;
       
        private int size;
        public SinglyLinkedList() {
            super();
            
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public E first(){
            if(isEmpty()) return null;
            return head.data;
        }
        public E last(){
            if(isEmpty()) return null;
            return tail.data;
        }
        // Adds a new element to the front of the list.
        public void addFirst(E data){
            Node<E> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            } else{
                size++;
                Node<E> temp = head;
                newNode.next = head;
                head = newNode;
                temp.next = head;
            }

        }
        public void addLast(E e){
            Node<E> newNode = new Node<>(e);
            if(head == null){
                head = newNode;
                tail = newNode;
            } 
            else{
                size++;
                tail.next= newNode;
                tail = newNode;
            }
        }
        public void removeFirst(){
            if(head == null){
                return;
            }
            if(head == tail){
                head = null;
                tail = null;
            }
            else{
                size--;
                Node<E> temp = head;
                head = head.next;
                temp.next = null;
            }
        }
        public void removeLast(){
            if(head == null || head.next == null){
                return;
            }
            if(head == tail){
                head = null;
                tail = null;
            }
            else{
                size--;
                Node<E> temp = head;
                while(temp.next != tail){
                   temp = temp.next;
                }
                tail = temp;
                tail.next = null;
                
            }
            
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.addLast(5);
        list.removeFirst();
        list.removeLast();
        System.out.println(list.size());
        System.out.println(list.first());
        System.out.println(list.last());
    }
}


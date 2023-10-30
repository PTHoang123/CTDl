package lab6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;
	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
		public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}
		public void growSize() {
			if(size >= elements.length) {
				elements = Arrays.copyOf(this.elements, this.size * 2);
			}
		}
		// Returns the number of elements in this list.
		public int size() {
				return size;
		}
		// Returns whether the list is empty.
		public boolean isEmpty() {
			return size == 0;
		}
		public E get(int i) throws IndexOutOfBoundsException {
			if(i < 0 || i >= size) {
				throw new ArrayIndexOutOfBoundsException("index out of bound");
			}else
				return elements[i];
		}
		public E set(int i, E e) throws IndexOutOfBoundsException {
			if(i < 0 || i >= size) {
				throw new ArrayIndexOutOfBoundsException("index out of bound");
			}
			E elementReplace = elements[i];
			elements[i] = e;
			return elementReplace;
		}
		public boolean add(E e) {
            growSize();
            elements[size] = e;
            size++;
            return true;
			
		}
		public void add(int i, E e) throws
		IndexOutOfBoundsException {
			if(i < 0 || i >= size) {
                throw new ArrayIndexOutOfBoundsException("index out of bound");
            }
            growSize();
            for(int j = size - 1 ; j > i ; j-- ) {
                elements[j] = elements[j-1]; 
            }
            elements[i] = e;
            size++;
		}
		public E remove(int i) throws
		IndexOutOfBoundsException {
			if(i < 0 || i >= size) {
				throw new ArrayIndexOutOfBoundsException("index out of bound");
			}
			size--;
			E result = elements[i];
			for(int j = i; j < size; j++) {
                elements[j] = elements[j+1];
            }
			return result;
		}

		public void clear() {
			for(int i = 0 ; i < size; i++) {
				elements[i] = null;
			}
			size = 0;
		}
		public int lastIndexOf(Object o) {
			for(int i = size - 1; i >= 0; i--) {
                if(elements[i].equals(o)) {
                    return i;
                }
            }
            return -1;
		}
		public E[] toArray() {
		 E[] newArray= (E[]) new Object[size];
			for(int i = 0; i < size; i++) {
				newArray[i] = elements[i];
			}
			return newArray;
		}
		public MyArrayList<E> clone() {
            MyArrayList<E> clone = new MyArrayList<E>();
            for(int i = 0; i < size; i++) {
                clone.add(elements[i]);
            }
            return clone;
			
		}
        public boolean contains(Object o) {
            for(int i = 0; i < size; i++) {
                if(elements[i].equals(o)) {
                    return true;
                }
            }
            return false;
        }
        public int indexOf(E o){
            for(int i = 0; i < size; i++) {
                if(elements[i].equals(o)) {
                    return i;
                }
            }
            return -1;
        }
        public boolean remove(E e){
            for(int i = 0; i < size; i++){
                if(elements[i].equals(e)){
                    remove(i);
                    return true;
                }
            }
            return false;
        }
        public void sort(Comparator<E> c){
            for(int i = 0; i < size; i++){
                for(int j = i + 1; j < size; j++){
                    if(c.compare(elements[i], elements[j]) > 0){
                        E temp = elements[i];
                        elements[i] = elements[j];
                        elements[j] = temp;
                    }
                }
            }

        }
}
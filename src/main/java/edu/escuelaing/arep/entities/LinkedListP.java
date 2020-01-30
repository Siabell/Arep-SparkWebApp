package edu.escuelaing.arep.entities;

import java.io.Serializable;
import java.util.*;

import edu.escuelaing.arep.exception.MathLinkedListException;

/**
 * LinkedList Class 
 * 
 * 
 * @author Valentina Siabatto Rojas
 *
 * @param T - the type of elements held in this linked List 
 */
public class LinkedListP<T>  implements List<T>, Serializable, Iterable<T>, Collection<T> {
	
    private Node<T> head; 
    private Node<T> tail; 
    public int listLenght; 

    /**
     * Construct an empty Linkedlist
     */
	public LinkedListP() {
    	this.listLenght = 0;
    	this.head = null;
		this.tail = null;
    }
    
    /**
     * Construct an Linkedlist from an array of elements
     * @param c  array of elements to be appended to the linked List
     */
    public LinkedListP (T[] c) {
    	this.head = null;
		this.tail = null;
		this.listLenght = 0;
		T[] nodeElements = c;
		Node<T> nodeAdd = null;
		Node<T> nodePrior = null;
		for (int i = 0; i < nodeElements.length; i++) {
			if (i==0) {
				nodeAdd = new Node<T>(null,nodeElements[0], null);
				this.head = nodeAdd;
				this.tail = nodeAdd;
				listLenght++;
			}else {
				nodePrior=nodeAdd;
				nodeAdd = new Node<T>(nodeAdd,nodeElements[i], null);
				nodePrior.setNext(nodeAdd);
				this.tail = nodeAdd;	
				listLenght++;
			}
		
		}
    }

    /**
     * Appends the specified element to the end of this list.
     * @param objToAdd element to be appended
     * @return true
     */
    public boolean add (T objToAdd) {
    	Node<T> newNode;
    	if (listLenght==0) {
    		newNode = new Node<T>(null, objToAdd, null); 
    		this.head = newNode;
    		this.tail = newNode;
    		listLenght++;
    		
    	} else {
    		newNode = new Node<T>(this.tail,objToAdd,null); 
    		this.tail.setNext(newNode);
    		this.tail = newNode;
    		listLenght++;    		
    	}
    	return true;
    }
    
    /**
     * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right.
     * @param index index at which the specified element is to be inserted
     * @param element element to be appended
     * @throws IndexOutOfBoundsException - if the index is out of range
     * 
     */
	public void add(int index, T element)  {
		if (index < 0 || index >= listLenght) {
			try {
				throw new MathLinkedListException(MathLinkedListException.IndexOutOfBoundsException);
			} catch (Exception e) {
			      System.out.println(e);
			}
		} else  {
			Node<T> newNode;
			if (index == 0) {
				newNode = new Node<T>(null, element, this.head);
				this.head.setPreceding(newNode);
				this.head = newNode;
			} else if (index == listLenght) {
				newNode = new Node<T>(this.tail, element, null);
				this.tail.setNext(newNode);
				this.tail = newNode;
			} else {
				Node<T> nodeElement = this.getNode(index);
				newNode = new Node<T>(nodeElement.getPreceding(), element, nodeElement);
				nodeElement.getPreceding().setNext(newNode);
				nodeElement.setPreceding(newNode);
			}
			listLenght++;
		}
	}
	
	
	/**
	 * Returns the element at the specified position in this Linked list.
	 * @param index index of the element to return
	 * @return the element at the specified position in this Linked list
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public T get(int index) {
		if (index < 0 || index >= listLenght) {
			try {
				throw new MathLinkedListException(MathLinkedListException.IndexOutOfBoundsException);
			} catch (Exception e) {
			      System.out.println(e);
			}
		} else {
			Node<T> nodeElement = this.getNode(index);
			T element = (T) nodeElement.getElement();
			return element;
		}
		return null;
	}
	
	/**
	 * Returns the node of the element at the specified position in this Linked list.
	 * @param index index at which the specified element is to be inserted
	 * @return the node of the element at the specified position in this Linked list.
	 */
	private Node<T> getNode (int index) {
		int mid = listLenght/2;
		int pos = 0;
		Node<T> indexNode;
		if (index >= mid) {
			pos = listLenght-1;
			indexNode = this.tail;
			while (pos > index) {
				indexNode=indexNode.getPreceding();
				pos-=1;
			}
			//System.out.println(pos + "pos");
			return indexNode;
		} else {
			pos = 0;
			indexNode = this.head;
			while (pos < index) {
				indexNode=indexNode.getNext();
				pos+=1;
			}
			//System.out.println(pos + "pos");
			return indexNode;
		}
		
	}
	
	/**
	 * Removes all of the elements from this Linked list.
	 */
	public void clear() {
		this.head = null;
		this.tail = null;
		this.listLenght = 0;
		System.gc();
	}
	
	/**
	 * Returns the number of elements in this Linked list.
	 * @return  the number of elements in this Linked list.
	 */
	public int size() {
		return this.listLenght;
	}
	
	/**
	 * Removes the element at the specified position in this Linked list.
	 * Shifts any subsequent elements to the left
	 * @param index index at which the specified element is to be deleted.
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 * @return the element that was removed from the Linkedlist.
	 */
	public T remove(int index) {
		if (index < 0 || index >= listLenght) {
			try {
				throw new MathLinkedListException(MathLinkedListException.IndexOutOfBoundsException);
			} catch (Exception e) {
			      System.out.println(e);
			}
		} else  {
			Node<T> nodeElement;
			if (index == 0) {
				nodeElement = this.head;
				this.head.getNext().setPreceding(null);
				this.head = this.head.getNext();
				return (T) nodeElement.getElement();
			} else if (index == listLenght) {
				this.tail.getPreceding().setNext(null);
				this.tail = this.tail.getPreceding();
			} else {
				nodeElement = this.getNode(index);
				nodeElement.getPreceding().setNext(nodeElement.getNext());
				nodeElement.getNext().setPreceding(nodeElement.getPreceding());
				return nodeElement.getElement();
			}
			listLenght--;
		}
		return null;
	}
	
	/**
	 * Returns true if the linked List contains no elements.
	 * @return true if the linked List contains no elements
	 */
	public boolean isEmpty() {
		if (listLenght ==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns an iterator over the elements in this list 
	 * @return an iterator over the elements in this list
	 */
	public Iterator<T> iterator() {
		Iterator<T> res = new Iterator<T>() {
            private Node<T> now = head;

            public boolean hasNext() {
                if (now != null)
                    return true;
                return false;
            }

            public T next() {
                T data = now.getElement();
                now = now.getNext();
                return data;
            }
        };
        return res;
	}
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence
	 * @return an array containing all of the elements in this list in proper sequence
	 */
	public Object[] toArray() {
		Object[] resultArray = new Object[listLenght];
        for (int i = 0; i < this.listLenght; i++) {
        	resultArray[i] = this.get(i);
        }
        return resultArray;
	}
	
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	

	



	
	

}

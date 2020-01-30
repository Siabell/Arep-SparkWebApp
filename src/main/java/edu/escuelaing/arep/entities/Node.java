package edu.escuelaing.arep.entities;

/**
 * Node Class 
 * @author Valentina Siabatto Rojas
 *
 * @param T the type of elements held in this linked List 
 */
public class Node<T> {
	
	private T element;
	private Node<T> next; 
	private Node<T> preceding; 
	
	/**
	 * Constructs a node 
	 * @param preceding preceding node
	 * @param element element of the node
	 * @param next next node
	 */
	public Node (Node<T> preceding, T element, Node<T> next ) {
		this.element = element;
		this.next = next;
		this.preceding = preceding;
	}

	/**
	 * Returns the element of the node
	 * @return the element of the node
	 */
	public T getElement() {
		return element;
	}
	
	/**
	 * Replaces the element of the node
	 * @param element element to be stored.
	 */
	public void setElement(T element) {
		this.element = element;
	}
	
	/**
	 * Returns the next node
	 * @return next node
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * Replaces the next node
	 * @param next node to be stored
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * Returns the preceding node
	 * @return preceding node
	 */
	public Node<T> getPreceding() {
		return preceding;
	}
	
	/**
	 * Replaces the preceding node
	 * @param preceding node to be stored
	 */
	public void setPreceding(Node<T> preceding) {
		this.preceding = preceding;
	}

	

	
}

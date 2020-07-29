package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size=0;
		head=new LLNode<E>(null);
		tail=new LLNode<E>(null);
		head.next=tail;
		tail.prev=head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
//		if(element==null)
//		{
//			throw new NullPointerException();
//		}
		
//		LLNode<E> newNode=new LLNode<E>(element);
//		newNode.next=tail;
//		newNode=tail.prev;
//		tail.prev.next=newNode;
//		tail.prev=newNode;
		
//		size++;
		
		add(this.size(),element);
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if((index<0)||(index>size-1)||(size==0))
		{
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		LLNode<E> node=head.next;
		for(int i=0;i<index;i++)
		{
			node=node.next;
		}
		return node.data;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element==null)
		{
			throw new NullPointerException("Data cannot be null");
		}
		if((index<0)||(index>size))
		{
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		LLNode<E> currentNode=head;
		LLNode<E> newNode=new LLNode<E>(element);
		for(int i=0;i<index;i++)
		{
			currentNode=currentNode.next;
		}
		
		newNode.prev=currentNode;
		newNode.next=currentNode.next;
		newNode.next.prev=newNode;
		currentNode.next=newNode;
		
		this.size++;
		
	}
	


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if((index<0)||(index>this.size()-1))
		{
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		LLNode<E>nodeRemove=head.next;
		for(int i=0;i<index;i++)
		{
			nodeRemove=nodeRemove.next;
		}
		
		E removedElement=nodeRemove.data;
		nodeRemove.prev.next=nodeRemove.next;
		nodeRemove.next.prev=nodeRemove.prev;
		nodeRemove.prev=null;
		nodeRemove.next=null;
		this.size--;
		
		return removedElement;
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element==null)
		{
			throw new NullPointerException("Null Value");
		}
		if((index<0)||(index>this.size()-1))
		{
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		LLNode<E> nodeSet=head.next;
		for(int i=0;i<index;i++)
		{
			nodeSet=nodeSet.next;
		}
		E oldElement=nodeSet.data;
		nodeSet.data=element;
		return oldElement;
	} 
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}


package com.metacube.customDoubleLinkedList;



public class DoublyLinkedList<E> {
	Node<E> head = null;
	Node<E> node = new Node<E>();
	static int size = 0;

	public boolean addNodeAtLocation(int location, E data) {
			Node<E> newNode = node.getNode(data);
			Node<E> temp = this.head;
			int index = 2;
			if(location == 1){
				newNode.next = temp;
				if(temp != null){
					temp.previous = newNode;
				}
				this.head = newNode;
				size++;
				return true;
			}
			else{
				while(temp != null){		
					if(index == location){
						newNode.previous = temp;
						newNode.next = temp.next();
						if(temp.next != null){
							temp.next.previous = newNode;
						}
						temp.next = newNode;
						size++;
						return true;
					}
					index++;
					temp=temp.next();
					}	
				}
		return false;	
	}

	public int getSize() {
		return size;
	}

	public void addNode(E data) {
		Node<E> newNode = node.getNode(data);
		if (size == 0) {
			this.head = newNode;
		} else {
			Node<E> temp = this.head;
			while (temp.next() != null) {
				temp = temp.next();
			}
			newNode.previous = temp;
			temp.next = newNode;
		}
		size++;
	}

	public boolean removeItem(E data) {
		Node<E> temp = this.head;
		if ( size>0 && head.data.equals(data) ) {
			head = head.next();
			if(head!=null){
			head.previous=null;
			}
			size--;
			return true;
		} else {
			while (temp != null) {
				if (temp.data.equals(data)) {
					temp.previous.next = temp.next();
					if(temp.next != null){
					temp.next.previous = temp.previous();	
					}
					size--;
					return true;
				}
				temp = temp.next();
			}
		}
		return false;
	}

	public boolean removeItemFromPosition(int location) {
		Node<E> temp = this.head;
		int index = 0;
		if (location == 0 && size>0) {
			this.head = this.head.next();
			if(head!=null){
			head.previous=null;
			}
			size--;
			return true;
		} else {
			while (temp != null) {
				if (index == location) {
					temp.previous.next = temp.next();
					if(temp.next != null){
						temp.next.previous = temp.previous();
					}
					size--;
					return true;
				}
				index++;
				temp = temp.next();
			}
		}
		return false;
	}

	public E getElementFromPosition(int location) {
		Node<E> temp = this.head;
		int index = 0;
		while (temp != null) {
			if (index == location) {
				return temp.data;
			}
			temp=temp.next();
			index++;
		}
		return (E) "-1";
	}

	public void reverseLinkedList() {
		Node<E> temp = null;
        Node<E> current = head;
 
        while (current != null) {
            temp = current.previous();
            current.previous = current.next;
            current.next = temp;
            current = current.previous();
        }
        /* Before changing head, check for the cases like empty 
         list and list with only one node */
        if (temp != null) {
            head = temp.previous();
        }
	}
	public void sort(){
		Node<E> temp1 = this.head;
		Node<E> temp2 = null;
		while( temp1 != null ){
			temp2 = temp1.next();
			while(temp2 != null){
				if( temp1.data.toString().compareTo(temp2.data.toString()) > 0 ){
					E temp = temp1.data;
					temp1.data = temp2.data;
					temp2.data = temp;
				}
				temp2 = temp2.next();
			}
			temp1 = temp1.next();
		}
	}
	
}

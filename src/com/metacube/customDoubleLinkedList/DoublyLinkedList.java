package com.metacube.customDoubleLinkedList;

import com.metacube.util.Utility;
import com.metacube.util.customArrayList.CustomList;

import java.util.Iterator;


/**
 * The Class DoublyLinkedList.
 * @author Pawan Manglani
 * @version 1.1 21-Aug-2017
 * @param <T> the generic type
 */
public class DoublyLinkedList<T> implements CustomList<T> {

    /** The head. */
    Node<T> head = null;
    
    /** The node. */
    Node<T> node = new Node<T>();
    
    /** The size. */
    /*
    *The size of the ArrayList (the number of elements it contains). 
     */
    private int size;

    /**
     * Checks if the given index is in range. If not, throws an appropriate
     * runtime exception.
     *
     * @param index the index
     * @throws IllegalArgumentException the illegal argument exception
     */
    private void rangeCheck(int index) {
        if (((index - size >= 1) || index < 0) && (size>0) ) {
            throw new IllegalArgumentException("Invalid Position");
        }
    }

    /**
     * Reverse linked list.
     */
    public void reverseLinkedList() {
        Node<T> temp = null;
        Node<T> current = head;

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

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        boolean result = false;
        if (size == 0) {
            result = true;
        }
        return result;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present. If the list does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        Node<T> temp = this.head;
        boolean result = false;
        if (size > 0 && head.data.equals(o)) {
            head = head.next();
            if (head != null) {
                head.previous = null;
            }
            size--;
            result = true;
        } else {
            while (temp != null) {
                if (temp.data.equals(o)) {
                    temp.previous.next = temp.next();
                    if (temp.next != null) {
                        temp.next.previous = temp.previous();
                    }
                    size--;
                    result = true;
                    break;
                }
                temp = temp.next();
            }
        }
        return result;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after
     * this call returns.
     */
    @Override
    public void clear() {
        Node<T> temp = this.head;
        try {
            while (temp != null) {
                Node<T> next = temp.next;
                temp.previous = temp.next = null;
                temp.data = null;
                temp = next;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     *
     */
    @Override
    public T get(int index) {
        Node<T> temp = this.head;
        T element = null;
        int position = 0;
        try {
        	rangeCheck(index);
            while (temp != null) {
                if (index == position) {
                    element = temp.data;
                    break;
                }
                temp = temp.next();
                position++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return element;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param data the data
     */
    @Override
    public void add(int index, T data) {
        Node<T> newNode = node.getNode(data);
        Node<T> temp = this.head;
        int position = 1;
        try {
            rangeCheck(index);
            if (index == 0) {
                newNode.next = temp;
                if (temp != null) {
                    temp.previous = newNode;
                }
                this.head = newNode;
                size++;
            } else {
                while (temp != null) {
                    if (position == index) {
                        newNode.previous = temp;
                        newNode.next = temp.next();
                        if (temp.next != null) {
                            temp.next.previous = newNode;
                        }
                        temp.next = newNode;
                        size++;
                    }
                    position++;
                    temp = temp.next();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param data element to be appended to this list
     */
    @Override
    public void add(T data) {
        Node<T> newNode = node.getNode(data);
        if (size == 0) {
            this.head = newNode;
        } else {
            Node<T> temp = this.head;
            while (temp.next() != null) {
                temp = temp.next();
            }
            temp.next = newNode;
            newNode.previous = temp;
        }
        size++;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    @Override
    public T remove(int index) {
        Node<T> temp = this.head;
        T element = null;
        int position = 0;
        try {
            rangeCheck(index);
            if (index == 0 && size > 0) {
                this.head = this.head.next();
                element = this.head.data;
                if (head != null) {
                    head.previous = null;
                }
                size--;
            } else {
                while (temp != null) {
                    if (position == index) {
                        element = temp.data;
                        temp.previous.next = temp.next();
                        if (temp.next != null) {
                            temp.next.previous = temp.previous();
                        }
                        size--;
                    }
                    position++;
                    temp = temp.next();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return element;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     * @param o element whose index in this list is to be needed
     * @return the index of element
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<T> e = head.next; e != head; e = e.next) {
                if (e.data == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> e = head.next; e != head; e = e.next) {
                if (o.equals(e.data)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     *
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        Node<T> e = head;
        for (e = head; e != null; e = e.next) {
            result[i++] = e.data;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.metacube.util.customArrayList.CustomList#sort(com.metacube.util.customArrayList.CustomList)
     */
    @SuppressWarnings("hiding")
	@Override
    public <T extends Comparable<? super T>> void sort(CustomList<T> list) {
        Utility.sort(list);
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     *
     *
     */
    @Override
    public T set(int index, T element) {
        Node<T> temp = this.head;
        T oldValue = temp.data;
        int position = 0;
        if (index == 0) {
            temp.data = element;
        } else {
            while (position <= index) {
                if (position == index) {
                    oldValue = temp.data;
                    temp.data = element;
                    break;
                }
                temp = temp.next;
                position++;
            }
        }
        return oldValue;
    }

    /**
     * To string.
     *
     * @return String representation of ArrayList
     */
    @Override
    public String toString() {
        String result = "[";
        Node<T> temp = this.head;
        if (head == null) {
            result = "List is Empty";
        } else {
            while (temp != null) {
                result += " " + temp.data;
                temp = temp.next();
            }
            result += "]";
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.metacube.util.customArrayList.CustomList#addAll(com.metacube.util.customArrayList.CustomList)
     */
    @Override
    public boolean addAll(CustomList<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    @SuppressWarnings("rawtypes")
	@Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public int indexOf(Object o, int pos) {
		// TODO Auto-generated method stub
		return 0;
	}

}

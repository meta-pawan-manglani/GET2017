/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.util.customArrayList;

/**
 *
 * @author Pawan Manglani
 * @version 1.1 21-Aug-2017
 */
@SuppressWarnings("rawtypes")
public interface CustomList<T> extends Iterable{

    public int size();

    public boolean isEmpty();

    public boolean contains(Object o);

    public boolean remove(Object o);

    public void clear();

    public T get(int index);

    public void add(int index, T element);
    
    public void add(T element);

    public  T remove(int index);

    public int indexOf(Object o);
    
    public int indexOf(Object o,int pos);
    
    public Object[]  toArray();
    
    @SuppressWarnings("hiding")
	public  <T extends Comparable<? super T>> void sort(CustomList<T> list);
    
    public T set(int index, T element);
     
    public boolean addAll(CustomList<? extends T> c);
}

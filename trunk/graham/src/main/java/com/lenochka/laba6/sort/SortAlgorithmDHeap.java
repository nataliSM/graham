package com.lenochka.laba6.sort;

import com.lenochka.laba6.CommonUtils;


/**
 * @author Lenochka
 * 
 * Информация взята из статьи "Сортировка с помощью d-кучи"
 * http://cpblog.ru/algorithms/sortirovki/sortirovka-s-pomoshhyu-d-kuchi.html
 * 
 */
public class SortAlgorithmDHeap implements SortAlgorithm {
	
	public static final SortAlgorithm SORT_ALGORITHM_2HEAP = new SortAlgorithmDHeap(2);
	public static final SortAlgorithm SORT_ALGORITHM_3HEAP = new SortAlgorithmDHeap(3);

	@SuppressWarnings("rawtypes")
	private Comparable[] key = null;
	private Integer lenghtd = null;
	private final int d;
	
	public SortAlgorithmDHeap(int d) {
		if (d < 2){
			throw new IllegalArgumentException(String.valueOf(d));
		}
		this.d = d;
	}
	
	/* (non-Javadoc)
	 * @see com.lenochka.laba6.algorithm.SortAlgorithm#sort(java.lang.Comparable[])
	 */
	@Override
	public void sort(@SuppressWarnings("rawtypes") Comparable[] data) {
		key = data;
		sortDHeap();
	}

	/**
	 * Сортирует массив key[] с помощью d-кучи
	 */
	private void sortDHeap() {
		lenghtd = key.length - 1;
		createQueue();
		while (lenghtd >= 0) {
			deleteMin();
		}
		
	};
	
	
	/**
	 * Образуем очередь
	 */
	private void createQueue() {
		for (int i = lenghtd; i >= 0; i--)
			inbedding(i);
	};

	
	/**
	 * Удаляем минимальный
	 */
	private void deleteMin() {
		CommonUtils.swap(key, 0, lenghtd);
		if (--lenghtd >= 0){
			inbedding(0);
		}
	};

	
	/**
	 * Погружение
	 * 
	 * @param index
	 */
	@SuppressWarnings("unchecked")
	private void inbedding(final int index)
	{
		int c = minChild(index);
		int i = index;
		// Знак сравнения изменен для сортировки непоубыванию
		while ((c != 0) && (key[c].compareTo(key[i]) > 0)) {
			CommonUtils.swap(key, i, c);
			i = c;
			c = minChild(c);
		}
	};

	
	/**
	 * Последний потомок узна
	 * 
	 * @param index
	 * @return
	 */
	private int lastChild(final int index) {
		int k = firstChild(index);
		int f = k + d - 1;
		if (k == index)
			return index;
		else if (f <= lenghtd)
			return f;
		else
			return lenghtd;
	};

	
	/**
	 * Первый потомок узла
	 * 
	 * @param index
	 * @return
	 */
	private int firstChild(final int index) {
		int k = index * d + 1;
		if (k > lenghtd) {
			return index;
		} else {
			return k;
		}
	};

	
	/**
	 * Позволяет находить непосредственного потомка узла с минимальным ключом
	 * 
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int minChild(final int index) {
		int kf = firstChild(index);
		int kl;
		if (kf != 0){
			kl = lastChild(index);
			@SuppressWarnings("rawtypes")
			Comparable min_key = key[kf];
			int min_ch = kf;
			for (int i = kf; i <= kl; i++){
				// Знак сравнения изменен для сортировки непоубыванию
				if (key[i].compareTo(min_key) > 0) {
					min_key = key[i];
					min_ch = i;
				}
			}
			return min_ch;
		}
		return 0;
	};
	
	@Override
	public String toString(){
		return "Сортровка " + d + " кучей";
	}

}

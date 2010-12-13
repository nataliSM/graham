package com.lenochka.laba6.convex;

import com.lenochka.laba6.CommonUtils;
import com.lenochka.laba6.sort.SortAlgorithm;

/**
 * @author Lenochka
 * 
 *
 */
public class ConvexHull {

	private SortAlgorithm sortAlgorithm;

	public ConvexHull(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}
	
	public int convex(Point[] a) {

		// Поиск лексикографического минимума
		// в декартовых координатах
		Point c = a[0];
		int m = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i].getX() < c.getX()) {
				c = a[i];
				m = i;
			} else if (a[i].getX() > c.getX()) {
				// НЕ сравниваем вещественные числа на строгое
				// равенство/неравенство (плохая практика)
				continue;
			}
			if (a[i].getY() < c.getY()) {
				c = a[i];
				m = i;
			}
		}
		CommonUtils.swap(a, 0, m);
		m = 0;

		// Переносим начало системы координат в точку c
		for (int i = 0; i < a.length; i++) {
			a[i] = Point.minus(a[i], c);
		}

		// Лексикографическая сортировка в полярной системе координат
		sortAlgorithm.sort(a);

		// Обход Грэхема как в методичке
		for (int i = 1; i < a.length; i++) {
			if (i != m) {
				if (m >= 1) {
					while ((m >= 1)
							&& (Point.det(Point.minus(a[m], a[i]),
									Point.minus(a[m - 1], a[m])) >= 0)) {
						m--;
					}
				}
				m++;
				CommonUtils.swap(a, m, i);
			}
		}

		// Восстанавливаем начало декартовой системы координат
		for (int i = 0; i < a.length; i++) {
			a[i] = Point.plus(a[i], c);
		}

		// Возвращем индекс последнего элемента массива
		return m;

	}
	
	@Override
	public String toString(){
		return "Нахождение выпуклой оболочки конечного множества точек метогом Грэхема. " + sortAlgorithm.toString();
	}

}

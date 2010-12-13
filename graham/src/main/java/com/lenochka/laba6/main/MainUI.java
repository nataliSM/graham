package com.lenochka.laba6.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lenochka.laba6.convex.ConvexHull;
import com.lenochka.laba6.convex.Point;
import com.lenochka.laba6.sort.SortAlgorithmDHeap;

public class MainUI {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			start();
		} catch (NumberFormatException e) {
			System.err.println("Неверный формат. Вводите валидные значения! " + e.getLocalizedMessage() );
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Ошибка ввод/вывода! " + e.getLocalizedMessage() );
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Неизвестная ошибка! " + e.getLocalizedMessage());
			e.printStackTrace();
		} finally {
			try {
				reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void start() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Нахождение выпуклой оболочки конечного множества точек метогом Грэхема");
		System.out.println("Выберите эксперимент.");
		System.out.println("1 - Проверить алгоритм.");
		System.out.println("2 - п 3.1 из методички.");
		System.out.println("3 - п 3.2 из методички.");
		System.out.println("4 - п 3.3 из методички.");
		System.out.print("Введите номер 1-4: ");
		int expNo = Integer.valueOf(reader.readLine());
		switch (expNo) {
		case 1:
			exp1();
			break;
		case 2:
			exp2();
			break;
		case 3:
			exp3();
			break;
		case 4:
			exp4();
			break;
		default:
			throw new IOException("Значение от 1 до 4!");
		}

	}
	
	public static void exp1() throws NumberFormatException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Проверить алгоритм.");
		System.out.println("Выберите алгоритм сортировки.");
		System.out.println("1 - 2кучей");
		System.out.println("2 - 3кучей");
		int alg = Integer.valueOf(reader.readLine());
		ConvexHull convexHull = null;
		switch (alg) {
		case 1:
			convexHull = new ConvexHull(new SortAlgorithmDHeap(2));
			break;
		case 2:
			convexHull = new ConvexHull(new SortAlgorithmDHeap(3));
			break;
		default:
			throw new IOException("Значение от 1 до 2!");
		}	
		System.out.println("Введите количество точек: ");
		int n = Integer.valueOf(reader.readLine());
		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < n; i++) {
			System.out.println("Введите координаты точки " + i + " :");
			System.out.print("x: ");
			Float x = Float.valueOf(reader.readLine());
			System.out.print("y: ");
			Float y = Float.valueOf(reader.readLine());
			points.add(new Point(x,y));
		}
		Point[] ps = (Point[]) points.toArray(new Point[]{});
		int m = convexHull.convex(ps);
		System.out.println("Точки на границе: " + Arrays.asList(Arrays.copyOf(ps, m + 1)));
	}
	
	public static void exp2() throws NumberFormatException, IOException{
		System.out.println("п 3.1 из методички.");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Введите стороны прямоугольника для генерации значеничений.");
		System.out.print("q: ");
		Float q = Float.valueOf(reader.readLine());
		System.out.print("w: ");
		Float w = Float.valueOf(reader.readLine());
		System.out.println("Введите параметры изменения количества точек.");
		System.out.print("nFrom (от какого значения): ");
		int nFrom = Integer.valueOf(reader.readLine());
		System.out.print("nTo (до какого значения): ");
		int nTo = Integer.valueOf(reader.readLine());
		System.out.print("nStep (шаг): ");
		int nStep = Integer.valueOf(reader.readLine());
		MainUtils.task31(q, w, nFrom, nTo, nStep);
	}
	
	public static void exp3() throws NumberFormatException, IOException{
		System.out.println("п 3.2 из методички. (Точки внутри квадрата)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Введите количество точек.");
		System.out.print("n: ");
		int n = Integer.valueOf(reader.readLine());
		System.out.println("Введите параметры изменения стороны квадрата.");
		System.out.print("qFrom (от какого значения): ");
		Float qFrom = Float.valueOf(reader.readLine());
		System.out.print("qTo (до какого значения): ");
		Float qTo = Float.valueOf(reader.readLine());
		System.out.print("qStep (шаг): ");
		Float qStep = Float.valueOf(reader.readLine());
		MainUtils.task32(n, qFrom, qTo, qStep);
	}
	
	public static void exp4() throws NumberFormatException, IOException{
		System.out.println("п 3.3 из методички. (Точки на границе квадрата)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Введите количество точек.");
		System.out.print("n: ");
		int n = Integer.valueOf(reader.readLine());
		System.out.println("Введите параметры изменения стороны квадрата.");
		System.out.print("qFrom (от какого значения): ");
		Float qFrom = Float.valueOf(reader.readLine());
		System.out.print("qTo (до какого значения): ");
		Float qTo = Float.valueOf(reader.readLine());
		System.out.print("qStep (шаг): ");
		Float qStep = Float.valueOf(reader.readLine());
		MainUtils.task33(n, qFrom, qTo, qStep);
	}

}

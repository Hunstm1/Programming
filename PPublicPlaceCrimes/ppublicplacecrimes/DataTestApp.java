//package ppublicplacecrimes;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class DataTestApp {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ArrayList<Crime> dataList = new ArrayList<Crime>();
//		Worker worker = new Worker();
//		
//		
//		dataList = worker.readFile(dataList);
//		//worker.sortByDistrict(dataList);
//		worker.sortByVictims(dataList);
//		//Collections.sort(dataList);
//		for (Crime item:dataList) {
//			System.out.println(item.toString());
//		}
//		
//		System.out.println("\n" + worker.getMax(dataList).toString());
//		System.out.println("\n" + worker.getMin(dataList).toString());
//	}
//
//}

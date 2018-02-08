package com.conv.review.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.conv.review.dao.ReviewDAO;

public class TEst {
	public static void main(String[] args) {
		Review[] arr = {(new ReviewDAO()).selectBoardByNo(17), (new ReviewDAO()).selectBoardByNo(19), (new ReviewDAO()).selectBoardByNo(19)};
		
		System.out.println("배열 : " + arr[0].getTitle());
		System.out.println("배열 : " + arr[0]);
		System.out.println("배열 : " + arr);
		System.out.println("배열 : " + Arrays.toString(arr));
		
		List<Review> list = new ArrayList<>();
		
		list.add((new ReviewDAO()).selectBoardByNo(17));
		list.add((new ReviewDAO()).selectBoardByNo(19));
		System.out.println("리스트 : " +list.get(0).getTitle());
		System.out.println("리스트 : " +list.get(0));
		System.out.println("리스트 : " + list);
		
		
		Object[] oArr = {"String", 1};
		List<Object> oList = new ArrayList<>();
		oList.add("String");
		oList.add(1);

		String arrs = (String)oArr[0];
		String lists = (String)oList.get(0);
		
		System.out.println("배열 : " + oArr[0]);
		System.out.println("배열 : " + oArr[1]);
		System.out.println("리스트 : " + oList.get(0));
		System.out.println("리스트 : " + oList.get(1));
		
		
	}
}

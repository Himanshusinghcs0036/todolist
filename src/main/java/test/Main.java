package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	static Map<Integer, Dto> map = new HashMap<Integer, Dto>();

	public static void main(String[] args) {

		Map<Integer, Dto> map2 = map();
		Result root = new Result();

		Set<Entry<Integer, Dto>> entrySet = map2.entrySet();

		for (Map.Entry<Integer, Dto> entry : entrySet) {
			Dto value = entry.getValue();
			root.setId(entry.getKey());
			insertNew(root, value.getIntegers());
			break;
		}
		System.out.println(root);
	}

	public static Result insertNew(Result root, List<Integer> children) {

		if (children == null) {
			return root;
		} else {

			List<Result> list = new ArrayList<Result>();
			for (Integer i : children) {
				Result root1 = new Result();
				root1.setId(i);
				list.add(insertNew(root1, map.get(i).getIntegers()));
			}
			root.setList(list);
			return root;
		}

	}

	/*
	 * private static Result insert(Result root, Dto value) { List<Integer> integers
	 * = value.getIntegers(); if (integers == null) { root =
	 * getNewNode(value.getId()); } else { List<Result> list = new
	 * ArrayList<Result>(); for (Integer i : integers) { Result insert =
	 * insert(root, map.get(i)); list.add(insert); } root.setList(list); } return
	 * root; }
	 */

	private static Result getNewNode(int id) {
		Result root = new Result();
		root.setId(id);
		return root;
	}

	private static Map<Integer, Dto> map() {
		Dto dto = new Dto();
		dto.setId(101);
		dto.setVal("val1");
		dto.setIntegers(Arrays.asList(102, 103));

		Dto dto1 = new Dto();
		dto1.setId(102);
		dto1.setVal("val1");

		Dto dto2 = new Dto();
		dto2.setId(103);
		dto2.setVal("val1");
		dto2.setIntegers(Arrays.asList(104));

		Dto dto3 = new Dto();
		dto3.setId(104);
		dto3.setVal("val1");

		map.put(101, dto);
		map.put(102, dto1);
		map.put(103, dto2);
		map.put(104, dto3);
		return map;
	}
}

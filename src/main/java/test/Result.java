package test;

import java.util.List;

public class Result {

	private int id;

	private List<Result> list;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Result> getList() {
		return list;
	}

	public void setList(List<Result> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", list=" + list + "]";
	}
}

package com.comp.practisestring;

public class MyPair<T1, T2> {
	private T1 index;
	private T2 count;

	public MyPair(T1 i, T2 j) {
		index = i;
		count = j;
	}

	public T1 getIndex() {
		return index;
	}

	public void setIndex(T1 index) {
		this.index = index;
	}

	public T2 getCount() {
		return count;
	}

	public void setCount(T2 count) {
		this.count = count;
	}
}

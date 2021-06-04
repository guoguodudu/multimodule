package com.fenyun.ws.manager;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ManagerApplication.class)
public class BaseTest {


	@Test
	public void quickSort() {

		int[] ints = {5, 6, 3, 11, 23, 4};
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
		System.out.println("11111111");
		sort(ints, 0, ints.length - 1);
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}

	public void sort(int[] ins, int start, int end) {

		if (end < start) return;
		int mid = ins[start];
		int left = start;
		int right = end;
		while (left <= right) {
			while (left <= right && mid > ins[left]) {
				left++;
			}

			while (left <= right && mid < ins[right]) {
				right--;
			}
			if (left <= right) {
				int temp = ins[left];
				ins[left] = ins[right];
				ins[right] = temp;
				left++;
				right--;
			}

		}
		sort(ins, start, right);
		sort(ins, left, end);
	}
}

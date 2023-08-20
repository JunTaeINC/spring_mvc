package hello.servlet.basic;

import lombok.Getter;

@Getter
public class TestData {
	private String username;
	private int age;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
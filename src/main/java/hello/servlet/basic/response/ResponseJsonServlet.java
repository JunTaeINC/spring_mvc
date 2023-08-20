package hello.servlet.basic.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.TestData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		TestData testData = new TestData();
		testData.setAge(20);
		testData.setUsername("Post");

		String result = objectMapper.writeValueAsString(testData);
		response.getWriter().write(result);
	}
}
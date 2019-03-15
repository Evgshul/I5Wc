package jtm.activity17;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import jtm.activity13.Teacher;
import jtm.activity13.TeacherManager;

@Controller
@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
public class JettyController {

	TeacherManager manager;

	/**
	 * method which is invoked when root folder (i.e. http://localhost:8080/) of
	 * web application is requested. This method doesn't take any parameters
	 * passed in URL (address).
	 * 
	 * @return string as HTML response to the request using UTF-8 encoding for
	 *         non-Latin characters.
	 */
	@GetMapping("")
	@ResponseBody
	// This method should work without declared name parameter, request and
	// response objects,
	// but it shows, how passed request and returned response can be used inside
	// method
	public String homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href='/insertTeacher'>Insert teacher<a><br/>\n");
		sb.append("<a href='/findTeacher'>Find teacher<a><br/>\n");
		sb.append("<a href='/deleteTeacher'>Delete teacher<a><br/>\n");
		// Following is also redundant because status is OK by default:
		response.setStatus(HttpServletResponse.SC_OK);
		return sb.toString();
	}

	// TODO Implement insertTeacher() method
	// @GetMapping("/insertTeacher")

	@GetMapping("/insertTeacher")
	@ResponseBody
	public String insertTeacher(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname, HttpServletRequest request,
			HttpServletResponse response) {

		StringBuilder sb = new StringBuilder();

		sb.append("<form action=''>");
		sb.append("Name: <input type='text' name='name' value=''><br/>");
		sb.append("Surname:<input type='text' name='surname' value=''><br/>");
		sb.append("<input type='submit' value='Insert'></form><br/>");
		sb.append("<a href='/'>Back</a>");

		if (name != null && surname != null) {
			if (name != "" && surname != "") {
				if (manager.insertTeacher(name, surname)) {
					sb = new StringBuilder();
					sb.append("true<br/>\n");
					sb.append("<a href='/'>Back</a>\n");
					response.setStatus(HttpServletResponse.SC_OK);
					return sb.toString();
				} else {
					sb = new StringBuilder();
					sb.append("false<br/>\n");
					sb.append("<a href='/'>Back</a>\n");
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					sb.toString();
				}
			}
		}

		return sb.toString();
	}

	// TODO Implement findTeacher() method
	@GetMapping("/findTeacher")
	@ResponseBody
	public String findTeacher(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname, HttpServletRequest request,
			HttpServletResponse response) {
		List<Teacher> teacher = new ArrayList<Teacher>(manager.findTeacher(name, surname));

		StringBuilder sb = new StringBuilder();
		sb.append("<form action=''>");
		sb.append("Name: <input type='text' name='name' value=''><br/>");
		sb.append("Surname:<input type='text' name='surname' value=''><br/>");
		sb.append("<input type='submit' value='Find'><br/>");
		sb.append("<a href='/'>Back</a>");
		response.setStatus(HttpServletResponse.SC_OK);

		if (name != null && surname != null) {
			if (name != "" && surname != "") {
				if (manager.findTeacher(name, surname) != null) {

					for (Teacher t : teacher) {

						sb.append(" <form action=''>");
						sb.append("Name: <input type='text' name='name' value=''><br/>");
						sb.append("Surname:<input type='text' name='surname' value=''><br/>");
						sb.append("<input type='submit' value='Find'><br/>");
						sb.append("<table>\n");

						sb.append("<tr>\n");
						sb.append("<td>" + t.getID() + "</td>\n");
						sb.append("<td>" + t.getFirstName() + "</td>\n");
						sb.append("<td>" + t.getLastName() + "</td>\n");
						sb.append("</tr>\n");
						sb.append("</table><br> <a href='/'>Back</a>");

					}
				}

			}
		}
		sb.append("<a href='/'>Back</a>\n");
		return sb.toString();
	}

	// TODO Implement deleteTeacher() method
	@GetMapping("/deleteTeacher")
	@ResponseBody
	public String deleteTeacher(@RequestParam(value = "id", required = false) String id, HttpServletRequest request,
			HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		sb.append("<form action=''>\n");
		sb.append("ID:<input type='text' name='id' value=''><br/>\n");
		sb.append("<input type='submit' value='Delete'><br/>\n");
		sb.append("<a href='/'>Back</a>\n");
		response.setStatus(HttpServletResponse.SC_OK);
		if (id != null) {
			if (id != "") {
				if (manager.deleteTeacher(Integer.parseInt(id))) {
					sb = new StringBuilder();
					sb.append("true<br/>\n");
					sb.append("<a href='/'>Back</a>\n");
					response.setStatus(HttpServletResponse.SC_OK);
				}
			} else {
				sb = new StringBuilder();
				sb.append("false<br/>\n");
				sb.append("<a href='/'>Back</a>\n");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
		return sb.toString();

	}
}

package jtm.activity17;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
public class JettyController {

	//TeacherManager manager = new TeacherManager();

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
	@GetMapping("/insertTeacher")
	///@RequestMapping(value = "/insertTeacher", produces = "text/html;charset=UTF-8")
	
	@ResponseBody
	public String insertTeacher(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname,HttpServletRequest request,
	HttpServletResponse response) {
		
		//if(manager== null)
			//manager = new TeacherManager();
	String content = 
		"<form action=''>"+
		"Name: <input type='text' name='name' value=''><br/>"+
		"Surname:<input type='text' name='surname' value=''><br/>"+
		"<input type='submit' value='Insert'></form><br/>"+
		"<a href='/'>Back</a>";

	
	//response.setStatus(HttpServletResponse.SC_OK);
		
		
		return content;
	}

	// TODO Implement findTeacher() method
	@GetMapping("/findTeacher")
	@ResponseBody
	public String findTeacher() {
		return "";
	}

	// TODO Implement deleteTeacher() method
	public String deleteTeacher() {
		return "";
	}
}

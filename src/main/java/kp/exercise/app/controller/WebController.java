package kp.exercise.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Webcontroller for the basic rendering of the API as a webpage
 * 
 * @author Karen Pang
 *
 */
@Controller
public class WebController {
	
	private static Logger LOG = LoggerFactory.getLogger(WebController.class);
	
    private static final String HOME_TEMPLATE = "home"; 
    
    private ExerciseController eController;
    
    @Autowired
    public WebController(ExerciseController eController) {
    	this.eController = eController;
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = "text/html", value = "") 
	public String home(@RequestParam(name="name", required=false, defaultValue="Karen") String name, Model model) {
		model.addAttribute("hello", String.format("Greetings %s!", name));
		return HOME_TEMPLATE;
    }
}

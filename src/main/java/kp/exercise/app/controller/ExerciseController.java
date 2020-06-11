package kp.exercise.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kp.exercise.app.model.ExerciseEntry;
import kp.exercise.app.service.ExerciseService;

/**
 * Controller for the Exercise App
 * 
 * @author Karen Pang
 *
 */
@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
	
	private static Logger LOG = LoggerFactory.getLogger(ExerciseController.class);
	
	private ExerciseService exerciseService;
	
	@Autowired
	public ExerciseController(ExerciseService exerciseDao) {
		this.exerciseService = exerciseDao;
	}
    
    @GetMapping("list")
    public List<ExerciseEntry> getExercises() {
    	return exerciseService.getExercises();
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value="add")
    public ExerciseEntry addExercise(@RequestBody ExerciseEntry reqBody) {
    	exerciseService.addExercise(reqBody);
    	return reqBody;
    }
    
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value="delete")
    public void deleteExercise(@RequestParam Long id) {
    	exerciseService.deleteExercise(id);
    }
}

package kp.exercise.app.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Preconditions;

import io.micrometer.core.annotation.Timed;
import kp.exercise.app.controller.ExerciseController;
import kp.exercise.app.dao.ExerciseDao;
import kp.exercise.app.model.ExerciseEntry;

/**
 * Service layer that handles the logic of interacting w/ Exercise objects
 * 
 * @author Karen Pang
 *
 */
@Service
public class ExerciseService {
	private static Logger LOG = LoggerFactory.getLogger(ExerciseController.class);
	
	private ExerciseDao exerciseDao;
	
	@Autowired
	public ExerciseService(ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}
    
    @Timed("exercise.list")
    @GetMapping("list")
    public List<ExerciseEntry> getExercises() {
    	try {
    		return exerciseDao.getAllExercises();
    	}
    	catch(EmptyResultDataAccessException e) {
    		LOG.warn("No exercise results present.");
    		return Collections.emptyList();
    	}
    }
    
    @Timed("exercise.add")
    public ExerciseEntry addExercise(@RequestBody ExerciseEntry reqBody) {
    	Preconditions.checkArgument(reqBody != null, "No exercise object specified to add");
    	LOG.debug("reqBody: " + reqBody);
    	exerciseDao.addExercise(reqBody);
    	
    	//TODO handle unique constraints and return id
    	return reqBody;
    }
    
    @Timed("exercise.delete")
    public void deleteExercise(@RequestParam Long id) {
    	Preconditions.checkArgument(id != null, "No exercise id specified to delete");
    	LOG.debug("id: " + id);
    	exerciseDao.deleteExercise(id);
    }
}

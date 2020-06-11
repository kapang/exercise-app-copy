package kp.exercise.app.dao;

import java.util.List;
import kp.exercise.app.model.ExerciseEntry;

/**
 * The database access object for interacting w/ exercise database table
 * @author Karen Pang
 *
 */
public interface ExerciseDao {

	/**
	 * Retrieves all exercises
	 * 
	 * @return a list of all exercises
	 */
	public List<ExerciseEntry> getAllExercises();

	/**
	 * Adds a new exercise entry to the database
	 * 
	 * @param exercise - the exercise object to add to the database
	 */
	public void addExercise(ExerciseEntry exercise);

	/**
	 * Deletes a specified exercise by exercise id
	 * 
	 * @param id - the specified id to delete
	 */
	public void deleteExercise(Long id);
}

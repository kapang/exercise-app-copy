package kp.exercise.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.micrometer.core.annotation.Timed;
import kp.exercise.app.dao.mapper.ExerciseRowMapper;
import kp.exercise.app.model.ExerciseEntry;

/**
 * Implementation of the Exercise database access object using PostgresSQL Db
 * 
 * @author Karen Pang
 *
 */
@Repository
public class ExerciseDaoPostgresImpl implements ExerciseDao {

	// TODO add pagination
	private final static String GET_ALL_QUERY = "SELECT * FROM exercises LIMIT 100";
	
	private final static String ADD_QUERY = "INSERT INTO exercises "
			+ "(name, reps, sets, rest, category, subcategory, intensity, type) "
			+ "VALUES (:name, :reps, :sets, :rest, :category, :subcategory, :intensity, :type)";
	
	private final static String DELETE_QUERY = "DELETE FROM exercises "
			+ "WHERE id = :id";
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	private ExerciseRowMapper exerciseRowMapper;
	
    @Autowired
    public ExerciseDaoPostgresImpl(NamedParameterJdbcTemplate namedJdbcTemplate) {
    	this.jdbcTemplate = namedJdbcTemplate;
    	this.exerciseRowMapper = new ExerciseRowMapper();
    }
    
    @Timed
    @Transactional
    public List<ExerciseEntry> getAllExercises() {
    	return jdbcTemplate.getJdbcTemplate().query(GET_ALL_QUERY, exerciseRowMapper);
    }
    
    @Timed
    @Transactional
    public void addExercise(ExerciseEntry exercise) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", exercise.getName());
		paramMap.put("reps", exercise.getReps());
		paramMap.put("sets", exercise.getSets()); 
		paramMap.put("rest", exercise.getRestInSecs()); 
		paramMap.put("category", exercise.getCategory().name()); 
		paramMap.put("subcategory", exercise.getSubcategory().name()); 
		paramMap.put("intensity", exercise.getIntensityMode().name()); 
		paramMap.put("type", exercise.getType().name()); 
		
		jdbcTemplate.update(ADD_QUERY, paramMap);
    }
    
    @Timed
    @Transactional
    public void deleteExercise(Long id) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		jdbcTemplate.update(DELETE_QUERY, paramMap);
    }
    
}

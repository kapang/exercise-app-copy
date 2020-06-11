package kp.exercise.app.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kp.exercise.app.model.Category;
import kp.exercise.app.model.ExerciseEntry;
import kp.exercise.app.model.ExerciseType;
import kp.exercise.app.model.IntensityMode;
import kp.exercise.app.model.Subcategory;

/**
 * Exercise table database row mapper
 * 
 * @author Karen Pang
 *
 */
public class ExerciseRowMapper implements RowMapper<ExerciseEntry> {

	@Override
	public ExerciseEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExerciseEntry e = new ExerciseEntry();
		
		e.setId(rs.getLong("id"));
		e.setName(rs.getString("name"));
		e.setReps(rs.getInt("reps"));
		e.setSets(rs.getInt("sets"));
		e.setRestInSecs(rs.getInt("rest"));
		e.setType(ExerciseType.valueOf(rs.getString("type")));
		e.setCategory(Category.valueOf(rs.getString("category")));
		e.setSubcategory(Subcategory.valueOf(rs.getString("subcategory")));
		e.setIntensityMode(IntensityMode.valueOf(rs.getString("intensity")));
		
		return e;
	}

}

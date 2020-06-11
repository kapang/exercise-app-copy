package kp.exercise.app.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.LocalDate;
import org.springframework.jdbc.core.RowMapper;

import kp.exercise.app.model.ActivityEntry;

/**
 * RowMapper object for Activity database table object
 * 
 * @author Karen Pang
 *
 */
public class ActivityRowMapper implements RowMapper<ActivityEntry> {

	@Override
	public ActivityEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
		ActivityEntry entry = new ActivityEntry();
		
		entry.setPerson(rs.getString("person"));
		entry.setDate(new LocalDate(rs.getTimestamp("created_date")));
		entry.setActivtyType(rs.getString("activity_type"));
		
		return entry;
	}


}

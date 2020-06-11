package kp.exercise.app;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import com.google.common.collect.ImmutableList;

import kp.exercise.app.dao.ExerciseDao;
import kp.exercise.app.model.ExerciseEntry;
import kp.exercise.app.service.ExerciseService;

/**
 * Unit tests for {@link ExerciseService}
 * 
 * @author Karen Pang
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ExerciseServiceTest {

	@Mock
    private ExerciseDao exerciseDao;
    
    public ExerciseService service;

    @Before
    public void setup() {
    	service = new ExerciseService(exerciseDao);
    }

    @Test
    public void testGetAllExercise() {
    	ExerciseEntry expectedExercise = new ExerciseEntry();
    	ExerciseEntry expectedExercise2 = new ExerciseEntry();
    	List<ExerciseEntry> expectedResults = ImmutableList.of(expectedExercise, expectedExercise2);
    	
    	when(exerciseDao.getAllExercises()).thenReturn(expectedResults);
    	
    	List<ExerciseEntry> result = service.getExercises();
    	
    	assertThat(result, is(notNullValue()));
    	assertThat(result.size(), is(equalTo(expectedResults.size())));
    	assertThat(result, is(equalTo(expectedResults)));
    }
    
    @Test
    public void testGetAllExerciseNoResults() {
    	when(exerciseDao.getAllExercises()).thenThrow(new EmptyResultDataAccessException(1));
    	
    	List<ExerciseEntry> result = service.getExercises();
    	
    	assertThat(result, is(notNullValue()));
    	assertThat(result.isEmpty(), is(true));
    }
}

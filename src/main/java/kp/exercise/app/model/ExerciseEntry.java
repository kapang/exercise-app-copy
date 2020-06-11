package kp.exercise.app.model;

/**
 * POJO representing an exercise entry 
 * 
 * @author Karen Pang
 *
 */
public class ExerciseEntry {

	private Long id;
	private String name;
	private Integer reps;
	private Integer sets;
	private Integer restInSecs;
	private ExerciseType type;
	private Category category;
	private Subcategory subcategory;
	private IntensityMode intensityMode;
	
	public IntensityMode getIntensityMode() {
		return intensityMode;
	}

	public void setIntensityMode(IntensityMode intensityMode) {
		this.intensityMode = intensityMode;
	}

	public Integer getRestInSecs() {
		return restInSecs;
	}

	public Category getCategory() {
		return category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setRestInSecs(Integer restInSecs) {
		this.restInSecs = restInSecs;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Integer getSets() {
		return sets;
	}

	public ExerciseType getType() {
		return type;
	}


	public void setSets(Integer sets) {
		this.sets = sets;
	}

	public void setType(ExerciseType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps = reps;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Exercise [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", reps=");
		builder.append(reps);
		builder.append(", sets=");
		builder.append(sets);
		builder.append(", restInSecs=");
		builder.append(restInSecs);
		builder.append(", type=");
		builder.append(type);
		builder.append(", category=");
		builder.append(category);
		builder.append(", subcategory=");
		builder.append(subcategory);
		builder.append(", intensityMode=");
		builder.append(intensityMode);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intensityMode == null) ? 0 : intensityMode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reps == null) ? 0 : reps.hashCode());
		result = prime * result + ((restInSecs == null) ? 0 : restInSecs.hashCode());
		result = prime * result + ((sets == null) ? 0 : sets.hashCode());
		result = prime * result + ((subcategory == null) ? 0 : subcategory.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExerciseEntry other = (ExerciseEntry) obj;
		if (category != other.category)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intensityMode != other.intensityMode)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reps == null) {
			if (other.reps != null)
				return false;
		} else if (!reps.equals(other.reps))
			return false;
		if (restInSecs == null) {
			if (other.restInSecs != null)
				return false;
		} else if (!restInSecs.equals(other.restInSecs))
			return false;
		if (sets == null) {
			if (other.sets != null)
				return false;
		} else if (!sets.equals(other.sets))
			return false;
		if (subcategory != other.subcategory)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}

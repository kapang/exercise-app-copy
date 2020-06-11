package kp.exercise.app.model;

import org.joda.time.LocalDate;

/**
 * POJO representing an Activity entry in the database
 * 
 * @author Karen Pang
 *
 */
public class ActivityEntry {
	
	private String person;
	private LocalDate date;
	private String activtyType;

	public String getPerson() {
		return person;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getActivtyType() {
		return activtyType;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setActivtyType(String activtyType) {
		this.activtyType = activtyType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activtyType == null) ? 0 : activtyType.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		ActivityEntry other = (ActivityEntry) obj;
		if (activtyType == null) {
			if (other.activtyType != null)
				return false;
		} else if (!activtyType.equals(other.activtyType))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActivityDb [person=");
		builder.append(person);
		builder.append(", date=");
		builder.append(date);
		builder.append(", activtyType=");
		builder.append(activtyType);
		builder.append("]");
		return builder.toString();
	}
}

package kp.exercise.app.error;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.joda.time.format.ISODateTimeFormat;

/**
 * Custom error response POJO
 * 
 * @author Karen Pang
 *
 */
public class ErrorResponse {

	private String timestamp;

	private List<String>  errorDetails;

	private String path;

	public ErrorResponse(String path, List<String> errorDetails) {
		this.timestamp = ISODateTimeFormat.dateTime().print(LocalDateTime.now());
		this.errorDetails = errorDetails;
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(List<String> errorDetails) {
		this.errorDetails = errorDetails;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ErrorResponse [timestamp=" + timestamp + ", errorDetails=" + errorDetails + ", path=" + path + "]";
	}
}
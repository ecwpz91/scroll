import java.sql.Timestamp;
import java.util.Collection;

public interface LogEntry {

	public Timestamp getTime();
	public String getForm();
	public Collection<?> getNameValuePairs();
	public long getBytes();

}
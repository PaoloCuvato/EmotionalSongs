package emotionalsongs;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface InterfaceDB<T>
{
	Optional<T> get(Object id);
	List<T> getAll() throws IOException;
	void save(T t) throws IOException;
	boolean update(T base, T modified) throws IOException;
	boolean delete(T t) throws IOException;
}

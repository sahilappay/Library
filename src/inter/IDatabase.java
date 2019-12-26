package inter;

import java.util.List;

public interface IDatabase<T> {
    List<T> getAll() throws Exception;

    List<T> getAllByPS() throws Exception;

    int update(T obj) throws Exception;

    int insert(T obj) throws Exception;

    int delete(int id) throws Exception;
}

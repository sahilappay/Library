package inter;

import java.util.List;

public interface DatabaseInter<T> {
      List<T> getAll() throws Exception ;

      List<T> getAllByPS() throws Exception;

      boolean update(T obj) throws Exception;

      int insert(T obj) throws Exception;

      int delete(int id) throws Exception;
}

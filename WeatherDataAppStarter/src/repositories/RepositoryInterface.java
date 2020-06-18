package repositories;

import java.util.List;
import model.City;

public interface RepositoryInterface {

    /**
     *
     * @param item
     */
    void add(City item);

    /**
     *
     * @param id
     * @return
     */
    City getItem(int id);

    List<City> getItems();

    /**
     *
     * @param id
     */
    
    void remove(int id);

    void setItems(List<City> items);

    /**
     *
     * @param filename
     */
    
    void store(String filename);

    /**
     *
     * @return
     */
    @Override
    String toString();
    
}

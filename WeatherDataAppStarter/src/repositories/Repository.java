package repositories;

import daos.DAOObjImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import model.City;


public class Repository implements RepositoryInterface {
    private List<City> items;    
 
    
    
    public Repository() {
        this.items = new ArrayList<>();       
    }
    
    public Repository(List<City> items) {        
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        // Create dao and execute load  
         
        DAOObjImpl dao = new DAOObjImpl();
        this.items = dao.load(filename).getItems();         
    }

  
    
    
    @Override
    public List<City> getItems() {        
        return this.items;
    }
    
    @Override
    public void setItems(List<City> items) {        
        this.items = items;
    }
    
    @Override
    public void add(City item) {
        this.items.add(item);
    }
       
    @Override
    public void remove(int id) {
        Predicate<City> predicate = e->e.getId() == id;       
        this.items.removeIf(predicate);
    }
    
    @Override
    public City getItem(int id) {
        for (City item:this.items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }    
    
    @Override
    public void store(String filename) {       
        // create dao and execute store  
        DAOObjImpl dao = new DAOObjImpl();
        dao.store(filename, this);
    }        
}

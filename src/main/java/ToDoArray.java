import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 14.04.2017.
 */
public class ToDoArray {
    int count=1;
    ArrayList<ToDoList> todoList = new ArrayList<>();
    public int add(String TaskName){
        int id =count+1;
        todoList.add(new ToDoList(count,TaskName));
        return id;
    }
    List<ToDoList> view(){
        return todoList;
    }
    public void delete(int id){
        todoList.remove(id);
    }
}

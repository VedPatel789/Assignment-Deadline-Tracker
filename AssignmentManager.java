import java.util.ArrayList;
import java.util.Iterator;

public class AssignmentManager {

    private ArrayList<Assignment> list = new ArrayList<>();

    public void add(Assignment a) {
        list.add(a);
    }

    public ArrayList<Assignment> getAll() {
        return list;
    }

    public void markDone(String title) {
        for (Assignment a : list) {
            if (a.title.equalsIgnoreCase(title)) {
                a.completed = true;
                return;
            }
        }
    }

    public void delete(String title) {
        Iterator<Assignment> it = list.iterator();

        while (it.hasNext()) {
            Assignment a = it.next();
            if (a.title.equalsIgnoreCase(title)) {
                it.remove();
                return;
            }
        }
    }
}
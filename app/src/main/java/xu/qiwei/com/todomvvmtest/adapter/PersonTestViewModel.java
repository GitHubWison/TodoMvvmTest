package xu.qiwei.com.todomvvmtest.adapter;

import android.databinding.ObservableArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuqiwei on 17-2-16.
 */

public class PersonTestViewModel {
    public ObservableArrayList<PopWindowListAdapter.Person> persons = new ObservableArrayList<>();

    public PersonTestViewModel() {
        loadPersons();
    }

    public void loadPersons(){
        int count = 20;
        List<PopWindowListAdapter.Person> tempPersons = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tempPersons.add(new PopWindowListAdapter.Person(new StringBuffer("person").append(i).toString()));
        }
        persons.clear();
        persons.addAll(tempPersons);
    }

}

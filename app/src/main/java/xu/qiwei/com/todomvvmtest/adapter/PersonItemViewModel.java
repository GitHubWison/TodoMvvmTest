package xu.qiwei.com.todomvvmtest.adapter;

import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

/**
 * Created by xuqiwei on 17-2-16.
 */

public class PersonItemViewModel extends BaseObservable {
    public ObservableField<PopWindowListAdapter.Person> person = new ObservableField<>();
    public ObservableField<String> personname = new ObservableField<>();

    public PersonItemViewModel() {
        person.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                personname.set(person.get().getName());
            }
        });

    }
    public void setPerson(PopWindowListAdapter.Person person){
        this.person.set(person);
    }
    public void personNameClicked(View view){
        Log.e("personNameClicked","personNameClicked");
    }
}

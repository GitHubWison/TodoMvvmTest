package xu.qiwei.com.todomvvmtest.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import xu.qiwei.com.todomvvmtest.databinding.PersonSpinnerItemBinding;

/**
 * Created by xuqiwei on 17-2-16.
 */

public class PopWindowListAdapter extends BaseAdapter{
    private List<Person> persons;

    public PopWindowListAdapter(List<Person> persons) {
        this.persons = persons;
    }


    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PersonSpinnerItemBinding binding;
        if (view==null) {
            binding = PersonSpinnerItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);

        }else
        {
            binding = DataBindingUtil.getBinding(view);
        }
        PersonItemViewModel personItemViewModel = new PersonItemViewModel();
        binding.setViewmodel(personItemViewModel);
        personItemViewModel.setPerson(persons.get(i));
        return binding.getRoot();
    }

    public void replaceData(List<Person> persons) {
        this.persons = persons;
        notifyDataSetChanged();
    }


    public static class Person{
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

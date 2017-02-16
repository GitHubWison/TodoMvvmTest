package xu.qiwei.com.todomvvmtest.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xu.qiwei.com.todomvvmtest.databinding.FragmentTaskdetailBinding;
import xu.qiwei.com.todomvvmtest.tasks.Task;
import xu.qiwei.com.todomvvmtest.tasks.TaskItemNavigator;
import xu.qiwei.com.todomvvmtest.tasks.TasksFragment;

/**
 * Created by xuqiwei on 17-2-15.
 */

public class TaskDetailFragment extends Fragment {

    private FragmentTaskdetailBinding binding;
    private TaskDetailViewModel taskDetailViewModel;
    public static TaskDetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TaskDetailFragment fragment = new TaskDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setAdapter();
    }

    private void setAdapter() {
        TasksFragment.TaskAdapter taskAdapter = new TasksFragment.TaskAdapter(new ArrayList<Task>(0),getContext().getApplicationContext(),
                (TaskItemNavigator) getActivity());
        binding.testSpinner.setAdapter(taskAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTaskdetailBinding.inflate(inflater,container,false);
        binding.setViewmodel(taskDetailViewModel);
        return binding.getRoot();
    }

    public void setViewModel(TaskDetailViewModel taskDetailViewModel) {
        this.taskDetailViewModel = taskDetailViewModel;
    }

    @Override
    public void onResume() {
        super.onResume();
        taskDetailViewModel.loadTasks();
//        taskDetailViewModel.loadPersons();
    }
}

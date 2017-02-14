package xu.qiwei.com.todomvvmtest.tasks;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import xu.qiwei.com.todomvvmtest.R;
import xu.qiwei.com.todomvvmtest.databinding.FragmentTasksBinding;
import xu.qiwei.com.todomvvmtest.databinding.TaskItemLayoutBinding;

import static com.google.common.base.Preconditions.checkNotNull;

public class TasksFragment extends Fragment {
    private TasksListViewModel mTasksListViewModel;

    private FragmentTasksBinding binding;

    public static TasksFragment newInstance() {

        Bundle args = new Bundle();
        TasksFragment fragment = new TasksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mTasksListViewModel.loadTasks();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTasksBinding.inflate(inflater, container, false);
        binding.setViewmodel(checkNotNull(mTasksListViewModel, "mTasksListViewModel shouldn't be null"));
        return binding.getRoot();
    }

    public void setTasksListViewModel(@NotNull TasksListViewModel tasksListViewModel) {
        checkNotNull(tasksListViewModel);
        this.mTasksListViewModel = tasksListViewModel;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter();

        setUpFab();

    }

    private void setUpFab() {
        FloatingActionButton floadActButton = (FloatingActionButton)getActivity().findViewById(R.id.floatacbtn);
        floadActButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTasksListViewModel.toAddTaskActivity();
            }
        });
    }

    private void setListAdapter() {
        TaskAdapter taskAdapter = new TaskAdapter(new ArrayList<Task>(0),(TaskItemNavigator) getActivity());
        binding.taskListview.setAdapter(taskAdapter);
    }

    public static class TaskAdapter extends BaseAdapter {
        private TaskItemNavigator taskItemNavigator;
        private List<Task> tasks;

        public TaskAdapter(List<Task> tasks,TaskItemNavigator taskItemNavigator) {
            this.tasks = tasks;
            this.taskItemNavigator = taskItemNavigator;
        }

        @Override
        public int getCount() {
            return tasks.size();
        }

        @Override
        public Task getItem(int i) {
            return tasks.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Task task = tasks.get(i);
            TaskItemLayoutBinding binding;
            if (view == null) {
                binding = TaskItemLayoutBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            } else {
                binding = DataBindingUtil.getBinding(view);
            }
            TaskItemViewModel taskItemViewModel = new TaskItemViewModel(taskItemNavigator);
            binding.setViewmodel(taskItemViewModel);
            taskItemViewModel.setTask(task);
            return binding.getRoot();
        }
        public void replaceTasks(List<Task> tasks){
            setList(tasks);
        }
        private void setList(List<Task> tasks){
            this.tasks = tasks;
            notifyDataSetChanged();
        }
    }

}

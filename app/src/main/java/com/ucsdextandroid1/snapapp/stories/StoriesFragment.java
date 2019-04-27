package com.ucsdextandroid1.snapapp.stories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;



import java.util.List;

import com.ucsdextandroid1.snapapp.DataSources;
import com.ucsdextandroid1.snapapp.R;
import com.ucsdextandroid1.snapapp.util.WindowUtil;


/**
 * Created by rjaylward on 4/15/19
 */
public class StoriesFragment extends Fragment {

    public static StoriesFragment create() {
        return new StoriesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_story, container, false);

        View background = root.findViewById(R.id.fs_background);
        RecyclerView recyclerView = root.findViewById(R.id.fs_recycler_view);
        recyclerView.setClipToPadding(false);

        // this just adds padding to top of the views so they are not drawn under the status bar
        WindowUtil.doOnApplyWindowInsetsToMargins(background, true, false);
        WindowUtil.doOnApplyWindowInsetsToPadding(recyclerView, true, true);

        StoriesAdapter storiesAdapter = new StoriesAdapter();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return storiesAdapter.getSpanSize(position);
            }
        });

        //TODO create a grid layout manager with default span of 2 and the SpanSizeLookup for each type

        //TODO set up the recyclerView with the layoutManager and adapter
        recyclerView.setAdapter(storiesAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        //TODO add a callback to the adapter that calls the method onStoryClicked when the user clicks on the list item

        DataSources.getInstance().getStoryCards(new DataSources.Callback<List<Story>>() {
            @Override
            public void onDataFetched(List<Story> data) {
                //TODO set the data from the DataSource to the adapter
                storiesAdapter.setItems(getContext(),data);
            }
        });

        return root;
    }

    private void onStoryClicked(Story story) {

    }

}

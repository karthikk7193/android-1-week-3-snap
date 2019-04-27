package com.ucsdextandroid1.snapapp.stories;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ucsdextandroid1.snapapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaylward on 2019-04-20
 */
public class StoriesAdapter extends RecyclerView.Adapter {

    //TO DO The first thing your should do is finish the StoriesListItem class at the bottom

    private List<StoriesListItem> items = new ArrayList<>();

    public void setItems(Context context, List<Story> stories) {
        items.clear();

        //TO DO add title item to our list of StoriesListItems
        items.add(new StoriesListItem(context.getString(R.string.stories)));

        //TO DO add all of the story items to the list of StoriesListItems
        for (Story story : stories) {
            items.add(new StoriesListItem(story));
        }

        //TODO let the adapter know that  the data has changed
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TO DO return the correct view holder for each viewType. We want to return the
        // StoriesSectionTitleViewHolder for our title and the StoryCardViewHolder for our items.

        Log.d("StoriesAdapter", String.valueOf(viewType));
        switch(viewType) {
            case StoriesListItem.TYPE_TITLE:
                return StoriesSectionTitleViewHolder.inflate(parent);
            case StoriesListItem.TYPE_STORY:
                return StoryCardViewHolder.inflate(parent);
            default:
                throw new IllegalArgumentException("Unrecognized view type");
        }



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //TO DO bind the title or the story to the correct view holder
        if(holder instanceof StoriesSectionTitleViewHolder)
            ((StoriesSectionTitleViewHolder) holder).bind( items.get(position).getTitle() );
        else if(holder instanceof StoryCardViewHolder)
            ((StoryCardViewHolder) holder).bind( items.get(position).getStory() );
    }

    @Override
    public int getItemCount() {
        // TO DO return the correct item count
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        //TO DO return the correct view type
        return items.get(position).getType();
    }

    public int getSpanSize(int position) {
        switch(getItemViewType(position)) {
            case StoriesListItem.TYPE_TITLE:
                return 2;
            case StoriesListItem.TYPE_STORY:
                return 1;
            default:
                throw new IllegalArgumentException("Unrecognized view type");
        }
    }

    //TODO add a method that returns the correct span for each item type. It should take in the
    // int position and return an int representing either 1 or 2 depending on if the item is a title
    // or a story card item.

    //TODO add a custom interface called Callback that extends the click listener defined on the StoriesCardViewHolder

    //TODO finish creating a class that holds both the story and the title
    private class StoriesListItem {
        //TO DO you will need to add 2 constructors, one that takes in a String title, and another that
        // takes in a Story story. We need this data class to represent all the possibilities for
        // our list.
        public static final int TYPE_TITLE = 1;
        public static final int TYPE_STORY = 2;

        private String title = null;
        private Story story = null;
        private int type;

        public StoriesListItem (String title) {
            this.title = title;
            this.type = TYPE_TITLE;
        }
        public StoriesListItem (Story story){
            this.story = story;
            this.type = TYPE_STORY;
        }

        public Story getStory() {
            return story;
        }

        public String getTitle() {
            return title;
        }

        public int getType() {
            return type;
        }
    }

}

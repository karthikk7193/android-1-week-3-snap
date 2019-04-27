package com.ucsdextandroid1.snapapp.stories;

import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ucsdextandroid1.snapapp.R;


/**
 * Created by rjaylward on 2019-04-20
 */
public class StoryCardViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView titleView;
    private TextView subtitleView;

    private Story currentStory;
    private StoryCardClickListener listener;

    //TODO add a static method called inflate() that inflates the layout view_story_card
    public static StoryCardViewHolder inflate(ViewGroup parent) {
        return new StoryCardViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_story_card, parent, false));
    }


    public StoryCardViewHolder(@NonNull View itemView) {
        super(itemView);
        //TODO find all of the views
            imageView = itemView.findViewById(R.id.vsc_image_view);
            titleView = itemView.findViewById(R.id.vsc_title);
            subtitleView = itemView.findViewById(R.id.vsc_subtitle);
        //TODO add a click listener to the itemView that calls the custom click listener

        }

    public void bind(Story story) {
        //TODO set the currentStory

        //TODO load the imageUrl into the imageView using Picasso (http://square.github.io/picasso/)
        //the library has already been added to the project.

        //TODO set the title and the subtitle
    }

    //TODO add a method to set a StoryCardClickListener to this class

    public interface StoryCardClickListener {
        // TODO add a method to be called when the user clicks the card view
    }

}

package com.apps.newsapp.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.apps.newsapp.R;
import com.apps.newsapp.activities.model.WalkthroughModel;

import org.w3c.dom.Text;

import java.util.List;

public class WalkthroughAdapter extends PagerAdapter {
    private Context context;
    private List<WalkthroughModel> modelList;

    public WalkthroughAdapter(Context context, List<WalkthroughModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.walkthrough_item, null);

        ImageView imageView = layout.findViewById(R.id.image_intro);
        TextView txtTitle = layout.findViewById(R.id.txt_title);
        TextView txtDescription = layout.findViewById(R.id.txt_description);

        imageView.setImageResource(modelList.get(position).getImage());
        txtTitle.setText(modelList.get(position).getTitle());
        txtDescription.setText(modelList.get(position).getDesc());

        container.addView(layout);

        return layout;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

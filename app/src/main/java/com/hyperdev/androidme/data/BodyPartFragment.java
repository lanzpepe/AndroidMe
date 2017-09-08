package com.hyperdev.androidme.data;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;

import java.util.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartFragment extends Fragment {

    private ImageView mIvHead, mIvBody, mIvLegs;
    private List<Integer> mHeadList, mBodyList, mLegsList;

    public BodyPartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);
        
        findViews(view);
        bodyPartsList();
        setAndroidImageAssets();

        mIvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mHeadList.size(); i++) {
                    if (i == mHeadList.size() - 1)
                        i = 0;
                    else {
                        Drawable drawableHead = ResourcesCompat.getDrawable(getResources(), mHeadList.get(i), null);
                        mIvHead.setImageDrawable(drawableHead);
                    }
                }
            }
        });

        mIvBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mBodyList.size(); i++) {
                    if (i == mBodyList.size() - 1)
                        i = 0;
                    else {
                        Drawable drawableBody = ResourcesCompat.getDrawable(getResources(), mBodyList.get(i), null);
                        mIvBody.setImageDrawable(drawableBody);
                    }
                }
            }
        });

        mIvLegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mLegsList.size(); i++) {
                    if (i == mLegsList.size() - 1)
                        i = 0;
                    else {
                        Drawable drawableLegs = ResourcesCompat.getDrawable(getResources(), mLegsList.get(i), null);
                        mIvLegs.setImageDrawable(drawableLegs);
                    }
                }
            }
        });

        return view;
    }

    private void findViews(View view) {
        mIvHead = (ImageView) view.findViewById(R.id.ivHead);
        mIvBody = (ImageView) view.findViewById(R.id.ivBody);
        mIvLegs = (ImageView) view.findViewById(R.id.ivLegs);
    }

    private void bodyPartsList() {
        mHeadList = new ArrayList<>();
        mBodyList = new ArrayList<>();
        mLegsList = new ArrayList<>();
    }

    private void setAndroidImageAssets() {
        mHeadList = AndroidImageAssets.getHeads();
        mBodyList = AndroidImageAssets.getBodies();
        mLegsList = AndroidImageAssets.getLegs();
    }
}

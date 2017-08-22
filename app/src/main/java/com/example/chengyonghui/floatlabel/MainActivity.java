package com.example.chengyonghui.floatlabel;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LabelView mLabelView;
    private LabelView mLabelView2;
    private LabelView mLabelView3;
    private LabelView mLabelView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLabelView = (LabelView)findViewById(R.id.htv);
        mLabelView.setTags(getData());

        mLabelView2 = (LabelView)findViewById(R.id.htv2);
        mLabelView2.setTags(getData());

        mLabelView3 = (LabelView)findViewById(R.id.htv3);
        mLabelView3.setTags(getData());

        mLabelView4 = (LabelView)findViewById(R.id.htv4);
        mLabelView4.setTags(getData());

        //让不同的TagView有不同颜色
        int[] myColors = {Color.rgb(0x49, 0xC1, 0x20), Color.rgb(0xF0, 0x80, 0x80),
                Color.rgb(0xCD, 0xAA, 0x7D)};
        Random rand = new Random();
        ArrayList<LabelView.TagView> tagViews = (ArrayList<LabelView.TagView>)mLabelView4.getTagViews();
        for (LabelView.TagView tagView: tagViews) {
            int curColor = myColors[rand.nextInt(myColors.length)];
            tagView.setTextColor(curColor);
            tagView.setmLinePaintColor(curColor);
        }
    }

    public ArrayList<String> getData() {
        String[] labels = new String[]{
                "good", "apple", "yeah", "iphone", "ill",
                "sky", "tokyo", "sky tower",
        };
        ArrayList<String> tags = new ArrayList<String>();
        for (int i = 0; i < labels.length; i++) {
            tags.add(labels[i]);
        }

        return tags;
    }
}

package com.example.gallery;

import java.util.ArrayList;

public class Images {
    private ArrayList<Integer> imageId;
    public Images() {
        imageId = new ArrayList<Integer>();
        imageId.add(R.drawable.ic_launcher_background);
        imageId.add(R.drawable.ic_launcher_foreground);
        imageId.add(R.drawable.ic_launcher_foreground);
    }
    public ArrayList<Integer> getImageItem() {
        return imageId;
    }
}

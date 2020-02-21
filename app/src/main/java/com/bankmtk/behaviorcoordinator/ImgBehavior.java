package com.bankmtk.behaviorcoordinator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;

public class ImgBehavior extends CoordinatorLayout.Behavior<ImageView> {
    private float initialX = 0;
    private boolean firstMove = true;

    public ImgBehavior(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull ImageView child, @NonNull View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull ImageView child, @NonNull View dependency) {
        if (firstMove){
            firstMove = false;
            initialX = child.getX();
        }
        child.setX(initialX-dependency.getY()*1.5f);
        return false;
    }
}

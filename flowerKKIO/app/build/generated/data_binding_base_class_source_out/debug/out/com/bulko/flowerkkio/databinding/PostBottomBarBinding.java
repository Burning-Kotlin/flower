// Generated by view binder compiler. Do not edit!
package com.bulko.flowerkkio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bulko.flowerkkio.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PostBottomBarBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView bookmarkButton;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView likeButton;

  @NonNull
  public final BottomAppBar postBottomBar;

  private PostBottomBarBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView bookmarkButton, @NonNull ImageView imageView3,
      @NonNull ImageView likeButton, @NonNull BottomAppBar postBottomBar) {
    this.rootView = rootView;
    this.bookmarkButton = bookmarkButton;
    this.imageView3 = imageView3;
    this.likeButton = likeButton;
    this.postBottomBar = postBottomBar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PostBottomBarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PostBottomBarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.post_bottom_bar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PostBottomBarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bookmark_button;
      ImageView bookmarkButton = ViewBindings.findChildViewById(rootView, id);
      if (bookmarkButton == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.like_button;
      ImageView likeButton = ViewBindings.findChildViewById(rootView, id);
      if (likeButton == null) {
        break missingId;
      }

      id = R.id.post_bottom_bar;
      BottomAppBar postBottomBar = ViewBindings.findChildViewById(rootView, id);
      if (postBottomBar == null) {
        break missingId;
      }

      return new PostBottomBarBinding((ConstraintLayout) rootView, bookmarkButton, imageView3,
          likeButton, postBottomBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
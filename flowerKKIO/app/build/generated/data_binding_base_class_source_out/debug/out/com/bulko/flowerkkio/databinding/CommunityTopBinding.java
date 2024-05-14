// Generated by view binder compiler. Do not edit!
package com.bulko.flowerkkio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bulko.flowerkkio.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CommunityTopBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView backButton;

  @NonNull
  public final ImageView menuBar;

  @NonNull
  public final ImageView searchBar;

  @NonNull
  public final LinearLayout searchView;

  private CommunityTopBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView backButton,
      @NonNull ImageView menuBar, @NonNull ImageView searchBar, @NonNull LinearLayout searchView) {
    this.rootView = rootView;
    this.backButton = backButton;
    this.menuBar = menuBar;
    this.searchBar = searchBar;
    this.searchView = searchView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CommunityTopBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CommunityTopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.community_top, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CommunityTopBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back_button;
      ImageView backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.menu_bar;
      ImageView menuBar = ViewBindings.findChildViewById(rootView, id);
      if (menuBar == null) {
        break missingId;
      }

      id = R.id.search_bar;
      ImageView searchBar = ViewBindings.findChildViewById(rootView, id);
      if (searchBar == null) {
        break missingId;
      }

      id = R.id.search_view;
      LinearLayout searchView = ViewBindings.findChildViewById(rootView, id);
      if (searchView == null) {
        break missingId;
      }

      return new CommunityTopBinding((ConstraintLayout) rootView, backButton, menuBar, searchBar,
          searchView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

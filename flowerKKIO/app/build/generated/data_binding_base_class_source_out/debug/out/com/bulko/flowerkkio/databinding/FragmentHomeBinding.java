// Generated by view binder compiler. Do not edit!
package com.bulko.flowerkkio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bulko.flowerkkio.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CommunityTopBinding communityTop;

  @NonNull
  public final ImageView interest1;

  @NonNull
  public final ImageView interest2;

  @NonNull
  public final ImageView interest3;

  @NonNull
  public final ImageView interest4;

  @NonNull
  public final ImageView interest5;

  @NonNull
  public final ImageView interest6;

  @NonNull
  public final TextView interestText;

  @NonNull
  public final TextView interestText1;

  @NonNull
  public final TextView interestText2;

  @NonNull
  public final TextView interestText3;

  @NonNull
  public final TextView interestText4;

  @NonNull
  public final TextView interestText5;

  @NonNull
  public final TextView interestText6;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final NaviBarBinding naviView;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull CommunityTopBinding communityTop, @NonNull ImageView interest1,
      @NonNull ImageView interest2, @NonNull ImageView interest3, @NonNull ImageView interest4,
      @NonNull ImageView interest5, @NonNull ImageView interest6, @NonNull TextView interestText,
      @NonNull TextView interestText1, @NonNull TextView interestText2,
      @NonNull TextView interestText3, @NonNull TextView interestText4,
      @NonNull TextView interestText5, @NonNull TextView interestText6,
      @NonNull ConstraintLayout main, @NonNull NaviBarBinding naviView) {
    this.rootView = rootView;
    this.communityTop = communityTop;
    this.interest1 = interest1;
    this.interest2 = interest2;
    this.interest3 = interest3;
    this.interest4 = interest4;
    this.interest5 = interest5;
    this.interest6 = interest6;
    this.interestText = interestText;
    this.interestText1 = interestText1;
    this.interestText2 = interestText2;
    this.interestText3 = interestText3;
    this.interestText4 = interestText4;
    this.interestText5 = interestText5;
    this.interestText6 = interestText6;
    this.main = main;
    this.naviView = naviView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.community_top;
      View communityTop = ViewBindings.findChildViewById(rootView, id);
      if (communityTop == null) {
        break missingId;
      }
      CommunityTopBinding binding_communityTop = CommunityTopBinding.bind(communityTop);

      id = R.id.interest1;
      ImageView interest1 = ViewBindings.findChildViewById(rootView, id);
      if (interest1 == null) {
        break missingId;
      }

      id = R.id.interest2;
      ImageView interest2 = ViewBindings.findChildViewById(rootView, id);
      if (interest2 == null) {
        break missingId;
      }

      id = R.id.interest3;
      ImageView interest3 = ViewBindings.findChildViewById(rootView, id);
      if (interest3 == null) {
        break missingId;
      }

      id = R.id.interest4;
      ImageView interest4 = ViewBindings.findChildViewById(rootView, id);
      if (interest4 == null) {
        break missingId;
      }

      id = R.id.interest5;
      ImageView interest5 = ViewBindings.findChildViewById(rootView, id);
      if (interest5 == null) {
        break missingId;
      }

      id = R.id.interest6;
      ImageView interest6 = ViewBindings.findChildViewById(rootView, id);
      if (interest6 == null) {
        break missingId;
      }

      id = R.id.interest_text;
      TextView interestText = ViewBindings.findChildViewById(rootView, id);
      if (interestText == null) {
        break missingId;
      }

      id = R.id.interestText_1;
      TextView interestText1 = ViewBindings.findChildViewById(rootView, id);
      if (interestText1 == null) {
        break missingId;
      }

      id = R.id.interestText_2;
      TextView interestText2 = ViewBindings.findChildViewById(rootView, id);
      if (interestText2 == null) {
        break missingId;
      }

      id = R.id.interestText_3;
      TextView interestText3 = ViewBindings.findChildViewById(rootView, id);
      if (interestText3 == null) {
        break missingId;
      }

      id = R.id.interestText_4;
      TextView interestText4 = ViewBindings.findChildViewById(rootView, id);
      if (interestText4 == null) {
        break missingId;
      }

      id = R.id.interestText_5;
      TextView interestText5 = ViewBindings.findChildViewById(rootView, id);
      if (interestText5 == null) {
        break missingId;
      }

      id = R.id.interestText_6;
      TextView interestText6 = ViewBindings.findChildViewById(rootView, id);
      if (interestText6 == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.navi_view;
      View naviView = ViewBindings.findChildViewById(rootView, id);
      if (naviView == null) {
        break missingId;
      }
      NaviBarBinding binding_naviView = NaviBarBinding.bind(naviView);

      return new FragmentHomeBinding((ConstraintLayout) rootView, binding_communityTop, interest1,
          interest2, interest3, interest4, interest5, interest6, interestText, interestText1,
          interestText2, interestText3, interestText4, interestText5, interestText6, main,
          binding_naviView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

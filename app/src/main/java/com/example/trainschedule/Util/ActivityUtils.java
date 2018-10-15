package com.example.trainschedule.Util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * This provides methods to help Activities load their UI.
 */
public class ActivityUtils {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    public static void replaceFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId){
        fragmentManager.beginTransaction()
                .replace(frameId, fragment)
                .commitAllowingStateLoss();
    }

    //隐藏并添加Fragment
    public static void hideAndAddFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                    @NonNull Fragment fromFragment,
                                                    @NonNull Fragment toFragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fromFragment).add(frameId, toFragment).show(toFragment).commit();
    }

    //隐藏并显示Fragment
    public static void hideAndShowFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                     @NonNull Fragment fromFragment,
                                                     @NonNull Fragment toFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fromFragment).show(toFragment).commit();
    }

    public static void hideFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }

    public static void showFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(fragment);
        transaction.commit();
    }

}


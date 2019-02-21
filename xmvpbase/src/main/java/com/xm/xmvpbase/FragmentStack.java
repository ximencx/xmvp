package com.xm.xmvpbase;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class FragmentStack {

    private static int anim_In = R.anim.anim_fade_in;
    private static int anim_out = R.anim.anim_fade_out;

    /**
     * set Animations of Fragment about show or hide
     *
     * @param in_anim  show Animations
     * @param out_anim hide Animations
     */
    public static void setCustomAnimations(int in_anim, int out_anim) {
        anim_In = in_anim;
        anim_out = out_anim;
    }

    /**
     * put one fragment(which is contained by activity) into stack
     *
     * @param context     the activity
     * @param containerId fragment containerId
     * @param newFragment fragment object
     */
    public static void addFragmentToStack(FragmentActivity context,
                                          int containerId, Fragment newFragment) {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager
                .beginTransaction();
        ft.replace(containerId, newFragment, newFragment.getClass()
                .getSimpleName());
        ft.setCustomAnimations(anim_In, anim_out);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

    /**
     * @param mActivity
     */
    public static void popBackStack(FragmentActivity mActivity) {
        FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
        fragmentManager.popBackStack();
    }

    /**
     * @param context
     * @param containerId
     * @param newFragment
     */
    public static void addFragmentToStack(Fragment context, int containerId,
                                          Fragment newFragment) {
        FragmentManager fragmentManager = context.getFragmentManager();
        FragmentTransaction ft = fragmentManager
                .beginTransaction();
        ft.replace(containerId, newFragment, newFragment.getClass()
                .getSimpleName());
        ft.setCustomAnimations(anim_In, anim_out);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

    public static void replaceFragment(FragmentActivity context,
                                       int containerId, Fragment newFragment) {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager
                .beginTransaction();
        ft.setCustomAnimations(anim_In, anim_out);
        ft.replace(containerId, newFragment, newFragment.getClass()
                .getSimpleName());
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    public static void replaceChildFrament(Fragment context, int containerId,
                                           Fragment newFragment) {
        FragmentManager fragmentManager = context.getChildFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(containerId, newFragment,
                newFragment.getClass().getSimpleName()).commit();
    }

    public static void addChildFrament(Fragment context, int containerId,
                                       Fragment newFragment) {
        addChildFragmentByTag(context, containerId, newFragment, newFragment
                .getClass().getSimpleName());
    }

    public static void addChildFragmentByTag(Fragment context, int containerId,
                                             Fragment newFragment, String tag) {
        FragmentManager fragmentManager = context.getChildFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(containerId, newFragment, tag).commit();
    }

    public static void addFrament(FragmentActivity context, int containerId,
                                  Fragment newFragment) {
        try {
            FragmentManager fragmentManager = context.getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(anim_In, anim_out);
            ft.add(containerId, newFragment, newFragment.getClass().getSimpleName())
                    .commit();
        } catch (IllegalStateException e) {
            if (e.getMessage().startsWith("Fragment already added")) {
                removeFragment(context, newFragment);
                addFrament(context, containerId, newFragment);
            }
        }
    }

    public static void showFragment(FragmentActivity context, Fragment fragment) {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(anim_In, anim_out);
        ft.show(fragment).commit();
    }

    public static void showChildFragment(Fragment context, Fragment fragment) {
        FragmentManager fragmentManager = context.getChildFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(anim_In, anim_out);
        ft.show(fragment).commit();
    }

    public static void hideFragment(FragmentActivity context, Fragment fragment) {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.hide(fragment).commit();
    }

    /**
     * @param context
     * @param fragment
     */
    public static void hideChildFragment(Fragment context, Fragment fragment) {
        FragmentManager fragmentManager = context.getChildFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(anim_In, anim_out);
        ft.hide(fragment).commit();
    }

    public static void removeFragment(FragmentActivity context,
                                      Fragment fragment) {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(fragment).commit();
    }

    public static Fragment findFragment(FragmentActivity context,
                                        Class<?> fragment) {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        return fragmentManager.findFragmentByTag(fragment.getSimpleName());
    }

    public static Fragment findFragment(Fragment context, Class<?> fragment) {
        FragmentManager fragmentManager = context.getFragmentManager();
        return fragmentManager.findFragmentByTag(fragment.getSimpleName());
    }

    public static Fragment findChildFragment(Fragment context, Class<?> fragment) {
        return findChildFragmentByTag(context, fragment,
                fragment.getSimpleName());
    }

    public static Fragment findChildFragmentByTag(Fragment context,
                                                  Class<?> fragment, String tag) {
        FragmentManager fragmentManager = context.getChildFragmentManager();
        return fragmentManager.findFragmentByTag(tag);
    }

}

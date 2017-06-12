package com.owl.book.base;

import android.os.Bundle;

/**
 * FragmentEventListener for transition data with Fragment
 * Created by Imagine Owl on 2017/5/24.
 */

public interface FragmentEventListener {

    void dismiss(String target, Bundle extras);

    void handleDismiss(String src, Bundle extras);
}

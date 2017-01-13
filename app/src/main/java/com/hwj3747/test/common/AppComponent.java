package com.hwj3747.test.common;


import com.hwj3747.test.ui.test2.TestActivityFragment2;

import dagger.Component;

@Component(
        modules = AppModule.class
)
public interface AppComponent {
    TestActivityFragment2 inject(TestActivityFragment2 activity);
}

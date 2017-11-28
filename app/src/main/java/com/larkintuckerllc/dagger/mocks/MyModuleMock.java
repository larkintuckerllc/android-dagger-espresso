package com.larkintuckerllc.dagger.mocks;

import com.larkintuckerllc.dagger.MyExample;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class MyModuleMock {

    @Provides
    @Singleton
    static MyExample provideMyExample() {
        return new MyExampleImplMock();
    }

}

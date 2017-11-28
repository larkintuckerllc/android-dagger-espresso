package com.larkintuckerllc.dagger.mocks;

import com.larkintuckerllc.dagger.MyComponent;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = MyModuleMock.class)
public interface MyComponentMock extends MyComponent {
}

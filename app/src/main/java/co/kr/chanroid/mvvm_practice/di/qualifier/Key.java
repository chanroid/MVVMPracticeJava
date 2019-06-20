package co.kr.chanroid.mvvm_practice.di.qualifier;

import javax.inject.Qualifier;

@Qualifier
public @interface Key {
    String value() default "";
}

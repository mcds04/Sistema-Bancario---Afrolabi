package com.bancosystem;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.Annotation;

public class SpringBootApplicationImpl implements SpringBootApplication {
    @Override
    public Class<?>[] exclude() {
        return new Class[0];
    }

    @Override
    public String[] excludeName() {
        return new String[0];
    }

    @Override
    public String[] scanBasePackages() {
        return new String[0];
    }

    @Override
    public Class<?>[] scanBasePackageClasses() {
        return new Class[0];
    }

    @Override
    public Class<? extends BeanNameGenerator> nameGenerator() {
        return null;
    }

    @Override
    public boolean proxyBeanMethods() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}

package com.tdd.contas.config.core;

import org.springframework.context.ApplicationContext;

class EnvironmentRunner {

    @SuppressWarnings("unchecked")
    void run(Class<? extends EnvironmentRoot> environmentClass, ApplicationContext applicationContext) throws InstantiationException, IllegalAccessException {
        Class<? extends EnvironmentRoot> superclass = (Class<? extends EnvironmentRoot>) environmentClass.getSuperclass();
        if (!superclass.equals(EnvironmentRoot.class)) {
            run(superclass, applicationContext);
        }

        EnvironmentRoot environmentRoot = environmentClass.newInstance();
        environmentRoot.run(applicationContext);
    }

}

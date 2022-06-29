package com.comrades.app;


import com.comrades.app.core.bases.UseCase;
import com.comrades.app.core.bases.UseCaseManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringUseCaseManager implements UseCaseManager, BeanFactoryAware {

    private AutowireCapableBeanFactory beanFactory;

    @Autowired
    public SpringUseCaseManager() {
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (AutowireCapableBeanFactory) beanFactory;
    }

    @Override
    public void prepare(UseCase usecase) {

    }

    @Override
    public void complete(UseCase usecase) {

    }

    @Override
    public void destroy(UseCase usecase) {

    }
}



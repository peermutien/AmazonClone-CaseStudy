package com.capg.service;

import com.capg.repository.CartRepository;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class CartServiceApplicationTestsContextInitializer {
  public static void registerCartService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("cartService", CartService.class)
        .instanceSupplier((instanceContext) -> {
          CartService bean = new CartService();
          instanceContext.field("addToCartRepo", CartRepository.class)
              .invoke(beanFactory, (attributes) -> bean.addToCartRepo = attributes.get(0));
                  instanceContext.field("productDetailsProxy", ProductDetailsProxy.class)
                      .invoke(beanFactory, (attributes) -> bean.productDetailsProxy = attributes.get(0));
                          return bean;
                        }).register(beanFactory);
                  }
                }

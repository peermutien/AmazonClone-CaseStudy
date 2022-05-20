package com.capg.controller;

import com.capg.service.CartService;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class CartServiceApplicationTestsContextInitializer {
  public static void registerCartController(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("cartController", CartController.class)
        .instanceSupplier((instanceContext) -> {
          CartController bean = new CartController();
          instanceContext.field("addTocartService", CartService.class)
              .invoke(beanFactory, (attributes) -> bean.addTocartService = attributes.get(0));
                  return bean;
                }).register(beanFactory);
          }
        }

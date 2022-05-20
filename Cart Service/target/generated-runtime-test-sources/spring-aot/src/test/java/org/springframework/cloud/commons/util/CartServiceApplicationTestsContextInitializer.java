package org.springframework.cloud.commons.util;

import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class CartServiceApplicationTestsContextInitializer {
  public static void registerUtilAutoConfiguration_inetUtilsProperties(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("inetUtilsProperties", InetUtilsProperties.class).withFactoryMethod(UtilAutoConfiguration.class, "inetUtilsProperties")
        .instanceSupplier((instanceContext) -> {
          InetUtilsProperties bean = beanFactory.getBean(UtilAutoConfiguration.class).inetUtilsProperties();
          instanceContext.field("timeoutSeconds", int.class)
              .invoke(beanFactory, (attributes) -> {
                Field timeoutSecondsField = ReflectionUtils.findField(InetUtilsProperties.class, "timeoutSeconds", int.class);
                ReflectionUtils.makeAccessible(timeoutSecondsField);
                ReflectionUtils.setField(timeoutSecondsField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }
        }

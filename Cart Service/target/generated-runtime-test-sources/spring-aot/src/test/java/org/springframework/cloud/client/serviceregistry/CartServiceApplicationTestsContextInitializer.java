package org.springframework.cloud.client.serviceregistry;

import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class CartServiceApplicationTestsContextInitializer {
  public static void registerAutoServiceRegistrationAutoConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationAutoConfiguration", AutoServiceRegistrationAutoConfiguration.class)
        .instanceSupplier((instanceContext) -> {
          AutoServiceRegistrationAutoConfiguration bean = new AutoServiceRegistrationAutoConfiguration();
          instanceContext.field("autoServiceRegistration", AutoServiceRegistration.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> {
                Field autoServiceRegistrationField = ReflectionUtils.findField(AutoServiceRegistrationAutoConfiguration.class, "autoServiceRegistration", AutoServiceRegistration.class);
                ReflectionUtils.makeAccessible(autoServiceRegistrationField);
                ReflectionUtils.setField(autoServiceRegistrationField, bean, attributes.get(0));
              });
                  instanceContext.field("properties", AutoServiceRegistrationProperties.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field propertiesField = ReflectionUtils.findField(AutoServiceRegistrationAutoConfiguration.class, "properties", AutoServiceRegistrationProperties.class);
                        ReflectionUtils.makeAccessible(propertiesField);
                        ReflectionUtils.setField(propertiesField, bean, attributes.get(0));
                      });
                          return bean;
                        }).register(beanFactory);
                  }
                }

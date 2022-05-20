package org.springframework.cloud.openfeign;

import java.lang.reflect.Field;
import java.util.List;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class CartServiceApplicationTestsContextInitializer {
  public static void registerFeignAutoConfiguration_DefaultFeignTargeterConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.cloud.openfeign.FeignAutoConfiguration$DefaultFeignTargeterConfiguration", FeignAutoConfiguration.DefaultFeignTargeterConfiguration.class)
        .instanceSupplier(FeignAutoConfiguration.DefaultFeignTargeterConfiguration::new).register(beanFactory);
  }

  public static void registerDefaultFeignTargeterConfiguration_feignTargeter(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("feignTargeter", Targeter.class).withFactoryMethod(FeignAutoConfiguration.DefaultFeignTargeterConfiguration.class, "feignTargeter")
        .instanceSupplier(() -> beanFactory.getBean(FeignAutoConfiguration.DefaultFeignTargeterConfiguration.class).feignTargeter()).register(beanFactory);
  }

  public static void registerFeignAutoConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.cloud.openfeign.FeignAutoConfiguration", FeignAutoConfiguration.class)
        .instanceSupplier((instanceContext) -> {
          FeignAutoConfiguration bean = new FeignAutoConfiguration();
          instanceContext.field("configurations", List.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> {
                Field configurationsField = ReflectionUtils.findField(FeignAutoConfiguration.class, "configurations", List.class);
                ReflectionUtils.makeAccessible(configurationsField);
                ReflectionUtils.setField(configurationsField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }
        }

package org.springframework.boot.autoconfigure.data.mongo;

import com.mongodb.client.MongoClient;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoDatabaseFactorySupport;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

public final class CartServiceApplicationTestsContextInitializer {
  public static void registerMongoDataConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.data.mongo.MongoDataConfiguration", MongoDataConfiguration.class)
        .instanceSupplier(MongoDataConfiguration::new).register(beanFactory);
  }

  public static void registerMongoDataConfiguration_mongoMappingContext(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("mongoMappingContext", MongoMappingContext.class).withFactoryMethod(MongoDataConfiguration.class, "mongoMappingContext", ApplicationContext.class, MongoProperties.class, MongoCustomConversions.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(MongoDataConfiguration.class).mongoMappingContext(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }

  public static void registerMongoDataConfiguration_mongoCustomConversions(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("mongoCustomConversions", MongoCustomConversions.class).withFactoryMethod(MongoDataConfiguration.class, "mongoCustomConversions")
        .instanceSupplier(() -> beanFactory.getBean(MongoDataConfiguration.class).mongoCustomConversions()).register(beanFactory);
  }

  public static void registerMongoDatabaseFactoryConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.data.mongo.MongoDatabaseFactoryConfiguration", MongoDatabaseFactoryConfiguration.class)
        .instanceSupplier(MongoDatabaseFactoryConfiguration::new).register(beanFactory);
  }

  public static void registerMongoDatabaseFactoryConfiguration_mongoDatabaseFactory(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("mongoDatabaseFactory", MongoDatabaseFactorySupport.class).withFactoryMethod(MongoDatabaseFactoryConfiguration.class, "mongoDatabaseFactory", MongoClient.class, MongoProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(MongoDatabaseFactoryConfiguration.class).mongoDatabaseFactory(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerMongoDatabaseFactoryDependentConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.data.mongo.MongoDatabaseFactoryDependentConfiguration", MongoDatabaseFactoryDependentConfiguration.class).withConstructor(MongoProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new MongoDatabaseFactoryDependentConfiguration(attributes.get(0)))).register(beanFactory);
  }

  public static void registerMongoDatabaseFactoryDependentConfiguration_mongoTemplate(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("mongoTemplate", MongoTemplate.class).withFactoryMethod(MongoDatabaseFactoryDependentConfiguration.class, "mongoTemplate", MongoDatabaseFactory.class, MongoConverter.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(MongoDatabaseFactoryDependentConfiguration.class).mongoTemplate(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerMongoDatabaseFactoryDependentConfiguration_mappingMongoConverter(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("mappingMongoConverter", MappingMongoConverter.class).withFactoryMethod(MongoDatabaseFactoryDependentConfiguration.class, "mappingMongoConverter", MongoDatabaseFactory.class, MongoMappingContext.class, MongoCustomConversions.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(MongoDatabaseFactoryDependentConfiguration.class).mappingMongoConverter(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }

  public static void registerMongoDatabaseFactoryDependentConfiguration_gridFsTemplate(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("gridFsTemplate", GridFsTemplate.class).withFactoryMethod(MongoDatabaseFactoryDependentConfiguration.class, "gridFsTemplate", MongoDatabaseFactory.class, MongoTemplate.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(MongoDatabaseFactoryDependentConfiguration.class).gridFsTemplate(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }
}

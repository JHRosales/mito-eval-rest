package com.mitocode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.ReactiveMongoTransactionManager;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;

@Configuration
public class MongoConfig {

	@Autowired
	private MongoDbFactory mongoDbFactory;

	@Autowired
	private MongoMappingContext mongoMappingContext;
	
	@Bean
	public MappingMongoConverter mappingMongoConverter() {

		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		return converter;
	}
	
	//Transacciones mongo (bajo clusters)
	/*@Bean
	public TransactionalOperator transactionalOperator(ReactiveTransactionManager txm) {
		return TransactionalOperator.create(txm);
	}
	
	@Bean
	public ReactiveTransactionManager transactionManager(ReactiveMongoDatabaseFactory dbf) {
		return new ReactiveMongoTransactionManager(dbf);
	}*/
}

package com.oyorooms.converter;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class EntityToDtoConverter {
	private static MapperFacade mapper;

	static {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapper = mapperFactory.getMapperFacade();
	}

	public static <S, D> D map(S source, Class<D> destination) {
		if (source == null) {
			throw new NullPointerException("Enity is null ");
		}
		return mapper.map(source, destination);
	}

	public static <S, D> void map(S source, D destination) {
		mapper.map(source, destination);
	}
}

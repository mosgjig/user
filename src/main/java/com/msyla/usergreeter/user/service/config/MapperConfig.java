package com.msyla.usergreeter.user.service.config;

import com.msyla.usergreeter.user.core.entity.UserPreference;
import com.msyla.usergreeter.user.dto.UserPreferenceDto;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import static org.dozer.loader.api.FieldsMappingOptions.oneWay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    private static final String ID = "id";
    private static final String KEY = "key";

    @Bean
    public Mapper mapper() {
        DozerBeanMapper mapper = (DozerBeanMapper) DozerBeanMapperSingletonWrapper.getInstance();
        mapper.addMapping(mapping());
        return mapper;
    }

    private BeanMappingBuilder mapping() {
        return new BeanMappingBuilder() {

            @Override
            protected void configure() {
                mapping(UserPreference.class, UserPreferenceDto.class)
                        .fields(ID, KEY, oneWay());
            }
        };
    }
}

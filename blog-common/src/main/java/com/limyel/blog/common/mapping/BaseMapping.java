package com.limyel.blog.common.mapping;

import org.mapstruct.AfterMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Stream;

public interface BaseMapping<S, T> {

    /**
     * 正向映射
     * @param obj
     * @return
     */
    @InheritConfiguration
    T convertTo(S obj);

    /**
     * 反向映射
     * @param obj
     * @return
     */
    @InheritInverseConfiguration(name = "convertTo")
    S convertFrom(T obj);

    /**
     * 正向映射（List）
     * @param list
     * @return
     */
    List<T> convertTo(List<S> list);

    /**
     * 反向映射（List）
     * @param list
     * @return
     */
    List<S> convertFrom(List<T> list);

    @AfterMapping
    default void handleAfterConvertTo(S source, @MappingTarget T target) {
        afterConvertTo(source, target);
    }

    @AfterMapping
    default void hadnleAfterConvertFrom(T source, @MappingTarget S target) {
        afterConvertFrom(source, target);
    }

    /**
     * 正向映射的后置处理
     * @param source
     * @param target
     */
    @AfterMapping
    default void afterConvertTo(S source, T target) {

    }

    default void afterConvertFrom(T source, S target) {

    }

    @InheritConfiguration(name = "convertTo")
    Stream<T> convertTo(Stream<S> stream);

    @InheritConfiguration(name = "convertFrom")
    Stream<S> convertFrom(Stream<T> stream);

}

package com.flexit.spacetoursinc.common.base;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.List;

@ParametersAreNonnullByDefault
public interface Converter<T, V> {

    @Nonnull
    V convertEntityToVo(T t);

    @Nonnull
    List<V> convertEntityToVo(Collection<T> tList);

    @Nonnull
    T convertVoToEntity(V v);

    @Nonnull
    List<T> convertVoToEntity(Collection<V> vList);

    @Nonnull
    T updateEntityFromVo(T t, V v);
}

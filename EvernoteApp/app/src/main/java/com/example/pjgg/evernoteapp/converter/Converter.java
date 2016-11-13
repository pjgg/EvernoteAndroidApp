package com.example.pjgg.evernoteapp.converter;

import java.util.Collection;

public interface Converter<T,K> {

    T createDataTransferObject(K entity);

    Collection<T> createDataTransferObjects(Collection<K> applications);

}

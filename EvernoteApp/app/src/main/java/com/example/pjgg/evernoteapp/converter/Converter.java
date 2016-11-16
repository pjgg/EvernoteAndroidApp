package com.example.pjgg.evernoteapp.converter;

import java.util.Collection;
import java.util.List;

public interface Converter<T,K> {

    T createDataTransferObject(K entity);

    List<T> createDataTransferObjects(Collection<K> applications);

}

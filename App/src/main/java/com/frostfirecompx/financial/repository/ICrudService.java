package com.frostfirecompx.financial.repository;

public interface ICrudService<T> {
    String AddItem(T item);
    String DeleteItem(int itemId);
    String UpdateItem(T item);
}

package com.quantumjockey.melya.delegateinterfaces;

public interface Predicate<ArgOne, ArgTwo> {
    Boolean call(ArgOne a, ArgTwo b);
}

package com.quantumjockey.melya.delegateinterfaces;

public interface Action<ArgOne, ArgTwo> {
    Void call(ArgOne a, ArgTwo b);
}

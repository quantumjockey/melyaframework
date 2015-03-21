package com.quantumjockey.melya.delegateinterfaces;

public interface Func<ReturnType, ArgOne, ArgTwo> {
    ReturnType call(ArgOne a, ArgTwo b);
}

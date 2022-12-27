package net.matez.wildnature.common.block;

public interface BlockRegisterCallback<T,U extends WNBlock> {
    U register(T value);
}

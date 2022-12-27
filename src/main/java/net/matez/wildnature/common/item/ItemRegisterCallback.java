package net.matez.wildnature.common.item;

public interface ItemRegisterCallback<T,U extends IWNItem> {
    U register(T value);
}

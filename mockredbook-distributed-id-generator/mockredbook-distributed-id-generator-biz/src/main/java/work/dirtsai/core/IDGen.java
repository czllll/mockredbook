package work.dirtsai.core;


import work.dirtsai.core.common.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}

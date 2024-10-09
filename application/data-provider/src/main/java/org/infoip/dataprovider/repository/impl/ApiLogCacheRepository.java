package org.infoip.dataprovider.repository.impl;

import org.infoip.core.entity.ApiLog;
import org.infoip.dataprovider.repository.ApiLogRepository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ApiLogCacheRepository implements ApiLogRepository {
    private final List<ApiLog> apiLogs = new CopyOnWriteArrayList<>();
    private static ApiLogCacheRepository instance;

    public static synchronized ApiLogCacheRepository getInstance() {
        if (instance == null) {
            instance = new ApiLogCacheRepository();
        }
        return instance;
    }

    private ApiLogCacheRepository() {
    }

    @Override
    public void save(final ApiLog apiLog) {
        apiLogs.add(apiLog);
    }

    @Override
    public List<ApiLog> getAll() {
        return new CopyOnWriteArrayList<>(apiLogs);
    }
}

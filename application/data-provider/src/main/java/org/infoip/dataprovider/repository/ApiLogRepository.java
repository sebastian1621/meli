package org.infoip.dataprovider.repository;

import org.infoip.core.entity.ApiLog;

import java.util.List;

public interface ApiLogRepository {
    void save(ApiLog apiLog);
    List<ApiLog> getAll();
}

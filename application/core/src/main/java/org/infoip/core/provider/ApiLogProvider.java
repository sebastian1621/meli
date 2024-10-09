package org.infoip.core.provider;

import org.infoip.core.entity.ApiLog;

import java.util.List;

public interface ApiLogProvider {
    void saveLog(ApiLog apiLog);

    List<ApiLog> getAll();
}

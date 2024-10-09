package org.infoip.dataprovider.provider;

import org.infoip.core.entity.ApiLog;
import org.infoip.core.provider.ApiLogProvider;
import org.infoip.dataprovider.repository.ApiLogRepository;
import org.infoip.dataprovider.repository.impl.ApiLogCacheRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiLogProviderImpl implements ApiLogProvider {
    private final ApiLogRepository apiLogRepository = ApiLogCacheRepository.getInstance();

    @Override
    public void saveLog(final ApiLog apiLog) {
        apiLogRepository.save(apiLog);
    }

    @Override
    public List<ApiLog> getAll() {
        return apiLogRepository.getAll();
    }
}

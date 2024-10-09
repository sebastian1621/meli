package org.infoip.core.usecase.impl;

import org.infoip.core.entity.ApiLog;
import org.infoip.core.provider.ApiLogProvider;
import org.infoip.core.usecase.ReadApiLogUseCase;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class ReadApiLogUseCaseImpl implements ReadApiLogUseCase {
    private final ApiLogProvider apiLogProvider;

    public ReadApiLogUseCaseImpl(final ApiLogProvider apiLogProvider) {
        this.apiLogProvider = apiLogProvider;
    }

    @Override
    public double getAverage() {
        final List<ApiLog> apiLogs = apiLogProvider.getAll();
        return apiLogs.stream().mapToDouble(ApiLog::getDistance).sum() / apiLogs.size();
    }

    public double getMaxDistance() {
        return apiLogProvider.getAll().stream()
                .max(Comparator.comparingDouble(ApiLog::getDistance))
                .map(ApiLog::getDistance)
                .orElse(0.0);
    }

    public double getMinDistance() {
        return apiLogProvider.getAll().stream()
                .min(Comparator.comparingDouble(ApiLog::getDistance))
                .map(ApiLog::getDistance)
                .orElse(0.0);
    }
}

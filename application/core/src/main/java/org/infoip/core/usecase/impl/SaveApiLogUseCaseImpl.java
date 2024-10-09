package org.infoip.core.usecase.impl;

import org.infoip.core.entity.ApiLog;
import org.infoip.core.provider.ApiLogProvider;
import org.infoip.core.usecase.SaveApiLogUseCase;
import org.springframework.stereotype.Component;

@Component
public class SaveApiLogUseCaseImpl implements SaveApiLogUseCase {
    private final ApiLogProvider apiLogProvider;

    public SaveApiLogUseCaseImpl(final ApiLogProvider apiLogProvider) {
        this.apiLogProvider = apiLogProvider;
    }

    @Override
    public void saveLog(final ApiLog apiLog) {
        apiLogProvider.saveLog(apiLog);
    }
}

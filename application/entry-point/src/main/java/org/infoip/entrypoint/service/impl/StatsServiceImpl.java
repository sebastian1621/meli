package org.infoip.entrypoint.service.impl;

import org.infoip.core.usecase.ReadApiLogUseCase;
import org.infoip.entrypoint.service.StatsService;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {
    private final ReadApiLogUseCase readApiLogUseCase;

    public StatsServiceImpl(final ReadApiLogUseCase readApiLogUseCase) {
        this.readApiLogUseCase = readApiLogUseCase;
    }

    @Override
    public double getAverage() {
        return readApiLogUseCase.getAverage();
    }

    @Override
    public double getMaxDistance() {
        return readApiLogUseCase.getMaxDistance();
    }

    @Override
    public double getMinDistance() {
        return readApiLogUseCase.getMinDistance();
    }
}

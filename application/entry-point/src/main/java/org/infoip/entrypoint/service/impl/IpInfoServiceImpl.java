package org.infoip.entrypoint.service.impl;

import org.infoip.core.entity.IpInfo;
import org.infoip.core.exceptions.ExternalApiException;
import org.infoip.core.usecase.ReadIpInfoUseCase;
import org.infoip.entrypoint.controller.dto.IpInfoDto;
import org.infoip.entrypoint.service.IpInfoService;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Service
public class IpInfoServiceImpl implements IpInfoService {
    private final ReadIpInfoUseCase readIpInfo;

    public IpInfoServiceImpl(final ReadIpInfoUseCase readIpInfo) {
        this.readIpInfo = readIpInfo;
    }

    @Override
    public IpInfoDto getCountry(final String ip) throws ExternalApiException {
        final IpInfo ipInfo = readIpInfo.getIpInfo(ip);
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss z");
        return new IpInfoDto(
                ipInfo.getCountry(),
                ipInfo.getIsoCode(),
                ipInfo.getIsoName(),
                ipInfo.getLatitude(),
                ipInfo.getLongitude(),
                ipInfo.getDistance(),
                ipInfo.getLocation(),
                ipInfo.getLocalTime() != null ? ipInfo.getLocalTime().format(formatter) : "",
                ipInfo.getLocalTime() != null ? ipInfo.getLocalTime().withZoneSameInstant(ZoneOffset.UTC).format(formatter) : ""
        );
    }
}

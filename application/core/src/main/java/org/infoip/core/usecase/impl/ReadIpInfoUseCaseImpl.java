package org.infoip.core.usecase.impl;

import org.infoip.core.entity.ApiLog;
import org.infoip.core.entity.IpInfo;
import org.infoip.core.exceptions.ExternalApiException;
import org.infoip.core.provider.IpInfoProvider;
import org.infoip.core.usecase.ReadIpInfoUseCase;
import org.infoip.core.usecase.SaveApiLogUseCase;
import org.springframework.stereotype.Component;

@Component
public class ReadIpInfoUseCaseImpl implements ReadIpInfoUseCase {
    private final IpInfoProvider ipInfoProvider;
    private final SaveApiLogUseCase writeApiLogUseCase;

    private static final double LAT_BUENOS_AIRES = -34.611778259277344;
    private static final double LON_BUENOS_AIRES = -58.41730880737305;
    private static final int EARTH_RADIUS = 6371;

    public ReadIpInfoUseCaseImpl(final IpInfoProvider ipInfoProvider, final SaveApiLogUseCase writeApiLogUseCase) {
        this.ipInfoProvider = ipInfoProvider;
        this.writeApiLogUseCase = writeApiLogUseCase;
    }

    @Override
    public IpInfo getIpInfo(final String ip) throws ExternalApiException {
        final IpInfo ipInfo = ipInfoProvider.getIpInfo(ip);
        ipInfo.setDistance(calculateDistanceToBuenosAires(ipInfo.getLatitude(), ipInfo.getLongitude()));
        writeApiLogUseCase.saveLog(new ApiLog(ipInfo.getCountry(), ipInfo.getDistance()));
        return ipInfo;
    }

    private double calculateDistanceToBuenosAires(final double lat1, final double lon1) {
        final double latDifferenceRad = Math.toRadians(ReadIpInfoUseCaseImpl.LAT_BUENOS_AIRES - lat1);
        final double lonDifferenceRad = Math.toRadians(ReadIpInfoUseCaseImpl.LON_BUENOS_AIRES - lon1);
        final double lat1Rad = Math.toRadians(lat1);
        final double lat2Rad = Math.toRadians(ReadIpInfoUseCaseImpl.LAT_BUENOS_AIRES);
        final double haversineResult = Math.sin(latDifferenceRad / 2)
                * Math.sin(latDifferenceRad / 2)
                + Math.cos(lat1Rad)
                * Math.cos(lat2Rad)
                * Math.sin(lonDifferenceRad / 2)
                * Math.sin(lonDifferenceRad / 2);
        return EARTH_RADIUS * (2 * Math.atan2(Math.sqrt(haversineResult), Math.sqrt(1 - haversineResult)));
    }

}

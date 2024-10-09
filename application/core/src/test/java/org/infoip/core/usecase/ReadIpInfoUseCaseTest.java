package org.infoip.core.usecase;

import org.infoip.core.entity.ApiLog;
import org.infoip.core.entity.IpInfo;
import org.infoip.core.entity.Location;
import org.infoip.core.exceptions.ExternalApiException;
import org.infoip.core.provider.IpInfoProvider;
import org.infoip.core.usecase.impl.ReadIpInfoUseCaseImpl;
import org.junit.jupiter.api.AfterEach;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReadIpInfoUseCaseTest {

    @Mock
    private IpInfoProvider ipInfoProvider;

    @Mock
    private SaveApiLogUseCase writeApiLogUseCase;

    @InjectMocks
    private ReadIpInfoUseCaseImpl readIpInfoUseCase;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getIpInfo_ValidIp_ShouldReturnIpInfoAndLog() throws ExternalApiException {
        final String testIp = "83.44.196.93";
        final IpInfo mockIpInfo = new IpInfo(
                "Spain",
                "ES",
                "Europe",
                41.93029022216797,
                2.254349946975708,
                10515.542988813599,
                new Location(),
                ZonedDateTime.now()
        );
        mockIpInfo.setLatitude(41.93);
        mockIpInfo.setLongitude(2.25);
        mockIpInfo.setCountry("Spain");
        when(ipInfoProvider.getIpInfo(testIp)).thenReturn(mockIpInfo);

        final IpInfo result = readIpInfoUseCase.getIpInfo(testIp);

        assertNotNull(result);
        assertEquals("Spain", result.getCountry());
        verify(writeApiLogUseCase, times(1)).saveLog(any(ApiLog.class));
    }

    @Test
    void getIpInfo_ProviderThrowsException_ShouldPropagateException() throws ExternalApiException {
        final String testIp = "83.44.196.93";

        when(ipInfoProvider.getIpInfo(testIp)).thenThrow(new ExternalApiException(new Exception()));

        assertThrows(ExternalApiException.class, () -> readIpInfoUseCase.getIpInfo(testIp));
    }
}

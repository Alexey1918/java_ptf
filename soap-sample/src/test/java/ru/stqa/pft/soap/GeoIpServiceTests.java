package ru.stqa.pft.soap;


import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("192.168.5.242");
        System.out.println(ipLocation);
        assertEquals(ipLocation, "<GeoIP><Country>US</Country><State>CA</State></GeoIP>");
    }
}

package com.boot.custom;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

public class ActivityControllerTest {

  @Test
  public void decode() {
    DecodedJWT decode =
        JwtUtils.decode(
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.ew0KICAiYWN0aXZpdHlPYmplY3RJRCI6ICI3NjJkNTY5ZC1hMzRlLTQwZGEtYmU4Mi0yZWMxYWI3ZGViMDAiLA0KICAiaW50ZXJhY3Rpb25JZCI6ICI2YzIyNWMzYi0wN2RlLTQ3MTctOWNmNy1jZjk4NTE1NWQwNWEiLA0KICAib3JpZ2luYWxEZWZpbml0aW9uSWQiOiAiNjFkM2QzNmQtZjUzYy00NTBiLWExY2EtOGNhNDAwMzM5YmNlIiwNCiAgImludGVyYWN0aW9uS2V5IjogIjE3OWRmN2RkLTRkNzQtMDViMi05NDJhLWY1NjIzN2Y2MmQwZCIsDQogICJpbnRlcmFjdGlvblZlcnNpb24iOiAiNiINCn0.sYUbSpCxKVO3HLRPBzoRToZWwqHo9XIGcSLpCVrcWDY");
    decode.getPayload();
  }
}

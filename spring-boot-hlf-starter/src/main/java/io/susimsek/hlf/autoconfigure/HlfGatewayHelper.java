package io.susimsek.hlf.autoconfigure;


import io.susimsek.hlf.ca.user.FabricCAUser;
import io.susimsek.hlf.ca.user.service.FabricCAUserService;

final class HlfGatewayHelper {
    public static void registerFabricCAUserIfNotExists(FabricCAUserService fabricCAUserService, FabricCAUser fabricCAUser) throws Exception {
        if (!fabricCAUserService.userExist(fabricCAUser.getName())) {
            fabricCAUserService.enrollAdmin(fabricCAUser.getMspId());
            fabricCAUserService.registerAndEnrollUser(fabricCAUser.getMspId(), fabricCAUser.getName(), fabricCAUser.getAffiliation());
        }
    }
}

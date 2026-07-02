package dev.hybridlabs.fantasticfishery.platform;

import dev.hybridlabs.fantasticfishery.platform.services.ClientPlatformHelper;

import static dev.hybridlabs.fantasticfishery.platform.Services.load;

public class ClientServices {
    public static final ClientPlatformHelper PLATFORM = load(ClientPlatformHelper.class);
}

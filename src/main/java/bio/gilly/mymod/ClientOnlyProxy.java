package bio.gilly.mymod;

public class ClientOnlyProxy extends CommonProxy {
	public void preInit() {
		super.preInit();
		bio.gilly.mymod.simpleBlock.StartupOnlyClient.preInitClientOnly();
	}
	
	public void init() {
		super.init();
		bio.gilly.mymod.simpleBlock.StartupOnlyClient.initClientOnly();
	}
	
	public void postInit() {
		super.postInit();
		bio.gilly.mymod.simpleBlock.StartupOnlyClient.postInitClientOnly();
	}
	
	public boolean isDedicatedServer() {
		return false;
	}
}

package bio.gilly.mymod;

public class ClientOnlyProxy extends CommonProxy {
	public void preInit() {
		super.preInit();
		bio.gilly.mymod.simpleBlock.StartupClientOnly.preInitClientOnly();
		bio.gilly.mymod.partialBlock.StartupClientOnly.preInitClientOnly();
	}
	
	public void init() {
		super.init();
		bio.gilly.mymod.simpleBlock.StartupClientOnly.initClientOnly();
		bio.gilly.mymod.partialBlock.StartupClientOnly.initClientOnly();
	}
	
	public void postInit() {
		super.postInit();
		bio.gilly.mymod.simpleBlock.StartupClientOnly.postInitClientOnly();
		bio.gilly.mymod.partialBlock.StartupClientOnly.postInitClientOnly();
	}
	
	public boolean isDedicatedServer() {
		return false;
	}
}

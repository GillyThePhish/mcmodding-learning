package bio.gilly.mymod;

public abstract class CommonProxy {
	public void preInit() {
		bio.gilly.mymod.simpleBlock.StartupCommon.preInitCommon();
	}
	
	public void init() {
		bio.gilly.mymod.simpleBlock.StartupCommon.initCommon();
	}
	
	public void postInit() {
		bio.gilly.mymod.simpleBlock.StartupCommon.postInitCommon();
	}
	
	public abstract boolean isDedicatedServer();
}

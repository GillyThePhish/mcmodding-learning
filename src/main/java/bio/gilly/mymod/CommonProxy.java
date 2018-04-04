package bio.gilly.mymod;

public abstract class CommonProxy {
	public void preInit() {
		bio.gilly.mymod.simpleBlock.StartupCommon.preInitCommon();
		bio.gilly.mymod.partialBlock.StartupCommon.preInitCommon();
	}
	
	public void init() {
		bio.gilly.mymod.simpleBlock.StartupCommon.initCommon();
		bio.gilly.mymod.partialBlock.StartupCommon.initCommon();
	}
	
	public void postInit() {
		bio.gilly.mymod.simpleBlock.StartupCommon.postInitCommon();
		bio.gilly.mymod.partialBlock.StartupCommon.postInitCommon();
	}
	
	public abstract boolean isDedicatedServer();
}

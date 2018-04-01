package bio.gilly.mymod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = MyMod.MODID, name = MyMod.NAME, version = MyMod.VERSION)
public class MyMod {
	public static final String MODID = "mymod";
	public static final String NAME = "My Mod";
	public static final String VERSION = "0.0.1";
	
	@Mod.Instance(MyMod.MODID)
	public static MyMod instance;
	
	@SidedProxy(clientSide="bio.gilly.mymod.ClientOnlyProxy", serverSide="bio.gilly.mymod.DedicatedServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	
	public static String prependModID(String resource) {
		return MODID + ":" + resource;
	}
}

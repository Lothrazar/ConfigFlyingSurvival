package com.lothrazar.util;

import java.util.ArrayList;

import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;

public class Reference 
{ 
	public static final int TICKS_PER_SEC = 20;
	


 
	public static final int face_bottom = 0;	
	public static final int face_top = 1;
	public static final int face_north = 2;
	public static final int face_south = 3;
	public static final int face_west = 4;
	public static final int face_east = 5;
	
	
		// Items.skull
	public static final int skull_skeleton = 0;	
	public static final int skull_wither = 1;
	public static final int skull_zombie = 2;
	public static final int skull_player = 3;
	public static final int skull_creeper = 4;
	

	public static final int dye_incsac = 0;
	public static final int dye_red = 1;
	public static final int dye_cactus = 2;
	public static final int dye_cocoa = 3;
	public static final int dye_lapis = 4;
	public static final int dye_purple = 5;
	public static final int dye_cyan = 6;
	public static final int dye_lightgray = 7;
	public static final int dye_gray = 8;
	public static final int dye_pink = 9;
	public static final int dye_lime = 10;
	public static final int dye_dandelion = 11;
	public static final int dye_lightblue = 12;
	public static final int dye_magenta = 13;
	public static final int dye_orange = 14;
	public static final int dye_bonemeal = 15;
	
 
	public static final int CHEST_RARITY_COMMON = 100; 
	public static final int CHEST_RARITY_REDSTONE = 50;
	public static final int CHEST_RARITY_RECORD = 5;
	public static final int CHEST_RARITY_GAPPLE = 1;
	 
 
	//import net.minecraftforge.common.ChestGenHooks;
	public static String chest_mineshaftCorridor = "mineshaftCorridor"; 
	public static String chest_pyramidJungleChest= "pyramidJungleChest"; 
	public static String chest_pyramidDesertyChest= "pyramidDesertyChest"; 
	public static String chest_pyramidJungleDispenser= "pyramidJungleDispenser"; 
	public static String chest_strongholdCorridor= "strongholdCorridor"; 
	public static String chest_strongholdLibrary= "strongholdLibrary"; 
	public static String chest_strongholdCrossing= "strongholdCrossing";  
	public static String chest_villageBlacksmith= "villageBlacksmith"; 
	public static String chest_bonusChest= "bonusChest"; 
	public static String chest_dungeonChest= "dungeonChest";




	public static long ticksPerDay = 24000 ;
 
	/*s:

    MHF_Blaze
    MHF_CaveSpider
    MHF_Chicken
    MHF_Cow
    MHF_Enderman
    MHF_Ghast
    MHF_Golem
    MHF_Herobrine
    MHF_LavaSlime
    MHF_MushroomCow
    MHF_Ocelot
    MHF_Pig
    MHF_PigZombie
    MHF_Sheep
    MHF_Slime
    MHF_Spider
    MHF_Squid
    MHF_Villager
*/
	//TODO:
	//	player inv slots
	//zero o 8 is the hotbar
	//9 to 35 is the main inventory
	
	//100 to 103 is the armor
 
 
	public static final int stone_slab_stone = 0;
	public static final int stone_slab_sandstone = 1;
	public static final int stone_slab_oldwood = 2;
	public static final int stone_slab_cobble = 3;
	public static final int stone_slab_brickred = 4;
	public static final int stone_slab_stonebrick = 5;
	public static final int stone_slab_netehrbrick = 6;
	public static final int stone_slab_quartz = 7;
	
	public static final int stonebrick_stone = 0;
	public static final int stonebrick_mossy = 1;
	public static final int stonebrick_cracked = 2;
	public static final int stonebrick_chisel = 3;
	
	public static final int planks_oak = 0;
	public static final int planks_spruce = 1;
	public static final int planks_birch = 2;
	public static final int planks_jungle = 3;
	public static final int planks_acacia = 4;
	public static final int planks_darkoak = 5;
	 
	public static final int log_oak = 0;
	public static final int log_spruce = 1;
	public static final int log_birch = 2;
	public static final int log_jungle = 3;
	public static final int log2_acacia = 0;
	public static final int log2_darkoak = 5;
	
	public static final int sapling_oak = 0;
	public static final int sapling_spruce = 1;
	public static final int sapling_birch = 2;
	public static final int sapling_jungle = 3;
	public static final int sapling_acacia = 4;
	public static final int sapling_darkoak = 5;
	 
	public static final int quartz_block = 0;
	public static final int quartz_chiselled = 1;
	public static final int quartz_pillar = 2;
	
	public static final int cobblestone_wall_plain = 0;
	public static final int cobblestone_wall_mossy = 1;
	
	public static final int potion_SPEED = 1;
	public static final int potion_SLOWNESS = 2;
	public static final int potion_HASTE = 3;
	public static final int potion_FATIGUE = 4; 
 	public static final int potion_STRENGTH = 5;
	public static final int potion_instanthealth = 6; 
	public static final int potion_instantdamage = 7;//both would not work in runestones		
	public static final int potion_JUMP = 8;
	public static final int potion_NAUSEA = 9;
	public static final int potion_REGEN = 10;
	public static final int potion_RESISTANCE = 11;
	public static final int potion_FIRERESIST = 12;
	public static final int potion_WATER_BREATHING = 13;
	public static final int potion_INVIS = 14;
	public static final int potion_BLINDNESS = 15; 
	public static final int potion_NIGHT_VISION = 16; 
	public static final int potion_HUNGER = 17; 
	public static final int potion_WEAKNESS = 18; 
	public static final int potion_POISON = 19;
	public static final int potion_WITHER = 20;
	public static final int potion_HEALTH_BOOST = 21;
	public static final int potion_absorption = 22;// is absorption; like 21 but they vanish like gold apple hearts
	public static final int potion_SATURATION = 23;//fills hunger
	
	public static final int entity_cow = 92;
	public static final int entity_pig = 90;
	public static final int entity_sheep = 91;
	public static final int entity_chicken = 93;
	public static final int entity_mooshroom = 96;
	public static final int entity_bat = 65;
	
	
	public class PlayerInventory
	{
		public static final int ROWS = 3;
		public static final int COLS = 9;
		public static final int SIZE = ROWS*COLS;
		public static final int START = 9;//top left
		public static final int END = START + SIZE;
	}
 
//	public static final String gamerule_commandBlockOutput = "commandBlockOutput";
	public class FurnaceBurnTime // inner class
	{
		public static final int Sticks = 100;
		public static final int WoodenSlabs = 150;
		public static final int WoodenTools = 200;
		public static final int WoodStuff = 300;
		public static final int Coal = 1600; 
		public static final int LavaBucket = 20000;
		public static final int Sapling = 100;
		public static final int BlazeRod = 2400;
				
	}
	public static class gamerule
	{
		public final static String commandBlockOutput  = "commandBlockOutput";
		public static final String doDaylightCycle = "doDaylightCycle";
		public static final String doFireTick = "doFireTick";
		public static final String doMobLoot = "doMobLoot";
		public static final String doMobSpawning = "doMobSpawning";
		public static final String doTileDrops = "doTileDrops";
		public static final String keepInventory = "keepInventory";
		public static final String mobGriefing = "mobGriefing";
		public static final String naturalRegeneration = "naturalRegeneration";
	}
	//public static struct tallgrass{
 
	public static class grassplant
	{
		public final static int deadbush=0;
		public final static int grass=1;
		public final static int fern=2;
	} 
 

	//is struct
	public static class tallgrass
	{
		public final static int sunflower = 0;
		public final static int lilac=1;
		public final static int grass=2;
		public final static int fern=3;
		public final static int rosebush=4;
		public final static int peony=5;
		
	}  
}//ends class reference
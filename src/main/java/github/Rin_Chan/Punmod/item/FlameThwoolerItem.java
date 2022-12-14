package github.Rin_Chan.Punmod.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import github.Rin_Chan.Punmod.util.ModItemGroup;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FlameThwoolerItem extends Item {
	private int durabilityUsedFromProjectile = 5;
	private final Random rand = new Random();
	
	public FlameThwoolerItem() {
		super(new Item.Properties().stacksTo(1).durability(600).tab(ModItemGroup.PUN_MOD));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		List<Item> woolList = new ArrayList<Item>();
		woolList.add(Items.BLACK_WOOL);
		woolList.add(Items.BLUE_WOOL);
		woolList.add(Items.BROWN_WOOL);
		woolList.add(Items.CYAN_WOOL);
		woolList.add(Items.GRAY_WOOL);
		woolList.add(Items.GREEN_WOOL);
		woolList.add(Items.LIGHT_BLUE_WOOL);
		woolList.add(Items.LIGHT_GRAY_WOOL);
		woolList.add(Items.LIME_WOOL);
		woolList.add(Items.MAGENTA_WOOL);
		woolList.add(Items.ORANGE_WOOL);
		woolList.add(Items.PINK_WOOL);
		woolList.add(Items.PURPLE_WOOL);
		woolList.add(Items.RED_WOOL);
		woolList.add(Items.WHITE_WOOL);
		woolList.add(Items.YELLOW_WOOL);
		
		ItemStack woolItemstack = ItemStack.EMPTY;
		 for (ItemStack item : player.getInventory().items) {
		 	if (woolList.contains(item.getItem())) {
		 		woolItemstack = item;
		 		break;
			}
		}
		
		if (woolItemstack.isEmpty() && !player.getAbilities().instabuild) {
			return InteractionResultHolder.fail(itemstack);
		}
		
		player.startUsingItem(hand);
		
		int range = 3;
        Vec3 lookingAt = getLookingAt((Player) player, range);
        List<BlockPos> coords = collect((Player) player, lookingAt, level);
        List<Entity> entities = level.getEntities(player, player.getBoundingBox().expandTowards(3*range, 3*range, 3*range), (val) -> true);
        
		if (!level.isClientSide) {
			for (BlockPos coord:coords) {
				spawnFireParticle(coord, (ServerLevel) player.level);
				
				for (Entity entity:entities) {
					if ((coord.getX()+1 > entity.getBlockX()) && (entity.getBlockX() > coord.getX()-1) && (coord.getY()+5 > entity.getBlockY()) && (entity.getBlockY() > coord.getY()-5) && (coord.getZ()+1 > entity.getBlockZ()) && (entity.getBlockZ() > coord.getZ()-1)) {
						entity.hurt(DamageSource.ON_FIRE, 4);
						entity.setSecondsOnFire(entity.getRemainingFireTicks() + 4);
					}
				}
			}
        }
		
		if (!player.getAbilities().instabuild) {
			itemstack.hurtAndBreak(durabilityUsedFromProjectile, player, e -> e.broadcastBreakEvent(hand));
			
			woolItemstack.shrink(1);
            if (woolItemstack.isEmpty()) {
               player.getInventory().removeItem(woolItemstack);
            }
		}
		
        return InteractionResultHolder.pass(itemstack);
	}
	
	private void spawnFireParticle(BlockPos sourcePos, ServerLevel world) {
        double randomTX = rand.nextDouble();
        double randomTY = rand.nextDouble();
        double randomTZ = rand.nextDouble();
        world.sendParticles(ParticleTypes.FLAME, sourcePos.getX() + randomTX, sourcePos.getY() + randomTY, sourcePos.getZ() + randomTZ, 1, 0D, 0D, 0D, 0.0D);
    }
	
	public static Vec3 getLookingAt(Player player, int range) {
        Vec3 look = player.getLookAngle();
        Vec3 end = new Vec3(player.getX() + look.x * (double) range, player.getY() + player.getEyeHeight() + look.y * (double) range, player.getZ() + look.z * (double) range);
        return end;
    }
	
	public static List<BlockPos> collect(Player player, Vec3 blockEnd, Level world) {
        List<BlockPos> coordinates = new ArrayList<>();
        
        // Using Bresenham's Algorithm (with reference to https://www.geeksforgeeks.org/bresenhams-algorithm-for-3-d-line-drawing/)
        Vec3 playerStart = new Vec3(player.getX(), player.getY() + player.getEyeHeight(), player.getZ());
        Direction direction = player.getDirection();
        
        Axis axis = direction.getAxis();
        if (axis == Axis.X) {
        	playerStart = new Vec3(player.getX()+1, player.getY() + player.getEyeHeight(), player.getZ());
        }
        else if (axis == Axis.Z) {
        	playerStart = new Vec3(player.getX(), player.getY() + player.getEyeHeight(), player.getZ()+1);
        }
        else {
        	playerStart = new Vec3(player.getX(), player.getY() + player.getEyeHeight()+1, player.getZ());
        }
        
        double playerX = playerStart.x;
        double playerY = playerStart.y;
        double playerZ = playerStart.z;
        double blockX = blockEnd.x;
        double blockY = blockEnd.y;
        double blockZ = blockEnd.z;
        
        coordinates.add(new BlockPos(new Vec3(playerX, playerY, playerZ)));
        
        double xs = -0.1;
        double ys = -0.1;
        double zs = -0.1;
        double dx = Math.abs(blockX - playerX);
        double dy = Math.abs(blockY - playerY);
        double dz = Math.abs(blockZ - playerZ);
        double p1;
        double p2;
        
        if (blockX > playerX) {
        	xs = 0.1;
        }
        if (blockY > playerY) {
        	ys = 0.1;
        }
        if (blockZ > playerZ) {
        	zs = 0.1;
        }
        
        // Driving axis is X-axis
        if ((dx >= dy) && (dx >= dz)) {
        	p1 = 2 * dy - dx;
        	p2 = 2 * dz - dx;
        	
        	if (playerX > blockX) {
	        	while (playerX > blockX) {
	        		playerX += xs;
	        		if (p1 >= 0) {
	        			playerY += ys;
	        			p1 -= 2 * dx;
	        		}
	        		if (p2 >= 0) {
	        			playerZ += zs;
	        			p2 -= 2 * dx;
	        		}
	        		p1 += 2 * dy;
	        		p2 += 2 * dz;
	        		
	        		coordinates.add(new BlockPos(new Vec3(playerX, playerY, playerZ)));
	        	}
        	}
        	else {
        		while (playerX < blockX) {
	        		playerX += xs;
	        		if (p1 >= 0) {
	        			playerY += ys;
	        			p1 -= 2 * dx;
	        		}
	        		if (p2 >= 0) {
	        			playerZ += zs;
	        			p2 -= 2 * dx;
	        		}
	        		p1 += 2 * dy;
	        		p2 += 2 * dz;
	        		
	        		coordinates.add(new BlockPos(new Vec3(playerX, playerY, playerZ)));
	        	}
        	}
        }
        // Driving axis is Y-axis
        else if ((dy >= dx) && (dy >= dz)) {
        	p1 = 2 *dx - dy;
        	p2 = 2 * dz - dy;
        	
        	if (playerY > blockY) {
	        	while (playerY > blockY) {
	        		playerY += ys;
	        		if (p1 >= 0) {
	        			playerX += xs;
	        			p1 -= 2 * dy;
	        		}
	        		if (p2 >= 0) {
	        			playerZ += zs;
	        			p2 -= 2 * dy;
	        		}
	        		p1 += 2 * dx;
	        		p2 += 2 * dz;
	        		
	        		coordinates.add(new BlockPos(new Vec3(playerX, playerY, playerZ)));
	        	}
        	}
        	else {
        		while (playerY < blockY) {
	        		playerY += ys;
	        		if (p1 >= 0) {
	        			playerX += xs;
	        			p1 -= 2 * dy;
	        		}
	        		if (p2 >= 0) {
	        			playerZ += zs;
	        			p2 -= 2 * dy;
	        		}
	        		p1 += 2 * dx;
	        		p2 += 2 * dz;
	        		
	        		coordinates.add(new BlockPos(new Vec3(playerX, playerY, playerZ)));
	        	}
        	}
        }
        // Driving axis is Z-axis
        else {
        	p1 = 2 * dy - dz;
        	p2 = 2 * dx - dz;
        	
        	if (playerZ > blockZ) {
	        	while (playerZ > blockZ) {
	        		playerZ += zs;
	        		if (p1 >= 0) {
	        			playerY += ys;
	        			p1 -= 2 * dz;
	        		}
	        		if (p2 >= 0) {
	        			playerX += xs;
	        			p2 -= 2 * dz;
	        		}
	        		p1 += 2 * dy;
	        		p2 += 2 * dx;
	        		
	        		coordinates.add(new BlockPos(new Vec3(playerX, playerY, playerZ)));
	        	}
        	}
        	else {
        		while (playerZ < blockZ) {
	        		playerZ += zs;
	        		if (p1 >= 0) {
	        			playerY += ys;
	        			p1 -= 2 * dz;
	        		}
	        		if (p2 >= 0) {
	        			playerX += xs;
	        			p2 -= 2 * dz;
	        		}
	        		p1 += 2 * dy;
	        		p2 += 2 * dx;
	        		
	        		coordinates.add(new BlockPos(new Vec3(playerX, playerY, playerZ)));
	        	}
        	}
        }
        
        return coordinates.stream().collect(Collectors.toList());
    }
}

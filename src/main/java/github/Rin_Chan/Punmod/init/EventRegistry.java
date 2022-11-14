package github.Rin_Chan.Punmod.init;

import github.Rin_Chan.Punmod.event.TheUltimateBlockEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class EventRegistry {
	public static void onTickPlayerEvent(PlayerTickEvent event) {
		TheUltimateBlockEvent.onTickPlayerEvent(event);
	}
}

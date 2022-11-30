package github.Rin_Chan.Punmod.init;

import github.Rin_Chan.Punmod.event.BreakFastEvent;
import github.Rin_Chan.Punmod.event.DyemondArmorEvent;
import github.Rin_Chan.Punmod.event.EndDyemondArmorEvent;
import github.Rin_Chan.Punmod.event.HammerEvent;
import github.Rin_Chan.Punmod.event.LuxDyemondArmorEvent;
import github.Rin_Chan.Punmod.event.TheUltimateBlockEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class EventRegistry {
	public static void onTickPlayerEvent(PlayerTickEvent event) {
		TheUltimateBlockEvent.onTickPlayerEvent(event);
		BreakFastEvent.onTickPlayerEvent(event);
		DyemondArmorEvent.onTickPlayerEvent(event);
		EndDyemondArmorEvent.onTickPlayerEvent(event);
		LuxDyemondArmorEvent.onTickPlayerEvent(event);
		HammerEvent.onTickPlayerEvent(event);
	}
}

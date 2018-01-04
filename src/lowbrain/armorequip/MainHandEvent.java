package lowbrain.armorequip;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

public final class MainHandEvent extends PlayerEvent implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private boolean cancel = false;
	private final HandMethod equipType;
	private ItemStack oldItem, newItem;

	/**
	 * Constructor for the ArmorEquipEvent.
	 *
	 * @param player The player who put on / removed the armor.
	 * @param oldItem The ItemStack of the armor removed.
	 * @param newItem The ItemStack of the armor added.
	 */
	public MainHandEvent(final Player player, final HandMethod equipType, final ItemStack oldItem, final ItemStack newItem){
		super(player);
		this.equipType = equipType;
		this.newItem = newItem;
		this.oldItem = oldItem;
	}

	/**
	 * Gets a list of handlers handling this event.
	 *
	 * @return A list of handlers handling this event.
	 */
	@Contract(pure = true)
    public final static HandlerList getHandlerList(){
		return handlers;
	}

	/**
	 * Gets a list of handlers handling this event.
	 *
	 * @return A list of handlers handling this event.
	 */
	@Contract(pure = true)
    @Override
	public final HandlerList getHandlers(){
		return handlers;
	}

	/**
	 * Sets if this event should be cancelled.
	 *
	 * @param cancel If this event should be cancelled.
	 */
	public final void setCancelled(final boolean cancel){
		this.cancel = cancel;
	}

	/**
	 * Gets if this event is cancelled.
	 *
	 * @return If this event is cancelled
	 */
	@Contract(pure = true)
    public final boolean isCancelled(){
		return cancel;
	}

	/**
	 * Returns the last equipped armor piece, could be a piece of armor, Air, or null.
	 */
	@Contract(pure = true)
    public final ItemStack getOldItem(){
		return this.oldItem;
	}

	public final void setOldItem(final ItemStack oldArmorPiece){
		this.oldItem = oldArmorPiece;
	}

	/**
	 * Returns the newly equipped armor, could be a piece of armor, MaterialAir, or null.
	 */
	@Contract(pure = true)
    public final ItemStack getNewItem(){
		return this.newItem;
	}

	public final void setNewItem(final ItemStack newArmorPiece){
		this.newItem = newArmorPiece;
	}

	/**
	 * Gets the method used to either equip or unequip an armor piece.
	 */
	@Contract(pure = true)
    public HandMethod getMethod(){
		return equipType;
	}

	public enum HandMethod {
	    HELD_SWITCH,
	    CRAFTED,
	    PICK_UP,
	    DROP,
	    HOT_BAR,
		HELD_SWAP,
		/**
		 * When in range of a dispenser that shoots an armor piece to equip.
		 */
		DISPENSER,
		/**
		 * When an armor piece breaks to unequip
		 */
		BROKE,
		/**
		 * When you die causing all armor to unequip
		 */
		DEATH,
		;
	}
}
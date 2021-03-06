package ganymedes01.ganyssurface.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.ganyssurface.GanysSurface;
import ganymedes01.ganyssurface.IConfigurable;
import ganymedes01.ganyssurface.core.utils.Utils;
import ganymedes01.ganyssurface.lib.Strings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * Gany's Surface
 *
 * @author ganymedes01
 *
 */

public class PrismarineItems extends Item implements IConfigurable {

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public PrismarineItems() {
		setMaxDamage(0);
		setHasSubtypes(true);
		setUnlocalizedName(Utils.getUnlocalisedName(Strings.PRISMARINE_ITEMS));
		setCreativeTab(GanysSurface.enablePrismarineStuff ? GanysSurface.surfaceTab : null);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + stack.getItemDamage();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return icons[Math.max(Math.min(meta, icons.length - 1), 0)];
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getSubItems(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < 2; i++)
			list.add(new ItemStack(item, 1, i));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		icons = new IIcon[2];
		icons[0] = reg.registerIcon("prismarine_shard");
		icons[1] = reg.registerIcon("prismarine_crystals");
	}

	@Override
	public boolean isEnabled() {
		return GanysSurface.enablePrismarineStuff;
	}
}
package me.shedaniel.rei.mixin;

//@Mixin(GuiContainer.class)
//public class MixinGuiContainer extends GuiScreen implements IMixinGuiContainer {
//
//    @Shadow
//    protected int guiLeft;
//    @Shadow
//    protected int guiTop;
//    @Shadow
//    protected int xSize;
//    @Shadow
//    protected int ySize;
//    @Shadow
//    protected Slot hoveredSlot;
//    @Shadow
//    private ItemStack draggedStack;
//
//    @Override
//    public int rei_getContainerLeft() {
//        return guiLeft;
//    }
//
//    @Override
//    public int rei_getContainerTop() {
//        return guiTop;
//    }
//
//    @Override
//    public int rei_etContainerWidth() {
//        return xSize;
//    }
//
//    @Override
//    public int rei_getContainerHeight() {
//        return ySize;
//    }
//
//    @Inject(method = "initGui()V", at = @At("RETURN"))
//    protected void initGui(CallbackInfo info) {
//        GuiHelper.setLastGuiContainer((GuiContainer) (Object) this);
//        this.children.add(GuiHelper.getLastOverlay(true));
//    }
//
//    @Inject(method = "render(IIF)V", at = @At("RETURN"))
//    public void render(int int_1, int int_2, float float_1, CallbackInfo info) {
//        if (Minecraft.getInstance().currentScreen instanceof GuiContainerCreative) {
//            IMixinTabGetter tabGetter = (IMixinTabGetter) Minecraft.getInstance().currentScreen;
//            if (tabGetter.getSelectedTab() != ItemGroup.INVENTORY.getIndex())
//                return;
//        }
//        GuiHelper.getLastOverlay().renderOverlay(int_1, int_2, float_1);
//    }
//
//    @Override
//    public ItemStack rei_getDraggedStack() {
//        return this.draggedStack;
//    }
//
//    @Inject(method = "keyPressed(III)Z", at = @At("HEAD"), cancellable = true)
//    public void keyPressed(int int_1, int int_2, int int_3, CallbackInfoReturnable<Boolean> ci) {
//        if (GuiHelper.getLastOverlay().keyPressed(int_1, int_2, int_3)) {
//            ci.cancel();
//            ci.setReturnValue(true);
//        }
//    }
//
//    @Override
//    public Slot rei_getHoveredSlot() {
//        return hoveredSlot;
//    }
//
//    @Override
//    public boolean mouseScrolled(double double_1) {
//        ContainerGuiOverlay overlay = GuiHelper.getLastOverlay();
//        if (GuiHelper.isOverlayVisible() && overlay.getRectangle().contains(ClientHelper.getMouseLocation()))
//            for(IGuiEventListener entry : this.getChildren())
//                if (entry.mouseScrolled(double_1))
//                    return true;
//        return super.mouseScrolled(double_1);
//    }
//
//}

public class MixinGuiContainer {}
